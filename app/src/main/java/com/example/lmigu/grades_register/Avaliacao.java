package com.example.lmigu.grades_register;

import java.io.Serializable;

/**
 * Created by lmigu on 05/03/2018.
 */

public class Avaliacao implements Serializable {

    private String nomeAval;
    private double nota=0;

    private double peso=0;

    public Avaliacao (String nomeAval, double nota,double peso){
        this.nomeAval = nomeAval;
        this.nota = nota;
        this.peso = peso;
    }



    public String getNomeAval() {
        return nomeAval;
    }

    public void setNomeAval(String nomeAval) {
        this.nomeAval = nomeAval;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
