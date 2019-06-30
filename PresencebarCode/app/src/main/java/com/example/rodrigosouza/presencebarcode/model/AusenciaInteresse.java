package com.example.rodrigosouza.presencebarcode.model;

public class AusenciaInteresse {
    private long cod;
    private DeclaracaoAusencia ausencia;
    private String horaInicio;
    private String horafim;
    private Boolean status;
    private DeclaracaoInteresse interessado;
    public AusenciaInteresse(){

    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public DeclaracaoAusencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(DeclaracaoAusencia ausencia) {
        this.ausencia = ausencia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHorafim() {
        return horafim;
    }

    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DeclaracaoInteresse getInteressado() {
        return interessado;
    }

    public void setInteressado(DeclaracaoInteresse interessado) {
        this.interessado = interessado;
    }
}
