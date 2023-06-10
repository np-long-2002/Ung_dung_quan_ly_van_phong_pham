package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.NguoiDungDAO;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtMatKhau;
	JButton btnThoat;
	private static DangNhap frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DangNhap();
					Rectangle bounds = frame.getGraphicsConfiguration().getBounds();
					Dimension dimension = bounds.getSize();
					int x = (int) (((dimension.getWidth() - frame.getWidth()) / 2) + bounds.getMinX());
					int y = (int) (((dimension.getHeight() - frame.getHeight()) / 2) + bounds.getMinY());
					frame.setLocation(x, y);
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
	public DangNhap() {
		setForeground(new Color(0, 0, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(138, 11, 153, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setBounds(52, 65, 60, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu");
		lblNewLabel_2.setBounds(52, 113, 60, 14);
		panel.add(lblNewLabel_2);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(122, 62, 221, 20);
		panel.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(122, 110, 221, 20);
		panel.add(txtMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 NguoiDungDAO dao = new NguoiDungDAO();
				 if(dao.checkDangNhap(txtTaiKhoan.getText().toString().trim(), txtMatKhau.getText().toString().trim())) {
				 frame.dispose();
					 Main main = new Main();
					 main.setVisible(true);
				 }else {
					 JOptionPane.showConfirmDialog(null, "Sai tên tài khoản hoặc mật khẩu! Vui Lòng Nhập Lại!!!", "Thông Báo!", JOptionPane.DEFAULT_OPTION);
				 }
			}
		});
		btnDangNhap.setBounds(52, 176, 116, 23);
		panel.add(btnDangNhap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int dialogButton = JOptionPane.YES_NO_OPTION;
                 int dialogResult = JOptionPane.showConfirmDialog (btnThoat, "Bạn Muốn Thoát?","Thông báo!!!",dialogButton);
                 if(dialogResult == JOptionPane.YES_OPTION)
                 {
                     System.exit(0);
                 }
			}
		});
		btnThoat.setBounds(236, 176, 107, 23);
		panel.add(btnThoat);
	}
}
