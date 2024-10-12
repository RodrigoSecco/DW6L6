package com.atividade.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CoockiesFacil1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Login</h2>");
        response.getWriter().println("<form method='post' action='login'>");
        response.getWriter().println("Usuário: <input type='text' name='username' required><br><br>");
        response.getWriter().println("Senha: <input type='password' name='password' required><br><br>");
        response.getWriter().println("<button type='submit'>Entrar</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); 
            response.addCookie(userCookie); 

            response.sendRedirect("welcome");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>Login falhou! Usuário ou senha incorretos.</h2>");
            response.getWriter().println("<a href='login'>Tente novamente</a>");
            response.getWriter().println("</body></html>");
        }
    }
}
