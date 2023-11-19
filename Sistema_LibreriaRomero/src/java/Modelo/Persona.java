/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Balmore
 */
public class Persona {
    private int IdUsuario;
    private String NombreCompleto;
    private String UserName;
    private String Pass;
    private int IdRol;
    private String Email;
    private String Fecha;
    private int Estado;

    public Persona() {
        
    }

    
    
    public Persona(int IdUsuario, String NombreCompleto, String UserName, String Pass, int IdRol, String Email, String Fecha, int Estado) {
        this.IdUsuario = IdUsuario;
        this.NombreCompleto = NombreCompleto;
        this.UserName = UserName;
        this.Pass = Pass;
        this.IdRol = IdRol;
        this.Email = Email;
        this.Fecha = Fecha;
        this.Estado = Estado;
    }
    

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
}
