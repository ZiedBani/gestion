package gestion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gestion.matiere;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

    public class login {
      private JFrame frame;
	  private JTextField txtad;
	  private JPasswordField txtps;
     
	/* * Launch the application. */ 
    public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
			     	} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
          }
		 });
	}
     
	/** Create the application. */
	public login() {
		initialize();
	}
    /* Initialize the contents of the frame. */
	    private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(180, 180, 180));
		frame.setBounds(100, 100, 814, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Enseignants");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(181, 38, 393, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(180, 180, 180));
		panel.setBackground(new Color(212, 212, 212));
		panel.setBounds(139, 143, 516, 267);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(65, 67, 79, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(65, 143, 139, 28);
		panel.add(lblNewLabel_2);
		
		txtad = new JTextField();
		txtad.setBounds(252, 75, 148, 20);
		panel.add(txtad);
		txtad.setColumns(10);
		
		txtps = new JPasswordField();
		txtps.setBounds(252, 151, 148, 20);
		panel.add(txtps);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String pas=txtps.getText();
				String address=txtad.getText();
				
			if (pas.contains("enseignant") && address.contains("enseignant"))
			{
				txtps.setText(null);
				txtad.setText(null);
					
				matiere m =new matiere();
				m.getFrame().setVisible(true);
					
				}
			else {
			   JOptionPane.showConfirmDialog(null, "Invalid Address","Address Error",JOptionPane.ERROR_MESSAGE);
						txtps.setText(null);
						txtad.setText(null);
					
				}}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(479, 453, 137, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  
			{
				JFrame freLoginSystem = new JFrame("EXIT");
				if (JOptionPane.showConfirmDialog(freLoginSystem, "Vous voulez sortir ?" , "Login" , JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}	
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(636, 453, 140, 31);
		frame.getContentPane().add(btnNewButton_1);
	}
}
