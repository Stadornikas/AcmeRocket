
package br.com.fiap.dao;

//import br.com.fiap.conexao.Conexao;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.entity.Aluno;
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
public class AlunoDAO {
    
    private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;

    public boolean inserir(Aluno aluno) {
        boolean aux = false;
        
        sql = "INSERT INTO ALUNOS VALUES (?, ?, ?)";
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, aluno.getCodAluno());
            p.setString(2, aluno.getNomComp());
            p.setInt(3, aluno.getCodGrupo());
            p.execute();
            
            aux = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "inserir alunos! \n ERRO:" + e);
        } 
        
        return aux;
    }

    public Aluno buscar(int codAluno) {
        Aluno Aluno = null;
        connection = Conexao.getConnection();
        sql = "SELECT * FROM ALUNOS WHERE COD_ALUNO = ?";

        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codAluno);
            rs = p.executeQuery();
            while (rs.next()) {
                String nomComp = rs.getString("NOM_ALUNO");
                int codGrupo = rs.getInt("GRUPO_COD_GRUPO");
                Aluno = new Aluno(codAluno, nomComp, codGrupo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Aluno;
    }

    public boolean alterar(Aluno aluno) {
        
        boolean aux = false;
        
        connection = Conexao.getConnection();
        sql = "UPDATE ALUNOS SET NOM_ALUNO = ?, GRUPO_COD_GRUPO = ? WHERE COD_ALUNO = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, aluno.getNomComp());
            p.setInt(2, aluno.getCodGrupo());
            p.setInt(3, aluno.getCodAluno());
            p.execute();
            
            aux = true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "alterar alunos! \n ERRO:" + e);
        }
        
        return aux;
    }

    public boolean deletar(int codAluno) {
        
        boolean aux = false;
        
        connection = Conexao.getConnection();
        sql = "DELETE FROM ALUNOS WHERE COD_ALUNO = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setInt(1, codAluno);
            p.execute();
            
            aux  = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "deletar alunos! \n ERRO:" + e);
        }
        
        return aux;
    }

    public ArrayList<Aluno> listar() {

        ArrayList<Aluno> lista = new ArrayList();

        connection = Conexao.getConnection();
        sql = "SELECT * FROM ALUNOS";
        
        try {
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int codAluno = rs.getInt("COD_ALUNO");
                String nomComp = rs.getString("NOM_ALUNO");
                int codGrupo = rs.getInt("GRUPO_COD_GRUPO");

                lista.add(new Aluno(codAluno, nomComp, codGrupo));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"listar alunos! \n ERRO: " + e);
        }
        
        return lista;
        
    }
    
    public int verificaQauntidadeDependencia(int codAluno){
        int qtdGrupos = 0;
        try {
            connection = Conexao.getConnection();
            sql = "SELECT COUNT(*) qtd_grupo FROM GRUPO WHERE GRUPO_COD_GRUPO = ?";
            p = connection.prepareStatement(sql);
            p.setInt(1, codAluno);
            rs = p.executeQuery();
            
            while(rs.next()){
                qtdGrupos = rs.getInt("qtd_grupo");
            }           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar quantidade de grupos dependentes: " + ex);
        } 
        
        return qtdGrupos;
    }
    
    
    
    public boolean existeAluno(int codAluno) {
        Aluno a = null;
        boolean valida = false;
        try {
            connection = Conexao.getConnection();
            sql = "SELECT * FROM ALUNOS WHERE COD_ALUNO = ?";
            p = connection.prepareStatement(sql);
            p.setInt(1, codAluno);
            rs = p.executeQuery();
            
            while (rs.next()) {
                a = new Aluno(rs.getInt("COD_ALUNO"),rs.getString("NOM_ALUNO"), rs.getInt("GRUPO_COD_GRUPO"));
                valida = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar maior cod aluno: " + ex);
        }

        return (valida);

    }
    
}

