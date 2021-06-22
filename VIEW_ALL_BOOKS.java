import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIEW_ALL_BOOKS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIEW_ALL_BOOKS frame = new VIEW_ALL_BOOKS();
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
	public VIEW_ALL_BOOKS() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblViewAllBooks = new JLabel("VIEW ALL BOOKS");
		lblViewAllBooks.setFont(new Font("Algerian", Font.BOLD, 14));
		
		JLabel lblViewAllBooks_1 = new JLabel("VIEW ALL BOOKS BY");
		
		
		//27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 27 
		String value[]= {"All","Author","Subject","Category","Publication"};
		JComboBox comboBox = new JComboBox(value);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener()
		{
			String value="";
			public void actionPerformed(ActionEvent e) 
			{
				
				String option=(String) comboBox.getSelectedItem();
				//System.out.println(option);option==field selected
				if(option.equalsIgnoreCase("All"))
				{
					//creatin new frame to display JTable
					JFrame frm= new JFrame("SHOWING ALL BOOKS");
					frm.setSize(1000,500);
					frm.setLocationRelativeTo(getParent());
					frm.setVisible(true);
					//dispose();
					//28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 28a 
					DBinfo.getBookTable();
					
					JTable table= new JTable(DBinfo.allRows,DBinfo.colsName);
					JScrollPane pane= new JScrollPane(table);
					frm.add(pane);
				}
				else
				{
					JFrame frm= new JFrame("Select "+option+" name");
					frm.setSize(500, 400);
					frm.setLocationRelativeTo(getParent());
					frm.setLayout(new FlowLayout());
					JLabel lbl= new JLabel("Select "+option+" name");
					JComboBox<String> cb=new JComboBox<>(DBinfo.getValues(option));
					JButton btn= new JButton("search");
					frm.setVisible(true);
					//dispose();
					frm.add(lbl);
					frm.add(cb);
					frm.add(btn);
					
					btn.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							value= (String) cb.getSelectedItem();
							//System.out.println(value);
							JFrame frm=new JFrame("showin all books of "+option+" "+value);
							frm.setSize(1000, 500);
							frm.setLocationRelativeTo(getParent());
							frm.setVisible(true);
						
							DBinfo.getBookTable(option,value);
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
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(lblViewAllBooks, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(lblViewAllBooks_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSubmit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox, Alignment.LEADING, 0, 159, Short.MAX_VALUE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblViewAllBooks, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblViewAllBooks_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnSubmit)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
