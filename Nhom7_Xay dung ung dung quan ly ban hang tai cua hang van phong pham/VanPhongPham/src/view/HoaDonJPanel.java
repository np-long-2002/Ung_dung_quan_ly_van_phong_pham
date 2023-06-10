package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import model.ChiTietHoaDon;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class HoaDonJPanel extends JPanel {
	private static JTable tbHD;
	private static ArrayList<HoaDon> arrayList;
	private JTextField txtNgayLap;
	private JComboBox cbcTenKH, cbcTenNV,cbcSP;
	private ArrayList<KhachHang> listKH;
	private ArrayList<NhanVien> listNV;
	private ArrayList<SanPham> listSP;
	private JTable tableCTHD;
	private JTextField txtSL;
	private JTextField txtMaHD;

	/**
	 * Create the panel.
	 */
	public HoaDonJPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1081, 638);
		add(panel);
		panel.setLayout(null);

		JPanel pnView = new JPanel();
		pnView.setBounds(0, 0, 599, 315);
		panel.add(pnView);
		pnView.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 579, 295);
		pnView.add(scrollPane);
		tbHD = new JTable();
		tbHD.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbHD);
		tbHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "T\u00EAn Kh\u00E1ch H\u00E0ng", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Ng\u00E0y L\u1EADp H\u00F3a \u0110\u01A1n", "T\u1ED5ng Ti\u1EC1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		tbHD.getColumnModel().getColumn(3).setPreferredWidth(76);
		
		JPanel pnEdit = new JPanel();
		pnEdit.setBackground(new Color(192, 192, 192));
		pnEdit.setBounds(609, 0, 355, 315);
		panel.add(pnEdit);
		pnEdit.setLayout(null);
		
		JLabel lblTnKhchHng = new JLabel("Tên khách hàng");
		lblTnKhchHng.setBounds(25, 31, 73, 13);
		pnEdit.add(lblTnKhchHng);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setBounds(32, 71, 66, 13);
		pnEdit.add(lblTnNhnVin);
		
		cbcTenKH = new JComboBox();
		cbcTenKH.setBounds(124, 27, 96, 21);
		pnEdit.add(cbcTenKH);
		cbcTenNV = new JComboBox();
		cbcTenNV.setBounds(124, 67, 96, 21);
		pnEdit.add(cbcTenNV);

		
		JButton btnThemHD = new JButton("Tạo Hóa Đơn");
		btnThemHD.setBounds(25, 118, 195, 21);
		pnEdit.add(btnThemHD);
		
		JButton btnXoaHD = new JButton("Xóa Hóa Đơn");
		btnXoaHD.setBounds(25, 210, 195, 21);
		pnEdit.add(btnXoaHD);
		
		JButton btnSuaHD = new JButton("Cập Nhật Hóa Đơn");
		btnSuaHD.setBounds(25, 167, 195, 21);
		pnEdit.add(btnSuaHD);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(25, 251, 195, 31);
		pnEdit.add(btnThanhToan);
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tbHD.getSelectedRow();
				if (r != -1) {
					HoaDonDAO hdDao = new HoaDonDAO();
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(tbHD.getValueAt(r, 0).toString()));
					hd.setTrangThai("Đã Thanh Toán");
					hdDao.updateTrangThai(hd);
					loadDataTableHoaDon();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Hoa Don Can Thanh Toan!");
				}
				
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 342, 579, 285);
		panel.add(scrollPane_1);
		
		tableCTHD = new JTable();
		tableCTHD.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"Mã Chi Tiết Hóa Đơn ","M\u00E3 h\u00F3a \u0111\u01A1n", "M\u00E3 s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "T\u1ED5ng ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(tableCTHD);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(607, 342, 355, 238);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setBounds(26, 14, 66, 13);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblSnPhm = new JLabel("Sản phẩm");
		lblSnPhm.setBounds(26, 59, 66, 13);
		panel_2.add(lblSnPhm);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(26, 101, 66, 13);
		panel_2.add(lblSLng);
		
		txtSL = new JTextField();
		txtSL.setColumns(10);
		txtSL.setBounds(132, 98, 96, 19);
		panel_2.add(txtSL);
		
		cbcSP = new JComboBox();
		cbcSP.setBounds(132, 55, 96, 21);
		panel_2.add(cbcSP);
		
		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(132, 11, 96, 19);
		panel_2.add(txtMaHD);
		
		JButton btnThemCTHD = new JButton("Thêm Vào Giỏ Hàng");
		btnThemCTHD.setBounds(10, 141, 218, 21);
		panel_2.add(btnThemCTHD);
		
		JButton btnSuaCTHD = new JButton("Cập Nhật Mặt Hàng");
		btnSuaCTHD.setBounds(10, 173, 218, 21);
		panel_2.add(btnSuaCTHD);
		
		JButton btnXoaCTHD = new JButton("Xóa Mặt Hàng");
		btnXoaCTHD.setBounds(10, 205, 218, 21);
		panel_2.add(btnXoaCTHD);
		loadDataTableHoaDon();
		loadDataTableChiTiet();
		loadComboboxKH();
		loadComboboxNV();
		loadComboboxSP();
		
		btnThemHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { {
					HoaDon hd = new HoaDon();
					hd.setMaKhachHang(String.valueOf(listKH.get(cbcTenKH.getSelectedIndex()).getMaKhachHang()));
					hd.setMaNhanVien(String.valueOf(listNV.get(cbcTenNV.getSelectedIndex()).getMaNhanVien()));
					HoaDonDAO hdDao = new HoaDonDAO();
					hdDao.addHoaDon(hd);
					loadDataTableHoaDon();
					loadDataTableChiTiet();
				}
			}
		});
		
		btnSuaHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tbHD.getSelectedRow();
				if (r != -1) {
					HoaDonDAO hdDao = new HoaDonDAO();
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(tbHD.getValueAt(r, 0).toString()));
					hd.setMaKhachHang(String.valueOf(listKH.get(cbcTenKH.getSelectedIndex()).getMaKhachHang()));
					hd.setMaNhanVien(String.valueOf(listNV.get(cbcTenNV.getSelectedIndex()).getMaNhanVien()));
					hdDao.updateHoaDon(hd);
					loadDataTableHoaDon();
					loadDataTableChiTiet();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Dong Hoa Don Can Sua!");
				}
			}
		});
		
		btnXoaHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tbHD.getSelectedRow();
				if (r != -1) {
					HoaDonDAO hdDao = new HoaDonDAO();
					hdDao.deleteHoaDon(tbHD.getValueAt(r, 0).toString());
					loadDataTableHoaDon();
					loadDataTableChiTiet();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Dong Can Xoa!");
				}
				
			}
		});
btnThemCTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					ChiTietHoaDon hd = new ChiTietHoaDon();
					hd.setMaHoaDon(Integer.parseInt(txtMaHD.getText().trim()));
					hd.setMaSanPham(listSP.get(cbcSP.getSelectedIndex()).getMaSanPham());
					hd.setSoLuong(Integer.parseInt(txtSL.getText().trim()));
					ChiTietHoaDonDAO hdDao = new ChiTietHoaDonDAO();
					hdDao.addCTHoaDon(hd);
					loadDataTableChiTiet();
					loadDataTableHoaDon();
				}
			
		});
		
		btnXoaCTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableCTHD.getSelectedRow();
				if (r != -1) {
					ChiTietHoaDonDAO hdDao = new ChiTietHoaDonDAO();
					hdDao.deleteCTHoaDon(tableCTHD.getValueAt(r, 0).toString());
					loadDataTableChiTiet();
					loadDataTableHoaDon();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Dong Can Xoa!");
				}
				
			}
		});
		
		btnSuaCTHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tableCTHD.getSelectedRow();
				if (r != -1) {
					ChiTietHoaDonDAO hdDao = new ChiTietHoaDonDAO();
					ChiTietHoaDon hd = new ChiTietHoaDon();
					hd.setMaChiTietHD(Integer.parseInt(tableCTHD.getValueAt(r, 0).toString()));
					hd.setMaHoaDon(Integer.parseInt(tableCTHD.getValueAt(r, 1).toString()));
					hd.setMaSanPham(Integer.parseInt(tableCTHD.getValueAt(r, 2).toString()));
					hd.setSoLuong(Integer.parseInt(txtSL.getText().trim()));
					hdDao.updateCTHoaDon(hd);
					loadDataTableChiTiet();
					loadDataTableHoaDon();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Dong Chi Tiet Hoa Don Can Sua!");
				}
			}
		});
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = tbHD.getSelectedRow();
				if (r != -1) {
					HoaDonDAO hdDao = new HoaDonDAO();
					HoaDon hd = new HoaDon();
					hd.setMaHoaDon(Integer.parseInt(tbHD.getValueAt(r, 0).toString()));
					hd.setTrangThai("Đã Thanh Toán");
					hdDao.updateTrangThai(hd);
					loadDataTableHoaDon();
				}else {
					JOptionPane.showMessageDialog(null, "Ban Chua Chon Hoa Don Can Thanh Toan!");
				}
				
			}
		});
		tableCTHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableCTHD.getSelectedRow();
				if (r != -1) {
					txtMaHD.setText(tableCTHD.getValueAt(r, 1).toString());
					txtSL.setText(tableCTHD.getValueAt(r, 3).toString());
					
				}
				
			}
		});
		loadDataTableHoaDon();
		tbHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tbHD.getSelectedRow();
				if (r != -1) {
					
					txtMaHD.setText(tbHD.getValueAt(r, 0).toString());
				}
				
			}
		});
		
	}

	public void loadDataTableHoaDon() {
		HoaDonDAO dao = new HoaDonDAO();
		arrayList = dao.docLS();
		DefaultTableModel model = (DefaultTableModel) tbHD.getModel();
		model.setRowCount(0);
		for (int i = 0; i < arrayList.size(); i++) {
			Vector<Object> vec = new Vector<>();
			vec.add(arrayList.get(i).getMaHoaDon());
			vec.add(arrayList.get(i).getMaKhachHang());
			vec.add(arrayList.get(i).getMaNhanVien());
			vec.add(arrayList.get(i).getNgayLapHoaDon());
			vec.add(arrayList.get(i).getTongTien());
			vec.add(arrayList.get(i).getTrangThai());
			model.addRow(vec);
		}

	}
	public void loadDataTableChiTiet() {
		ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();
		ArrayList<ChiTietHoaDon> list = new ArrayList();
		list = dao.docLS();
		DefaultTableModel model = (DefaultTableModel) tableCTHD.getModel();
		model.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> vec = new Vector<>();
			vec.add(list.get(i).getMaChiTietHD());
			vec.add(list.get(i).getMaHoaDon());
			vec.add(list.get(i).getMaSanPham());
			vec.add(list.get(i).getSoLuong());
			vec.add(list.get(i).getTongTien());
			model.addRow(vec);
		}
	}
	
	public void loadComboboxKH() {
		cbcTenKH.removeAllItems();
		KhachHangDAO dao = new KhachHangDAO();
		listKH = dao.docLS();
		for (int i = 0; i < listKH.size(); i++) {
			cbcTenKH.addItem(listKH.get(i).getTenKhachHang());
		}
	}
	
	public void loadComboboxNV() {
		cbcTenNV.removeAllItems();
		NhanVienDAO dao = new NhanVienDAO();
		listNV = dao.getALlNhanVien();
		for (int i = 0; i < listNV.size(); i++) {
			System.out.println("esté");
			cbcTenNV.addItem(listNV.get(i).getTenNhanVien());
		}
	}
	
	public void loadComboboxSP() {
		SanPhamDAO dao = new SanPhamDAO();
		listSP = dao.docSP();
		for (int i = 0; i < listSP.size(); i++) {
			cbcSP.addItem(listSP.get(i).getTenSanPham());
		}
	}
}
