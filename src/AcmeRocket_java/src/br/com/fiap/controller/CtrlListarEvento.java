package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.entity.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlListarEvento {

    public CtrlListarEvento() {
    }

    public ArrayList<Evento> carregarRegistros() {
        EventoDAO dao = new EventoDAO();
        return dao.listar();
    }

    public List<Evento> carregarCombos() {

        List<Evento> listaEvento = new ArrayList();

        EventoDAO daoEvento = new EventoDAO();
        listaEvento = daoEvento.listar();

        return listaEvento;

    }

    public int buscarIdComboEvento(String codEvento) {
        int e = 0;

        EventoDAO dao = new EventoDAO();
        e = dao.buscarIdComboEvento(codEvento);
        if (e == 0) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar id da combo evento");
        }

        return e;
    }

}
