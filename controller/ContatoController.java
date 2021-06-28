package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Contato;
import service.ContatoServices;

public class ContatoController {
	
	private ContatoServices cs;
	
	public ContatoController() {
		super();
		cs = new ContatoServices();
	}
	
	public void adicionarContato(Contato c) {
		cs.addContato(c);
		JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
	}
	
	public void atualizarContato(Contato c) {
		cs.updateById(c);
		JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
	}
	
	public void removerContato(Contato c) {
		Object opcoes[] = {"Corfimar","Cancelar"};
		
		int escolha = JOptionPane.showOptionDialog(null,
				"Deseja realmente apagar o contato: " + c.getNome() + "?" ,
				"Aviso!", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				opcoes,
				opcoes[0]);
		
		if(escolha == 0) {
			cs.deleteById(c);
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
		}else {
			JOptionPane.showMessageDialog(null, "Operação cancelada com sucesso!");
		}
	}
	
	public List<Contato> listarTodos(){
		return cs.getAll();
	}
	
	public List<Contato> listarPorParteDoNome(String pnome){
		return cs.getContatoByName(pnome);
	}

}
