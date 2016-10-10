/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.entity.Periodo;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CtrlListarPeriodo {

    public CtrlListarPeriodo() {}
    
    public ArrayList<Periodo> CarregarRegistros(){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.listar();
    }
    
}
