/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.entity;

import java.sql.Date;



/**
 *
 * @author leandro
 */
public class Ranking {
    
    private String nomGrupo;
    private Date datEvento;
    private float disQueda;
    private float velMax;
    private float altMax;
    private String horLancamento;

    public Ranking(String nomGrupo, Date datEvento, float disQueda, float velMax, float altMax, String horLancamento) {
        this.nomGrupo = nomGrupo;
        this.datEvento = datEvento;
        this.disQueda = disQueda;
        this.velMax = velMax;
        this.altMax = altMax;
        this.horLancamento = horLancamento;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    public Date getDatEvento() {
        return datEvento;
    }

    public void setDatEvento(Date datEvento) {
        this.datEvento = datEvento;
    }

    public float getDisQueda() {
        return disQueda;
    }

    public void setDisQueda(float disQueda) {
        this.disQueda = disQueda;
    }

    public float getVelMax() {
        return velMax;
    }

    public void setVelMax(float velMax) {
        this.velMax = velMax;
    }

    public float getAltMax() {
        return altMax;
    }

    public void setAltMax(float altMax) {
        this.altMax = altMax;
    }

    public String getHorLancamento() {
        return horLancamento;
    }

    public void setHorLancamento(String horLancamento) {
        this.horLancamento = horLancamento;
    }
    
    
}
