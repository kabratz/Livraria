/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.JTable;
import modelos.Autor;
import modelos.Funcionario;

/**
 *
 * @author karoline.bratz
 */
public class FuncionarioController {

    Funcionario objFuncionario;
    JTable jtbFuncionario = null;

    public FuncionarioController(Funcionario objFuncionario, JTable jtbFuncionario) {
        this.objFuncionario = this.objFuncionario;
        this.jtbFuncionario = this.jtbFuncionario;

    }


    public boolean incluir() throws ParseException {
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(id_livraria, pis, data_nascimento, cpf, nome) VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1, objFuncionario.getIdLivraria());
            stmt.setString(2, objFuncionario.getPis());
            stmt.setString(3, objFuncionario.getDataNascimento());
            stmt.setString(4, objFuncionario.getCpf());
            stmt.setString(5, objFuncionario.getNome());

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
            stmt = con.prepareStatement("UPDATE candidatos SET id_livraria=?, pis=?, data_nascimento=?, cpf=?, nome=? WHERE id=?");
            stmt.setInt(1, objFuncionario.getIdLivraria());
            stmt.setString(2, objFuncionario.getPis());
            stmt.setString(3, objFuncionario.getDataNascimento());
            stmt.setString(4, objFuncionario.getCpf());
            stmt.setString(5, objFuncionario.getNome());
            stmt.setInt(6, objFuncionario.getIdFuncionario());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Conexao.fecharConexao(con, stmt);
        }

    }

    /*
        public void preencher() {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Código");
        cabecalhos.add("Nome");

        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT a.id, a.nome ";
            SQL += " FROM autor a";
            SQL += " ORDER BY a.nome ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbCandidatos.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbCandidatos.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbCandidatos.getColumnModel().getColumn(i);
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
        
        jtbCandidatos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Autor autor(String id, String nome) {
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        Conexao.abreConexao();

        Autor aut = null;
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id, nome");
        comandoSQL.append(" FROM autor");
        comandoSQL.append(" WHERE id = '" + id + "'");
        comandoSQL.append(" AND senha = MD5('" + nome + "')");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = Conexao.stmt.executeQuery(comandoSQL.toString());
            System.out.println("Executou Conexão em buscar area");

            if (rs.next() == true) {
                aut = new Autor();
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

    }*/

}
