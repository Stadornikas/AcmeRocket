package br.com.fiap.controller;

import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Periodo;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class CtrlSalvarTurma {

    public CtrlSalvarTurma() {
    }
    
        
    /**
     * Carrega lista de Periodos para preenchimento do combobox
     * @return 
     */
    public ArrayList<Periodo> carregarRegistrosPeriodo(){
        PeriodoDAO dao = new PeriodoDAO();
        return dao.listar();
    }
    
    /**
     * Retorma turma requisitada
     * @param codTurma
     * @return 
     */
    public Turma carregarTurma(int codTurma){
        TurmaDAO dao = new TurmaDAO();
        Turma  t = dao.buscar(codTurma);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Nenhum turma encontrada");
        }
        return t;
    }
    
   //TODO: continuar criando os métodos de validação
}
