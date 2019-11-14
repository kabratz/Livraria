/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author USER
 */
public class Livraria {
    
    private int id_livraria;
    private int id_cidade;
    private String bairro;

    public int getId_livraria() {
        return id_livraria;
    }

    public void setId_livraria(int id_livraria) {
        this.id_livraria = id_livraria;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
}
