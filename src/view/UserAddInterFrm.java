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
import model.User;
import dao.UserDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class UserAddInterFrm extends JInternalFrame {
	private JTextField passwordTxt;
	private JTextField userNameTxt;

	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddInterFrm frame = new UserAddInterFrm();
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
	public UserAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u666E\u901A\u7528\u6237");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				userAddActionPerformed(evt);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(9)))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(177))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void resetValueActionPerformed(ActionEvent e) {
		resetValue();
		
	}

	private void userAddActionPerformed(ActionEvent evt) {

		String userName=this.userNameTxt.getText();
		String password=this.passwordTxt.getText();
		String userType="普通用户";
		
		
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null,"密码不能为空！");
			return;
		}
		
		User user=new User(userName,password,userType);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=userDao.add(con, user);
			if(addNum==1){
				JOptionPane.showMessageDialog(null,"用户添加成功！");
				resetValue();
				return;
			}else{
				JOptionPane.showMessageDialog(null,"用户添加失败！");
	
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
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
