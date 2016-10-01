/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.entity.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class PeriodoDAO {
    
    private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;

    public boolean inserir(Periodo periodo) {
        boolean aux = false;
        
        sql = "INSERT INTO PERIODO VALUES (?, ?)";
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, periodo.getCodPeriodo());
            p.setString(2, periodo.getNomPeriodo());
            p.execute();
            
            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "inserir periodo! \n ERRO:" + e);
        } 
        
        return aux;
    }

    public Periodo buscar(int codPeriodo) {
        Periodo Periodo = null;
        connection = Conexao.getConnection();
        sql = "SELECT * FROM PERIODO WHERE COD_PERIODO = ?";

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codPeriodo);
            rs = p.executeQuery();
            while (rs.next()) {
                String nomPeriodo = rs.getString("NUM_PERIODO");
                Periodo = new Periodo(codPeriodo, nomPeriodo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeriodoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Periodo;
    }

    public boolean alterar(Periodo periodo) {
        
        boolean aux = false;
        
        connection = Conexao.getConnection();
        sql = "UPDATE PERIODO SET NOM_PERIODO = ? WHERE COD_PERIODO = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, periodo.getNomPeriodo());
            p.execute();
            
            aux = true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "alterar periodo! \n ERRO:" + e);
        }
        
        return aux;
    }

    public boolean deletar(int codPeriodo) {
        
        boolean aux = false;
        
        connection = Conexao.getConnection();
        sql = "DELETE FROM PERIODO WHERE COD_PERIODO = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codPeriodo);
            p.execute();
            
            aux  = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "deletar periodo! \n ERRO:" + e);
        }
        
        return aux;
    }

    public ArrayList<Periodo> listar() {

        ArrayList<Periodo> lista = new ArrayList();

        connection = Conexao.getConnection();
        sql = "SELECT * FROM PERIODO";
        
        try {
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int codPeriodo = rs.getInt("COD_PERIODO");
                String nomPeriodo = rs.getString("NOM_PERIODO");

                lista.add(new Periodo(codPeriodo, nomPeriodo));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"listar periodo! \n ERRO: " + e);
        }
        
        return lista;
        
    }
    
}
