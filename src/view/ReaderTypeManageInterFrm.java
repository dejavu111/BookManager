package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ReaderDao;
import dao.ReaderTypeDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

import util.DbUtil;
import util.StringUtil;
import model.ReaderType;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderTypeManageInterFrm extends JInternalFrame {
	private JTextField s_readerTypeNameTxt;
	private JTable readerTypeTable;

	private DbUtil dbUtil  = new DbUtil();
	private ReaderTypeDao readerTypeDao=new ReaderTypeDao();
	private ReaderDao readerDao=new ReaderDao();
	private JTextField idTxt;
	private JTextField readerTypeNameTxt;
	private JTextField longestDayTxt;
	private JTextField maxNumberTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderTypeManageInterFrm frame = new ReaderTypeManageInterFrm();
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
	public ReaderTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFB\u8005\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 473, 426);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		s_readerTypeNameTxt = new JTextField();
		s_readerTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerTypeSearchActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(31)
							.addComponent(s_readerTypeNameTxt, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(button))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_readerTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(label))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BFB\u8005\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		readerTypeNameTxt = new JTextField();
		readerTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6700\u957F\u501F\u9605\u5929\u6570\uFF1A");
		
		longestDayTxt = new JTextField();
		longestDayTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6700\u5927\u501F\u9605\u672C\u6570\uFF1A");
		
		maxNumberTxt = new JTextField();
		maxNumberTxt.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerTypeUpdateActionPerformed(evt);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerTypeDeleteActionPerformed(evt);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(54)
									.addComponent(label_1))
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(longestDayTxt, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
								.addComponent(idTxt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(readerTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(maxNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(62)
							.addComponent(button_1)
							.addGap(38)
							.addComponent(button_2)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(readerTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(longestDayTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)
							.addComponent(maxNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(29))
		);
		panel.setLayout(gl_panel);
		
		readerTypeTable = new JTable();
		readerTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				readerTypeTableMousePressed(met);
			}
		});
		readerTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BFB\u8005\u7C7B\u522B\u540D\u79F0", "\u6700\u957F\u501F\u9605\u5929\u6570", "\u6700\u5927\u501F\u9605\u672C\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		readerTypeTable.getColumnModel().getColumn(1).setPreferredWidth(99);
		readerTypeTable.getColumnModel().getColumn(2).setPreferredWidth(115);
		readerTypeTable.getColumnModel().getColumn(3).setPreferredWidth(97);
		scrollPane.setViewportView(readerTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.filltable(new ReaderType());

	}
	private void readerTypeUpdateActionPerformed(ActionEvent evt) {
		String id=idTxt.getText();
		String readerTypeName=readerTypeNameTxt.getText();
		String longestDay=longestDayTxt.getText();
		String maxNumber=maxNumberTxt.getText();
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return;
		}
		
		if(StringUtil.isEmpty(readerTypeName))
		{
			JOptionPane.showMessageDialog(null,"读者类别名称不能为空");
			return;
		}
		ReaderType readerType=new ReaderType(Integer.parseInt(id),readerTypeName,Integer.parseInt(longestDay),Integer.parseInt(maxNumber));
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int modifyNum=readerTypeDao.update(con, readerType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.filltable(new ReaderType());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"修改失败");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void resetValue() {
		this.idTxt.setText("");
		this.readerTypeNameTxt.setText("");
		this.longestDayTxt.setText("");
		this.maxNumberTxt.setText("");
	}

	private void readerTypeTableMousePressed(MouseEvent met) {
		int row=this.readerTypeTable.getSelectedRow();
		this.idTxt.setText((String)readerTypeTable.getValueAt(row, 0));
		this.readerTypeNameTxt.setText((String)readerTypeTable.getValueAt(row, 1));
		this.longestDayTxt.setText((String)readerTypeTable.getValueAt(row,2));
		this.maxNumberTxt.setText((String)readerTypeTable.getValueAt(row,3));
		
		this.filltable(new ReaderType());
		
	}
	
	private void readerTypeDeleteActionPerformed(ActionEvent evt)
	{
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null,"请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				boolean flag=readerDao.existReaderByReaderTypeId(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null,"当前读者类别下有读者，不能删除此类别");
					return;
				}
				int deleteNum=readerTypeDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null,"删除成功");
					this.resetValue();
					this.filltable(new ReaderType());
				}else{
					JOptionPane.showMessageDialog(null,"删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"删除失败");
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

	private void readerTypeSearchActionPerformed(ActionEvent e) {
		String s_readerTypeName=this.s_readerTypeNameTxt.getText();
		ReaderType readerType=new ReaderType();
		readerType.setReaderTypeName(s_readerTypeName);
		this.filltable(readerType);
		
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void filltable(ReaderType readerType){
		DefaultTableModel dtm=(DefaultTableModel)readerTypeTable.getModel();
		dtm.setRowCount(0);
		/**while(dtm.getRowCount()>0)
			dtm.removeRow(dtm.getRowCount()-1);
			**/
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=readerTypeDao.list(con,readerType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("readerTypeName"));
				v.add(rs.getString("theLongestBorrowingDays"));
				v.add(rs.getString("maximumBorrowingNumber"));
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
