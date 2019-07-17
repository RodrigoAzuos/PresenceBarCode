package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Matricula {

    @SerializedName("id") private long id;
    @SerializedName("aluno") private Aluno aluno;

    public long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
