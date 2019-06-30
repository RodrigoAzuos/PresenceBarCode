package com.example.rodrigosouza.presencebarcode.model;

import java.util.Date;

public class DeclaracaoInteresse {
    private long cod ;
    private Professor professor;
    private Date dateDeclaracao;
    public DeclaracaoInteresse(){

    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Date getDateDeclaracao() {
        return dateDeclaracao;
    }

    public void setDateDeclaracao(Date dateDeclaracao) {
        this.dateDeclaracao = dateDeclaracao;
    }
}
