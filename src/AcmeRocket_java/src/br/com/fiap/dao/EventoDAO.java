package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.fiap.conexao.Conexao;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

public class EventoDAO {
    private Connection          conn;
    private PreparedStatement   ps;
    private ResultSet           rs;
    private String              sql;
    private String              msg = "Erro ao ";
    
    
    public ArrayList listar(){
        ArrayList<Evento> lista = new ArrayList();
        
        try {
            conn = Conexao.getConnection();
            sql  = "SELECT * FROM EVENTO";
            ps   = conn.prepareStatement(sql);
            rs   = ps.executeQuery();
            
            while (rs.next()) {                
                int codEvento = rs.getInt("COD_EVENTO");
                String nomeEvento = rs.getString("NOM_EVENTO");
                String localEvento  = rs.getString("LOC_EVENTO");
                Date   datEvento  = rs.getDate("DAT_EVENTO");
                lista.add(new Evento(nomeEvento, localEvento, datEvento));
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "listar eventos! \n ERRO: "+ex);
        }
        return lista;
    }
    
    public boolean deletar(int codEvento) {
        try {
            conn    = Conexao.getConnection();
            sql     = "DELETE FROM EVENTOS WHERE COD_EVENTO = ?";
            ps      = conn.prepareStatement(sql);
            ps.setInt(1, codEvento);
            
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "deletar eventos! \n ERRO: "+ex);
        }
        return true;
    }
    
    public void inserir(Evento evento) {
        try {
            conn    = Conexao.getConnection();
            sql     = "INSERT INTO EVENTOS VALUES(?, ?, ?)";
            ps      = conn.prepareStatement(sql);
            
            ps.setString(1, evento.getNomeEvento());
            ps.setString(2, evento.getLocEvento());
            ps.setDate(3, evento.getDateEvento());
            ps.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "inserir eventos! \n ERRO: "+ex);
        }
    }
    
    public Evento buscar(int codEvento) {
        try {
            conn    = Conexao.getConnection();
            sql     = "SELECT * FROM EVENTOS WHERE COD_EVENTO = ?";
            ps      = conn.prepareStatement(sql);
            ps.setInt(1, codEvento);
            rs      = ps.executeQuery();
            
            String nomeEvento = rs.getString("NOM_EVENTO");
            String localEvento = rs.getString("LOC_EVENTO");
            Date   dataEvento = rs.getDate("DAT_EVENTO");
            
            evento = new Evento(nomeEvento, localEvento, dataEvento);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "buscar evento! \n ERRO: "+ex);
        }
        return evento;
    }
    
    public void alterar(Evento evento) {
        try {
            conn = Conexao.getConnection();
            sql = "UPDATE EVENTOS SET NOM_EVENTO = ?, LOC_EVENTO = ?, DAT_EVENTO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getNomeevento());
            ps.setString(2, evento.getLocalEvento());
            ps.setDate(3, evento.getDataEvento());
            ps.execute();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, msg + "alterar evento! \n ERRO: "+ex);
        }
    }
}
