import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIEW_ALL_USERS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEW_ALL_USERS frame = new VIEW_ALL_USERS();
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
	public VIEW_ALL_USERS() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblViewUsers = new JLabel("VIEW ALL USERS");
		lblViewUsers.setFont(new Font("Algerian", Font.BOLD, 14));
		
		JLabel lblViewAllUsers = new JLabel("VIEW ALL USERS BY");
		
		//29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 
		String value[]= {"All","Enter Username","not submitted book"};
		JComboBox comboBox = new JComboBox(value);
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 35 
				String option=(String) comboBox.getSelectedItem();
				if(option.equalsIgnoreCase("All"))
				{
					JFrame frm= new JFrame("SHOWING ALL USERS");
					frm.setSize(1000, 500);
					frm.setVisible(true);
					//dispose();
					frm.setResizable(false);
					frm.setLocationRelativeTo(getParent());
					DBinfo.getIssueBook();
					
					JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
					JScrollPane pane= new JScrollPane(table);
					frm.add(pane);
					
				}
				if(option.equalsIgnoreCase("Not submitted book"))
				{
					JFrame frm= new JFrame("SHOWING USERS WHO HAS NOT SUBMITTED BOOK");
					frm.setSize(1000, 500);
					frm.setVisible(true);
					//dispose();
					frm.setResizable(false);
					frm.setLocationRelativeTo(getParent());
					DBinfo.getIssueBook1();
					
					JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
					JScrollPane pane= new JScrollPane(table);
					frm.add(pane);
				}
				if(option.equalsIgnoreCase("Enter Username"))
				{
					JFrame frm= new JFrame("enter username");
					frm.setVisible(true);
					frm.setSize(300,200);
					frm.setLocationRelativeTo(getParent());
					frm.setLayout(new FlowLayout());
					JLabel lbl= new JLabel("enter username");
					JTextField ta= new JTextField(15);
					JButton btn=new JButton("SEARCH");
					frm.add(lbl);
					frm.add(ta);
					frm.add(btn);
					
					btn.addActionListener(new ActionListener() 
					{
						
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							String uname=ta.getText();
							JFrame frm= new JFrame("showing table of username: "+uname);
							frm.setSize(1000, 500);
							frm.setLocationRelativeTo(getParent());
							frm.setVisible(true);
							
							DBinfo.getIssueBook(uname);
							JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
							JScrollPane pane= new JScrollPane(table);
							frm.add(pane);
							
							
						}
					});
					
				}
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addComponent(lblViewUsers, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(lblViewAllUsers)
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 163, Short.MAX_VALUE))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblViewUsers)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblViewAllUsers)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnSubmit)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
