/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcutil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    private Connection conn;
    public AlunoDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Aluno a) throws SQLException{
        try {
        String sql = "insert into Aluno(Nome) values('"+a.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public void update (String novo, String id_aluno) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE aluno SET nome = '"+novo+"' WHERE id_aluno = '"+id_aluno+"'");
    ps.executeUpdate();
    ps.close();
    
    }
     
         public void deletar(String id_aluno) throws SQLException{
        try {
        String sql = "delete from Aluno where id_aluno = ('"+id_aluno+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    
    public List listar() {
		String sql = "select * from Aluno";
        System.out.println(sql);		
        List al1 = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("id_aluno");
				String Nome = rs.getString("Nome");
                                al1.add("\nID: "+ID+"\nNome: "+Nome);
				System.out.println(al1);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al1;
	}
    
}
