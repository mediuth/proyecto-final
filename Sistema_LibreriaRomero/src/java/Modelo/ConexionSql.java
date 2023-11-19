/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Balmore
 */
public class ConexionSql {
    Connection cn;
    String url = "jdbc:sqlserver://DESKTOP-ROLEGON\\\\SQLEXPRESS:1037;databaseName=LibreriaP4";
    
    String user = "balmoreProg";
    String password = "123";
    
    public Connection getConexionSql(){//Sql-Server
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException ex){
            return null;
        }
        return cn;
    }
}
