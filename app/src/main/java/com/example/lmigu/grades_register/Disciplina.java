package com.example.lmigu.grades_register;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lmigu on 24/02/2018.
 */

public class Disciplina implements Serializable {

    private String nome;
    private int semestre;
    private ArrayList <Avaliacao> notasDisciplina = new ArrayList<>();

    public Disciplina (String nome, int semestre, ArrayList<Avaliacao> notasDisciplina)
    {
        this.nome = nome;
        this.semestre = semestre;
        this.notasDisciplina = notasDisciplina;
    }
    public Disciplina (String nome, int semestre)
    {
        this.nome = nome;
        this.semestre = semestre;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getSemestre() {

        return semestre;
    }

    public void setSemestre(int semestre) {

        this.semestre = semestre;
    }

    public ArrayList<Avaliacao> getNotasDisciplina() {
        return notasDisciplina;
    }

    public void setNotasDisciplina(ArrayList<Avaliacao> notasDisciplina) {
        this.notasDisciplina = notasDisciplina;
    }
}
