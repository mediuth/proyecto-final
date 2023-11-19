package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Persona;

public final class Principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/estilosSlider.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("       <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\"><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background-color: #c8c8c8\">\n");
      out.write("        ");

            Persona p = new Persona();
            p = (Persona) request.getSession().getAttribute("persona");
            if (request.getSession().getAttribute("logout") != null) {
                if (request.getSession().getAttribute("logout").equals("1")) {//Si la sesión está cerrada
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
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
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Productos\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=ListarProducto\">Listar Producto</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=NuevoProducto\">Nuevo Producto</a>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Movimientos\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=RealizarCompra\">Realizar Compra</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"Controlador?accion=MostrarVentas\">Realizar Ventas</a>\n");
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
      out.write("                    <br>\n");
      out.write("     <div class=\"slider\">\n");
      out.write("    <ul>\n");
      out.write("        <li>\n");
      out.write("            <img src=\"images/img1.jpg\" style=\"border-radius: 3%; width: 1250px; height: 760px;\">\n");
      out.write("            \n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <img src=\"images/img2.jpg\" style=\"border-radius: 3%; width: 1250px; height: 760px;\">\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <img src=\"images/img3.jpg\" style=\"border-radius: 3%; width: 1250px; height: 760px;\"> \n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <img src=\"images/img4.jpg\" style=\"border-radius: 3%; width: 1250px; height: 760px;\">\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("       \n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://kit.fontawesome.com/7cae056f8b.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.js\" integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
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
