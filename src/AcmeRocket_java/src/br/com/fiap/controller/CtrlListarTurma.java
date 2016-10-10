package br.com.fiap.controller;


import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.entity.Periodo;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;


public class CtrlListarTurma {

    public CtrlListarTurma() {
    }
    
    /**
     * Carrega lista de Periodos para preenchimento do combobox
     * @return 
     */
    public ArrayList<Periodo> CarregarRegistrosPeriodo(){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.listar();
    }
    
    /**
     * Carrega a lista de turmas cadastradas
     * @return 
     */
    public ArrayList<Turma> CarregarRegistrosTurmas(){
        TurmaDAO dao = new TurmaDAO();
        return dao.listar();
    }
    
    /**
     * Retorna o nome do periodo atrelado a turma
     * @param turma
     * @return 
     */
    public String obterNomePeriodo(Turma turma){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.buscarNomePeriodo(turma.getCodPeriodo());
    }
    
}
