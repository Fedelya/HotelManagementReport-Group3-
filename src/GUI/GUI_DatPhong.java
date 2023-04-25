package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.HoaDonPhong_DAO;
import dao.KhachHang_DAO;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.DichVu;
import entity.HoaDonDichVu;
import entity.HoaDonPhong;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;

public class GUI_DatPhong extends JFrame implements ActionListener, MouseListener {
	private JButton btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnTim, btnXemTatCa;
	private JMenuItem itemTrangChu;
	private JMenu menuTrangChu, menuDatPhong, menuQuanLyHoaDon, menuQuanLyDichVu, menuQuanLyKhachHang,
			menuQuanLyNhanVien, menuThongKe, subMenu;

	private int x = 10, w = 150, h = 50;
	private ImageIcon iconLogout = new ImageIcon(
			new ImageIcon("picture/logout-icon.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	private ImageIcon iconUser = new ImageIcon(
			new ImageIcon("picture/user-icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	private ImageIcon iconThem = new ImageIcon(
			new ImageIcon("picture/add-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXoa = new ImageIcon(
			new ImageIcon("picture/delete-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconSua = new ImageIcon(
			new ImageIcon("picture/update-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconLamMoi = new ImageIcon(
			new ImageIcon("picture/refesh-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconTim = new ImageIcon(
			new ImageIcon("picture/search-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXemTatCa = new ImageIcon(
			new ImageIcon("picture/see_all-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

	private JLabel lblMaKhachHang, lblTenKhachHang, lblCCCD, lblNgayHetHanCCCD, lblQuocTich;
	private JTextField txtTenKhachHang, txtCCCD;
	private JComboBox<String> cbQuocTich;
	private DatePicker dpNgayHetHanCCCD;

	private DefaultTableModel tableModel;
	private JTable table;
	private JComboBox<String> cboMaKhachHang;
	private JComboBox<String> jcbLoaiKH;
	private JComboBox jcbMaPhong;
	private JCheckBox jckKH1st;
	private DefaultTableModel tableModelHD;
	private JTable tableHD;
	private JButton btnLoc;
	private JComboBox jcbLoc;
	private JMenuItem itemQuanLyNhanVien;
	private JMenuItem itemThongKeDichVu;
	private JMenuItem itemThongKeKhachHang;
	private JMenuItem itemThongKeNhanVien;
	private JMenuItem itemDatPhong;
	private JMenuItem itemQuanLyHoaDon;
	private JMenuItem itemQuanLyPhong;
	private JMenuItem itemQuanLyDichVu;
	private JMenuItem itemQuanLyKhachHang;
	int maHD = 0;

	private HoaDonPhong_DAO hdp_dao;
	private KhachHang_DAO kh_dao;
	private Phong_DAO phong_dao;
	private LoaiPhong_DAO loaiPhong_dao;
	private ArrayList<HoaDonPhong> listHDP;
	private ArrayList<LoaiPhong> listLP;
	private ArrayList<KhachHang> listKH;
	private ArrayList<Phong> listPhong;
	private DatePicker dpTuNgay;
	private DatePicker dpDenNgay;
	private String tinhTrang;
	private JTextField txtTenKhachHang1;
	private JButton btnAdd;
	private ArrayList<HoaDonPhong> dshdp;

//	private DefaultComboBoxModel<String> modelMaPhong;
//	private DefaultComboBoxModel<String> modelMaKH;
//	private DefaultComboBoxModel<String> modelLoaiKH;

	public GUI_DatPhong() {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		listKH = new ArrayList<KhachHang>();

		hdp_dao = new HoaDonPhong_DAO();
		kh_dao = new KhachHang_DAO();
		phong_dao = new Phong_DAO();
		loaiPhong_dao = new LoaiPhong_DAO();

		// Phần Left
		JPanel pnlFull = new JPanel();
		pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(7, 0, 200, 650);
//				menuBar.setLayout(new GridLayout(0, 1));
		menuBar.setLayout(null);

		JLabel lblUser = new JLabel("admin");
		lblUser.setBounds(x, 30, w, 70);
		menuBar.add(lblUser);
		lblUser.setIcon(iconUser);

		menuTrangChu = new JMenu("Trang Chủ");

//				menuTrangChu.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuTrangChu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menuTrangChu.setBounds(x, 140, w, h);
//				menuBar.add(menuTrangChu);
		itemTrangChu = new JMenuItem("Trang chủ");
		menuTrangChu.add(itemTrangChu);
		menuBar.add(menuTrangChu);

//		            JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
//		            bar.add(sep1, "growy");
		menuDatPhong = new JMenu("Đặt phòng");
//				menuDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
//				menuBar.add(menuDatPhong);
		menuDatPhong.setBounds(x, 200, w, h);
		itemDatPhong = new JMenuItem("Đặt phòng");
		menuDatPhong.add(itemDatPhong);
		menuBar.add(menuDatPhong);

		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa Đơn");
//				menuQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuQuanLyHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
//				menuBar.add(menuQuanLyHoaDon);
		menuQuanLyHoaDon.setBounds(x, 260, w, h);
		itemQuanLyHoaDon = new JMenuItem("Quản lý hóa đơn dịch vụ");
		menuQuanLyHoaDon.add(itemQuanLyHoaDon);
		menuBar.add(menuQuanLyHoaDon);

		menuQuanLyDichVu = new JMenu("Quản Lý Dịch Vụ");
//				menuQuanLyDichVu.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuQuanLyDichVu.setVerticalTextPosition(SwingConstants.BOTTOM);
//				menuBar.add(menuQuanLyDichVu);
		menuQuanLyDichVu.setBounds(x, 320, w, h);
		itemQuanLyPhong = new JMenuItem("Quản lý phòng");
		itemQuanLyDichVu = new JMenuItem("Quản lý dịch vụ");
		menuQuanLyDichVu.add(itemQuanLyPhong);
		menuQuanLyDichVu.add(itemQuanLyDichVu);
		menuBar.add(menuQuanLyDichVu);

//		            JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
//		            bar.add(sep2, "growy");

		menuQuanLyKhachHang = new JMenu("Quản Lý Khách Hàng");
//				menuQuanLyKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuQuanLyKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
//				menuBar.add(menuQuanLyKhachHang);
		menuQuanLyKhachHang.setBounds(x, 380, w, h);
		itemQuanLyKhachHang = new JMenuItem("Quản lý khách hàng");
		menuQuanLyKhachHang.add(itemQuanLyKhachHang);
		menuBar.add(menuQuanLyKhachHang);

//				menuQuanLyNhanVien = new JMenu("Quản Lý Nhân Viên");
////				menuQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
////				menuQuanLyNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
////				menuBar.add(menuQuanLyNhanVien);
//				menuQuanLyNhanVien.setBounds(x, 400, w, h);
//				itemQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
//				menuQuanLyNhanVien.add(itemQuanLyNhanVien);
//				menuBar.add(menuQuanLyNhanVien);

		JMenu menuThongKe = new JMenu("Thống kê");
//				menuThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
//				menuThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
//				menuBar.add(menuThongKe);
		menuThongKe.setBounds(x, 440, w, h);
		itemThongKeDichVu = new JMenuItem("Thống kê dịch vụ");
		itemThongKeKhachHang = new JMenuItem("Thống kê khách hàng");

		menuThongKe.add(itemThongKeDichVu);
		menuThongKe.add(itemThongKeKhachHang);
		menuBar.add(menuThongKe);

		btnLogout = new JButton("Log out");
		btnLogout.setIcon(iconLogout);
		btnLogout.setBounds(20, 550, 120, 30);
		menuBar.add(btnLogout);
		pnlFull.add(menuBar);

		// Phần Right
		JLabel lblTitle = new JLabel("Quản Lý Đặt Phòng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(new TitledBorder("Thông tin khách hàng"));
		pnlThongTin.setBounds(210, 40, 330, 350);
		pnlFull.add(pnlThongTin);

		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(10, 20, 100, 30);
		pnlThongTin.add(lblMaKhachHang);

		cboMaKhachHang = new JComboBox<String>();
		cboMaKhachHang.setEditable(false);
		cboMaKhachHang.setBounds(125, 25, 145, 25);
		cboMaKhachHang.addItem("");
		pnlThongTin.add(cboMaKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(7, 55, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		txtTenKhachHang1 = new JTextField();
		txtTenKhachHang1.setBounds(125, 55, 195, 25);
		pnlThongTin.add(txtTenKhachHang1);
		txtTenKhachHang1.setColumns(10);

		lblTenKhachHang = new JLabel("CCCD:");
		lblTenKhachHang.setBounds(10, 85, 100, 30);
		pnlThongTin.add(lblTenKhachHang);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(125, 83, 195, 25);
		pnlThongTin.add(txtCCCD);
		txtCCCD.setColumns(10);

//		txtCCCD = new JTextField();
//		txtCCCD.setBounds(490, 25, 250, 25);
//		pnlThongTin.add(txtCCCD);
//		txtCCCD.setColumns(10);

		lblNgayHetHanCCCD = new JLabel("Ngày hết hạn CCCD: ");
		lblNgayHetHanCCCD.setBounds(7, 110, 250, 30);
		pnlThongTin.add(lblNgayHetHanCCCD);

		dpNgayHetHanCCCD = new DatePicker(205);
		dpNgayHetHanCCCD.setBounds(125, 115, 200, 25);
		pnlThongTin.add(dpNgayHetHanCCCD);

		lblTenKhachHang = new JLabel("Quốc tịch:");
		lblTenKhachHang.setBounds(7, 140, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		jcbLoaiKH = new JComboBox<String>();
		jcbLoaiKH.setBounds(125, 140, 195, 25);
		jcbLoaiKH.setEnabled(false);
		pnlThongTin.add(jcbLoaiKH);

		lblTenKhachHang = new JLabel("Mã phòng:");
		lblTenKhachHang.setBounds(7, 170, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		jcbMaPhong = new JComboBox<String>();
		jcbMaPhong.setBounds(125, 170, 195, 25);
		pnlThongTin.add(jcbMaPhong);

		lblNgayHetHanCCCD = new JLabel("Ngày đi: ");
		lblNgayHetHanCCCD.setBounds(7, 195, 250, 30);
		pnlThongTin.add(lblNgayHetHanCCCD);

		dpTuNgay = new DatePicker(205);
		dpTuNgay.setBounds(125, 200, 200, 25);
		pnlThongTin.add(dpTuNgay);

		lblNgayHetHanCCCD = new JLabel("Ngày đến: ");
		lblNgayHetHanCCCD.setBounds(7, 220, 250, 30);
		pnlThongTin.add(lblNgayHetHanCCCD);

		dpDenNgay = new DatePicker(205);
		dpDenNgay.setBounds(125, 225, 200, 25);
		pnlThongTin.add(dpDenNgay);

		jckKH1st = new JCheckBox("Khách hàng mới");
		jckKH1st.setBounds(100, 10000, 250, 30);
		pnlThongTin.add(jckKH1st);

		// Thêm Button

		btnAdd = new JButton("+");
		btnAdd.setBounds(274, 25, 45, 25);
		pnlThongTin.add(btnAdd);

		btnThem = new JButton("Add");
		btnThem.setBounds(40, 300, 100, 30);
		btnThem.setIcon(iconThem);
		pnlThongTin.add(btnThem);

		btnLamMoi = new JButton("Refesh");
		btnLamMoi.setBounds(180, 300, 100, 30);
		btnLamMoi.setIcon(iconLamMoi);
		pnlThongTin.add(btnLamMoi);
//
//		btnXoa = new JButton("Delete");
//		btnXoa.setBounds(260, 150, 100, 30);
//		btnXoa.setIcon(iconXoa);
//		pnlThongTin.add(btnXoa);
//
//		btnSua = new JButton("Update");
//		btnSua.setBounds(390, 150, 100, 30);
//		btnSua.setIcon(iconSua);
//		pnlThongTin.add(btnSua);
//

		JPanel pnlDanhSachPhong = new JPanel();
		pnlDanhSachPhong.setBorder(new TitledBorder("Danh Sách Phòng"));
		pnlDanhSachPhong.setBounds(543, 40, 440, 350);
		pnlFull.add(pnlDanhSachPhong);

		pnlDanhSachPhong.setLayout(null);

		JScrollPane scroll;
		String[] headers = { "Mã phòng", "Loại phòng", "vị trí", "giá phòng" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlDanhSachPhong.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scroll.setBounds(10, 30, 420, 310);

		JPanel pnlDanhSachHoaDon = new JPanel();
		pnlDanhSachHoaDon.setBorder(new TitledBorder("Danh Sách Hóa Đơn"));
		pnlDanhSachHoaDon.setBounds(209, 400, 775, 250);
		pnlFull.add(pnlDanhSachHoaDon);
		pnlDanhSachHoaDon.setLayout(null);

		JScrollPane scrollHD;
		String[] headersHD = { "Mã hóa đơn", "Mã khách hàng", "tên khách hàng", "Mã phòng", "Ngày đến", "Ngày đi",
				"Tình trạng" };

		tableModelHD = new DefaultTableModel(headersHD, 0);

		pnlDanhSachHoaDon.add(scrollHD = new JScrollPane(tableHD = new JTable(tableModelHD),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scrollHD.setBounds(10, 60, 756, 150);

		//
		lblTenKhachHang = new JLabel("Mã hóa đơn :");
		lblTenKhachHang.setBounds(30, 20, 100, 30);
		pnlDanhSachHoaDon.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(130, 25, 250, 25);
		txtTenKhachHang.setColumns(10);
		pnlDanhSachHoaDon.add(txtTenKhachHang);

		btnTim = new JButton("Search");
		btnTim.setBounds(380, 22, 100, 30);
		btnTim.setIcon(iconTim);
		pnlDanhSachHoaDon.add(btnTim);

		JLabel jblLoc = new JLabel("Lọc:");
		jblLoc.setBounds(550, 20, 50, 30);
		pnlDanhSachHoaDon.add(jblLoc);

		jcbLoc = new JComboBox<>();
		jcbLoc.addItem("Tất Cả");
		jcbLoc.addItem("Đã thanh toán");
		jcbLoc.addItem("Đã nhận phòng");
		jcbLoc.setBounds(600, 22, 150, 30);
		pnlDanhSachHoaDon.add(jcbLoc);

//		setJMenuBar(menuBar);
		pack();
		setTitle("Quản Lý Đặt Phòng");
		setSize(1000, 650);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));

		docDuLieuVaoTable();
		docDSPhong();
		loadCBMaPhong();
		loadCBKhachHang();
		loadCboMaKH();
//		docHoaDon();
		table.addMouseListener(this);
		tableHD.addMouseListener(this);
		jckKH1st.addActionListener(this);

		// Add sự kiện comboBox
		cboMaKhachHang.addActionListener(this);
		jcbLoc.addActionListener(this);
		// add sự kiện button
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLogout.addActionListener(this);
		btnTim.addActionListener(this);

		// add sự kiện cho menu
		itemDatPhong.addActionListener(this);
		itemQuanLyDichVu.addActionListener(this);
		itemQuanLyHoaDon.addActionListener(this);
		itemQuanLyKhachHang.addActionListener(this);
		itemQuanLyPhong.addActionListener(this);
		itemThongKeDichVu.addActionListener(this);
		itemThongKeKhachHang.addActionListener(this);
		itemTrangChu.addActionListener(this);
		btnLogout.addActionListener(this);

		btnAdd.addActionListener(this);

	}

//	public static void main(String[] args) {
//		new GUI_DatPhong().setVisible(true);
//
//	}

	private void loadCboMaKH() {
		listKH = kh_dao.getalltbKhachHang();
		for (KhachHang kh : listKH) {
			String ma = kh.getMaKhachHang();
			cboMaKhachHang.addItem(String.valueOf(ma));
		}
	}

	private void loadCBMaPhong() {
		listPhong = phong_dao.getallPhong();
		for (Phong p : listPhong)
			jcbMaPhong.addItem(p.getMaPhong());
	}

	private void loadCBKhachHang() {
		listKH = kh_dao.getalltbKhachHang();
		for (KhachHang kh : listKH)
			jcbLoaiKH.addItem(kh.getQuocTich());
	}

	public void docDuLieuVaoTable() {
		List<HoaDonPhong> list = hdp_dao.getalltbHoaDonPhong();
		List<KhachHang> listKH = kh_dao.getalltbKhachHang();
		List<Phong> listPhong = phong_dao.getallPhong();
		List<LoaiPhong> listLP = loaiPhong_dao.getallLoaiPhong();

		for (HoaDonPhong hdp : list) {
			String date1 = formatDate(hdp.getNgayGioNhan());
			String date2 = formatDate(hdp.getNgayGioTra());

			String MaKH = hdp.getKhachHang().getMaKhachHang();
			String tenKH = "";
			for (KhachHang i : listKH) {
				if (i.getMaKhachHang().equalsIgnoreCase(MaKH)) {
					tenKH = i.getTenKhachHang();
					break;
				}
			}
			String tenLPhong = "";
			for (Phong p : listPhong) {
				int maLPhong = p.getLoaiPhong().getMaLoaiPhong();
				for (LoaiPhong i : listLP) {
					if (i.getMaLoaiPhong() == maLPhong) {
						tenLPhong = i.getTenLoaiPhong();
						break;
					}
				}

			}

			if (hdp.getTinhTrang() == 0)
				tinhTrang = "Đã nhận phòng";
			else if (hdp.getTinhTrang() == 1)
				tinhTrang = "Đã thanh toán";
			tableModelHD.addRow(new Object[] { hdp.getMaHoaDon(), hdp.getKhachHang().getMaKhachHang(), tenKH,
					hdp.getPhong().getMaPhong(), date1, date2, tinhTrang });

		}
	}

	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		return sdf.format(date);
	}

	public void docDSPhong() {
		List<Phong> listPhong = phong_dao.getallPhong();
		List<LoaiPhong> listLP = loaiPhong_dao.getallLoaiPhong();
		String tenLPhong = "";
		double dongia = 0.0;
		for (Phong p : listPhong) {
			int maLPhong = p.getLoaiPhong().getMaLoaiPhong();
			for (LoaiPhong i : listLP) {
				if (i.getMaLoaiPhong() == maLPhong) {
					tenLPhong = i.getTenLoaiPhong();
					dongia = i.getDonGia();
					break;
				}

			}
			tableModel.addRow(new Object[] { p.getMaPhong(), tenLPhong, p.getViTri(), dongia });

		}
	}

	public void renderHoaDon() {
		for (int i = 0; i < dshdp.size(); i++) {
			int maHD = dshdp.get(i).getMaHoaDon();
			Date ngayGioNhan = dshdp.get(i).getNgayGioNhan();
			Date ngayGioTra = dshdp.get(i).getNgayGioTra();
			Phong phong = dshdp.get(i).getPhong();
			String maKhachHang = dshdp.get(i).getKhachHang().getMaKhachHang();
			String tenKhachHang = dshdp.get(i).getKhachHang().getTenKhachHang();
			String tinhTrang = "Đã thanh toán";
			if (dshdp.get(i).getTinhTrang() == 1)
				tinhTrang = "Đã nhận phòng";
			tableModelHD.addRow(new Object[] { maHD, maKhachHang, tenKhachHang, phong.getMaPhong(), ngayGioNhan,
					ngayGioTra, tinhTrang });

			if (this.maHD == maHD) {
				tableHD.addRowSelectionInterval(i, i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		long ml = System.currentTimeMillis();
		ml = ml / 86400000 * 86400000;
		Date now = new Date(ml);
		if (o.equals(btnThem)) {
			if (jckKH1st.isSelected()) {
				if (txtTenKhachHang.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống");
					return;
				}
				if (!txtTenKhachHang.getText().matches("^[0-9]{2,25}$")) {
					JOptionPane.showMessageDialog(this, "Tên khách hàng không được chứa số và có ít nhất 2 kí tự");
					txtTenKhachHang.selectAll();
					txtTenKhachHang.requestFocus();
					return;
				}
				if (txtCCCD.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "CCCD không được để trống");
					return;
				}
				if (!txtCCCD.getText().matches("^(\\d{9}|\\d{12}$)")) {
					JOptionPane.showMessageDialog(this, "CCCD chỉ được chứa chữ số, bao gồm hoặc 12 kí tự");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return;
				}
			} else {
				if (cboMaKhachHang.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống");
				}
			}
			Date ngayHetHan = new Date(ml);
			try {
				ngayHetHan = dpNgayHetHanCCCD.getFullDate();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			if (!ngayHetHan.toString().equals(now.toString()) && ngayHetHan.before(now)) {
				JOptionPane.showMessageDialog(this, "Giất tờ đã hết hạn, Không thể đặt phòng");
				return;
			}

			Date tuNgay = new Date(ml);
			Date denNgay = new Date(ml);
			try {
				tuNgay = dpTuNgay.getFullDate();
				denNgay = dpDenNgay.getFullDate();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			if (!tuNgay.toString().equals(now.toString()) && tuNgay.before(now)) {
				JOptionPane.showMessageDialog(this, "Ngày đến không được trước ngày hiện tại");
				return;
			}
			if (!tuNgay.toString().equals(denNgay.toString()) && !denNgay.before(tuNgay)) {
				JOptionPane.showMessageDialog(this, "Ngày đi không được trước ngày đến");
				return;
			}
			KhachHang khachHang = null;
			if (jckKH1st.isSelected()) {
				String tenKH = txtTenKhachHang.getText();
				String cccd = txtCCCD.getText();
				String loaiKH = (String) jcbLoaiKH.getSelectedItem();
				int soLanDatPhong = 0;
				khachHang = new KhachHang("", tenKH, loaiKH, cccd, ngayHetHan);
				try {
					if (kh_dao.insert(khachHang)) {
						JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
					}
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(this, "Không thể thêm khách hàng");
				}

				khachHang.setMaKhachHang(kh_dao.getLatestID());
			} else {
				khachHang = listKH.get(cboMaKhachHang.getSelectedIndex() - 1);
			}
			Phong phong = listPhong.get(jcbMaPhong.getSelectedIndex());
			int tinhTrang = 0;
			HoaDonPhong hdp = new HoaDonPhong(tinhTrang, tuNgay, denNgay, phong, khachHang);
			if (hdp_dao.themHDP(hdp)) {
				JOptionPane.showMessageDialog(this, "Đặt phòng thành công!");
				hdp.setMaHoaDon(hdp_dao.getLatestID());
				// dshdp.add(hdp);
				// maHD = hdp.getMaHD();
//                cboTinhTrang.setSelectedIndex(0);

				tableModelHD.addRow(new Object[] { hdp.getMaHoaDon(), hdp.getKhachHang().getMaKhachHang(),
						hdp.getKhachHang().getTenKhachHang(), phong.getMaPhong(), tuNgay, denNgay, "Đã nhận phòng" });
			} else {
				JOptionPane.showMessageDialog(this, "Không thể đặt phòng do trùng giờ đặt");
			}
		} else if (o.equals(cboMaKhachHang)) {
			int index = cboMaKhachHang.getSelectedIndex() - 1;
			if (index == -1) {
				txtTenKhachHang1.setText("");
				txtCCCD.setText("");
				dpNgayHetHanCCCD.setValue(now);
				jcbLoaiKH.setSelectedIndex(0);
			} else {
				txtTenKhachHang1.setText(listKH.get(index).getTenKhachHang());
//				String cc = String.valueOf(listKH.get(index).getCCCD());
				txtCCCD.setText(listKH.get(index).getCCCD());
				txtCCCD.setEditable(false);
				dpNgayHetHanCCCD.setValue(listKH.get(index).getNgayHetHanCCCD());
				jcbLoaiKH.setSelectedItem(listKH.get(index).getQuocTich());

			}
		} else if (o.equals(btnLamMoi)) {
			cboMaKhachHang.setSelectedIndex(0);
			txtTenKhachHang1.setText("");
			txtCCCD.setText("");
			dpNgayHetHanCCCD.setValue(now);
			jcbMaPhong.setSelectedIndex(0);
			dpTuNgay.setValue(now);
			dpDenNgay.setValue(now);
		} else if (o.equals(btnTim)) {
			dshdp = hdp_dao.getalltbHoaDonPhong();
			try {
				int MaHD = Integer.parseInt(txtTenKhachHang.getText());
				tableHD.clearSelection();
				for (int i = 0; i < dshdp.size(); i++) {
					if (MaHD == dshdp.get(i).getMaHoaDon()) {
						tableHD.addRowSelectionInterval(i, i);
						return;
					}
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Mã hóa đơn phải là số");
			}
		} else if (o.equals(jcbLoc)) {
			int index = jcbLoc.getSelectedIndex();
			if (index <= 0) {
				dshdp = hdp_dao.getalltbHoaDonPhong();
			} else {
				dshdp = hdp_dao.getListHDPhongByTinhTrang(index - 1);
			}
			tableModelHD.getDataVector().removeAllElements();
			renderHoaDon();
		}

//		if (o.equals(itemDatPhong)) {
//			this.dispose();
//			new GUI_DatPhong().setVisible(true);
//		} else 
		if (o.equals(itemQuanLyDichVu)) {
			this.dispose();
			new GUI_QuanLyDichVu().setVisible(true);
		} else if (o.equals(itemQuanLyHoaDon)) {
			this.dispose();
			new GUI_QuanLyHoaDonDichVu().setVisible(true);
		} else if (o.equals(itemQuanLyKhachHang)) {
			this.dispose();
			new GUI_QuanLyKhachHang().setVisible(true);
		} else if (o.equals(itemThongKeDichVu)) {
			this.dispose();
			new GUI_ThongKeDichVu().setVisible(true);
		} else if (o.equals(itemThongKeKhachHang)) {
			this.dispose();
			new GUI_ThongKeKhachHang().setVisible(true);
		} else if (o.equals(itemTrangChu)) {
			this.dispose();
			new GUI_TrangChu().setVisible(true);
		} else if (o.equals(itemQuanLyPhong)) {
			this.dispose();
			new GUI_QuanLyPhong().setVisible(true);
		} else if (o.equals(btnLogout)) {
			int ans = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất ?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION) {
				this.dispose();
				new GUI_DangNhap().setVisible(true);
			}
		} else if (o.equals(btnAdd)) {
			this.dispose();
			new GUI_QuanLyKhachHang().setVisible(true);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tableHD)) {
			int row2 = tableHD.getSelectedRow();
			cboMaKhachHang.setSelectedItem(tableModelHD.getValueAt(row2, 1).toString());
			txtTenKhachHang.setText(tableModelHD.getValueAt(row2, 0).toString());
			txtTenKhachHang1.setText(tableModelHD.getValueAt(row2, 2).toString());
			jcbMaPhong.setSelectedItem(tableModelHD.getValueAt(row2, 3).toString());
			// dpTuNgay.setValue(tableHD.getValueAt(row2, 4));

		}

		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
