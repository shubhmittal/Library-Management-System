import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class SECONDPROGRAM_CREATEALLTABLE extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					SECONDPROGRAM_CREATEALLTABLE frame = new SECONDPROGRAM_CREATEALLTABLE();
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
	public SECONDPROGRAM_CREATEALLTABLE() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCreatingAllTables = new JLabel("Creating all tables");
		
		JLabel lblEnterUrDatabasemust = new JLabel("Enter ur database(must exist already)");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnWantToCreate = new JButton("Want to create database ,click here");
		btnWantToCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new FIRSTPROGRAM_CREATEDATABASE().setVisible(true);
			//dispose();
			}
		});
		
		JButton btnCreatealltables = new JButton("CreateAllTables");
		btnCreatealltables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String dbName=textField.getText();
				Connection con=DBinfo.getConn(dbName);
				String query1="create table registration(Name varchar(50),Mobile varchar(12),email varchar(100),username varchar(25),password varchar(25),usertype varchar(15))";
			    String query2="create table book(ID int(10),Title varchar(100),Author varchar(100),Subject varchar(100),Category varchar(100),Publication varchar(100),ISBN varchar(50),Edition varchar(30),Price varchar(10),Quantity varchar(10))";
			    String query3="create table author(ID int(10) PRIMARY KEY AUTO_INCREMENT,Name varchar(100))";
			    String query4="create table subject(ID int(10) PRIMARY KEY AUTO_INCREMENT,Name varchar(100))";
			    String query5="create table category(ID int(10) PRIMARY KEY AUTO_INCREMENT,Name varchar(100))";
			    String query6="create table publication(ID int(10) PRIMARY KEY AUTO_INCREMENT,Name varchar(100))";
			    String query7="create table issueBook(username varchar(50),BOOKID varchar(50),issueDate varchar(50),ExpectedReturnDate varchar(50),ReturnDate varchar(50))";
			    try
			    {
			    PreparedStatement ps=con.prepareStatement(query7);
			    ps.executeUpdate();
			    ps=con.prepareStatement(query2);ps.executeUpdate();
			    ps=con.prepareStatement(query3);ps.executeUpdate();
			    ps=con.prepareStatement(query4);ps.executeUpdate();
			    ps=con.prepareStatement(query5);ps.executeUpdate();
			    ps=con.prepareStatement(query6);ps.executeUpdate();
			    ps=con.prepareStatement(query1);ps.executeUpdate();
			    JOptionPane.showMessageDialog(getParent(), "All tables created!!","Done",JOptionPane.INFORMATION_MESSAGE);
			    }
			    catch(Exception e1)
			    {
			    JOptionPane.showMessageDialog(getParent(), e1,"Error",JOptionPane.ERROR_MESSAGE);	
			    }
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(187)
							.addComponent(lblCreatingAllTables))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnWantToCreate)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterUrDatabasemust)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCreatealltables)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreatingAllTables)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUrDatabasemust)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCreatealltables)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addComponent(btnWantToCreate)
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
