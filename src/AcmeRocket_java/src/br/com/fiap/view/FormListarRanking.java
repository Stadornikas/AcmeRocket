/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.view;

import br.com.fiap.controller.CtrlListarRanking;
import br.com.fiap.entity.Ranking;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Thiago
 */
public class FormListarRanking extends javax.swing.JFrame {

    private String[][] matrizRanking;
    ArrayList<Ranking> lista;

    /**
     * Creates new form FormRanking
     */
    public FormListarRanking() {
        initComponents();
        setLocationRelativeTo(this);
        lblDashboard.setForeground(Color.blue);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDashboard = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabRanking = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(723, 420));
        setSize(new java.awt.Dimension(723, 420));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDashboard.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        lblDashboard.setText("Dashboard");
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel8.setText("Ranking");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fiap/images/Icones-Seta 16x16.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Candara", 0, 28)); // NOI18N
        jLabel3.setText("Ranking");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 45, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fiap/images/Icones-07 51x51.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, -1));

        tabRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "NOME GRUPO", "DATA EVENTO", "HORA LANÇAMENTO", "DISTANCIA QUEDA", "ALTURA MAXIMA", "VELOCIDADE MAXIMA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabRankingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabRanking);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 700, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        //CHAMANDO FORMULARIO PRINCIPAL
        FormPrincipal fp = new FormPrincipal();
        this.dispose();
        fp.setVisible(true);
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CtrlListarRanking ctrlListarRanking = new CtrlListarRanking();
        lista = ctrlListarRanking.listarRanking();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        matrizRanking = new String[lista.size()][6];
        Ranking ranking;

        String[] colunas = {"Nome Grupo", "Data Evento", "Hora Lançamento", "Dist Queda", "Alt. max.", "Vel. max."};
        for (int i = 0; i < lista.size(); i++) {

            
            ranking = lista.get(i);
            matrizRanking[i][0] = String.valueOf(ranking.getNomGrupo());
            matrizRanking[i][1] = String.valueOf(formatoData.format(ranking.getDatEvento()));
            matrizRanking[i][2] = String.valueOf(ranking.getHorLancamento());
            matrizRanking[i][3] = String.valueOf(ranking.getDisQueda());
            matrizRanking[i][4] = String.valueOf(ranking.getAltMax());
            matrizRanking[i][5] = String.valueOf(ranking.getVelMax());
            //TODO  Continuar a listagem de rankign e formatar data para exibicao
        }

        TableModel modeloTabela = new DefaultTableModel(matrizRanking, colunas);
        tabRanking.setModel(modeloTabela);
    }//GEN-LAST:event_formWindowOpened

    private void tabRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabRankingMouseClicked
          int linha = tabRanking.getSelectedRow();
        if (linha != -1) {
            FormSalvarLancamento fng = new FormSalvarLancamento();
            String horaLanc = String.valueOf(tabRanking.getValueAt(linha, 2));
            int idLanc = -1;
            for (Ranking ranking : lista) {
                if (horaLanc.equalsIgnoreCase(ranking.getHorLancamento())) {
                    CtrlListarRanking clr = new CtrlListarRanking();
                    idLanc = clr.obterIdLancamento(horaLanc);
                    break;
                }
            }
            if (idLanc  != -1) {
                fng.setCodLancamento(idLanc);
                this.dispose();
                fng.setVisible(true);
            }
        } 
    }//GEN-LAST:event_tabRankingMouseClicked

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
            java.util.logging.Logger.getLogger(FormListarRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListarRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListarRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListarRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListarRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JTable tabRanking;
    // End of variables declaration//GEN-END:variables
}
