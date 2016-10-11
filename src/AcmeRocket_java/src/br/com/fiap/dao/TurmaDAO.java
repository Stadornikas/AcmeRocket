/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

//import br.com.fiap.conexao.Conexao;
import br.com.fiap.connection.Conexao;
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

    private Connection conn;
    private PreparedStatement ps;
    private String sql;
    private ResultSet rs;

    public boolean inserir(Turma turma) {
        boolean aux = false;
        int novoIndex = buscarIndex();

        sql = "INSERT INTO TURMA VALUES (?, ?, ?, ?)";
        conn = Conexao.getConnection();

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, novoIndex);
            ps.setString(2, turma.getNomTurma());
            ps.setString(3, turma.getAnoTurma());
            ps.setInt(4, turma.getCodPeriodo());
            ps.execute();

            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "inserir Turma! \n ERRO:" + e);
        }

        return aux;
    }

    public Turma buscar(int codTurma) {
        Turma Turma = null;
        conn = Conexao.getConnection();
        sql = "SELECT * FROM TURMA WHERE COD_TURMA = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codTurma);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nomTurma = rs.getString("NOM_TURMA");
                String anoTurma = rs.getString("ANO_TURMA");
                int codPeriodo = rs.getInt("PERIODO_COD_PERIODO");
                Turma = new Turma(codTurma, nomTurma, anoTurma, codPeriodo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Turma! \n ERRO:" + ex);
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Turma;
    }

    public boolean alterar(Turma turma) {

        boolean aux = false;

        conn = Conexao.getConnection();
        sql = "UPDATE TURMA SET NOM_TURMA = ?, ANO_TURMA = ?, PERIODO_COD_PERIODO = ? WHERE COD_TURMA = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, turma.getNomTurma());
            ps.setString(2, turma.getAnoTurma());
            ps.setInt(3, turma.getCodPeriodo());
            ps.execute();

            aux = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro alterar Turmas! \n ERRO:" + e);
        }

        return aux;
    }

    public boolean deletar(int codTurma) {

        boolean aux = false;

        conn = Conexao.getConnection();
        sql = "DELETE FROM TURMA WHERE COD_TURMA = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codTurma);
            ps.execute();

            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "deletar Turmas! \n ERRO:" + e);
        }

        return aux;
    }

    public ArrayList<Turma> listar() {

        ArrayList<Turma> lista = new ArrayList();

        conn = Conexao.getConnection();
        sql = "SELECT * FROM TURMA";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

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

    public int buscarIndex() {
        int proximaColuna = 0;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT MAX(COD_TURMA) as max_linhas FROM TURMA";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proximaColuna = rs.getInt("max_linhas") + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar index turma: " + ex);
        }

        return proximaColuna;
    }

    public String buscarNomeTurma(int codigo) {
        String nomeTurma = "";

        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM TURMA WHERE COD_TURMA = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                nomeTurma = rs.getString("NOM_TURMA");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar nome da turma! \n ERROR: " + ex);

        }

        return nomeTurma;
    }

    public int buscarIdComboTurma(String turma) {
        int id = 0;
        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM TURMA WHERE NOM_TURMA = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, turma);

            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("COD_TURMA");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar id da turma! \n ERROR: " + ex);
        }

        return id;

    }

}
