package com.example.rodrigosouza.presencebarcode.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
public class DeclaracaoAusencia {
    private String justificativa;
    private String professor;
    private String turma;
    private String horario;
    private String data_falta;
    private String data_declaracao;

    public DeclaracaoAusencia(){

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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData_falta() {
        return data_falta;
    }

    public void setData_falta(String data_falta) {
        this.data_falta = data_falta;
    }

    public String getData_declaracao() {
        return data_declaracao;
    }

    public void setData_declaracao(String data_declaracao) {
        this.data_declaracao = data_declaracao;
    }
}