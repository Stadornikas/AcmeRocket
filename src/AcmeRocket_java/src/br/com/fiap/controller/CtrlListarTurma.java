package br.com.fiap.controller;


import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.entity.Periodo;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CtrlListarTurma {

    public CtrlListarTurma() {
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
    
      public int buscarIdComboTurma(String codTurma) {
        int t = 0;
        TurmaDAO dao = new TurmaDAO();
        t = dao.buscarIdComboTurma(codTurma);
        if (t == 0) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar id da combo turma");
        }
        return t;
    }

}
