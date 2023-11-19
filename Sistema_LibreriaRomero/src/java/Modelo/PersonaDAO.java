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

/**
 *
 * @author Balmore
 */
public class PersonaDAO implements InterfazDAO{
    Connection conex;
    ConexionSql cn = new ConexionSql();
    CallableStatement st;
    ResultSet rs;
    PreparedStatement ps;
    Producto Prod = new Producto();
    int r = 0;
    
    @Override
    public Persona ValidarUsuario(Persona p) {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ValidarUsuario(?,?,?)}");
            st.setString(1, p.getUserName());
            st.setString(2, p.getPass());
            st.setString(3, "@Libreria123");
            rs = st.executeQuery();
            if (rs.next()){//Si hay datos en el RS
                r = rs.getInt("IdUsuario");
                if (r > 0){
                    p.setIdUsuario(rs.getInt("IdUsuario"));
                    p.setNombreCompleto(rs.getString("NombreCompleto"));
                    p.setUserName(rs.getString("UserName"));
                    p.setPass(rs.getString("Pass"));
                    p.setIdRol(rs.getInt("IdRol"));
                    p.setEmail(rs.getString("Email"));
                    p.setFecha(rs.getString("Fecha"));
                   p.setEstado(rs.getInt("Estado"));
                    
                }
                else
                    p.setIdUsuario(-1);
            }
            return p;
        }
        catch (Exception ex){
            p.setNombreCompleto(ex.getMessage());
            return p;
        }
    }
    
    @Override
    public boolean AgregarUsuario(Persona p) {
        
        String cadenaSql = "exec SP_InsertarUsuario '"+p.getNombreCompleto()+"','"+p.getUserName()+"','"+p.getPass()+"',"+p.getIdRol()+",'"+p.getEmail()+"','@Libreria123'";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
        
        
    }
    @Override
    public boolean ModificarUsuario(Persona p) {
        
        String cadenaSql = "exec SP_ModificarUsuarios "+p.getIdUsuario()+",'"+p.getNombreCompleto()+"','"+p.getUserName()+"','"+p.getPass()+"',"+p.getIdRol()+",'"+p.getEmail()+"',"+p.getEstado()+",'@Libreria123'";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
        
        
    }
    
    @Override
    public ResultSet ListarUsuarios() {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarUsuario()}");
            rs = st.executeQuery();
            return rs;
        }
        catch (Exception ex){
            return rs;
        }
    }
    
    @Override
    public ResultSet Rol() {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarRol()}");
            rs = st.executeQuery();
            return rs;
        }
        catch (Exception ex){
            return rs;
        }        
    }
    @Override
    public int EliminarUsuario(int p) {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_EliminarUsuarios(?,?)}");
            st.setInt(1, p);
            st.registerOutParameter(2, Types.INTEGER);
            st.execute();
            r = st.getInt(2);//Respuesta de eliminarion (1=Exitoso)
            return r;
        }
        catch (Exception ex){
            return -1;
        }
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

    @Override
    public ResultSet ListarProductoVenta() {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarProductoVenta()}");
            rs = st.executeQuery();
            return rs;
        }
        catch (Exception ex){
            return rs;
        }
    }

    @Override
   public Producto ListarProductoId(int IdProducto){
        try {
            
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarProductoId "+IdProducto+"}");
            
            rs = st.executeQuery();
            if (rs.next()){//Si hay datos en el RS
                r = rs.getInt("IdProducto");
                if (r > 0){
                    Prod.setIdProducto(rs.getInt("IdProducto"));
                    Prod.setNombreProducto(rs.getString("NombreProducto"));
                    Prod.setNombreCategoria(rs.getString("NombreCategoria"));
                    Prod.setPrecioVenta(rs.getDouble("PrecioVenta"));
                    Prod.setCantidad(rs.getInt("Cantidad"));
                }
                else
                    Prod.setIdCategoria(-1);
            }
            return Prod;
        }
        catch (Exception ex){
            Prod.setNombreProducto(ex.getMessage());
            return Prod;
        }
    }

    @Override
    public boolean RealizarVenta(int IdProducto, double venta) {
        String cadenaSql = "exec SP_InsertarMovimientos "+IdProducto+",'Venta',"+venta+" ";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
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
