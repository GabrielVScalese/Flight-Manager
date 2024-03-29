package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.DadosAeroporto;
import classes.Destino;
import classes.ListaAeroportos;
import classes.ListaVoos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField txtCodAero;
	private ListaAeroportos listaAeroportos;
	private JButton btnExcluirVoo;

	/**
	 * Executa a aplica��o.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria a tela.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("ANAC - Ag\u00EAncia Nacional de Avia\u00E7\u00E3o Civil");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("COTUCA - 2020");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Exibir os V\u00F4os");
		
		/**
		 * Abre a tela da listagem de voos
		 * */
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					ListaDeVoos frame = new ListaDeVoos();
					frame.setVisible(true);
					frame.initialize();
				}
				catch (Exception error)
				{}
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 126, 141, 23);
		panel_2.add(btnNewButton);
		
		JButton btnCadastrarAeroporto = new JButton("Cadastrar Aeroporto");
		
		/**
		 * Abre a tela de cadastro de aeroportos
		 */
		btnCadastrarAeroporto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					CadastroDeAeroporto frame = new CadastroDeAeroporto();
					frame.setVisible(true);
					frame.initialize();
				}
				catch (Exception error)
				{}
			}
		});
		btnCadastrarAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCadastrarAeroporto.setBounds(10, 160, 239, 23);
		panel_2.add(btnCadastrarAeroporto);
		
		JButton btnBuscarVoo = new JButton("Buscar V\u00F4os");
		
		/**
		 *  Verifica se o c�digo do aeroporto escrito na caixa de texto existe.
		 * */
		btnBuscarVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try
				{
					Pattern p = Pattern.compile( "[0-9]" );
				    Matcher m = p.matcher(txtCodAero.getText());
					if (m.find() || txtCodAero.getText().length() != 3)
					{
						JOptionPane.showMessageDialog(null, "C�digo de aerorporto inv�lido!");
					}
					else
					{
						PesquisaDeVoo frame = new PesquisaDeVoo();
						if (frame.existsCode(txtCodAero.getText().toUpperCase()))
						{
							frame.setVisible(true);
					        frame.initialize(txtCodAero.getText().toUpperCase());
					        frame.showFlight(txtCodAero.getText().toUpperCase());
						}
						else
							JOptionPane.showMessageDialog(null, "C�digo de aerorporto inexistente!");
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnBuscarVoo.setEnabled(false);
		btnBuscarVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnBuscarVoo.setBounds(161, 126, 179, 23);
		panel_2.add(btnBuscarVoo);
		
		txtCodAero = new JTextField();
		txtCodAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodAero.setHorizontalAlignment(SwingConstants.CENTER);
		
		/**
		 *  Habilita ou n�o os bot�es de buscar e excluir voo de acordo com o codigo do aeroporto
		 * */
		txtCodAero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				Pattern p = Pattern.compile("[a-zA-Z]+");
			    Matcher m = p.matcher(txtCodAero.getText());
				if (!m.find())
				{
					btnExcluirVoo.setEnabled(false);
					btnBuscarVoo.setEnabled(false);
				}
				else
				{
					btnBuscarVoo.setEnabled(true);
					btnExcluirVoo.setEnabled(true);
				}
			}
		});
		txtCodAero.setBounds(161, 81, 179, 20);
		panel_2.add(txtCodAero);
		txtCodAero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo do Aeroporto");
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(161, 56, 179, 14);
		panel_2.add(lblNewLabel_2);
		
		btnExcluirVoo = new JButton("Excluir V\u00F4o");
		btnExcluirVoo.setEnabled(false);
		
		/**
		 *  Abre a tela de excluir voo
		 * */
		btnExcluirVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Pattern p = Pattern.compile( "[0-9]" );
				    Matcher m = p.matcher(txtCodAero.getText());
					if (m.find() || txtCodAero.getText().length() != 3)
					{
						JOptionPane.showMessageDialog(null, "C�digo de aerorporto inv�lido!");
					}
					else
					{
						ExclusaoDeVoo frame = new ExclusaoDeVoo();
						if (frame.existsCode(txtCodAero.getText().toUpperCase()))
						{
							frame.setVisible(true);
					        frame.initialize(txtCodAero.getText().toUpperCase());
					        frame.showFlight();
						}
						else
							JOptionPane.showMessageDialog(null, "C�digo de aerorporto inexistente!");
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnExcluirVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnExcluirVoo.setBounds(350, 126, 141, 23);
		panel_2.add(btnExcluirVoo);
		
		JButton btnCadastrarVoo = new JButton("Cadastrar V\u00F4o");
		/**
		 *  Abre a tela de cadastrar voo
		 * 
		 * */
		btnCadastrarVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					CadastroDeVoo frame = new CadastroDeVoo();
					frame.setVisible(true);
					frame.initialize();
				}
				catch (Exception error)
				{}
			}
		});
		btnCadastrarVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnCadastrarVoo.setBounds(252, 160, 239, 23);
		panel_2.add(btnCadastrarVoo);
	}
}
