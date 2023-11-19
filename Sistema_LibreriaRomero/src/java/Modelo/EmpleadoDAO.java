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

/**
 *
 * @author Usuario
 */
public class EmpleadoDAO implements InterfazDAO {
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
    public boolean AgregarEmpleado(Empleado e) {
        String cadenaSql = "exec SP_InsertarEmpleado '"+e.getNombre()+"','"+e.getEmail()+"','"+e.getTelefono()+"','"+e.getFechaNac()+"','"+e.getDireccion()+"','"+e.getDui()+"','"+e.getNit()+"','"+e.getArea()+"'";
       try {
            conex = cn.getConexionSql();   
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        }
        catch (SQLException ex){
            
        }
       return false;
    }
    

    @Override
    public ResultSet ListarEmpleados() {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarEmpleado()}");
            rs = st.executeQuery();
            return rs;
        }
        catch (Exception ex){
            return rs;
        }
    }

    

    @Override
    public boolean ModificarEmpleado(Empleado e) {
        String cadenaSql = "exec SP_ModificarEmpleados " +e.getIdEmpleado()+",'"+e.getNombre()+"','"+e.getEmail()+"','"+e.getTelefono()+"','"+e.getFechaNac()+"','"+e.getDireccion()+"','"+e.getDui()+"','"+e.getNit()+"','"+e.getArea()+"'";
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        }
        catch (SQLException ex){
            
        }     
        return false;
    }
    
    @Override
    public boolean EliminarEmpleado(int id) {
         String cadenaSql = "exec SP_EliminarEmpleados "+id;
        
        try{
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        }catch(SQLException ex){
            
        }
        return false;
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
    public boolean InsertarMovimientoCompra(Producto pr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ListarProductoCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EditarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean AgregarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
