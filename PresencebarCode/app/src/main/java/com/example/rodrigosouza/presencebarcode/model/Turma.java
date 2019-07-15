package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Turma {

    @SerializedName("id") private long id;
    @SerializedName("disciplina") private String disciplina;

    public Turma(String disciplina){
        this.disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
