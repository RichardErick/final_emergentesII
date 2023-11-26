<%
String opcion= request.getParameter("opcion");
%>
<ul class="nav nav-pills">
            <li class="nav-item ms-2 border-bottom">
                <a class="nav-link active <%=(opcion.equals("categorias"))? "active" : "" %>" href="CategoriaControlador">Categorías</a>
            </li>
            <li class="nav-item ms-2 border-bottom">
                <a class="nav-link <%=(opcion.equals("productos"))? "active" : "" %>" href="productos.jsp">Productos</a>
            </li>
            <li class="nav-item ms-2 border-bottom">
                <a class="nav-link <%=(opcion.equals("clientes"))? "active" : "" %>" href="ClienteControlador">Clientes</a>
            </li>
            <li class="nav-item ms-2 border-bottom">
                <a class="nav-link <%=(opcion.equals("proveedores"))? "active" : "" %>" href="proveedores.jsp">Proveedores</a>
            </li>
            <li class="nav-item ms-2 border-bottom">
                <a class="nav-link <%=(opcion.equals("ventas"))? "active" : "" %>" href="ventas.jsp">Ventas</a>
            </li>    
        </ul>