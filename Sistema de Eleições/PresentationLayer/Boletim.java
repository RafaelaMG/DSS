/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import BusinessLayer.FacadeB;

import java.util.HashMap;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author 15
 */
public class Boletim extends javax.swing.JFrame {

    private LCandidatos lista;
    private int codE;
    private int NrEleitorG;
    private Login log;
    private Boletim b;

    public void setCodE(int novo) {
        codE = novo;

    }

    public int getCodE() {

        return this.codE;

    }

    public void setNrEleitor(int novo) {
        NrEleitorG = novo;

    }

    public int getNrEleitor() {

        return this.NrEleitorG;

    }

    DefaultListModel modelo = new DefaultListModel();

    public void preencheV() {

        HashMap<Integer, String> flag;
        flag = FacadeB.mostarCandidatos(codE, NrEleitorG);

        int ajuda = 0;
        Set<Integer> aux = flag.keySet();
        String[] morada = new String[aux.size()];
        for (Integer i : aux) {

            morada[ajuda] = flag.get(i);
            ajuda++;
        }
        for (int j = 0; j < ajuda; j++) {
            modelo.add(j, morada[j]);

            votos.setModel(modelo);
        }
    }

    public Boletim() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        submeterButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        votos = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("        Boletim de Voto");

        submeterButton.setText("Submeter Voto");
        submeterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submeterButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(votos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submeterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submeterButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void submeterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submeterButtonActionPerformed
        int codE = 0;
        HashMap<Integer, String> flag;
        flag = FacadeB.mostarCandidatos(this.getCodE(), NrEleitorG);
        for (Integer i : flag.keySet()) {
            if (flag.get(i).equals(votos.getSelectedValue())) {
                codE = i;
            }
        }

        if (FacadeB.voto(this.codE, NrEleitorG) == 1) {
            FacadeB.voto(this.codE, NrEleitorG);
            JOptionPane.showMessageDialog(this, "O seu voto foi registado com sucesso", "Guardado", JOptionPane.INFORMATION_MESSAGE);
            
        } else {

            JOptionPane.showMessageDialog(this, "Não foi possível registar o voto", "Erro", JOptionPane.ERROR_MESSAGE);
            

    }//GEN-LAST:event_submeterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Boletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Boletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Boletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Boletim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Boletim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submeterButton;
    private javax.swing.JList votos;
    // End of variables declaration//GEN-END:variables
}
