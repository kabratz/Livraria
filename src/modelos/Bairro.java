package modelos;

/**
 *
 * @author karoline.bratz
 */
public class Bairro {

    private int id_bairro;
    private String nome;
    private int id_cidade;
    private int uf;

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int cidade) {
        this.id_cidade = cidade;
    }

    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id) {
        this.id_bairro = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
