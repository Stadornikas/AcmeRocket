
package br.com.fiap.entity;

import java.util.ArrayList;

public class Aluno {

    private int codAluno;
    private String nomComp;
    private int codGrupo;
    
    
    //CONSTRUTOR
    public Aluno(int codAluno, String nomComp, int codGrupo) {
        this.codAluno = codAluno;
        this.nomComp = nomComp;
        this.codGrupo = codGrupo;
    }     
    
    public Aluno(int codAluno) {
        this.codAluno = codAluno;
    }
    
    
    //GETTERS E SETTERS
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
    
    
   /* public ArrayList<Aluno> listar(){
        
    } */
    
    
}
