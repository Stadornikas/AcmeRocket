package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.entity.Lancamento;
import br.com.fiap.entity.Ranking;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class LancamentoDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public boolean inserir(Lancamento lancamento) {
        boolean aux = false;
        int MaxId = buscarMaxId();
        try {

            conn = Conexao.getConnection();
            sql = "INSERT INTO LANCAMENTO VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, MaxId);
            ps.setInt(2, lancamento.getCodGrupo());
            ps.setString(3, lancamento.getHorLancamento());
            ps.setInt(4, lancamento.getStatus());
            ps.setFloat(5, lancamento.getAngLancamento());
            ps.setFloat(6, lancamento.getVelVento());
            ps.setFloat(7, lancamento.getDisAlvo());
            ps.setFloat(8, lancamento.getPesFoguete());
            ps.setFloat(9, lancamento.getAltMax());
            ps.setFloat(10, lancamento.getVelMax());
            ps.setFloat(11, lancamento.getTemPrp());
            ps.setFloat(12, lancamento.getPicAcl());
            ps.setFloat(13, lancamento.getAlcMax());
            ps.setFloat(14, lancamento.getTemApdc());
            ps.setFloat(15, lancamento.getTemEje());
            ps.setFloat(16, lancamento.getAltEje());
            ps.setFloat(17, lancamento.getTaxDes());
            ps.setFloat(18, lancamento.getDurVoo());
            ps.setFloat(19, lancamento.getDisQueda());

            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao inserir lançamento! \n ERRO: " + ex);
        }

        return aux;

    }

    public boolean deletar(int codLancamento) {
        boolean aux = false;

        try {

            conn = Conexao.getConnection();
            sql = "DELETE FROM LANCAMENTO WHERE COD_LANCAMENTO = ?";
            ps = conn.prepareCall(sql);
            ps.setInt(1, codLancamento);
            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao deletar lançamento! \n ERRO: " + ex);
        }

        return aux;
    }

    public Lancamento buscar(int codLancamento) {
        Lancamento lancamento = null;

        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM LANCAMENTO WHERE COD_LANCAMENTO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codLancamento);

            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoLancamento = rs.getInt("COD_LANCAMENTO");
                int codGrupo = rs.getInt("GRUPO_COD_GRUPO");
                String horaLancamento = rs.getString("HOR_LANCAMENTO");
                int status = rs.getInt("STATUS_LANC");
                float angLancamento = rs.getFloat("ANG_LANCAMENTO");
                float velVento = rs.getFloat("VEL_VENTO");
                float disAlvo = rs.getFloat("DIS_ALVO");
                float pesFoguete = rs.getFloat("PES_FOGUETE");
                float altMax = rs.getFloat("ALT_MAX");
                float velMax = rs.getFloat("VEL_MAX");
                float temPrp = rs.getFloat("TEM_PRP");
                float picAcl = rs.getFloat("PIC_ACL");
                float aclMax = rs.getFloat("ACL_MAX");
                float temApdc = rs.getFloat("TEM_APDC");
                float temEje = rs.getFloat("TEM_EJE");
                float altEje = rs.getFloat("ALT_EJE");
                float taxDes = rs.getFloat("TAX_DES");
                float durVoo = rs.getFloat("DUR_VOO");
                float disQueda = rs.getFloat("DIS_QUEDA");

                lancamento = new Lancamento(codGrupo, horaLancamento, status, angLancamento,
                        velVento, disAlvo, pesFoguete, altMax, velMax, temPrp, picAcl, aclMax,
                        temApdc, temEje, altEje, taxDes, durVoo, disQueda);
            }

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao buscar lançamento! \n ERRO: " + ex);
        }

        return lancamento;
    }

    public ArrayList<Lancamento> listar() {

        ArrayList<Lancamento> lista = new ArrayList();

        try {
            conn = Conexao.getConnection();
            sql = "SELECT * FROM LANCAMENTO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoLancamento = rs.getInt("COD_LANCAMENTO");
                int codGrupo = rs.getInt("GRUPO_COD_GRUPO");
                String horaLancamento = rs.getString("HOR_LANCAMENTO");
                int status = rs.getInt("STATUS_LANC");
                float angLancamento = rs.getFloat("ANG_LANCAMENTO");
                float velVento = rs.getFloat("VEL_VENTO");
                float disAlvo = rs.getFloat("DIS_ALVO");
                float pesFoguete = rs.getFloat("PES_FOGUETE");
                float altMax = rs.getFloat("ALT_MAX");
                float velMax = rs.getFloat("VEL_MAX");
                float temPrp = rs.getFloat("TEM_PRP");
                float picAcl = rs.getFloat("PIC_ACL");
                float aclMax = rs.getFloat("ACL_MAX");
                float temApdc = rs.getFloat("TEM_APDC");
                float temEje = rs.getFloat("TEM_EJE");
                float altEje = rs.getFloat("ALT_EJE");
                float taxDes = rs.getFloat("TAX_DES");
                float durVoo = rs.getFloat("DUR_VOO");
                float disQueda = rs.getFloat("DIS_QUEDA");

                lista.add(new Lancamento(codigoLancamento, codGrupo, horaLancamento, status, angLancamento, velVento,
                        disAlvo, pesFoguete, altMax, velMax, temPrp, picAcl, altMax, temApdc, temEje,
                        altEje, taxDes, durVoo, disQueda));
            }

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao listar lançamento! \n ERRO: " + ex);
        }

        return lista;

    }

//    Aqui primeiro listar e depois alterar
    public boolean alterar(Lancamento lancamento) {
        boolean aux = false;

        try {
            conn = Conexao.getConnection();
            sql = "UPDATE LANCAMENTO SET GRUPO_COD_GRUPO = ?, HOR_LANCAMENTO = ?, STATUS_LANC = ?, ANG_LANCAMENTO = ?, "
                    + "VEL_VENTO = ?, DIS_ALVO = ?, PES_FOGUETE = ?, ALT_MAX = ?, VEL_MAX = ?, TEM_PRP = ?, PIC_ACL = ?,"
                    + " ACL_MAX = ?, TEM_APDC = ?, TEM_EJE = ?, ALT_EJE = ?, TAX_DES = ?, DUR_VOO = ?, DIS_QUEDA = ? WHERE COD_LANCAMENTO = ?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, lancamento.getCodGrupo());
            ps.setString(2, lancamento.getHorLancamento());
            ps.setInt(3, lancamento.getStatus());
            ps.setFloat(4, lancamento.getAngLancamento());
            ps.setFloat(5, lancamento.getVelVento());
            ps.setFloat(6, lancamento.getDisAlvo());
            ps.setFloat(7, lancamento.getPesFoguete());
            ps.setFloat(8, lancamento.getAltMax());
            ps.setFloat(9, lancamento.getVelMax());
            ps.setFloat(10, lancamento.getTemPrp());
            ps.setFloat(11, lancamento.getPicAcl());
            ps.setFloat(12, lancamento.getAlcMax());
            ps.setFloat(13, lancamento.getTemApdc());
            ps.setFloat(14, lancamento.getTemEje());
            ps.setFloat(15, lancamento.getAltEje());
            ps.setFloat(16, lancamento.getTaxDes());
            ps.setFloat(17, lancamento.getDurVoo());
            ps.setFloat(18, lancamento.getDisQueda());
            ps.setInt(19, lancamento.getCodLancamento());

            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao alterar lançamento! \n ERRO: " + ex);
        }

        return aux;
    }

    public int buscarMaxId() {
        int proximaColuna = 0;
        try {
            conn = Conexao.getConnection();
            sql = "SELECT MAX(COD_LANCAMENTO) max_linhas FROM LANCAMENTO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                proximaColuna = rs.getInt("max_linhas") + 1;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar index lancamento: " + ex);
        }

        return proximaColuna;
    }

    public ArrayList<Ranking> buscarRanking() {

        ArrayList<Ranking> lista = new ArrayList();

        try {
            conn = Conexao.getConnection();
            sql = "SELECT grup.`NOM_GRUPO`, even.`DAT_EVENTO`, lanc.`DIS_QUEDA`, lanc.`VEL_MAX`, lanc.`ALT_MAX`, lanc.`HOR_LANCAMENTO`  "
                    + "FROM `LANCAMENTO` as lanc "
                    + "INNER JOIN `GRUPO` as grup ON lanc.`GRUPO_COD_GRUPO` = grup.`COD_GRUPO` "
                    + "INNER JOIN `EVENTOS` as even ON grup.`EVENTOS_COD_EVENTO` = even.`COD_EVENTO` "
                    + "WHERE lanc.`STATUS_LANC` = 2 "
                    + "ORDER BY lanc.`DIS_QUEDA` DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nomeGrupo = rs.getString("NOM_GRUPO");
                Date dataEvento = rs.getDate("DAT_EVENTO");
                String horaLancamento = rs.getString("HOR_LANCAMENTO");
                float altMax = rs.getFloat("ALT_MAX");
                float velMax = rs.getFloat("VEL_MAX");
                float disQueda = rs.getFloat("DIS_QUEDA");

                lista.add(new Ranking(nomeGrupo, dataEvento, disQueda, velMax, altMax, horaLancamento));
            }

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao buscar ranking! \n ERRO: " + ex);
        }

        return lista;
    }

    public String buscarNomeGrupo(int codigo) {
        String nomeGrupo = "";

        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM GRUPO WHERE COD_GRUPO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            while (rs.next()) {
                nomeGrupo = rs.getString("NOM_GRUPO");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar nome do grupo! \n ERROR: " + ex);

        }

        return nomeGrupo;
    }

}
