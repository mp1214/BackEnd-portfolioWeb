
package com.portfolio.pc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String proyecto;
    private String path;
    private String img;
    private String fecha;
    private String repositorio;

    public Proyecto() {
    }

    public Proyecto(String proyecto, String path, String img, String fecha, String repositorio) {
        this.proyecto = proyecto;
        this.path = path;
        this.img = img;
        this.fecha = fecha;
        this.repositorio = repositorio;
    }

  

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
