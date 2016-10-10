package br.com.fiap.dao;

import br.com.fiap.connection.Conexao;
import br.com.fiap.entity.Periodo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PeriodoDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    /**
     * busca todos os períodos cadastrados e retorna um ArrayList<Periodo>
     *
     * @return
     */
    public ArrayList<Periodo> listar() {
        ArrayList<Periodo> lista = new ArrayList();

        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Periodo(rs.getInt("COD_PERIODO"), rs.getString("NOM_PERIODO")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar periodos! \n ERRO: " + ex);
        }

        return lista;
    }

    /**
     * Remove o período indicado por codPeriodo do banco de dados
     *
     * @param codPeriodo
     * @return
     */
    public boolean deletar(int codPeriodo) {
        try {
            conn = Conexao.getConnection();
            sql = "DELETE FROM PERIODO WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar periodos! \n ERRO: " + ex);
        }
        return true;
    }

    /**
     * Persiste um novo período no banco de dados
     *
     * @param periodo
     * @return boolean
     */
    public boolean inserir(Periodo periodo) {
        boolean sucesso = false;
        int MaxId = buscarMaxId();

        if (MaxId <= 0) {
            return false;
        }

        try {
            conn = Conexao.getConnection();
            sql = "INSERT INTO PERIODO (COD_PERIODO, NOM_PERIODO) VALUES(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, MaxId);
            ps.setString(2, periodo.getNomPeriodo());
            ps.execute();
            sucesso = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir periodos! \n ERRO: " + ex);
            return false;
        }

        return sucesso;

    }

    /**
     * Retora o Período indicado por codPeriodo
     *
     * @param codPeriodo
     * @return
     */
    public Periodo buscar(int codPeriodo) {
        Periodo periodo = null;

        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoPeriodo = rs.getInt("COD_PERIODO");
                String nomePeriodo = rs.getString("NOM_PERIODO");
                periodo = new Periodo(codigoPeriodo, nomePeriodo);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar periodos! \n ERRO: " + ex);
        }
        return periodo;
    }

    /**
     * Edita um período existe no banco dedos
     *
     * @param periodo
     */
    public boolean alterar(Periodo periodo) {
        boolean sucesso = false;
        try {
            conn = Conexao.getConnection();
            sql = "UPDATE PERIODO SET NOM_PERIODO = ? WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, periodo.getNomPeriodo());
            ps.setInt(2, periodo.getCodPeriodo());
            ps.execute();
            sucesso = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar periodo! \n ERRO: " + ex);
        }
        return sucesso;
    }

    /**
     * Busca o ultimo maior valor de id e incrementa + 1
     *
     * @return int
     */
    public int buscarMaxId() {
        int proximaColuna = 0;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT MAX(COD_PERIODO) max_linhas FROM PERIODO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                proximaColuna = rs.getInt("max_linhas") + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar index: " + ex);
        }

        return proximaColuna;
    }

    public boolean existePeriodo(String nomePeriodo) {
        Periodo p = null;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO WHERE NOM_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nomePeriodo);
            rs = ps.executeQuery();

            while (rs.next()) {
                p = new Periodo(rs.getInt("COD_PERIODO"), rs.getString("NOM_PERIODO"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar maior cod periodo: " + ex);
        }

        return (p != null);

    }

    public String buscarNomePeriodo(int codigo) {
        String nomePeriodo = "";

        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            while (rs.next()) {
                nomePeriodo = rs.getString("NOM_PERIODO");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar nome da periodo! \n ERROR: " + ex);

        }

        return nomePeriodo;
    }

    public int buscarIdComboPeriodo(String periodo) {
        int id = 0;
        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODO WHERE NOM_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, periodo);

            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("COD_PERIODO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar id do periodo! \n ERROR: " + ex);
        }

        return id;

    }

}
