package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ContatoController;
import model.Contato;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManterContato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel dados = new JPanel();
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField tnome;
	private JTextField ttelefone;
	private JTextField tcelular;
	private JTextField temail;
	private ContatoController cc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ManterContato dialog = new ManterContato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManterContato() {
		cc = new ContatoController();
		setSize(600, 600);
		setTitle("Manter Contatos");
		setLocationByPlatform(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel,BorderLayout.CENTER);
		{
			contentPanel.add(dados);
			dados.setLayout(new GridLayout(0,2));
			{
				JLabel lblNewLabel = new JLabel("Nome");
				dados.add(lblNewLabel);
			}
			{
				tnome = new JTextField();
				dados.add(tnome);
				tnome.setColumns(25);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Telefone");
				dados.add(lblNewLabel_1);
			}
			{
				ttelefone = new JTextField();
				dados.add(ttelefone);
				ttelefone.setColumns(25);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Celular");
				dados.add(lblNewLabel_2);
			}
			{
				tcelular = new JTextField();
				dados.add(tcelular);
				tcelular.setColumns(25);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("E-mail");
				dados.add(lblNewLabel_3);
			}
			{
				temail = new JTextField();
				dados.add(temail);
				temail.setColumns(25);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new JTable(dtm);
				scrollPane.setViewportView(table);
				
				dtm.addColumn("ID");
				dtm.addColumn("Nome");
				dtm.addColumn("Telefone");
				dtm.addColumn("Celular");
				dtm.addColumn("E-mail");
				
				List<Contato> clista = cc.listarTodos();
				for(Contato c: clista) {
					dtm.addRow(new Object[] {
							c.getId(),
							c.getNome(),
							c.getTelefone(),
							c.getCelular(),
							c.getEmail()
					});
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton_1 = new JButton("Adicionar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Contato c = new Contato();
						c.setNome(tnome.getText());
						c.setTelefone(ttelefone.getText());
						c.setCelular(tcelular.getText());
						c.setEmail(temail.getText());
						cc.adicionarContato(c);
						ttelefone.setText("");
						tnome.setText("");
						tcelular.setText("");
						temail.setText("");
						
						atualizarTabela();
					}
				});
				buttonPane.add(btnNewButton_1);
			}
			{
				JButton btnNewButton = new JButton("Atualizar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Contato c = new Contato();
						int row = table.getSelectedRow();
						c.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
						c.setNome(tnome.getText());
						c.setTelefone(ttelefone.getText());
						c.setCelular(tcelular.getText());
						c.setEmail(temail.getText());
						
						cc.atualizarContato(c);
						
						ttelefone.setText("");
						tnome.setText("");
						tcelular.setText("");
						temail.setText("");
						
						atualizarTabela();
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton("Remover");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Contato c = new Contato();
						int row = table.getSelectedRow();
						c.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
						c.setNome(table.getValueAt(row, 1).toString());
						cc.removerContato(c);
						atualizarTabela();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Fechar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void atualizarTabela() {
		
		dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Nome");
		dtm.addColumn("Telefone");
		dtm.addColumn("Celular");
		dtm.addColumn("E-mail");
		
		List<Contato> clista = cc.listarTodos();
		for(Contato c: clista) {
			dtm.addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getTelefone(),
					c.getCelular(),
					c.getEmail()
			});
		}
		
		table.setModel(dtm);
		
	}

}
