/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.TurmaDAO;
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

    public ArrayList<Turma> carregarRegistrosTurma(){
        TurmaDAO dao = new TurmaDAO();
        return dao.listar();
    }
    
    public Turma carregarTurma(int codTurma){
        TurmaDAO dao = new TurmaDAO();
        Turma  t = dao.buscar(codTurma);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Nenhum turma encontrada");
        }
        return t;
    }
    
}
