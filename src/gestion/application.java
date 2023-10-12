package gestion;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;



    public class application {
      public static JFrame frame;
	  private JTextField txtnom;
	  private JTextField txtprenom;
	  private JTextField txtcin;
	  private JTextField txtaddress;
	  private JTextField txtidmatiere;
	  private JTable table;
    /* * Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	public void run() 
	{
			try 
			    {
				application window = new application();
				window.frame.setVisible(true);
				}
			catch (Exception e) 
			    {
					e.printStackTrace();
				}
			}
		});
	}
    /* * Create the application.*/
	public application() {
	  	initialize();
		Connect();
		table_load();
	}
    Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table_1;
	private JTextField txtiden2;
	private JTextField txtiden1;
	 public void Connect()
	    {
	        try 
	        {
 	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/enseigants", "root","Korba-8070");
	        }
	        catch (ClassNotFoundException ex)
	        {
	           ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	  public void table_load()
	       {
	       try
	       {
	           pst = con.prepareStatement("select * from enseignant");
	           rs = pst.executeQuery();
	           table.setModel(DbUtils.resultSetToTableModel(rs));
	       }
	       catch (SQLException e)
	       {
	           e.printStackTrace();
	       }
	       }
	 /*** Initialize the contents of the frame.*/
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(180, 180, 180));
		frame.setBounds(100, 100, 1012, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enseignant");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(360, -15, 249, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(212, 212, 212));
		panel.setBounds(26, 62, 505, 327);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 59, 77, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("prenom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(40, 110, 77, 41);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("cin");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(40, 165, 77, 41);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(40, 216, 77, 41);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("idmatiere");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(40, 267, 112, 41);
		panel.add(lblNewLabel_1_4);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(200, 69, 190, 27);
		panel.add(txtnom);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(200, 120, 190, 27);
		panel.add(txtprenom);
		
		txtcin = new JTextField();
		txtcin.setColumns(10);
		txtcin.setBounds(200, 175, 190, 27);
		panel.add(txtcin);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(200, 226, 190, 27);
		panel.add(txtaddress);
		
	  	txtidmatiere = new JTextField();
		txtidmatiere.setColumns(10);
		txtidmatiere.setBounds(200, 277, 190, 27);
		panel.add(txtidmatiere);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("iden");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(42, 19, 52, 22);
		panel.add(lblNewLabel_2_1_1);
		
		txtiden2 = new JTextField();
		txtiden2.setColumns(10);
		txtiden2.setBounds(200, 20, 190, 27);
		panel.add(txtiden2);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nom,prenom,cin,address,idmatiere,iden;

				 nom=txtnom.getText();
				 prenom=txtprenom.getText();
				 cin=txtcin.getText();
				 address=txtaddress.getText();
				 idmatiere=txtidmatiere.getText();
				 iden=txtiden2.getText();
				 

				 try 
				 {
				 pst = con.prepareStatement("insert into enseignant(iden,nom,prenom,cin,address,idmatiere) values(?,?,?,?,?,?)");
	             pst.setString(1, iden);
	             pst.setString(2, nom);
   	             pst.setString(3, prenom);
   	             pst.setString(4,cin);
   	             pst.setString(5, address);
	             pst.setString(6, idmatiere);
					        
	             pst.executeUpdate();
	             JOptionPane.showMessageDialog(null, "Enseignant Ajoutee!!!!!");
	             table_load();
					           
			     txtiden2.setText("");
			     txtnom.setText("");
	             txtprenom.setText("");
	             txtcin.setText("");
	             txtaddress.setText("");
	             txtidmatiere.setText("");
	             txtnom.requestFocus();
				 }
					  
				 catch (SQLException e1)
				     {
					 e1.printStackTrace();
					 }
		}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(94, 413, 113, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  
			{
			      String  iden;
			      iden=txtiden1.getText();
					  try 
					  {
						 pst = con.prepareStatement("Delete from enseignant  where iden=?");
			             pst.setString(1,iden);
			             pst.executeUpdate();
		                 JOptionPane.showMessageDialog(null, "Enseignant Supprimer!!!!!");
 			             table_load();
 			             txtiden2.setText("");
 			             txtnom.setText("");
 			             txtprenom.setText("");
 			             txtcin.setText("");
 			             txtaddress.setText("");
 			             txtidmatiere.setText("");
			             txtiden2.requestFocus();
					  }
		              catch (SQLException e1)
					  {
						 e1.printStackTrace();
					  }
			}
		});
		
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setBounds(717, 501, 113, 50);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				      String iden,nom,prenom,cin,address,idmatiere,id ;
					  iden=txtiden2.getText();
				      nom=txtnom.getText();
				      prenom=txtprenom.getText();
				      cin=txtcin.getText();
				      address=txtaddress.getText();
				      idmatiere=txtidmatiere.getText();
				      id=txtiden2.getText();
				 try
				  {
					   pst = con.prepareStatement("UPDATE enseignant set iden=?, nom= ? ,prenom= ? ,cin= ? ,address=?, idmatiere=? where iden=?");
		               pst.setString(1,iden);
		               pst.setString(2, nom);
    	               pst.setString(3, prenom);
					   pst.setString(4,cin);
					   pst.setString(5, address);
                       pst.setString(6, idmatiere);
					   pst.setString(7,id);
					   pst.executeUpdate();
					   JOptionPane.showMessageDialog(null, "Enseignant Modifier!!!!!");
					   table_load();
					   txtnom.setText("");
					   txtprenom.setText("");
					   txtcin.setText("");
					   txtaddress.setText("");
					   txtidmatiere.setText("");
					   txtnom.requestFocus();
					 }
					  
				 catch (SQLException e1) 
				     {
					 e1.printStackTrace();
					 }
				}
		});
		
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifier.setBounds(572, 501, 113, 50);
		frame.getContentPane().add(btnModifier);
		
		table = new JTable();
		table.setBounds(572, 413, 313, -328);
		frame.getContentPane().add(table);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFrame freLoginSystem = new JFrame("EXIT");
				if (JOptionPane.showConfirmDialog(freLoginSystem, "Vous voulez sortir !!!" , "Login" , JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}	
		});
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(284, 413, 113, 50);
		frame.getContentPane().add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(212, 212, 212));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Recherche", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(26, 478, 505, 96);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("iden");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(28, 40, 52, 22);
		panel_1.add(lblNewLabel_2_1);
		
		txtiden1 = new JTextField();
		txtiden1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				try 
				{
					  String iden2 = txtiden1.getText();
					  pst = con.prepareStatement("select iden,nom,prenom,cin,address,idmatiere from enseignant where iden = ?");
					  pst.setString(1, iden2);
					  ResultSet rs = pst.executeQuery();
			                     if(rs.next()==true)
					               {
					                String iden=rs.getString(1);
					                String nom = rs.getString(2);
					                String prenom = rs.getString(3);
					                String cin = rs.getString(4);
					                String address=rs.getString(5);
					                String idmatiere=rs.getString(6);
					                
					                txtiden2.setText(iden);
					                txtnom.setText(nom);
					                txtprenom.setText(prenom);
					                txtcin.setText(cin);
					                txtaddress.setText(address);
					                txtidmatiere.setText(idmatiere);
					                }  
					            else
					                {
					                txtiden2.setText(iden2);
					                txtnom.setText("");
					                txtprenom.setText("");
					                txtcin.setText("");
					                txtaddress.setText("");
					                txtidmatiere.setText("");
					                }
					            
					 
					 
				}
					catch (SQLException ex) 
				    {
					          
				    }
					}
				});
		txtiden1.setColumns(10);
		txtiden1.setBounds(174, 35, 190, 27);
		panel_1.add(txtiden1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(554, 76, 418, 304);
		frame.getContentPane().add(scrollPane);
		
		table= new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				matiere a =new matiere();
				a.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(897, 506, 91, 38);
		frame.getContentPane().add(btnNewButton_1);
	}
}
