<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Proyecto final emergentes II Sistema de venta</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

        <!-- Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Formulario de Categoria</h1>   
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value ="categorias"/>
            </jsp:include>
            <br>
            <form action="CategoriaControlador" method="post">
                <input type="hidden" name="id" value="${categoria.id}">

                <div class="form-group">
                    <label for="nombre_categoria" class="form-label">Nombre categoria</label>
                    <input type="text" class="form-control" name="nombre_categoria" value="${categoria.nombre_categoria}" placeholder="Escribe la categoria ">
                </div>
                <div class="form-group">
                    <label for="descripcion" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" name="descripcion" value="${categoria.descripcion}" placeholder="Escribe la descripcion">
                </div>


                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>



        </div>

        <!-- Bootstrap y Font Awesome JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Z8v5kYHuQXGXu9+LrnSrMUE40BI3Q7ZubC/vFvlXIoqwy6aAko56E7QdjBD2Z8q2" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/js/all.min.js"></script>
    </body>
</html>
