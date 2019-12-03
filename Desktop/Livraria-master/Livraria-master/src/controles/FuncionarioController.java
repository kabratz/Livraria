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
import modelos.Cidade;
import modelos.Funcionario;
import modelos.Livraria;

/**
 *
 * @author USER
 */
public class FuncionarioController {

    Funcionario objFuncionario;
    JTable jtbFuncionario = null;

    public FuncionarioController(Funcionario objFuncionario, JTable jtbFuncionario) {
        this.objFuncionario = objFuncionario;
        this.jtbFuncionario = jtbFuncionario;
    }

    public boolean incluir() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        Date parsed = formato.parse(objFuncionario.getData_nascimento());
        java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(id_livraria, pis, data_nascimento, cpf, nome, id_bairro) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, objFuncionario.getId_livraria());
            stmt.setString(2, objFuncionario.getPis());
            stmt.setDate(3, dataFormatada);
            stmt.setString(4, objFuncionario.getCpf());
            stmt.setString(5, objFuncionario.getNome());
            stmt.setInt(6, objFuncionario.getId_bairro());

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
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = formato.parse(objFuncionario.getData_nascimento());
        java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());

        try {

            stmt = con.prepareStatement("UPDATE funcionario SET id_livraria=?, pis=?, data_nascimento=?, cpf=?, nome=?, id_bairro=? WHERE id_livraria=?");
            stmt.setInt(1, objFuncionario.getId_livraria());
            stmt.setString(2, objFuncionario.getPis());
            stmt.setDate(3, dataFormatada);
            stmt.setString(4, objFuncionario.getCpf());
            stmt.setString(5, objFuncionario.getNome());
            stmt.setInt(6, objFuncionario.getId_bairro());
            stmt.setInt(7, objFuncionario.getId_funcionario());

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
        cabecalhos.add("ID da Livraria");
        cabecalhos.add("PIS");
        cabecalhos.add("Data de Nascimento");
        cabecalhos.add("CPF");
        cabecalhos.add("Nome");
        cabecalhos.add("Bairro");
        cabecalhos.add("Excluir");

        ResultSet result = null;

        try {

            String SQL = "";
            SQL = " SELECT f.id_funcionario, l.id_livraria, f.pis, f.data_nascimento, f.cpf, f.nome, b.nome ";
            SQL += " FROM livraria l, cidade c, funcionario f, bairro b";
            SQL += " WHERE f.data_exclusao IS NULL AND ";
            SQL += " l.id_cidade = c.id_cidade AND ";
            SQL += " f.id_livraria = l.id_livraria AND ";
            SQL += " f.id_bairro = b.id_bairro ";
            SQL += " ORDER BY f.id_funcionario ";

            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while (result.next()) {
                linha = new Vector<Object>();

                linha.add(result.getInt(1));
                linha.add(result.getInt(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
                linha.add(result.getString(5));
                linha.add(result.getString(6));
                linha.add(result.getString(7));
                linha.add("X");

                dadosTabela.add(linha);
            }

        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbFuncionario.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbFuncionario.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbFuncionario.getColumnModel().getColumn(i);
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

        jtbFuncionario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public Funcionario buscar(String id) {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_funcionario, id_livraria, pis, data_nascimento, cpf, nome, id_bairro ";
            SQL += " FROM funcionario ";
            SQL += " WHERE id_funcionario = '" + id + "'";
            SQL += " AND data_exclusao IS NULL ";

            try {
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objFuncionario = new Funcionario();
                if (rs.next() == true) {
                    objFuncionario.setId_funcionario(rs.getInt(1));
                    objFuncionario.setId_livraria(rs.getInt(2));
                    objFuncionario.setPis(rs.getString(3));
                    objFuncionario.setData_nascimento(String.valueOf(rs.getDate(4)));
                    objFuncionario.setCpf(rs.getString(5));
                    objFuncionario.setNome(rs.getString(6));
                    objFuncionario.setId_bairro(rs.getInt(7));
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
        return objFuncionario;
    }

    public boolean excluir() {

        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET data_exclusao=now() WHERE id_funcionario=?");
            stmt.setInt(1, objFuncionario.getId_funcionario());

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
