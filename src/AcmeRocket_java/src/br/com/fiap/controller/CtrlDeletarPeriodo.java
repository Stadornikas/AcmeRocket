/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class CtrlDeletarPeriodo {

    public CtrlDeletarPeriodo() {
    }
 
    public boolean ValidarDependecia(){
        return true;
    }
    
    public boolean ConfirmaExclusao(){
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o perído?") == 0) {
            out = true;
        }
        return out;
    }
}
