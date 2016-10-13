/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.AlunoDAO;
import javax.swing.JOptionPane;


public class CtrlDeletarAluno {

    public CtrlDeletarAluno() {
    }
 
    /**
     * Verifica se o aluno possui grupos dependentes (vinculadas)
     * @param codAluno
     * @return boolean
     */
    
    /**
     * Confirma se o usuário realmente deseja excluir
     * @return 
     */
    public boolean confirmaExclusao(){
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o aluno?","Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }
    
    /**
     * Remove o aluno do banco de dados
     * @param codAluno 
     */
    public void excluirAluno(int codAluno){
        String msg = "Falha ao deletar aluno";
        boolean validacao = true;
        
        
        
        if (validacao) {
            AlunoDAO dao = new AlunoDAO();
            if(dao.deletar(codAluno)) msg = "Aluno deletado com sucesso";
        }
        
        JOptionPane.showMessageDialog(null, msg); 
    }
}
