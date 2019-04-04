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
        /*alunodao.insere((new Aluno("Roberto")));
        alunodao.insere((new Aluno("Vitor")));
        alunodao.update("Edson", "1");
        alunodao.listar();*/
        alunodao.deletar("1");
        
        ProfessorDAO professordao = new ProfessorDAO(JdbcUtil.getConnection());
        /*professordao.insere((new Professor("Wagner")));
        professordao.insere((new Professor("Carlos")));
        professordao.update("Luciano", "1");
        professordao.listar();*/
        professordao.deletar("1");
        
        UsuarioDAO usuariodao = new UsuarioDAO(JdbcUtil.getConnection());
        /*usuariodao.insere((new Usuario("Vitória")));
        usuariodao.insere((new Usuario("Julia")));
        usuariodao.update("Mateus", "1");
        usuariodao.listar();*/
        usuariodao.deletar("1");
    }
    
}
