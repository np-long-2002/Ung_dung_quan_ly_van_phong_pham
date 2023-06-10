package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jfree.data.xy.YInterval;

import dao.ChiTietPhieuNhapDAO;
import dao.LoaiSanPhamDAO;
import dao.NhaCungCapDAO;
import dao.NhaSanXuatDAO;
import dao.NhanVienDAO;
import dao.PhieuNhapDAO;
import dao.SanPhamDAO;
import model.ChiTietPhieuNhap;
import model.ItemCTPN;
import model.ItemPhieuNhap;
import model.ItemSanPham;
import model.LoaiSanPham;
import model.NhaCungCap;
import model.NhaSanXuat;
import model.NhanVien;
import model.SanPham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SanPhamJPanel extends JPanel {
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;

	private JTable table;
	private ListSelectionModel selectionTableModel;
	private DefaultTableModel tableModel;

	private JTable tableLoaiSP;
	private ListSelectionModel selectionTableModelLoaiSP;
	private DefaultTableModel tableModelLoaiSP;

	private JTable tableSP_2;
	private ListSelectionModel selectionTableModelSP_2;
	private DefaultTableModel tableModelSP_2;

	private JTable tablePhieuNhap;
	private ListSelectionModel selectionTableModelPhieuNhap;
	private DefaultTableModel tableModelPhieuNhap;

	private JTable tableCTPhieuNhap;
	private ListSelectionModel selectionTableModelCTPhieuNhap;
	private DefaultTableModel tableModelCTPhieuNhap;

	private SanPhamDAO sanPhamDAO;
	private LoaiSanPhamDAO loaiSanPhamDAO;
	private PhieuNhapDAO phieuNhapDAO;
	private ChiTietPhieuNhapDAO ctphieuNhapDAO;
	private NhanVienDAO nhanVienDAO;
	private NhaSanXuatDAO nhaSanXuatDAO;
	private NhaCungCapDAO nhaCungCapDAO;

	private JLabel lblMaSanPham;
	private JLabel lblTenSanPham;
	private JLabel lblLoaiSanPham;
	private JLabel lblGiaNhap;
	private JLabel lblGiaBan;
	private JLabel lblNhaSanXuat;
	private JLabel lblTonKho;
	private JLabel lblMaLoaiSP;
	private JLabel lblTenLoaiSP;
	private JLabel lblMaPhieuNhap;
	private JLabel lblNhanVien;
	private JLabel lblNgayNhap;
	private JLabel lblNhaCungCap;
	private JLabel lblTongTien;
	private JLabel lblMaCTPN;
	private JLabel lblMaPhieuNhap2;
	private JLabel lblSanPham;
	private JLabel lblSoLuong;
	private JLabel lblTongTien2;

	private JTextField txtMaCTPN;
	private JTextField txtMaPhieuNhap2;
	private JTextField txtSanPham;
	private JTextField txtSoLuong;
	private JTextField txtTongTien2;
	private JTextField txtMaPhieuNhap;
	private JTextField txtNhanVien;
	private JTextField txtNgayNhap;
	private JTextField txtNhaCungCap;
	private JTextField txtTongTien;
	private JTextField txtTenLoaiSP;
	private JTextField txtMaSanPham;
	private JTextField txtTenSanPham;
	private JTextField txtMaLoaiSP;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	
	private JTextField txtTonKho; 

	private DefaultComboBoxModel cbxlLoaiSanPhamModel;
	private DefaultComboBoxModel cbxlNhaSanXuatModel;
	private DefaultComboBoxModel cbxlNhanVienModel;
	private DefaultComboBoxModel cbxlNhaCungCapModel;
	private DefaultComboBoxModel cbxlSanPhamModel;
	private JComboBox<String> cbxlLoaiSanPham;
	private JComboBox<String> cbxlNhaSanXuat;
	private JComboBox<String> cbxlNhanVien;
	private JComboBox<String> cbxlNhaCungCap;
	private JComboBox<String> cbxlSanPham;

	private JButton btnThemSP;
	private JButton btnSuaSP;
	private JButton btnXoaSP;

	private JButton btnThemLSP;
	private JButton btnSuaLSP;
	private JButton btnXoaLSP;

	private JButton btnThemPN;
	private JButton btnSuaPN;
	private JButton btnXoaPN;

	private JButton btnThemCTPN;
	private JButton btnSuaCTPN;
	private JButton btnXoaCTPN;

	private int rowTableSelected = 0;
	private ArrayList<LoaiSanPham> listLoaiSanPham;
	private ArrayList<NhaSanXuat> listNhaSanXuat;
	private ArrayList<ItemSanPham> listSanPham;
	private ArrayList<ItemPhieuNhap> listPhieuNhap;
	private ArrayList<ItemCTPN> listCTPN;
	private ArrayList<NhanVien> listNhanVien;
	private ArrayList<NhaCungCap> listNCC;

	private String[] columnSanPham = {"STT","Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Giá nhập","Giá bán","Nhà sản xuất","Tồn kho"};
	private String[] columnLoaiSanPham = {"STT","Mã loại sản phẩm","Tên loại sản phẩm"};
	private String[] columnSP_2 = {"STT","Mã sản phẩm","Tên sản phẩm","Loại sản phẩm"};
	private String[] columnPhieuNhap = {"STT","Mã phiếu","Nhân viên","Nhà phân phối","Tổng tiền","Ngày nhập"};
	private String[] columnCTPhieuNhap = {"STT","Mã CTPN","Mã phiếu nhập","Sản phẩm","Số lượng","Tổng tiền"};


	/**
	 * Create the panel.
	 */
	public SanPhamJPanel() {
		sanPhamDAO = new SanPhamDAO();
		loaiSanPhamDAO = new LoaiSanPhamDAO();
		nhaSanXuatDAO = new dao.NhaSanXuatDAO();
		contentPane = this;
		contentPane.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();
		tab1 = new JPanel(null);
		tab2 = new JPanel(null);
		tab3 = new JPanel(null);

		tabbedPane.add("Sản phẩm",tab1);
		tabbedPane.add("Loại sản phẩm",tab2);
		tabbedPane.add("Phiếu nhập hàng",tab3);

		contentPane.add(tabbedPane);

		initLayoutTab1();
		initLayoutTab2();
		initLayoutTab3();
	}
	//#TAB3
	private void initLayoutTab3() {
		phieuNhapDAO = new PhieuNhapDAO();
		nhanVienDAO = new NhanVienDAO();
		nhaCungCapDAO = new NhaCungCapDAO();
		listNhanVien = nhanVienDAO.getALlNhanVien();
		ctphieuNhapDAO = new ChiTietPhieuNhapDAO();
		listPhieuNhap = phieuNhapDAO.getAllPhieuNhap();
		listNCC = nhaCungCapDAO.docLS();

		/* TITLE PHIEU NHAP */
		JLabel titlePhieuNhap = new JLabel("PHIẾU NHẬP");
		titlePhieuNhap.setForeground(Color.BLUE);
		titlePhieuNhap.setBounds(360, 0, 800, 50);
		tab3.add(titlePhieuNhap);
		int y = 50;
		/* TABLE PHIEU NHAP */
		Object[][] data = convertToPhieuNhapTable(listPhieuNhap);
		tableModelPhieuNhap = new DefaultTableModel(data, columnPhieuNhap);
		tablePhieuNhap = new JTable(tableModelPhieuNhap);
		selectionTableModelPhieuNhap = tablePhieuNhap.getSelectionModel();
		JScrollPane jScrollPane = new JScrollPane(tablePhieuNhap);
		jScrollPane.setBounds(0, y, 800, 250);
		selectionTableModelPhieuNhap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ chọn một hàng tại một thời điểm
		selectionTableModelPhieuNhap.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tablePhieuNhap.getSelectedRow();
				rowTableSelected = row;
				if (!e.getValueIsAdjusting() && row != -1) {
					txtMaPhieuNhap.setText(tableModelPhieuNhap.getValueAt(row, 1).toString());
					for(int i = 0; i < cbxlNhanVienModel.getSize(); i++){
						String str = cbxlNhanVienModel.getElementAt(i).toString();
						if(tableModelPhieuNhap.getValueAt(row, 2).toString().equalsIgnoreCase(str))
						{
							cbxlNhanVienModel.setSelectedItem(cbxlNhanVienModel.getElementAt(i));
							break;
						}
					}
					for(int i = 0; i < cbxlNhaCungCapModel.getSize(); i++){
						String str = cbxlNhaCungCapModel.getElementAt(i).toString();
						if(tableModelPhieuNhap.getValueAt(row, 3).toString().equalsIgnoreCase(str))
						{
							cbxlNhaCungCapModel.setSelectedItem(cbxlNhaCungCapModel.getElementAt(i));
							break;
						}
					}
					txtNgayNhap.setText(tableModelPhieuNhap.getValueAt(row, 5).toString());
					txtTongTien.setText(tableModelPhieuNhap.getValueAt(row, 4).toString());

					ItemPhieuNhap phieuNhapSelected = listPhieuNhap.get(row);
					tableModelCTPhieuNhap.setRowCount(0);
					int stt=0;
					for(ItemCTPN item : listCTPN){
						if(phieuNhapSelected.getMaPhieuNhap()==item.getMaPhieuNhap()){
							Object[] newRow = convertToTableDataItemCTPN(item,stt);
							tableModelCTPhieuNhap.addRow(newRow);
							stt++;
						}
					}
				}
			}
		});
		tab3.add(jScrollPane);

		phieuNhapDAO = new PhieuNhapDAO();
		listCTPN = ctphieuNhapDAO.getAllCTPhieuNhap();
		/* TABLE CHI TIET PHIEU NHAP */
		int y2= 350;
		ArrayList<ItemCTPN> listByMaPhieuNhap = new ArrayList<>();
		ItemPhieuNhap phieuNhapSelected = listPhieuNhap.get(0);
		for(ItemCTPN item : listCTPN){
			if(phieuNhapSelected.getMaPhieuNhap()==item.getMaPhieuNhap()){
				listByMaPhieuNhap.add(item);
			}
		}
		Object[][] data_ct = convertToCTPhieuNhapTable(listByMaPhieuNhap);
		tableModelCTPhieuNhap = new DefaultTableModel(data_ct, columnCTPhieuNhap);
		tableCTPhieuNhap = new JTable(tableModelCTPhieuNhap);
		selectionTableModelCTPhieuNhap = tableCTPhieuNhap.getSelectionModel();
		JScrollPane jScrollPaneCT = new JScrollPane(tableCTPhieuNhap);
		jScrollPaneCT.setBounds(0, y2, 800, 250);
		selectionTableModelCTPhieuNhap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ chọn một hàng tại một thời điểm
		selectionTableModelCTPhieuNhap.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableCTPhieuNhap.getSelectedRow();
				rowTableSelected = row;
				if (!e.getValueIsAdjusting() && row != -1) {
					txtMaCTPN.setText(tableModelCTPhieuNhap.getValueAt(row, 1).toString());
					txtMaPhieuNhap2.setText(tableModelCTPhieuNhap.getValueAt(row, 2).toString());
					for(int i = 0; i < cbxlSanPhamModel.getSize(); i++){
						String str = cbxlSanPhamModel.getElementAt(i).toString();
						if(tableModelCTPhieuNhap.getValueAt(row, 3).toString().equalsIgnoreCase(str))
						{
							cbxlSanPhamModel.setSelectedItem(cbxlSanPhamModel.getElementAt(i));
							break;
						}
					}
					txtSoLuong.setText(tableModelCTPhieuNhap.getValueAt(row, 4).toString());
					txtTongTien2.setText(tableModelCTPhieuNhap.getValueAt(row, 5).toString());
				}
			}
		});
		tab3.add(jScrollPaneCT);

		/* MA PHIEU NHAP */
		y+=10;
		lblMaPhieuNhap = new JLabel("Mã phiếu nhập: ");
		txtMaPhieuNhap = new JTextField();
		txtMaPhieuNhap.setEditable(false);
		lblMaPhieuNhap.setBounds(810, y, 150, 30);
		txtMaPhieuNhap.setBounds(900, y, 200, 30);
		tab3.add(lblMaPhieuNhap);
		tab3.add(txtMaPhieuNhap);

		/* MA NHAN VIEN */
		y+=40;
		lblNhanVien = new JLabel("Nhân viên: ");
		String[] dataCBXNV = convertToNhanVienCbx(listNhanVien);
		cbxlNhanVienModel = new DefaultComboBoxModel<>(dataCBXNV);
		cbxlNhanVien = new JComboBox<>(cbxlNhanVienModel);
		lblNhanVien.setBounds(810, y, 150, 30);
		cbxlNhanVien.setBounds(900, y, 200, 30);
		tab3.add(lblNhanVien);
		tab3.add(cbxlNhanVien);

		/* NGAY NHAP */
		y+=40;
		lblNgayNhap = new JLabel("Ngày nhập: ");
		txtNgayNhap = new JTextField();
		lblNgayNhap.setBounds(810, y, 150, 30);
		txtNgayNhap.setBounds(900, y, 200, 30);
		tab3.add(lblNgayNhap);
		tab3.add(txtNgayNhap);

		/* NHA CUNG CAP */
		y+=40;
		lblNhaCungCap = new JLabel("Nhà phân phối: ");
		String[] dataCBXNCC = convertToNhaCungCapCbx(listNCC);
		cbxlNhaCungCapModel = new DefaultComboBoxModel<>(dataCBXNCC);
		cbxlNhaCungCap = new JComboBox<>(cbxlNhaCungCapModel);
		lblNhaCungCap.setBounds(810, y, 150, 30);
		cbxlNhaCungCap.setBounds(900, y, 200, 30);
		tab3.add(lblNhaCungCap);
		tab3.add(cbxlNhaCungCap);

		/* TONG TIEN */
		y+=40;
		lblTongTien = new JLabel("Tổng tiền: ");
		txtTongTien = new JTextField();
		lblTongTien.setBounds(810, y, 200, 30);
		txtTongTien.setBounds(900, y, 200, 30);
		tab3.add(lblTongTien);
		tab3.add(txtTongTien);

		/* Button Them Xoa Sua */
		//BUTTON THEM
		y+=40;
		btnThemPN = new JButton("Thêm");
		btnThemPN.setBounds(810, y, 100, 30);
		btnThemPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					eventClickThemPN();
				}catch(NumberFormatException en){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị hợp lệ");
				}
			}
        });
		tab3.add(btnThemPN);
		//BUTTON SUA
		btnSuaPN = new JButton("Sửa");
		btnSuaPN.setBounds(920, y, 100, 30);
		btnSuaPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					eventClickSuaPN();
				}catch(NumberFormatException en){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị hợp lệ");
				}
			}
        });
		tab3.add(btnSuaPN);
		//BUTTON XOA
		btnXoaPN = new JButton("Xóa");
		btnXoaPN.setBounds(1030, y, 100, 30);
		btnXoaPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickXoaPN();
			}
        });
		tab3.add(btnXoaPN);


		/* FORM CHI TIET PHIEU NHAP */
		/* TITLE CHI TIET PHIEU NHAP */
		JLabel titleCTPN = new JLabel("CHi TIẾT PHIẾU NHẬP");
		titleCTPN.setForeground(Color.BLUE);
		titleCTPN.setBounds(360, 300, 800, 50);
		tab3.add(titleCTPN);
		/* MA CT PHIEU NHAP */
		int y3 = 360;
		lblMaCTPN = new JLabel("Mã CTPN: ");
		txtMaCTPN = new JTextField();
		txtMaCTPN.setEditable(false);
		lblMaCTPN.setBounds(810, y3, 150, 30);
		txtMaCTPN.setBounds(900, y3, 200, 30);
		tab3.add(lblMaCTPN);
		tab3.add(txtMaCTPN);

		/* MA PHIEU NHAP */
		y3+=40;
		lblMaPhieuNhap2 = new JLabel("Mã phiếu nhập: ");
		txtMaPhieuNhap2 = new JTextField();
		lblMaPhieuNhap2.setBounds(810, y3, 150, 30);
		txtMaPhieuNhap2.setBounds(900, y3, 200, 30);
		tab3.add(lblMaPhieuNhap2);
		tab3.add(txtMaPhieuNhap2);

		/* SAN PHAM */
		y3+=40;
		lblSanPham = new JLabel("Sản phẩm: ");
		String[] dataCBXSP = convertToSanPhamCbx(listSanPham);
		cbxlSanPhamModel = new DefaultComboBoxModel<>(dataCBXSP);
		cbxlSanPham = new JComboBox<>(cbxlSanPhamModel);
		lblSanPham.setBounds(810, y3, 150, 30);
		cbxlSanPham.setBounds(900, y3, 200, 30);
		tab3.add(lblSanPham);
		tab3.add(cbxlSanPham);

		/* SO LUONG */
		y3+=40;
		lblSoLuong = new JLabel("Số lượng: ");
		txtSoLuong = new JTextField();
		lblSoLuong.setBounds(810, y3, 150, 30);
		txtSoLuong.setBounds(900, y3, 200, 30);
		tab3.add(lblSoLuong);
		tab3.add(txtSoLuong);

		/* TONG TIEN */
		y3+=40;
		lblTongTien2 = new JLabel("Tổng tiền: ");
		txtTongTien2 = new JTextField();
		lblTongTien2.setBounds(810, y3, 150, 30);
		txtTongTien2.setBounds(900, y3, 200, 30);
		tab3.add(lblTongTien2);
		tab3.add(txtTongTien2);

		/* Button Them Xoa Sua */
		y3+=40;
		//BUTTON THEM
		btnThemCTPN = new JButton("Thêm");
		btnThemCTPN.setBounds(810, y3, 100, 30);
		btnThemCTPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickThemCTPN();
			}
        });
		tab3.add(btnThemCTPN);
		//BUTTON SUA
		btnSuaCTPN = new JButton("Sửa");
		btnSuaCTPN.setBounds(920, y3, 100, 30);
		btnSuaCTPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickSuaCTPN();
			}
        });
		tab3.add(btnSuaCTPN);
		//BUTTON XOA
		btnXoaCTPN = new JButton("Xóa");
		btnXoaCTPN.setBounds(1030, y3, 100, 30);
		btnXoaCTPN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickXoaCTPN();
			}
        });
		tab3.add(btnXoaCTPN);
	}
	private void initLayoutTab1() {
		/* TITLE SAN PHAM */
		JLabel titleSanPham = new JLabel("SẢN PHẨM");
		titleSanPham.setForeground(Color.BLUE);
		titleSanPham.setBounds(360, 0, 800, 50);
		tab1.add(titleSanPham);

		/* TABLE SAN PHAM */
		listSanPham = sanPhamDAO.getAllSanPham();
		Object[][] data = convertToTableData(listSanPham);
		tableModel = new DefaultTableModel(data, columnSanPham);
		table = new JTable(tableModel);
		selectionTableModel = table.getSelectionModel();
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 50, 800, 400);
		selectionTableModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ chọn một hàng tại một thời điểm
        selectionTableModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				rowTableSelected = row;
				if (!e.getValueIsAdjusting() && row != -1) { // Đảm bảo rằng sự kiện chỉ được bắt một lần
					txtMaSanPham.setText(tableModel.getValueAt(row, 1).toString());
					txtTenSanPham.setText(tableModel.getValueAt(row, 2).toString());
					for(int i = 0; i < cbxlLoaiSanPhamModel.getSize(); i++){
						String str = cbxlLoaiSanPhamModel.getElementAt(i).toString();
						if(tableModel.getValueAt(row, 3).toString().equalsIgnoreCase(str))
						{
							cbxlLoaiSanPhamModel.setSelectedItem(cbxlLoaiSanPhamModel.getElementAt(i));
							break;
						}
					}
					txtGiaNhap.setText(tableModel.getValueAt(row, 4).toString());
					txtGiaBan.setText(tableModel.getValueAt(row, 5).toString());
					for(int i = 0; i < cbxlNhaSanXuatModel.getSize(); i++){
						String str = cbxlNhaSanXuatModel.getElementAt(i).toString();
						if(tableModel.getValueAt(row, 6).toString().equalsIgnoreCase(str))
						{
							cbxlNhaSanXuatModel.setSelectedItem(cbxlNhaSanXuatModel.getElementAt(i));
							break;
						}
					}
					txtTonKho.setText(tableModel.getValueAt(row, 7).toString());
                }
			}
		}); 
		tab1.add(jScrollPane);

		/* FORM SAN PHAM */
		//MA SAN PHAM
		int y = 470;
		lblMaSanPham = new JLabel("Mã sản phâm: ");
		txtMaSanPham = new JTextField();
		txtMaSanPham.setEditable(false);
		lblMaSanPham.setBounds(10, y, 150, 30);
		txtMaSanPham.setBounds(120, y, 200, 30);
		tab1.add(lblMaSanPham);
		tab1.add(txtMaSanPham);
		//TEN SAN PHAM
		y+=40;
		lblTenSanPham = new JLabel("Tên sản phâm: ");
		txtTenSanPham = new JTextField();
		lblTenSanPham.setBounds(10, y, 150, 30);
		txtTenSanPham.setBounds(120, y, 200, 30);
		tab1.add(lblTenSanPham);
		tab1.add(txtTenSanPham);
		//LOAI SAN PHAM
		y+=40;
		lblLoaiSanPham = new JLabel("Loại sản phâm: ");
		listLoaiSanPham = loaiSanPhamDAO.getAllLoaiSanPham();
		String[] columnLSP = convertToLoaiSPCbx(listLoaiSanPham);
		cbxlLoaiSanPhamModel = new DefaultComboBoxModel<>(columnLSP);
		cbxlLoaiSanPham = new JComboBox<>(cbxlLoaiSanPhamModel);
		lblLoaiSanPham.setBounds(10, y, 150, 30);
		cbxlLoaiSanPham.setBounds(120, y, 200, 30);
		tab1.add(lblLoaiSanPham);
		tab1.add(cbxlLoaiSanPham);
		//NHA SAN XUAT
		y+=40;
		lblNhaSanXuat = new JLabel("Nhà sản xuất: ");
		listNhaSanXuat = nhaSanXuatDAO.getAllNhaSanXuat();
		String[] columnNSX = convertToNhaSXCbx(listNhaSanXuat);
		cbxlNhaSanXuatModel = new DefaultComboBoxModel<>(columnNSX);
		cbxlNhaSanXuat = new JComboBox<>(cbxlNhaSanXuatModel);
		lblNhaSanXuat.setBounds(10, y, 150, 30);
		cbxlNhaSanXuat.setBounds(120, y, 200, 30);
		tab1.add(lblNhaSanXuat);
		tab1.add(cbxlNhaSanXuat);
		//GIA NHAP
		int y2=470;
		lblGiaNhap = new JLabel("Giá nhập: ");
		txtGiaNhap = new JTextField();
		lblGiaNhap.setBounds(360, y2, 150, 30);
		txtGiaNhap.setBounds(470, y2, 200, 30);
		tab1.add(lblGiaNhap);
		tab1.add(txtGiaNhap);
		//GIA BAN
		y2+=40;
		lblGiaBan = new JLabel("Giá bán: ");
		txtGiaBan = new JTextField();
		lblGiaBan.setBounds(360, y2, 150, 30);
		txtGiaBan.setBounds(470, y2, 200, 30);
		tab1.add(lblGiaBan);
		tab1.add(txtGiaBan);
		//SO LUONG TON
		y2+=40;
		lblTonKho = new JLabel("Tồn kho: ");
		txtTonKho = new JTextField();
		lblTonKho.setBounds(360, y2, 150, 30);
		txtTonKho.setBounds(470, y2, 200, 30);
		tab1.add(lblTonKho);
		tab1.add(txtTonKho);
		//BUTTON THEM
		y2+=40;
		btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(360, y, 100, 30);
		btnThemSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					eventClickThem();
				}catch(NumberFormatException en){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị hợp lệ");
				}
			}
        });
		tab1.add(btnThemSP);
		//BUTTON SUA
		btnSuaSP = new JButton("Sửa");
		btnSuaSP.setBounds(470, y, 100, 30);
		btnSuaSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					eventClickSua();
				}catch(NumberFormatException en){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập giá trị hợp lệ");
				}
			}
        });
		tab1.add(btnSuaSP);
		//BUTTON XOA
		btnXoaSP = new JButton("Xóa");
		btnXoaSP.setBounds(580, y, 100, 30);
		btnXoaSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickXoa();
			}
        });
		tab1.add(btnXoaSP);
	}

	private void initLayoutTab2() {
		/* TITLE LOAI SAN PHAM */
		JLabel titleLoaiSP = new JLabel("LOẠI SẢN PHẨM");
		titleLoaiSP.setForeground(Color.BLUE);
		titleLoaiSP.setBounds(240, 0, 600, 50);
		tab2.add(titleLoaiSP);
		/* TABLE LOAI SAN PHAM */
		Object[][] data = convertToLoaiSPTable(listLoaiSanPham);
		tableModelLoaiSP = new DefaultTableModel(data, columnLoaiSanPham);
		tableLoaiSP = new JTable(tableModelLoaiSP);
		selectionTableModelLoaiSP = tableLoaiSP.getSelectionModel();
		JScrollPane jScrollPane = new JScrollPane(tableLoaiSP);
		jScrollPane.setBounds(0, 50, 600, 150);
		selectionTableModelLoaiSP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ chọn một hàng tại một thời điểm
		selectionTableModelLoaiSP.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = tableLoaiSP.getSelectedRow();
				rowTableSelected = row;
				if (!e.getValueIsAdjusting() && row != -1) {
					tableModelSP_2.setRowCount(0);
					ArrayList<ItemSanPham> listByLoaiSP = new ArrayList<>();
					LoaiSanPham selectedLoaiSP = listLoaiSanPham.get(row);
					txtMaLoaiSP.setText(selectedLoaiSP.getMaLoaiSP()+"");
					txtTenLoaiSP.setText(selectedLoaiSP.getTenLoaiSP()+"");
					int stt = 0;
					for( int i = 0 ; i < listSanPham.size(); i++){ 
						ItemSanPham sp = listSanPham.get(i);
						if(sp.getTenLoaiSanPham().equalsIgnoreCase(selectedLoaiSP.getTenLoaiSP())){
							listByLoaiSP.add(sp);
							Object[] newRow = convertToTableDataItemSP_2(sp,stt);
							tableModelSP_2.addRow(newRow);
							stt++;
						}
					}
				}
			}
		});
		tab2.add(jScrollPane);

		int y2 = 200;
		/* TITLE SAN PHAM THEO LOAI */
		JLabel titleSPTheoLoai = new JLabel("SẢN PHẨM THEO LOẠI");
		titleSPTheoLoai.setForeground(Color.BLUE);
		titleSPTheoLoai.setBounds(240, y2, 600, 50);
		tab2.add(titleSPTheoLoai);
		/* TABLE SAN PHAM 2*/
		y2+=50;
		ArrayList<ItemSanPham> listByLoaiSP = new ArrayList<>();
		LoaiSanPham selectedLoaiSP = listLoaiSanPham.get(0);
		for(ItemSanPham sp : listSanPham){
			if(sp.getTenLoaiSanPham().equalsIgnoreCase(selectedLoaiSP.getTenLoaiSP())){
				listByLoaiSP.add(sp);
			}
		}
		Object[][] data_sp = convertToTableDataSP_2(listByLoaiSP);
		tableModelSP_2 = new DefaultTableModel(data_sp, columnSP_2);
		tableSP_2 = new JTable(tableModelSP_2);
		selectionTableModelLoaiSP = tableSP_2.getSelectionModel();
		JScrollPane jScrollPaneSP_2 = new JScrollPane(tableSP_2);
		jScrollPaneSP_2.setBounds(0, y2, 600, 300);
		selectionTableModelLoaiSP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chỉ chọn một hàng tại một thời điểm
		tab2.add(jScrollPaneSP_2);

		/* MÃ LOẠI SP */
		int y = 60;
		lblMaLoaiSP = new JLabel("Mã loại SP: ");
		txtMaLoaiSP = new JTextField();
		txtMaLoaiSP.setEditable(false);
		lblMaLoaiSP.setBounds(630, y, 100, 30);
		txtMaLoaiSP.setBounds(720, y, 200, 30);
		tab2.add(lblMaLoaiSP);
		tab2.add(txtMaLoaiSP);

		/* TÊN LOẠI SP */
		y+=40;
		lblTenLoaiSP = new JLabel("Tên loại SP: ");
		txtTenLoaiSP = new JTextField();
		lblTenLoaiSP.setBounds(630, y, 100, 30);
		txtTenLoaiSP.setBounds(720, y, 200, 30);
		tab2.add(lblTenLoaiSP);
		tab2.add(txtTenLoaiSP);

		//BUTTON THEM
		y+=40;
		btnThemLSP = new JButton("Thêm");
		btnThemLSP.setBounds(610, y, 100, 30);
		btnThemLSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickThemLSP();
			}
        });
		tab2.add(btnThemLSP);
		//BUTTON SUA
		btnSuaLSP = new JButton("Sửa");
		btnSuaLSP.setBounds(720, y, 100, 30);
		btnSuaLSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickSuaLSP();
			}
        });
		tab2.add(btnSuaLSP);
		//BUTTON XOA
		btnXoaLSP = new JButton("Xóa");
		btnXoaLSP.setBounds(830, y, 100, 30);
		btnXoaLSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickXoaLSP();
			}
        });
		tab2.add(btnXoaLSP);

		//BUTTON XOA
		JButton btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setBounds(610, y+115, 150, 30);
		btnXoaSP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventClickXoaSP2();
			}
        });
		tab2.add(btnXoaSP);
	}

	private Object[] convertToTableDataItem(ItemSanPham item,int i){
        Object[] data = new Object[8];
            data[0] = i+1;
            data[1] = item.getMaSanPham();
            data[2] = item.getTenSanPham();
            data[3] = item.getTenLoaiSanPham();
            data[4] = item.getGiaNhap();
            data[5] = item.getGiaBan();
            data[6] = item.getTenNhaSanXuat();
            data[7] = item.getSoLuongTon();
        return data;
    }
	private Object[][] convertToTableData(ArrayList<ItemSanPham> arrayList){
        Object[][] data = new Object[arrayList.size()][8];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = i+1;
            data[i][1] = arrayList.get(i).getMaSanPham();
            data[i][2] = arrayList.get(i).getTenSanPham();
            data[i][3] = arrayList.get(i).getTenLoaiSanPham();
            data[i][4] = arrayList.get(i).getGiaNhap();
            data[i][5] = arrayList.get(i).getGiaBan();
            data[i][6] = arrayList.get(i).getTenNhaSanXuat();
            data[i][7] = arrayList.get(i).getSoLuongTon();
        }
        return data;
    }
	private Object[][] convertToTableDataSP_2(ArrayList<ItemSanPham> arrayList){
        Object[][] data = new Object[arrayList.size()][8];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = i+1;
            data[i][1] = arrayList.get(i).getMaSanPham();
            data[i][2] = arrayList.get(i).getTenSanPham();
            data[i][3] = arrayList.get(i).getTenLoaiSanPham();
        }
        return data;
    }
	private Object[] convertToTableDataItemCTPN(ItemCTPN item,int i){
        Object[] data = new Object[8];
		data[0] = i+1;
		data[1] = item.getMaCTPN();
		data[2] = item.getMaPhieuNhap();
		data[3] = item.getTenSanPham();
		data[4] = item.getSoLuong();
		data[5] = item.getTongTien();
        return data;
    }
	private Object[] convertToTableDataItemSP_2(ItemSanPham item,int i){
        Object[] data = new Object[8];
		data[0] = i+1;
		data[1] = item.getMaSanPham();
		data[2] = item.getTenSanPham();
		data[3] = item.getTenLoaiSanPham();
        return data;
    }
	private Object[][] convertToCTPhieuNhapTable(ArrayList<ItemCTPN> arrayList){
		//private String[] columnCTPhieuNhap = {"STT","Mã CTPN","Mã phiếu nhập","Sản phẩm","Số lượng","Tổng tiền"};
        Object[][] data = new Object[arrayList.size()][6];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = i+1;
            data[i][1] = arrayList.get(i).getMaCTPN();
            data[i][2] = arrayList.get(i).getMaPhieuNhap();
            data[i][3] = arrayList.get(i).getTenSanPham();
            data[i][4] = arrayList.get(i).getSoLuong();
            data[i][5] = arrayList.get(i).getTongTien();
        }
        return data;
    }
	private Object[][] convertToPhieuNhapTable(ArrayList<ItemPhieuNhap> arrayList){
		//private String[] columnPhieuNhap = {"STT","Mã phiếu","Nhân viên","Nhà phân phối","Tổng tiền","Ngày nhập"};
        Object[][] data = new Object[arrayList.size()][6];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = i+1;
            data[i][1] = arrayList.get(i).getMaPhieuNhap();
            data[i][2] = arrayList.get(i).getTenNhanVien();
            data[i][3] = arrayList.get(i).getTenNhaCungCap();
            data[i][4] = arrayList.get(i).getTongTien();
            data[i][5] = arrayList.get(i).getNgayNhap();
        }
        return data;
    }
	private Object[][] convertToLoaiSPTable(ArrayList<LoaiSanPham> arrayList){
        Object[][] data = new Object[arrayList.size()][3];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = i+1;
            data[i][1] = arrayList.get(i).getMaLoaiSP();
            data[i][2] = arrayList.get(i).getTenLoaiSP();
        }
        return data;
    }
	private String[] convertToNhaCungCapCbx(ArrayList<NhaCungCap> arrayList){
        String[] data = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i] = arrayList.get(i).getTenNhaCungCap();
        }
        return data;
    }
	private String[] convertToNhanVienCbx(ArrayList<NhanVien> arrayList){
        String[] data = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i] = arrayList.get(i).getTenNhanVien();
        }
        return data;
    }
	private String[] convertToSanPhamCbx(ArrayList<ItemSanPham> arrayList){
        String[] data = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i] = arrayList.get(i).getTenSanPham();
        }
        return data;
    }
	private String[] convertToLoaiSPCbx(ArrayList<LoaiSanPham> arrayList){
        String[] data = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i] = arrayList.get(i).getTenLoaiSP();
        }
        return data;
    }
	private String[] convertToNhaSXCbx(ArrayList<NhaSanXuat> arrayList){
        String[] data = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i] = arrayList.get(i).getTenNSX();
        }
        return data;
    }
	private void resetCBXLoaiSP(){
		cbxlLoaiSanPhamModel.removeAllElements();
		for(LoaiSanPham item : listLoaiSanPham){
			cbxlLoaiSanPhamModel.addElement(item.getTenLoaiSP());
		}
	}
	private void resetCBXSanPham(){
		cbxlSanPhamModel.removeAllElements();
		for(ItemSanPham item : listSanPham){
			cbxlSanPhamModel.addElement(item.getTenSanPham());
		}
	}
	private void eventClickThemLSP(){
	 	String tenLoaiSP = txtTenLoaiSP.getText().toString().trim();
		if(tenLoaiSP==null || tenLoaiSP.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại sản phẩm");
			return;
		}
		int result = loaiSanPhamDAO.insertLoaiSanPham(tenLoaiSP);
		if(result>0){
			int count = tableModelLoaiSP.getRowCount();
			Object[] newRow = {count+1, result,tenLoaiSP};
			tableModelLoaiSP.addRow(newRow);
			txtTenLoaiSP.setText("");
			LoaiSanPham newLoaiSanPham = new LoaiSanPham(result, tenLoaiSP);
			listLoaiSanPham.add(newLoaiSanPham);
			resetCBXLoaiSP();
			JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thành công: "+tenLoaiSP);
		}else{
			JOptionPane.showMessageDialog(null, "Thêm loại sản phẩm thất bại: "+tenLoaiSP);
		}
	}
	private void eventClickThemPN(){
		int maPhieuNhap = Integer.parseInt(txtMaPhieuNhap.getText().toString().trim());
		int maNhanVien = 0;
		int maNhaCungCap = 0;
		long tongTien = Long.parseLong(txtTongTien.getText().toString().trim());
		String ngayNhap = txtNgayNhap.getText().toString().trim();
		for(NhanVien item : listNhanVien){
			if(item.getTenNhanVien().equalsIgnoreCase(cbxlNhanVien.getSelectedItem().toString())){
				maNhanVien=item.getMaNhanVien();
				break;
			}
		}
		for(NhaCungCap item : listNCC){
			if(item.getTenNhaCungCap().equalsIgnoreCase(cbxlNhaCungCap.getSelectedItem().toString())){
				maNhaCungCap=item.getMaNhaCungCap();
				break;
			}
		}
		int result = phieuNhapDAO.insertPhieuNhap(maNhanVien, maNhaCungCap, tongTien, ngayNhap);
		if(result>0){
		   int count = tableModelPhieuNhap.getRowCount();
		   Object[] newRow = {count+1, result, cbxlNhanVien.getSelectedItem().toString(), cbxlNhaCungCap.getSelectedItem().toString(), tongTien+"",ngayNhap};
		   tableModelPhieuNhap.addRow(newRow);
		   txtMaPhieuNhap.setText("");
		   txtNgayNhap.setText("");
		   txtTongTien.setText("");
		   ItemPhieuNhap p = new ItemPhieuNhap();
		   p.setMaPhieuNhap(result);
		   p.setNgayNhap(ngayNhap);
		   p.setTenNhaCungCap(cbxlNhaCungCap.getSelectedItem().toString());
		   p.setTenNhanVien( cbxlNhanVien.getSelectedItem().toString());
		   p.setTongTien(tongTien);
		   listPhieuNhap.add(p);
		   //INSERT A ROW
		   JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công: "+maPhieuNhap);
	   }else{
			if(result==-2){
				JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ: "+ngayNhap);
			}else{
				JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thất bại: "+maPhieuNhap);
			}
	   }
   }
   	private void eventClickThemCTPN(){
		String maCTPN = txtMaCTPN.getText().toString().trim();
		int maPhieuNhap = Integer.parseInt(txtMaPhieuNhap2.getText().toString().trim());
		int maSanPham = 0 ;
		for(ItemSanPham item : listSanPham){
			if(item.getTenSanPham().equalsIgnoreCase(cbxlSanPham.getSelectedItem().toString())){
				maSanPham=item.getMaSanPham();
			}
		}
		int soLuong = Integer.parseInt(txtSoLuong.getText().toString());
		long tongTien = Long.parseLong(txtTongTien2.getText().toString());

		int result = ctphieuNhapDAO.insertCTPhieuNhap(maPhieuNhap,maSanPham,soLuong,tongTien);
		if(result>0){
			int count = tableModelCTPhieuNhap.getRowCount();
			Object[] newRow = {count+1, result,maPhieuNhap, cbxlSanPham.getSelectedItem().toString(), soLuong, tongTien};
			tableModelCTPhieuNhap.addRow(newRow);
			txtMaCTPN.setText("");
			txtMaPhieuNhap2.setText("");
			txtSoLuong.setText("");
			txtTongTien2.setText("");
			listCTPN = ctphieuNhapDAO.getAllCTPhieuNhap();
			//INSERT A ROW
			JOptionPane.showMessageDialog(null, "Thêm CTPN thành công: "+result);
		}else{
			JOptionPane.showMessageDialog(null, "Thêm CTPN thất bại: "+result);
		}
	}
	private void eventClickThem(){
	 	String tenSanPham = txtTenSanPham.getText().toString().trim();
	 	int indexLSP = cbxlLoaiSanPham.getSelectedIndex();
		String giaNhap = txtGiaNhap.getText().toString().trim();
		String giaBan = txtGiaBan.getText().toString().trim();
		int indexNSX = cbxlNhaSanXuat.getSelectedIndex();
		String tonKho = txtTonKho.getText().toString().trim();
		int result = sanPhamDAO.insertSanPham(tenSanPham, (indexLSP+1)+"", Integer.parseInt(giaNhap), Integer.parseInt(giaBan), (indexNSX+1)+"", Integer.parseInt(tonKho));
		if(result>0){
			int count = tableModel.getRowCount();
			Object[] newRow = {count+1, result,tenSanPham, cbxlLoaiSanPham.getSelectedItem().toString(), giaNhap, giaBan, cbxlNhaSanXuat.getSelectedItem().toString(), tonKho};
			tableModel.addRow(newRow);
			txtTenSanPham.setText("");
			txtGiaNhap.setText("");
			txtGiaBan.setText("");
			txtTonKho.setText("");
			listSanPham = sanPhamDAO.getAllSanPham();
			resetCBXSanPham();
			//INSERT A ROW
			JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công: "+tenSanPham);
		}else{
			JOptionPane.showMessageDialog(null, "Thêm sản phẩm thất bại: "+tenSanPham);
		}
	}
	private void eventClickSuaCTPN(){
		if (tableCTPhieuNhap.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn CTPN muốn sửa");
			return;
		}
		int maCTPN = Integer.parseInt(txtMaCTPN.getText().toString().trim());
		int maPhieuNhap = Integer.parseInt(txtMaPhieuNhap2.getText().toString().trim());
		int maSanPham = 0 ;
		for(ItemSanPham item : listSanPham){
			if(item.getTenSanPham().equalsIgnoreCase(cbxlSanPham.getSelectedItem().toString())){
				maSanPham=item.getMaSanPham();
			}
		}
		int soLuong = Integer.parseInt(txtSoLuong.getText().toString());
		long tongTien = Long.parseLong(txtTongTien2.getText().toString());

		boolean result = ctphieuNhapDAO.updateCTPhieuNhap(maCTPN,maPhieuNhap,maSanPham,soLuong,tongTien);
		if(result){
			tableModelCTPhieuNhap.setValueAt(maPhieuNhap,rowTableSelected,2);
			tableModelCTPhieuNhap.setValueAt(cbxlSanPham.getSelectedItem().toString(),rowTableSelected,3);
			tableModelCTPhieuNhap.setValueAt(soLuong,rowTableSelected,4);
			tableModelCTPhieuNhap.setValueAt(tongTien,rowTableSelected,5);
			txtMaCTPN.setText("");
			txtMaPhieuNhap2.setText("");
			txtSoLuong.setText("");
			txtTongTien2.setText("");
			listCTPN = ctphieuNhapDAO.getAllCTPhieuNhap();
			//INSERT A ROW
			JOptionPane.showMessageDialog(null, "Sửa CTPN thành công: "+result);
		}else{
			JOptionPane.showMessageDialog(null, "Sửa CTPN thất bại: "+result);
		}
	}
	private void eventClickSuaPN(){
		if (tablePhieuNhap.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu muốn sửa");
			return;
		}
		int maPhieuNhap = Integer.parseInt(txtMaPhieuNhap.getText().toString().trim());
		int maNhanVien = 0;
		int maNhaCungCap = 0;
		long tongTien = Long.parseLong(txtTongTien.getText().toString().trim());
		String ngayNhap = txtNgayNhap.getText().toString().trim();
		for(NhanVien item : listNhanVien){
			if(item.getTenNhanVien().equalsIgnoreCase(cbxlNhanVien.getSelectedItem().toString())){
				maNhanVien=item.getMaNhanVien();
				break;
			}
		}
		for(NhaCungCap item : listNCC){
			if(item.getTenNhaCungCap().equalsIgnoreCase(cbxlNhaCungCap.getSelectedItem().toString())){
				maNhaCungCap=item.getMaNhaCungCap();
				break;
			}
		}
		boolean result = phieuNhapDAO.updatePhieuNhap(maPhieuNhap,maNhanVien, maNhaCungCap, tongTien, ngayNhap);
		if(result==true){
			tableModelPhieuNhap.setValueAt(cbxlNhanVien.getSelectedItem().toString(),rowTableSelected,2);
			tableModelPhieuNhap.setValueAt(cbxlNhaCungCap.getSelectedItem().toString(),rowTableSelected,3);
			tableModelPhieuNhap.setValueAt(tongTien,rowTableSelected,4);
			tableModelPhieuNhap.setValueAt(ngayNhap,rowTableSelected,5);
			txtMaPhieuNhap.setText("");
			txtNgayNhap.setText("");
			txtTongTien.setText("");
			listPhieuNhap = phieuNhapDAO.getAllPhieuNhap();
			//INSERT A ROW
			JOptionPane.showMessageDialog(null, "Sửa phiếu nhập thành công: "+maPhieuNhap);
	   }else{
		   	JOptionPane.showMessageDialog(null, "Sửa phiếu nhập thất bại: "+maPhieuNhap);
	   }
   }
	private void eventClickSua(){
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn sửa");
			return;
		}
		String maSanPham = txtMaSanPham.getText().toString().trim();
	 	String tenSanPham = txtTenSanPham.getText().toString().trim();
	 	String tenLoaiSP = cbxlLoaiSanPham.getSelectedItem().toString();
		String giaNhap = txtGiaNhap.getText().toString().trim();
		String giaBan = txtGiaBan.getText().toString().trim();
		String tenNSX = cbxlNhaSanXuat.getSelectedItem().toString();
		String tonKho = txtTonKho.getText().toString().trim();
		int maLoaiSP = 0;
		int maNSX = 0;
		for(LoaiSanPham item : listLoaiSanPham){
			if(item.getTenLoaiSP().equalsIgnoreCase(tenLoaiSP)){
				maLoaiSP = item.getMaLoaiSP();
				break;
			}
		}
		for(NhaSanXuat item : listNhaSanXuat){
			if(item.getTenNSX().equalsIgnoreCase(tenNSX)){
				maNSX = item.getMaNSX();
				break;
			}
		}
		boolean result = sanPhamDAO.updateSanPham(Integer.parseInt(maSanPham),tenSanPham, maLoaiSP+"", Integer.parseInt(giaNhap), Integer.parseInt(giaBan), maNSX+"", Integer.parseInt(tonKho));
		if(result){
			tableModel.setValueAt(txtTenSanPham.getText().toString(),rowTableSelected,2);
			tableModel.setValueAt(cbxlLoaiSanPham.getSelectedItem().toString(),rowTableSelected,3);
			tableModel.setValueAt(txtGiaNhap.getText().toString(),rowTableSelected,4);
			tableModel.setValueAt(txtGiaBan.getText().toString(),rowTableSelected,5);
			tableModel.setValueAt(cbxlNhaSanXuat.getSelectedItem().toString(),rowTableSelected,6);
			tableModel.setValueAt(txtTonKho.getText().toString(),rowTableSelected,7);
			txtMaSanPham.setText("");
			txtTenSanPham.setText("");
			txtGiaNhap.setText("");
			txtGiaBan.setText("");
			txtTonKho.setText("");
			listSanPham = sanPhamDAO.getAllSanPham();
			resetCBXSanPham();
			JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công: "+tenSanPham);
		}else{
			JOptionPane.showMessageDialog(null, "Sửa sản phẩm thất bại: "+tenSanPham);
		}
		
	}
	private void eventClickSuaLSP(){
		if (tableLoaiSP.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm muốn sửa");
			return;
		}
		String maLoaiSP = txtMaLoaiSP.getText().toString().trim();
	 	String tenLoaiSP = txtTenLoaiSP.getText().toString().trim();
		boolean result = loaiSanPhamDAO.updateLoaiSanPham(Integer.parseInt(maLoaiSP),tenLoaiSP);
		if(result){
			tableLoaiSP.setValueAt(maLoaiSP,rowTableSelected,1);
			tableLoaiSP.setValueAt(tenLoaiSP,rowTableSelected,2);
			txtMaLoaiSP.setText("");
			txtTenLoaiSP.setText("");
			listLoaiSanPham = loaiSanPhamDAO.getAllLoaiSanPham();
			resetCBXLoaiSP();
			JOptionPane.showMessageDialog(null, "Sửa loại sản phẩm thành công: "+tenLoaiSP);
		}else{
			JOptionPane.showMessageDialog(null, "Sửa loại sản phẩm thất bại: "+tenLoaiSP);
		}
	}
	private void eventClickXoaPN(){
		if (tablePhieuNhap.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu nhập muốn xóa");
			return;
		}
		
		int maPhieuNhap = Integer.parseInt(txtMaPhieuNhap.getText().toString().trim());
		boolean result = phieuNhapDAO.deletePhieuNhap(maPhieuNhap);
		if(result){
			txtMaPhieuNhap.setText("");
			txtNgayNhap.setText("");
			txtTongTien.setText("");

			tableModelPhieuNhap.removeRow(rowTableSelected);

			JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thành công: "+maPhieuNhap);
		}else{
			JOptionPane.showMessageDialog(null, "Xóa phiếu nhập thất bại: "+maPhieuNhap);
		}
	}
	private void eventClickXoaSP2(){
		int row = tableSP_2.getSelectedRow();
		if (tableSP_2.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa");
			return;
		}
		String maSanPham = tableModelSP_2.getValueAt(row, 1).toString();
		for(ItemCTPN item : listCTPN){
			if(item.getMaSanPham()==Integer.parseInt(maSanPham)){
				JOptionPane.showMessageDialog(null, "Không thể xóa sản phẩm có trong phiếu nhập (Mã CTPN: "+item.getMaCTPN()+"): ");
				return;
			}
		}
		boolean result = sanPhamDAO.deleteSanPham(Integer.parseInt(maSanPham));
		if(result){
			tableModelSP_2.removeRow(row);

			listSanPham = sanPhamDAO.getAllSanPham();
			resetCBXSanPham();
			tableModel.setRowCount(0);
			int stt = 0;
			for(ItemSanPham item : listSanPham){
				tableModel.addRow(convertToTableDataItem(item,stt));
				stt++;
			}
			JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công: "+maSanPham);
		}else{
			JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại: "+maSanPham);
		}
	}
	private void eventClickXoa(){
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa");
			return;
		}
		String maSanPham = txtMaSanPham.getText().toString().trim();
		for(ItemCTPN item : listCTPN){
			if(item.getMaSanPham()==Integer.parseInt(maSanPham)){
				JOptionPane.showMessageDialog(null, "Không thể xóa sản phẩm có trong phiếu nhập (Mã CTPN: "+item.getMaCTPN()+"): ");
				return;
			}
		}
		
		String tenSanPham = txtTenSanPham.getText().toString().trim();
		boolean result = sanPhamDAO.deleteSanPham(Integer.parseInt(maSanPham));
		if(result){
			txtMaSanPham.setText("");
			txtTenSanPham.setText("");
			txtGiaNhap.setText("");
			txtGiaBan.setText("");
			txtTonKho.setText("");
			
			tableModel.removeRow(rowTableSelected);

			listSanPham = sanPhamDAO.getAllSanPham();
			resetCBXSanPham();
			JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công: "+tenSanPham);
		}else{
			JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại: "+tenSanPham);
		}
	}
	private void eventClickXoaLSP(){
		if (tableLoaiSP.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại sản phẩm muốn xóa");
			return;
		}
		String maLoaiSP = txtMaLoaiSP.getText().toString().trim();
		for(ItemSanPham item : listSanPham){
			if(item.getMaLoaiSanPham()==Integer.parseInt(maLoaiSP)){
				JOptionPane.showMessageDialog(null, "Không thể xóa loại sản phẩm đang có chứa sản phẩm.");
				return;
			}
		}
		boolean result = loaiSanPhamDAO.deleteLoaiSanPham(Integer.parseInt(maLoaiSP));
		if(result){
			txtMaLoaiSP.setText("");
			txtTenLoaiSP.setText("");
			tableModelLoaiSP.removeRow(rowTableSelected);
			listLoaiSanPham = loaiSanPhamDAO.getAllLoaiSanPham();
			resetCBXLoaiSP();
			JOptionPane.showMessageDialog(null, "Xóa loại sản phẩm thành công: "+maLoaiSP);
		}else{
			JOptionPane.showMessageDialog(null, "Xóa loại sản phẩm thất bại: "+maLoaiSP);
		}
	}
	private void eventClickXoaCTPN(){
		if (tableCTPhieuNhap.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn CTPN sản phẩm muốn xóa");
			return;
		}
		String maCTPN = txtMaCTPN.getText().toString().trim();
		boolean result = ctphieuNhapDAO.deleteCTPhieuNhap(Integer.parseInt(maCTPN));
		if(result){
			txtMaPhieuNhap.setText("");
			txtNgayNhap.setText("");
			txtTongTien.setText("");
			listCTPN = ctphieuNhapDAO.getAllCTPhieuNhap();
			tableModelCTPhieuNhap.removeRow(rowTableSelected);
			JOptionPane.showMessageDialog(null, "Xóa CTPN thành công: "+maCTPN);
		}else{
			JOptionPane.showMessageDialog(null, "Xóa CTPN thất bại: "+maCTPN);
		}
	}
	
}

		