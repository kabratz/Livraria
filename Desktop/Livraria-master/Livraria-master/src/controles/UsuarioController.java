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
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Usuario;

/**
 *
 * @author USER
 */
public class UsuarioController {
        Usuario objUsuario;
        JTable jtbUsuario = null;
    
    public UsuarioController(Usuario objUsuario, JTable jtbUsuario) {
        this.objUsuario = objUsuario;
        this.jtbUsuario = jtbUsuario;
    }
    
         public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuarios(login, senha, nome, nivel) VALUES(?, MD5(?), ?, ?)");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getSenha());
            stmt.setString(3, objUsuario.getNome());
            stmt.setInt(4, objUsuario.getNivel());

            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
     
         public boolean alterar(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET login=?, senha=?, nome=?, nivel=? WHERE login=?");
            stmt.setString(1, objUsuario.getLogin());
            stmt.setString(2, objUsuario.getSenha());
            stmt.setString(3, objUsuario.getNome());
            stmt.setInt(4, objUsuario.getNivel());
            stmt.setString(5, objUsuario.getLogin());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
        
    }
         
         public void preencher() {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Login");
        cabecalhos.add("Nome");
        cabecalhos.add("Nível de acesso");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT login, nome, nivel";
            SQL += " FROM usuarios ";
            SQL += " WHERE data_exclusao IS NULL ";
            SQL += " ORDER BY login ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getString(1));
                linha.add(result.getString(2));
                linha.add(result.getInt(3));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbUsuario.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbUsuario.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbUsuario.getColumnModel().getColumn(i);
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
        
        jtbUsuario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
         
         public Usuario buscar(String login)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT login ,senha, nome, nivel ";
            SQL += " FROM usuarios ";
            SQL += " WHERE login = '" + login + "'";
            SQL += " AND data_exclusao IS NULL ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objUsuario = new Usuario();
                if(rs.next() == true)
                {
                    objUsuario.setLogin(rs.getString(1));
                    objUsuario.setSenha(rs.getString(2));
                    objUsuario.setNome(rs.getString(3));
                    objUsuario.setNivel(rs.getInt(4));
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
        return objUsuario;
    }
         
        public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET data_exclusao=now() WHERE login=?");
            stmt.setString(1, objUsuario.getLogin());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
        
        
}
