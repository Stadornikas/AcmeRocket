package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PeriodoDao {
    private Connection          conn;
    private PreparedStatement   ps;
    private ResultSet           rs;
    private String              sql;
    private String              msg = "Erro ao ";
    
    /*public ArrayList listar(){
        ArrayList<Periodo> lista = new ArrayList();
        
        try {
            conn = Conexao.getConnection();
            sql  = "SELECT * FROM PERIODO";
            ps   = conn.prepareStatement(sql);
            rs   = ps.executeQuery();
            
            while (rs.next()) {                
                int codPeriodo = rs.getInt("COD_PERIODO");
                String nomePeriodo = rs.getString("NOM_PERIODO");
                lista.add(new Periodo(codPeriodo, nomePeriodo));
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "listar periodos! \n ERRO: "+ex);
        }
        
        return lista;
    }
    
    public boolean deletar(int codPeriodo) {
        try {
            conn    = Conexao.getConnection();
            sql     = "DELETE FROM PERIODOS WHERE COD_PERIODO = ?";
            ps      = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "deletar periodos! \n ERRO: "+ex);
        }
        return true;
    }
    
    public void inserir(Periodo periodo) {
        try {
            conn    = Conexao.getConnection();
            sql     = "INSERT INTO PERIODOS VALUES(?)";
            ps      = conn.prepareStatement(sql);
            
            ps.setString(1, periodo.getNomePeriodo());
            ps.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "inserir periodos! \n ERRO: "+ex);
        }
    }
    
    public Periodo buscar(int codPeriodo) {
        try {
            conn    = Conexao.getConnection();
            sql     = "SELECT * FROM PERIODOS WHERE COD_PERIODO = ?";
            ps      = conn.prepareStatement(sql);
            ps.setInt(1, codPeriodo);
            rs      = ps.executeQuery();
            
            int     codigoPeriodo = rs.getInt("COD_PERIODO");
            String nomePeriodo = rs.getString("NOM_PERIODO");
            
            periodo = new Periodo(codigoPeriodo, nomePeriodo);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "buscar periodos! \n ERRO: "+ex);
        }
        return periodo;
    }
    
    public void alterar(Periodo periodo) {
        try {
            conn = Conexao.getConnection();
            sql = "UPDATE PERIODOS SET NOM_PERIODO = ? WHERE COD_PERIODO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, periodo.getNomePeriodo());
            ps.setInt(2, periodo.getCodigoPeriodo());
            ps.execute();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "alterar periodo! \n ERRO: "+ex);
        }
    }*/
}
