<%--
  Created by IntelliJ IDEA.
  User: fernando-u
  Date: 8/05/24
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Nuevo usuario</title>
</head>
<body>
  <h1>Nuevo usuario</h1>
  <br>
  <form action="usuario" method="POST">
    <input type="hidden" value="grabarUsuario" name="opcionPOST"/>
    Correo: <input type="text" name="correo"/><br>
    Password: <input type="password" name="password"/><br><br>
    Estado: <select name="estado">
              <option value="activo">Activo</option>
              <option value="inactivo">Inactivo</option>
            </select>
    <button>Grabar</button>
  </form>

</body>
</html>
