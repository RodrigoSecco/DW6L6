package com.atividade.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DespachoFacil1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valor = request.getParameter("valor");

        if (valor == null || valor.isEmpty()) {
            valor = "Parâmetro não fornecido";
        }

        request.setAttribute("valorPassado", valor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exibir");
        dispatcher.forward(request, response);
    }
}
