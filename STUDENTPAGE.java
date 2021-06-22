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

public class STUDENTPAGE extends JFrame {

	private JPanel contentPane;
	public STUDENTPAGE() 
	{
		//77777777777777777777777777777777777777
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 358);
		setLocationRelativeTo(this);
		setTitle("STUDENT PAGE");
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnSearchBooks = new JButton("SEARCH BOOKS");
		btnSearchBooks.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new SEARCH_BY_STUDENT().setVisible(true);
			}
		});
		btnSearchBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnSearchBooks);
		
		JButton btnViewAllBooks = new JButton("VIEW ALL BOOKS");
		btnViewAllBooks.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new VIEW_ALL_BOOKS().setVisible(true);
			}
		});
		btnViewAllBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnViewAllBooks);
		
		JButton btnViewSelfAccount = new JButton("VIEW SELF ACCOUNT");
		btnViewSelfAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new VIEW_SELF_ACCOUNT_STUDENT().setVisible(true);
			}
		});
		btnViewSelfAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnViewSelfAccount);
		
		JButton btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new CHANGE_PASSWORD().setVisible(true);
			}
		});
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnChangePassword);
	}

}
