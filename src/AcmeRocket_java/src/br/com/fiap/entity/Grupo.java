package br.com.fiap.entity;

public class Grupo {

    private int codGrupo;
    private String nomGrupo;
    private int codTurma;
    private int codEvento;
    
    
    //CONSTRUTOR
    public Grupo(int codGrupo, String nomGrupo, int codTurma, int codEvento) {
        this.codGrupo = codGrupo;
        this.nomGrupo = nomGrupo;
        this.codTurma = codTurma;
        this.codEvento = codEvento;
    }
    
    //CONSTRUTOR
    public Grupo(String nomGrupo, int codTurma, int codEvento) {
        this.nomGrupo = nomGrupo;
        this.codTurma = codTurma;
        this.codEvento = codEvento;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public int getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(int codEvento) {
        this.codEvento = codEvento;
    }
    
    
}
