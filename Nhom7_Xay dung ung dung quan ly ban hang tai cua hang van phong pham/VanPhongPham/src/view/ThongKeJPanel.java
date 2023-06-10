package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import model.ItemThongKe;
import chart.ColumnChart;
import dao.HoaDonDAO;

public class ThongKeJPanel extends JPanel {
	private JPanel contentPane;
	private JPanel panelChart;
    private JTable tableItemThongKe;
    private DefaultTableModel tableItemThongKeModel;
    private HoaDonDAO hoaDonDao;
    private JComboBox<String> comboBox;
    private ColumnChart chart;
    String[] columns = {"Tên SP", "SL tổn", "SL bán","Tổng tiền"};
    private JTextField txtDoanhThuThang;
    private ArrayList<ItemThongKe> listItemThongKe = new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public ThongKeJPanel() {
		contentPane = this;
		
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);

        contentPane.setLayout(null);
        hoaDonDao = new HoaDonDAO();
        listItemThongKe.addAll(hoaDonDao.getListItemThongKeTheoThang(1));
        Object[][] data = convertToMang2Chieu(listItemThongKe);
        tableItemThongKeModel = new DefaultTableModel(data, columns);
        tableItemThongKe = new JTable(tableItemThongKeModel);
        JScrollPane scrollPane = new JScrollPane(tableItemThongKe); // Tạo JScrollPane và đưa JTable vào trong đó
        scrollPane.setBounds(10, 11, 354, 259); // Đặt kích thước cho JScrollPane
        contentPane.add(scrollPane); 


        JButton btnLamMoi = new JButton("Làm mới");
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Xóa các dòng của tableItemThongKe
		        tableItemThongKeModel.setRowCount(0);
		        // Lấy dữ liệu mới cho tableItemThongKe từ comboBox
		        String selectedMonth = (String)comboBox.getSelectedItem();
		        // Thực hiện các xử lý để lấy dữ liệu mới cho tableItemThongKe
		        listItemThongKe.clear();
		        listItemThongKe.addAll(hoaDonDao.getListItemThongKeTheoThang(Integer.parseInt(selectedMonth.split(" ")[1])));
		        Object[][] newData = convertToMang2Chieu(listItemThongKe);
		        tableItemThongKeModel = new DefaultTableModel(newData, columns);
		        tableItemThongKe.setModel(tableItemThongKeModel);
		        txtDoanhThuThang.setText(getTotalRevenue());
            }
        });
        btnLamMoi.setBounds(340, 349, 150, 23);
        contentPane.add(btnLamMoi);

//        JButton btnTroVe = new JButton("Trở về");
//        btnTroVe.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //this.dispose();
//            }
//        });
//        btnTroVe.setBounds(440, 349, 90, 23);
//        contentPane.add(btnTroVe);

        panelChart = new JPanel();
        panelChart.setBounds(374, 12, 526, 415);
        chart = new ColumnChart("Doanh thu theo tháng");
        panelChart.add(chart.getContentPane());
        contentPane.add(panelChart);


        txtDoanhThuThang = new JTextField();
        txtDoanhThuThang.setColumns(10);
        txtDoanhThuThang.setBounds(180, 309, 184, 20);
        txtDoanhThuThang.setEditable(false);
        txtDoanhThuThang.setText(getTotalRevenue());
        contentPane.add(txtDoanhThuThang);

        JLabel lblNewLabel_1_2_1 = new JLabel("Tổng doanh thu tháng: ");
        lblNewLabel_1_2_1.setBounds(10, 312, 143, 14);
        contentPane.add(lblNewLabel_1_2_1);

        String[] months = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
        comboBox = new JComboBox<String>(months);
        comboBox.setBounds(180, 281, 184, 20);
        comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Xóa các dòng của tableItemThongKe
		        tableItemThongKeModel.setRowCount(0);
		        // Lấy dữ liệu mới cho tableItemThongKe từ comboBox
		        String selectedMonth = (String)comboBox.getSelectedItem();
		        // Thực hiện các xử lý để lấy dữ liệu mới cho tableItemThongKe
		        listItemThongKe.clear();
		        listItemThongKe.addAll(hoaDonDao.getListItemThongKeTheoThang(Integer.parseInt(selectedMonth.split(" ")[1])));
		        Object[][] newData = convertToMang2Chieu(listItemThongKe);
		        tableItemThongKeModel = new DefaultTableModel(newData, columns);
		        tableItemThongKe.setModel(tableItemThongKeModel);
		        txtDoanhThuThang.setText(getTotalRevenue());
			}
        });
        contentPane.add(comboBox);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("Phạm vi thống kê: ");
        lblNewLabel_1_2_1_1.setBounds(10, 284, 113, 14);
        contentPane.add(lblNewLabel_1_2_1_1);
		JLabel lblNewLabel = new JLabel("Hi");
		add(lblNewLabel);

	}
	
	 private String getTotalRevenue() {
        long revenue = 0 ;
        for(ItemThongKe item : listItemThongKe){
            revenue+= item.getTongTien();
        }
        DecimalFormat df = new DecimalFormat("###,### VNĐ");
        return df.format(revenue).toString();
    }

    private Object[][] convertToMang2Chieu(ArrayList<ItemThongKe> arrayList){
        // Chuyển đổi ArrayList thành một mảng hai chiều
        Object[][] data = new Object[arrayList.size()][4];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i][0] = arrayList.get(i).getTenSanPham();
            data[i][1] = arrayList.get(i).getSoLuongTon();
            data[i][2] = arrayList.get(i).getSoLuongBan();
            data[i][3] = arrayList.get(i).getTongTien();
        }
        return data;
    }

}
