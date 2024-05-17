<%--
  Created by IntelliJ IDEA.
  User: fernando-u
  Date: 16/05/24
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Editar usuario</h1>
<br>
<form action="usuario" method="POST">
    <input type="hidden" value="editarUsuario" name="opcionPOST"/>
    <input type="hidden" name="id" value="${usuario.id}"/>
    Correo: <input type="text" name="correo" value="${usuario.correo}"/><br>
    Password: <input type="password" name="password" value="${usuario.password}"/><br><br>
    Estado:
    <select name="estado">
        <option value="activo" ${usuario.estado == 'activo' ? 'selected' : ''}>Activo</option>
        <option value="inactivo" ${usuario.estado == 'inactivo' ? 'selected' : ''}>Inactivo</option>
    </select>
    <button>Grabar</button>
</form>

</body>
</html>
