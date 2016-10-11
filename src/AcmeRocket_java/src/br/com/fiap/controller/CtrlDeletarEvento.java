package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import javax.swing.JOptionPane;

public class CtrlDeletarEvento {
    public CtrlDeletarEvento() {}
    
    public boolean validarDependencia(int codEvento) {
        EventoDAO dao = new EventoDAO();
        //Caso a quantidade de turmas dependetes do periodo for maior que zero a validacao retorna false
        return dao.verificarQuantidadeDependencia(codEvento) > 0 ? false : true;
    }
    
    public boolean confirmaExclusao() {
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o evento?","Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }
    
    public void excluirEvento(int codEvento) {
        String msg = "Falha ao deletar Evento";
        boolean validacao = true;
        
        if (!this.validarDependencia(codEvento)) {
            msg = "Antes de deletar o evento é necessário excluir os grupos vinculados a ele";
            validacao = false;
        }
        
        if (validacao) {
            EventoDAO dao = new EventoDAO();
            if(dao.deletar(codEvento)){
                msg = "Evento deletado com sucesso";
            }
        }
        
        JOptionPane.showMessageDialog(null, msg); 
    }
}
