package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BorrowingDao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import util.DbUtil;
import model.Borrowing;

public class BorrowingListInterFrm extends JInternalFrame {
	private JTable borrowingListTable;

	private DbUtil dbUtil=new DbUtil();
	private JTextField IDNumberTxt;
	private JTextField bookIdTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowingListInterFrm frame = new BorrowingListInterFrm();
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
	public BorrowingListInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u501F\u4E66\u8BB0\u5F55");
		setBounds(100, 100, 528, 362);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		IDNumberTxt = new JTextField();
		IDNumberTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				borrowingSearchActionPerformed(evt);
			}
		});
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		
		bookIdTxt = new JTextField();
		bookIdTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(IDNumberTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(377)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(IDNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		borrowingListTable = new JTable();
		borrowingListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFB\u8005\u7F16\u53F7", "\u8EAB\u4EFD\u8BC1\u53F7", "\u59D3\u540D", "\u56FE\u4E66\u7F16\u53F7", "\u501F\u9605\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(borrowingListTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Borrowing());
	}
	
	private void borrowingSearchActionPerformed(ActionEvent evt) {
		
		String IDNumber=this.IDNumberTxt.getText();
		String bookId=this.bookIdTxt.getText();
		Borrowing borrowing =new Borrowing(IDNumber,bookId);
		this.fillTable(borrowing);
		
	}

	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Borrowing borrowing){
		DefaultTableModel dtm=(DefaultTableModel)borrowingListTable.getModel();
		dtm.setRowCount(0);
		/**while(dtm.getRowCount()>0)
			dtm.removeRow(dtm.getRowCount()-1);
			**/
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=BorrowingDao.list(con,borrowing);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("readerId"));
				v.add(rs.getString("IDNumber"));
				v.add(rs.getString("name"));
				v.add(rs.getString("bookId"));
				v.add(rs.getDate("borrowingTime"));
				dtm.addRow(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
