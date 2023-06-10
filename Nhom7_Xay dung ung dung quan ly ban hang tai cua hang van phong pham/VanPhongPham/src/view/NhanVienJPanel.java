package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import dao.ChucVuDAO;
import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.ChucVu;
import model.NguoiDung;
import model.NguoiDung_1;
import model.NhanVien;
import model.Quyen;


public class NhanVienJPanel extends JPanel {
	private JTextField txtTenNhanVien_NhanVien;
	private JTextField txtMaNhanVien_NhanVien;
	private JTextField txtSoDT_NhanVien;
	private JTextField textField_4;
	private static JTable tblTaiKhoan_TaiKhoan;
	private JTextField txtID_TaiKhoan;
	private JTextField txtUser_TaiKhoan;
	private JTextField  txtPassword_TaiKhoan;
	private JTextField txtTenChucVu_ChucVu;
	private JTextField txtMaChucVu_ChucVu;
	private static JTable tblChucVu_ChucVu;

	private AbstractButton rbtnNam_NhanVien;
	private JComboBox cbbChucVu_NhanVien;
	private AbstractButton rbtnNu_NhanVien;
	private JComponent lblMaNhanVien_NhanVien;
	private JComponent lblTenNhanVien_NhanVien;
	private JComponent lblDiaChi_NhanVien;
	private JComponent lblSDT_NhanVien;
	private JComboBox cbNhanVien;
	private ArrayList<NhanVien> listNV;
	private ArrayList<NguoiDung_1> listND;
	private ArrayList<ChucVu> listCV;
	private ArrayList<Quyen> listQ;
	private static ArrayList<NhanVien> arrayList;
	private JComboBox cbGioiTinh;
	private static JTable tblNhanVien_NhanVien;
	private JComboBox cbbChucVu_NhanVien_1;
	private JComboBox cbbQuyen_TaiKhoan;
	/**
	 * Create the panel.
	 */
	public NhanVienJPanel() {
		setLayout(null);
		
		JTabbedPane jTabbedPaneNhanVien = new JTabbedPane(JTabbedPane.TOP);
		jTabbedPaneNhanVien.setBounds(31, 10, 1086, 517);
		add(jTabbedPaneNhanVien);
	
		
		JPanel jPanelNhanVien = new JPanel();

		jTabbedPaneNhanVien.addTab("Nh\u00E2n Vi\u00EAn", null, jPanelNhanVien, null);
		jPanelNhanVien.setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 953, 221);
		jPanelNhanVien.add(scrollPane);
		
		tblNhanVien_NhanVien = new JTable();
		tblNhanVien_NhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int viTriDongVuaBam = tblNhanVien_NhanVien.getSelectedRow();
				 txtMaNhanVien_NhanVien.setText(tblNhanVien_NhanVien.getValueAt(viTriDongVuaBam, 0).toString());
				 txtTenNhanVien_NhanVien.setText(tblNhanVien_NhanVien.getValueAt(viTriDongVuaBam, 1).toString());
				 txtSoDT_NhanVien.setText(tblNhanVien_NhanVien.getValueAt(viTriDongVuaBam, 4).toString());
			}
		});
		
		tblNhanVien_NhanVien.setModel(new DefaultTableModel(
			new Object[][] {
				{null,null,null,null,null,null}
			},
			new String[] {
				"M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ng\u00E0y V\u00E0o L\u00E0m", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Ch\u1EE9c V\u1EE5"
			}
		));
		scrollPane.setViewportView(tblNhanVien_NhanVien);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 237, 953, 241);
		jPanelNhanVien.add(panel);
		panel.setLayout(null);
		
		JPanel jPanel16 = new JPanel();
		jPanel16.setBounds(10, 11, 345, 227);
		jPanel16.setBackground(new Color(192, 192, 192));
		panel.add(jPanel16);
		
		JLabel lblMaNhanVien_NhanVien = new JLabel();
		lblMaNhanVien_NhanVien.setText("M\u00E3 Nh\u00E2n Vi\u00EAn");
		
		JLabel lblGiiTnh = new JLabel();
		lblGiiTnh.setText("Gi\u1EDBi t\u00EDnh ");
		
		JLabel lblTenNhanVien_NhanVien = new JLabel();
		lblTenNhanVien_NhanVien.setText("T\u00EAn Nh\u00E2n Vi\u00EAn");
		
		txtTenNhanVien_NhanVien = new JTextField();
		
		txtMaNhanVien_NhanVien = new JTextField();
		txtMaNhanVien_NhanVien.setEnabled(false);
		
		cbGioiTinh = new JComboBox();
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		
		JLabel jLabel52 = new JLabel();
		jLabel52.setText("Chức Vụ");
		
		cbbChucVu_NhanVien_1 = new JComboBox<>();
		cbbChucVu_NhanVien_1.setEditable(true);
		cbbChucVu_NhanVien_1.setModel(new DefaultComboBoxModel(new String[] {"Quản Lý ", "Nhân Viên"}));
		
		
		
		JLabel lblSDT_NhanVien_1 = new JLabel();
		lblSDT_NhanVien_1.setText("Số ĐT");
		
		txtSoDT_NhanVien = new JTextField();
		GroupLayout gl_jPanel16 = new GroupLayout(jPanel16);
		gl_jPanel16.setHorizontalGroup(
			gl_jPanel16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel16.createSequentialGroup()
							.addComponent(jLabel52, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(262, Short.MAX_VALUE))
						.addGroup(gl_jPanel16.createSequentialGroup()
							.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaNhanVien_NhanVien, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenNhanVien_NhanVien)
								.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPanel16.createSequentialGroup()
									.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
										.addComponent(txtMaNhanVien_NhanVien, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
										.addComponent(txtTenNhanVien_NhanVien, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
										.addComponent(cbbChucVu_NhanVien_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
									.addGap(24))
								.addGroup(gl_jPanel16.createSequentialGroup()
									.addComponent(cbGioiTinh, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_jPanel16.createSequentialGroup()
							.addComponent(lblSDT_NhanVien_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtSoDT_NhanVien, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGap(25))))
		);
		gl_jPanel16.setVerticalGroup(
			gl_jPanel16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel16.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaNhanVien_NhanVien)
						.addComponent(txtMaNhanVien_NhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTenNhanVien_NhanVien)
						.addComponent(txtTenNhanVien_NhanVien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSoDT_NhanVien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSDT_NhanVien_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel52, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbChucVu_NhanVien_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel16.createParallelGroup(Alignment.LEADING)
						.addComponent(cbGioiTinh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiiTnh))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		jPanel16.setLayout(gl_jPanel16);
		
		
		JButton btnSua_NhanVien = new JButton();
		btnSua_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				NhanVien nv = new NhanVien();
				nv.setTenNhanVien(txtTenNhanVien_NhanVien.getText());
				String gt = (String) cbGioiTinh.getSelectedItem();
				nv.setGioiTinh(gt);
				nv.setSoDienThoai(txtSoDT_NhanVien.getText());
				nv.setMaChucVu(String.valueOf(listCV.get(cbbChucVu_NhanVien_1.getSelectedIndex()).getMaChucVu()));
				nv.setMaNhanVien(Integer.parseInt(txtMaNhanVien_NhanVien.getText()));
		       NhanVienDAO nvdao =new NhanVienDAO() ;
		       if (nvdao.capnhapNv(nv)>0 )
		       {    
		    	   JOptionPane.showMessageDialog(null, "câp nhật thành công");
		    	   hienthiNhanVien();
		       }
		       else
		           JOptionPane.showMessageDialog(null, "cập nhật that bại");
		}
		});
		btnSua_NhanVien.setText("Cập Nhật Thông Tin Nhân Viên");
		btnSua_NhanVien.setBounds(365, 61, 240, 34);
		panel.add(btnSua_NhanVien);
		
		JButton btnXoa_NhanVien = new JButton();
		btnXoa_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnXoa_NhanVienActionPerformed(evt);
			}

			private void btnXoa_NhanVienActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				 int index = tblNhanVien_NhanVien.getSelectedRow();     
			     NhanVienDAO nvdao = new NhanVienDAO();
			     nvdao.xoaNv(tblNhanVien_NhanVien.getValueAt(index,0).toString());
			     hienthiNhanVien();
				
			}
		});
		btnXoa_NhanVien.setText("Xóa Nhân Viên");
		btnXoa_NhanVien.setBounds(365, 108, 240, 34);
		panel.add(btnXoa_NhanVien);
		
		JPanel jPanel17 = new JPanel();
		jPanel17.setBounds(689, 11, 227, 227);
		panel.add(jPanel17);
		jPanel17.setBackground(new Color(204, 204, 255));
		
		JLabel jLabel53 = new JLabel();
		jLabel53.setText("Tìm Kiếm");
		jLabel53.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_4 = new JTextField();
		
		JButton btnTimKiem_NhanVien = new JButton("Tìm Kiếm ");
		btnTimKiem_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDAO dao = new NhanVienDAO();
				arrayList = dao.Tknv(textField_4.getText());
				DefaultTableModel model = (DefaultTableModel)tblNhanVien_NhanVien.getModel();
				model.setRowCount(0);
				for(int i=0;i<arrayList.size();i++) {
					Vector<Object> vec = new Vector<>();
					  vec.add(arrayList.get(i).getMaNhanVien());
				      vec.add(arrayList.get(i).getTenNhanVien());
				      vec.add(arrayList.get(i).getGioiTinh());
				      vec.add(arrayList.get(i).getNgayVaoLam());
				      vec.add(arrayList.get(i).getSoDienThoai());
				      vec.add(arrayList.get(i).getMaChucVu());
			        model.addRow(vec); 
				}
			}

			private void btnTimKiemActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
			}
		});
		GroupLayout gl_jPanel17 = new GroupLayout(jPanel17);
		gl_jPanel17.setHorizontalGroup(
			gl_jPanel17.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel17.createSequentialGroup()
					.addGroup(gl_jPanel17.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel17.createSequentialGroup()
							.addGap(50)
							.addComponent(jLabel53, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel17.createSequentialGroup()
							.addGap(22)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel17.createSequentialGroup()
							.addGap(61)
							.addComponent(btnTimKiem_NhanVien)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_jPanel17.setVerticalGroup(
			gl_jPanel17.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel17.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel53, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnTimKiem_NhanVien)
					.addGap(46))
		);
		jPanel17.setLayout(gl_jPanel17);
		
		JButton btnThem_NhanVien_1 = new JButton();
		btnThem_NhanVien_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhanVien nv = new NhanVien();
				nv.setTenNhanVien(txtTenNhanVien_NhanVien.getText().trim());
				String gt = (String) cbGioiTinh.getSelectedItem();
				nv.setGioiTinh(gt);
				nv.setSoDienThoai(txtSoDT_NhanVien.getText().trim());
				nv.setMaChucVu(String.valueOf(listCV.get(cbbChucVu_NhanVien_1.getSelectedIndex()).getMaChucVu()));
				NhanVienDAO NvDao = new NhanVienDAO();
				 if (NvDao.ThemNhanVien(nv)>0 )
			     {    
			      JOptionPane.showMessageDialog(null, "lưu thành công");
			      hienthiNhanVien();
			      }
			      else
			           JOptionPane.showMessageDialog(null, "lưu that bại");
			}
		});
		btnThem_NhanVien_1.setText("Lưu Thông Tin Nhân Viên");
		btnThem_NhanVien_1.setBounds(365, 16, 240, 34);
		panel.add(btnThem_NhanVien_1);
		
		JPanel jPanelTaiKhoan = new JPanel();
		jPanelTaiKhoan.addComponentListener(new ComponentAdapter() {
			private JTabbedPane cbbQuyen_TaiKhoan;

			@Override
			public void componentShown(ComponentEvent evt) {
				jPanelTaiKhoanComponentShown(evt);
			}

			private void jPanelTaiKhoanComponentShown(ComponentEvent evt) {
				// TODO Auto-generated method stub
				hienthiNguoiDung();
			}
		});
		jTabbedPaneNhanVien.addTab("Tài Khoản", null, jPanelTaiKhoan, null);
		jPanelTaiKhoan.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 703, 218);
		jPanelTaiKhoan.add(scrollPane_1);
		
		tblTaiKhoan_TaiKhoan = new JTable();
		tblTaiKhoan_TaiKhoan.addMouseListener(new MouseAdapter() {
			private JComboBox cbbQuyen_TaiKhoan;

			@Override
			public void mouseClicked(MouseEvent evt) {
				tblTaiKhoan_TaiKhoanMouseClicked(evt);
			}

			private void tblTaiKhoan_TaiKhoanMouseClicked(MouseEvent evt) {
				// TODO Auto-generated method stub
				  int viTriDongVuaBam = tblTaiKhoan_TaiKhoan.getSelectedRow();
			        txtID_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 0).toString());
			        txtUser_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 2).toString());
			        txtPassword_TaiKhoan.setText(tblTaiKhoan_TaiKhoan.getValueAt(viTriDongVuaBam, 3).toString());
			}
		});
		scrollPane_1.setViewportView(tblTaiKhoan_TaiKhoan);
		tblTaiKhoan_TaiKhoan.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, null, null, null},
			},
			new String[] {
				"M\u00E3 Ng\u01B0\u1EDDi D\u00F9ng", "M\u00E3 Nh\u00E2n Vi\u00EAn", "T\u00EAn \u0110\u0103ng Nh\u1EADp", "M\u1EADt Kh\u1EA9u", "Quy\u1EC1n"
			}
		));
		
		JLabel jLabel55 = new JLabel();
		jLabel55.setText("Mã Người Dùng");
		jLabel55.setBounds(10, 256, 125, 13);
		jPanelTaiKhoan.add(jLabel55);
		
		txtID_TaiKhoan = new JTextField();
		txtID_TaiKhoan.setEnabled(false);
		txtID_TaiKhoan.setBounds(178, 253, 132, 19);
		jPanelTaiKhoan.add(txtID_TaiKhoan);
		
		JLabel lblMNhnVin = new JLabel();
		lblMNhnVin.setText("Tên Nhân Viên");
		lblMNhnVin.setBounds(10, 295, 125, 13);
		jPanelTaiKhoan.add(lblMNhnVin);
		
		JLabel lblTnngNhp = new JLabel();
		lblTnngNhp.setText("Tên Đăng Nhập");
		lblTnngNhp.setBounds(10, 346, 125, 13);
		jPanelTaiKhoan.add(lblTnngNhp);
		
		txtUser_TaiKhoan = new JTextField();
		txtUser_TaiKhoan.setBounds(178, 343, 132, 19);
		jPanelTaiKhoan.add(txtUser_TaiKhoan);
		
		JLabel lblMtKhu = new JLabel();
		lblMtKhu.setText("Mật Khẩu");
		lblMtKhu.setBounds(10, 391, 125, 13);
		jPanelTaiKhoan.add(lblMtKhu);
		
		 txtPassword_TaiKhoan = new JTextField();
		 txtPassword_TaiKhoan.setBounds(178, 388, 132, 19);
		jPanelTaiKhoan.add( txtPassword_TaiKhoan);
		
		JLabel jLabel23 = new JLabel();
		jLabel23.setText("Quyền");
		jLabel23.setBounds(10, 446, 145, 13);
		jPanelTaiKhoan.add(jLabel23);
		
		cbbQuyen_TaiKhoan = new JComboBox();
		cbbQuyen_TaiKhoan.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		cbbQuyen_TaiKhoan.setBounds(178, 442, 132, 19);
		jPanelTaiKhoan.add(cbbQuyen_TaiKhoan);
		
		
		
		JButton btnThem_TaiKhoan = new JButton();
		btnThem_TaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnThem_TaiKhoanActionPerformed(evt);
			}

			private void btnThem_TaiKhoanActionPerformed(ActionEvent evt) {
				NguoiDung_1 nd = new NguoiDung_1();
				nd.setMaNhanVien(String.valueOf(listNV.get(cbNhanVien.getSelectedIndex()).getMaNhanVien()));
				nd.setTenDangNhap(txtUser_TaiKhoan.getText());
				nd.setMatKhau(txtPassword_TaiKhoan.getText());
				nd.setMaQuyen(String.valueOf(listQ.get(cbbQuyen_TaiKhoan.getSelectedIndex()).getMaQuyen()));
		       NguoiDungDAO ndDao =new NguoiDungDAO() ;
		       if (ndDao.ThemTaiKhoan(nd)>0 )
		       {    
		    	   JOptionPane.showMessageDialog(null, "lưu  thành công");
				      hienthiNguoiDung();
				      }
				      else
				           JOptionPane.showMessageDialog(null, "lưu that bại");
				}
		});
		btnThem_TaiKhoan.setText("Tạo Tài Khoản");
		btnThem_TaiKhoan.setBounds(339, 252, 145, 21);
		jPanelTaiKhoan.add(btnThem_TaiKhoan);
		
		JButton btnXoa_TaiKhoan = new JButton();
		btnXoa_TaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnXoa_TaiKhoanActionPerformed(evt);
			}

			private void btnXoa_TaiKhoanActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				 int index = tblTaiKhoan_TaiKhoan.getSelectedRow();     
			     NguoiDungDAO nddao = new NguoiDungDAO();
			     nddao.xoaTaiKhoa(tblTaiKhoan_TaiKhoan.getValueAt(index,0).toString());
			     hienthiNguoiDung();
			}
		});
		btnXoa_TaiKhoan.setText("Xóa Tài Khoản");
		btnXoa_TaiKhoan.setBounds(339, 387, 145, 21);
		jPanelTaiKhoan.add(btnXoa_TaiKhoan);
		
		JButton btnSua_TaiKhoan = new JButton();
		btnSua_TaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSua_TaiKhoanActionPerformed(evt);
			}

			private void btnSua_TaiKhoanActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				NguoiDung_1 nd = new NguoiDung_1();
				nd.setMaNguoiDung(Integer.parseInt(txtID_TaiKhoan.getText()));
				nd.setMaNhanVien(String.valueOf(listNV.get(cbNhanVien.getSelectedIndex()).getMaNhanVien()));
				nd.setTenDangNhap(txtUser_TaiKhoan.getText());
				nd.setMatKhau(txtPassword_TaiKhoan.getText());
				nd.setMaQuyen(String.valueOf(listQ.get(cbbQuyen_TaiKhoan.getSelectedIndex()).getMaQuyen()));
		       NguoiDungDAO ndDao =new NguoiDungDAO() ;
		       if (ndDao.capnhapTaiKhoan(nd)>0 )
		       {    
		    	   JOptionPane.showMessageDialog(null, "câp nhật thành công");
		    	   hienthiNguoiDung();
		       }
		       else
		           JOptionPane.showMessageDialog(null, "cập nhật that bại");
				}
		});
		btnSua_TaiKhoan.setText("Cập Nhật Tài Khoản");
		btnSua_TaiKhoan.setBounds(339, 316, 145, 21);
		jPanelTaiKhoan.add(btnSua_TaiKhoan);
		
		cbNhanVien = new JComboBox();
		cbNhanVien.setBounds(178, 292, 132, 19);
		jPanelTaiKhoan.add(cbNhanVien);
		
		JPanel jPanelChucVu = new JPanel();
		jPanelChucVu.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent evt) {
				jPanelChucVuComponentShown(evt);
			}

			private void jPanelChucVuComponentShown(ComponentEvent evt) {
				// TODO Auto-generated method stub
				hienthiChucVu();
			}
		});
		jTabbedPaneNhanVien.addTab("Chức vụ", null, jPanelChucVu, null);
		jPanelChucVu.setLayout(null);
		
		JScrollPane jScrollPane12 = new JScrollPane();
		jScrollPane12.setBounds(38, 32, 556, 239);
		jPanelChucVu.add(jScrollPane12);
		
		tblChucVu_ChucVu = new JTable();
		tblChucVu_ChucVu.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				tblChucVu_ChucVuMouseClicked(evt);
			}

			private void tblChucVu_ChucVuMouseClicked(MouseEvent evt) {
				// TODO Auto-generated method stub
				  int viTriDongVuaBam = tblChucVu_ChucVu.getSelectedRow();
			        txtMaChucVu_ChucVu.setText(tblChucVu_ChucVu.getValueAt(viTriDongVuaBam, 0).toString());
			        txtTenChucVu_ChucVu.setText(tblChucVu_ChucVu.getValueAt(viTriDongVuaBam, 1).toString());
			}
		});
		tblChucVu_ChucVu.setModel(new DefaultTableModel(
			new Object[][] {
				{null,null,null}
			},
			new String[] {
				 "M\u00E3 Ch\u1EE9c V\u1EE5", "T\u00EAn Ch\u1EE9c V\u1EE5"
			}
		));
		jScrollPane12.setViewportView(tblChucVu_ChucVu);
		
		JPanel jPanel20 = new JPanel();
		jPanel20.setBackground(new Color(192, 192, 192));
		jPanel20.setBounds(638, 35, 363, 199);
		jPanelChucVu.add(jPanel20);
		
		JLabel jLabel25 = new JLabel();
		jLabel25.setText("Mã Chức Vụ");
		
		JLabel jLabel26 = new JLabel();
		jLabel26.setText("Tên Chức Vụ");
		
		txtTenChucVu_ChucVu = new JTextField();
		
		txtMaChucVu_ChucVu = new JTextField();
		txtMaChucVu_ChucVu.setEnabled(false);
		
		JButton btnThem_ChucVu = new JButton();
		btnThem_ChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnThem_ChucVuActionPerformed(evt);
			}

			private void btnThem_ChucVuActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				ChucVu cv = new ChucVu();
				cv.setTenChucVu(txtTenChucVu_ChucVu.getText());
		       ChucVuDAO ndDao =new ChucVuDAO() ;
		       if (ndDao.ThemChucVu(cv)>0 )
		       {    
		    	   JOptionPane.showMessageDialog(null, "lưu thành công");
				      hienthiChucVu();
				      }
				      else
				           JOptionPane.showMessageDialog(null, "lưu that bại");
				}
		});
		btnThem_ChucVu.setText("Thêm Chức Vụ");
		
		JButton btnSua_ChucVu = new JButton();
		btnSua_ChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSua_ChucVuActionPerformed(evt);
			}

			private void btnSua_ChucVuActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				ChucVu cv = new ChucVu();
				cv.setMaChucVu(Integer.parseInt(txtMaChucVu_ChucVu.getText()));
				cv.setTenChucVu(txtTenChucVu_ChucVu.getText());
		       ChucVuDAO cvDao =new ChucVuDAO() ;
		       if (cvDao.capnhapChucVu(cv)>0 )
		       {    
		    	   JOptionPane.showMessageDialog(null, "lưu thành công");
				      hienthiChucVu();
				      loadComboboxCV();
				      }
				      else
				           JOptionPane.showMessageDialog(null, "lưu that bại");
				}
		});
		btnSua_ChucVu.setText("Cập Nhật Chức Vụ");
		
		JButton btnXoa_ChucVu = new JButton();
		btnXoa_ChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnXoa_ChucVuActionPerformed(evt);
			}

			private void btnXoa_ChucVuActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				int index = tblChucVu_ChucVu.getSelectedRow();     
			     ChucVuDAO cvDao = new ChucVuDAO();
			     cvDao.xoaCV(tblChucVu_ChucVu.getValueAt(index,0).toString());
			     hienthiChucVu();
			}
		});
		btnXoa_ChucVu.setText("Xóa Chức Vụ");
		GroupLayout gl_jPanel20 = new GroupLayout(jPanel20);
		gl_jPanel20.setHorizontalGroup(
			gl_jPanel20.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel20.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel20.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel25)
						.addComponent(jLabel26))
					.addGap(66)
					.addGroup(gl_jPanel20.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnXoa_ChucVu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtTenChucVu_ChucVu, Alignment.LEADING)
						.addComponent(txtMaChucVu_ChucVu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(btnThem_ChucVu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSua_ChucVu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_jPanel20.setVerticalGroup(
			gl_jPanel20.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel20.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanel20.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel25)
						.addComponent(txtMaChucVu_ChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_jPanel20.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel26)
						.addComponent(txtTenChucVu_ChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnThem_ChucVu)
					.addGap(18)
					.addComponent(btnSua_ChucVu)
					.addGap(10)
					.addComponent(btnXoa_ChucVu)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel20.setLayout(gl_jPanel20);
		tblTaiKhoan_TaiKhoan.getColumnModel().getColumn(0).setPreferredWidth(145);
		tblTaiKhoan_TaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(108);
		tblTaiKhoan_TaiKhoan.getColumnModel().getColumn(2).setPreferredWidth(112);
		tblTaiKhoan_TaiKhoan.getColumnModel().getColumn(3).setPreferredWidth(103);
		hienthiNhanVien();
		hienthiNguoiDung();
		hienthiChucVu();
		loadComboboxCV();
		loadComboboxNV();
		loadComboboxQ();
	}
	
	public static void hienthiNhanVien() {
		NhanVienDAO  dao = new NhanVienDAO();
		ArrayList<NhanVien> arrayList = dao.docLS();
		DefaultTableModel model = (DefaultTableModel)tblNhanVien_NhanVien.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
			  vec.add(arrayList.get(i).getMaNhanVien());
		      vec.add(arrayList.get(i).getTenNhanVien());
		      vec.add(arrayList.get(i).getGioiTinh());
		      vec.add(arrayList.get(i).getNgayVaoLam());
		      vec.add(arrayList.get(i).getSoDienThoai());
		      vec.add(arrayList.get(i).getMaChucVu());
	        model.addRow(vec); 
		}
	}
	public static void hienthiNguoiDung() {
		NguoiDungDAO  dao = new NguoiDungDAO();
		ArrayList<NguoiDung_1> arrayList = dao.docLS();
		DefaultTableModel model = (DefaultTableModel)tblTaiKhoan_TaiKhoan.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
			  vec.add(arrayList.get(i).getMaNguoiDung());
		      vec.add(arrayList.get(i).getMaNhanVien());
		      vec.add(arrayList.get(i).getTenDangNhap());
		      vec.add(arrayList.get(i).getMatKhau());
		      vec.add(arrayList.get(i).getMaQuyen());
	        model.addRow(vec); 
		}
	}
	public static void hienthiChucVu() {
		ChucVuDAO  dao = new ChucVuDAO();
		ArrayList<ChucVu> arrayList = dao.docLS();
		DefaultTableModel model = (DefaultTableModel)tblChucVu_ChucVu.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
			  vec.add(arrayList.get(i).getMaChucVu());
		      vec.add(arrayList.get(i).getTenChucVu());
	        model.addRow(vec); 
		}
	}
	public void loadComboboxCV() {
		cbbChucVu_NhanVien_1.removeAllItems();
		ChucVuDAO dao = new ChucVuDAO();
		listCV = dao.docLS();
		for (int i = 0; i < listCV.size(); i++) {
			System.out.println("esté");
			cbbChucVu_NhanVien_1.addItem(listCV.get(i).getTenChucVu());
		}
	}
	public void loadComboboxQ() {
		// TODO Auto-generated method stub
		cbbQuyen_TaiKhoan.removeAllItems();
		NguoiDungDAO dao = new NguoiDungDAO();
		listQ = dao.ds();
		for (int i = 0; i < listQ.size(); i++) {
			cbbQuyen_TaiKhoan.addItem(listQ.get(i).getTenQuyen());
		}
	}
	public void loadComboboxNV() {
		// TODO Auto-generated method stub
		cbNhanVien.removeAllItems();
		NhanVienDAO dao = new NhanVienDAO();
		listNV = dao.docLS();
		for (int i = 0; i < listNV.size(); i++) {
			cbNhanVien.addItem(listNV.get(i).getTenNhanVien());
		}
	}
}

