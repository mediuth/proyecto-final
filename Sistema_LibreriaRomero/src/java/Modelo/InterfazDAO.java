/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;

/**
 *
 * @author Balmore
 */
public interface InterfazDAO {
    public Persona ValidarUsuario(Persona p);
    public boolean AgregarUsuario(Persona p);
     public ResultSet ListarUsuarios();
     public ResultSet Rol();
     public boolean ModificarUsuario(Persona p);
      public int EliminarUsuario(int p);
      public ResultSet ListarCategoria();
    public boolean AgregarCategoria(Categoria c);
    public boolean EditarCategoria(Categoria c);
    public boolean EditarProducto(Producto producto);
    public boolean EliminarCategoria(int id);
    public boolean AgregarEmpleado(Empleado e);
    public boolean AgregarProducto(Producto producto);
    public boolean ModificarEmpleado(Empleado e);
    public boolean EliminarEmpleado(int id);
    public boolean EliminarProducto(int id);
    public ResultSet ListarEmpleados();
    public ResultSet ListarProductoVenta();
    public Producto ListarProductoId(int IdProducto);
    public boolean RealizarVenta(int IdProducto,double venta);
    public boolean InsertarMovimientoCompra(Producto pr);
    public ResultSet ListarProductoCompra();
}
