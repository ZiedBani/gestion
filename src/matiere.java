

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
public class matiere {

	private JFrame frame;
	private JTextField txtidm;
	private JTextField txtnom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					matiere window = new matiere();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public matiere() {
		initialize();
		Connect();
		table_load();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField txtidm1;
	public void Connect()
    {
        try {
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
	    pst = con.prepareStatement("select * from matiere");
	    rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	     catch (SQLException e)
	     {
	     e.printStackTrace();
	  }
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("matiere");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(344, 28, 102, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 84, 400, 276);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("idmatiere");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(51, 79, 91, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("nom matiere");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(51, 174, 111, 22);
		panel.add(lblNewLabel_1_1);
		
		txtidm = new JTextField();
		txtidm.setBounds(187, 84, 127, 19);
		panel.add(txtidm);
		txtidm.setColumns(10);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		txtnom.setBounds(187, 179, 127, 19);
		panel.add(txtnom);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String idmatiere,nommatiere;
				idmatiere=txtidm.getText();
				nommatiere=txtnom.getText();
				try {
					pst = con.prepareStatement("insert into matiere(idmatiere,nommatiere) values(?,?)");
					pst.setString(1, idmatiere);
					            pst.setString(2, nommatiere);
					            pst.executeUpdate();
					            JOptionPane.showMessageDialog(null, "Matiere Ajouter!!!!!");
					            table_load();
					          
					            txtidm.setText("");
					            txtnom.setText("");
					            
					            txtnom.requestFocus();
					}
					 
					            catch (SQLException e1) {
					e1.printStackTrace();
					}
					}
		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(50, 388, 102, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Modifier");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			      String idmatiere,nommatiere,id;

					 idmatiere=txtidm.getText();
			         nommatiere=txtnom.getText();
			         id=txtidm1.getText();
					 
					 

					 try {
						 pst = con.prepareStatement("UPDATE matiere set idmatiere= ? ,nommatiere= ?  where idmatiere=?");
						             pst.setString(1, idmatiere);
	    				             pst.setString(2, nommatiere);
	    				             pst.setString(3, id);
	    				             
						           
						            
						             
						             
						             
						             pst.executeUpdate();
						             JOptionPane.showMessageDialog(null, "Matiere Modifier!!!!!");
						             table_load();
						           
						             txtidm.setText("");
						             txtnom.setText("");
						            
						             txtidm.requestFocus();
						 }
						  
						             catch (SQLException e1) {
						 e1.printStackTrace();
						 }
						 }
					
			
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSupprimer.setBounds(181, 388, 102, 37);
		frame.getContentPane().add(btnSupprimer);
		
		JButton btnModifier = new JButton("Supprimer");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                String idm;
                      idm  = txtidm1.getText();
            try {
                      pst = con.prepareStatement("delete from matiere where idmatiere =?");
                      pst.setString(1, idm);
                      pst.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Matiere Supprimer!!!!!");
                      table_load();
   
                      txtidm.setText("");
                      txtnom.setText("");
     
                      txtidm.requestFocus();
}

     catch (SQLException e1) {
e1.printStackTrace();
}
				
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnModifier.setBounds(325, 388, 121, 37);
		frame.getContentPane().add(btnModifier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(483, 84, 351, 276);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Recherche", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 446, 400, 105);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("idmatiere");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(40, 40, 91, 22);
		panel_1.add(lblNewLabel_1_2);
		
		txtidm1 = new JTextField();
		txtidm1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) 
			{
				{
					try {
					          
					            String idmatiere = txtidm1.getText();
					 
					                pst = con.prepareStatement("select idmatiere,nommatiere from matiere where idmatiere = ?");
					                pst.setString(1, idmatiere);
					                ResultSet rs = pst.executeQuery();
					 
					            if(rs.next()==true)
					            {
					                String idmatiere1=rs.getString(1);
					                String nommatiere=rs.getString(2);

					             
					               
					                txtidm.setText(idmatiere);
					                txtnom.setText(nommatiere);
					                
					                
					            }  
					            else
					            {
					               
					                txtidm.setText("");
					                txtnom.setText("");

					                
					            }
					            
					 
					 
					        }
					catch (SQLException ex) {
					          
					        }
					}
			
			}
			
		});
		txtidm1.setColumns(10);
		txtidm1.setBounds(187, 45, 127, 19);
		panel_1.add(txtidm1);
	}
}
