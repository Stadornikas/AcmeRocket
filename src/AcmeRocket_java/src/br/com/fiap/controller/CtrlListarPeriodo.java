/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.PeriodoDao;
import br.com.fiap.entity.Periodo;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CtrlListarPeriodo {

    public CtrlListarPeriodo() {}
    
    public ArrayList<Periodo> CarregarRegistros(){
        PeriodoDao dao = new PeriodoDao();
        return dao.listar();
    }
    
}
