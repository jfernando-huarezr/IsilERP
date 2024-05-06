package org.example.isilerp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.Request;
import java.io.IOException;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcionGet");

        switch (opcion) {
            case "mostrarGestionUsuarios" : {
                mostrarGestionUsuarios(request, response);
                break;
            }
        }

    }

    private void mostrarGestionUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paginaDestino = "/gestionUsuarios.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(paginaDestino);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}