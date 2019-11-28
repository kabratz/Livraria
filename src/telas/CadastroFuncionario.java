/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Conexao;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import controles.BairroController;
import controles.FuncionarioController;
import ferramentas.CaixaDeDialogo;
import ferramentas.Combos;
import ferramentas.Validacao;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Bairro;
import modelos.Funcionario;

/**
 *
 * @author USER
 */
public class CadastroFuncionario extends javax.swing.JFrame {
    

    Funcionario objFuncionario;
    FuncionarioController objFuncionarioControle;
    Combos cbCombosBairro, cbCombosLivraria;
    /**
     * Creates new form CadastroFuncionario
     */
    public CadastroFuncionario() {
        initComponents();
        atualizarTabela();
        preencherCombos();
    }
    
             private void atualizarTabela(){
        try{
            
            objFuncionarioControle = new FuncionarioController(null, jtbFuncionario);
            objFuncionarioControle.preencher();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbCidadeLivraria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbFuncionario = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        jdcDataNascimento = new com.toedter.calendar.JDateChooser();
        cbBairro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(" LIVRARIA");

        cbCidadeLivraria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCidadeLivraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeLivrariaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PIS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("DATA DE NASCIMENTO");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CPF");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NOME");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("CADASTRO DE FUNCIONARIO");

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jtbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFuncionarioMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbFuncionario);

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");

        cbBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("BAIRRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPis, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(lblId))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(cbCidadeLivraria, 0, 198, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCidadeLivraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lblId)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnSalvar))
                    .addComponent(btnLimpar))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Validacao validacao = new Validacao();
        try{
            boolean retorno;
            //validar os campos
            if(txtNome.getText().trim().length() == 0 || txtCpf.getText().trim().length() < 11 || txtCpf.getText().trim().length() > 11 || txtPis.getText().trim().length() < 11 ||
                    jdcDataNascimento.getDate() == null || txtPis.getText().trim().length() > 13){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe os dados corretamente", 'a');
                return;
            }

            objFuncionario = new Funcionario();
            Combos c = (Combos) cbCidadeLivraria.getSelectedItem();
            String codLivraria = c.getCodigo();
            Combos c2 = (Combos) cbBairro.getSelectedItem();
            String codBairro = c2.getCodigo();
            objFuncionario.setId_bairro(Integer.parseInt(codBairro));
            objFuncionario.setId_livraria(Integer.parseInt(codLivraria));
            objFuncionario.setCpf(txtCpf.getText().trim());
            objFuncionario.setPis(txtPis.getText().trim());
            objFuncionario.setData_nascimento(formato.format(jdcDataNascimento.getDate()));
            objFuncionario.setNome(txtNome.getText());
            if(!lblId.getText().equals("ID")){
                objFuncionario.setId_funcionario(Integer.parseInt(lblId.getText()));
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                retorno = objFuncionarioControle.alterar();
            }else{
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);
   
                retorno = objFuncionarioControle.incluir();
            }
            
            if(retorno = true){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }
            
            atualizarTabela();

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jtbFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFuncionarioMousePressed
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try{
            
            int linhaSelecionada = jtbFuncionario.getSelectedRow();//pega a linha selecionada
            String codigo = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha
            String dataNascimento = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 3).toString();
            String pis = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 2).toString();
            String cpf = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 4).toString();
            String nome = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 5).toString();
            

            //Verifica se clicou na coluna 2 = EXCLUIR
            if(jtbFuncionario.getSelectedColumn() == 7){
                try{
                    
                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?","",'p');
                    if (wPergunta == true){
                        lblId.setText(codigo);
                        objFuncionario = new Funcionario();
                        objFuncionario.setId_funcionario(Integer.parseInt(codigo));
                        
                        objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                        boolean wControle = objFuncionarioControle.excluir();
                        if (wControle){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }

                }catch(Exception ex){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
                atualizarTabela();
            }else {
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                objFuncionario = objFuncionarioControle.buscar(codigo);
                lblId.setText(String.valueOf(objFuncionario.getId_funcionario()));   
                txtCpf.setText(objFuncionario.getCpf());
                txtNome.setText(objFuncionario.getNome());
                txtPis.setText(objFuncionario.getPis());               
                cbCombosLivraria.SetaComboBox(String.valueOf(objFuncionario.getId_livraria()));
            btnSalvar.setEnabled(true);
                
            }
        
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
        atualizarTabela();
    }//GEN-LAST:event_jtbFuncionarioMousePressed

    private void cbCidadeLivrariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeLivrariaActionPerformed
        try {
            atualizarComboBairro();
            
        } catch(Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_cbCidadeLivrariaActionPerformed

            private void preencherCombos() {
                
        try {
            cbCombosLivraria = new Combos(cbCidadeLivraria);        
            cbCombosLivraria.PreencheCombo("SELECT id_livraria, id_livraria FROM livraria WHERE data_exclusao IS NULL");
            
            cbCombosBairro = new Combos(cbBairro);        
            cbCombosBairro.PreencheCombo("SELECT id_bairro, nome FROM bairro WHERE data_exclusao IS NULL");
            
            cbBairro.setSelectedIndex(1);
            cbCidadeLivraria.setSelectedIndex(1);
            
            atualizarComboBairro();
            
        } catch (Exception e) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(e.getMessage());
        }
            }
            
            private void atualizarComboBairro() {
        
        cbCombosLivraria = (Combos) cbCidadeLivraria.getSelectedItem();
        String codLivraria = cbCombosLivraria.getCodigo();
            
                   
        try {
            cbCombosBairro.PreencheCombo("SELECT b.id_bairro, b.nome FROM bairro b, livraria l WHERE l.id_bairro = b.id_bairro AND b.data_exclusao is null AND l.id_livraria =" + codLivraria);
            cbCombosBairro.SetaComboBox(codLivraria);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
           
        
        private void limparTela(){
        try{
            lblId.setText("ID");
            txtCpf.setText("");
            txtNome.setText("");
            txtPis.setText("");
            jdcDataNascimento.setDate(null);
            cbCidadeLivraria.setSelectedIndex(1);
            cbBairro.setSelectedIndex(1);
           
            btnSalvar.setEnabled(true);
            
            atualizarTabela();
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }
                
        private void preencherCampos(String id){
        try{
                
            
            
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
   
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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbBairro;
    private javax.swing.JComboBox<String> cbCidadeLivraria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcDataNascimento;
    private javax.swing.JTable jtbFuncionario;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPis;
    // End of variables declaration//GEN-END:variables
}
