package com.atividade.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Redirecionamento extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Login</h2>");
        out.println("<form method='post' action='login'>");
        out.println("Usuário: <input type='text' name='username' required><br><br>");
        out.println("Senha: <input type='password' name='password' required><br><br>");
        out.println("<button type='submit'>Entrar</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            out.println("<html><body>");
            out.println("<h1>Bem-vindo, " + username + "!</h1>");
            out.println("<p>Você fez login com sucesso.</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Login Falhou!</h2>");
            out.println("<p>Usuário ou senha incorretos.</p>");
            out.println("<a href='login'>Tente novamente</a>");
            out.println("</body></html>");
        }
    }
}
