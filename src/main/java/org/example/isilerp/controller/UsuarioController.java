package org.example.isilerp.controller;

import org.example.isilerp.dao.UsuarioDAO;
import org.example.isilerp.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UsuarioController", value = "/usuario")
public class UsuarioController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //para saber desde donde esta llegando la solicitud
        String opcion = request.getParameter("opcionGET");

        switch (opcion) {
            case "buscarUsuario": {
                try {
                    buscarUsuario(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String correo = request.getParameter("correo");
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = objUsuarioDAO.buscarUsuariosxCorreo(correo);

        //dejar la informacion en memoria
        request.setAttribute("listaUsuarios", listaUsuarios);

        //definir pagina donde debemos ir
        String paginaDestino = "/gestionUsuarios.jsp";
        //redirigir sistema a pagina en particular
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcionPOST");
        switch (opcion) {
            case "mostrarNuevoUsuario": {
                mostrarNuevoUsuario(request, response);
                break;
            }

            case "grabarUsuario": {
                try {
                    grabarUsuario(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    private void grabarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String estado = request.getParameter("estado");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.grabarUsusario(correo, password, estado);

        String paginaDestino = "/gestionUsuarios.jsp";
        //redirigir sistema a pagina en particular
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
    }

    private void mostrarNuevoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //definir pagina donde debemos ir
        String paginaDestino = "/nuevoUsuario.jsp";
        //redirigir sistema a pagina en particular
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
    }
}