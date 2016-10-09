
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

    
    
}
