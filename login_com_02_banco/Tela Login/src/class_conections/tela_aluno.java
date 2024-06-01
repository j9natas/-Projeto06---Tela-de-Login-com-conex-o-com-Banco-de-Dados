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

public class tela_aluno extends JFrame {

	private JPanel contentPane;
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
					tela_aluno frame = new tela_aluno();
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
	public tela_aluno() {
		setResizable(false);
		setTitle("Tela do Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo a tela de Aluno");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(10, 11, 222, 40);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Aperte para recuperar seus dados:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 186, 424, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Pressione");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.connect();
					
					String buscasql = "select ra, nome, email from usuarios natural join alunos where login like ?";
					
					PreparedStatement stmt = con.prepareStatement(buscasql);
					
					stmt.setString(1, tela_login.loginAluno);
					
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
		btnNewButton.setBounds(94, 21, 222, 42);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("RA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 62, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtRa = new JTextField();
		txtRa.setBounds(59, 60, 129, 20);
		contentPane.add(txtRa);
		txtRa.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(20, 102, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(69, 100, 139, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(231, 83, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(269, 81, 165, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}

}
