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
import javax.swing.JTable;
import modelos.Autor;

/**
 *
 * @author karoline.bratz
 */
public class AutorController {

    Autor objAutor;
    JTable jtbAutor = null;

    public AutorController(Autor objAutor, JTable jtbCandidatos) {
        this.objAutor = objAutor;
        this.jtbAutor = jtbAutor;

    }
     public boolean incluir() throws ParseException{
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        Date parsed = formato.parse(objCandidato.getDataNascimento());
        java.sql.Date dataFormatada = new java.sql.Date(parsed.getTime());
        try{
            stmt = con.prepareStatement("INSERT INTO candidatos(nome, data_nascimento, id_bairro) VALUES(?, ?, ?)");
            stmt.setString(1, objCandidato.getNome());
            stmt.setDate(2, dataFormatada);
            stmt.setInt(3, objCandidato.getIdBairro());
            
            stmt.executeUpdate();
            
            return true;
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
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

    }

}
