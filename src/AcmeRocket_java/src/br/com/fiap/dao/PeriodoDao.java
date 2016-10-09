package br.com.fiap.dao;

import br.com.fiap.connection.Conexao;
import br.com.fiap.entity.Periodo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PeriodoDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    /**
     * busca todos os períodos cadastrados e retorna um ArrayList<Periodo>
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
                int codPeriodo = rs.getInt("COD_PERIODO");
                String nomePeriodo = rs.getString("NOM_PERIODO");
                lista.add(new Periodo(codPeriodo, nomePeriodo));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar periodos! \n ERRO: " + ex);
        }

        return lista;
    }

    /**
     * Remove o período indicado por codPeriodo do banco de dados
     * @param codPeriodo
     * @return 
     */
    public boolean deletar(int codPeriodo) {
        try {
            conn = Conexao.getConnection();
            sql = "DELETE FROM PERIODOS WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar periodos! \n ERRO: " + ex);
        }
        return true;
    }

    /**
     * Persiste um novo período no banco de dados
     * @param periodo 
     * @return boolean
     */
    public boolean inserir(Periodo periodo) {
        boolean sucesso = false;

        try {
            conn = Conexao.getConnection();
            sql = "INSERT INTO PERIODOS VALUES(?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, periodo.getNomPeriodo());
            
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
     * @param codPeriodo
     * @return 
     */
    public Periodo buscar(int codPeriodo) {
        Periodo periodo = null;

        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM PERIODOS WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);
            rs = ps.executeQuery();

            int codigoPeriodo = rs.getInt("COD_PERIODO");
            String nomePeriodo = rs.getString("NOM_PERIODO");

            periodo = new Periodo(codigoPeriodo, nomePeriodo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar periodos! \n ERRO: " + ex);
        }
        return periodo;
    }

    /**
     * Edita um período existe no banco dedos
     * @param periodo 
     */
    public boolean alterar(Periodo periodo) {
        boolean sucesso = false;
        try {
            conn = Conexao.getConnection();
            sql = "UPDATE PERIODOS SET NOM_PERIODO = ? WHERE COD_PERIODO = ?";
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
}
