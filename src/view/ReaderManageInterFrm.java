package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.DbUtil;
import util.StringUtil;
import model.Reader;
import model.ReaderType;
import dao.ReaderDao;
import dao.ReaderTypeDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReaderManageInterFrm extends JInternalFrame {
	private JTextField s_readerNameTxt;
	private JTextField s_IDNumberTxt;
	private JTable readerTable;
	private JComboBox s_readerTypeJcb;
	private JComboBox readerTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private ReaderTypeDao readerTypeDao=new ReaderTypeDao();
	private ReaderDao readerDao=new ReaderDao();
	private JTextField idTxt;
	private JTextField IDNumberTxt;
	private JTextField nameTxt;
	private JTextField telTxt;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderManageInterFrm frame = new ReaderManageInterFrm();
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
	public ReaderManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BFB\u8005\u7BA1\u7406");
		setBounds(100, 100, 517, 517);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
						.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7\uFF1A");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		IDNumberTxt = new JTextField();
		IDNumberTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u59D3\u540D\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		
		readerTypeJcb = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		telTxt = new JTextField();
		telTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerUpdateActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerDeleteAcitonPerformed(evt);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_5)
						.addComponent(label_3)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(idTxt, 70, 70, 70)
						.addComponent(nameTxt, 70, 70, 70)
						.addComponent(telTxt, 70, 70, 70))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(136)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(60)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_6)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(readerTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(IDNumberTxt, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
					.addGap(27))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(IDNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_5)
										.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(readerTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton)
										.addComponent(btnNewButton_1)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(27)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(telTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(label_6))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		readerTable = new JTable();
		readerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				readerTableMousePressed(met);
			}
		});
		readerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8EAB\u4EFD\u8BC1\u53F7", "\u59D3\u540D", "\u8BFB\u8005\u7C7B\u578B", "\u8054\u7CFB\u65B9\u5F0F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(readerTable);
		
		JLabel label = new JLabel("\u8BFB\u8005\u59D3\u540D\uFF1A");
		
		s_readerNameTxt = new JTextField();
		s_readerNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		s_IDNumberTxt = new JTextField();
		s_IDNumberTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		
		s_readerTypeJcb = new JComboBox();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerSearchAcitonPerformed(evt);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(s_readerNameTxt, 79, 79, 79))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addGap(18)
							.addComponent(s_readerTypeJcb, 0, 79, Short.MAX_VALUE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(37)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(s_IDNumberTxt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)))
					.addGap(48))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_readerNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_IDNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(s_readerTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillReaderType("search");
		this.fillTable(new Reader());
		this.fillReaderType("modify");

	}

	private void readerUpdateActionPerformed(ActionEvent evt) {

		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return;
		}
		
		String readerName=this.nameTxt.getText();		
		if(StringUtil.isEmpty(readerName)){
			JOptionPane.showMessageDialog(null,"读者名称不能为空！");
			return;
		}
		
		String IDNumber=this.IDNumberTxt.getText();
		if(StringUtil.isEmpty(IDNumber)){
			JOptionPane.showMessageDialog(null,"读者身份证号不能为空！");
			return;
		}
		
		String tel=this.telTxt.getText();
		ReaderType readerType=(ReaderType)readerTypeJcb.getSelectedItem();
		int readerTypeId=readerType.getId();
		
		Reader reader=new Reader(Integer.parseInt(id),IDNumber,readerName, readerTypeId,tel);
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=readerDao.update(con, reader);
			if(addNum==1){
				JOptionPane.showMessageDialog(null,"读者修改成功！");
				resetValue();
				this.fillTable(new Reader());
				return;
			}else{
				JOptionPane.showMessageDialog(null,"读者修改失败！");
	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"读者修改失败！");
			}
		} 
		
	}

	private void readerDeleteAcitonPerformed(ActionEvent evt) {

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
				if(readerDao.existBookNotReturn(con, id)){
					JOptionPane.showMessageDialog(null,"该读者有书未还，不能删除！");
					return;
				}else{
				int deleteNum=readerDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null,"删除成功");
					this.resetValue();
					this.fillTable(new Reader());
				}else{
					JOptionPane.showMessageDialog(null,"删除失败");
				}}
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

	private void resetValue() {
		this.idTxt.setText("");
		this.nameTxt.setText("");
		this.telTxt.setText("");
		this.IDNumberTxt.setText("");
		if(this.readerTypeJcb.getItemCount()>0){
			this.readerTypeJcb.setSelectedIndex(0);
		}
		
	}

	private void readerTableMousePressed(MouseEvent met) {

		int row=this.readerTable.getSelectedRow();
		this.idTxt.setText((String)readerTable.getValueAt(row, 0));
		this.IDNumberTxt.setText((String)readerTable.getValueAt(row,1));
		this.nameTxt.setText((String)readerTable.getValueAt(row, 2));
		String readerTypeName=(String)readerTable.getValueAt(row,3);
		int n=this.readerTypeJcb.getItemCount();
		for(int i=0;i<n;i++){
			ReaderType item=(ReaderType)this.readerTypeJcb.getItemAt(i);
			if(item.getReaderTypeName().equals(readerTypeName)){
				this.readerTypeJcb.setSelectedIndex(i);
			}
		}
		this.telTxt.setText((String)readerTable.getValueAt(row,4));
		this.fillTable(new Reader());
		
	}

	private void readerSearchAcitonPerformed(ActionEvent evt) {

		String readerName=this.s_readerNameTxt.getText();
		String IDNumber=this.s_IDNumberTxt.getText();
		ReaderType readerType=(ReaderType)this.s_readerTypeJcb.getSelectedItem();
		int readerTypeid=readerType.getId();
		
		Reader reader=new Reader(readerName,IDNumber,readerTypeid);
		this.fillTable(reader);
		
	}
	
	/**
	 * 初始化下拉框
	 * @param Type
	 */
	private void fillReaderType(String type){
		Connection con=null;
		ReaderType readerType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=readerTypeDao.list(con, new ReaderType());
			if("search".equals(type)){
				readerType=new ReaderType();
				readerType.setReaderTypeName("请选择...");
				readerType.setId(-1);
				this.s_readerTypeJcb.addItem(readerType);
			}
			while(rs.next()){
				readerType=new ReaderType();
				readerType.setReaderTypeName(rs.getString("readerTypeName"));
				readerType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_readerTypeJcb.addItem(readerType);
				}else if("modify".equals(type)){
					this.readerTypeJcb.addItem(readerType);
				}
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{ 
			try {
				dbUtil.closeCon(con);
				// TODO Auto-generated catch block
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/*
	 * 初始化表格数据
	 */
	private void fillTable(Reader reader) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=(DefaultTableModel)readerTable.getModel();
		dtm.setRowCount(0);
		/**while(dtm.getRowCount()>0)
			dtm.removeRow(dtm.getRowCount()-1);
			**/
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=readerDao.list(con,reader);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("IDNumber"));
				v.add(rs.getString("name"));
				v.add(rs.getString("readerTypeName"));
				v.add(rs.getString("tel"));
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
