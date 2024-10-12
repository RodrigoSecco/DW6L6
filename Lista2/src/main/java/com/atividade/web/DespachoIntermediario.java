package com.atividade.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DespachoIntermediario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        if (nome == null || nome.isEmpty()) {
            nome = "Nome não fornecido";
        } else {
            nome = nome.toUpperCase(); 
        }

        request.setAttribute("nomeProcessado", nome);

        RequestDispatcher dispatcher = request.getRequestDispatcher("exibirDados.jsp");
        dispatcher.forward(request, response);
    }
}
