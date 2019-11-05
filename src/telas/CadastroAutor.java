/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.AutorController;
import ferramentas.CaixaDeDialogo;
import modelos.Autor;

/**
 *
 * @author User
 */
public class CadastroAutor extends javax.swing.JFrame {
    Autor objAutor;
    AutorController objAutorController;
    /**
     * Creates new form CadastroAutor
     */
    public CadastroAutor() {
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

        txtNome = new javax.swing.JTextField();
        cbBairro = new javax.swing.JComboBox<>();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCandidatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(0, 153, 102));
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jtbCandidatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCandidatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCandidatos);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("Campos com * são obrigatórios");

        btnLimpar.setBackground(new java.awt.Color(255, 0, 0));
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNome.setText("Nome *");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(301, 301, 301)
                                .addComponent(lblId))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(346, 346, 346)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblId))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnLimpar)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(101, 101, 101)
                            .addComponent(btnSalvar)
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(274, Short.MAX_VALUE)
                            .addComponent(btnSair)))
                    .addGap(3, 3, 3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            boolean retorno;
            //validar os campos
            if (txtNome.getText().trim().length() == 0) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um autor corretamente", 'a');
                return;
            }

            objAutor = new Autor();

            if (!lblId.getText().equals("ID")) {
                objAutor.setID(Integer.parseInt(lblId.getText()));
                objAutorController = new AutorController(objAutor, null);
           
                objAutor.setNome(txtNome.getText());
                 retorno = objAutorController.alterar();
                atualizarTabela();
            } else {
                objAutor = new Autor();
               
                objAutorController = new AutorController(objAutor, null);
                objAutor.setNome(txtNome.getText());
             
                retorno = objAutorController.incluir();
            }

            if (retorno = true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
                atualizarTabela();
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtbCandidatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCandidatosMousePressed
        try {

            int linhaSelecionada = jtbCandidatos.getSelectedRow();//pega a linha selecionada
            String codigo = jtbCandidatos.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            if (jtbCandidatos.isColumnSelected(4)) {
                try {

                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        lblId.setText(codigo);
                        objAutor = new Autor();
                        objAutor.setID(Integer.parseInt(codigo));
                        lblId.setText("ID");
                        objAutorController = new AutorController(objAutor, null);
                        boolean wControle = objAutorController.excluir();
                        if (wControle) {
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        } else {
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }
                    atualizarTabela();

                } catch (Exception ex) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            } else {

                objAutorController = new AutorController(null, null);
                objAutor = objAutorController.buscar(codigo);
                if (objAutor != null && objAutor.getID() > 0) {
                    preencherCampos();
                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                }
            }

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }//GEN-LAST:event_jtbCandidatosMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbBairro;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbCandidatos;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
