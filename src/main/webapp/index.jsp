<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1>Sistema ISIL ERP</h1>
  <br>
  <br>
  <form action="login" method="POST">
    <input type="hidden" name="opcionPOST" value="validarUsuario"/>
    Correo: <input type="text" name="correo"/><br><br>
    Password: <input type="password" name="password"/> <br><br>

    <button>Ingresar</button>
  </form>
</body>
</html>