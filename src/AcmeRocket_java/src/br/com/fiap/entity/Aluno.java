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
public class Aluno {
    
=======
package br.com.fiap.entity;

public class Aluno {

    private int codAluno;
    private String nomComp;
    private int codGrupo;

    public Aluno(int codAluno, String nomComp, int codGrupo) {
        this.codAluno = codAluno;
        this.nomComp = nomComp;
        this.codGrupo = codGrupo;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public String getNomComp() {
        return nomComp;
    }

    public void setNomComp(String nomComp) {
        this.nomComp = nomComp;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }
>>>>>>> 68b174ff30e5414db01775948078579a63e1037a
    
    
}
