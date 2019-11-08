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
import modelos.Livraria;

/**
 *
 * @author karoline.bratz
 */
public class LivrariaController {

    Livraria objLivraria;
    JTable jtbLivraria = null;

    public LivrariaController(Livraria objLivraria, JTable jtbLivraria) {
        this.objLivraria = objLivraria;
        this.jtbLivraria = jtbLivraria;

    }

    public boolean incluir() throws ParseException {
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO livraria(nome, uf, id_cidade, bairro) VALUES(?, ?, ?, ?)");
            stmt.setString(1, objLivraria.getNome());
            stmt.setInt(2, objLivraria.getUf());
            stmt.setInt(3, objLivraria.getCidade());
            stmt.setInt(4, objLivraria.getBairro());
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
            stmt = con.prepareStatement("UPDATE livraria SET nome=?, uf=?, id_cidade=?, bairro=? WHERE id_livraria=?");
            stmt.setString(1, objLivraria.getNome());
            stmt.setInt(2, objLivraria.getUf());
            stmt.setInt(3, objLivraria.getCidade());
            stmt.setInt(4, objLivraria.getBairro());
            stmt.setInt(5, objLivraria.getID());

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
        cabecalhos.add("UF");
        cabecalhos.add("Cidade");
        cabecalhos.add("Bairro");

        ResultSet result = null;

        try {

            String SQL = "";
            SQL = " SELECT id_livraria, nome, uf, id_cidade, bairro ";
            SQL += " FROM livraria";
            SQL += " ORDER BY id_livraria ";

            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();

                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getInt(3));
                linha.add(result.getInt(4));
                linha.add(result.getInt(5));

                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbLivraria.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbLivraria.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbLivraria.getColumnModel().getColumn(i);
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

        jtbLivraria.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public Livraria buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_livraria, nome, uf, id_cidade, bairro ";
            SQL += " FROM livraria ";
            SQL += " WHERE id = '" + id + "'";

            try {
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objLivraria = new Livraria();
                if (rs.next() == true) {
                    objLivraria.setID(rs.getInt(1));
                    objLivraria.setNome(rs.getString(2));
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
        return objLivraria;
    }

    public boolean excluir() {

        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE candidatos SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objLivraria.getID());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public Livraria livraria(String id, String nome) {
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();

        Livraria aut = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id_livraria, nome, uf, id_cidade, bairro");
        comandoSQL.append(" FROM livraria");
        comandoSQL.append(" WHERE id = '" + id + "'");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");

            if (rs.next() == true) {
                aut = new Livraria();
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
