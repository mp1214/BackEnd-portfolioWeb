
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String proyecto;
    private String path;
    private String img;
    private String fecha;
    private String repositorio;

    public dtoProyecto() {
    }

    public dtoProyecto(String proyecto, String path, String img, String fecha, String repositorio) {
        this.proyecto = proyecto;
        this.path = path;
        this.img = img;
        this.fecha = fecha;
        this.repositorio = repositorio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }



    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    
    
}
