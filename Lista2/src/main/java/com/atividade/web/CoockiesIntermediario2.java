package com.atividade.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
public class CoockiesIntermediario2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        if (username != null) {
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Bem-vindo, " + username + "!</h1>");
            response.getWriter().println("<a href='logout'>Fazer logout</a>");
            response.getWriter().println("</body></html>");
        } else {
            response.sendRedirect("login");
        }
    }
}
