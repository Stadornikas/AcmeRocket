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
     * Verifica se existe um periodo com o mesmo nome
     * @param nomeTurma
     * @return boolean 
     */
    private boolean validarNomeDuplicidade(String nomeTurma){
        TurmaDAO dao = new TurmaDAO();
        //retorna false caso o periodo exista no banco dados
//        return !dao.existeTurma(nomeTurma); 
return true;
//TODO : CONTINUAR
    }
    
    /**
     * verifica se o nome foi preenchido
     * @param nomeTurma
     * @return boolean
     */
    private boolean validarCamposObrigatorios(String nomeTurma){
        return !(nomeTurma.equalsIgnoreCase(""));
    }
    
    /**
     * Valida se o numero de caracteres no nome da turma é maior que 3 caracateres
     * @param nomeTurma
     * @return 
     */
    private boolean validaNumeroCaracteres(String nomeTurma){
        return !(nomeTurma.length() > 3);
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
    
       
    /**
     * Valida informações e persiste o periodo
     * @param nomeTurma
     * @return boolean
     */
    public void inserirTurma(String nomeTurma, String anoTurma, int codPeriodo){
        String msg =  "Falha ao inserir turma";
        boolean validacao = true;
        
        if (!this.validarCamposObrigatorios(nomeTurma)) {
            msg =  "Preencha os campos Obrigatórios";
            validacao = false;
        }
        
        if(!this.validarNomeDuplicidade(nomeTurma)) {
            msg =  "Já existe uma turma com este nome";
            validacao = false;
        }
        
        if(!this.validaNumeroCaracteres(nomeTurma)) {
            msg =  "O nome da turma deve no mínimo 3 caracteres";
            validacao = false;
        }
        
        if (validacao) {
            Turma t = new Turma(nomeTurma, anoTurma, codPeriodo);
            TurmaDAO dao = new TurmaDAO();
            if(dao.inserir(t)) msg = "Turma Criado com sucesso";
            
        }
                 
        JOptionPane.showMessageDialog(null, msg);     
           
    }
    
    /**
     * Valida dados e modifica o periodo
     * @param codPeriodo
     * @return 
     */
    public void alterarTurma(int codPeriodo,String nomeTurma){
        String msg = "Falha ao alterar turma";
        boolean validacao = true;
        
        if (!this.validarCamposObrigatorios(nomeTurma)) {
            msg =  "Preencha os campos Obrigatórios";
            validacao = false;
        }
        
        if (validacao) {
            Periodo p = new Periodo(codPeriodo, nomeTurma);
            PeriodoDAO dao = new PeriodoDAO();
            if(dao.alterar(p)) msg = "Turma Alteardo com sucesso";
            
        }
                  
        JOptionPane.showMessageDialog(null, msg);  
    }
    
}
