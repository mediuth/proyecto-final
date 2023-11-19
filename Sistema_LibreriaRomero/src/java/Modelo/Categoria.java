/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adonay Alvarado
 */
public class Categoria {
    int IdCategoria;
    String NombreCategoria;
    String Descripcion;
    int Estado;
    
    public Categoria(){
        
    }
    public Categoria(int IdCategoria, String NombreCategoria, String Descripcion, int Estado){
        this.IdCategoria=IdCategoria;
        this.NombreCategoria=NombreCategoria;
        this.Descripcion=Descripcion;
        this.Estado=Estado;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
}
