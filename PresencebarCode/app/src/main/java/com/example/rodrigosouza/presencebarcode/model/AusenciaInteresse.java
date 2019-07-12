package com.example.rodrigosouza.presencebarcode.model;

public class AusenciaInteresse {
    private long cod;
    private String ausencia;
    private String hora_inicio;
    private String hora_fim;
    private Boolean status;
    private String interessado;

    public AusenciaInteresse() {

    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getAusencia() {
        return ausencia;
    }

    public void setAusencia(String ausencia) {
        this.ausencia = ausencia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String horaInicio) {
        this.hora_inicio = horaInicio;
    }

    public String getHor_fim() {
        return hora_fim;
    }

    public void setHora_fim(String horafim) {
        this.hora_fim = horafim;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getInteressado() {
        return interessado;
    }

    public void setInteressado(String interessado) {
        this.interessado = interessado;
    }
}