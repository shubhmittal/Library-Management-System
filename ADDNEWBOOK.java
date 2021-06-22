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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;

public class ADDNEWBOOK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	//16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 16 
	JComboBox<String> comboBox,comboBox_2,comboBox_1,comboBox_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDNEWBOOK frame = new ADDNEWBOOK();
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
	//17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17 17
	public String bookID()
	{
		String id="";
		for(int i=1;i<=6; i++)
		{
			id=id+(int)(Math.random()*10);
		}
		return id;
	}
	//15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15
	public void reset()
	{
		textField.setText(bookID());
		textField_1.setText(null);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		//to reset the combo box
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		comboBox_3.setSelectedIndex(0);
		
	}
	
	
	public ADDNEWBOOK() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Dispose only current
		setBounds(100, 100, 477, 616);
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
		setTitle("Add new book");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("SAVE");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String s1=textField.getText();
				String s2=textField_1.getText();
				//combo box
				//for combo box
				String s3=(String) comboBox.getSelectedItem();
				String s4=(String) comboBox_1.getSelectedItem();
				String s5=(String) comboBox_2.getSelectedItem();
				String s6=(String) comboBox_3.getSelectedItem();
				
				String s7=textField_2.getText();
				String s8=textField_3.getText();
				String s9=textField_4.getText();
				String s10=textField_5.getText();
				if(s1.length()==0 || s2.length()==0|| s3.length()==0 || s4.length()==0 || s5.length()==0 || s6.length()==0 || s7.length()==0 || s8.length()==0|| s9.length()==0|| s10.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "complete all fields","error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Connection con=DBinfo.getConn("library");
					String query="insert into book values(?,?,?,?,?,?,?,?,?,?)";
					
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
						ps.setString(6, s6);
						ps.setString(7, s7);
						ps.setString(8, s8);
						ps.setString(9, s9);
						ps.setString(10, s10);
						
						i=ps.executeUpdate();
						
						
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
				
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "book added","done",JOptionPane.INFORMATION_MESSAGE);
					reset();
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),"book not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
					reset();
				}
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmReset = new JMenuItem("RESET");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				reset();
			}
		});
		mnFile.add(mntmReset);
		
		JMenu mnAddNew = new JMenu("Add New");
		menuBar.add(mnAddNew);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener()
		{
			//20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 
			public void actionPerformed(ActionEvent e) 
			{
				int i=0;
				String option=e.getActionCommand();//option==Author
				//System.out.println(option);
				String value=JOptionPane.showInputDialog(getParent(),"enter "+option+" name");
				//System.out.println(option+":"+value);
			/*	Connection con=DBinfo.getConn("library");
				String query="insert into "+option+" values(?,?)";
				try
				{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, 0);
				ps.setString(2,value.toUpperCase());//convert all into upper case
				i=ps.executeUpdate();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}*/
				// second method
				i=DBinfo.setValues(option, value);
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), option+" added!!", "Done", JOptionPane.INFORMATION_MESSAGE);		
				}
				//22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),  option+" not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
				new ADDNEWBOOK().setVisible(true);
			}
		});
		mnAddNew.add(mntmAuthor);
		
		JMenuItem mntmSubject = new JMenuItem("Subject");
		mntmSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=0;
				String option=arg0.getActionCommand();//option==Author
				//System.out.println(option);
				String value=JOptionPane.showInputDialog(getParent(),"enter "+option+" name");
				//System.out.println(option+":"+value);
				i=DBinfo.setValues(option, value);
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), option+" added!!", "Done", JOptionPane.INFORMATION_MESSAGE);		
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),  option+" not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
				new ADDNEWBOOK().setVisible(true);
			}
		});
		mnAddNew.add(mntmSubject);
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String option=e.getActionCommand();//option==Author
				//System.out.println(option);
				String value=JOptionPane.showInputDialog(getParent(),"enter "+option+" name");
				//System.out.println(option+":"+value);
				i=DBinfo.setValues(option, value);
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), option+" added!!", "Done", JOptionPane.INFORMATION_MESSAGE);		
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),  option+" not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
				new ADDNEWBOOK().setVisible(true);
			}
		});
		mnAddNew.add(mntmCategory);
		
		JMenuItem mntmPublication = new JMenuItem("Publication");
		mntmPublication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String option=e.getActionCommand();//option==Author
				//System.out.println(option);
				String value=JOptionPane.showInputDialog(getParent(),"enter "+option+" name");
				//System.out.println(option+":"+value);
				i=DBinfo.setValues(option, value);
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), option+" added!!", "Done", JOptionPane.INFORMATION_MESSAGE);		
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),  option+" not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
				}
				dispose();
				new ADDNEWBOOK().setVisible(true);
			}
		});
		mnAddNew.add(mntmPublication);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		
		JLabel lblAddNewBook = new JLabel("ADD NEW BOOK");
		lblAddNewBook.setFont(new Font("Algerian", Font.ITALIC, 12));
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPublication = new JLabel("Publication");
		lblPublication.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18 18
		textField = new JTextField(bookID());
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField("1");
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		//21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 21a 
		comboBox = new JComboBox(DBinfo.getValues("author"));
		
		comboBox_1 = new JComboBox(DBinfo.getValues("subject"));
		
		comboBox_2 = new JComboBox(DBinfo.getValues("category"));
		
		comboBox_3 = new JComboBox(DBinfo.getValues("publication"));
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() 
		{
			//14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14 14
			public void actionPerformed(ActionEvent e) 
			{
				int i=0;
				String s1=textField.getText();
				String s2=textField_1.getText();
				//combo box
				//for combo box
				String s3=(String) comboBox.getSelectedItem();
				String s4=(String) comboBox_1.getSelectedItem();
				String s5=(String) comboBox_2.getSelectedItem();
				String s6=(String) comboBox_3.getSelectedItem();
				
				String s7=textField_2.getText();
				String s8=textField_3.getText();
				String s9=textField_4.getText();
				String s10=textField_5.getText();
				if(s1.length()==0 || s2.length()==0|| s3.length()==0 || s4.length()==0 || s5.length()==0 || s6.length()==0 || s7.length()==0 || s8.length()==0|| s9.length()==0|| s10.length()==0)
				{
					JOptionPane.showMessageDialog(getParent(), "complete all fields","error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Connection con=DBinfo.getConn("library");
					String query="insert into book values(?,?,?,?,?,?,?,?,?,?)";
					
					try
					{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1, s1);
						ps.setString(2, s2);
						ps.setString(3, s3);
						ps.setString(4, s4);
						ps.setString(5, s5);
						ps.setString(6, s6);
						ps.setString(7, s7);
						ps.setString(8, s8);
						ps.setString(9, s9);
						ps.setString(10, s10);
						
						i=ps.executeUpdate();
						
						
					} 
					catch (Exception e1) 
					{
						e1.printStackTrace();
					}
				}
				
				if(i==1)
				{
					JOptionPane.showMessageDialog(getParent(), "book added","done",JOptionPane.INFORMATION_MESSAGE);
					reset();
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(),"book not added!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
					reset();
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 19 
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		table = new JTable();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuantity)
						.addComponent(lblPrice)
						.addComponent(lblEdition)
						.addComponent(lblIsbn)
						.addComponent(lblPublication)
						.addComponent(lblCategory)
						.addComponent(lblSubject)
						.addComponent(lblAuthor)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_1)
							.addComponent(lblAddNewBook, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addGap(118))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(btnSave)
					.addGap(49)
					.addComponent(btnReset)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblAddNewBook)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublication)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEdition)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset))
					.addContainerGap(53, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(492, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
