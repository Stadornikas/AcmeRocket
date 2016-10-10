package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.entity.Evento;
import java.util.ArrayList;
import java.util.List;

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

}
