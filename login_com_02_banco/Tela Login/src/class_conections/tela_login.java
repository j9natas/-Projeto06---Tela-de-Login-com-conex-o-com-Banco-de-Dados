package class_conections;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class tela_login extends JFrame {

	
	public static String loginAluno = "";
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_login frame = new tela_login();
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
	public tela_login() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 54, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 51, 54, 20);
		contentPane.add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setText("Login");
		txtLogin.setBounds(74, 17, 150, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.connect();
					
					String loginsql = "select login, senha, tipo from usuarios where login=? and senha=?";
					
					PreparedStatement stmt = con.prepareStatement(loginsql);
					
					stmt.setString(1, txtLogin.getText());
					stmt.setString(2, new String (pfSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						
						if(rs.getInt("tipo") == 2) {
							tela_adm exibirAdm = new tela_adm();
							exibirAdm.setVisible(true);
							
							setVisible(false);
						}else {
							loginAluno = rs.getString("login");
							tela_aluno exibirAluno = new tela_aluno();
							exibirAluno.setVisible(true);
							
							setVisible(false);
						}
						
						
						JOptionPane.showMessageDialog(null, "Esse usuário existe");
					}else {
						JOptionPane.showMessageDialog(null, "Usuário/Senha incorreto(s)");
					}
					
					stmt.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(267, 11, 157, 60);
		contentPane.add(btnNewButton);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(74, 53, 150, 20);
		contentPane.add(pfSenha);
	}
}
