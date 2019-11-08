/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author karoline.bratz
 */
public class Livraria {

    private String nome;
    private int ID;
    private int bairro;
    private int cidade;
    private int uf;

    public int getBairro() {
        return bairro;
    }

    public void setBairro(int bairro) {
        this.bairro = bairro;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
