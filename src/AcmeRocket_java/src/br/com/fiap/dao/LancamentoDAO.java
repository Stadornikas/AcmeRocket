package br.com.fiap.dao;

import br.com.fiap.connection.Conexao;
import br.com.fiap.entity.Lancamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class LancamentoDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public boolean inserir(Lancamento lancamento) {
        boolean aux = false;

        try {

            conn = Conexao.getConnection();
            sql = "INSERT INTO LANCAMENTO VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareCall(sql);
            ps.setInt(1, lancamento.getCodLancamento());
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
            ps = conn.prepareCall(sql);
            ps.setInt(1, codLancamento);

            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoLancamento = rs.getInt("COD_LANCAMENTO");
                int codGrupo = rs.getInt("GRUPO_COD_GRUPO");
                String horaLancamento = rs.getString("HOR_LANCAMENTO");
                int status = rs.getInt("STATUS");
                float angLancamento = rs.getFloat("AND_LANCAMENTO");
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
                        velVento, disAlvo, pesFoguete, altMax, velMax, temPrp, picAcl, altMax,
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
                int status = rs.getInt("STATUS");
                float angLancamento = rs.getFloat("AND_LANCAMENTO");
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

                lista.add(new Lancamento(codGrupo, horaLancamento, status, angLancamento, velVento,
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
            sql = "UPDATE LANCAMENTO SET(COD_LANCAMENTO = ?, GRUPO_COD_GRUPO = ?, HOR_LANCAMENTO = ?, STATUS = ?, ANG_LANCAMENTO = ?, "
                    + "VEL_VENTO = ?, DIS_ALVO = ?, PES_FOGUTE = ?, ALT_MAX = ?, VEL_MAX = ?, TEM_PRP = ?, PIC_ACL = ?, ACL_MAX = ?, TEM_APDC = ?, "
                    + "TEM_EJE = ?, ALT_EJE = ?, TAX_DES = ?, DUR_VOO = ?, DIS_QUEDA = ?)";
            
            ps = conn.prepareCall(sql);

            ps.setInt(1, lancamento.getCodLancamento());
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
            showMessageDialog(null, "Erro ao alterar lançamento! \n ERRO: " + ex);
        }

        return aux;
    }

}
