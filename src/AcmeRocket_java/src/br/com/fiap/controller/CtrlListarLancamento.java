package br.com.fiap.controller;

import br.com.fiap.dao.LancamentoDAO;
import br.com.fiap.entity.Lancamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlListarLancamento {

    public CtrlListarLancamento() {
    }

//    public ArrayList<Lancamento> carregarRegistro() {
//
//    }
    
    public Lancamento carregarLancamento(int codLancamento) {
        LancamentoDAO dao = new LancamentoDAO();
        Lancamento l = dao.buscar(codLancamento);
        if (l == null) {
            JOptionPane.showMessageDialog(null, "Nenhum lançamento encontrado");
        }
        return l;
    }

}
