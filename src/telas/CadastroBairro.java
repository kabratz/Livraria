/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controles.BairroController;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Consulta;
import modelos.Bairro;

/**
 *
 * @author karoline.bratz
 */
public class CadastroBairro extends javax.swing.JFrame {

    Combos obCidade, obUf;
    Bairro objBairro;
    BairroController objBairroController;
    Consulta objConsulta;

    /**
     * Creates new form CadastroBairro
     */
    public CadastroBairro() {
        initComponents();
        try {
            obCidade = new Combos(cbCidade);
            obCidade.PreencheCombo("SELECT id, nome FROM cidade");
        } catch (Exception e) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(e.getMessage());
        }
        limparTela();
    }

    private void limparTela() {
        try {
            lblId.setText("ID");
            txtNome.setText("");
            cbCidade.setSelectedIndex(0);
            cbUF.setSelectedIndex(0);
            btnSalvar.setEnabled(true);
            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

    private void preencherCampos() {
        try {
            lblId.setText(String.valueOf(objBairro.getId()));
            txtNome.setText(objBairro.getNome());
            obCidade.SetaComboBox(String.valueOf(objBairro.getCidade()));
            obUf.SetaComboBox(String.valueOf(objBairro.getUf()));

            btnSalvar.setEnabled(true);

            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

    private void atualizarTabela() {
        try {

            objBairroController = new BairroController(null, jtbBairro);
            objBairroController.preencher();
            //ola

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBairro = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox<>();
        lblNome1 = new javax.swing.JLabel();
        cbUF = new javax.swing.JComboBox<>();
        lblUF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNome.setText("Nome *");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");

        btnSalvar.setBackground(new java.awt.Color(0, 153, 102));
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jtbBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbBairro.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbBairroMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBairro);

        btnLimpar.setBackground(new java.awt.Color(255, 0, 0));
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Cadastro de Bairro");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblNome1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNome1.setText("Cidade");

        cbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUF.setText("UF *");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUF)
                            .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome1)
                            .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblId)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(lblId)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {
            boolean retorno;
            //validar os campos
            if (txtNome.getText().trim().length() == 0) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um bairro corretamente", 'a');
                return;
            }

            objBairro = new Bairro();

            if (!lblId.getText().equals("ID")) {
                objBairro.setId(Integer.parseInt(lblId.getText()));
                objBairroController = new BairroController(objBairro, null);
                objBairro.setNome(txtNome.getText());
                objBairro.setUf(cbUF.getSelectedIndex());
                objBairro.setCidade(cbCidade.getSelectedIndex());

                retorno = objBairroController.alterar();
                atualizarTabela();
            } else {
                objBairro = new Bairro();
                objBairroController = new BairroController(objBairro, null);
                objBairro.setNome(txtNome.getText());
                objBairro.setUf(cbUF.getSelectedIndex());
                objBairro.setCidade(cbCidade.getSelectedIndex());
                retorno = objBairroController.incluir();
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

    private void jtbBairroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBairroMousePressed
        int linhaSelecionada = jtbBairro.getSelectedRow();//pega a linha selecionada
        String codigo = jtbBairro.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha
        if (jtbBairro.isColumnSelected(4)) {
            try {
                boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                if (wPergunta == true) {
                    lblId.setText(codigo);
                    objBairro = new Bairro();
                    objBairro.setId(Integer.parseInt(codigo));
                    lblId.setText("ID");
                    objBairroController = new BairroController(objBairro, null);
                    boolean wControle = objBairroController.excluir();
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
            //  int linhaSelecionada = jtbBairro.getSelectedRow();
            //String codigo = jtbBairro.getModel().getValueAt(linhaSelecionada, 0).toString();

            if (jtbBairro.isColumnSelected(4)) {
                try {
                    objBairroController = new BairroController(null, null);
                    objBairro = objBairroController.buscar(codigo);
                    if (objBairro != null && objBairro.getId() > 0) {
                        preencherCampos();
                    } else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar no BD!");
                    }

                } catch (Exception ex) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
                }
    }//GEN-LAST:event_jtbBairroMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        char c = objConsulta.getConsulta();

        if (c == 's') {
            btnSalvar.setVisible(false);
            btnLimpar.setVisible(false);
            //lblCampos.setVisible(false);
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroBairro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbUF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbBairro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUF;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
