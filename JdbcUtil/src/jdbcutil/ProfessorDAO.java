package jdbcutil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    
    private Connection conn;
    public ProfessorDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Professor p) throws SQLException{
        try {
        String sql = "insert into Professor(Nome) values('"+p.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public void update (String novo, String id_professor) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE professor SET nome = '"+novo+"' WHERE id_professor = '"+id_professor+"'");
    ps.executeUpdate();
    ps.close();
    
    }
     
         public void deletar(String id_professor) throws SQLException{
        try {
        String sql = "delete from Usuario where id_professor = ('"+id_professor+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    
    public List listar() {
		String sql = "select * from Professor";
        System.out.println(sql);		
        List al1 = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("id_professor");
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