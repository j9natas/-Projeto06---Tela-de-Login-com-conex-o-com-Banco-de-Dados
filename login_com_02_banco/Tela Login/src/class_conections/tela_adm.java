package class_conections;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class tela_adm extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusca;
	private JTextField txtRa;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_adm frame = new tela_adm();
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
	public tela_adm() {
		setResizable(false);
		setTitle("Tela do Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo a tela de Administrador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 11, 222, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar dados de usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 197, 382, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.connect();
					
					String buscasql = "select ra, nome, email from usuarios natural join alunos where login like ?";
					
					PreparedStatement stmt = con.prepareStatement(buscasql);
					
					stmt.setString(1, txtBusca.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						
						txtRa.setText(rs.getString("ra"));
						txtNome.setText(rs.getString("nome"));
						txtEmail.setText(rs.getString("email"));
					}
					
					rs.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(10, 21, 89, 31);
		panel.add(btnBuscar);
		
		txtBusca = new JTextField();
		txtBusca.setText("Login ou RA");
		txtBusca.setBounds(121, 21, 158, 31);
		panel.add(txtBusca);
		txtBusca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("RA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 46, 27, 14);
		contentPane.add(lblNewLabel_1);
		
		txtRa = new JTextField();
		txtRa.setBounds(48, 44, 105, 20);
		contentPane.add(txtRa);
		txtRa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(21, 71, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(67, 69, 129, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(21, 96, 46, 20);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(67, 96, 222, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}
}
