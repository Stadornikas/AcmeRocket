package br.com.fiap.entity;

import java.sql.Date;

public class Evento {

    
    private int codEvento;
    private String nomEvento;
    private String locEvento;
    private Date datEvento;


    //CONSTRUTOR
    public Evento(int codEvento, String nomEvento, String locEvento, Date datEvento) {//O que é isso?
        this.codEvento = codEvento;
        this.nomEvento = nomEvento;
        this.locEvento = locEvento;
        this.datEvento = datEvento;
    }
    
    //CONSTRUTOR
    public Evento(String nomEvento, String locEvento, Date datEvento) {
        this.nomEvento = nomEvento;
        this.locEvento = locEvento;
        this.datEvento = datEvento;
    }

    public int getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(int codEvento) {
        this.codEvento = codEvento;
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    public String getLocEvento() {
        return locEvento;
    }

    public void setLocEvento(String locEvento) {
        this.locEvento = locEvento;
    }

    public Date getDatEvento() {
        return datEvento;
    }

    public void setDatEvento(Date datEvento) {
        this.datEvento = datEvento;
    }
    
    
       
    
    
}
