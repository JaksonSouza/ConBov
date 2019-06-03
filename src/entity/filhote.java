/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Jakson
 */
public class filhote {
    Integer tatuagem;
    String sexo;
    String vacinado;

    public Integer getTatuagem() {
        return tatuagem;
    }

    public String getVacinado() {
        return vacinado;
    }

    public void setVacinado(String vacinado) {
        this.vacinado = vacinado;
    }

    public void setTatuagem(Integer tatuagem) {
        this.tatuagem = tatuagem;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
