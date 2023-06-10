Create database quanlyvanphongpham
go
use quanlyvanphongpham
go
SET DATEFORMAT DMY
go
create table NhanVien(
	MaNhanVien int IDENTITY (1,1),
	TenNhanVien nvarchar(50),
	GioiTinh nvarchar(10),
	NgayVaoLam date DEFAULT GETDATE(),
	SoDienThoai nvarchar(11),
	MaChucVu int,
	constraint pk_nv primary key(MaNhanVien),
)
go
create table NguoiDung(
	MaNguoiDung int IDENTITY (1,1),
	MaNhanVien int,
	TenDangNhap nvarchar(50),
	MatKhau nvarchar(50),
	MaQuyen int,
	constraint pk_nd primary key (MaNguoiDung),
)
go
create table Quyen(
	MaQuyen int IDENTITY (1,1),
	TenQuyen nvarchar(50),
	constraint pk_q primary key(MaQuyen)
)
go
create table ChucVu(
	MaChucVu int IDENTITY (1,1),
	TenChucVu nvarchar(50),
	constraint pk_cv primary key(MaChucVu)
)
go
create table KhachHang(
	MaKhachHang int IDENTITY (1,1),
	TenKhachHang nvarchar(50),
	GioiTinh nvarchar(10),
	SoDienThoai nvarchar(50),
	MaLoaiKH int,
	constraint pk_kh primary key (MaKhachHang)
)
go
create table LoaiKhachHang(
	MaLoaiKH int IDENTITY (1,1),
	TenLoaiKH nvarchar(50),
	constraint pk_lkh primary key (MaLoaiKH)
)
go
create table SanPham(
	MaSanPham int IDENTITY (1,1),
	TenSanPham nvarchar(50),
	MaLoaiSP int,
	MaNSX int,
	GiaNhap int,
	GiaBan int,
	SoLuong int,
	constraint pk_sp primary key(MaSanPham)
)
go
create table LoaiSanPham(
	MaLoaiSP int IDENTITY (1,1),
	TenLoaiSP nvarchar(50),
	constraint pk_lsp primary key(MaLoaiSP)
)
go
create table NhaSanXuat(
	MaNSX int IDENTITY (1,1),
	TenNSX nvarchar(50),
	constraint pk_nsx primary key(MaNSX)
)
go
create table HoaDon(
	MaHoaDon int IDENTITY (1,1),
	MaKhachHang int,
	MaNhanVien int,
	NgayLapHoaDon date DEFAULT GETDATE(),
	TongTien int DEFAULT 0,
	TrangThai nvarchar(50) DEFAULT N'Chưa Thanh Toán',
	constraint pk_hd primary key(MaHoaDon)
)
go
create table ChiTietHoaDon(
	MaChiTietHD int IDENTITY (1,1),
	MaHoaDon int,
	MaSanPham int,
	SoLuong int,
	TongTien int DEFAULT 0,
	constraint pk_cthd primary key(MaChiTietHD)
)
go
create table PhieuNhap(
	MaPhieuNhap int IDENTITY (1,1),
	MaNhanVien int,
	MaNhaCungCap int,
	TongTien int DEFAULT 0,
	NgayNhap date DEFAULT GETDATE(),
	constraint pk_pn primary key(MaPhieuNhap)
)
create table NhaCungCap(
	MaNhaCungCap int IDENTITY (1,1),
	TenNhaCungCap nvarchar(50),
	DiaChi nvarchar(50),
	SoDienThoai nvarchar(50),
	Email nvarchar(50),
	constraint pk_ncc primary key (MaNhaCungCap)
)
go
create table ChiTietPhieuNhap(
	MaCTPN int IDENTITY (1,1),
	MaPhieuNhap int,
	MaSanPham int,
	SoLuong int,
	TongTien int DEFAULT 0,
	constraint pk_ctpn primary key(MaCTPN) 
)
alter table NhanVien
add constraint fk_nv foreign key (MaChucVu) references ChucVu(MaChucVu)on delete cascade
go
alter table NguoiDung
add constraint fk_nd foreign key (MaQuyen) references Quyen(MaQuyen)on delete cascade
go
alter table NguoiDung
add constraint fk_nd1 foreign key (MaNhanVien) references NhanVien(MaNhanVien)on delete cascade
go
alter table KhachHang
add constraint fk_kh foreign key (MaLoaiKH) references LoaiKhachHang(MaLoaiKH)on delete cascade
go
alter table SanPham
add constraint fk_sp foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP)on delete cascade
go
alter table SanPham
add constraint fk_sp1 foreign key (MaNSX) references NhaSanXuat(MaNSX) on delete cascade
go
alter table ChiTietHoaDon
add constraint fk_cthd foreign key (MaHoaDon) references HoaDon(MaHoaDon) on delete cascade
go
alter table ChiTietHoaDon
add constraint fk_cthd1 foreign key (MaSanPham) references SanPham(MaSanPham) on delete cascade
go
alter table HoaDon
add constraint fk_hd foreign key (MaKhachHang) references KhachHang(MaKhachHang) on delete cascade
go
alter table HoaDon
add constraint fk_hd1 foreign key (MaNhanVien) references NhanVien(MaNhanVien) on delete cascade
go
alter table PhieuNhap
add constraint fk_pn foreign key (MaNhanVien) references NhanVien(MaNhanVien) on delete cascade
go
alter table PhieuNhap
add constraint fk_pn1 foreign key (MaNhaCungCap) references NhaCungCap(MaNhaCungCap) on delete cascade
go
alter table ChiTietPhieuNhap
add constraint fk_ctpn foreign key (MaPhieuNhap) references PhieuNhap(MaPhieuNhap) on delete cascade
go
alter table ChiTietPhieuNhap
add constraint fk_ctpn1 foreign key (MaSanPham) references SanPham(MaSanPham) on delete cascade
go

insert into Quyen(TenQuyen)
values(N'Admin')
insert into Quyen(TenQuyen)
values(N'user')

insert into ChucVu(TenChucVu)
values(N'Quản lý')
insert into ChucVu(TenChucVu)
values(N'Quản lý')

insert into NhaSanXuat(TenNSX)
values(N'Thiên Long')
insert into NhaSanXuat(TenNSX)
values(N'Khang Minh')

insert into LoaiSanPham(TenLoaiSP)
values(N'Dụng cụ học tập')
insert into LoaiSanPham(TenLoaiSP)
values(N'Tập sách')

insert into NhaCungCap(TenNhaCungCap,DiaChi,SoDienThoai,Email)
values(N'Hùng',N'15 Lê Thánh Tôn Hồ Chí Minh',05442211360,N'chuhung12@gmail.com')
insert into NhaCungCap(TenNhaCungCap,DiaChi,SoDienThoai,Email)
values(N'My',N'316 Tây Thạnh Hồ Chí Minh',03603605578,N'bemy2k11@gmail.com')

insert into LoaiKhachHang(TenLoaiKH)
values(N'Siêu cấp')
insert into LoaiKhachHang(TenLoaiKH)
values(N'Sơ cấp')

insert into NhanVien(TenNhanVien ,GioiTinh,SoDienThoai,MaChucVu)
values(N'Thu Thảo',N'Nữ',0458796524,1)
insert into NhanVien(TenNhanVien ,GioiTinh,SoDienThoai,MaChucVu)
values(N'Thảo Dang Yeu',N'Nam',0125798524,2)

insert into NguoiDung(MaNhanVien,TenDangNhap,MatKhau,MaQuyen)
values('1','thao','123',1)
insert into NguoiDung(MaNhanVien,TenDangNhap,MatKhau,MaQuyen)
values('2','thaodangyeu','234',2)

insert into KhachHang(TenKhachHang,GioiTinh ,SoDienThoai,MaLoaiKH)
values(N'Mèo Simmy',N'Nữ',0254789633,'1')
insert into KhachHang(TenKhachHang,GioiTinh ,SoDienThoai,MaLoaiKH)
values(N'Mai Kim Trí',N'Nam',0457888977,'2')

insert into SanPham(TenSanPham,MaLoaiSP,MaNSX,GiaNhap,GiaBan,SoLuong)
values(N'Bút chì kim','1','1',10000000,1000,100)
insert into SanPham(TenSanPham,MaLoaiSP,MaNSX,GiaNhap,GiaBan,SoLuong)
values(N'Sách Tiếng ziệt','2','2',40000000,4000,100)

insert into PhieuNhap(MaNhanVien,MaNhaCungCap)
values('1','1')
insert into PhieuNhap(MaNhanVien,MaNhaCungCap)
values('2','2')

insert into HoaDon(MaKhachHang,MaNhanVien,TongTien,TrangThai)
values('1','1',10000,N'Chưa Thanh Toán')
insert into HoaDon(MaKhachHang,MaNhanVien,TongTien,TrangThai)
values('2','2',1000,N'Đã Thanh Toán')

insert into ChiTietPhieuNhap(MaPhieuNhap,MaSanPham,SoLuong)
values('1','1','10')
insert into ChiTietPhieuNhap(MaPhieuNhap,MaSanPham,SoLuong)
values('2','2','10')
go
Create trigger tongTienCTHD on ChiTietHoaDon for insert ,update
as
begin
	DECLARE @tongtien int,@giaban int ,@soluong int;
	select @giaban = (Select GiaBan from SanPham,inserted where inserted.MaSanPham = SanPham.MaSanPham) 
	select @soluong = (Select inserted.SoLuong from inserted)
	Select @tongtien = @giaban * @soluong;
	Update ChiTietHoaDon 
	set TongTien = @tongtien
	from ChiTietHoaDon,inserted
	where ChiTietHoaDon.MaChiTietHD = inserted.MaChiTietHD
end
go
create trigger tongTienHD_1 on ChiTietHoaDon for delete
as
begin
	declare @tongtien int,@mahd int;
	select @mahd = (select deleted.MaHoaDon from deleted)
	select @tongtien = (select SUM(ChiTietHoaDon.TongTien) from deleted,ChiTietHoaDon where deleted.MaHoaDon = ChiTietHoaDon.MaHoaDon)
	update HoaDon
	set TongTien = @tongtien
	where HoaDon.MaHoaDon = @mahd
end
go
create trigger ttHD on ChiTietHoaDon for insert,update
as
begin
	declare @tongtien int,@mahd int;
	select @mahd = (select inserted.MaHoaDon from inserted)
	select @tongtien = (select SUM(ChiTietHoaDon.TongTien) from inserted,ChiTietHoaDon where inserted.MaHoaDon = ChiTietHoaDon.MaHoaDon)
	update HoaDon
	set TongTien = @tongtien
	where HoaDon.MaHoaDon = @mahd
end
go
create trigger spct on ChiTietHoaDon for insert
as
begin
	declare @slsp int , @slct int,@masp int,@slc int;
	select @masp = (select inserted.MaSanPham from inserted)
	select @slsp = (select SanPham.SoLuong from SanPham where SanPham.MaSanPham =@masp )
	select @slct = (select inserted.SoLuong from inserted)
	select @slc = @slsp -@slct
	if(@slc < 0)
		ROLLBACK TRANSACTION
	else
		begin
			update SanPham
			set SoLuong = @slc
			where SanPham.MaSanPham = @masp
		end
end
go
create trigger spct_delete on ChiTietHoaDon for delete
as
begin
	declare @slsp int , @slct int,@masp int,@slc int;
	select @masp = (select deleted.MaSanPham from deleted)
	select @slsp = (select SanPham.SoLuong from SanPham where SanPham.MaSanPham =@masp )
	select @slct = (select deleted.SoLuong from deleted)
	select @slc = @slsp +@slct
			update SanPham
			set SoLuong = @slc
			where SanPham.MaSanPham = @masp
end
go
