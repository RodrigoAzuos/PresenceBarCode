package com.example.rodrigosouza.presencebarcode.model;

import java.util.Date;

public class DeclaracaoInteresse {
    //private long cod ;
    private String declarador;
    private String data_declaracao;
    public DeclaracaoInteresse(){

    }
    public DeclaracaoInteresse(String declarador, String data_declaracao){
        this.declarador = declarador;
        this.data_declaracao = data_declaracao;
    }

    /*public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }*/

    public String getDeclarador() {
        return declarador;
    }

    public void setDeclarador(String professor) {
        this.declarador = professor;
    }

    public String getData_declaracao() {
        return data_declaracao;
    }

    public void setData_declaracao(String dataDeclaracao) {
        this.data_declaracao = dataDeclaracao;
    }
}