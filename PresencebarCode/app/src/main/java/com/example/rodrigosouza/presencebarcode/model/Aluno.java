package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Aluno {

    @SerializedName("id") private long id;
    @SerializedName("matricula_curso") private String matriculaCurso;

    public long getId() {
        return id;
    }

    public String getMatriculaCurso() {
        return matriculaCurso;
    }

    public void setMatriculaCurso(String matriculaCurso) {
        this.matriculaCurso = matriculaCurso;
    }
}
