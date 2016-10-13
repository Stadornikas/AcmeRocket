package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.LancamentoDAO;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Lancamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlSalvarLacamento {

    public boolean validarDispositivo() {
        return true;
    }

    public void inserirLancamento(Lancamento lancamento) {

        String msg = "Falha ao inserir lançamento";
        boolean validacao = true;

        LancamentoDAO dao = new LancamentoDAO();
        if (dao.inserir(lancamento)) {
            msg = "Laçamento Criado com sucesso";
        }

        JOptionPane.showMessageDialog(null, msg);

    }

    public void editarLancamento(Lancamento lancamento) {

        String msg = "Falha ao alterar lançamento";

        LancamentoDAO dao = new LancamentoDAO();
        if (dao.alterar(lancamento)) {
            msg = "lançamento Alteardo com sucesso";
        }

        JOptionPane.showMessageDialog(null, msg);

    }
    
    public ArrayList<Grupo> carregarRegistrosGrupo() {
        GrupoDAO dao = new GrupoDAO();
        return dao.listar();
    }

    public String carregarComboGrupo(int codGrupo) {
        String t = "";
        GrupoDAO dao = new GrupoDAO();
        t = dao.buscarNomeGrupo(codGrupo);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Erro ao listar combo lançamento");
        }
        return t;
    }

//    public boolean validar() {
//
//    }
//
//    public int calcularStatus() {
//
//    }
}
