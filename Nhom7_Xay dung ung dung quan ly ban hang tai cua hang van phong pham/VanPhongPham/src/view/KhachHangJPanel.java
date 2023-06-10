package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import model.KhachHang;
import model.LoaiKhachHang;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KhachHangJPanel extends JPanel {
	private static JTable tbKH;
	private static ArrayList<KhachHang> arrayList;
	private static ArrayList<LoaiKhachHang> arrayListKH;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtGT;
	private JTextField txtSDT;
	private JTextField txtTK;
	static JComboBox cbLoaiKH ;
	/**
	 * Create the panel.
	 */
	public KhachHangJPanel() {
		setForeground(new Color(192, 192, 192));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1004, 413);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 984, 391);
		panel.add(scrollPane);
		
		tbKH = new JTable();
		tbKH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 int viTriDongVuaBam = tbKH.getSelectedRow();
			     	txtMa.setText( tbKH.getValueAt(viTriDongVuaBam, 0).toString());
			        txtTen.setText(tbKH.getValueAt(viTriDongVuaBam, 1).toString());
			        txtGT.setText(tbKH.getValueAt(viTriDongVuaBam, 2).toString());
			        txtSDT.setText(tbKH.getValueAt(viTriDongVuaBam, 3).toString());
			        cbLoaiKH.setSelectedItem(arrayList.get(viTriDongVuaBam).getMaLoaiKH());
			}
		});
		tbKH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Lo\u1EA1i Kh\u00E1ch H\u00E0ng"
			}
		));
		tbKH.getColumnModel().getColumn(0).setPreferredWidth(115);
		tbKH.getColumnModel().getColumn(1).setPreferredWidth(120);
		scrollPane.setViewportView(tbKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 435, 1002, 160);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng");
		lblNewLabel.setBounds(10, 11, 130, 14);
		panel_1.add(lblNewLabel);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setBounds(150, 11, 221, 20);
		panel_1.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng");
		lblTnKhchHng.setBounds(10, 42, 130, 14);
		panel_1.add(lblTnKhchHng);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(150, 42, 221, 20);
		panel_1.add(txtTen);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setBounds(435, 11, 108, 14);
		panel_1.add(lblGiiTnh);
		
		txtGT = new JTextField();
		txtGT.setColumns(10);
		txtGT.setBounds(553, 11, 130, 20);
		panel_1.add(txtGT);
		
		JLabel lblLoiKhchHng = new JLabel("Loại Khách Hàng");
		lblLoiKhchHng.setBounds(435, 42, 108, 14);
		panel_1.add(lblLoiKhchHng);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại");
		lblSinThoi.setBounds(10, 73, 130, 14);
		panel_1.add(lblSinThoi);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(150, 73, 221, 20);
		panel_1.add(txtSDT);
		
		cbLoaiKH = new JComboBox();
		cbLoaiKH.setModel(new DefaultComboBoxModel(new String[] {"Long", "Toàn", "Thảo"}));
		cbLoaiKH.setBounds(553, 38, 130, 22);
		panel_1.add(cbLoaiKH);
		
		JButton btnThem = new JButton("Làm Mới");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMa.setText(" ");
				txtTen.setText("");
				txtGT.setText("");
				txtSDT.setText("");
				hienthi();
			}
		});
		btnThem.setBounds(10, 118, 89, 23);
		panel_1.add(btnThem);
		
		JButton btnLuu = new JButton("Lưu Thông Tin Khách Hàng");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KhachHang kh = new KhachHang();
				kh.setTenKhachHang(txtTen.getText());
				kh.setGioiTinh(txtGT.getText());
				kh.setSoDienThoai(txtSDT.getText());
				kh.setMaLoaiKH(String.valueOf(arrayListKH.get(cbLoaiKH.getSelectedIndex()).getMaLoaiKH()));
				KhachHangDAO dao = new KhachHangDAO();
				if (dao.luuKH(kh)>0 )
			     {    
			      JOptionPane.showMessageDialog(null, "Thêm thành công");
			      hienthi();
			      }
			      else
			           JOptionPane.showMessageDialog(null, "Thêm that bại");
			}
		});
		btnLuu.setBounds(435, 84, 248, 23);
		panel_1.add(btnLuu);
		
		JButton btnXoa = new JButton("Xóa Khách Hàng");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbKH.getSelectedRow();
				KhachHangDAO dao = new KhachHangDAO();
				dao.xoaKH(tbKH.getValueAt(index,0).toString());
				hienthi();
			}
		});
		btnXoa.setBounds(150, 118, 221, 23);
		panel_1.add(btnXoa);
		
		JButton btnSua = new JButton("Cập Nhật Thông Tin Khách Hàng");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(Integer.parseInt(txtMa.getText()));
				kh.setTenKhachHang(txtTen.getText());
				kh.setGioiTinh(txtGT.getText());
				kh.setSoDienThoai(txtSDT.getText());
				kh.setMaLoaiKH(String.valueOf(arrayListKH.get(cbLoaiKH.getSelectedIndex()).getMaLoaiKH()));
				KhachHangDAO dao = new KhachHangDAO();
				if (dao.capnhapKH(kh)>0 )
			       {    
			    	   JOptionPane.showMessageDialog(null, "câp nhật thành công");
			    	   hienthi();
			       }
			       else
			           JOptionPane.showMessageDialog(null, "cập nhật that bại,khong duoc sua ma");
			}
		});
		btnSua.setBounds(435, 118, 248, 23);
		panel_1.add(btnSua);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(704, 11, 269, 75);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm Theo Tên");
		lblNewLabel_1.setBounds(10, 14, 108, 14);
		panel_2.add(lblNewLabel_1);
		
		txtTK = new JTextField();
		txtTK.setBounds(128, 11, 130, 20);
		panel_2.add(txtTK);
		txtTK.setColumns(10);
		
		JButton btnTK = new JButton("Tìm Kiếm");
		btnTK.setBounds(10, 42, 248, 23);
		panel_2.add(btnTK);
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHangDAO dao = new KhachHangDAO();
				arrayList = dao.tkKH(txtTK.getText());
				DefaultTableModel model = (DefaultTableModel)tbKH.getModel();
				model.setRowCount(0);
				for(int i=0;i<arrayList.size();i++) {
					Vector<Object> vec = new Vector<>();
					  vec.add(arrayList.get(i).getMaKhachHang());
				      vec.add(arrayList.get(i).getTenKhachHang());
				      vec.add(arrayList.get(i).getGioiTinh());
				      vec.add(arrayList.get(i).getSoDienThoai());
				      vec.add(arrayList.get(i).getMaLoaiKH());
			        model.addRow(vec); 
				}
			}
		});
		hienthi();
		loadComboboxLoaiKH();
	}
	public static void hienthi() {
		KhachHangDAO kh = new KhachHangDAO();
		arrayList = kh.docLS();
		DefaultTableModel model = (DefaultTableModel)tbKH.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
			  vec.add(arrayList.get(i).getMaKhachHang());
		      vec.add(arrayList.get(i).getTenKhachHang());
		      vec.add(arrayList.get(i).getGioiTinh());
		      vec.add(arrayList.get(i).getSoDienThoai());
		      vec.add(arrayList.get(i).getMaLoaiKH());
	        model.addRow(vec); 
		}
	}
	public static void loadComboboxLoaiKH() {
		cbLoaiKH.removeAllItems();
		KhachHangDAO dao = new KhachHangDAO();
		arrayListKH = dao.doc();
		for (int i = 0; i < arrayListKH.size(); i++) {
			cbLoaiKH.addItem(arrayListKH.get(i).getTenLoaiKH());
		}
	}
}
