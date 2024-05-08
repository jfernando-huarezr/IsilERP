package org.example.isilerp.dao;


import org.example.isilerp.model.Usuario;

//importar dependencias para la conexion SQL
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //para conectarnos a base de datos requerimos 2 cosas importantes
    //1. La ruta/ubicacion donde se encuentra nuestra base de datos.
    //2. La conexion a nuestra base de datos.

    private String url;
    private Connection conexion;

    //metodo constructor donde se establece la conexion
    public UsuarioDAO() throws SQLException {
        /*definir todo lo necesario para conectarse a la base de datos*/
        //1. la ruta donde va a estar mi base de datos -> jdbc:sqlserver://ubicacionBD:puertoBD;nombreBD;usuarioBD;passwordBD
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=IsilERP;user=sa;password=Crisantemos-421";

        try {
            //cargar el driver del sqlServer
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //aqui establezco la conexion, ya tengo una conexion abierta, usando el driver manager
            this.conexion = DriverManager.getConnection(url);

        } catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new SQLException("Driver not found", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error establishing connection", e);
        }
    }

    //metodo para validar el usuario segun el correo y el password
    public boolean validarUsuario(String correo, String password) throws SQLException {
        String sentenciaSQL = String.format("SELECT * FROM Usuario WHERE correo = '%s' AND password = '%s' AND estado ='Activo'", correo, password);

        //sentencia stmt de la conexion. Objeto mediante se puede ejecutar querys
        Statement stmt = this.conexion.createStatement();
        //ejecutar el query SELECT. Guardar en una clase ResultSet
        ResultSet rs = stmt.executeQuery(sentenciaSQL);

        boolean existe = false;
        //este rs trae la data como tabla. leer la tabla si encuentra algo es true si no es false
        while (rs.next()) {
            existe = true;
        }

        //cerrar la conexion
        this.conexion.close();
        return existe;

    }

    //metodo para obtener un usuario segun su correo. Necesito el MODELO de usuario
    //usando preparedStatement para ejemplificar como se usa
    //personalmente prefiero String.format - Huarez Reyes
    public List<Usuario> buscarUsuariosxCorreo(String correo) throws SQLException {

        //Lista donde se devolveran los usuarios encontrados
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        String sentenciaSQL = "SELECT * FROM Usuario WHERE correo = ?";
        PreparedStatement stmt = this.conexion.prepareStatement(sentenciaSQL);
        stmt.setString(1, correo);
        ResultSet rs = stmt.executeQuery();

        //lee una fila de lo que traido
        while (rs.next()) {
            Usuario objUsuario = new Usuario();
            objUsuario.setId(rs.getInt(1));
            objUsuario.setCorreo(rs.getString(2));
            objUsuario.setPassword(rs.getString(3));
            objUsuario.setEstado(rs.getString(4));

            listaUsuarios.add(objUsuario);
        }

        this.conexion.close();
        return listaUsuarios;
    }

}
