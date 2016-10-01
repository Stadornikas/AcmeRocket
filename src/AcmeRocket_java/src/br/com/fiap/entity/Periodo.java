package br.com.fiap.entity;

public class Periodo {
    
private int codPeriodo;
private String nomPeriodo;

    //CONSTRUTOR
    public Periodo(int codPeriodo, String nomPeriodo) {
        this.codPeriodo = codPeriodo;
        this.nomPeriodo = nomPeriodo;
    }

    //CONSTRUTOR
    public Periodo(String nomPeriodo) {
        this.nomPeriodo = nomPeriodo;
    }

    public int getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(int codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getNomPeriodo() {
        return nomPeriodo;
    }

    public void setNomPeriodo(String nomPeriodo) {
        this.nomPeriodo = nomPeriodo;
    }
    
    

}
