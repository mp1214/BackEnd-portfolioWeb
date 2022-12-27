/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidad {
    @NotBlank
    private String habilidad;
    @NotBlank
    private int porcentaje;
    private String icono;

    public dtoHabilidad() {
    }

    public dtoHabilidad(String habilidad, int porcentaje, String icono) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.icono = icono;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
    
    
}
