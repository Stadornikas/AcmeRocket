package br.com.fiap.controller;

import br.com.fiap.dao.GrupoDAO;
import br.com.fiap.dao.LancamentoDAO;
import br.com.fiap.entity.Grupo;
import br.com.fiap.entity.Lancamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlSalvarLancamento {

    public int validarDispositivo(float altitudeMaxima, float velocidadeMaxima,
            float tempoDePropulsao, float picoAceleracao, float aceleracaoMedia, float tempoApogeuDescida,
            float tempoEjecao, float altitudeEjecao, float taxaDescida, float duracaoVoo, float distanciaQuedaAlvo) {
        int aux = 1;

        if (altitudeMaxima != 0 || velocidadeMaxima != 0 || tempoDePropulsao != 0 || picoAceleracao != 0 || aceleracaoMedia != 0 || tempoApogeuDescida != 0
                || tempoEjecao != 0 || altitudeEjecao != 0 || taxaDescida != 0 || duracaoVoo != 0 || distanciaQuedaAlvo != 0) {
            if (altitudeMaxima != 0 && velocidadeMaxima != 0 && tempoDePropulsao != 0 && picoAceleracao != 0 && aceleracaoMedia != 0 && tempoApogeuDescida != 0
                    && tempoEjecao != 0 && altitudeEjecao != 0 && taxaDescida != 0 && duracaoVoo != 0 && distanciaQuedaAlvo != 0) {
                aux = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos do pós-lançamento devem ser preenchidos");
                aux = 0;
            }
        }

        return aux;
    }

    public boolean inserirLancamento(Lancamento lancamento) {
        boolean aux = false;
        String msg = "Falha ao inserir lançamento";
        boolean validacao = true;
        if (validar(lancamento.getCodGrupo(), lancamento.getHorLancamento(),
                lancamento.getAngLancamento(), lancamento.getDisAlvo(), lancamento.getVelVento(),
                lancamento.getPesFoguete())) {
            validacao = false;
            msg = "Informe os campos obrigatorios";
        }

        LancamentoDAO dao = new LancamentoDAO();
        if (validacao) {
            if (dao.inserir(lancamento)) {
                msg = "Laçamento Criado com sucesso";
                aux = true;
            }
        }
        JOptionPane.showMessageDialog(null, msg);
        return aux;
    }

    public boolean editarLancamento(Lancamento lancamento) {
        boolean aux = false;
        String msg = "Falha ao alterar lançamento";

        LancamentoDAO dao = new LancamentoDAO();
        if (dao.alterar(lancamento)) {
            msg = "lançamento Alteardo com sucesso";
            aux = true;
        }

        JOptionPane.showMessageDialog(null, msg);
        return aux;
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
            JOptionPane.showMessageDialog(null, "Erro ao listar combo lançamento");
        }
        return t;
    }

    public boolean validar(int codGrupo, String hora, float angulo, float distanciaDoALvo,
            float velocidadeVento, float pesoFoguete) {
        boolean aux = false;

        if (codGrupo == 0 || hora.equalsIgnoreCase("0") || angulo == 0 || distanciaDoALvo == 0
                || velocidadeVento == 0 || pesoFoguete == 0) {
            aux = true;

        }
        return aux;
    }    
    public int calcularStatus(String txtAltitudeMaxima, String txtVelocidadeMaxima, String txtTempoDePropulsao, 
            String txtPicoDeAceleracao, String txtAceleracaoMedia, String txtTempoApogeuDescida,
            String txtTempoDeEjecao, String txtAltitudeDeEjecao, String txtTaxaDeDescida, String txtDuracaoVoo, String txtQuedaAteAlvo ) {
        
        int aux = 1;
        float altitudeMaxima = Float.parseFloat(txtAltitudeMaxima);
        float velocidadeMaxima = Float.parseFloat(txtVelocidadeMaxima);
        float tempoDePropulsao = Float.parseFloat(txtTempoDePropulsao);
        float picoAceleracao = Float.parseFloat(txtPicoDeAceleracao);
        float aceleracaoMedia = Float.parseFloat(txtAceleracaoMedia);
        float tempoApogeuEDescida = Float.parseFloat(txtTempoApogeuDescida);
        float tempoEjecao = Float.parseFloat(txtTempoDeEjecao);
        float altiduteEjecao = Float.parseFloat(txtAltitudeDeEjecao);
        float taxaDecida = Float.parseFloat(txtTaxaDeDescida);
        float duracaoVoo = Float.parseFloat(txtDuracaoVoo);
        float distanciaQuedaAlvo = Float.parseFloat(txtQuedaAteAlvo);

        if (altitudeMaxima != 0 || velocidadeMaxima != 0 || tempoDePropulsao != 0 || picoAceleracao != 0 || aceleracaoMedia != 0 || tempoApogeuEDescida != 0
                || tempoEjecao != 0 || altiduteEjecao != 0 || taxaDecida != 0 || duracaoVoo != 0 || distanciaQuedaAlvo != 0) {
            if (altitudeMaxima != 0 && velocidadeMaxima != 0 && tempoDePropulsao != 0 && picoAceleracao != 0 && aceleracaoMedia != 0 && tempoApogeuEDescida != 0
                    && tempoEjecao != 0 && altiduteEjecao != 0 && taxaDecida != 0 && duracaoVoo != 0 && distanciaQuedaAlvo != 0) {
                aux = 2;
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos do pós-lançamento devem ser preenchidos");
                aux = 0;
            }
        }

        return aux;
    }
}
