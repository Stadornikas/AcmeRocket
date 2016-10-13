package br.com.fiap.entity;

public class Turma {

    private int codTurma;
    private String nomTurma;
    private int anoTurma;
    private int codPeriodo;

    //CONSTRUTOR
    public Turma(int codTurma, String nomTurma, int anoTurma, int codPeriodo) {
        this.codTurma = codTurma;
        this.nomTurma = nomTurma;
        this.anoTurma = anoTurma;
        this.codPeriodo = codPeriodo;
    }

    //CONSTRUTOR
    public Turma(String nomTurma, int anoTurma, int codPeriodo) {
        this.nomTurma = nomTurma;
        this.anoTurma = anoTurma;
        this.codPeriodo = codPeriodo;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public String getNomTurma() {
        return nomTurma;
    }

    public void setNomTurma(String nomTurma) {
        this.nomTurma = nomTurma;
    }

    public int getAnoTurma() {
        return anoTurma;
    }

    public void setAnoTurma(int anoTurma) {
        this.anoTurma = anoTurma;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }
    
    
    
}
