package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import javax.swing.JOptionPane;

public class CtrlDeletarGrupo {

    public boolean confirmaExclusao() {
        boolean out = false;
        if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o grupo?", "Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
            out = true;
        }
        return out;
    }

    public void excluirGrupo(int codGrupo) {
        String msg = "Falha ao deletar período";
        boolean validacao = true;

        if (!this.validarDependencia(codGrupo)) {
            msg = "Antes de deletar o grupo é necessário excluir os alunos vinculadas a ele";
            validacao = false;
        }

        if (validacao) {
            GrupoDAO dao = new GrupoDAO();
            if (dao.deletar(codGrupo)) {
                msg = "Grupo deletado com sucesso";
            }
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public boolean validarDependencia(int codEvento) {
        GrupoDAO dao = new GrupoDAO();
        //Caso a quantidade de turmas dependetes do periodo for maior que zero a validacao retorna false
        return dao.verificarQuantidadeDependencia(codEvento) > 0 ? false : true;
    }

}
