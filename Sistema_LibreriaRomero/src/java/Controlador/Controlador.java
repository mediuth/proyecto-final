/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Balmore
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ResultSet rs;
    ResultSet rsInterno;
    Empleado e = new Empleado();
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
    Categoria c = new Categoria();
    CategoriaDAO Cdao = new CategoriaDAO();
    EmpleadoDAO deo = new EmpleadoDAO();
    Producto prod = new Producto();
    Producto pro = new Producto();
    ProductoDAO Pdao = new ProductoDAO();
    int r = 0;
    int id = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            HttpSession session = request.getSession();

            if (session.getAttribute("Logueado") != null) {
                if (session.getAttribute("Logueado").equals("0")) {
                    p = new Persona();
                    request.getSession().setAttribute("persona", p);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }
            }

            rs = null;
            switch (accion) {
                case "Ingresar":
                    if (request.getParameter("UserName").isEmpty() || request.getParameter("Pass").isEmpty()) {
                        p = new Persona();
                        request.getSession().setAttribute("persona", p);
                        session.setAttribute("Logueado", null);//Indica sesión cerrada
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        return;
                    }
                    p.setUserName(request.getParameter("UserName"));
                    p.setPass(request.getParameter("Pass"));
                    p = dao.ValidarUsuario(p);//Ejecuta el proceso en la base de datos
                    request.getSession().setAttribute("persona", p);
                    if (p.getIdUsuario() > 0) {
                        session.setAttribute("Logueado", "1");
                        session.setAttribute("user", p.getNombreCompleto());
                        request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    } else {
                        p = new Persona();
                        request.getSession().setAttribute("persona", p);
                        session.setAttribute("Logueado", "0");//0=Cierre de sesión
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
                case "Registrarse":

                    p = new Persona();
                    p.setNombreCompleto(request.getParameter("NombreCompleto"));
                    p.setUserName(request.getParameter("UserName"));
                    p.setPass(request.getParameter("Pass"));
                    p.setEmail(request.getParameter("Email"));
                    p.setIdRol(2);

                    dao.AgregarUsuario(p);
                    session.setAttribute("user", p.getNombreCompleto());
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);

                    break;
                case "Salir":
                    p = new Persona();
                    session.setAttribute("Logueado", null);
                    session.setAttribute("user", "");
                    request.getSession().setAttribute("persona", p);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "Principal":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "Usuarios":
                    rs = dao.ListarUsuarios();
                    request.getSession().setAttribute("ListaUsuarios", rs);
                    request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
                    break;
                case "Nuevo"://Carga la página donde se puede crear nuevos usuarios

                    rs = dao.Rol();
                    request.getSession().setAttribute("Roles", rs);
                    request.getRequestDispatcher("AgregarUsuario.jsp").forward(request, response);

                    break;
                case "Agregar":
                    p = new Persona();
                    p.setNombreCompleto(request.getParameter("NombreCompleto"));
                    p.setUserName(request.getParameter("UserName"));
                    p.setPass(request.getParameter("Pass"));
                    String cboRol = request.getParameter("cboRol");
                    p.setIdRol(Integer.parseInt(cboRol.split("-")[0]));
                    p.setEmail(request.getParameter("Email"));
                    dao.AgregarUsuario(p);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);

                    break;
                case "Editar":
                request.setAttribute("IdUsuario", request.getParameter("IdUsuario"));
                request.setAttribute("NombreCompleto", request.getParameter("NombreCompleto"));
                request.setAttribute("UserName", request.getParameter("UserName"));  
                request.setAttribute("Pass", request.getParameter("Pass")); 
                request.setAttribute("IdRol", request.getParameter("IdRol"));
                request.setAttribute("Email", request.getParameter("Email"));
                
                request.setAttribute("Estado", request.getParameter("Estado"));
                
                rs = dao.Rol();
                
                request.getSession().setAttribute("Roles", rs);
                request.getRequestDispatcher("ModificarUsuario.jsp").forward(request, response);
                break;
                case "GuardarCambio":
                    p = new Persona();
                    int IdUsuario=Integer.parseInt(request.getParameter("IdUsuario"));
                    p.setIdUsuario(IdUsuario);
                    p.setNombreCompleto(request.getParameter("NombreCompleto"));
                    p.setUserName(request.getParameter("UserName"));
                    p.setPass(request.getParameter("Pass"));
                    int idRol = Integer.parseInt(request.getParameter("cboRol"));
                    p.setIdRol(idRol);
                    p.setEmail(request.getParameter("Email"));
                    int Estado = Integer.parseInt(request.getParameter("cboEstado"));
                    p.setEstado(Estado);
                    dao.ModificarUsuario(p);
                    
                        request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    
                    
                    break;
                    case "Eliminar":
                
                int id=Integer.parseInt(request.getParameter("IdUsuario"));
                r = dao.EliminarUsuario(id);
                
                
                request.getRequestDispatcher("Controlador?accion=Usuarios").forward(request, response);
                break;
                case "NuevaCate":
                    request.getRequestDispatcher("InsertarCategoria.jsp").forward(request, response);
                    break;
                
                case "ListarCategoria":
                    rs = Cdao.ListarCategoria();
                    request.getSession().setAttribute("ListaCate", rs);
                    request.getRequestDispatcher("Categoria.jsp").forward(request, response);
                    break;

                case "InsertarCate":
                    c = new Categoria();
                    c.setNombreCategoria(request.getParameter("txtCate"));
                    c.setDescripcion(request.getParameter("txtDescrip"));

                    Cdao.AgregarCategoria(c);
                    request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);

                    break;
                case "EditarCate":
                    request.setAttribute("IdCategoria", request.getParameter("ID"));
                    request.setAttribute("NombreCategoria", request.getParameter("Nom"));
                    request.setAttribute("Descripcion", request.getParameter("Des"));
                    request.setAttribute("Estado", request.getParameter("Est"));

                    request.getRequestDispatcher("EditarCategoria.jsp").forward(request, response);

                    break;
                case "GuardarCate":
                    c = new Categoria();
                    id = Integer.parseInt(request.getParameter("txtCodCate"));
                    c.setIdCategoria(id);
                    c.setNombreCategoria(request.getParameter("txtCate"));
                    c.setDescripcion(request.getParameter("txtDescrip"));

                    if (request.getParameter("cbxEstado").equals("1")) {
                        c.setEstado(1);

                    } else {
                        c.setEstado(0);
                    }
                    Cdao.EditarCategoria(c);
                    request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);

                    break;
                case "EliminarCate":
                    id = Integer.parseInt(request.getParameter("ID"));
                    Cdao.EliminarCategoria(id);
                    request.getRequestDispatcher("Controlador?accion=ListarCategoria").forward(request, response);
                    break;
                case "ListarEmpleados":
                if (session.getAttribute("Logueado") == null) {
                    request.getRequestDispatcher("Controlador?accion=Salir").forward(request, response);
                } else {
                    rs = deo.ListarEmpleados();
                    request.getSession().setAttribute("ListarEmpleados", rs);
                    request.getRequestDispatcher("Empleados.jsp").forward(request, response);
                }
                break;
                case "NuevoEmpleado":                
                    request.getRequestDispatcher("AgregarEmpleados.jsp").forward(request, response);
                break; 
                
                
                case "Editar_Emp":
                request.setAttribute("IdEmpleado", request.getParameter("IdEmpleado"));
                request.setAttribute("Nombre", request.getParameter("Nombre"));
                request.setAttribute("Email", request.getParameter("Email"));  
                request.setAttribute("Telefono", request.getParameter("Telefono")); 
                request.setAttribute("FechaNac", request.getParameter("FechaNac"));
                request.setAttribute("Direccion", request.getParameter("Direccion"));
                request.setAttribute("Dui", request.getParameter("Dui"));
                request.setAttribute("Nit", request.getParameter("Nit"));
                request.setAttribute("Area", request.getParameter("Area"));

                
                request.getRequestDispatcher("ModificarEmpleado.jsp").forward(request, response);
                break;
                
                case "Guardar Empleado":
                      
                id = Integer.parseInt(request.getParameter("txtIdEmpleado")); 
                e.setIdEmpleado(id);
                
                       
                e.setNombre(request.getParameter("txtNombre"));
                e.setEmail(request.getParameter("txtEmail"));
                e.setTelefono(request.getParameter("txtTelefono"));
                e.setFechaNac(request.getParameter("txtFechaNac"));
                e.setDireccion(request.getParameter("txtDireccion"));
                e.setDui(request.getParameter("txtDui"));
                e.setNit(request.getParameter("txtNit"));
                e.setArea(request.getParameter("txtArea"));
                
                deo.ModificarEmpleado(e);
                request.getRequestDispatcher("Controlador?accion=ListarEmpleados").forward(request, response);
                
                break;
                case "Registrar Empleado":
                    e = new Empleado();
                e.setNombre(request.getParameter("txtNombre"));
                e.setEmail(request.getParameter("txtEmail"));
                e.setTelefono(request.getParameter("txtTelefono"));
                e.setFechaNac(request.getParameter("txtFechaNac"));
                e.setDireccion(request.getParameter("txtDireccion"));
                e.setDui(request.getParameter("txtDui"));
                e.setNit(request.getParameter("txtNit"));
                e.setArea(request.getParameter("txtArea"));
                
                deo.AgregarEmpleado(e);
                request.getRequestDispatcher("Controlador?accion=ListarEmpleados").forward(request, response);
                
                break;
                case "Eliminar_Emp":
                
                id=Integer.parseInt(request.getParameter("IdEmpleado"));
                deo.EliminarEmpleado(id);
                request.getRequestDispatcher("Controlador?accion=ListarEmpleados").forward(request, response);
                break;
                case "MostrarVentas":
                    rs = dao.ListarProductoVenta();
                    request.getSession().setAttribute("ListarProductoVenta", rs);
                    request.getRequestDispatcher("Ventas.jsp").forward(request, response);
                    break;
                case "SeleccionarProducto":
                    request.getSession().setAttribute("IdProducto", request.getParameter("IdProducto"));
                    request.getSession().setAttribute("NombreProducto", request.getParameter("NombreProducto"));
                    request.getSession().setAttribute("NombreCategoria", request.getParameter("NombreCategoria"));
                    request.getSession().setAttribute("PrecioVenta", request.getParameter("PrecioVenta"));
                    request.getSession().setAttribute("Cantidad", request.getParameter("Cantidad"));
                    
                    request.getRequestDispatcher("ProcesarVenta.jsp").forward(request, response);
                    break;
                case "RealizarVenta":
                    int IdProducto = Integer.parseInt(request.getParameter("IdProducto"));
                    double venta = Double.parseDouble(request.getParameter("venta"));
                    dao.RealizarVenta(IdProducto, venta);
                    request.getRequestDispatcher("Controlador?accion=MostrarVentas").forward(request, response);
                    break;
                    case "RealizarCompra":
                    if (session.getAttribute("Logueado") == null) {
                        request.getRequestDispatcher("Controlador?accion=Salir").forward(request, response);
                    } else {
                        rs = Pdao.ListarProductoCompra();
                        request.getSession().setAttribute("ListarProd", rs);
                        request.getRequestDispatcher("Compra.jsp").forward(request, response);
                    }
//                    rs = Pdao.ListarProductos();
//                    request.getSession().setAttribute("ListaProd", rs);
//                    request.getRequestDispatcher("Compra.jsp").forward(request, response);
                    break;
                case "ComprarProduct":
                    request.setAttribute("IdProducto", request.getParameter("ID"));
                    request.setAttribute("NombreProducto", request.getParameter("Nom"));
                    request.setAttribute("PrecioCompra", request.getParameter("Precio"));
                    request.setAttribute("Cantidad", request.getParameter("Cant"));

                    request.getRequestDispatcher("CompraProducto.jsp").forward(request, response);

                    break;
                 case "AdquirirProducto":
                    id = Integer.parseInt(request.getParameter("txtCodProd"));
                    pro.setIdProducto(id);           
                    pro.setCantCompra(Integer.parseInt(request.getParameter("txtCantCompra")));
  

                    Pdao.InsertarMovimientoCompra(pro);
                    request.getRequestDispatcher("Controlador?accion=RealizarCompra").forward(request, response);

                    break;
                 case "ListarProducto":
                    rs = Pdao.ListarProductoCompra();
                    request.getSession().setAttribute("ListarProducto", rs);
                    request.getRequestDispatcher("Productos.jsp").forward(request, response);
                     break;
                 case "EditarProducto":
                request.setAttribute("IdProducto", request.getParameter("IdProducto"));
                request.setAttribute("NombreProducto", request.getParameter("NombreProducto"));
                request.setAttribute("IdCategoria", request.getParameter("IdCategoria"));  
                request.setAttribute("PrecioCompra", request.getParameter("PrecioCompra")); 
                request.setAttribute("PrecioVenta", request.getParameter("PrecioVenta"));
                request.setAttribute("Cantidad", request.getParameter("Cantidad"));
                request.setAttribute("Estado", request.getParameter("Estado"));
                
                rs = Cdao.ListarCategoria();
                
                request.getSession().setAttribute("Categorias", rs);
                request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
                    break;
                    
                    case "GuardarProducto":
                        //IdProducto=1&NombreProducto=antiguo+testamento&cboCategoria=1&PrecioCompra=2.25&PrecioVenta=3.0&cboEstado=1&accion=GuardarProducto
                    prod = new Producto();
                    int IdProductoEdit=Integer.parseInt(request.getParameter("IdProducto"));
                    prod.setIdProducto(IdProductoEdit);
                    prod.setNombreProducto(request.getParameter("NombreProducto"));
                    int IdCategoriaEdit = Integer.parseInt(request.getParameter("cboCategoria"));
                    prod.setIdCategoria(IdCategoriaEdit);
                    
                    prod.setPrecioCompra(Double.parseDouble(request.getParameter("PrecioCompra")));
                    prod.setPrecioVenta(Double.parseDouble(request.getParameter("PrecioVenta")));

                    int EstadoEdit = Integer.parseInt(request.getParameter("cboEstado"));
                    prod.setEstado(EstadoEdit);
                    
                    Pdao.EditarProducto(prod);
                    
                    request.getRequestDispatcher("Controlador?accion=ListarProducto").forward(request, response);
                    
                    
                    break;
                    case "EliminarProducto":
                    id=Integer.parseInt(request.getParameter("IdProducto"));
                    Pdao.EliminarProducto(id);
                    request.getRequestDispatcher("Controlador?accion=ListarProducto").forward(request, response);
                    break;
                    
                    case "NuevoProducto":
                        rs = Cdao.ListarCategoria();
                    request.getSession().setAttribute("Categoria", rs);
                    request.getRequestDispatcher("AgregarProducto.jsp").forward(request, response);
                        break;
                    case "AgregarProducto":
                    prod = new Producto();
                    prod.setNombreProducto(request.getParameter("NombreProducto"));
                    String cbocategoria = request.getParameter("cbocategoria");
                    prod.setIdCategoria(Integer.parseInt(cbocategoria.split("-")[0]));
                    prod.setPrecioCompra(Double.parseDouble(request.getParameter("PrecioCompra")));
                    prod.setPrecioVenta(Double.parseDouble(request.getParameter("PrecioVenta")));
                    prod.setCantidad(Integer.parseInt(request.getParameter("Cantidad")));
                    Pdao.AgregarProducto(prod);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                        break;
                             
            }
            

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
