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
public class Aluno {
    private String nome;
    
    public Aluno(String nome) {
        this.nome = nome;
    }
   
    String getNome() {
        return nome;
    }
}
