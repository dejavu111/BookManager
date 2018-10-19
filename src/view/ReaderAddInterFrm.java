package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

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

public class ReaderAddInterFrm extends JInternalFrame {
	private JTextField IDnumberTxt;
	private JTextField nameTxt;
	private JTextField telTxt;
	private JComboBox readerTypeJcb;
	
	private DbUtil dbUtil=new DbUtil();
	private Reader reader=new Reader();
	private ReaderDao readerDao=new ReaderDao();
	private ReaderTypeDao readerTypeDao=new ReaderTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderAddInterFrm frame = new ReaderAddInterFrm();
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
	public ReaderAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8BFB\u8005\u6DFB\u52A0");
		setBounds(100, 100, 370, 369);
		
		JLabel label = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		IDnumberTxt = new JTextField();
		IDnumberTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BFB\u8005\u7C7B\u522B\uFF1A");
		
		readerTypeJcb = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		telTxt = new JTextField();
		telTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\uFF08\u9009\u586B\uFF09");
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				readerAddActionPerformed(evt);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetValueActionPerformed(evt);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_1)
											.addComponent(lblNewLabel_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(7)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(telTxt, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
													.addGap(8)
													.addComponent(label_2))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(readerTypeJcb, 0, 93, Short.MAX_VALUE)
													.addGap(57))))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(3)
											.addComponent(IDnumberTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(18)
									.addComponent(button_1))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(lblNewLabel)
							.addGap(5)
							.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addGap(73))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel)
							.addGap(27)
							.addComponent(label)
							.addGap(27))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(IDnumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(21)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(readerTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(telTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))
							.addContainerGap(76, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addGap(139))))
		);
		getContentPane().setLayout(groupLayout);
		fillReaderType();
	}

	private void resetValueActionPerformed(ActionEvent evt) {

		this.resetValue();
		
	}

	private void readerAddActionPerformed(ActionEvent evt) {

		String name=this.nameTxt.getText();		
		String IDnumber=this.IDnumberTxt.getText();
		String tel=this.telTxt.getText();
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null,"姓名不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(IDnumber)){
			JOptionPane.showMessageDialog(null,"身份证号不能为空！");
			return;
		}
		
		
		
		
		ReaderType readerType=(ReaderType)readerTypeJcb.getSelectedItem();
		int readerTypeId=readerType.getId();
		
		Reader book=new Reader(IDnumber,name,readerTypeId,tel);
		
		Connection con=null;
		
		try{
			con=dbUtil.getCon();
			int addNum=readerDao.add(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null,"读者添加成功！");
				resetValue();
				return;
			}else{
				JOptionPane.showMessageDialog(null,"读者添加失败！");
	
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"图书添加失败！");
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
		
		this.nameTxt.setText("");
		this.IDnumberTxt.setText("");
		this.telTxt.setText("");
		if(this.readerTypeJcb.getItemCount()>0){
			this.readerTypeJcb.setSelectedIndex(0);
		}
		
	}
	
	/**
	 * 初始读者类别下拉框
	 */
	private void fillReaderType(){
		Connection con=null;
		ReaderType readerType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=readerTypeDao.list(con, new ReaderType());
			while(rs.next()){
				readerType=new ReaderType();
				readerType.setId(rs.getInt("id"));
				readerType.setReaderTypeName(rs.getString("readerTypeName"));
				this.readerTypeJcb.addItem(readerType);
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			
		}
	}
}
