package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Disciplina {
    @SerializedName("id") private long id;
    @SerializedName("descricao") private String descricao;

    public Disciplina(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
