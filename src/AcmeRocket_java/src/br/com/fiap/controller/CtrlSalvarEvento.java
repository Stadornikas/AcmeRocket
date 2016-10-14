/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.entity.Evento;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author nagat
 */
public class CtrlSalvarEvento {

    public CtrlSalvarEvento() {
    }

    public boolean validarNumCaracteres() {
        boolean sucesso = false;
        return sucesso;
    }

    public boolean verificarExistencia(String nomeEvento) {
        
        boolean aux = false;

        EventoDAO dao = new EventoDAO();

        if (dao.existeEvento(nomeEvento)) {
            aux = true;
        }

        return aux;
    }

    public boolean inserirEvento(String nomeEvento, String locEvento, String dataEvento) {
        Date datEventoFormated = validarData(dataEvento);
        Evento novoEvento = new Evento(nomeEvento, locEvento, datEventoFormated);
        boolean sucesso = false;

        EventoDAO eventoDAO = new EventoDAO();

        if (eventoDAO.inserir(novoEvento)) {
            sucesso = true;
        }

        return sucesso;
    }

    public void editarEvento(int codEvento, String nomeEvento, String locEvento, String dataEvento) {
        String msg = "Falha ao alterar evento";
        Date datEventoFormated = validarData(dataEvento);
        Evento novoEvento = new Evento(codEvento, nomeEvento, locEvento, datEventoFormated);

        EventoDAO eventoDAO = new EventoDAO();

        if (eventoDAO.alterar(novoEvento)) {
            JOptionPane.showMessageDialog(null, "Evento alterado com sucesso!");
        }
    }

    private Date validarData(String dataEvento) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        java.util.Date dataEventoDate = new Date(0);
        Date datEventoFormated = new Date(0);
        try {
            dataEventoDate = format.parse(dataEvento);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data não foi convertida com sucesso.");
        }
        datEventoFormated = new Date(dataEventoDate.getTime());

        return datEventoFormated;
    }

    public Evento carregarEvento(int codEvento) {
        EventoDAO dao = new EventoDAO();
        Evento e = dao.buscar(codEvento);
        if (e == null) {
            JOptionPane.showMessageDialog(null, "Nenhum evento encontrado");
        }

        return e;
    }
}
