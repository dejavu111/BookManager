package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;

public class MainFrm2 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm2 frame = new MainFrm2();
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
	public MainFrm2() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 558);
		final JDesktopPane table = new JDesktopPane();
		getContentPane().add(table, BorderLayout.CENTER);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u501F\u4E66");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u501F\u9605");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BorrowingInterFrm borrowingInterFrm=new BorrowingInterFrm();
				borrowingInterFrm.setVisible(true);
				table.add(borrowingInterFrm);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u501F\u9605\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowingListInterFrm borrowingListInterFrm=new BorrowingListInterFrm();
				borrowingListInterFrm.setVisible(true);
				table.add(borrowingListInterFrm);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u8FD8\u4E66");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u5F52\u8FD8");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnInterFrm returnInterFrm=new ReturnInterFrm();
				returnInterFrm.setVisible(true);
				table.add(returnInterFrm);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8FD8\u4E66\u8BB0\u5F55\u67E5\u8BE2");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnListInterFrm returnListInterFrm=new ReturnListInterFrm();
				returnListInterFrm.setVisible(true);
				table.add(returnListInterFrm);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result==0){
					dispose();
				}
			}
		});
		menuBar.add(menuItem_2);
		
		
	}
}
