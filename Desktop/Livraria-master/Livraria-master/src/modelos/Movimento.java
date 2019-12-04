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
public class Movimento {
    private int id_movimento;
    private int id_funcionario;
    private String data_movimento;
    private int id_livraria;
    private char tipo;

    public int getId_movimento() {
        return id_movimento;
    }

    public void setId_movimento(int id_movimento) {
        this.id_movimento = id_movimento;
    }


    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getData_movimento() {
        return data_movimento;
    }

    public void setData_movimento(String data_movimento) {
        this.data_movimento = data_movimento;
    }

    public int getId_livraria() {
        return id_livraria;
    }

    public void setId_livraria(int id_livraria) {
        this.id_livraria = id_livraria;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
}
