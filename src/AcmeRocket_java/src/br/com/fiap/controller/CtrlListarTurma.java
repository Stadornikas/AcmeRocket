package br.com.fiap.controller;

import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;

public class CtrlListarTurma {
    
    public CtrlListarTurma() {}
    
    public ArrayList<Turma> CarregarRegistros(){
        TurmaDAO dao = new TurmaDAO();
        return dao.listar();
    }
}
