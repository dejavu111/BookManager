package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;

import util.DbUtil;
import util.StringUtil;
import dao.BorrowingDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.Date;


public class BorrowingInterFrm extends JInternalFrame {
	private JTextField readerIdTxt;
	private JTextField bookIdTxt;

	private DbUtil dbUtil=new DbUtil();
	private BorrowingDao borrowingDao=new BorrowingDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowingInterFrm frame = new BorrowingInterFrm();
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
	public BorrowingInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u501F\u9605");
		setBounds(100, 100, 450, 302);
		
		JLabel label = new JLabel("\u8BFB\u8005\u7F16\u53F7\uFF1A");
		
		readerIdTxt = new JTextField();
		readerIdTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		
		bookIdTxt = new JTextField();
		bookIdTxt.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				borrowingAddActionPerformed(evt);
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
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(button))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(bookIdTxt, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
								.addComponent(readerIdTxt, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
							.addContainerGap(151, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(button_1)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(70))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void borrowingAddActionPerformed(ActionEvent evt) {

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
			if(!borrowingDao.existInReader(con, readerId)){
				JOptionPane.showMessageDialog(null,"不存在此读者！");
				flag=0;
			}
			if(!borrowingDao.existInBook(con, bookId)){
				JOptionPane.showMessageDialog(null,"不存在此图书！");
				flag=0;
			}
			if(flag==1&&borrowingDao.numberOfbook(con, readerId)>=borrowingDao.maxBorrowingNumber(con, readerId))
			{
				JOptionPane.showMessageDialog(null,"该读者借阅图书数量已达到最大限制");
				flag=0;
			}
			if(flag==1&&((date.getTime()-borrowingDao.farthestDay(con, readerId).getTime())/86400000)>borrowingDao.theLongestBorrowingDays(con, readerId)){
				JOptionPane.showMessageDialog(null,"该读者有图书未还，超过最长借阅天数");
				flag=0;
			}
			if(flag==1){
			int addNum=borrowingDao.add(con, readerId, bookId, date);
			if(addNum==1){
				if(borrowingDao.addInR(con, readerId, bookId)==1){
				JOptionPane.showMessageDialog(null,"借阅成功！");
				resetValue();
				return;
				}
			}else{
				JOptionPane.showMessageDialog(null,"借阅失败！");
	
			}}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"借阅失败！");
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
