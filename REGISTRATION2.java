//by me 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class REGISTRATION2 extends JFrame {
	JComboBox<String> comboBox;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public REGISTRATION2() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 350);
		setLocationRelativeTo(this);
		//for smoothness
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
		setTitle("REGISTRATION");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		
		JLabel lblEnterMobile = new JLabel("Enter Mobile");
		
		JLabel lblEnterEmail = new JLabel("Enter Email");
		
		JLabel lblEnterUsername = new JLabel("Enter UserName");
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		
		JLabel lblUsertype = new JLabel("UserType");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		String value[]= {"Student","Admin"};
		comboBox =new JComboBox(value);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				//222222222222222222222222222222222222222222222222222222222222222
				int i=0;
				int count=0;
				String s1=textField.getText();
				String s2=textField_1.getText();
				String s3=textField_2.getText();
				String s4=textField_3.getText();
				String s5=textField_4.getText();
				String s6=(String) comboBox.getSelectedItem();
				if(s1.length()==0 || s2.length()==0 || s3.length()==0 || s4.length()==0 || s5.length()==0 || s6.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "All Fields should be filled","error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Connection con=DBinfo.getConn("library");
					String query="insert into registration values(?,?,?,?,?,?)";
					String query1="select * from registration";
					
					try
					{
						PreparedStatement ps= con.prepareStatement(query);
						PreparedStatement ps1= con.prepareStatement(query1);
						ResultSet res=ps1.executeQuery();
						while(res.next())
						{
							//555555555555555555555555555555555555555555555555
							if(s4.equals(res.getString(4)))
								{
									//JOptionPane.showMessageDialog(getParent(), "enter another username","error",JOptionPane.ERROR_MESSAGE);
									count++;
									break;
								}
						}
						if(count>0)
						{
							JOptionPane.showMessageDialog(getParent(), "enter another username","error",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							ps.setString(1,s1);
							ps.setString(2,s2);
							ps.setString(3,s3);
							ps.setString(4,s4);
							ps.setString(5,s5);
							ps.setString(6,s6);
							i=ps.executeUpdate();
						}
						
						
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
					if(i==1)
					{
						JOptionPane.showMessageDialog(getParent(),"Registration done successfully!!","Done",JOptionPane.INFORMATION_MESSAGE);
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						comboBox.setSelectedIndex(0);
					}
					if(i==0)
					{
						JOptionPane.showMessageDialog(getParent(), "Registration failed", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener()
		{
			//11111111111111111111111111111111111111111111111111111111111
			public void actionPerformed(ActionEvent arg0) 
			{
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		
		JButton btnLoginNow = new JButton("LOGIN NOW");
		btnLoginNow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				LOGIN lg= new LOGIN();
				lg.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblRegistrationPage = new JLabel("REGISTRATION PAGE");
		
//		String value[]= {"Admin","Student"};
//		JComboBox comboBox = new JComboBox(value);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsertype)
								.addComponent(lblEnterUsername)
								.addComponent(lblEnterEmail)
								.addComponent(lblEnterMobile)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnSave)
									.addComponent(lblEnterPassword)))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnReset)
									.addGap(34)
									.addComponent(btnLoginNow))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(lblRegistrationPage)))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistrationPage)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterMobile)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterEmail)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsertype)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnLoginNow))
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
