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
import modelos.Cliente;

/**
 *
 * @author karoline.bratz
 */
public class ClienteController {

    Cliente objCliente;
    JTable jtbCliente = null;

    public ClienteController(Cliente objCliente, JTable jtbCliente) {
        this.objCliente = objCliente;
        this.jtbCliente = jtbCliente;

    }

    public boolean incluir() throws ParseException {
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO cliente(nome, dt_nascimento, cpf, telefone, uf, cidade, bairro) VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getData_nascimento());
            stmt.setString(3, objCliente.getCpf());
            stmt.setString(4, objCliente.getTelefone());
            stmt.setInt(5, objCliente.getUf());
            stmt.setInt(6, objCliente.getCidade());
            stmt.setInt(7, objCliente.getBairro());
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
            stmt = con.prepareStatement("UPDATE candidatos SET nome=?, dt_nascimento=?, cpf=?, telefone=?, uf=?, cidade=?, bairro=?  WHERE id=?");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getData_nascimento());
            stmt.setString(3, objCliente.getCpf());
            stmt.setString(4, objCliente.getTelefone());
            stmt.setInt(5, objCliente.getUf());
            stmt.setInt(6, objCliente.getCidade());
            stmt.setInt(7, objCliente.getBairro());
            stmt.setInt(8, objCliente.getID());

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
        cabecalhos.add("Telefone");
        cabecalhos.add("UF");
        cabecalhos.add("Cidade");
        cabecalhos.add("Bairro");
        cabecalhos.add("Logradouro");

        ResultSet result = null;

        try {

            String SQL = "";
            SQL = " SELECT c.id, c.nome, c.telefone, uf.uf, b.nome, ci.nome, c.logradouro";
            SQL += " FROM cliente c, bairro b, cidade ci, uf";
            SQL += " WHERE b.id = c.bairro ";
            SQL += " AND uf.id = c.uf ";
            SQL += " AND ci.id = c.cidade ";
            SQL += " ORDER BY c.nome ";

            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();

                linha.add(result.getInt(1));
                linha.add(result.getString(2));

                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCliente.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCliente.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCliente.getColumnModel().getColumn(i);
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

        jtbCliente.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public Cliente buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT c.id, c.nome, c.telefone, uf.uf, b.nome, ci.nome, c.logradouro";
            SQL += " FROM cliente c, bairro b, cidade ci, uf";
            SQL += " WHERE b.id = c.bairro ";
            SQL += " AND uf.id = c.uf ";
            SQL += " AND ci.id = c.cidade ";
            SQL += " AND id = '" + id + "'";
            SQL += " ORDER BY c.nome ";

            try {
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objCliente = new Cliente();
                if (rs.next() == true) {
                    objCliente.setID(rs.getInt(1));
                    objCliente.setNome(rs.getString(2));
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
        return objCliente;
    }

    public boolean excluir() {

        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE candidatos SET data_exclusao= now() WHERE id=?");
            stmt.setInt(1, objCliente.getID());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public Cliente cliente(String id, String nome) {
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();

        Cliente aut = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT c.id, c.nome, c.telefone, uf.uf, b.nome, ci.nome, c.logradouro");
        comandoSQL.append(" FROM cliente c, bairro b, cidade ci, uf");
        comandoSQL.append(" WHERE WHERE b.id = c.bairro ");
        comandoSQL.append(" AND uf.id = c.uf ");
        comandoSQL.append(" AND ci.id = c.cidade ");
        comandoSQL.append(" id = '" + id + "'");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");

            if (rs.next() == true) {
                aut = new Cliente();
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
