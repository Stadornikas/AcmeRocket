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
 * Controle de exclusao de periodo
 * @author Leandro
 */
public class CtrlDeletarPeriodo {

    public CtrlDeletarPeriodo() {
    }
 
    /**
     * Verifica se o periodo possui turmas dependentes (vinculadas)
     * @param codPeriodo
     * @return boolean
     */
    private boolean validarDependecia(int codPeriodo){
        PeriodoDAO dao = new PeriodoDAO();
        //Caso a quantidade de turmas dependetes do periodo for maior que zero a validacao retorna false
        return dao.verificaQauntidadeDependencia(codPeriodo) > 0 ? false : true;
        
    }
    
    /**
     * Confirma se o usuário realmente deseja excluir
     * @return 
     */
    public boolean confirmaExclusao(){
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o perído?","Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }
    
    /**
     * Remove o período do banco de dados
     * @param codPeriodo 
     */
    public void excluirPeriodo(int codPeriodo){
        String msg = "Falha ao deletar período";
        boolean validacao = true;
        
        if (!this.validarDependecia(codPeriodo)) {
            msg = "Antes de deletar o período é necessário excluir as turmas vinculadas a ele";
            validacao = false;
        }
        
        if (validacao) {
            PeriodoDAO dao = new PeriodoDAO();
            if(dao.deletar(codPeriodo)) msg = "Período deletado com sucesso";
            
        }
        
        JOptionPane.showMessageDialog(null, msg); 
    }
}
