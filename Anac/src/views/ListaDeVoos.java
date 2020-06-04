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

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ListaDeVoos extends JFrame {

	private JPanel contentPane;
	private JTextField txtCidade;
	private JTextField txtCodigo;
	private JTextField txtIndice;
	private JTextField txtNumero;
	private JButton btnProxVoo;
	private DadosAeroporto dadosAtual;
	private Destino destinoAtual;
	private ListaAeroportos listaAeroportos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeVoos frame = new ListaDeVoos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaDeVoos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Exibi\u00E7\u00E3o de V\u00F4os");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCidade.setBounds(196, 70, 86, 20);
		txtCidade.setColumns(10);
		panel_1.add(txtCidade);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade");
		lblNewLabel_1.setBounds(41, 73, 78, 14);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);
		
		JButton btnProxAero = new JButton("Pr\u00F3ximo Aeroporto");
		btnProxAero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					dadosAtual = listaAeroportos.getProxDados(dadosAtual);
					destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
					showFlight();
					if (listaAeroportos.getProxDados(dadosAtual) == null)
						btnProxAero.setEnabled(false);
				}
				catch (Exception error)
				{}
			}
		});
		btnProxAero.setBounds(41, 142, 250, 23);
		btnProxAero.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(btnProxAero);
		
		JLabel lblCdigoDoAeroporto = new JLabel("C\u00F3digo do Aeroporto");
		lblCdigoDoAeroporto.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblCdigoDoAeroporto.setBounds(41, 98, 145, 14);
		panel_1.add(lblCdigoDoAeroporto);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(196, 101, 86, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblndiceDaCidade = new JLabel("\u00CDndice da Cidade");
		lblndiceDaCidade.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblndiceDaCidade.setBounds(340, 73, 119, 14);
		panel_1.add(lblndiceDaCidade);
		
		txtIndice = new JTextField();
		txtIndice.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtIndice.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndice.setColumns(10);
		txtIndice.setBounds(458, 70, 86, 20);
		panel_1.add(txtIndice);
		
		JLabel lblNmeroDoVo = new JLabel("N\u00FAmero do V\u00F4o");
		lblNmeroDoVo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNmeroDoVo.setBounds(340, 98, 119, 14);
		panel_1.add(lblNmeroDoVo);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Georgia", Font.PLAIN, 11));
		txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero.setColumns(10);
		txtNumero.setBounds(458, 95, 86, 20);
		panel_1.add(txtNumero);
		
		btnProxVoo = new JButton("Pr\u00F3ximo V\u00F4o");
		btnProxVoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					destinoAtual = listaAeroportos.getProxDestino(dadosAtual.getCodigo(), destinoAtual);
					if (listaAeroportos.getProxDestino(dadosAtual.getCodigo(), destinoAtual) == null)
						btnProxVoo.setEnabled(false);
					showFlight();
				}
				catch (Exception error)
				{}
			}
		});
		btnProxVoo.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnProxVoo.setBounds(340, 142, 204, 23);
		panel_1.add(btnProxVoo);
		
		JLabel lblNewLabel_2 = new JLabel("Aeroportos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(41, 24, 241, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("V\u00F4os");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(340, 24, 204, 14);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Aeroporto Anterior");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (dadosAtual.equals(listaAeroportos.getDadosDoFim()))
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
						showFlight();
						btnProxAero.setEnabled(true);
					}
					else
					{
						dadosAtual = listaAeroportos.getAnteDados(dadosAtual);
						destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
						showFlight();
					}
				}
				catch (Exception error)
				{}
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton.setBounds(41, 176, 250, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("V\u00F4o Anterior");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					if (destinoAtual.equals(listaAeroportos.getDestinoDoFim(dadosAtual.getCodigo())))
					{
						destinoAtual = listaAeroportos.getAnteDestino(dadosAtual.getCodigo(), destinoAtual);
						showFlight();
						btnProxVoo.setEnabled(true);
					}
					else
					{
						destinoAtual = listaAeroportos.getAnteDestino(dadosAtual.getCodigo(), destinoAtual);
						showFlight();
					}
				}
				catch (Exception error)
				{}
				
			}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnNewButton_1.setBounds(340, 176, 204, 23);
		panel_1.add(btnNewButton_1);
	}
	
	protected void initialize() throws Exception
	{
		try
		{
			listaAeroportos = new ListaAeroportos();
			DadosAeroporto dadosBsd = new DadosAeroporto("Brasilia", "BSD");
			DadosAeroporto dadosCnf = new DadosAeroporto("Belo Horizonte", "CNF");
			DadosAeroporto dadosGig = new DadosAeroporto("Rio de Janeiro", "GIG");
			DadosAeroporto dadosGru = new DadosAeroporto("Sao Paulo", "GRU");
			DadosAeroporto dadosSsa = new DadosAeroporto("Salvador", "SSA");
			Destino destinoBsd = new Destino(5, 107);
			Destino destinoCnf = new Destino(5, 214);
			Destino destinoCnf2 = new Destino(3, 555);
			Destino destinoCnf3 = new Destino(4, 101);
			Destino destinoGig = new Destino(2, 554);
			Destino destinoGig2 = new Destino(5, 90);
			Destino destinoGru = new Destino(1, 50);
			Destino destinoGru2 = new Destino(3, 89);
			Destino destinoGru3 = new Destino(2, 102);
			Destino destinoSsa = new Destino(2, 215);
			ListaVoos listaVoosBsd = new ListaVoos();
			ListaVoos listaVoosCnf = new ListaVoos();
			ListaVoos listaVoosGig = new ListaVoos();
			ListaVoos listaVoosGru = new ListaVoos();
			ListaVoos listaVoosSsa = new ListaVoos();
			listaVoosBsd.insiraNoFim(destinoBsd);
			listaVoosCnf.insiraNoFim(destinoCnf);
			listaVoosCnf.insiraNoFim(destinoCnf2);
			listaVoosCnf.insiraNoFim(destinoCnf3);
			listaVoosGig.insiraNoFim(destinoGig);
			listaVoosGig.insiraNoFim(destinoGig2);
			listaVoosGru.insiraNoFim(destinoGru);
			listaVoosGru.insiraNoFim(destinoGru2);
			listaVoosGru.insiraNoFim(destinoGru3);
			listaVoosSsa.insiraNoFim(destinoSsa);
			
			listaAeroportos.insiraNoFim(dadosBsd, listaVoosBsd);
			listaAeroportos.insiraNoFim(dadosCnf, listaVoosCnf);
			listaAeroportos.insiraNoFim(dadosGig, listaVoosGig);
			listaAeroportos.insiraNoFim(dadosGru, listaVoosGru);
			listaAeroportos.insiraNoFim(dadosSsa, listaVoosSsa);
			
			dadosAtual = listaAeroportos.getDadosDoInicio();
			destinoAtual = listaAeroportos.getDestinoDoInicio(dadosAtual.getCodigo());
			showFlight();
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
	
	protected void showFlight() throws Exception
	{
		try
		{
			txtCidade.setText(dadosAtual.getNome());
			txtCodigo.setText(dadosAtual.getCodigo());
			txtIndice.setText("" + destinoAtual.getIndice());
			txtNumero.setText("" + destinoAtual.getNumeroVoo());
		}
		catch (Exception e)
		{
			System.out.print(e.getMessage());
		}	
	}
}
