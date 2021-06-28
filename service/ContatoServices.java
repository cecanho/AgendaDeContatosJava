package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contato;
import persistence.ConnectionFactory;

public class ContatoServices {
	
	public ContatoServices() {
		super();
	}
	
	public void addContato(Contato c) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "INSERT INTO tbl_contatos (nome, telefone, celular, email) VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getCelular());
			stmt.setString(4, c.getEmail());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateById(Contato c) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "UPDATE tbl_contatos SET nome = ?, telefone = ?, celular = ?, email = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getTelefone());
			stmt.setString(3, c.getCelular());
			stmt.setString(4, c.getEmail());
			stmt.setInt(5, c.getId());
			stmt.execute();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteById(Contato c) {
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			String sql = "DELETE FROM tbl_contatos where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, c.getId());
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Contato> getAll(){
		Connection conn = ConnectionFactory.getConnection();
		List<Contato> lista = new ArrayList<>();
		try {			
			String sql = "SELECT * FROM tbl_contatos";
			Statement stmt = conn.createStatement();
			ResultSet resultados = stmt.executeQuery(sql);
			while(resultados.next()) {
				int id = resultados.getInt("id");
				String nome = resultados.getString("nome");
				String telefone = resultados.getString("telefone");
				String celular = resultados.getString("celular");
				String email = resultados.getString("email");
				lista.add(new Contato(id, nome, telefone, celular, email));
			}
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public List<Contato> getContatoByName(String pnome){
		Connection conn = ConnectionFactory.getConnection();
		List<Contato> lista = new ArrayList<>();
		try {			
			String sql = "SELECT * FROM tbl_contatos WHERE nome like ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + pnome + "%");
			ResultSet resultados = stmt.executeQuery();
			while(resultados.next()) {
				int id = resultados.getInt("id");
				String nome = resultados.getString("nome");
				String telefone = resultados.getString("telefone");
				String celular = resultados.getString("celular");
				String email = resultados.getString("email");
				lista.add(new Contato(id, nome, telefone, celular, email));
			}
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

}
