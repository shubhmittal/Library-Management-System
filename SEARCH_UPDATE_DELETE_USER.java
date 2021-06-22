import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SEARCH_UPDATE_DELETE_USER extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEARCH_UPDATE_DELETE_USER frame = new SEARCH_UPDATE_DELETE_USER();
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
	public SEARCH_UPDATE_DELETE_USER() {
		setTitle("SEARCH/UPDATE/DELETE USER");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSearchByUsername = new JLabel("SEARCH BY USERNAME");
		lblSearchByUsername.setFont(new Font("Algerian", Font.ITALIC, 14));
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEnter = new JLabel("ENTER USERNAME");
		
		JLabel lblNewLabel = new JLabel("NAME");
		
		JLabel lblMobile = new JLabel("MOBILE");
		
		JLabel lblEmail = new JLabel("EMAIL");
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int i=0;
				//32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 32 
				String s1=textField.getText();
				Connection con= DBinfo.getConn("library");
				String query="select * from registration where username=?";
				try 
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,s1);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						i=1;
						String s2=res.getString("Name");
						String s3=res.getString("Mobile");
						String s4= res.getString("email");
						textField.setText(s1);
						textField_1.setText(s2);
						textField_2.setText(s3);
						textField_3.setText(s4);
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),"username doesn't exist", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() 
		{
			//33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 33 
			public void actionPerformed(ActionEvent arg0) 
			{
				int i=0;
				String s1=textField.getText();
				String s2=textField_1.getText();
				String s3=textField_2.getText();
				String s4=textField_3.getText();
				Connection con=DBinfo.getConn("library");
				String query="update registration set Name=?,Mobile=?,email=? where username=?";
				try 
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1,s2);
					ps.setString(2,s3);
					ps.setString(3,s4);
					ps.setString(4,s1);
					i=ps.executeUpdate();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "fields updated","done",JOptionPane.INFORMATION_MESSAGE);
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "fields not updated","error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 34 
				int j=0;
				String s1=textField.getText();
				int i=JOptionPane.showConfirmDialog(getParent(),"do u really want to drop "+s1);
				if(i==0)
				{
					Connection con=DBinfo.getConn("library");
					String query="delete from registration where username=?";
					try 
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,s1);
						j=ps.executeUpdate();
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
				
				else
				{
					
				}
				if(j==1)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" deleted","done",JOptionPane.INFORMATION_MESSAGE);
				}
				if(j==0)
				{
					JOptionPane.showMessageDialog(getParent(), s1+" not exist","error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnViewUsersBefore = new JButton("VIEW USERS BEFORE DELETION");
		btnViewUsersBefore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				new VIEW_ALL_USERS().setVisible(true);
			}
		});
		btnViewUsersBefore.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(lblSearchByUsername))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnter)
								.addComponent(lblNewLabel)
								.addComponent(lblMobile)
								.addComponent(lblEmail))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnViewUsersBefore, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSearch)
									.addGap(30)
									.addComponent(btnUpdate)
									.addGap(47)
									.addComponent(btnDelete)))))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearchByUsername)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnter)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(btnUpdate)
						.addComponent(btnDelete))
					.addGap(30)
					.addComponent(btnViewUsersBefore)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
