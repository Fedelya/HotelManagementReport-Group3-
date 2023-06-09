
create database HotelManagement
go

USE [HotelManagement]
GO
/****** Object:  Table [dbo].[ChiTietDichVu]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVu](
	[MaHDDV] [int] NULL,
	[MaDV] [int] NULL,
	[SoLuong] [int] NULL,
	[NgayGioDat] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDV] [int] NOT NULL,
	[TenDV] [nvarchar](50) NOT NULL,
	[DonGia] [decimal](18, 0) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonDichVu]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonDichVu](
	[MaHDDV] [int] IDENTITY NOT NULL,
	[TinhTrang] [int] NULL,
	[NgayGioLap] [datetime] NULL,
	[MaKH] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HoaDonDichVu] PRIMARY KEY CLUSTERED 
(
	[MaHDDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonPhong]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonPhong](
	[MaHD] [int] IDENTITY NOT NULL,
	[MaKH] [nvarchar](50) NULL,
	[MaPhong] [nvarchar](50) NULL,
	[TinhTrang] [int] NULL,
	[NgayGioNhan] [datetime] NOT NULL,
	[NgayGioTra] [datetime] NULL,
 CONSTRAINT [PK_HoaDonPhong] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nvarchar](50) NOT NULL,
	[TenKH] [nvarchar](50) NOT NULL,
	[QuocTich] [nvarchar](20) NOT NULL,
	[CCCD] [nvarchar](20) NOT NULL,
	[NgayHetHanCCCD] [datetime] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [int] NOT NULL,
	[TenLoaiPhong] [nvarchar](50) NOT NULL,
	[DonGia] [decimal](18, 0) NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nvarchar](50) NOT NULL,
	[ViTri] [nvarchar](50) NULL,
	[TinhTrang] [int] NULL,
	[MaLoaiPhong] [int] NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietDichVu] ([MaHDDV], [MaDV], [SoLuong], [NgayGioDat]) VALUES (1, 4, 1, CAST(N'2023-04-10T19:00:00.000' AS DateTime))
INSERT [dbo].[ChiTietDichVu] ([MaHDDV], [MaDV], [SoLuong], [NgayGioDat]) VALUES (4, 5, 3, CAST(N'2023-04-18T00:00:00.000' AS DateTime))
INSERT [dbo].[ChiTietDichVu] ([MaHDDV], [MaDV], [SoLuong], [NgayGioDat]) VALUES (2, 11, 5, CAST(N'2023-04-17T18:30:00.000' AS DateTime))
INSERT [dbo].[ChiTietDichVu] ([MaHDDV], [MaDV], [SoLuong], [NgayGioDat]) VALUES (3, 1, 1, CAST(N'2023-04-18T23:00:00.000' AS DateTime))
GO
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (1, N'Mát xa toàn thân', CAST(200000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (2, N'Nước Cola', CAST(25000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (3, N'Nước 7UP', CAST(25000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (4, N'Khoai tây chiên', CAST(28000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (5, N'Cháo hành', CAST(30000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (6, N'Mì xào bò', CAST(40000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (7, N'Giặt quần áo', CAST(50000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (8, N'Trông trẻ', CAST(30000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (9, N'Bia Tiger', CAST(25000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (10, N'Bia Heineken', CAST(29000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (11, N'Bia Saigon', CAST(20000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (12, N'Rượu Whiskey', CAST(400000 AS Decimal(18, 0)))
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [DonGia]) VALUES (13, N'Rượu Gin', CAST(200000 AS Decimal(18, 0)))
GO
INSERT [dbo].[HoaDonDichVu] ([TinhTrang], [NgayGioLap], [MaKH]) VALUES (1, CAST(N'2023-04-10T00:00:00.000' AS DateTime), N'KH1')
INSERT [dbo].[HoaDonDichVu] ([TinhTrang], [NgayGioLap], [MaKH]) VALUES (1, CAST(N'2023-04-16T00:00:00.000' AS DateTime), N'KH2')
INSERT [dbo].[HoaDonDichVu] ([TinhTrang], [NgayGioLap], [MaKH]) VALUES (1, CAST(N'2023-04-17T00:00:00.000' AS DateTime), N'KH3')
INSERT [dbo].[HoaDonDichVu] ([TinhTrang], [NgayGioLap], [MaKH]) VALUES (0, CAST(N'2023-04-17T00:00:00.000' AS DateTime), N'KH4')
GO
INSERT [dbo].[HoaDonPhong] ([MaKH], [MaPhong], [TinhTrang], [NgayGioNhan], [NgayGioTra]) VALUES (N'KH1', N'P101', 1, CAST(N'2023-04-09T18:00:00.000' AS DateTime), CAST(N'2023-04-11T06:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonPhong] ([MaKH], [MaPhong], [TinhTrang], [NgayGioNhan], [NgayGioTra]) VALUES (N'KH2', N'P201', 1, CAST(N'2023-04-13T18:00:00.000' AS DateTime), CAST(N'2023-04-14T06:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonPhong] ([MaKH], [MaPhong], [TinhTrang], [NgayGioNhan], [NgayGioTra]) VALUES (N'KH3', N'P301', 1, CAST(N'2023-04-15T19:00:00.000' AS DateTime), CAST(N'2023-04-17T09:00:00.000' AS DateTime))
INSERT [dbo].[HoaDonPhong] ([MaKH], [MaPhong], [TinhTrang], [NgayGioNhan], [NgayGioTra]) VALUES (N'KH4', N'P303', 0, CAST(N'2023-04-16T10:00:00.000' AS DateTime), CAST(N'2023-04-18T07:00:00.000' AS DateTime))
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH1', N'Trần Anh Tiến', N'Việt Nam', N'224578965', CAST(N'2027-10-13T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH2', N'Đặng Minh Phương', N'Việt Nam', N'228199072', CAST(N'2027-05-06T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH3', N'Nguyễn Quang Duy', N'Việt Nam', N'226718906', CAST(N'2027-12-10T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH4', N'DuongChel', N'Nước Ngoài', N'229843123', CAST(N'2027-07-19T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH5', N'David', N'Nước ngoài', N'223456775', CAST(N'2027-04-08T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH6', N'Duong Jonny', N'Nước ngoài', N'224567890', CAST(N'2027-04-16T00:00:00.000' AS DateTime))
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [QuocTich], [CCCD], [NgayHetHanCCCD]) VALUES (N'KH7', N'cc', N'Việt Nam', N'123456789', CAST(N'2023-04-29T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (1, N'Phòng đơn', CAST(40000 AS Decimal(18, 0)))
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia]) VALUES (2, N'Phòng đôi', CAST(100000 AS Decimal(18, 0)))
GO
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P101', N'Tầng 1', 0, 1)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P102', N'Tầng 1', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P103', N'Tầng 1', 0, 1)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P104', N'Tầng 1', 2, 1)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P105', N'Tầng 1', 2, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P201', N'Tầng 2', 1, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P202', N'Tầng 2', 0, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P203', N'Tầng 2', 0, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P204', N'Tầng 2', 2, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P301', N'Tầng 3', 0, 1)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P302', N'Tầng 3', 0, 2)
INSERT [dbo].[Phong] ([MaPhong], [ViTri], [TinhTrang], [MaLoaiPhong]) VALUES (N'P303', N'Tầng 3', 1, 2)
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_DichVu] FOREIGN KEY([MaDV])
REFERENCES [dbo].[DichVu] ([MaDV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_DichVu]
GO
ALTER TABLE [dbo].[ChiTietDichVu]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDichVu_HoaDonDichVu] FOREIGN KEY([MaHDDV])
REFERENCES [dbo].[HoaDonDichVu] ([MaHDDV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDichVu] CHECK CONSTRAINT [FK_ChiTietDichVu_HoaDonDichVu]
GO
ALTER TABLE [dbo].[HoaDonDichVu]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonDichVu_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonDichVu] CHECK CONSTRAINT [FK_HoaDonDichVu_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonPhong]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonPhong_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonPhong] CHECK CONSTRAINT [FK_HoaDonPhong_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonPhong]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonPhong_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDonPhong] CHECK CONSTRAINT [FK_HoaDonPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
/****** Object:  StoredProcedure [dbo].[Proc_LocChiTietHoaDonTheoNgay]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[Proc_LocChiTietHoaDonTheoNgay]
	@tuNgay DATETIME,
	@denNgay DATETIME
AS
BEGIN
	SELECT hddv.MaHDDV, hddv.NgayGioLap , hddv.TinhTrang,
		kh.MaKH , kh.TenKH, kh.CCCD, kh.NgayHetHanCCCD, kh.QuocTich,
		ctdv.SoLuong, ctdv.NgayGioDat,
		dv.MaDV, dv.TenDV, dv.DonGia
	FROM dbo.HoaDonDichVu hddv
		JOIN dbo.ChiTietDichVu ctdv ON hddv.MaHDDV = ctdv.MaHDDV
		JOIN dbo.DichVu dv ON dv.MaDV = ctdv.MaDV 
		JOIN dbo.KhachHang kh ON  kh.MaKH =  hddv.MaKH
	WHERE ctdv.NgayGioDat BETWEEN @tuNgay AND @denNgay
		AND hddv.TinhTrang = 1
END
GO
/****** Object:  StoredProcedure [dbo].[Proc_LocHoaDonPhongTheoNgay]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[Proc_LocHoaDonPhongTheoNgay]
	@tuNgay DATETIME,
	@denNgay DATETIME
AS
BEGIN
	SELECT hdp.MaHD, hdp.TinhTrang AS TinhTrangHD,
		hdp.NgayGioNhan, hdp.NgayGioTra,
		p.MaPhong, p.ViTri, p.TinhTrang AS TinhTrangP,
		lp.MaLoaiPhong, lp.TenLoaiPhong, lp.DonGia,
		kh.MaKH, kh.TenKH, kh.CCCD, kh.NgayHetHanCCCD, kh.QuocTich
	FROM dbo.HoaDonPhong hdp
		JOIN dbo.Phong p ON hdp.MaPhong = p.MaPhong
		JOIN dbo.LoaiPhong lp ON lp.MaLoaiPhong = p.MaLoaiPhong
		JOIN dbo.KhachHang kh ON kh.MaKH = hdp.MaKH
	WHERE (hdp.NgayGioNhan BETWEEN @tuNgay AND @denNgay)
		AND (hdp.TinhTrang BETWEEN 1 AND 2)
END
GO
/****** Object:  StoredProcedure [dbo].[UDP_LocHoaDonDichVuBoiMa]    Script Date: 24/04/2023 9:11:34 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[UDP_LocHoaDonDichVuBoiMa]
	@id INT
AS
BEGIN
	SELECT hddv.MaHDDV, kh.MaKH, hddv.NgayGioLap, hddv.TinhTrang,
		ctdv.MaDV, dv.TenDV, ctdv.SoLuong, dv.DonGia, ctdv.NgayGioDat, ctdv.MaHDDV AS MaCTHD
	FROM dbo.HoaDonDichVu hddv
		INNER JOIN dbo.KhachHang kh ON hddv.MaKH = kh.MaKH
		INNER JOIN dbo.ChiTietDichVu ctdv ON ctdv.MaHDDV=hddv.MaHDDV
		INNER JOIN dbo.DichVu dv ON  dv.MaDV = ctdv.MaDV
	WHERE hddv.MaHDDV = @id
END
GO
