package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import Modelo.Persona;

public final class ModificarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #c8c8c8\">\n");
      out.write("        \n");
      out.write("        ");

            Persona p = new Persona();
            p = (Persona) request.getSession().getAttribute("persona");
            if (request.getSession().getAttribute("logout") != null) {
                if (request.getSession().getAttribute("logout").equals("1")) {//Si la sesión está cerrada
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        
      out.write("\n");
      out.write("        ");

            int IdProducto = Integer.parseInt((String)request.getAttribute("IdProducto"));
            String NombreProducto = (String)request.getAttribute("NombreProducto");
            int IdCategoria = Integer.parseInt((String)request.getAttribute("IdCategoria"));
            double PrecioCompra = Double.parseDouble((String)request.getAttribute("PrecioCompra"));
            double PrecioVenta = Double.parseDouble((String)request.getAttribute("PrecioVenta"));
            int Cantidad = Integer.parseInt((String)request.getAttribute("Cantidad"));
             String Estado = (String)request.getAttribute("Estado");
            ResultSet rs = (ResultSet) request.getSession().getAttribute("Categorias");
            
            if (session.getAttribute("Logueado").equals("0")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        
      out.write("\n");
      out.write("        <div class=\"container-md\">\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #185D5D;\">\n");
      out.write("  <a class=\"navbar-brand\" href=\"Controlador?accion=Principal\">Libreria Monseñor Romero</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Usuarios\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=Usuarios\">Listar usuarios</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=Nuevo\">Crear Nuevo Usuarios</a>\n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      \n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Categoria\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=ListarCategoria\">Listar Categoria</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=NuevaCate\">Crear Nueva Categoria</a>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Empleados\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=ListarEmpleados\">Listar Empleados</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=NuevoEmpleado\">Crear Nuevo Empleado</a>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("    <form class=\"form-inline my-2 my-lg-0\" action=\"Controlador\" method=\"post\">\n");
      out.write("                    <a><i class=\"fa fa-user-circle\" aria-hidden=\"true\" style=\"color: black\"></i> ");
      out.print( session.getAttribute("user"));
      out.write("</a>\n");
      out.write("                    <button class=\"btn btn-outline-primary my-2 my-sm-0 ml-2\" type=\"submit\" name=\"accion\" value=\"Salir\">Logout</button>\n");
      out.write("                </form>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-sm-8\"> \n");
      out.write("                    \n");
      out.write("                    <form action=\"Controlador\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                                <label>IdProducto</label>\n");
      out.write("                                <input type=\"text\" name=\"IdProducto\" class=\"form-control\" value=\"");
      out.print( IdProducto );
      out.write("\" readonly>\n");
      out.write("                            </div>\n");
      out.write("                        <div class=\"form-group\"> \n");
      out.write("                            <label for=\"user\" class=\"label\">Nombre Producto</label> \n");
      out.write("                            <input id=\"user\" name=\"NombreProducto\" type=\"text\" class=\"form-control\" value=\"");
      out.print( NombreProducto );
      out.write("\"> \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">  \n");
      out.write("                            <label for=\"pass\" class=\"label\">Seleecione Categoria</label> \n");
      out.write("                            \n");
      out.write("                        <select class=\"form-control\" id=\"cboCategoria\" name=\"cboCategoria\">\n");
      out.write("                            ");

                                    if (rs != null) {
                                        while (rs.next()) {
                                            if (rs.getString("IdCategoria").equals(IdCategoria) ) {
                                                
      out.write("\n");
      out.write("                                                <option selected value=\"");
      out.print( rs.getString("IdCategoria"));
      out.write("\" >");
      out.print( rs.getString("NombreCategoria"));
      out.write(" </option>\n");
      out.write("                                                ");

                                            }else{
                                
      out.write("\n");
      out.write("                                <option value=\"");
      out.print( rs.getString("IdCategoria"));
      out.write("\" >");
      out.print( rs.getString("NombreCategoria"));
      out.write(" </option>\n");
      out.write("                                \n");
      out.write("                                ");
        }
                                    }
}
                                
      out.write(" \n");
      out.write("                        </select>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\"> \n");
      out.write("                            <label for=\"pass\" class=\"label\">Precio de Compra</label> \n");
      out.write("                            <input id=\"pass\" name=\"PrecioCompra\" type=\"text\" class=\"form-control\" value=\"");
      out.print( PrecioCompra );
      out.write("\"> \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\"> \n");
      out.write("                            <label for=\"pass\" class=\"label\">Precio de Venta</label> \n");
      out.write("                            <input id=\"pass\" name=\"PrecioVenta\" type=\"text\" class=\"form-control\" value=\"");
      out.print( PrecioVenta );
      out.write("\"> \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">  \n");
      out.write("                            <label for=\"pass\" class=\"label\">Seleecione Estado</label> \n");
      out.write("                        <select class=\"form-control\" id=\"cboEstado\" name=\"cboEstado\">\n");
      out.write("                            ");

                             if (Estado.equals("1")) {
                                 
      out.write("    \n");
      out.write("                                 <option selected value=\"1\">Activo</option>\n");
      out.write("                                  <option value=\"2\">Inactivo</option>\n");
      out.write("                                 ");

                                 }else {
                                 
      out.write("    \n");
      out.write("                                  <option selected value=\"2\">Inactivo</option>\n");
      out.write("                                  <option value=\"1\">Activo</option>\n");
      out.write("                                 ");

}
                               
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        </div>                    \n");
      out.write("                               <button type=\"submit\" class=\"btn btn-primary\" value=\"GuardarProducto\" name=\"accion\">Modificar Producto</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://kit.fontawesome.com/7cae056f8b.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
