/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.LancamentoDAO;
import br.com.fiap.entity.Ranking;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CtrlListarRanking {

    public CtrlListarRanking() {
    }
    
    public ArrayList<Ranking> listarRanking(){
        LancamentoDAO dao = new LancamentoDAO();
        return dao.buscarRanking();
    }
}
