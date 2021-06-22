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
import javax.swing.JTextField;
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
import javax.swing.LayoutStyle.ComponentPlacement;

public class SUBMIT_BOOK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUBMIT_BOOK frame = new SUBMIT_BOOK();
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
	public SUBMIT_BOOK() {
		setTitle("SUBMISSION OF BOOK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 274);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSubmissionOfBook = new JLabel("SUBMITTED DATE");
		lblSubmissionOfBook.setFont(new Font("Algerian", Font.ITALIC, 14));
		
		JLabel lblEnterBookid = new JLabel("ENTER BOOKID");
		lblEnterBookid.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int i=0;
				int quant=0;
				int total=0;
				String s1=textField.getText();//bookid
				String s2=textField_1.getText();//actual submitted date
				//System.out.println(s2);
				
				Connection con=DBinfo.getConn("library");
				String query="select * from issuebook";
				String query1="select * from book";
				String query2="update book set Quantity=? where ID=?";
				String query3="update issuebook set ReturnDate=? where BOOKID=?";
				try 
				{
					PreparedStatement ps= con.prepareStatement(query);//issuebook
					PreparedStatement ps1= con.prepareStatement(query1);//book
					PreparedStatement ps2= con.prepareStatement(query2);
					PreparedStatement ps3= con.prepareStatement(query3);
					ResultSet res=ps.executeQuery();//issuebook
					ResultSet res1=ps1.executeQuery();//book
		
					while(res.next())
					{
						if(s1.equals(res.getString("BOOKID")) && res.getString("ReturnDate")==null)
						{
							String s5=res.getString("issueDate");
							String s6=res.getString("ExpectedReturnDate");
							System.out.println(s5);
							System.out.println(s6);
							//String s2=actual return date
							Date d1;
							Date d2;
							Date d3;
							try
							{
								d1 = new SimpleDateFormat("yyyy-M-dd").parse((String)(s5));//issuedate
							    d2 = new SimpleDateFormat("yyyy-M-dd").parse((String)(s6));//Expected return date
								d3 = new SimpleDateFormat("yyyy-M-dd").parse((String)(s2));//Actual return date

								long diff21a = d2.getTime() - d1.getTime();//difference between issue date and expected return date
								
								long diff21b=(diff21a / (1000 * 60 * 60 * 24));//difference between issue date and expected return date
								
								
								
								long diff31a = d3.getTime() - d1.getTime();//difference between issue date and return date
								
								long diff31b=(diff31a / (1000 * 60 * 60 * 24));//difference between issue date and return date
								
								
								long diff32a = d3.getTime() - d2.getTime();//difference between expected return date and return date
								
								long diff32b=(diff32a / (1000 * 60 * 60 * 24));//difference between expected return date and return date
								
								if(diff31b>=0)
								{
									if(diff31b<=diff21b)
									{
										while(res1.next())
										{
											if(s1.equals(res1.getString("ID")))
											{
												 i=1;
												String noOfBooks=res1.getString(10);
												quant=Integer.parseInt(noOfBooks);
												total=Integer.parseInt(noOfBooks)+1;
												String s3=Integer.toString(total);
												ps2.setString(1, s3);
												ps2.setString(2, s1);
												ps2.executeUpdate();
												ps3.setString(1,s2);
												ps3.setString(2,s1);
												ps3.executeUpdate();
											}
										}
										JOptionPane.showMessageDialog(getParent(), "book returned","done",JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										while(res1.next())
										{
											if(s1.equals(res1.getString("ID")))
											{
												 i=1;
												String noOfBooks=res1.getString(10);
												quant=Integer.parseInt(noOfBooks);
												total=Integer.parseInt(noOfBooks)+1;
												String s3=Integer.toString(total);
												ps2.setString(1, s3);
												ps2.setString(2, s1);
												ps2.executeUpdate();
												ps3.setString(1,s2);
												ps3.setString(2,s1);
												ps3.executeUpdate();
											}
										}
										JOptionPane.showMessageDialog(getParent(), "book returned, submit fine of "+diff32b+" rs.","done",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(getParent(), "enter correct return date","done",JOptionPane.INFORMATION_MESSAGE);
								}
								
								
							} 
							catch (ParseException e) 
							{
								
								e.printStackTrace();
							}
						}
					}
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), "book not found","information",JOptionPane.INFORMATION_MESSAGE);
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "book submitted successfully","information",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblEnterSubmissionDate = new JLabel("ENTER SUBMISSION DATE");
		lblEnterSubmissionDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblSubmissionOfBook, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(135)
									.addComponent(btnSubmit))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnterBookid)
										.addComponent(lblEnterSubmissionDate))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, Alignment.LEADING))))
					.addGap(77))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSubmissionOfBook)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterBookid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterSubmissionDate)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnSubmit)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
