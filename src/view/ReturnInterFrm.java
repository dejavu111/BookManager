package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import util.DbUtil;
import util.StringUtil;
import dao.BorrowingDao;
import dao.ReturnDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class ReturnInterFrm extends JInternalFrame {
	private JTextField readerIdTxt;
	private JTextField bookIdTxt;

	private DbUtil dbUtil=new DbUtil();
	private ReturnDao returnDao=new ReturnDao();
	private BorrowingDao borrowingDao=new BorrowingDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnInterFrm frame = new ReturnInterFrm();
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
	public ReturnInterFrm() {
		setTitle("\u56FE\u4E66\u5F52\u8FD8");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		
		readerIdTxt = new JTextField();
		readerIdTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		
		bookIdTxt = new JTextField();
		bookIdTxt.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				returnAddActionPerformed(evt);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookIdTxt)
								.addComponent(readerIdTxt, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(button)
							.addGap(30)
							.addComponent(button_1)))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	
	private void returnAddActionPerformed(ActionEvent evt) {

		String readerId=this.readerIdTxt.getText();
		String bookId=this.bookIdTxt.getText();
		if(StringUtil.isEmpty(readerId)){
			JOptionPane.showMessageDialog(null,"读者编号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(bookId)){
			JOptionPane.showMessageDialog(null,"图书编号不能为空！");
			return;
		}
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int flag=1;
			java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
			if(!returnDao.existInR(con, readerId,bookId)){
				JOptionPane.showMessageDialog(null,"不存在对应的借阅记录！");
				flag=0;
			}
			if(flag==1&&((date.getTime()-borrowingDao.farthestDay(con, readerId).getTime())/86400000)>borrowingDao.theLongestBorrowingDays(con, readerId)){
				JOptionPane.showMessageDialog(null,"该读者有图书未还，超过最长借阅天数");
				flag=0;
			}
			if(flag==1){
				int addNum=returnDao.add(con, readerId, bookId, date);
				if(addNum==1){
					if(returnDao.deleteInR(con, readerId, bookId)==1){
					JOptionPane.showMessageDialog(null,"还书成功！");
					resetValue();
					return;
					}
				}else{
					JOptionPane.showMessageDialog(null,"还书失败！");
		
				}}
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"还书失败！可能该读者已经归还了该图书");
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

		this.bookIdTxt.setText("");
		this.readerIdTxt.setText("");
	}
}
