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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Movimento;

/**
 *
 * @author USER
 */
public class MovimentoController {
    Movimento objMovimento;
    JTable jtbMovimentos = null;
    
        public MovimentoController(Movimento objMovimento, JTable jtbMovimentos) {
        this.objMovimento = objMovimento;
        this.jtbMovimentos = jtbMovimentos;
    }
        
            public boolean incluir() throws ParseException, SQLException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        Date parsed = formato.parse(objMovimento.getData_movimento());
        java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());
        try{
            stmt = con.prepareStatement("INSERT INTO movimento(id_funcionario, data_movimento, id_livraria, tipo) VALUES(?, ?, ?, ?)");
            stmt.setInt(1, objMovimento.getId_funcionario());
            stmt.setDate(2, dataFormatada);
            stmt.setInt(3, objMovimento.getId_livraria());
            stmt.setString(4, String.valueOf(objMovimento.getTipo()));
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
            
        public boolean alterar() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        Date parsed = formato.parse(objMovimento.getData_movimento());
        java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());

        try {

            stmt = con.prepareStatement("UPDATE funcionario SET id_funcionario=?, data_movimento=?, id_livraria=?, tipo=? WHERE id_movimento=?");
            stmt.setInt(1, objMovimento.getId_funcionario());
            stmt.setDate(2, dataFormatada);
            stmt.setInt(3, objMovimento.getId_livraria());
            stmt.setString(4, String.valueOf(objMovimento.getTipo()));
            stmt.setInt(5, objMovimento.getId_movimento());


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

        cabecalhos.add("#");
        cabecalhos.add("Funcionário");
        cabecalhos.add("Data da movimentação");
        cabecalhos.add("Livraria");
        cabecalhos.add("Tipo");
        cabecalhos.add("Excluir");


        ResultSet result = null;

        try {

            String SQL = "";
            SQL = " SELECT m.id_movimento, f.nome, m.data_movimento, l.id_livraria, m.tipo";
            SQL += " FROM movimento m, funcionario f, livraria l";
            SQL += " WHERE m.data_exclusao IS NULL AND ";
            SQL += " m.id_funcionario = f.id_funcionario AND ";
            SQL += " m.id_livraria = l.id_livraria";
            SQL += " ORDER BY m.data_movimento ";

            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();

                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getDate(3));
                linha.add(result.getInt(4));
                linha.add(result.getString(5));
                linha.add("X");

                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbMovimentos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbMovimentos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbMovimentos.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(10);
                    break;
                case 2:
                    column.setPreferredWidth(100);
                    break;
                case 3:
                    column.setPreferredWidth(120);
                    break;
                case 4:
                    column.setPreferredWidth(250);
                    break;
                case 5:
                    column.setPreferredWidth(50);
                    break;
                case 6:
                    column.setPreferredWidth(50);
                    break;
                case 7:
                    column.setPreferredWidth(10);
                    break;
            }
        }

        jtbMovimentos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
            
            public Movimento buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_movimento, id_funcionario, data_movimento, id_livraria, tipo ";
            SQL += " FROM movimento ";
            SQL += " WHERE id_movimento = '" + id + "'";
            SQL += " AND data_exclusao IS NULL ";

            try {
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objMovimento = new Movimento();
                if (rs.next() == true) {
                    objMovimento.setId_movimento(rs.getInt(1));
                    objMovimento.setId_funcionario(rs.getInt(2));
                    objMovimento.setData_movimento(String.valueOf(rs.getDate(3)));
                    objMovimento.setId_livraria(rs.getInt(4));
                    objMovimento.setTipo(rs.getString(5).charAt(0));

                }
            } catch (SQLException ex) {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        System.out.println("Executou buscar area com sucesso");
        return objMovimento;
    }
            
                public boolean excluir() {

        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE movimento SET data_exclusao=now() WHERE id_movimento=?");
            stmt.setInt(1, objMovimento.getId_movimento());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }


}
