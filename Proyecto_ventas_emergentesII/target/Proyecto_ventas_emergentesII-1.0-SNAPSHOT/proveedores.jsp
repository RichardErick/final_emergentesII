<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h1>Proveedores</h1>   
            <jsp:include page="META-INF/menu.jsp">
                <jsp:param name="opcion" value ="productos"/>
            </jsp:include>
            <br>
            <a href="#" class="btn btn-primary btn-sm mt-2">

                <i class="fas fa-plus-circle me-1"></i> Nuevo
            </a>  
            <br>
            <table class ="table table-light">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
               
                    <th></th>
                    <th></th>


                </tr>
                <tr>
                    <td> 1</td>
                    <td> das</td>
                    <td>asd </td>
                    <td>das </td>
                  
                    <td><a href="#"><i class="fa fa-pen"></i></a> </td>
                    <td><a href="#"><i class="fas fa-eraser"></i></a> </td>

                </tr>
            </table>


        </div>

        <!-- Bootstrap y Font Awesome JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Z8v5kYHuQXGXu9+LrnSrMUE40BI3Q7ZubC/vFvlXIoqwy6aAko56E7QdjBD2Z8q2" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/js/all.min.js"></script>
    </body>
</html>
