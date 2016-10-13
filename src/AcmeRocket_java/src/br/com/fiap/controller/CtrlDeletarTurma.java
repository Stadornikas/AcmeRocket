/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.TurmaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class CtrlDeletarTurma {
    
     /**
     * Verifica se o turma possui turmas dependentes (vinculadas)
     * @param codTurma
     * @return boolean
     */
    private boolean validarDependecia(int codTurma){
        TurmaDAO dao = new TurmaDAO();
        //Caso a quantidade de turmas dependetes do turma for maior que zero a validacao retorna false
        return dao.verificaQauntidadeDependencia(codTurma) > 0 ? false : true;
        
    }
    
    /**
     * Confirma se o usuário realmente deseja excluir
     * @return 
     */
    public boolean confirmaExclusao(){
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar a turma?","Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }
    
    /**
     * Remove o turma do banco de dados
     * @param codTurma 
     */
    public void excluirTurma(int codTurma){
        String msg = "Falha ao deletar turma";
        boolean validacao = true;
        
        if (!this.validarDependecia(codTurma)) {
            msg = "Antes de deletar o turma é necessário excluir os grupos vinculadas a ela";
            validacao = false;
        }
        
        if (validacao) {
            TurmaDAO dao = new TurmaDAO();
            if(dao.deletar(codTurma)) msg = "Turma deletado com sucesso";
            
        }
        
        JOptionPane.showMessageDialog(null, msg); 
    }
}
