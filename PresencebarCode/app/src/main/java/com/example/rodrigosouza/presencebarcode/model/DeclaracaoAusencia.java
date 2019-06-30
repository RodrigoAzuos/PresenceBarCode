package com.example.rodrigosouza.presencebarcode.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties({"cod","justificativa","data_declaracao"})
public class DeclaracaoAusencia {
    private long cod;
    private String justificativa;
    private String professor;
    private String turma;
    private Date data_falta;
    private Date data_declaracao;
    private String horario;
    public DeclaracaoAusencia(){

    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getData_falta() {
        return data_falta;
    }

    public void setData_falta(Date dataFalta) {
        this.data_falta = dataFalta;
    }

    public Date getData_declaracao() {
        return data_declaracao;
    }

    public void setData_declaracao(Date dataDeclaracao) {
        this.data_declaracao = dataDeclaracao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
