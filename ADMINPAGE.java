// by me
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ADMINPAGE extends JFrame {

	private JPanel contentPane;
	public ADMINPAGE() 
	{
		//6666666666666666666666666666666666666666666666666666
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 434);
		setLocationRelativeTo(this);
		setTitle("ADMIN PAGE");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnAddNewBook = new JButton("Add new book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new ADDNEWBOOK().setVisible(true);
			//	dispose();
				
			}
		});
		btnAddNewBook.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnAddNewBook);
		
		JButton btnSearchupdatedeleteBook = new JButton("search/update/delete book");
		btnSearchupdatedeleteBook.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new SEARCH_UPDATE_DELETE().setVisible(true);
				//dispose();
			}
		});
		btnSearchupdatedeleteBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSearchupdatedeleteBook);
		
		JButton btnIssueBook = new JButton("issue book");
		btnIssueBook.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new ISSUE_BOOK().setVisible(true);
				//dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnIssueBook);
		
		JButton btnSubmitBook = new JButton("submit book");
		btnSubmitBook.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SUBMIT_BOOK().setVisible(true);
			}
		});
		btnSubmitBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSubmitBook);
		
		JButton btnAddNewUser = new JButton("add new user");
		btnAddNewUser.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new REGISTRATION2().setVisible(true);
				//registration2 gives option of both admin and student
				//dispose();
			}
		});
		btnAddNewUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnAddNewUser);
		
		JButton btnSearchupdatedeleteUser = new JButton("search/update/delete user");
		btnSearchupdatedeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new SEARCH_UPDATE_DELETE_USER().setVisible(true);
			}
		});
		btnSearchupdatedeleteUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSearchupdatedeleteUser);
		
		JButton btnViewAllUser = new JButton("view all user(who issued the book)");
		btnViewAllUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new VIEW_ALL_USERS().setVisible(true);
			}
		}); 
		btnViewAllUser.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(btnViewAllUser);
		
		JButton btnViewAllBook = new JButton("view all book");
		btnViewAllBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new VIEW_ALL_BOOKS().setVisible(true);
			}
		});
		btnViewAllBook.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnViewAllBook);
		
		JButton btnChangeSelfPassword = new JButton("change self password");
		btnChangeSelfPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new CHANGE_PASSWORD().setVisible(true);
				//dispose();
			}
		});
		btnChangeSelfPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnChangeSelfPassword);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
	}

}
