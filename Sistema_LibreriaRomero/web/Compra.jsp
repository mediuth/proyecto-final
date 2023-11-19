<%-- 
    Document   : Categoria
    Created on : 10-21-2021, 08:08:49 PM
    Author     : Adonay Alvarado
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Modelo.Persona"%>
<%@page import="Modelo.Categoria"%>
<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/css.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
   
        <link href="//cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@4/dark.css" rel="stylesheet">
    </head>
    <body>
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
         
                

        <div class="col-lg-6 mx-auto p-0">
            <h3 class="text-center">COMPRA</h3>
            <br>
            
                 <%
                        ResultSet rs = (ResultSet) request.getSession().getAttribute("ListarProd");
                        if (rs != null) {
                    %>
                    <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th scope="col">IdProducto</th>
                        <th scope="col">NombreProducto</th>
                        <th scope="col">PrecioCompra</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                            while (rs.next()) {
                        %>
                    <tr>
                        <th><%= rs.getInt("IdProducto")%></th>
                        <th><%= rs.getString("NombreProducto")%></th>
                        <th><%= rs.getString("PrecioCompra")%></th>
                        <th><%= rs.getString("Cantidad")%></th>
                        <td><a class="btn btn-outline-primary" href="Controlador?accion=ComprarProduct&ID=<%=rs.getInt("IdProducto")%>&Nom=<%= rs.getString("NombreProducto")%>&Precio=<%= rs.getDouble("PrecioCompra")%>&Cant=<%= rs.getInt("Cantidad")%>" role="button"><i class="bi bi-cart-plus"></i></a></td> 
                    </tr>
                    <% } %>
                </tbody>
                <% } %>
            </table>
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>  
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
               <script src="https://kit.fontawesome.com/7cae056f8b.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

        </div>
    </body>
</html>

