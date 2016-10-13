package br.com.fiap.controller;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Grupo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class CtrlSalvarAluno {

    public Aluno carregarAluno(int codAluno) {
        AlunoDAO dao = new AlunoDAO();
        Aluno a = dao.buscar(codAluno);
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Nenhum Aluno encontrada");
        }
        return a;
    }

    public ArrayList<Grupo> carregarRegistrosGrupo() {
        GrupoDAO dao = new GrupoDAO();
        return dao.listar();
    }

    public String carregarComboGrupo(int codGrupo) {
        String t = "";
        GrupoDAO dao = new GrupoDAO();
        t = dao.buscarNomeGrupo(codGrupo);
        if (t == null) {
            JOptionPane.showMessageDialog(null, "Erro ao listar combo grupo");
        }
        return t;
    }

    public void inserirAluno(String nomeAluno, int codAluno, int codGrupo) {
        
        String msg = "Falha ao inserir período";
        boolean validacao = true;

        if (this.validarCamposObrigatorios(nomeAluno, codAluno, codGrupo)) {
            msg = "Informe os campos obrigatorios";
            validacao = false;
        }
        if (!this.validarNomeDuplicidade(codAluno)) {
            msg = "Já existe um aluno com este nome";
            validacao = false;
        }

        if (this.validarNumeroDeCaracteres(nomeAluno)) {
            msg = "Informe um aluno com um nome maior que 4 caracteres";
            validacao = false;
        }

        if (validacao) {
            Aluno a = new Aluno(codAluno, nomeAluno, codGrupo);
            AlunoDAO dao = new AlunoDAO();
            if (dao.inserir(a)) {
                msg = "Aluno cadastrado com sucesso";
            }

        }

        JOptionPane.showMessageDialog(null, msg);

    }

    public void editarAluno(int codAluno, String nomeAluno, int codGrupo) {
        String msg = "Falha ao alterar aluno";
        boolean validacao = true;

        if (!this.validarCamposObrigatorios(nomeAluno, codAluno, codGrupo)) {
            msg = "Preencha os campos Obrigatórios";
            validacao = false;
        }
        if (validacao) {
            Aluno a = new Aluno(codAluno, nomeAluno, codGrupo);
            AlunoDAO dao = new AlunoDAO();
            if (dao.alterar(a)) {
                msg = "Aluno Alteardo com sucesso";
            }

        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public boolean validarNomeDuplicidade(int codAluno) {//alterar para verificaExistencia
        boolean aux = false;

        AlunoDAO dao = new AlunoDAO();

        if (dao.existeAluno(codAluno)) {
            aux = true;
        }

        return aux;
    }

    public boolean validarCamposObrigatorios(String nomeAluno, int codAluno, int codGrupo) {
        boolean aux = false;

        if ((nomeAluno.equalsIgnoreCase("")) || (codAluno == 0) || (codGrupo == 0)) {
            aux = true;
        }

        return aux;
    }

    public boolean validarNumeroDeCaracteres(String nomeAluno) {//alterar para validarNumCaracteres
        boolean aux = false;

        if (nomeAluno.length() < 4) {
            aux = true;
        }
        return aux;
    }

}
