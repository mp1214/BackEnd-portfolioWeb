/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pc.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author User
 */
public class dtoCertificado {
   
    @NotBlank
    private String titulo;
    private String img;

    public dtoCertificado() {
    }

    public dtoCertificado(String titulo, String img) {
        this.titulo = titulo;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
