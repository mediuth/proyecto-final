package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Adonay Alvarado
 */
public class CategoriaDAO implements InterfazDAO {

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
    public ResultSet ListarCategoria() {
        try {
            conex = cn.getConexionSql();
            st = conex.prepareCall("{call SP_ListarCategoria()}");
            rs = st.executeQuery();
            return rs;
        } catch (Exception ex) {
            return rs;
        }
    }

    @Override
    public boolean AgregarCategoria(Categoria c) {
        String cadenaSql = "exec SP_InsertarCategoria '"+c.getNombreCategoria()+"','"+c.getDescripcion()+"'";
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
    }

    @Override
    public boolean EditarCategoria(Categoria c) {
         String cadenaSql = "exec SP_EditarCategoria "+c.getIdCategoria()+",'"+c.getNombreCategoria()+"','"+c.getDescripcion()+"','"+c.getEstado()+"'";//aqui me quede
        
        try {
            conex = cn.getConexionSql();
            ps=conex.prepareStatement(cadenaSql);
            ps.executeUpdate();
        } catch (SQLException ex) {
           
        }
        return false;
    }


    @Override
    public boolean EliminarCategoria(int id) {
         String cadenaSql = "exec SP_EliminarCategoria "+id;
        
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
