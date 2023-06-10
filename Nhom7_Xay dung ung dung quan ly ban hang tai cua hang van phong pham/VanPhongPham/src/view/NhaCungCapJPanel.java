package view;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCapDAO;
import model.NhaCungCap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NhaCungCapJPanel extends JPanel {
	private static JTable tbNCC;
	private static ArrayList<NhaCungCap> arrayList;
	private JTextField txtTK;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	/**
	 * Create the panel.
	 */
	public NhaCungCapJPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1038, 339);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1018, 317);
		panel.add(scrollPane);
		
		tbNCC = new JTable();
		tbNCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int viTriDongVuaBam = tbNCC.getSelectedRow();
			     	txtMa.setText( tbNCC.getValueAt(viTriDongVuaBam, 0).toString());
			        txtTen.setText(tbNCC.getValueAt(viTriDongVuaBam, 1).toString());
			        txtDiaChi.setText(tbNCC.getValueAt(viTriDongVuaBam, 2).toString());
			        txtSDT.setText(tbNCC.getValueAt(viTriDongVuaBam, 3).toString());
			        txtEmail.setText(tbNCC.getValueAt(viTriDongVuaBam, 4).toString());
			}
		});
		tbNCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E0 Cung C\u1EA5p", "T\u00EAn Nh\u00E0 Cung C\u1EA5p", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Email"
			}
		));
		scrollPane.setViewportView(tbNCC);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 361, 1038, 170);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(689, 11, 339, 150);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tìm Kiếm Nhà Cung Cấp");
		lblNewLabel_4.setBounds(10, 14, 159, 14);
		panel_2.add(lblNewLabel_4);
		
		txtTK = new JTextField();
		txtTK.setBounds(179, 11, 150, 20);
		panel_2.add(txtTK);
		txtTK.setColumns(10);
		
		JButton btnTK = new JButton("Tìm Kiếm");
		btnTK.setBounds(10, 80, 319, 23);
		panel_2.add(btnTK);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 11, 669, 150);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMNhaCung = new JLabel("Mã Nha Cung Cap");
		lblMNhaCung.setBounds(10, 15, 108, 14);
		panel_3.add(lblMNhaCung);
		
		txtMa = new JTextField();
		txtMa.setEnabled(false);
		txtMa.setColumns(10);
		txtMa.setBounds(113, 12, 280, 20);
		panel_3.add(txtMa);
		
		JLabel lblNewLabel = new JLabel("Tên Nhà Cung Cấp");
		lblNewLabel.setBounds(10, 43, 108, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Địa Chỉ");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(113, 40, 280, 20);
		panel_3.add(txtTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(113, 68, 280, 20);
		panel_3.add(txtDiaChi);
		
		JLabel lblNewLabel_2 = new JLabel("Số Điện Thoại");
		lblNewLabel_2.setBounds(10, 99, 108, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(10, 127, 46, 14);
		panel_3.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(113, 124, 280, 20);
		panel_3.add(txtEmail);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(113, 96, 280, 20);
		panel_3.add(txtSDT);
		
		JButton btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBounds(403, 11, 239, 23);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMa.setText(" ");
				txtTen.setText("");
				txtDiaChi.setText("");
				txtSDT.setText("");
				txtEmail.setText("");
				hienthi();
			}
				
		});
		panel_3.add(btnLmMi);
		
		JButton btnLuThngTin = new JButton("Lưu Thông Tin Nhà Cung Cấp");
		btnLuThngTin.setBounds(403, 39, 239, 23);
		btnLuThngTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaCungCap ncc = new NhaCungCap();
				ncc.setTenNhaCungCap(txtTen.getText().toString().trim());
				ncc.setDiaChi(txtDiaChi.getText().toString().trim());
				ncc.setSoDienThoai(txtSDT.getText().toString().trim());
				ncc.setEmail(txtEmail.getText().toString().trim());
				NhaCungCapDAO dao = new NhaCungCapDAO();
				if (dao.luuNCC(ncc)>0 )
			     {    
			      JOptionPane.showMessageDialog(null, "Thêm thành công");
			      hienthi();
			      }
			      else
			           JOptionPane.showMessageDialog(null, "Thêm that bại");
			}
		});
		panel_3.add(btnLuThngTin);
		
		JButton btnCpNhtThng = new JButton("Cập Nhật Thông Tin Nhà Cung Cấp");
		btnCpNhtThng.setBounds(403, 67, 239, 23);
		btnCpNhtThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaCungCap ncc = new NhaCungCap();
				ncc.setMaNhaCungCap(Integer.parseInt(txtMa.getText()));
				ncc.setTenNhaCungCap(txtTen.getText());
				ncc.setDiaChi(txtDiaChi.getText());
				ncc.setSoDienThoai(txtSDT.getText());
				ncc.setEmail(txtEmail.getText());
				NhaCungCapDAO dao = new NhaCungCapDAO();
				if (dao.capnhapNCC(ncc)>0 )
			       {    
			    	   JOptionPane.showMessageDialog(null, "câp nhật thành công");
			    	   hienthi();
			       }
			       else
			           JOptionPane.showMessageDialog(null, "cập nhật that bại,khong duoc sua ma");
			}
		});
		panel_3.add(btnCpNhtThng);
		
		JButton btnXaThngTin = new JButton("Xóa Thông Tin Nhà Cung Cấp\\");
		btnXaThngTin.setBounds(403, 95, 239, 23);
		btnXaThngTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tbNCC.getSelectedRow();
				NhaCungCapDAO dao = new NhaCungCapDAO();
				dao.xoaNCC(tbNCC.getValueAt(index,0).toString());
				hienthi();
			}
		});
		panel_3.add(btnXaThngTin);
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhaCungCapDAO dao = new NhaCungCapDAO();
				arrayList = dao.tkNCC(txtTK.getText());
				DefaultTableModel model = (DefaultTableModel)tbNCC.getModel();
				model.setRowCount(0);
				for(int i=0;i<arrayList.size();i++) {
					Vector<Object> vec = new Vector<>();
					  vec.add(arrayList.get(i).getMaNhaCungCap());
				      vec.add(arrayList.get(i).getTenNhaCungCap());
				      vec.add(arrayList.get(i).getDiaChi());
				      vec.add(arrayList.get(i).getSoDienThoai());
				      vec.add(arrayList.get(i).getEmail());
			        model.addRow(vec); 
				}
			}
		});
		hienthi();
	}
	public static void hienthi() {
		NhaCungCapDAO kh = new NhaCungCapDAO();
		arrayList = kh.docLS();
		DefaultTableModel model = (DefaultTableModel)tbNCC.getModel();
		model.setRowCount(0);
		for(int i=0;i<arrayList.size();i++) {
			Vector<Object> vec = new Vector<>();
			  vec.add(arrayList.get(i).getMaNhaCungCap());
		      vec.add(arrayList.get(i).getTenNhaCungCap());
		      vec.add(arrayList.get(i).getDiaChi());
		      vec.add(arrayList.get(i).getSoDienThoai());
		      vec.add(arrayList.get(i).getEmail());
	        model.addRow(vec); 
		}
	}
}
