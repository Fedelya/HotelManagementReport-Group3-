package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_QuanLyPhong extends JFrame {
	private JButton btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnTim, btnXemTatCa;
	private JMenuItem itemTrangChu, itemDatPhong, itemQuanLyHoaDon, itemQuanLyPhong, itemQuanLyDichVu,
	itemQuanLyKhachHang, itemQuanLyNhanVien,  itemThongKeDichVu, itemThongKeKhachHang, itemThongKeNhanVien;
	private JMenu menuTrangChu, menuDatPhong, menuQuanLyHoaDon, menuQuanLyDichVu, menuQuanLyKhachHang,
			menuQuanLyNhanVien, menuThongKe, subMenu;

	private int x = 0, w = 150, h = 150;
	private ImageIcon iconLogout = new ImageIcon(new ImageIcon("picture/logout-icon.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	private	ImageIcon iconUser = new ImageIcon(new ImageIcon("picture/user-icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	private ImageIcon iconThem = new ImageIcon(new ImageIcon("picture/add-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXoa = new ImageIcon(new ImageIcon("picture/delete-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconSua = new ImageIcon(new ImageIcon("picture/update-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconLamMoi = new ImageIcon(new ImageIcon("picture/refesh-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconTim = new ImageIcon(new ImageIcon("picture/search-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXemTatCa = new ImageIcon(new ImageIcon("picture/see_all-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	
	private JLabel lblMaKhachHang, lblTenKhachHang, lblCCCD, lblNgayHetHanCCCD, lblQuocTich;
	private JTextField txtMaKhachHang, txtTenKhachHang, txtCCCD;
	private JComboBox<String> cbQuocTich;
	private DatePicker dpNgayHetHanCCCD;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel center;
	private JPanel centerleft;
	private JPanel centerright;
	private JTextField txtmaloaiPhong;
	private JTextField txttenloaiphong;
	private JTextField txtdongia;
	private JLabel lbShowMessagesLP;
	private JButton btnlammoi;
	private JButton btnXem;
	private JTextField txttenloaiPhong;
	private JTable jTable;
	private JTextField txtmaPhong;
	private JTextField txtviTri;
	private JButton btnthem;
	private JButton btnxoa;
	private JButton btnLammoi;
	private JButton btnxemlich;
	private JButton btnsua;
	private JTextField txtmaPH;
	private DefaultTableModel tableModell;
	private JTable jTablee;
	
	private JLabel lblDonGia;
	
	private JLabel lblMaLoaiPhong;
	private Component txtTenLoaiPhong;
	private JLabel lblTenLoaiPhong;
	private JTextField txtMaLoaiPhong;
	private Component txtDonGia;
	private JLabel lblMaPhong;
	private JTextField txtMaPhong;
	private JLabel lblvitri;
	private JTextField txtvitri;
	private JComboBox<String> cbcloaiphong;
	private JComboBox<String> cbctinhtrang;
	private AbstractButton btnLamMois;
	private AbstractButton btnSuas;
	private JButton btnXemLichs;
	private AbstractButton btnXoas;
	private JLabel lbltinhtrang;
	private JLabel lblloaiphong;
	private JLabel lbltimmaphong;
	private JTextField txttimphong;
	private JButton btnTims;
	private JButton btnXemTatCas;
	private JLabel lbltimmaloai;
	private JTextField txttimmaloai;
	private DefaultTableModel tableModels;
	
	
	public GUI_QuanLyPhong() {
		JPanel pnlFull = new JPanel();
	pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(7, 0, 200, 800);
//		menuBar.setLayout(new GridLayout(0, 1));
		menuBar.setLayout(null);

		JLabel lblUser = new JLabel("Tên Admin");
		lblUser.setBounds(x, 10, w, 70);
		menuBar.add(lblUser);
		lblUser.setIcon(iconUser);

		menuTrangChu = new JMenu("Trang Chủ");

//		menuTrangChu.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuTrangChu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menuTrangChu.setBounds(x, 100, w, h);
//		menuBar.add(menuTrangChu);
		itemTrangChu = new JMenuItem("Trang chủ");
		menuTrangChu.add(itemTrangChu);
		menuBar.add(menuTrangChu);

//            JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
//            bar.add(sep1, "growy");
		menuDatPhong = new JMenu("Đặt phòng");
//		menuDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuDatPhong);
		menuDatPhong.setBounds(x, 160, w, h);
		itemDatPhong = new JMenuItem("Đặt phòng");
		menuDatPhong.add(itemDatPhong);
		menuBar.add(menuDatPhong);

		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa  ?ơn");
//		menuQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyHoaDon);
		menuQuanLyHoaDon.setBounds(x, 220, w, h);
		itemQuanLyHoaDon = new JMenuItem("Quản lý hóa đơn dịch vụ");
		menuQuanLyHoaDon.add(itemQuanLyHoaDon);
		menuBar.add(menuQuanLyHoaDon);

		menuQuanLyDichVu = new JMenu("Quản Lý Dịch Vụ");
//		menuQuanLyDichVu.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyDichVu.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyDichVu);
		menuQuanLyDichVu.setBounds(x, 280, w, h);
		itemQuanLyPhong = new JMenuItem("Quản lý phòng");
		itemQuanLyDichVu = new JMenuItem("Quản lý dịch vụ");
		menuQuanLyDichVu.add(itemQuanLyPhong);
		menuQuanLyDichVu.add(itemQuanLyDichVu);
		menuBar.add(menuQuanLyDichVu);

//            JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
//            bar.add(sep2, "growy");

		menuQuanLyKhachHang = new JMenu("Quản Lý Khách Hàng");
//		menuQuanLyKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyKhachHang);
		menuQuanLyKhachHang.setBounds(x, 340, w, h);
		itemQuanLyKhachHang = new JMenuItem("Quản lý khách hàng");
		menuQuanLyKhachHang.add(itemQuanLyKhachHang);
		menuBar.add(menuQuanLyKhachHang);

		menuQuanLyNhanVien = new JMenu("Quản Lý Nhân Viên");
//		menuQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyNhanVien);
		menuQuanLyNhanVien.setBounds(x, 400, w, h);
		itemQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
		menuQuanLyNhanVien.add(itemQuanLyNhanVien);
		menuBar.add(menuQuanLyNhanVien);

		JMenu menuThongKe = new JMenu("Thống kê");
//		menuThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuThongKe);
		menuThongKe.setBounds(x, 460, w, h);
		itemThongKeDichVu = new JMenuItem("Thống kê dịch vụ");
		itemThongKeKhachHang = new JMenuItem("Thống kê khách hàng");
		itemThongKeNhanVien = new JMenuItem("Thống kê nhân viên");
		
		menuThongKe.add(itemThongKeDichVu);
		menuThongKe.add(itemThongKeKhachHang);
		menuThongKe.add(itemThongKeNhanVien);
		menuBar.add(menuThongKe);

		btnLogout = new JButton("Log out");
		btnLogout.setIcon(iconLogout);
		btnLogout.setBounds(20, 650, 120, 30);
		menuBar.add(btnLogout);
		pnlFull.add(menuBar);
		//
		JLabel lblTitle = new JLabel("Quản Lý Phòng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(480, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 27));
		pnlFull.add(lblTitle);
		
		//add
		setTitle("Quản Lý Phòng");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255,230,179));
		//Thong tin loai phong
		JPanel pnlThongTinLoaiPhong = new JPanel();
		pnlThongTinLoaiPhong.setBorder(new TitledBorder(null, "Thông tin loại phòng"));
		pnlThongTinLoaiPhong.setBounds(210, 40, 350, 360);
		pnlFull.add(pnlThongTinLoaiPhong);

		pnlThongTinLoaiPhong.setLayout(null);

		lblMaLoaiPhong = new JLabel("Mã loại phòng:");
		lblMaLoaiPhong.setBounds(10, 40, 100, 30);
		pnlThongTinLoaiPhong.add(lblMaLoaiPhong);

		txtMaLoaiPhong = new JTextField();
//		txtMaLoaiPhong.setEditable(false);
		txtMaLoaiPhong.setBounds(110, 45, 200, 25);
		pnlThongTinLoaiPhong.add(txtMaLoaiPhong);
		txtMaLoaiPhong.setColumns(10);

		lblTenLoaiPhong = new JLabel("Tên loại phòng:");
		lblTenLoaiPhong.setBounds(10, 75, 100, 30);
		pnlThongTinLoaiPhong.add(lblTenLoaiPhong);

		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBounds(110, 80, 200, 25);
		pnlThongTinLoaiPhong.add(txtTenLoaiPhong);
		txtMaLoaiPhong.setColumns(10);

		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setBounds(10, 110, 100, 30);
		pnlThongTinLoaiPhong.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(110, 115, 200, 25);
		pnlThongTinLoaiPhong.add(txtDonGia);
//		txtDonGia.setColumns(10);

		// Thêm button
		btnThem = new JButton("Add");
		btnThem.setBounds(50, 200, 100, 30);
		btnThem.setIcon(iconThem);
		pnlThongTinLoaiPhong.add(btnThem);

		btnXoa = new JButton("Delete");
		btnXoa.setBounds(200, 200, 100, 30);
		btnXoa.setIcon(iconXoa);
		pnlThongTinLoaiPhong.add(btnXoa);

		btnSua = new JButton("Update");
		btnSua.setBounds(50, 235, 100, 30);
		btnSua.setIcon(iconSua);
		pnlThongTinLoaiPhong.add(btnSua);

		btnLamMoi = new JButton("Refesh");
		btnLamMoi.setBounds(200, 235, 100, 30);
		btnLamMoi.setIcon(iconLamMoi);
		pnlThongTinLoaiPhong.add(btnLamMoi);
	//Danh sach Loai Phong
		JPanel pnldanhsachloaiphong = new JPanel();
		pnldanhsachloaiphong.setBorder(new TitledBorder(null, "Danh Sách Khách Hàng"));
		pnldanhsachloaiphong.setBounds(560, 40, 630, 360);
		pnlFull.add(pnldanhsachloaiphong);
		
		pnldanhsachloaiphong.setLayout(null);
		
		lbltimmaloai = new JLabel("Mã loại phòng:");
        lbltimmaloai.setBounds(0, 20, 100, 30);
        pnldanhsachloaiphong.add(lbltimmaloai);
        
        txttimmaloai = new JTextField();
        txttimmaloai.setBounds(110, 25, 250, 25);
        txttimmaloai.setColumns(10);
        pnldanhsachloaiphong.add(txttimmaloai);
        
        btnTim = new JButton("Search");
        btnTim.setBounds(370, 22, 100, 30);
        btnTim.setIcon(iconTim);
        pnldanhsachloaiphong.add(btnTim);
        
        btnXemTatCa = new JButton("Watch All");
        btnXemTatCa.setBounds(480, 22, 150, 30);
        btnXemTatCa.setIcon(iconXemTatCa);
        pnldanhsachloaiphong.add(btnXemTatCa);
        
        JScrollPane scroll;
        String[] headers = {"Mã Loại phòng", "Tên Loại Phòng", "Đơn Giá"};
        
        tableModel = new DefaultTableModel(headers, 0);
        
        pnldanhsachloaiphong.add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        scroll.setBounds(5, 60, 680, 300);
		//Thong tin phong
        JPanel pnlThongTinPhong = new JPanel();
		pnlThongTinPhong.setBorder(new TitledBorder(null, "Thông tin  phòng"));
		pnlThongTinPhong.setBounds(210, 400, 350, 360);
		pnlFull.add(pnlThongTinPhong);

		 pnlThongTinPhong.setLayout(null);

		lblMaPhong = new JLabel("Mã  phòng:");
		lblMaPhong.setBounds(10, 40, 100, 30);
		pnlThongTinPhong.add(lblMaPhong);

		txtMaPhong = new JTextField();
//		txtMaLoaiPhong.setEditable(false);
		txtMaPhong.setBounds(110, 45, 200, 25);
		pnlThongTinPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblvitri = new JLabel("Vị trí phòng:");
		lblvitri.setBounds(10, 75, 100, 30);
		pnlThongTinPhong.add(lblvitri);

		txtvitri = new JTextField();
		txtvitri.setBounds(110, 80, 200, 25);
		pnlThongTinPhong.add(txtvitri);
		txtvitri.setColumns(10);
		lblloaiphong = new JLabel("Loại Phòng:");
		lblloaiphong.setBounds(10, 110, 100, 30);
		pnlThongTinPhong.add(lblloaiphong);
		cbcloaiphong = new JComboBox<String>();
		cbcloaiphong.setBounds(110, 115, 160, 25);
//        cbBoPhan.addItem("");
		
		cbcloaiphong.addItem("Giường đơn");
		cbcloaiphong.addItem("Giường đôi");
		pnlThongTinPhong.add(cbcloaiphong);
		lbltinhtrang = new JLabel("Tình trạng phòng:");
		lbltinhtrang.setBounds(10, 140, 100, 30);
		pnlThongTinPhong.add(lbltinhtrang);
		cbctinhtrang = new JComboBox<String>();
		cbctinhtrang.setBounds(110, 145, 160, 25);
//        cbBoPhan.addItem("");
		cbctinhtrang.addItem("Trống");
		cbctinhtrang.addItem("Đã được đặt");
		cbctinhtrang.addItem("Đang cho thuê");
		pnlThongTinPhong.add(cbctinhtrang);
		
		

		
//		txtDonGia.setColumns(10);

		// Thêm button
		JButton btnThems = new JButton("Add");
		btnThems.setBounds(50, 200, 100, 30);
		btnThems.setIcon(iconThem);
		pnlThongTinPhong.add(btnThems);

		btnXoas = new JButton("Delete");
		btnXoas.setBounds(200, 200, 100, 30);
		btnXoas.setIcon(iconXoa);
		pnlThongTinPhong.add(btnXoas);

		btnSuas = new JButton("Update");
		btnSuas.setBounds(50, 235, 100, 30);
		btnSuas.setIcon(iconSua);
		pnlThongTinPhong.add(btnSuas);

		btnLamMois = new JButton("Refesh");
		btnLamMois.setBounds(200, 235, 100, 30);
		btnLamMois.setIcon(iconLamMoi);
		pnlThongTinPhong.add(btnLamMois);
		btnXemLichs = new JButton("Xem Lich Đặt");
		btnXemLichs.setBounds(75, 270, 200, 30);
		btnXemLichs.setIcon(iconXemTatCa);
		pnlThongTinPhong.add(btnXemLichs);
		//
		JPanel pnldanhsachphong = new JPanel();
		pnldanhsachphong.setBorder(new TitledBorder(null, "Danh Sách Phòng"));
		pnldanhsachphong.setBounds(560, 400, 630, 360);
		pnlFull.add(pnldanhsachphong);
		
		pnldanhsachphong.setLayout(null);
		
		lbltimmaphong = new JLabel("Mã Phòng:");
        lbltimmaphong.setBounds(0, 20, 100, 30);
        pnldanhsachphong.add(lbltimmaphong);
        
        txttimphong = new JTextField();
        txttimphong.setBounds(110, 25, 250, 25);
        txttimphong.setColumns(10);
        pnldanhsachphong.add(txttimphong);
        
        btnTims = new JButton("Search");
        btnTims.setBounds(370, 22, 100, 30);
        btnTims.setIcon(iconTim);
        pnldanhsachphong.add(btnTims);
        
        btnXemTatCas = new JButton("Watch All");
        btnXemTatCas.setBounds(480, 22, 150, 30);
        btnXemTatCas.setIcon(iconXemTatCa);
        pnldanhsachphong.add(btnXemTatCas);
        
        JScrollPane scrolls;
        String[] headerss = {"Mã  phòng", "Vị Trí", "Tình Trạng","Loại Phòng"};
        
        tableModels = new DefaultTableModel(headerss, 0);
        
        pnldanhsachphong.add(scrolls = new JScrollPane(table = new JTable(tableModels), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        scrolls.setBounds(5, 60, 680, 300);
		
		
		   
	}
	public static void main(String[] args) {
		new GUI_QuanLyPhong().setVisible(true);
	}
	

}
