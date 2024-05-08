<%--
  Created by IntelliJ IDEA.
  User: fernando-u
  Date: 28/04/24
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Gestion Usuarios</title>
</head>
<body>
  <h1>Gestion de Usuarios</h1>
  <br>
  <br>
  <form action="usuario" method="GET">
    <input type="hidden" name="opcionGet" value="buscarUsuario"/>
    Correo: <input type="text" name="correo"/><button>Buscar</button>
  </form>

  <br>
  <br>
  <table>
    <tr>
      <th>Id</th>
      <th>Correo</th>
      <th>Estado</th>
      <th>Acciones</th>
    </tr>
    <c:forEach var="usuario" items="${listaUsuarios}">
      <tr>
        <td>${usuario.id}</td>
        <td>${usuario.correo}</td>
        <td>${usuario.password}</td>
        <td>${usuario.estado}</td>
      </tr>
    </c:forEach>
  </table>
  <br>
  <br>
  <button>Nuevo</button>
</body>
</html>
