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
     * Verifica se existe um turma com o mesmo nome
     * @param nomeTurma
     * @return boolean 
     */
    private boolean validarNomeDuplicidade(String nomeTurma){
        TurmaDAO dao = new TurmaDAO();
        //retorna false caso a turma exista no banco dados
        return !dao.existeTurma(nomeTurma); 
    }
    
    /**
     * verifica se o nome foi preenchido
     * @param nomeTurma
     * @return boolean
     */
    public boolean validarCamposObrigatorios(String nomeTurma, String ano, String periodo){
       boolean output = true;
        if((nomeTurma.equalsIgnoreCase("")) || (ano.equalsIgnoreCase("")) || (periodo.equalsIgnoreCase(""))){
         String msg =  "Preencha os campos Obrigatórios";   
         JOptionPane.showMessageDialog(null, msg); 
         output = false;
       }
        return output;
    }
    
    /**
     * Valida se o numero de caracteres no nome da turma é maior que 3 caracateres
     * @param nomeTurma
     * @return 
     */
    private boolean validaNumeroCaracteres(String nomeTurma){
        int qtdStr = nomeTurma.length();
        return (qtdStr > 3);
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
     * @return Turma
     */
    public Turma carregarTurma(int codTurma){
        TurmaDAO dao = new TurmaDAO();
        Turma  t = dao.buscar(codTurma);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Nenhum turma encontrada");
        }
        return t;
    }
    
       
    /**
     * Valida informações e persiste a turma
     * @param nomeTurma
     * @return boolean
     */
    public boolean inserirTurma(String nomeTurma, int anoTurma, String periodo){
        String msg =  "Falha ao inserir turma";
        boolean validacao = true,sucesso = false;
        
        if(!this.validarNomeDuplicidade(nomeTurma)) {
            msg =  "Já existe uma turma com este nome";
            validacao = false;
        }
        
        if(!this.validaNumeroCaracteres(nomeTurma)) {
            msg =  "O nome da turma deve no mínimo 3 caracteres";
            validacao = false;
        }
        
        if (validacao) {
            PeriodoDAO periodoDAO = new PeriodoDAO();
            int codPeriodo = periodoDAO. buscarIdComboPeriodo(periodo);
            Turma t = new Turma(nomeTurma, anoTurma, codPeriodo);
            TurmaDAO dao = new TurmaDAO();
            if(dao.inserir(t)) msg = "Turma Criado com sucesso";
            sucesso = true;
        }
                 
        JOptionPane.showMessageDialog(null, msg);     
        return sucesso;
    }
    
    /**
     * Valida dados e modifica o periodo
     * @param codPeriodo
     * @return boolean
     */
    public boolean alterarTurma(int codTurma, String nomeTurma, int ano, String nomePeriodo){
        String msg = "Falha ao alterar turma";
        boolean validacao = true, sucesso = false;
        
        
        if(!this.validarNomeDuplicidade(nomeTurma)) {
            msg =  "Já existe uma turma com este nome";
            validacao = false;
        }  
        
        if(!this.validaNumeroCaracteres(nomeTurma)) {
            msg =  "O nome da turma deve no mínimo 3 caracteres";
            validacao = false;
        }
        
        if (validacao) {
            PeriodoDAO periodoDAO = new PeriodoDAO();
            int codPeriodo = periodoDAO. buscarIdComboPeriodo(nomePeriodo);
            Turma t = new Turma(codTurma, nomeTurma, ano, codPeriodo);
            TurmaDAO dao = new TurmaDAO();
            if(dao.alterar(t)) msg = "Turma Alterado com sucesso";
            sucesso = true;
        }
                  
        JOptionPane.showMessageDialog(null, msg);  
        return sucesso;
    }
    
}
