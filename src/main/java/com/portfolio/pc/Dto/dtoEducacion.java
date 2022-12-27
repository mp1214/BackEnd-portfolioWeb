
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String titulo;
   // @NotBlank
    private String tipoeducacion;
   // @NotBlank
    private String institucion;
    private String icono;
    private String inicio;
    private String fin;
    private boolean cursando;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String tipoeducacion, String institucion, String icono, String inicio, String fin,boolean cursando) {
        this.titulo = titulo;
        this.tipoeducacion = tipoeducacion;
        this.institucion = institucion;
        this.icono = icono;
        this.inicio = inicio;
        this.fin = fin;
        this.cursando=cursando;
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

    public String getinicio() {
        return inicio;
    }

    public void setinicio(String inicio) {
        this.inicio = inicio;
    }

    public String getfin() {
        return fin;
    }

    public void setfin(String fin) {
        this.fin = fin;
    }

    public boolean isCursando() {
        return cursando;
    }

    public void setCursando(boolean cursando) {
        this.cursando = cursando;
    }
    
}
