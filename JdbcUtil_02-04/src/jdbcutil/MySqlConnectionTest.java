/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcutil;
public class MySqlConnectionTest {

    public static void main(String[] args)throws Exception{
        System.out.println(JdbcUtil.getConnection());
        AlunoDAO alunodao = new AlunoDAO(JdbcUtil.getConnection());
        alunodao.insere((new Aluno("Mateus")));
        alunodao.insere((new Aluno("Vitor")));
        alunodao.update("Wagner", "3");
        alunodao.listar();
        
    }
    
}
