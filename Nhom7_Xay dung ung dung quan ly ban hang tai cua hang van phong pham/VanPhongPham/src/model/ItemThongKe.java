package model;

public class ItemThongKe {
    private String tenSanPham;
    private int soLuongTon;
    private int soLuongBan;
    private long tongTien;

    public ItemThongKe() {
    }

    public ItemThongKe(String tenSanPham, int soLuongTon, int soLuongBan, long tongTien) {
        this.tenSanPham = tenSanPham;
        this.soLuongTon = soLuongTon;
        this.soLuongBan = soLuongBan;
        this.tongTien = tongTien;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
}
