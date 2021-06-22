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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class FIRSTPROGRAM_CREATEDATABASE extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIRSTPROGRAM_CREATEDATABASE frame = new FIRSTPROGRAM_CREATEDATABASE();
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
	public FIRSTPROGRAM_CREATEDATABASE() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 275);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCreateDatabase = new JLabel("CREATE DATABASE");
		lblCreateDatabase.setFont(new Font("Algerian", Font.ITALIC, 18));
		
		JLabel lblEnterDatabaseName = new JLabel("Enter DataBase Name");
		lblEnterDatabaseName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//8888888888888888888888888888888888888888888888888888888
				Connection con=DBinfo.getConn("test");
				String dbName=textField.getText();
				String query="create database "+dbName;
				try
				{
					PreparedStatement ps=con.prepareStatement(query);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(getParent(), "database created","done", JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(getParent(), e, "error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCreate.setBackground(SystemColor.inactiveCaptionBorder);
		btnCreate.setForeground(Color.RED);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton button = new JButton("Reset");
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.addActionListener(new ActionListener()
		{
			//999999999999999999999999999999999999999999999999999999999999999999999
			public void actionPerformed(ActionEvent arg0)
			{
				textField.setText(null);
			}
		});
		
		JButton button_1 = new JButton("Drop");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		button_1.setForeground(Color.RED);
		button_1.addActionListener(new ActionListener()
		{
			//10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10
			public void actionPerformed(ActionEvent arg0) 
			{
				String dbName=textField.getText();
				//important and new
				int i=JOptionPane.showConfirmDialog(getParent(),"do u really want to drop databasse: "+dbName);
				//System.out.println(i);
				if(i==0)
				{
					Connection con=DBinfo.getConn("test");
					String query="drop database "+dbName;
					
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(getParent(),"Database dropped", "done", JOptionPane.INFORMATION_MESSAGE);
						textField.setText(null);
					} 
					catch (Exception e) 
					{
						//e.printStackTrace();
						JOptionPane.showMessageDialog(getParent(), e, "error", JOptionPane.ERROR_MESSAGE);
						
					}
				}
				else
				{
					
				}
			}
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(120)
							.addComponent(lblCreateDatabase))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEnterDatabaseName, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_1))))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateDatabase)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterDatabaseName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
