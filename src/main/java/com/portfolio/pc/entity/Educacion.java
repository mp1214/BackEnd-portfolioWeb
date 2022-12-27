
package com.portfolio.pc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String tipoeducacion;
    private String institucion;
    private String icono;
    private String inicio;
    private String fin;  
    private boolean cursando; 
    
     public Educacion() {
    }

    public Educacion(String titulo, String tipoeducacion, String institucion, String icono, String inicio, String fin,boolean cursando) {
        this.titulo = titulo;
        this.tipoeducacion = tipoeducacion;
        this.institucion = institucion;
        this.icono = icono;
        this.inicio = inicio;
        this.fin = fin;
        this.cursando=cursando;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoeducacion() {
        return tipoeducacion;
    }

    public void setTipoeducacion(String tipoeducacion) {
        this.tipoeducacion = tipoeducacion;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public boolean isCursando() {
        return cursando;
    }

    public void setCursando(boolean cursando) {
        this.cursando = cursando;
    }
     
}
