package jdbcutil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    private Connection conn;
    public UsuarioDAO(Connection c){
        this.conn = c;
    }
    
    public void insere(Usuario u) throws SQLException{
        try {
        String sql = "insert into Usuario(Nome) values('"+u.getNome()+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public void update (String novo, String id_usuario) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET nome = '"+novo+"' WHERE id_usuario = '"+id_usuario+"'");
    ps.executeUpdate();
    ps.close();
    
    }
     
     public void deletar(String id_usuario) throws SQLException{
        try {
        String sql = "delete from Usuario where id_usuario = ('"+id_usuario+"');";
        PreparedStatement ps = this.conn.prepareStatement(sql); 
        ps.executeUpdate();
        ps.close();
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public List listar() {
		String sql = "select * from Usuario";
        System.out.println(sql);		
        List al1 = new ArrayList();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("id_usuario");
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