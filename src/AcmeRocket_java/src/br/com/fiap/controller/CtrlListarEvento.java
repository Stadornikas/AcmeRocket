package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.entity.Evento;
import java.util.ArrayList;


public class CtrlListarEvento {
    public CtrlListarEvento() {}
    
    public ArrayList<Evento> carregarRegistros() {
       EventoDAO dao = new EventoDAO();
      return dao.listar();
    }
}
