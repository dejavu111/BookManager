package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import util.DbUtil;
import util.StringUtil;
import model.Book;
import model.BookType;
import dao.BookDao;
import dao.BookTypeDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField publisherTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField publishtimeTxt;
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private JRadioButton normalJrb;
	private JRadioButton abnormalJrb;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 574, 372);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		publisherTxt = new JTextField();
		publisherTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u51FA\u7248\u65F6\u95F4\uFF1A");
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u72B6\u6001\uFF1A");
		
		normalJrb = new JRadioButton("\u6B63\u5E38");
		buttonGroup.add(normalJrb);
		
		abnormalJrb = new JRadioButton("\u62A5\u5E9F");
		buttonGroup.add(abnormalJrb);
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		bookDescTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddAcitonPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		publishtimeTxt = new JTextField();
		publishtimeTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(35)
							.addComponent(button_1)
							.addGap(321))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(lblNewLabel)
										.addComponent(label_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(bookNameTxt)
												.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
											.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
											.addGap(57))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(71)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_1)
												.addComponent(label_3))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(publishtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_7)
											.addGap(18)
											.addComponent(normalJrb)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(abnormalJrb)))
									.addGap(58)))
							.addGap(16))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_7)
							.addComponent(normalJrb)
							.addComponent(abnormalJrb)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(publisherTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(publishtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(41))
		);
		getContentPane().setLayout(groupLayout);
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		fillBookType();
	}
	
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
		
	}

	/**
	 * 图书添加事件处理
	 * @param e
	 */
	private void bookAddAcitonPerformed(ActionEvent evt) {
		
		String bookName=this.bookNameTxt.getText();		
		String author=this.authorTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		String publishtime=this.publishtimeTxt.getText();
		String publisher=this.publisherTxt.getText();
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null,"图书名称不能为空！");
			return;
		}
		
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null,"作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publisher)){
			JOptionPane.showMessageDialog(null,"出版社不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publishtime)){
			JOptionPane.showMessageDialog(null,"出版时间不能为空！");
			return;
		}
		
		String state="";
		if(normalJrb.isSelected()){
			state="正常";
		}else if(abnormalJrb.isSelected()){
			state="报废";
		}
		
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,author,publisher,publishtime,bookTypeId,state,bookDesc);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=bookDao.add(con, book);
			if(addNum==1){
				JOptionPane.showMessageDialog(null,"图书添加成功！");
				resetValue();
				return;
			}else{
				JOptionPane.showMessageDialog(null,"图书添加失败！");
	
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

	/**重置表单
	 * 
	 */
	private void resetValue() {
		this.bookNameTxt.setText("");
		this.bookDescTxt.setText("");
		this.authorTxt.setText("");
		this.publisherTxt.setText("");
		this.publishtimeTxt.setText("");
		this.abnormalJrb.setSelected(true);
		this.normalJrb.setSelected(true);
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}

	/**
	 * 初始化图书类别下拉框
	 */
	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			
		}
	}
}
