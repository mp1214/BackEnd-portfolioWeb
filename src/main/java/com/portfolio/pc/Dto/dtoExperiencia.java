
package com.portfolio.pc.Dto;

import java.util.Date;


public class dtoExperiencia {
  // @NotBlank
   private String cargo;
  // @NotBlank
   private String descripcion;
  // @NotBlank
   private String empresa;
 //  @NotBlank
   private Boolean esTrabajoActual;
 //  @NotBlank
   private Date inicio;
  // @NotBlank
   private Date fin;
   
   private String imgE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String cargo, String descripcion, String empresa, Boolean esTrabajoActual, Date inicio, Date fin, String imgE) {
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.esTrabajoActual = esTrabajoActual;
        this.inicio = inicio;
        this.fin = fin;
        this.imgE = imgE;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Boolean getEsTrabajoActual() {
        return esTrabajoActual;
    }

    public void setEsTrabajoActual(Boolean esTrabajoActual) {
        this.esTrabajoActual = esTrabajoActual;
    }

    public Date getInicio() {
      
        return inicio;
    }

    public void setInicio(Date inicio) {
        
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
     
   
}
