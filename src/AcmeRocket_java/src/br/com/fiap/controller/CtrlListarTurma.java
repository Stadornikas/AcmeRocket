package br.com.fiap.controller;


import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Periodo;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;


public class CtrlListarTurma {

    public CtrlListarTurma() {
    }
    
    public ArrayList<Periodo> CarregarRegistrosPeriodo(){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.listar();
    }
    
    public ArrayList<Turma> CarregarRegistrosTurmas(){
        TurmaDAO dao = new TurmaDAO();
        return dao.listar();
    }
    

    public String obterNomePeriodo(Turma turma){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.buscarNomePeriodo(turma.getCodPeriodo());
    }
    
}
