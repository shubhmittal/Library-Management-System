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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CHANGE_PASSWORD extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHANGE_PASSWORD frame = new CHANGE_PASSWORD();
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
	public CHANGE_PASSWORD() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblChangePassword = new JLabel("CHANGE PASSWORD");
		lblChangePassword.setFont(new Font("Algerian", Font.ITALIC, 14));
		
		JLabel lblEnterOldPassword = new JLabel("ENTER OLD PASSWORD");
		
		passwordField = new JPasswordField();
		
		JLabel lblEnterNewPassword = new JLabel("ENTER NEW PASSWORD");
		
		passwordField_1 = new JPasswordField();
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() 
		{
			//30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 30 
			public void actionPerformed(ActionEvent arg0)
			{
				int i=0;
				int count=0;
				String s1= textField.getText();
				//System.out.println(s1);
				String s2=String.copyValueOf(passwordField.getPassword());
				//System.out.println(s2);
				String s3=String.copyValueOf(passwordField_1.getPassword());
				//System.out.println(s3);
				
				Connection con= DBinfo.getConn("library");
				String query="select * from registration where username=?";
				String query1="update registration set password=? where username=?";
				try 
				{
					PreparedStatement ps= con.prepareStatement(query);
					PreparedStatement ps1=con.prepareStatement(query1);
					ps.setString(1,s1);
					ResultSet res=ps.executeQuery();
					
					ps1.setString(1,s3);
					ps1.setString(2,s1);
					while(res.next())
					{
						if(s1.equals(res.getString(4)))
						{
							if(s2.equals(res.getString(5)))
							{
								//Connection con1= DBinfo.getConn("library");
								//String query1="update registration set password=? where username=?";
//								try
//								{
								//PreparedStatement ps1=con1.prepareStatement(query1);
//								ps1.setString(1,s3);
//								ps1.setString(2,s1);
								ps1.executeUpdate();
								count++;
//								}
//								catch (Exception e)
//								{
//									System.out.println(e);
//								}
							}
							
							break;
						}
					}
					
				}
				catch (SQLException e) 
				{
					System.out.println(e);
				}
				if(count==0)
				{
					JOptionPane.showMessageDialog(getParent(), "check username and password ","error", JOptionPane.ERROR_MESSAGE);
				}
				if(count>0)
				{
					JOptionPane.showMessageDialog(getParent(), "password updated","done", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
			}
		});
		btnSave.setFont(new Font("Segoe UI Black", Font.ITALIC, 12));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				passwordField.setText(null);
				passwordField_1.setText(null);
			}
		});
		btnReset.setFont(new Font("Segoe UI Black", Font.ITALIC, 12));
		
		JLabel lblEnterUsername = new JLabel("ENTER USERNAME");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterNewPassword)
								.addComponent(lblEnterOldPassword)
								.addComponent(lblEnterUsername)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(101)
							.addComponent(btnSave)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnReset)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(passwordField_1, 152, 152, Short.MAX_VALUE)
						.addComponent(textField))
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addComponent(lblChangePassword, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChangePassword)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterOldPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterNewPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
