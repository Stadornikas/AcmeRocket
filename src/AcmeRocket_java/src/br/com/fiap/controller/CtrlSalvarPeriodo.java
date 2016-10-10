/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.entity.Periodo;
import javax.swing.JOptionPane;

/**
 * Controle de inclusao e alteração de periodo
 * @author Leandro
 */
public class CtrlSalvarPeriodo {

    public CtrlSalvarPeriodo() {}
    
    /**
     * Verifica se existe um periodo com o mesmo nome
     * @param nomePeriodo
     * @return boolean 
     */
    private boolean validarNomeDuplicidade(String nomePeriodo){
        PeriodoDAO dao = new PeriodoDAO();
        //retorna false caso o periodo exista no banco dados
        return !dao.existePeriodo(nomePeriodo); 
    }
    
    /**
     * verifica se o nome foi preenchido
     * @param nomePeriodo
     * @return boolean
     */
    private boolean validarCamposObrigatorios(String nomePeriodo){
        return !(nomePeriodo.equalsIgnoreCase(""));
    }
    
    /**
     * Valida informações e persiste o periodo
     * @param nomePeriodo
     * @return boolean
     */
    public void inserirPeriodo(String nomePeriodo){
        String msg =  "Falha ao inserir período";
        boolean validacao = true;
        
        if (!this.validarCamposObrigatorios(nomePeriodo)) {
            msg =  "Preencha os campos Obrigatórios";
            validacao = false;
        }
        
        if(!this.validarNomeDuplicidade(nomePeriodo)) {
            msg =  "Já existe um período com este nome";
            validacao = false;
        }
        
        if (validacao) {
            Periodo p = new Periodo(nomePeriodo);
            PeriodoDAO dao = new PeriodoDAO();
            if(dao.inserir(p)) msg = "Período Criado com sucesso";
            
        }
                 
        JOptionPane.showMessageDialog(null, msg);     
           
    }
    
    /**
     * Valida dados e modifica o periodo
     * @param codPeriodo
     * @return 
     */
    public void alterarPeriodo(int codPeriodo,String nomePeriodo){
        String msg = "Falha ao alterar período";
        boolean validacao = true;
        
        if (!this.validarCamposObrigatorios(nomePeriodo)) {
            msg =  "Preencha os campos Obrigatórios";
            validacao = false;
        }
        
        if (validacao) {
            Periodo p = new Periodo(codPeriodo, nomePeriodo);
            PeriodoDAO dao = new PeriodoDAO();
            if(dao.alterar(p)) msg = "Período Alteardo com sucesso";
            
        }
                  
        JOptionPane.showMessageDialog(null, msg);  
    }
    
    /**
     * Carrega periodo selecionado na lista
     * @param codPeriodo
     * @return 
     */
    public Periodo carregarPeriodo(int codPeriodo){
        PeriodoDAO dao = new PeriodoDAO();
        Periodo p = dao.buscar(codPeriodo);
        return p;
    }
    
    
    
    
}
