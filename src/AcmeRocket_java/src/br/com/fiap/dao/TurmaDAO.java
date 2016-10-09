/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.entity.Turma;
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
public class TurmaDAO {

    private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;

    public boolean inserir(Turma turma) {
        boolean aux = false;
        int novoIndex = buscarIndex();

        sql = "INSERT INTO TURMA VALUES (?, ?, ?, ?)";
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, novoIndex);
            p.setString(2, turma.getNomTurma());
            p.setString(3, turma.getAnoTurma());
            p.setInt(4, turma.getCodPeriodo());
            p.execute();

            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "inserir Turma! \n ERRO:" + e);
        }

        return aux;
    }

    public Turma buscar(int codTurma) {
        Turma Turma = null;
        connection = Conexao.getConnection();
        sql = "SELECT * FROM TURMA WHERE COD_TURMA = ?";

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codTurma);
            rs = p.executeQuery();
            while (rs.next()) {
                String nomTurma = rs.getString("NUM_TURMA");
                String anoTurma = rs.getString("ANO_TURMA");
                int codPeriodo = rs.getInt("PERIODO_COD_PERIODO");
                Turma = new Turma(codTurma, nomTurma, anoTurma, codPeriodo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Turma;
    }

    public boolean alterar(Turma turma) {

        boolean aux = false;

        connection = Conexao.getConnection();
        sql = "UPDATE TURMA SET NOM_TURMA = ?, ANO_TURMA = ?, PERIODO_COD_PERIODO = ? WHERE COD_TURMA = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, turma.getNomTurma());
            p.setString(2, turma.getAnoTurma());
            p.setInt(3, turma.getCodPeriodo());
            p.execute();

            aux = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "alterar Turmas! \n ERRO:" + e);
        }

        return aux;
    }

    public boolean deletar(int codTurma) {

        boolean aux = false;

        connection = Conexao.getConnection();
        sql = "DELETE FROM TURMA WHERE COD_TURMA = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codTurma);
            p.execute();

            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "deletar Turmas! \n ERRO:" + e);
        }

        return aux;
    }

    public ArrayList<Turma> listar() {

        ArrayList<Turma> lista = new ArrayList();

        connection = Conexao.getConnection();
        sql = "SELECT * FROM TURMA";

        try {
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int codTurma = rs.getInt("COD_TURMA");
                String nomTurma = rs.getString("NOM_TURMA");
                String anoTurma = rs.getString("ANO_TURMA");
                int codPeriodo = rs.getInt("PERIODO_COD_PERIODO");

                lista.add(new Turma(codTurma, nomTurma, anoTurma, codPeriodo));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar Turmas! \n ERRO: " + e);
        }

        return lista;

    }

    public int buscarIdCombo(String periodo) {
        int id = 0;
        try {

            connection = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO WHERE NOM_PERIODO = ?";
            p = connection.prepareStatement(sql);
            p.setString(1, periodo);

            rs = p.executeQuery();
//            id = rs.getInt("COD_PERIODO");
            while (rs.next()) {
                id = rs.getInt("COD_PERIODO");
            }
        } catch (SQLException ex) {

        }

        return id;

    }

    public int buscarIndex() {
        int proximaColuna = 0;
        try {
            connection = Conexao.getConnection();
            sql = "SELECT MAX(COD_TURMA) as max_linhas FROM TURMA";

            p = connection.prepareStatement(sql);
            rs = p.executeQuery();
            while (rs.next()) {
                proximaColuna = rs.getInt("max_linhas") + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar index turma: " + ex);
        }

        return proximaColuna;
    }

}
