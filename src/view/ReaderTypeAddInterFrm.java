package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import util.DbUtil;
import util.StringUtil;
import model.ReaderType;
import dao.ReaderTypeDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class ReaderTypeAddInterFrm extends JInternalFrame {
	private JTextField readerTypeNameTxt;
	private JTextField longestDaysTxt;
	private JTextField maxNumberTxt;
	private ReaderTypeDao readerTypeDao=new ReaderTypeDao();
	private DbUtil dbUtil = new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderTypeAddInterFrm frame = new ReaderTypeAddInterFrm();
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
	public ReaderTypeAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BFB\u8005\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		readerTypeNameTxt = new JTextField();
		readerTypeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6700\u957F\u501F\u9605\u5929\u6570\uFF1A");
		
		longestDaysTxt = new JTextField();
		longestDaysTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6700\u5927\u501F\u9605\u672C\u6570\uFF1A");
		
		maxNumberTxt = new JTextField();
		maxNumberTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readerTypeAddActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(readerTypeNameTxt, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
								.addComponent(maxNumberTxt)
								.addComponent(longestDaysTxt))
							.addGap(97))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(button_1)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(readerTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(longestDaysTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(maxNumberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	
	/**
	 * 重置事件处理 
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}


	/**
	 * 读者类别添加事件处理
	 * @param e
	 */
	private void readerTypeAddActionPerformed(ActionEvent evt) {

		String readerTypeName=this.readerTypeNameTxt.getText();
		int theLongestBorrowingDays=Integer.parseInt(this.longestDaysTxt.getText());
		int maximumBorrowingNumber=Integer.parseInt(this.maxNumberTxt.getText());
		if(StringUtil.isEmpty(readerTypeName)){
			JOptionPane.showMessageDialog(null, "读者类别不能为空！");
			return;
		}
		if(StringUtil.isEmpty(String.valueOf(theLongestBorrowingDays))){
			JOptionPane.showMessageDialog(null, "最长借阅天数不能为空！");
			return;
		}
		if(StringUtil.isEmpty(String.valueOf(maximumBorrowingNumber))){
			JOptionPane.showMessageDialog(null, "最大借阅本数不能为空！");
			return;
		}
		
		ReaderType readerType=new ReaderType(readerTypeName,theLongestBorrowingDays,maximumBorrowingNumber);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int n=readerTypeDao.add(con, readerType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "读者类别添加成功！");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "读者类别添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "读者类别添加失败！");
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

		this.readerTypeNameTxt.setText("");
		this.maxNumberTxt.setText("");
		this.longestDaysTxt.setText("");
		
	}
}
