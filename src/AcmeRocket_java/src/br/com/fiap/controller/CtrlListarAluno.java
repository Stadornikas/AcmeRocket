/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CtrlListarAluno {

    public CtrlListarAluno() {}
    
    public ArrayList<Aluno> CarregarRegistros(){
        AlunoDAO dao = new AlunoDAO();
        return dao.listar();
    }
    
}
