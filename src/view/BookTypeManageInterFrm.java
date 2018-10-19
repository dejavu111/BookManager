package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookDao;
import dao.BookTypeDao;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import util.DbUtil;
import util.StringUtil;
import model.BookType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTextArea bookTypeDescTxt;
	
	private DbUtil dbUtil  = new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTable bookTypeTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 506, 543);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateAcitonEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteAcitonEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(39)
							.addComponent(btnNewButton_1)
							.addGap(34)
							.addComponent(btnNewButton_2)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnNewButton))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				bookTypeTableMousePressed(met);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(124);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.filltable(new BookType());
	}
	
	private void bookTypeTableMousePressed(MouseEvent met) {
		int row=this.bookTypeTable.getSelectedRow();
		this.idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
		this.bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		this.bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row,2));
		
		this.filltable(new BookType());
		
	}

	/**
	 * ͼ�����ɾ���¼�����
	 * @param e
	 */
	private void bookTypeDeleteAcitonEvent(ActionEvent evt) {

		String id=idTxt.getText();
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean flag=bookDao.existBookByBookTypeId(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null,"��ǰͼ���������ͼ�飬����ɾ�������");
					return;
				}
				int deleteNum=bookTypeDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
					this.resetValue();
					this.filltable(new BookType());
				}else{
					JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
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

	/**
	 * ͼ������޸��¼�����
	 * @param evt
	 */
	private void bookTypeUpdateAcitonEvent(ActionEvent evt) {
		
		String id=idTxt.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		
		if(StringUtil.isEmpty(bookTypeName))
		{
			JOptionPane.showMessageDialog(null,"ͼ��������Ʋ���Ϊ��");
			return;
		}
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int modifyNum=bookTypeDao.update(con, bookType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.resetValue();
				this.filltable(new BookType());
			}else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"�޸�ʧ��");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ͼ����������¼�����
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		String s_bookTypeName=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.filltable(bookType);
	}

	/**
	 * ��ʼ�����
	 * @param bookType
	 */
	private void filltable(BookType bookType){
		DefaultTableModel dtm=(DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0);
		/**while(dtm.getRowCount()>0)
			dtm.removeRow(dtm.getRowCount()-1);
			**/
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con,bookType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	
	/**���ñ�
	 * 
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
