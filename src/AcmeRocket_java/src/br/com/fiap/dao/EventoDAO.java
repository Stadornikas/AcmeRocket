package br.com.fiap.dao;

import br.com.fiap.connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.fiap.entity.Evento;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;

public class EventoDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    

    public ArrayList listar() {
        ArrayList<Evento> lista = new ArrayList();

        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM EVENTO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codEvento = rs.getInt("COD_EVENTO");
                String nomeEvento = rs.getString("NOM_EVENTO");
                String localEvento = rs.getString("LOC_EVENTO");
                Date datEvento = rs.getDate("DAT_EVENTO");
                lista.add(new Evento(nomeEvento, localEvento, datEvento));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar eventos! \n ERRO: " + ex);
        }
        return lista;
    }

    public boolean deletar(int codEvento) {
        try {
            conn = Conexao.getConnection();
            sql = "DELETE FROM EVENTOS WHERE COD_EVENTO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codEvento);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar eventos! \n ERRO: " + ex);
        }
        return true;
    }

    public void inserir(Evento evento) {
        try {
            conn = Conexao.getConnection();
            sql = "INSERT INTO EVENTOS COLUMN(NOM_EVENTO, LOC_EVENTO, DAT_EVENTO) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, evento.getNomEvento());
            ps.setString(2, evento.getLocEvento());
            ps.setDate(3, evento.getDatEvento());
            ps.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir eventos! \n ERRO: " + ex);
        }
    }
    
    public int buscarIndex() {
        int proximaColuna = 0;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT COUNT(*) colunas FROM EVENTOS";
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            proximaColuna = rs.getInt("colunas");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar evento! \n ERRO: " + ex);
        }
        return proximaColuna;
    }

    public Evento buscar(int codEvento) {
        Evento evento = null;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM EVENTOS WHERE COD_EVENTO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codEvento);
            rs = ps.executeQuery();

            String nomeEvento = rs.getString("NOM_EVENTO");
            String localEvento = rs.getString("LOC_EVENTO");
            Date dataEvento = rs.getDate("DAT_EVENTO");

            evento = new Evento(nomeEvento, localEvento, dataEvento);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar evento! \n ERRO: " + ex);
        }
        return evento;
    }

    public void alterar(Evento evento) {
        try {
            conn = Conexao.getConnection();
            sql = "UPDATE EVENTOS SET NOM_EVENTO = ?, LOC_EVENTO = ?, DAT_EVENTO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, evento.getNomEvento());
            ps.setString(2, evento.getLocEvento());
            ps.setDate(3, evento.getDatEvento());
            ps.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar evento! \n ERRO: " + ex);
        }
    }
}
