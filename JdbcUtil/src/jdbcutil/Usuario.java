/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcutil;

/**
 *
 * @author Aluno
 */
public class Usuario {
    private String nome;
    
    public Usuario(String nome) {
        this.nome = nome;
    }
   
    String getNome() {
        return nome;
    }
}
