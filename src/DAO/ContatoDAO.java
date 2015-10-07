package DAO;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.ContatoBean;
import Utilitario.Conexao;

public class ContatoDAO {

	private Conexao con;
	
	public ContatoDAO(){
		con = new Conexao();
	}
	
	public boolean salvarContato(ContatoBean contato){
		try {
		String sql = "INSERT INTO CONTATO(NOME,ENDERECO,CIDADE,UF,TELEFONE,CELULAR,EMAIL)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
		
		
			PreparedStatement stm = con.getConnection().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEndereco());
			stm.setString(3, contato.getCidade());
			stm.setString(4, contato.getUf());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getEmail());
			
			stm.execute();
			con.getConnection().commit();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean editarContato(ContatoBean contato){
		try {
		String sql = "UPDATE CONTATO SET NOME = ?, ENDERECO = ?, CIDADE = ?, UF = ?, TELEFONE = ?,"
				+ " CELULAR = ?, EMAIL = ? WHERE ID = ?";
					
		
		
			PreparedStatement stm = con.getConnection().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEndereco());
			stm.setString(3, contato.getCidade());
			stm.setString(4, contato.getUf());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getEmail());
			stm.setInt(8, contato.getId());
			
			stm.execute();
			con.getConnection().commit();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean excluirContato(ContatoBean contato){
		try {
		String sql = "DELETE FROM CONTATO WHERE ID = ?";
				
			PreparedStatement stm = con.getConnection().prepareStatement(sql);
			
			stm.setInt(1, contato.getId());
			
			stm.execute();
			con.getConnection().commit();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<ContatoBean> listarContato(){
		List<ContatoBean> lista = new ArrayList<ContatoBean>();
		try {
		String sql = "SELECT * FROM CONTATO";
				
			PreparedStatement stm = con.getConnection().prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()){
				ContatoBean contato = new ContatoBean();
				contato.setId(rs.getInt("ID"));
				contato.setNome(rs.getString("NOME"));
				contato.setEndereco(rs.getString("ENDERECO"));
				contato.setCidade(rs.getString("CIDADE"));
				contato.setUf(rs.getString("UF"));
				contato.setTelefone(rs.getString("TELEFONE"));
				contato.setCelular(rs.getString("CELULAR"));
				contato.setEmail(rs.getString("EMAIL"));
				lista.add(contato);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
}
