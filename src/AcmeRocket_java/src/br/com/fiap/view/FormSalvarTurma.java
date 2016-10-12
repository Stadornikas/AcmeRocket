/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.view;

import br.com.fiap.controller.CtrlListarTurma;
import br.com.fiap.controller.CtrlSalvarTurma;
import java.awt.Color;

import br.com.fiap.dao.EventoDAO;
import br.com.fiap.dao.PeriodoDAO;
import br.com.fiap.dao.TurmaDAO;
import br.com.fiap.entity.Evento;
import br.com.fiap.entity.Periodo;
import br.com.fiap.entity.Turma;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class FormSalvarTurma extends javax.swing.JFrame {

    int codTurma = -1;

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    
    /**
     * Creates new form FormNovaTurma
     */
    public FormSalvarTurma() {
        initComponents();
        setLocationRelativeTo(this);
        lblDashboard.setForeground(Color.blue);
        lblTurma.setForeground(Color.blue);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTurma = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelarTurma = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(723, 420));
        setResizable(false);
        setSize(new java.awt.Dimension(723, 420));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fiap/images/Icones-02 51x51.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, -1));

        jLabel4.setFont(new java.awt.Font("Candara", 0, 28)); // NOI18N
        jLabel4.setText("Turma");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 45, -1, -1));

        jLabel6.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel6.setText("Turma:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        txtTurma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 320, -1));

        txtAno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 90, -1));

        jLabel7.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel7.setText("Ano:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel8.setText("Período:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, 30));

        btnSalvar.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, -1));

        btnCancelarTurma.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        btnCancelarTurma.setText("Cancelar");
        btnCancelarTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarTurmaMouseClicked(evt);
            }
        });
        getContentPane().add(btnCancelarTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 100, -1));

        jLabel2.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel2.setText("Novo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        lblDashboard.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        lblDashboard.setText("Dashboard");
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fiap/images/Icones-Seta 16x16.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        lblTurma.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        lblTurma.setText("Turmas");
        lblTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTurmaMouseClicked(evt);
            }
        });
        getContentPane().add(lblTurma, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fiap/images/Icones-Seta 16x16.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 20, -1));

        cmbPeriodo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o periodo" }));
        getContentPane().add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 320, -1));

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        //CHAMANDO FORMULARIO PRINCIPAL
        FormPrincipal fp = new FormPrincipal();
        this.dispose();
        fp.setVisible(true);
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTurmaMouseClicked
        //CHAMANDO O FORMULARIO TURMAS(LISTA)
        this.dispose();
        FormTurmas ft = new FormTurmas();
        ft.setVisible(true);
    }//GEN-LAST:event_lblTurmaMouseClicked

    private void btnCancelarTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarTurmaMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar ?", "Selecione uma opção", JOptionPane.YES_NO_OPTION) == 0) {
           this.voltarParaLista();
        }
    }//GEN-LAST:event_btnCancelarTurmaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       //Carrega os periodos cadastrados em caso de inserção de nova turma    
        if (codTurma == -1) {
            CtrlSalvarTurma ctrlTurma= new CtrlSalvarTurma();
            ArrayList<Periodo> lista = ctrlTurma.carregarRegistrosPeriodo();

            for (Periodo periodo : lista) {
                cmbPeriodo.addItem(periodo.getNomPeriodo());
            }
        }else{
            //Em caso de edicao os campos vem carregados com os dados da turma
            CtrlSalvarTurma ctrlTurma = new CtrlSalvarTurma();
            Turma turma = ctrlTurma.carregarTurma(codTurma);
            if (turma == null) {
                this.voltarParaLista();
            }
            txtTurma.setText(turma.getNomTurma());
            txtAno.setText(turma.getAnoTurma());
            //TODO: CARREGAR COMBOBOX COM OS PERIODOS CADATRADOS E DEIXAR SELECIONADO O PERIODO REREENTE A TURMA ATUAL
        }


    }//GEN-LAST:event_formWindowOpened

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nomeTurma = txtTurma.getText();
        String ano = txtAno.getText();
        String periodo = String.valueOf(cmbPeriodo.getSelectedItem());

        TurmaDAO daoTurma = new TurmaDAO();
        PeriodoDAO daoPeriodo = new PeriodoDAO();

        Turma turma = new Turma(nomeTurma, ano, daoPeriodo.buscarIdComboPeriodo(String.valueOf(periodo)));

        if (daoTurma.inserir(turma)) {
            JOptionPane.showMessageDialog(this, "Turma cadastrada com sucesso!");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletarActionPerformed
    
    
    private void voltarParaLista(){
        this.dispose();
        FormTurmas lf = new FormTurmas();
        lf.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSalvarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSalvarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSalvarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSalvarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSalvarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTurma;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtTurma;
    // End of variables declaration//GEN-END:variables
}