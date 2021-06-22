//by me
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LOGIN()
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		setBounds(100, 100, 495, 449);
		setLocationRelativeTo(this);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblEnterUsername = new JLabel("Enter UserName");
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		
		JButton btnLoginNow = new JButton("Login Now");
		btnLoginNow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int flag=0;
				String utype="";
				//4444444444444444444444444444444444444444444444444444444444444444444
				String s1=textField.getText();
				String s2=String.copyValueOf(passwordField.getPassword());//conversion into array
				
				Connection con=DBinfo.getConn("library");
				String query="select * from registration where username=? and password=?";
				
				try
				{
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1,s1);
					ps.setString(2,s2);
					
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						flag=1;
						utype=res.getString(6);//get the user type
						break;
					} 
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				if(flag==1 && utype.equalsIgnoreCase("admin"))
				{
					ADMINPAGE ap=new ADMINPAGE();
					ap.setVisible(true);
					dispose();
				}
				if(flag==1 && utype.equalsIgnoreCase("student"))
				{
					STUDENTPAGE sp=new STUDENTPAGE();
					sp.setVisible(true);
					dispose();
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(getParent(),"wrong user name or passsword","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() 
		{
			//333333333333333333333333333333333333333333333333333333333333333333333
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewUserRegister = new JButton("new user register now");
		btnNewUserRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				REGISTRATION rg= new REGISTRATION();
				rg.setVisible(true);
				dispose();
			}
		});
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("login."));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("login."));
		
		ImageIcon icon= new ImageIcon("login.jpg");
		JLabel lblNewLabel_2 = new JLabel(icon);
		
		ImageIcon icon1= new ImageIcon("login.png");
		JLabel lblNewLabel_3 = new JLabel(icon1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(100)
							.addComponent(btnNewUserRegister, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(btnLoginNow)
							.addGap(71)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblEnterUsername)
								.addComponent(lblEnterPassword))
							.addGap(69)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, 149, 149, 149)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addComponent(lblLoginPage, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addComponent(lblNewLabel_3)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(lblLoginPage, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow)
						.addComponent(btnReset))
					.addGap(18)
					.addComponent(btnNewUserRegister)
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
