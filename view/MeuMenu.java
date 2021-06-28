package view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.ContatoController;
import model.Contato;

public class MeuMenu {

	private ContatoController cc;
	private Contato c;
	
	public MeuMenu() {
		super();
		
		c = new Contato();
		cc = new ContatoController();
	}
	
	public void iteracao() {
		int escolha = 100;
		Scanner ler = new Scanner(System.in);
		
		do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma operação:"
					+ "\n1 - Adicionar um contato"
					+ "\n2 - Atualizar um contato"
					+ "\n3 - Listar todos"
					+ "\n4 - Lista por parte do nome"
					+ "\n5 - Remover um usuário"
					+ "\n0 - Fechar / Sair do programa"));
			switch(escolha) {
				case 1 : 	System.out.println("Cadastro de contato:");						
							System.out.println("Entre com o nome do contato:");
							c.setNome(ler.nextLine());
							System.out.println("Entre com o telefone do contato:");
							c.setTelefone(ler.nextLine());
							System.out.println("Entre com o celular do contato:");
							c.setCelular(ler.nextLine());
							System.out.println("Entre com o email do contato:");
							c.setEmail(ler.nextLine());
							cc.adicionarContato(c);
					break;
				case 2 : 	System.out.println("Atualizar Contato");

							List<Contato> lista = cc.listarTodos();
				
							for(Contato c: lista) {
								System.out.println(c.getId() 	+ ": " + c.getNome()
																+ " " + c.getTelefone()
																+ " " + c.getCelular()
																+ " " + c.getEmail());
 							}
							System.out.println("Qual contato atualizar?\nDigite o ID do contato:");
							c.setId(ler.nextInt());
							ler.nextLine();
							System.out.println("Entre com o nome do contato:");
							c.setNome(ler.nextLine());
							System.out.println("Entre com o telefone do contato:");
							c.setTelefone(ler.nextLine());
							System.out.println("Entre com o celular do contato:");
							c.setCelular(ler.nextLine());
							System.out.println("Entre com o email do contato:");
							c.setEmail(ler.nextLine());
							cc.atualizarContato(c);
					break;
				case 3 : 	System.out.println("Listar todos");
							List<Contato> listat = cc.listarTodos();
							
							for(Contato c: listat) {
								System.out.println(c.getId() 	+ ": " + c.getNome()
																+ " " + c.getTelefone()
																+ " " + c.getCelular()
																+ " " + c.getEmail());
								}
					break;
				case 4 : 	System.out.println("Listar por parte do nome.\nEntre com o nome, ou parte dele:");
							String pnome = ler.nextLine();
							List<Contato> listapn = cc.listarPorParteDoNome(pnome);
							
							for(Contato c: listapn) {
								System.out.println(c.getId() 	+ ": " + c.getNome()
																+ " " + c.getTelefone()
																+ " " + c.getCelular()
																+ " " + c.getEmail());
								}
					break;
				case 5 : 	System.out.println("Remover um usuário");
							List<Contato> listar = cc.listarTodos();
							
							for(Contato c: listar) {
								System.out.println(c.getId() 	+ ": " + c.getNome());
								}
							System.out.println("Qual contato remover?\nDigite o ID do contato:");
							c.setId(ler.nextInt());
							cc.removerContato(c);
					break;
				case 0 : System.out.println("Bye!");
					break;
				default: System.out.println("Opções de 0 a 5 somente válidas");
					break;
			}
		}while(escolha!=0);
		ler.close();
	}
}
