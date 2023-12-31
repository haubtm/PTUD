USE [master]
GO
/****** Object:  Database [QLBH]    Script Date: 10/27/2023 4:32:31 PM ******/
CREATE DATABASE [QLBH]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLBH', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QLBH.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLBH_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QLBH_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLBH] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLBH].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLBH] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLBH] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLBH] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLBH] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLBH] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLBH] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLBH] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLBH] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLBH] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLBH] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLBH] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLBH] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLBH] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLBH] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLBH] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLBH] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLBH] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLBH] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLBH] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLBH] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLBH] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLBH] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLBH] SET RECOVERY FULL 
GO
ALTER DATABASE [QLBH] SET  MULTI_USER 
GO
ALTER DATABASE [QLBH] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLBH] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLBH] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLBH] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLBH] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLBH] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLBH', N'ON'
GO
ALTER DATABASE [QLBH] SET QUERY_STORE = OFF
GO
USE [QLBH]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maSanPham] [nvarchar](50) NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[kichThuoc] [varchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuDat]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuDat](
	[maPhieuDat] [nvarchar](50) NOT NULL,
	[maSanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
	[giaDat] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietPhieuDat] PRIMARY KEY CLUSTERED 
(
	[maPhieuDat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[ngayLapHoaDon] [date] NOT NULL,
	[thue] [float] NOT NULL,
	[maKhachHang] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__HoaDon__026B4D9A5D14C680] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[ngaySinh] [date] NOT NULL,
	[diaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK__KhachHan__0CCB3D49B6E58C36] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[maLoaiSanPham] [nvarchar](50) NOT NULL,
	[tenLoaiSanPham] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiSanPham] PRIMARY KEY CLUSTERED 
(
	[maLoaiSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [nvarchar](50) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[canCuoc] [nvarchar](50) NULL,
	[soDienThoai] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[chucVu] [nvarchar](50) NULL,
	[hinhAnh] [nvarchar](50) NULL,
 CONSTRAINT [PK__NhanVien__BDDEF20D86BD8222] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDat]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDat](
	[maPhieuDat] [nvarchar](50) NOT NULL,
	[ngayDat] [date] NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
	[maKhachHang] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_PhieuDat] PRIMARY KEY CLUSTERED 
(
	[maPhieuDat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nvarchar](50) NOT NULL,
	[tenSanPham] [nvarchar](50) NULL,
	[giaNhap] [float] NULL,
	[giaBan] [float] NULL,
	[mauSac] [nvarchar](50) NULL,
	[xuatXu] [nvarchar](50) NULL,
	[moTa] [text] NULL,
	[hinhAnh] [nvarchar](50) NULL,
	[maLoaiSanPham] [nvarchar](50) NULL,
	[maNhaCungCap] [nvarchar](50) NULL,
 CONSTRAINT [PK__SanPham__5B439C43B6EE3492] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham_SizeS]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham_SizeS](
	[maSize] [nvarchar](50) NOT NULL,
	[maSanPham] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sizes]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sizes](
	[maSize] [nvarchar](50) NOT NULL,
	[tenSize] [nvarchar](50) NULL,
 CONSTRAINT [PK_Sizes] PRIMARY KEY CLUSTERED 
(
	[maSize] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/27/2023 4:32:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[maTaiKhoan] [nvarchar](50) NOT NULL,
	[taiKhoan] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[role] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon1] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[ChiTietPhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat] FOREIGN KEY([maPhieuDat])
REFERENCES [dbo].[PhieuDat] ([maPhieuDat])
GO
ALTER TABLE [dbo].[ChiTietPhieuDat] CHECK CONSTRAINT [FK_ChiTietPhieuDat_PhieuDat]
GO
ALTER TABLE [dbo].[ChiTietPhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuDat_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietPhieuDat] CHECK CONSTRAINT [FK_ChiTietPhieuDat_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDat_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
GO
ALTER TABLE [dbo].[PhieuDat] CHECK CONSTRAINT [FK_PhieuDat_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDat]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDat_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuDat] CHECK CONSTRAINT [FK_PhieuDat_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_LoaiSanPham] FOREIGN KEY([maLoaiSanPham])
REFERENCES [dbo].[LoaiSanPham] ([maLoaiSanPham])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_LoaiSanPham]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_NhaCungCap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_SanPham_NhaCungCap]
GO
ALTER TABLE [dbo].[SanPham_SizeS]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_SizeS_SanPham1] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[SanPham_SizeS] CHECK CONSTRAINT [FK_SanPham_SizeS_SanPham1]
GO
ALTER TABLE [dbo].[SanPham_SizeS]  WITH CHECK ADD  CONSTRAINT [FK_SanPham_SizeS_Sizes] FOREIGN KEY([maSize])
REFERENCES [dbo].[Sizes] ([maSize])
GO
ALTER TABLE [dbo].[SanPham_SizeS] CHECK CONSTRAINT [FK_SanPham_SizeS_Sizes]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QLBH] SET  READ_WRITE 
GO

INSERT INTO [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaNhap], [giaBan], [mauSac], [xuatXu], [moTa], [hinhAnh], [maLoaiSanPham], [maNhaCungCap])
VALUES
('SP001', N'Áo da', 600000.00, 700000.00, N'Đen', N'Việt Nam', N'Áo siêu cấp vip pro', N'.\\IMG\\avatar.png', 'LSP001', 'NCC001'),
('SP002', N'Áo Trắng', 200000.00, 300000.00, N'Trắng', N'Trung Quốc', N'Áo trắng chất lượng cao', N'.\\IMG\\ao trang.png', 'LSP001', 'NCC002'),
('SP003', N'Quần Vải Đen', 100000.00, 200000.00, N'Đen', N'Thái Lan', N'Quần Đen chất lượng cao', N'.\\IMG\\Quần Vải Đen.png', 'LSP002', 'NCC003'),
('SP004', N'Đồng Hồ Nam', 1000000.00, 1200000.00, N'Xanh', N'Hàn Quốc', N'Đồng Hồ Rolex', N'.\\IMG\\đồng hồ.png', 'LSP004', 'NCC004')

INSERT INTO [dbo].[LoaiSanPham] ([maLoaiSanPham], [tenLoaiSanPham])
VALUES
('LSP001', N'Áo'),
('LSP002', N'Quần'),
('LSP003', N'Váy'),
('LSP004', N'Phụ Kiện');

INSERT INTO [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap])
VALUES
('NCC001', N'An Dương'),
('NCC002', N'P&T Vina'),
('NCC003', N'Xưởng Dáng Ngọc'),
('NCC004', N'Rolex')

INSERT INTO [dbo].[SanPham_SizeS] (	[maSize] ,[maSanPham] ,[soLuong] )
VALUES
('S', 'SP001', 30),
('M', 'SP001', 20),
('L', 'SP001', 40),
('XL', 'SP001', 35),
('S', 'SP002', 80),
('M', 'SP002', 13),
('L', 'SP002', 63),
('XL', 'SP002', 54),
('S', 'SP003', 87),
('M', 'SP003', 43),
('L', 'SP003', 65),
('S', 'SP003', 27)
('N', 'SP004', 27)

INSERT INTO [dbo].[Sizes] (	[maSize] ,[tenSize] )
VALUES
('N', 'No')
('S', 'Size S'),
('M', 'Size M'),
('L', 'Size L'),
('XL', 'Size XL')

INSERT INTO [dbo].[khachhang] (	[maSize] ,[tenSize] )
VALUES
('N', 'No')
('S', 'Size S'),
('M', 'Size M'),
('L', 'Size L'),
('XL', 'Size XL')

INSERT INTO [dbo].[KhachHang] ([maKhachHang], [hoTen], [soDienThoai], [gioiTinh], [diaChi])
VALUES 
('KH001', N'Nguyễn Văn A', '0385345330', 1, N'123 Đường ABC, Quận XYZ'),
('KH002', N'Trần Thị B', '0976561890', 0, N'456 Đường XYZ, Quận ABC'),
('KH003', N'Lê Văn C', '0347767444', 1, N'789 Đường LMN, Quận DEF'),
('KH004', N'Nguyễn Mạnh Cường', '0464756337', 1, N'343 Quang Trung, Quận Gò Vấp'),
('KH005', N'Phan Tấn Tài', '0585785037', 1, N'463 Lê Lợi, Quận Gò Vấp'),
('KH006', N'Lê Thị Minh Châu', '0563763947', 0, N'153 Phạm Văn Đồng, Quận Thủ Đức'),
('KH007', N'Nguyễn Lan Anh', '0936785256', 0, N'43 Phan Đình Phùng, Quận Tân Phú');


INSERT INTO [dbo].[NhanVien] 
VALUES
('NV001', N'Nguyễn Văn An', '1990-01-15', 1, '123456789', '0123456789', 'Địa chỉ 1', N'Quản lý', 'avatar1.jpg'),
('NV002', N'Trần Thị Bình', '1992-05-20', 0, '987654321', '0987654321', 'Địa chỉ 2', N'Quản lý', 'avatar2.jpg'),
('NV003', N'Lê Văn Trung', '1988-11-10', 1, '456789123', '0456789123', 'Địa chỉ 3', N'Nhân viên bán hàng', 'avatar3.jpg'),
('NV004', N'Phạm Thị Hiền', '1995-07-25', 0, '654321987', '0654321987', 'Địa chỉ 4', N'Quản lý', 'avatar4.jpg'),
('NV005', N'Hoàng Văn Công', '1993-03-01', 1, '789123456', '0789123456', 'Địa chỉ 5', N'Nhân viên bán hàng', 'avatar5.jpg'),
('NV006', N'Mai Thị Loan', '1991-08-08', 0, '987123456', '0987123456', 'Địa chỉ 6', N'Nhân viên quản lý', 'avatar6.jpg'),
('NV007', N'Nguyễn Văn Giang', '1994-04-22', 1, '654789321', '0654789321', 'Địa chỉ 7', N'Nhân viên bán hàng', 'avatar7.jpg'),
('NV008', N'Phan Thị Ngọc Hân', '1990-12-05', 0, '456987321', '0456987321', 'Địa chỉ 8', N'Quản lý', 'avatar8.jpg'),
('NV009', N'Lý Thị Phương', '1987-09-18', 0, '123987456', '0123987456', 'Địa chỉ 9', N'Nhân viên bán hàng', 'avatar9.jpg'),
('NV010', N'Nguyễn Văn Khang', '1989-06-30', 1, '789456123', '0789456123', 'Địa chỉ 10', N'Quản lý', 'avatar10.jpg');

INSERT INTO [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [thue], [maKhachHang], [maNhanVien])
VALUES 
('HD001', '2019-11-02', 0.1, 'KH006', 'NV003'),
('HD002', '2019-10-20', 0.1, 'KH003', 'NV009'),
('HD003', '2019-09-10', 0.1, 'KH002', 'NV010'),
('HD004', '2020-01-30', 0.1, 'KH004', 'NV003'),
('HD005', '2020-02-14', 0.1, 'KH001', 'NV004'),
('HD006', '2020-03-19', 0.1, 'KH007', 'NV008'),
('HD007', '2021-09-12', 0.1, 'KH005', 'NV001'),
('HD008', '2022-05-24', 0.1, 'KH004', 'NV010'),
('HD009', '2022-07-18', 0.1, 'KH001', 'NV008'),
('HD010', '2023-11-05', 0.1, 'KH007', 'NV002');


INSERT INTO [dbo].[ChiTietHoaDon] ([maHoaDon], [maSanPham], [soLuong], [donGia], [kichThuoc])
VALUES 
('HD001', 'SP001', 1, 600000, 'Size S'),
('HD001', 'SP001', 4, 600000, 'Size M'),
('HD002', 'SP001', 3, 600000, 'Size S'),
('HD002', 'SP002', 2, 20.0, 'Size XL'),
('HD002', 'SP003', 1, 20.0, 'Size L'),
('HD003', 'SP002', 3, 20.0, 'Size M'),
('HD004', 'SP004', 1, 20.0, 'No'),
('HD004', 'SP001', 4, 600000, 'Size XL'),
('HD004', 'SP002', 1, 20.0, 'Size M'),
('HD005', 'SP003', 2, 20.0, 'Size S'),
('HD006', 'SP004', 1, 20.0, 'No'),
('HD006', 'SP001', 1, 600000, 'Size M'),
('HD007', 'SP003', 2, 20.0, 'Size L'),
('HD008', 'SP001', 5, 600000, 'Size XL'),
('HD008', 'SP002', 4, 20.0, 'Size M'),
('HD008', 'SP001', 1, 20.0, 'Size S'),
('HD008', 'SP004', 1, 20.0, 'No'),
('HD009', 'SP001', 2, 20.0, 'Size L'),
('HD009', 'SP001', 5, 20.0, 'Size S'),
('HD010', 'SP002', 3, 20.0, 'Size M'),
('HD010', 'SP003', 5, 20.0, 'Size XL');

SELECT name
FROM sys.key_constraints
WHERE parent_object_id = OBJECT_ID('dbo.ChiTietHoaDon')
    AND COL_NAME(parent_object_id, parent_column_id) = 'maHoaDon';

SELECT * FROM SanPham
SELECT * FROM KhachHang
SELECT * FROM HoaDon
SELECT * FROM ChiTietHoaDon
SELECT * FROM NhanVien
SELECT * FROM LoaiSanPham
SELECT * FROM NhaCungCap
SELECT * FROM SanPham_SizeS
SELECT * FROM Sizes


SELECT S.tenSize, SS.soLuong
FROM [dbo].[SanPham_SizeS] AS SS
JOIN [dbo].[Sizes] AS S ON SS.maSize = S.maSize
WHERE SS.maSanPham = 'SP001';

SELECT * FROM SanPham
WHERE maSanPham = 'SP001'

SELECT * FROM ChiTietHoaDon
where maHoaDon = 'HD001'

SELECT * FROM SanPham_SizeS
WHERE maSanPham = 'SP001'

SELECT * FROM SizeS
WHERE maSize = 'S'

SELECT tenNhaCungCap FROM NhaCungCap
WHERE maNhaCungCap = 'NCC001'

