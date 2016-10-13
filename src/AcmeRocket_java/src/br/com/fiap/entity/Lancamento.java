package br.com.fiap.entity;

import java.sql.Date;

public class Lancamento {

    private int codLancamento;
    private int codGrupo;
    private String horLancamento;
    private int status;
    private float angLancamento;
    private float velVento;
    private float disAlvo;
    private float pesFoguete;
    private float altMax = 0;
    private float velMax = 0;
    private float temPrp = 0;
    private float picAcl = 0;
    private float alcMax = 0;
    private float temApdc = 0;
    private float temEje = 0;
    private float altEje = 0;
    private float taxDes = 0;
    private float durVoo = 0;
    private float disQueda = 0;

    public Lancamento(int codLancamento, int codGrupo, String horLancamento, int status, float angLancamento, float velVento, float disAlvo,
            float pesFoguete, float altMax, float velMax, float temPrp, float picAcl, float alcMax, float temApdc, float temEje, float altEje, float taxDes,
            float durVoo, float disQueda) {
        this.codLancamento = codLancamento;
        this.codGrupo = codGrupo;
        this.horLancamento = horLancamento;
        this.status = status;
        this.angLancamento = angLancamento;
        this.velVento = velVento;
        this.disAlvo = disAlvo;
        this.pesFoguete = pesFoguete;
        this.altMax = altMax;
        this.velMax = velMax;
        this.temPrp = temPrp;
        this.picAcl = picAcl;
        this.alcMax = alcMax;
        this.temApdc = temApdc;
        this.temEje = temEje;
        this.altEje = altEje;
        this.taxDes = taxDes;
        this.durVoo = durVoo;
        this.disQueda = disQueda;
    }

    public Lancamento(int codGrupo, String horLancamento, int status, float angLancamento,
            float velVento, float disAlvo, float pesFoguete, float altMax, float velMax, float temPrp, float picAcl,
            float alcMax, float temApdc, float temEje, float altEje, float taxDes, float durVoo, float disQueda) {
        this.codGrupo = codGrupo;
        this.horLancamento = horLancamento;
        this.status = status;
        this.angLancamento = angLancamento;
        this.velVento = velVento;
        this.disAlvo = disAlvo;
        this.pesFoguete = pesFoguete;
        this.altMax = altMax;
        this.velMax = velMax;
        this.temPrp = temPrp;
        this.picAcl = picAcl;
        this.alcMax = alcMax;
        this.temApdc = temApdc;
        this.temEje = temEje;
        this.altEje = altEje;
        this.taxDes = taxDes;
        this.durVoo = durVoo;
        this.disQueda = disQueda;
    }

    public int getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(int codLancamento) {
        this.codLancamento = codLancamento;
    }

    public int getCodGrupo() {
        return codGrupo;
    }

    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }

    public String getHorLancamento() {
        return horLancamento;
    }

    public void setHorLancamento(String horLancamento) {
        this.horLancamento = horLancamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getAngLancamento() {
        return angLancamento;
    }

    public void setAngLancamento(float angLancamento) {
        this.angLancamento = angLancamento;
    }

    public float getVelVento() {
        return velVento;
    }

    public void setVelVento(float velVento) {
        this.velVento = velVento;
    }

    public float getDisAlvo() {
        return disAlvo;
    }

    public void setDisAlvo(float disAlvo) {
        this.disAlvo = disAlvo;
    }

    public float getPesFoguete() {
        return pesFoguete;
    }

    public void setPesFoguete(float pesFoguete) {
        this.pesFoguete = pesFoguete;
    }

    public float getAltMax() {
        return altMax;
    }

    public void setAltMax(float altMax) {
        this.altMax = altMax;
    }

    public float getVelMax() {
        return velMax;
    }

    public void setVelMax(float velMax) {
        this.velMax = velMax;
    }

    public float getTemPrp() {
        return temPrp;
    }

    public void setTemPrp(float temPrp) {
        this.temPrp = temPrp;
    }

    public float getPicAcl() {
        return picAcl;
    }

    public void setPicAcl(float picAcl) {
        this.picAcl = picAcl;
    }

    public float getAlcMax() {
        return alcMax;
    }

    public void setAlcMax(float alcMax) {
        this.alcMax = alcMax;
    }

    public float getTemApdc() {
        return temApdc;
    }

    public void setTemApdc(float temApdc) {
        this.temApdc = temApdc;
    }

    public float getAltEje() {
        return altEje;
        
    }

    public void setAltEje(float altEje) {
        this.altEje = altEje;
    }
       
    public float getTemEje() {
        return temEje;
    }

    public void setTemEje(float temEje) {
        this.temEje = temEje;
    }

    public float getTaxDes() {
        return taxDes;
    }

    public void setTaxDes(float taxDes) {
        this.taxDes = taxDes;
    }

    public float getDurVoo() {
        return durVoo;
    }

    public void setDurVoo(float durVoo) {
        this.durVoo = durVoo;
    }

    public float getDisQueda() {
        return disQueda;
    }

    public void setDisQueda(float disQueda) {
        this.disQueda = disQueda;
    }

}
