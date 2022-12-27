
package com.portfolio.pc.entity;

import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
     
    private String img;
    
    @NotNull
    private String acerca_de_mi;
    private String email;
    private long telefono;
    private String img_banner;
    private String titulo_efecto;
    private String domicilio;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String acerca_de_mi, String email, long telefono, String img_banner, String titulo_efecto,String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acerca_de_mi = acerca_de_mi;
        this.email = email;
        this.telefono = telefono;
        this.img_banner = img_banner;
        this.titulo_efecto = titulo_efecto;
        this.domicilio = domicilio;
        
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return acerca_de_mi;
    }

    public void setAcercaDeMi(String acerca_de_mi) {
        this.acerca_de_mi = acerca_de_mi;
    }

    public String getImgBanner() {
        return img_banner;
    }

    public void setImgBanner(String img_banner) {
        this.img_banner = img_banner;
    }

    public String getTituloEfecto() {
        return titulo_efecto;
    }

    public void setTituloEfecto(String titulo_efecto) {
        this.titulo_efecto = titulo_efecto;
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
