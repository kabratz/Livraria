package controles;

import banco.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelos.Bairro;
/**
 *
 * @author karoline.bratz
 */
public class BairroController {
    
    Bairro objBairro;
    JTable jtbBairros = null;
    
    public BairroController(Bairro objBairro, JTable jtbBairros) {
        this.objBairro = objBairro;
        this.jtbBairros = jtbBairros;
    }
    
    public boolean incluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO bairro(id_cidade, nome) VALUES(?, ?)");
            stmt.setInt(1, objBairro.getId_cidade());
            stmt.setString(2, objBairro.getNome());
            
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
            stmt = con.prepareStatement("UPDATE bairro SET id_cidade=?, nome=? WHERE id_bairro=?");
            stmt.setInt(1, objBairro.getId_bairro());
            stmt.setString(2, objBairro.getNome());
            stmt.setInt(3, objBairro.getId_bairro());
            
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
        
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("Cidade");
        cabecalhos.add("Excluir");
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = "SELECT b.id_bairro, b.nome, c.nome";
            SQL += " FROM bairro b, cidade c";
            SQL += " WHERE b.data_exclusao IS NULL AND";
            SQL += " b.id_cidade = c.id_cidade";
            SQL += " ORDER BY b.id_bairro ";
            
            result = Conexao.stmt.executeQuery(SQL);

            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        jtbBairros.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });

        // permite seleção de apenas uma linha da tabela
        jtbBairros.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = jtbBairros.getColumnModel().getColumn(i);
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
        
        jtbBairros.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
    
    public Bairro buscar(String id)
    {
        try {
            Conexao.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id_bairro, id_cidade, nome ";
            SQL += " FROM bairro ";
            SQL += " WHERE id_bairro = '" + id + "'";
            SQL += " AND data_exclusao is null ";

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar");

                objBairro = new Bairro();
                if(rs.next() == true)
                {
                    objBairro.setId_bairro(rs.getInt(1));
                    objBairro.setId_cidade(rs.getInt(2));
                    objBairro.setNome(rs.getString(3));
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
        return objBairro;
    }
    
    public boolean excluir(){
        
        Conexao.abreConexao();
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE bairro SET data_exclusao= now() WHERE id_bairro=?");
            stmt.setInt(1, objBairro.getId_bairro());
                        
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    /*
    public ArrayList<Area> listar() {

        ConnectionFactory.abreConexao();
        
        ArrayList<Area> listagem_areas = new ArrayList();
        Area area_item = null;
        
        ResultSet result = null;
        
        try {

            String SQL = "";
            SQL = " SELECT id, nome AS nomeArea ";
            SQL += " FROM area ";
            SQL += " ORDER BY nome ";
            
            result = ConnectionFactory.stmt.executeQuery(SQL);

            while (result.next()) {
                area_item = new Area();
                area_item.setId(result.getInt("id"));
                area_item.setNome(result.getString("nomeArea"));
                listagem_areas.add(area_item);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
            return null;
        }
        
        return listagem_areas;
    }
    
    
    */
}
