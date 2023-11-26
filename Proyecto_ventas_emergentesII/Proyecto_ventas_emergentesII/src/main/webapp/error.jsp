<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <div style="text-align: center; margin-top: 50px;">
        <h2>¡Ups, algo salió mal!</h2>
        <c:if test="${not empty requestScope.error_message}">
            <p>Error: ${requestScope.error_message}</p>
        </c:if>
        <p>Se produjo un error en la aplicación. Por favor, inténtalo de nuevo más tarde.</p>
        <p><a href="index.jsp">Volver a la página principal</a></p>
    </div>
</body>
</html>
