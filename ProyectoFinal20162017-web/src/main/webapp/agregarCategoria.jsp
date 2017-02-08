<%-- 
    Document   : agregarCategoria
    Created on : 08-feb-2017, 10:45:13
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar Categoria</h1>
        
        <form action="AltaCategoria" method="POST">
            <input type="hidden" name="accion" value="agregar"/>
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;"/>
            
            <input type="submit" value="enviar"/>
        </form>
        
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
