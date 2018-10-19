package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u8BFB\u8005\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_6 = new JMenuItem("\u8BFB\u8005\u7C7B\u522B\u6DFB\u52A0");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderTypeAddInterFrm readerTypeAddInterFrm=new ReaderTypeAddInterFrm();
				readerTypeAddInterFrm.setVisible(true);
				table.add(readerTypeAddInterFrm);
			}
		});
		mnNewMenu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u8BFB\u8005\u7C7B\u522B\u7EF4\u62A4");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderTypeManageInterFrm readerTypeManageInterFrm=new ReaderTypeManageInterFrm();
				readerTypeManageInterFrm.setVisible(true);
				table.add(readerTypeManageInterFrm);
			}
		});
		mnNewMenu_2.add(menuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("\u8BFB\u8005\u7BA1\u7406");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem_9 = new JMenuItem("\u8BFB\u8005\u6DFB\u52A0");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderAddInterFrm readerAddInterFrm=new ReaderAddInterFrm();
				readerAddInterFrm.setVisible(true);
				table.add(readerAddInterFrm);
			}
		});
		mnNewMenu_3.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u8BFB\u8005\u7EF4\u62A4");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderManageInterFrm readerManageInterFrm=new ReaderManageInterFrm();
				readerManageInterFrm.setVisible(true);
				table.add(readerManageInterFrm);
			}
		});
		mnNewMenu_3.add(menuItem_10);
		
		JMenuItem menuItem_12 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0){
					dispose();
				}
				
			}
		});
		
		JMenu menu = new JMenu("\u501F\u4E66");
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u501F\u9605");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowingInterFrm borrowingInterFrm=new BorrowingInterFrm();
				borrowingInterFrm.setVisible(true);
				table.add(borrowingInterFrm);
			}
		});
		menu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u501F\u9605\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowingListInterFrm borrowingListInterFrm=new BorrowingListInterFrm();
				borrowingListInterFrm.setVisible(true);
				table.add(borrowingListInterFrm);
			}
		});
		menu.add(menuItem_5);
		
		JMenu menu_1 = new JMenu("\u8FD8\u4E66");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_8 = new JMenuItem("\u56FE\u4E66\u5F52\u8FD8");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnInterFrm returnInterFrm=new ReturnInterFrm();
				returnInterFrm.setVisible(true);
				table.add(returnInterFrm);
			}
		});
		menu_1.add(menuItem_8);
		
		JMenuItem menuItem_11 = new JMenuItem("\u8FD8\u4E66\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnListInterFrm returnListInterFrm=new ReturnListInterFrm();
				returnListInterFrm.setVisible(true);
				table.add(returnListInterFrm);
			}
		});
		menu_1.add(menuItem_11);
		
		JMenu menu_2 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_13 = new JMenuItem("\u6DFB\u52A0\u666E\u901A\u7528\u6237");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				UserAddInterFrm userAddInterFrm=new UserAddInterFrm();
				userAddInterFrm.setVisible(true);
				table.add(userAddInterFrm);
			}
		});
		menu_2.add(menuItem_13);
		
		JMenuItem menuItem_14 = new JMenuItem("\u91CD\u7F6E\u7528\u6237\u5BC6\u7801");
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManageInterFrm userManageInterFrm=new UserManageInterFrm();
				userManageInterFrm.setVisible(true);
				table.add(userManageInterFrm);
			}
		});
		menu_2.add(menuItem_14);
		menuBar.add(menuItem_12);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
