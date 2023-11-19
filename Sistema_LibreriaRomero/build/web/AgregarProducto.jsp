<%-- 
    Document   : Principal
    Created on : 10-20-2021, 04:52:16 PM
    Author     : Balmore
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
    </head>
    <body style="background-color: #c8c8c8">
        <%
            Persona p = new Persona();
            p = (Persona) request.getSession().getAttribute("persona");
            if (request.getSession().getAttribute("logout") != null) {
                if (request.getSession().getAttribute("logout").equals("1")) {//Si la sesión está cerrada
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        %>
        <div class="container-md">
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #185D5D;">
  <a class="navbar-brand" href="Controlador?accion=Principal">Libreria Monseñor Romero</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Usuarios
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador?accion=Usuarios">Listar usuarios</a>
          <a class="dropdown-item" href="Controlador?accion=Nuevo">Crear Nuevo Usuarios</a>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Categoria
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador?accion=ListarCategoria">Listar Categoria</a>
          <a class="dropdown-item" href="Controlador?accion=NuevaCate">Crear Nueva Categoria</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Empleados
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador?accion=ListarEmpleados">Listar Empleados</a>
          <a class="dropdown-item" href="Controlador?accion=NuevoEmpleado">Crear Nuevo Empleado</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Productos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador?accion=ListarProducto">Listar Producto</a>
          <a class="dropdown-item" href="Controlador?accion=NuevoProducto">Nuevo Producto</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Movimientos
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="Controlador?accion=RealizarCompra">Realizar Compra</a>
          <a class="dropdown-item" href="Controlador?accion=MostrarVentas">Realizar Ventas</a>
          
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="Controlador" method="post">
                    <a><i class="fa fa-user-circle" aria-hidden="true" style="color: black"></i> <%= session.getAttribute("user")%></a>
                    <button class="btn btn-outline-primary my-2 my-sm-0 ml-2" type="submit" name="accion" value="Salir">Logout</button>
                </form>
  </div>
</nav>
            <br>

            <div class="row justify-content-center">
                <div class="col-sm-8"> 
                    <%
                        ResultSet rs = (ResultSet) request.getSession().getAttribute("Categoria");

                    %>
                    <form action="Controlador">
                        <div class="form-group"> 
                            <label for="user" class="label">Nombre Producto</label> 
                            <input id="user" name="NombreProducto" type="text" class="form-control" placeholder="ingrese el Nombre del Producto"> 
                        </div>
                        <div class="form-group">  
                                <label for="pass" class="label">Seleecione La categoria</label> 
                        <select class="form-control" id="cbocategoria" name="cbocategoria">
                            
                                <%
                                    if (rs != null) {
                                        while (rs.next()) {
                                %>
                                <option> <%= rs.getString("IdCategoria") + "-" + rs.getString("NombreCategoria")%> </option>
                                <%        }
                                    }
                                %>
                        </select>
                        </div>
                        <div class="form-group"> 
                            <label for="pass" class="label">Precio de Compra</label> 
                            <input id="pass" name="PrecioCompra" type="text" class="form-control" data-type="text" placeholder="ingrese el Precio de Compra"> 
                        </div>
                        
                        
                        <div class="form-group"> 
                            <label for="pass" class="label">Precio de Venta</label> 
                            <input id="pass" name="PrecioVenta" type="text" class="form-control" placeholder="Ingrese el Precio de Venta"> 
                        </div>
                        <div class="form-group"> 
                            <label for="pass" class="label">Cantidad de producto a ingresar</label> 
                            <input id="pass" name="Cantidad" type="text" class="form-control" placeholder="Ingrese la Cantidad de producto"> 
                        </div>
                        
                        <button type="submit" class="btn btn-primary" value="AgregarProducto" name="accion">Crear Producto</button>
                    </form>











                </div>
            </div>
        </div>


    </body>
    <script src="https://kit.fontawesome.com/7cae056f8b.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</html>