package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.LancamentoDAO;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Lancamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlSalvarLancamento {

    public int validarDispositivo(float altitudeMaxima, float velocidadeMaxima,
            float tempoDePropulsao, float picoAceleracao, float aceleracaoMedia, float tempoApogeuDescida,
            float tempoEjecao, float altitudeEjecao, float taxaDescida, float duracaoVoo, float distanciaQuedaAlvo) {
        int aux = 1;

        if (altitudeMaxima != 0 || velocidadeMaxima != 0 || tempoDePropulsao != 0 || picoAceleracao != 0 || aceleracaoMedia != 0 || tempoApogeuDescida != 0
                || tempoEjecao != 0 || altitudeEjecao != 0 || taxaDescida != 0 || duracaoVoo != 0 || distanciaQuedaAlvo != 0) {
            if (altitudeMaxima != 0 && velocidadeMaxima != 0 && tempoDePropulsao != 0 && picoAceleracao != 0 && aceleracaoMedia != 0 && tempoApogeuDescida != 0
                    && tempoEjecao != 0 && altitudeEjecao != 0 && taxaDescida != 0 && duracaoVoo != 0 && distanciaQuedaAlvo != 0) {
                aux = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos do pós-lançamento devem ser preenchidos");
                aux = 0;
            }
        }

        return aux;
    }

    public void inserirLancamento(Lancamento lancamento) {

        String msg = "Falha ao inserir lançamento";
        boolean validacao = true;
        if (validar(lancamento.getCodGrupo())) {
            validacao = false;
            msg = "Informe um grupo";
        }

        LancamentoDAO dao = new LancamentoDAO();
        if (validacao) {
            if (dao.inserir(lancamento)) {
                msg = "Laçamento Criado com sucesso";
            }
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

    public boolean validar(int codGrupo) {
        boolean aux = false;

        if (codGrupo == 0) {
            aux = true;

        }
        return aux;
    }
//
//    public int calcularStatus() {
//
//    }
}
