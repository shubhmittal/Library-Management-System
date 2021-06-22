import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;

public class ISSUE_BOOK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnIssue;
	private JButton btnRegistrationOfNew;
	private JLabel lblEnterUsername;
	private JTextField textField_2;
	private JTextField textField_1;
	private JLabel lblReturnDate;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ISSUE_BOOK frame = new ISSUE_BOOK();
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
	
	
	public ISSUE_BOOK() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Dispose only current
		setBounds(100, 100, 592, 463);
		setLocationRelativeTo(this);
		//for smmothness
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setTitle("ISSUE BOOK");
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JLabel lblAddNewBook = new JLabel("ISSUE BOOK");
		lblAddNewBook.setFont(new Font("Algerian", Font.ITALIC, 14));
		
		lblEnterUsername = new JLabel("ENTER USERNAME");
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		//textField_1 = new JTextField(""+new Date());
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		table = new JTable();
		
		btnIssue = new JButton("ISSUE");
		btnIssue.addActionListener(new ActionListener()
		{
			//31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 31 
			public void actionPerformed(ActionEvent arg0)
			{
				int j=0;
				int i=0;
				int total=0;
				int count=0;
				int count1=0;
				int count2=0;
				int quant=0;
				String s1=textField_2.getText();//username
				String s2=textField.getText();//id
				String s5=textField_1.getText();//issue date
				String s6=textField_3.getText();//return date
				Connection con= DBinfo.getConn("library");
				
				String query="select username from registration";
				String query1="select * from book";
				String query2="update book set Quantity=? where ID=?";
				String query3="insert into issuebook (username,BOOKID,issueDate,ExpectedReturnDate) values (?,?,?,?)";
				if(s1.length()==0 || s2.length()==0 || s5.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(),"all fields should be filled","error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Date d1;
					Date d2;
					try
					{
						d1 = new SimpleDateFormat("yyyy-M-dd").parse((String)s5);
						d2 = new SimpleDateFormat("yyyy-M-dd").parse((String)s6);
						long diff = d2.getTime() - d1.getTime();
						//System.out.println((diff / (1000 * 60 * 60 * 24)));
						long dayDifference=diff / (1000 * 60 * 60 * 24);
						if(dayDifference>0)
						{
							try
							{
								PreparedStatement ps= con.prepareStatement(query);
								PreparedStatement ps1=con.prepareStatement(query1);
								PreparedStatement ps2=con.prepareStatement(query2);
								PreparedStatement ps3=con.prepareStatement(query3);
								ResultSet res=ps.executeQuery();
								ResultSet res1=ps1.executeQuery();
								while(res.next())
								{
									if(s1.equals(res.getString(1)))
									{
										while(res1.next())
										{
											if(s2.equals(res1.getString("ID")))
											{
											
												String noOfBooks=res1.getString(10);
												quant=Integer.parseInt(noOfBooks);
												if(quant==0)
												{
													JOptionPane.showMessageDialog(getParent(), "books are not available","error",JOptionPane.ERROR_MESSAGE);
													count2++;
												}
												else
												{
													total=Integer.parseInt(noOfBooks)-1;
													
													String s4=Integer.toString(total);
													 ps2.setString(1,s4);
													 ps2.setString(2, s2);
													 ps2.executeUpdate();
													 
													 ps3.setString(1, s1);
													 ps3.setString(2, s2);
													 ps3.setString(3, s5);
													 ps3.setString(4, s6);
													 ps3.executeUpdate();
													 textField.setText(null);
													 textField_1.setText(null);
													 textField_2.setText(null);
													 textField_3.setText(null);
												}
												j++;
												break;
												
											}
										}
										
										count++;
										break;
									}
								}
							}
							catch (SQLException e)
							{
								e.printStackTrace();
							}
						}
						if(dayDifference<=0)
						{
							JOptionPane.showMessageDialog(getParent(), "date should be filled correctly","error",JOptionPane.ERROR_MESSAGE);
							count1++;
						}
					} 
					catch (ParseException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				
				}
				
				if(count==0 && count1==0)
				{
					JOptionPane.showMessageDialog(getParent(), "username doesn't exist", "error",JOptionPane.ERROR_MESSAGE);
				}
				if(count>0 && j>0&& count2==0)
				{
					JOptionPane.showMessageDialog(getParent(), "book issued", "done",JOptionPane.INFORMATION_MESSAGE);
				}
				if(count>0 && j==0)
				{
					JOptionPane.showMessageDialog(getParent(), "book not available", "done",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnIssue.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnRegistrationOfNew = new JButton("REGISTRATION OF NEW USER");
		btnRegistrationOfNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new REGISTRATION2().setVisible(true);
			}
		});
		btnRegistrationOfNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblIssueDate = new JLabel("ISSUE DATE(yyyy-mm-dd)");
		
		lblReturnDate = new JLabel("RETURN DATE(yyyy-mm-dd)");
		
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIssueDate)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterUsername)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnIssue)
										.addComponent(lblReturnDate))
									.addGap(35)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblAddNewBook, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
											.addGap(108))
										.addComponent(textField, 209, 216, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnRegistrationOfNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(57))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(lblAddNewBook)
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIssueDate)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReturnDate)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIssue)
						.addComponent(btnRegistrationOfNew))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
