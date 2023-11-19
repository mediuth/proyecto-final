/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProductoDAO implements InterfazDAO {
    Connection conex;
    ConexionSql cn = new ConexionSql();
    CallableStatement st;
    ResultSet rs;
    PreparedStatement ps;
    int r = 0;

    @Override
    public Persona ValidarUsuario(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarUsuario(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet Rol() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ModificarUsuario(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarUsuario(int p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarCategoria(Categoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EditarCategoria(Categoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarCategoria(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarEmpleado(Empleado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ModificarEmpleado(Empleado e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarEmpleado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListarEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*COMPRAAAAAAAAAAAAAAA*/


    @Override
    public ResultSet ListarProductoCompra() {
                try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarProducto()}");
            rs = st.executeQuery();
            return rs;
        }
        catch (Exception ex){
            return rs;
        }
    }

    @Override
    public boolean InsertarMovimientoCompra(Producto pr) {
        String cadenaSql = "SP_InsertarMovimientos '"+pr.getIdProducto()+"','Compra','"+pr.getCantCompra()+"'";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
    }

    @Override
    public ResultSet ListarProductoVenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto ListarProductoId(int IdProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RealizarVenta(int IdProducto, double venta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EditarProducto(Producto producto) {
        String cadenaSql = "exec SP_ModificarProducto "+producto.getIdProducto()+",'"+producto.getNombreProducto()+"',"+producto.getIdCategoria()+","+producto.getPrecioCompra()+" ,"+producto.getPrecioVenta()+","+producto.getEstado()+"";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
    }

    @Override
    public boolean EliminarProducto(int id) {
       String cadenaSql = "exec SP_EliminarProducto "+id;
        
        try{
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        }catch(SQLException ex){
            
        }
        return false;
    }

    @Override
    public boolean AgregarProducto(Producto producto) {
       String cadenaSql = "exec SP_InsertarProducto '"+producto.getNombreProducto()+"',"+producto.getIdCategoria()+","+producto.getPrecioCompra()+","+producto.getPrecioVenta()+","+producto.getCantidad()+"";
       try {
            conex = cn.getConexionSql();   
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        }
        catch (SQLException ex){
            
        }
       return false;
    }
    
}
