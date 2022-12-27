
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class dtoPersona {
    @NotBlank 
    private String nombre;
    @NotBlank 
    private String apellido;
    @NotBlank 
    private String img;
    @NotBlank
    private String acercaDeMi;
    private String email;
    private long telefono;
    private String imgBanner;
    private String tituloEfecto;
    private String domicilio;

    public dtoPersona(String apellido, String img, String acercaDeMi, String email, long telefono, String imgBanner, String tituloEfecto,String domicilio) {
        this.apellido = apellido;
        this.img = img;
        this.acercaDeMi = acercaDeMi;
        this.email = email;
        this.telefono = telefono;
        this.imgBanner = imgBanner;
        this.tituloEfecto = tituloEfecto;
        this.domicilio=domicilio;
    }

    public dtoPersona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAcercaDeMi() {
        return acercaDeMi;
    }

    public void setAcercaDeMi(String acercaDeMi) {
        this.acercaDeMi = acercaDeMi;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getTituloEfecto() {
        return tituloEfecto;
    }

    public void setTituloEfecto(String tituloEfecto) {
        this.tituloEfecto = tituloEfecto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
}
