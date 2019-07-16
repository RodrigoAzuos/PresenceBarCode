package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

public class Frequencia {
    @SerializedName("id") private long id;
    @SerializedName("data") private String data;
    @SerializedName("ativa") private String ativa;
    @SerializedName("hora_inicio") private String horaInicio;
    @SerializedName("hora_fim") private String horaFim;
    @SerializedName("disciplina") private String disciplina;

    public Frequencia(String data, String ativa, String horaInicio, String horaFim, String disciplina) {
        this.data = data;
        this.ativa = ativa;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAtiva() {
        return ativa;
    }

    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
