package org.example.isilerp.controller;


import org.example.isilerp.dao.UsuarioDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //para saber desde donde esta llegando la solicitud
        String opcion = request.getParameter("opcionPOST");

        switch (opcion) {
            case "validarUsuario" : {
                try {
                    validarUsuario(request, response);
                } catch (ServletException | IOException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String paginaDestino;
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean existe = usuarioDAO.validarUsuario(correo, password);

        paginaDestino = existe ? "/principal.jsp" : "/index.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
        dispatcher.forward(request, response);
    }

}