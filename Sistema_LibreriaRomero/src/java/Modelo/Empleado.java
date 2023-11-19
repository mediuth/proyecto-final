/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Empleado {
    private int IdEmpleado;
    private String Nombre;
    private String Email;
    private String Telefono;
    private String FechaNac;
    private String Direccion;
    private String Dui;
    private String Nit;
    private String Area;
    private int Estado;
    
    public Empleado(){
    
    }

    public Empleado(int IdEmpleado, String Nombre, String Email, String Telefono, String FechaNac, String Direccion, String Dui, String Nit, String Area, int Estado) {
        this.IdEmpleado = IdEmpleado;
        this.Nombre = Nombre;
        this.Email = Email;
        this.Telefono = Telefono;
        this.FechaNac = FechaNac;
        this.Direccion = Direccion;
        this.Dui = Dui;
        this.Nit = Nit;
        this.Area = Area;
        this.Estado = Estado;
    }
    
        
    
    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDui() {
        return Dui;
    }

    public void setDui(String Dui) {
        this.Dui = Dui;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
