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
    @SerializedName("aluno") private long matriculaDiciplinar;
    @SerializedName("frequencia") private long frequencia;

    public Registro(boolean status, int peso, long matriculaDiciplinar, long frequencia) {
        this.status = status;
        this.peso = peso;
        this.matriculaDiciplinar = matriculaDiciplinar;
        this.frequencia = frequencia;
    }
}
