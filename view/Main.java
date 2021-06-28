package view;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import controller.ContatoController;
//import model.Contato;
//import persistence.ConnectionFactory;
//import service.ContatoServices;

public class Main {

	public static void main(String[] args) {
		System.out.println("Agenda de Contatos iniciou ...");
		
//		Contato c1 = new Contato();
//		c1.setId(8);
//		c1.setNome("Cristiano José Cecanho");
//		c1.setTelefone("(11) 3333-3333");
//		c1.setCelular("(11) 99999-9999");
//		c1.setEmail("cecanho@teste.com");
//		
//		System.out.println("\nNome:\t " + c1.getNome());
		
//		Contato c2 = new Contato(10, "Célia", "(11) 3333-4444", "(11) 99999-9999", "celia@teste.com");
//		System.out.println("\nNome:\t " + c2.getNome());
		
		
//		System.out.println("Estabelecendo conexão com o banco");
//		Connection conn = ConnectionFactory.getConnection();
//		System.out.println("Conexão realizada");
//		System.out.println("Fechando conexão com o banco");
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Conexão fechada");
		
//		ContatoServices cs = new  ContatoServices();
//		cs.addContato(c1);
//		cs.addContato(c2);
		
//		cs.deleteById(new Contato(2,"","","",""));
		
//		cs.updateById(c1);
//		
//		List<Contato> lista = cs.getAll();
		
//		List<Contato> lista = cs.getContatoByName("de tal");
		
//		ContatoController cc = new ContatoController();
////		cc.adicionarContato(c2);
//		c2.setNome("Celia T. F. C.");
////		cc.atualizarContato(c2);
////		cc.removerContato(new Contato(9, "", "", "", ""));
//		
////		List<Contato> lista = cc.listarTodos();
//
//		List<Contato> lista = cc.listarPorParteDoNome("Jos");
//		for(Contato c: lista) {
//			System.out.println(c.getId() + ": " + c.getNome());
//		}
		
		MeuMenu menu = new MeuMenu();
		menu.iteracao();
		
	}

}
