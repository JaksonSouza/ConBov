package entity;

import java.awt.Frame;

/**
 *
 * @author Jakson
 */
public class historico {
    Integer numeroPai;
    Integer numeroMae;
    Integer idAnimal;
    String vacinado;
    
    public Integer getNumeroPai() {
        return numeroPai;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setNumeroPai(Integer numeroPai) {
        this.numeroPai = numeroPai;
    }

    public Integer getNumeroMae() {
        return numeroMae;
    }

    public void setNumeroMae(Integer numeroMae) {
        this.numeroMae = numeroMae;
    }

    public String getVacinado() {
        return vacinado;
    }

    public void setVacinado(String vacinado) {
        this.vacinado = vacinado;
    }  
}
