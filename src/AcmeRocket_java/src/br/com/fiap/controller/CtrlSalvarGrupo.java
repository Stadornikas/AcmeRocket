/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class CtrlSalvarGrupo {

    public Grupo carregarGrupo(int codGrupo) {
        GrupoDAO dao = new GrupoDAO();
        Grupo g = dao.buscar(codGrupo);
        if (g == null) {
            JOptionPane.showMessageDialog(null, "Nenhum grupo encontrada");
        }
        return g;
    }

    public ArrayList<Turma> carregarRegistrosTurma() {
        TurmaDAO dao = new TurmaDAO();
        return dao.listar();
    }

    public ArrayList<Evento> carregarRegistrosEvento() {
        EventoDAO dao = new EventoDAO();
        return dao.listar();
    }

    public String carregarComboTurma(int codTurma) {
        String t = "";
        TurmaDAO dao = new TurmaDAO();
        t = dao.buscarNomeTurma(codTurma);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Erro ao listar combo turma");
        }
        return t;
    }

    public String carregarComboEvento(int codEvento) {
        String e = "";

        EventoDAO dao = new EventoDAO();
        e = dao.buscarNomeEvento(codEvento);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Erro ao listar combo evento");
        }

        return e;
    }

    public void inserirGrupo(String nomeGrupo, int codTurma, int codEvento) {
        //int codTurma = this.buscarIdComboTurma(nomeTurma);
        //int codEvento = this.buscarIdComboEvento(nomeEvento);
        String msg = "Falha ao inserir período";
        boolean validacao = true;

        if (this.validarCamposObrigatorios(nomeGrupo, codTurma, codEvento)) {
            msg = "Informe os campos obrigatorios";
            validacao = false;
        }
        if (this.validarNomeDuplicidade(nomeGrupo)) {
            msg = "Já existe um grupo com este nome";
            validacao = false;
        }

        if (this.validarTamanhoNomeGrupo(nomeGrupo)) {
            msg = "Informe um grupo com um nome maior que 4 caracteres";
            validacao = false;
        }

        if (validacao) {
            Grupo g = new Grupo(nomeGrupo, codTurma, codEvento);
            GrupoDAO dao = new GrupoDAO();
            if (dao.inserir(g)) {
                msg = "Grupo Criado com sucesso";
            }

        }

        JOptionPane.showMessageDialog(null, msg);

    }

    public void alterarGrupo(int codGrupo, String nomeGrupo, int codTurma, int codEvento) {//alterar para salvarGrupo
        String msg = "Falha ao alterar período";
        boolean validacao = true;

        if (this.validarCamposObrigatorios(nomeGrupo, codTurma, codEvento)) {
            msg = "Preencha os campos Obrigatórios";
            validacao = false;
        }
        if (validacao) {
            Grupo g = new Grupo(codGrupo, nomeGrupo, codTurma, codEvento);
            GrupoDAO dao = new GrupoDAO();
            if (dao.alterar(g)) {
                msg = "Grupo Alteardo com sucesso";
            }

        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public boolean validarNomeDuplicidade(String nomeGrupo) {//alterar para verificaExistencia
        boolean aux = false;

        GrupoDAO dao = new GrupoDAO();

        if (dao.existeGrupo(nomeGrupo)) {
            aux = true;
        }

        return aux;
    }

    public boolean validarCamposObrigatorios(String nomeGrupo, int codTurma, int codEvento) {
        boolean aux = false;

        if ((nomeGrupo.equalsIgnoreCase("")) || (codTurma == 0) || (codEvento == 0)) {
            aux = true;
        }

        return aux;
    }

    public boolean validarTamanhoNomeGrupo(String nomeGrupo) {//alterar para validarNumCaracteres
        boolean aux = false;

        if (nomeGrupo.length() < 4) {
            aux = true;
        }
        return aux;
    }

}
