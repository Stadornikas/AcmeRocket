package br.com.fiap.dao;

import br.com.fiap.connection.Conexao;
import br.com.fiap.entity.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.*;

public class GrupoDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public boolean inserir(Grupo grupo) {
        boolean aux = false;
        try {

            conn = Conexao.getConnection();
            sql = "INSERT INTO GRUPO VALUES(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, grupo.getCodGrupo());
            ps.setString(2, grupo.getNomGrupo());
            ps.setInt(3, grupo.getCodTurma());
            ps.setInt(4, grupo.getCodEvento());

            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao inserir grupo! \n ERRO:" + ex);
        }
        return aux;
    }

    public boolean alterar(Grupo grupo) {

        boolean aux = false;

        try {

            conn = Conexao.getConnection();
            sql = "UPDATE GRUPO SET (NOM_GRUPO = ?, TURMA_COD_TURMA = ?, EVENTOS_COD_EVENTO) WHERE COD_GRUPO = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, grupo.getNomGrupo());
            ps.setInt(2, grupo.getCodTurma());
            ps.setInt(3, grupo.getCodEvento());
            ps.setInt(4, grupo.getCodGrupo());

            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao ao alterar grupo! \n ERRO: " + ex);
        }

        return aux;
    }

    public boolean deletar(int codGrupo) {
        boolean aux = false;

        try {

            conn = Conexao.getConnection();
            sql = "DELETE FROM GRUPO WHERE COD_GRUPO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codGrupo);

            ps.execute();

            aux = true;

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao deletar grupo! \n ERRO: " + ex);
        }

        return aux;
    }

    public Grupo buscar(int codGrupo) {
        Grupo grupo = null;
        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM GRUPO WHERE COD_GRUPO = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codGrupo);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoGrupo = rs.getInt("COD_GRUPO");
                String nomGrupo = rs.getString("NOM_GRUPO");
                int codTurma = rs.getInt("TURMA_COD_TURMA");
                int codEvento = rs.getInt("EVENTOS_COD_EVENTO");

                grupo = new Grupo(codGrupo, nomGrupo, codTurma, codEvento);

            }
        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao ao buscar grupo! \n ERRO: " + ex);
        }
        return grupo;
    }

    public ArrayList<Grupo> listar() {

        ArrayList<Grupo> lista = new ArrayList();

        try {

            conn = Conexao.getConnection();
            sql = "SELECT * FROM GRUPO";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codigoGrupo = rs.getInt("COD_GRUPO");
                String nomGrupo = rs.getString("NOM_GRUPO");
                int codTurma = rs.getInt("TURMA_COD_TURMA");
                int codEvento = rs.getInt("EVENTOS_COD_EVENTO");

                lista.add(new Grupo(codigoGrupo, nomGrupo, codTurma, codEvento));
            }

        } catch (SQLException ex) {
            showMessageDialog(null, "Erro ao listar grupos! \n ERRO: " + ex);
        }/* finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, "Erro ao fechar a conexão!\n ERROR: " + ex);
            }
        }*/

        return lista;

    }

}
