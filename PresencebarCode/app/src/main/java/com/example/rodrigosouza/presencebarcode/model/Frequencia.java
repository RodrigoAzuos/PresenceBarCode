package com.example.rodrigosouza.presencebarcode.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Frequencia {
    @SerializedName("id") private long id;
    @SerializedName("data") private String data;
    @SerializedName("ativa") private String ativa;
    @SerializedName("hora_inicio") private String horaInicio;
    @SerializedName("hora_fim") private String horaFim;
    @SerializedName("disciplina") private long disciplina;
    @SerializedName("disciplina") private List<Registro> registros;

    public Frequencia(String data, String horaInicio, String horaFim, long disciplina) {
        this.data = data;
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

    public long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(long disciplina) {
        this.disciplina = disciplina;
    }
}
