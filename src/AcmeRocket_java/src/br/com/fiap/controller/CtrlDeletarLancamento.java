package br.com.fiap.controller;

import br.com.fiap.dao.LancamentoDAO;
import javax.swing.JOptionPane;

public class CtrlDeletarLancamento {

    public CtrlDeletarLancamento() {
    }

    public boolean confirmaExclusao() {
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o lançamento?", "Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }

//    public boolean validarDependencia() {
//
//    }

    public void excluirLancamento(int codLancamento) {
        String msg = "Falha ao deletar período";
        boolean validacao = true; 

        if (validacao) {
            LancamentoDAO dao = new LancamentoDAO();
            if (dao.deletar(codLancamento)) {
                msg = "Lançamento deletado com sucesso";
            }
        }

        JOptionPane.showMessageDialog(null, msg);
    }

}
