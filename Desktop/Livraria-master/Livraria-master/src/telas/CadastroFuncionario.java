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
import ferramentas.Formatacao;
import ferramentas.Validacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
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
    Formatacao formatacao;
    
    /**
     * Creates new form CadastroFuncionario
     */
    public CadastroFuncionario(){
        initComponents();
        atualizarTabela();
        preencherCombos();


    }

    private void atualizarTabela() {
        try {

            objFuncionarioControle = new FuncionarioController(null, jtbFuncionario);
            objFuncionarioControle.preencher();

        } catch (Exception ex) {
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
        cbLivraria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtPis = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter pis = new javax.swing.text.MaskFormatter("###.#####.##-#");

            txtPis = new javax.swing.JFormattedTextField(pis);
        }catch(Exception e){
        }
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText(" LIVRARIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        cbLivraria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLivraria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLivrariaItemStateChanged(evt);
            }
        });
        cbLivraria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLivrariaActionPerformed(evt);
            }
        });
        getContentPane().add(cbLivraria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 198, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PIS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));
        getContentPane().add(txtPis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 159, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("DATA DE NASCIMENTO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("CPF");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        try{
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");

            txtCpf = new javax.swing.JFormattedTextField(cpf);
        }catch(Exception e){
        }
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 201, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("NOME");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 198, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("CADASTRO DE FUNCIONARIO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 92, -1));

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 92, -1));

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
        jtbFuncionario.setMinimumSize(new java.awt.Dimension(60, 10));
        jtbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbFuncionarioMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbFuncionario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 301, 760, 220));

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));
        getContentPane().add(jdcDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 127, -1));

        cbBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbBairro.setEnabled(false);
        getContentPane().add(cbBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 127, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("BAIRRO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
//        verificaExistenciaCPF();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Validacao validacao = new Validacao();
        try {
            boolean retorno;
            //validar os campos
            if (txtNome.getText().trim().length() == 0 || txtCpf.getText().trim().length() < 14 || txtCpf.getText().trim().length() > 14 || txtPis.getText().trim().length() < 14
                    || jdcDataNascimento.getDate() == null || txtPis.getText().trim().length() > 14) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Informe os dados corretamente", 'a');
                return;
            }

            objFuncionario = new Funcionario();
            Combos c = (Combos) cbLivraria.getSelectedItem();
            String codLivraria = c.getCodigo();
            Combos c2 = (Combos) cbBairro.getSelectedItem();
            String codBairro = c2.getCodigo();
            objFuncionario.setId_livraria(Integer.parseInt(codLivraria));
            objFuncionario.setId_bairro(Integer.parseInt(codBairro));        

            objFuncionario.setCpf(txtCpf.getText());
            objFuncionario.setPis(txtPis.getText());
       
            objFuncionario.setData_nascimento(formato.format(jdcDataNascimento.getDate()));
            objFuncionario.setNome(txtNome.getText());
            if (!lblId.getText().equals("ID")) {
                objFuncionario.setId_funcionario(Integer.parseInt(lblId.getText()));
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                retorno = objFuncionarioControle.alterar();
            } else {
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);

                retorno = objFuncionarioControle.incluir();
            }

            if (retorno = true) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Registro salvo");
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar salvar");
            }

            atualizarTabela();
            limparTela();
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao tentar incluir");
            System.out.println("ERRO: " + ex.getMessage().toString());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparTela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jtbFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFuncionarioMousePressed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {

            int linhaSelecionada = jtbFuncionario.getSelectedRow();//pega a linha selecionada
            String codigo = jtbFuncionario.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

            //Verifica se clicou na coluna 2 = EXCLUIR
            if (jtbFuncionario.getSelectedColumn() == 7) {
                try {

                    boolean wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        lblId.setText(codigo);
                        objFuncionario = new Funcionario();
                        objFuncionario.setId_funcionario(Integer.parseInt(codigo));

                        objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                        boolean wControle = objFuncionarioControle.excluir();
                        if (wControle) {
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Excluído com Sucesso!");
                        } else {
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir!");
                        }
                    }

                } catch (Exception ex) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
                atualizarTabela();
            } else {
                objFuncionarioControle = new FuncionarioController(objFuncionario, null);
                objFuncionario = objFuncionarioControle.buscar(codigo);

                if (objFuncionario != null) {
                    String dataN = Formatacao.ajustaDataDMA(objFuncionario.getData_nascimento());
                    Date parsed = formato.parse(dataN);
                    java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());

                    lblId.setText(String.valueOf(objFuncionario.getId_funcionario()));
                    txtCpf.setText(objFuncionario.getCpf());
                    txtNome.setText(objFuncionario.getNome());
                    txtPis.setText(objFuncionario.getPis());
                    cbCombosLivraria.SetaComboBox(String.valueOf(objFuncionario.getId_livraria()));
                    cbCombosBairro.SetaComboBox(String.valueOf(objFuncionario.getId_bairro()));
                    jdcDataNascimento.setDate(dataFormatada);
                    btnSalvar.setEnabled(true);
                }
            }

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
        atualizarTabela();
    }//GEN-LAST:event_jtbFuncionarioMousePressed

    private void cbLivrariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLivrariaActionPerformed
        try {
            atualizarComboBairro();

        } catch (Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_cbLivrariaActionPerformed

    private void cbLivrariaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLivrariaItemStateChanged
        try {
            if(cbLivraria.getSelectedIndex() > 0){
                
                Combos c = (Combos) cbLivraria.getSelectedItem();
                String codLivraria = c.getCodigo();

                cbCombosBairro.PreencheCombo("SELECT b.id_bairro, b.nome FROM bairro b, livraria l WHERE l.id_bairro = b.id_bairro AND b.data_exclusao is null AND l.id_livraria =" + codLivraria);
                cbCombosBairro.SetaComboBox(codLivraria);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbLivrariaItemStateChanged

    private void preencherCombos() {

        try {
            cbCombosLivraria = new Combos(cbLivraria);
            cbCombosLivraria.PreencheCombo("SELECT id_livraria, id_livraria FROM livraria WHERE data_exclusao IS NULL");

            cbCombosBairro = new Combos(cbBairro);
            cbCombosBairro.PreencheCombo("SELECT id_bairro, nome FROM bairro WHERE data_exclusao IS NULL");

            cbBairro.setSelectedIndex(1);
            cbLivraria.setSelectedIndex(1);

            atualizarComboBairro();

        } catch (Exception e) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(e.getMessage());
        }
    }

    private void atualizarComboBairro() {

      
    }

    private void limparTela() {
        try {
            lblId.setText("ID");
            txtCpf.setText("");
            txtNome.setText("");
            txtPis.setText("");
            jdcDataNascimento.setDate(null);
            cbLivraria.setSelectedIndex(1);
            cbBairro.setSelectedIndex(1);

            btnSalvar.setEnabled(true);

            atualizarTabela();

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }
    }

    private void preencherCampos(String id) {
        try {

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
        }

    }

    /*  public Boolean verificaExistenciaCPF()
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT cpf, nome ";
            SQL += " FROM funcionario ";
            SQL += " WHERE cpf = '" + objFuncionario.getCpf()+ "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                if(rs.next() == true)
                {
                    //if(rs.getInt(5) != objFuncionario.getCpf()){
                        return true; //Já existe uma pessoa com este CPF
                    //}else{
                        //return false;
                   // }
                }else{
                    return false;
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return false;
        }
    }
     */
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
    private javax.swing.JComboBox<String> cbLivraria;
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
