package org.example.isilerp.dao;

//importar dependencias para la conexion SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
