package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.entity.Grupo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlListarGrupo {

    public CtrlListarGrupo() {
    }

    public ArrayList<Grupo> carregarRegistros() {
        GrupoDAO dao = new GrupoDAO();
        return dao.listar();
    }

    public int buscarIdComboGrupo(String codGrupo) {
        int t = 0;
        GrupoDAO dao = new GrupoDAO();
        if (dao.buscarIdComboGrupo(codGrupo) > 0) {
            t = dao.buscarIdComboGrupo(codGrupo);

            if (t == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar id da combo grupo");
            }

        }
        return t;
    }
}
