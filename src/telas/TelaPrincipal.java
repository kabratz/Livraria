package telas;
/**
 *
 * @author karoline.bratz
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(TelaPrincipal.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnCad = new javax.swing.JMenu();
        mnCadLivraria = new javax.swing.JMenuItem();
        mnCadLivro = new javax.swing.JMenuItem();
        mnCadFunc = new javax.swing.JMenuItem();
        mnCadCid = new javax.swing.JMenuItem();
        mnConsulta = new javax.swing.JMenu();
        mnConsLivros = new javax.swing.JMenuItem();
        mnConsLivraria = new javax.swing.JMenuItem();
        mnConsFunc = new javax.swing.JMenuItem();
        mnConsCid = new javax.swing.JMenuItem();
        mnSair = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mnCad.setText("Cadastros");

        mnCadLivraria.setText("Livraria");
        mnCadLivraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadLivrariaActionPerformed(evt);
            }
        });
        mnCad.add(mnCadLivraria);

        mnCadLivro.setText("Livro");
        mnCadLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadLivroActionPerformed(evt);
            }
        });
        mnCad.add(mnCadLivro);

        mnCadFunc.setText("Funcionário");
        mnCadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadFuncActionPerformed(evt);
            }
        });
        mnCad.add(mnCadFunc);

        mnCadCid.setText("Cidade");
        mnCadCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadCidActionPerformed(evt);
            }
        });
        mnCad.add(mnCadCid);

        jMenuBar1.add(mnCad);

        mnConsulta.setText("Consulta");

        mnConsLivros.setText("Livros");
        mnConsLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsLivrosActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConsLivros);

        mnConsLivraria.setText("Livraria");
        mnConsLivraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsLivrariaActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConsLivraria);

        mnConsFunc.setText("Funcionário");
        mnConsFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsFuncActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConsFunc);

        mnConsCid.setText("Cidade");
        mnConsCid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsCidActionPerformed(evt);
            }
        });
        mnConsulta.add(mnConsCid);

        jMenuBar1.add(mnConsulta);

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadLivrariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadLivrariaActionPerformed
        // TODO add your handling code here:
        
    //    CadBairros tela_bairros = new CadBairros();
      //  tela_bairros.setVisible(true);
    }//GEN-LAST:event_mnCadLivrariaActionPerformed

    private void mnCadLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnCadLivroActionPerformed


    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        dispose();
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnConsLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsLivrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnConsLivrosActionPerformed

    private void mnConsLivrariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsLivrariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnConsLivrariaActionPerformed

    private void mnCadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnCadFuncActionPerformed

    private void mnCadCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadCidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnCadCidActionPerformed

    private void mnConsFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnConsFuncActionPerformed

    private void mnConsCidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsCidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnConsCidActionPerformed


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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnCad;
    private javax.swing.JMenuItem mnCadCid;
    private javax.swing.JMenuItem mnCadFunc;
    private javax.swing.JMenuItem mnCadLivraria;
    private javax.swing.JMenuItem mnCadLivro;
    private javax.swing.JMenuItem mnConsCid;
    private javax.swing.JMenuItem mnConsFunc;
    private javax.swing.JMenuItem mnConsLivraria;
    private javax.swing.JMenuItem mnConsLivros;
    private javax.swing.JMenu mnConsulta;
    private javax.swing.JMenu mnSair;
    // End of variables declaration//GEN-END:variables
}
