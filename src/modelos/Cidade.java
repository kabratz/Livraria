/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelos.*;

/**
 *
 * @author karoline.bratz
 */
public class Cidade {
    
    private String nome;
    private int Id;
    private int cep;

    public String getNome() {
        return nome;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
