/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.PeriodoDao;
import br.com.fiap.entity.Periodo;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class CtrlSalvarPeriodo {

    public CtrlSalvarPeriodo() {}
    
    /**
     * Verifica se existe um periodo com o mesmo nome
     * @param nomePeriodo
     * @return boolean 
     */
    public boolean validarNomeDuplicidade(String nomePeriodo){
        PeriodoDao dao = new PeriodoDao();
        return !dao.existePeriodo(nomePeriodo);
    }
    
    /**
     * verifica se o nome foi preenchido
     * @param nomePeriodo
     * @return boolean
     */
    public boolean validarCamposObrigatorios(String nomePeriodo){
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
            PeriodoDao dao = new PeriodoDao();
            if(dao.inserir(p)) msg = "Período Criado com sucesso";
            
        }
                 
        JOptionPane.showMessageDialog(null, msg);     
           
    }
    
    /**
     * Valida dados e modifica o periodo
     * @param idPeriodo
     * @return 
     */
    public boolean alterarPeriodo(int idPeriodo){
        boolean output = false;
        
        return output; 
    }
    
    /**
     * Destroi o objeto
     */
    public void destruirObj(){}
    
    
    
}
