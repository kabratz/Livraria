/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Cidade;

/**
 *
 * @author karoline.bratz
 */
public class CidadeController {

    Cidade objCidade;
    JTable jtbCidade = null;

    public CidadeController(Cidade objCidade, JTable jtbCidade) {
        this.objCidade = objCidade;
        this.jtbCidade = jtbCidade;

    }

    public boolean incluir() throws ParseException {
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO cidade(nome, cep) VALUES(?, ?)");
            stmt.setString(1, objCidade.getNome());
            stmt.setInt(2, objCidade.getCep());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public boolean alterar() throws ParseException {
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cidade SET nome=?, cep=? WHERE id_cidade=?");
            stmt.setString(1, objCidade.getNome());
            stmt.setInt(2, objCidade.getCep());
            stmt.setInt(3, objCidade.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }

    }

    
        public void preencher() {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("CEP");

        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id_cidade, nome, cep ";
            SQL += " FROM cidade";
            SQL += " ORDER BY nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCidade.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCidade.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCidade.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);
                    break;
                case 1:
                    column.setPreferredWidth(230);
                    break;
                case 2:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        
        jtbCidade.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.LIGHT_GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }
         public Cidade buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_cidade, nome, cep ";
            SQL += " FROM cidade ";
            SQL += " WHERE id_cidade = '" + id + "'";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCidade = new Cidade();
                if(rs.next() == true)
                {
                    objCidade.setId(rs.getInt(1));
                    objCidade.setNome(rs.getString(2));
                    objCidade.setCep(rs.getInt(3));
                }
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
        
        System.out.println ("Executou buscar area com sucesso");
        return objCidade;
    }
         
         
   
       

         
    
    public Cidade cidade(String id, String nome) {
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();

        Cidade aut = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id_cidade, nome, cep");
        comandoSQL.append(" FROM cidade");
        comandoSQL.append(" WHERE id_cidade = '" + id + "'");
 

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");

            if (rs.next() == true) {
                aut = new Cidade();
                aut.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return aut;
        } finally {
            Connection con = Conexao.obterConexao();
            System.out.println("Vai fechar a conexão com o banco de dados");
            Conexao.fecharConexao(con);
        }

        return aut;

    }

}
