package br.com.fiap.entity;

import java.sql.Date;

public class Lancamento {

    private int codLancamento;
    private int codGrupo;
    private Date horLancamento;
    private double angLancamento;
    private double velVento;
    private double pesFoguete;
    private double altMax;
    private double velMax;
    private double temPrp;
    private double picAcl;
    private double alcMax;
    private double temApdg;
    private double temEje;
    private double taxDes;
    private double durVoo;
    private double disQueda;

    public Lancamento(int codLancamento, int codGrupo, Date horLancamento, double angLancamento, double velVento, double pesFoguete, double altMax, double velMax, double picAcl, double alcMax, double temApdg, double temEje, double taxDes, double durVoo, double disQueda) {
        this.codLancamento = codLancamento;
        this.codGrupo = codGrupo;
        this.horLancamento = horLancamento;
        this.angLancamento = angLancamento;
        this.velVento = velVento;
        this.pesFoguete = pesFoguete;
        this.altMax = 0;
        this.velMax = 0;
        this.picAcl = 0;
        this.alcMax = 0;
        this.temApdg = 0;
        this.temEje = 0;
        this.taxDes = 0;
        this.durVoo = 0;
        this.disQueda = 0;
    }

    public Lancamento(int codGrupo, Date horLancamento, double angLancamento, double velVento, double pesFoguete, double altMax, double velMax, double temPrp, double picAcl, double alcMax, double temApdg, double temEje, double taxDes, double durVoo, double disQueda) {
        this.codGrupo = codGrupo;
        this.horLancamento = horLancamento;
        this.angLancamento = angLancamento;
        this.velVento = velVento;
        this.pesFoguete = pesFoguete;
        this.altMax = 0;
        this.velMax = 0;
        this.temPrp = 0;
        this.picAcl = 0;
        this.alcMax = 0;
        this.temApdg = 0;
        this.temEje = 0;
        this.taxDes = 0;
        this.durVoo = 0;
        this.disQueda = 0;
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

    public Date getHorLancamento() {
        return horLancamento;
    }

    public void setHorLancamento(Date horLancamento) {
        this.horLancamento = horLancamento;
    }

    public double getAngLancamento() {
        return angLancamento;
    }

    public void setAngLancamento(double angLancamento) {
        this.angLancamento = angLancamento;
    }

    public double getVelVento() {
        return velVento;
    }

    public void setVelVento(double velVento) {
        this.velVento = velVento;
    }

    public double getPesFoguete() {
        return pesFoguete;
    }

    public void setPesFoguete(double pesFoguete) {
        this.pesFoguete = pesFoguete;
    }

    public double getAltMax() {
        return altMax;
    }

    public void setAltMax(double altMax) {
        this.altMax = altMax;
    }

    public double getVelMax() {
        return velMax;
    }

    public void setVelMax(double velMax) {
        this.velMax = velMax;
    }

    public double getTemPrp() {
        return temPrp;
    }

    public void setTemPrp(double temPrp) {
        this.temPrp = temPrp;
    }

    public double getPicAcl() {
        return picAcl;
    }

    public void setPicAcl(double picAcl) {
        this.picAcl = picAcl;
    }

    public double getAlcMax() {
        return alcMax;
    }

    public void setAlcMax(double alcMax) {
        this.alcMax = alcMax;
    }

    public double getTemApdg() {
        return temApdg;
    }

    public void setTemApdg(double temApdg) {
        this.temApdg = temApdg;
    }

    public double getTemEje() {
        return temEje;
    }

    public void setTemEje(double temEje) {
        this.temEje = temEje;
    }

    public double getTaxDes() {
        return taxDes;
    }

    public void setTaxDes(double taxDes) {
        this.taxDes = taxDes;
    }

    public double getDurVoo() {
        return durVoo;
    }

    public void setDurVoo(double durVoo) {
        this.durVoo = durVoo;
    }

    public double getDisQueda() {
        return disQueda;
    }

    public void setDisQueda(double disQueda) {
        this.disQueda = disQueda;
    }
    
    
    
    
    

}
