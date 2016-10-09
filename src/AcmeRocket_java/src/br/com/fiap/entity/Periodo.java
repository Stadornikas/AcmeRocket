<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.entity;

/**
 *
 * @author leandro
 */
public class Periodo {
    
    
    
    
=======
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
    
    

>>>>>>> 68b174ff30e5414db01775948078579a63e1037a
}
