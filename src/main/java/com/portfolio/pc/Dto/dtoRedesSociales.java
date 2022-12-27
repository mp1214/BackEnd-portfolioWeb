
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoRedesSociales {
    @NotBlank
    private String nombre;
    private String imagen;
    @NotBlank
    private String path;

    public dtoRedesSociales() {
    }

    public dtoRedesSociales(String nombre, String imagen, String path) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.path = path;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImg(String imagen) {
        this.imagen = imagen;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
