package com.example.rodrigosouza.presencebarcode.model;
import com.google.gson.annotations.SerializedName;
//{
//        "status": false,
//        "peso": null,
//        "aluno": null,
//        "frequencia": null
//        }

public class Registro {

    @SerializedName("id") private long id;
    @SerializedName("status") private boolean status;
    @SerializedName("peso") private int peso;
    @SerializedName("aluno") private long aluno;
    @SerializedName("frequencia") private long frequencia;

    public Registro(boolean status, int peso, long aluno, long freqeuncia) {
        this.status = status;
        this.peso = peso;
        this.aluno = aluno;
        this.frequencia = freqeuncia;
    }
}
