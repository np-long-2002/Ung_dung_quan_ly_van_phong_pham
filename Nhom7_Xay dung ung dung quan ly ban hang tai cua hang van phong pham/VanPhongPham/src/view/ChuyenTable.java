package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DanhMucMain;

public class ChuyenTable {
	private JPanel root;
	private String kindSelected ="";
	private ArrayList<DanhMucMain> listItem = null;
	public ChuyenTable(JPanel jpnRoot) {
		super();
		this.root = jpnRoot;
	}
	public void setView(JPanel jpnItem,JLabel jlbItem) {
		kindSelected = "ThongKe";
		jpnItem.setBackground(new Color(96,100,191));
		jlbItem.setBackground(new Color(96,100,191));
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new ThongKeJPanel());
		root.validate();
		root.repaint();
	}
	public void setEvant(ArrayList<DanhMucMain> listItem) {
		this.listItem=listItem;
		for (DanhMucMain item : listItem) {
			item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}
	class LabelEvent implements MouseListener{
		private JPanel node;
		private String kind;
		private JPanel jpnItem;
		private JLabel jlbItem;
		
		public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			super();
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(kind) {
				case "ThongKe":
					node = new ThongKeJPanel();
					break;
				case "KhachHang":
					node = new KhachHangJPanel();
					break;
				case "HoaDon":
					node = new HoaDonJPanel();
					break;
				case "SanPham":
					node = new SanPhamJPanel();
					break;
				case "NhaCungCap":
					node = new NhaCungCapJPanel();
					break;
				case "NhanVien":
					node = new NhanVienJPanel();
					break;
				default:
					node = new HoaDonJPanel();
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(!kindSelected.equalsIgnoreCase(kind)){
				jpnItem.setBackground(new Color(128, 255, 0));
				jlbItem.setBackground(new Color(128, 255, 0));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			kindSelected = kind;
			jpnItem.setBackground(new Color(96,100,191));
			jlbItem.setBackground(new Color(96,100,191));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		private void setChangeBackground(String kind) {
			for (DanhMucMain item : listItem) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getJlb().setBackground(new Color(96,100,191));
					item.getJpn().setBackground(new Color(96,100,191));
				}else {
					item.getJlb().setBackground(new Color(128, 255, 0));
					item.getJpn().setBackground(new Color(128, 255, 0));
				}
			}
		}
	}
}
