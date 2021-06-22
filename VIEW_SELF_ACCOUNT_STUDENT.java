import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VIEW_SELF_ACCOUNT_STUDENT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEW_SELF_ACCOUNT_STUDENT frame = new VIEW_SELF_ACCOUNT_STUDENT();
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
	public VIEW_SELF_ACCOUNT_STUDENT() {
		setTitle("VIEW ACCOUNT DETAILS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAccountDetails = new JLabel("ACCOUNT DETAILS");
		lblAccountDetails.setFont(new Font("Algerian", Font.ITALIC, 14));
		
		JLabel lblEnterUsername = new JLabel("ENTER USERNAME");
		
		JLabel lblEnterPassword = new JLabel("ENTER PASSWORD");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int i=0;
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
						i=1;
						if(s1.equals(res.getString("username")) && s2.equals(res.getString("password")))
						{
							JFrame frm= new JFrame("Showing Details");
							frm.setLayout(new FlowLayout());
							frm.setSize(400,300);
							frm.setLocationRelativeTo(getParent());
							frm.setVisible(true);
							
							JButton btn1=new JButton("Personal information");
							JButton btn2= new JButton("Book Account Information");
							
							frm.add(btn1);
							frm.add(btn2);
							
							btn1.addActionListener(new ActionListener()
							{
								
								@Override
								public void actionPerformed(ActionEvent arg0) 
								{
									JFrame frm= new JFrame("showing personal information of username: "+s1);
									frm.setSize(1000, 500);
									frm.setLocationRelativeTo(getParent());
									frm.setVisible(true);
									
									DBinfo.getPersonalDetail(s1);
									JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
									JScrollPane pane= new JScrollPane(table);
									frm.add(pane);
								}
							});
							
							
							btn2.addActionListener(new ActionListener() 
							{
								
								@Override
								public void actionPerformed(ActionEvent arg0) 
								{
									JFrame frm= new JFrame("showing book information of username: "+s1);
									frm.setSize(1000, 500);
									frm.setLocationRelativeTo(getParent());
									frm.setVisible(true);
									
									DBinfo.getIssueBook(s1);
									JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
									JScrollPane pane= new JScrollPane(table);
									frm.add(pane);
									
								}
							});
						}
					}
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "enter correct username or password","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterUsername)
								.addComponent(lblEnterPassword))
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSearch)
								.addComponent(lblAccountDetails, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAccountDetails)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addComponent(btnSearch)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
