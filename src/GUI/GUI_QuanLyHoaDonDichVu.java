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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
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
import dao.ChiTietDichVu_DAO;
import dao.DichVu_DAO;
import dao.HoaDonDichVu_DAO;
import dao.KhachHang_DAO;
import entity.ChiTietDichVu;
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDonDichVu;
import entity.HoaDonDichVu;
import entity.HoaDonDichVu;
import entity.KhachHang;

public class GUI_QuanLyHoaDonDichVu extends JFrame implements ActionListener, MouseListener {
	private JButton btnLogout, btnThem, btnXoa, btnSua, btnTaoHoaDon, btnTim, btnXemTatCa;
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
	private DatePicker dpNgayHetHanCCCD;

	private DefaultTableModel tableModel;
	private JTable table;
	private JComboBox<String> cboMaKhachHang;
	private JComboBox<String> jcbLoaiKH;
	private JComboBox<String> jcbMaPhong;
	private JCheckBox jckKH1st;
	private DefaultTableModel tableModelHD;
	private JTable tableHD;
	private JButton btnLoc;
	private JComboBox jcbLoc;
	private JComboBox<String> jcbDichVu;
	private JTextField txtSoLuong;
	private JTextField txtGia;
	private JButton btnSeeAll;
	private JButton btnBoChon;
	private JMenuItem itemQuanLyNhanVien;
	private JMenuItem itemThongKeDichVu;
	private JMenuItem itemThongKeKhachHang;
	private JMenuItem itemThongKeNhanVien;
	private JMenuItem itemDatPhong;
	private JMenuItem itemQuanLyHoaDon;
	private JMenuItem itemQuanLyPhong;
	private JMenuItem itemQuanLyDichVu;
	private JMenuItem itemQuanLyKhachHang;

	private ArrayList<ChiTietDichVu> dsCTDV;
	private ArrayList<KhachHang> dsKH;
	private ArrayList<DichVu> dsDV;
	private ArrayList<HoaDonDichVu> listHDDV;

	private HoaDonDichVu_DAO HDDV_dao;
	private ChiTietDichVu_DAO ctDV_dao;
	private KhachHang_DAO kh_dao;
	private DichVu_DAO dv_dao;
	private HoaDonDichVu_DAO hddv_dao;

	private JTextField txtMaHDDV;

	public GUI_QuanLyHoaDonDichVu() {
		// Phần Left
		dsKH = new ArrayList<KhachHang>();
		dsCTDV = new ArrayList<ChiTietDichVu>();
		dsDV = new ArrayList<DichVu>();
		listHDDV = new ArrayList<HoaDonDichVu>();

		hddv_dao = new HoaDonDichVu_DAO();
		ctDV_dao = new ChiTietDichVu_DAO();
		kh_dao = new KhachHang_DAO();
		dv_dao = new DichVu_DAO();

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HDDV_dao = new HoaDonDichVu_DAO();

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
		JLabel lblTitle = new JLabel("Quản Lý Hóa Đơn Dịch Vụ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);

		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(new TitledBorder("Thông tin khách hàng"));
		pnlThongTin.setBounds(250, 40, 730, 165);
		pnlFull.add(pnlThongTin);

		pnlThongTin.setLayout(null);

		lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(30, 20, 100, 30);
		pnlThongTin.add(lblMaKhachHang);

		cboMaKhachHang = new JComboBox<String>();
		cboMaKhachHang.setEditable(false);
		cboMaKhachHang.addItem("");
		cboMaKhachHang.setBounds(145, 25, 195, 25);
		pnlThongTin.add(cboMaKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(400, 20, 100, 30);
		pnlThongTin.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(500, 25, 195, 25);
		pnlThongTin.add(txtTenKhachHang);

		lblTenKhachHang = new JLabel("Dịch vụ:");
		lblTenKhachHang.setBounds(7, 70, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		jcbDichVu = new JComboBox<String>();
		jcbDichVu.setBounds(75, 70, 140, 25);
		jcbDichVu.addItem("");
		pnlThongTin.add(jcbDichVu);

		lblTenKhachHang = new JLabel("Số lượng:");
		lblTenKhachHang.setBounds(250, 70, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(330, 70, 160, 25);
		pnlThongTin.add(txtSoLuong);

		lblTenKhachHang = new JLabel("Giá:");
		lblTenKhachHang.setBounds(510, 70, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		txtGia = new JTextField();
		txtGia.setEditable(false);
		txtGia.setBounds(565, 70, 160, 25);
		pnlThongTin.add(txtGia);

		// Thêm Button
		btnThem = new JButton("Add");
		btnThem.setBounds(100, 120, 200, 30);
		btnThem.setIcon(iconThem);
		pnlThongTin.add(btnThem);

		btnTaoHoaDon = new JButton("Tạo hóa đơn");
		btnTaoHoaDon.setBounds(400, 120, 200, 30);
		btnTaoHoaDon.setIcon(iconLamMoi);
		pnlThongTin.add(btnTaoHoaDon);
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

		JPanel pnlDVDaDat = new JPanel();
		pnlDVDaDat.setBorder(new TitledBorder("Dịch vụ khách hàng đã đặt"));
		pnlDVDaDat.setBounds(250, 210, 730, 170);
		pnlFull.add(pnlDVDaDat);

		pnlDVDaDat.setLayout(null);

		JScrollPane scroll;
		String[] headers = { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá", "Thời gian đặt", "Mã hóa đơn" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlDVDaDat.add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		scroll.setBounds(10, 20, 710, 140);

		JPanel pnlDanhSachHoaDon = new JPanel();
		pnlDanhSachHoaDon.setBorder(new TitledBorder("Danh sách hóa đơn dịch vụ"));
		pnlDanhSachHoaDon.setBounds(250, 385, 730, 220);
		pnlFull.add(pnlDanhSachHoaDon);
		pnlDanhSachHoaDon.setLayout(null);

		JScrollPane scrollHD;
		String[] headersHD = { "Mã hóa đơn", "Mã khách hàng", "Thời gian đặt", "Tổng tiền", "Tình trạng" };

		tableModelHD = new DefaultTableModel(headersHD, 0);

		pnlDanhSachHoaDon.add(scrollHD = new JScrollPane(tableHD = new JTable(tableModelHD),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scrollHD.setBounds(10, 60, 710, 150);

		//
		lblTenKhachHang = new JLabel("Mã hóa đơn & dịch vụ :");
		lblTenKhachHang.setBounds(10, 20, 130, 30);
		pnlDanhSachHoaDon.add(lblTenKhachHang);

		txtMaHDDV = new JTextField();
		txtMaHDDV.setBounds(150, 25, 200, 25);
		txtMaHDDV.setColumns(10);
		pnlDanhSachHoaDon.add(txtMaHDDV);

		btnTim = new JButton("Tìm");
		btnTim.setBounds(350, 22, 110, 30);
		btnTim.setIcon(iconTim);
		pnlDanhSachHoaDon.add(btnTim);

		btnXemTatCa = new JButton("Xem tất cả");
		btnXemTatCa.setBounds(480, 22, 110, 30);
		btnXemTatCa.setIcon(iconXemTatCa);
		pnlDanhSachHoaDon.add(btnXemTatCa);

		btnBoChon = new JButton("Bỏ chọn");
		btnBoChon.setBounds(610, 22, 110, 30);
		btnBoChon.setIcon(iconXoa);
		pnlDanhSachHoaDon.add(btnBoChon);

//		setJMenuBar(menuBar);
		pack();
		setTitle("Quản Lý Hóa Đơn Dịch Vụ");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));

		docDuLieuVaoTableHDDV();
		docDuLieuVaoDV();
		loadCboMaKH();
		loadCboTenDV();

		table.addMouseListener(this);
		tableHD.addMouseListener(this);
		cboMaKhachHang.addActionListener(this);
//		pnlThongTin.addMouseListener(this);

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
		btnThem.addActionListener(this);
		btnTaoHoaDon.addActionListener(this);
		btnBoChon.addActionListener(this);
		btnTim.addActionListener(this);
		btnXemTatCa.addActionListener(this);

		jcbDichVu.addActionListener(this);

	}

	public static void main(String[] args) {
		new GUI_QuanLyHoaDonDichVu().setVisible(true);

	}

	public void docDuLieuVaoDV() {
		tableModel.setRowCount(0);
		for (ChiTietDichVu i : dsCTDV) {
			String date = formatDate(i.getNgayGioDat());
			tableModel.addRow(new Object[] { i.getDichVu().getMaDichVu(), i.getDichVu().getTenDichVu(), i.getSoLuong(),
					i.getDichVu().getDonGia(), date, i.getHoaDonDichVu().getMaHoaDonDichVu() });
		}
	}

	public void docDuLieuVaoTableHDDV() {
		listHDDV = hddv_dao.getalltbHoaDonDichVu();
		for (HoaDonDichVu hddv : listHDDV) {
			String date = formatDate(hddv.getNgayGioDat());
			String tinhTrang = getTinhTrang(hddv.getTinhTrang());
			double tong = hddv.tinhTong();
			tableModelHD.addRow(new Object[] { hddv.getMaHoaDonDichVu(), hddv.getKhachHang().getMaKhachHang(), date,
					tong, tinhTrang });
		}
	}

	private String getTinhTrang(int tinhTrang) {
		String s = "";
		if (tinhTrang == 0) {
			s = "Chưa thanh toán";
		} else if (tinhTrang == 1) {
			s = "Đã thanh toán";
		}
		return s;
	}

	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		return sdf.format(date);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		
		if (o.equals(btnThem)) {
			int index = tableHD.getSelectedRow();
			if (index == -1) {
				if (validDataSo()) {
					ChiTietDichVu ctdv = null;
					ctdv = getThongTinDV();
					try {
						boolean result = ctDV_dao.insertCTDV(ctdv);
						if (result) {
							int maDV = 0;
							String tenDV = ctdv.getDichVu().getTenDichVu();
							for (DichVu item : dsDV) {
								if (item.getTenDichVu().equals(tenDV)) {
									maDV = item.getMaDichVu();
									break;
								}
							}
							for (ChiTietDichVu chiTietDichVu : ctDV_dao.getallChiTietDichVu()) {
								tableModel.addRow(new Object[] { maDV, tenDV, chiTietDichVu.getSoLuong(),
										chiTietDichVu.getDichVu().getDonGia(), date, chiTietDichVu.getHoaDonDichVu().getMaHoaDonDichVu()});
							}
							JOptionPane.showMessageDialog(this, "Đã thêm dịch vụ");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Lỗi! Thêm thất bại");
					}
				}
			} else {
				if (validDataSo()) {
					HoaDonDichVu hdDV = null;
					hdDV = getThongTinHDDV();

					int maHDDV = listHDDV.get(index).getMaHoaDonDichVu();
					hdDV.setMaHoaDonDichVu(index);

					ChiTietDichVu ctdv = null;
					ctdv = getThongTinDV();
					ctdv.setHoaDonDichVu(hdDV);
					try {
						if (ctDV_dao.insertCTDV(ctdv)) {
						int maDV = 0;
						String tenDV = ctdv.getDichVu().getTenDichVu();
						for (DichVu item : dsDV) {
							if (item.getTenDichVu().equals(tenDV)) {
								maDV = item.getMaDichVu();
								break;
							}
						}
						tableModel.addRow(new Object[] { maDV, tenDV, ctdv.getSoLuong(), ctdv.getDichVu().getDonGia(),
								date, maHDDV });
						ctDV_dao.updateMaHDDV(maHDDV);
						JOptionPane.showMessageDialog(this, "Đã thêm dịch vụ");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Lỗi! Thêm thất bại");
					}
				}
			}
			cboMaKhachHang.setEnabled(false);

		}
		if (o.equals(btnBoChon)) {
			int index = tableHD.getSelectedRow();
			tableHD.removeRowSelectionInterval(index, index);
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
			cboMaKhachHang.setEnabled(false);
			cboMaKhachHang.setSelectedIndex(0);
			jcbDichVu.setSelectedIndex(0);
			txtSoLuong.setText("");
		}
		if (o.equals(btnTaoHoaDon)) {
			int index = tableHD.getSelectedRow();
			if (index == -1) {
				HoaDonDichVu hddv = null;
				hddv = getThongTinHDDV();
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();

				try {
					if (hddv_dao.insert(hddv)) {
						hddv.setMaHoaDonDichVu(hddv_dao.getLatestID());
						ctDV_dao.updateMaHDDV(hddv_dao.getLatestID());

					}
					String tinhTrang = getTinhTrang(hddv.getTinhTrang());
					listHDDV.add(hddv);
					tableModelHD.addRow(

							new Object[] { hddv.getMaHoaDonDichVu(), hddv.getKhachHang().getMaKhachHang(),
									hddv.getNgayGioDat(), hddv.tinhTong(), tinhTrang });
					JOptionPane.showMessageDialog(this, "Đã thêm hoá đơn");

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Lỗi! Thêm thất bại");
				}
			} else {
				HoaDonDichVu hddv = null;
				hddv = getThongTinHDDV();
				hddv.setMaHoaDonDichVu(listHDDV.get(index).getMaHoaDonDichVu());
				try {
					if (hddv_dao.insert(hddv)) {
						hddv.setMaHoaDonDichVu(hddv_dao.getLatestID());
						ctDV_dao.updateMaHDDV(hddv_dao.getLatestID());
					}
					String tt = getTinhTrang(hddv.getTinhTrang());
					listHDDV.add(hddv);
					tableModelHD.addRow(

							new Object[] { hddv.getMaHoaDonDichVu(), hddv.getKhachHang().getMaKhachHang(),
									hddv.getNgayGioDat(), hddv.tinhTong(), tt });
					JOptionPane.showMessageDialog(this, "Đã thêm hoá đơn");

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Lỗi! Thêm thất bại");
				}
			}
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
			cboMaKhachHang.setEnabled(true);
		}
		if(o.equals(btnTim)) {			
			int maHD = Integer.parseInt(txtMaHDDV.getText().trim());
			tableModelHD.getDataVector().removeAllElements();
			tableModelHD.fireTableDataChanged();
			listHDDV = hddv_dao.getDSHDDVTheoMa(maHD);
			if (listHDDV.size() <= 0) {
				JOptionPane.showMessageDialog(this, "Không tìm thấy hoá đơn");
			}
			for (HoaDonDichVu hddv : listHDDV) {
				String date2 = formatDate(hddv.getNgayGioDat());
				String tinhTrang = getTinhTrang(hddv.getTinhTrang());
				double tong = hddv.tinhTong();
				tableModelHD.addRow(new Object[] { hddv.getMaHoaDonDichVu(), hddv.getKhachHang().getMaKhachHang(), date2,
						tong, tinhTrang });
			}
		}
		if(o.equals(btnXemTatCa)) {
			tableModelHD.getDataVector().removeAllElements();
			tableModelHD.fireTableDataChanged();
			listHDDV = hddv_dao.getalltbHoaDonDichVu();
			docDuLieuVaoTableHDDV();
		}
		if (o.equals(cboMaKhachHang)) {
			int indx = cboMaKhachHang.getSelectedIndex() - 1;
			if (indx == -1) {
				txtTenKhachHang.setText("");
			} else {
				String ten = String.valueOf(dsKH.get(indx).getTenKhachHang());
				txtTenKhachHang.setText(ten);
			}
		}
		if (o.equals(jcbDichVu)) {
			int indx = jcbDichVu.getSelectedIndex() - 1;
			if (indx == -1) {
				txtGia.setText("");
			} else {
				String gia = String.valueOf(dsDV.get(indx).getDonGia());
				txtGia.setText(gia);
			}
		}
		// Menu
		else if (o.equals(itemDatPhong)) {
			this.dispose();
			new GUI_DatPhong().setVisible(true);
		} else if (o.equals(itemQuanLyDichVu)) {
			this.dispose();
			new GUI_QuanLyDichVu().setVisible(true);
//		} else if (o.equals(itemQuanLyHoaDon)) {
//			this.dispose();
//			new GUI_QuanLyHoaDonDichVu().setVisible(true);
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
		}
	}

	public HoaDonDichVu getThongTinHDDV() {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		KhachHang khachHang = new KhachHang("", "", "", "", date);
		String maKH = cboMaKhachHang.getSelectedItem().toString();
		khachHang.setMaKhachHang(maKH);
		int tt = 0;
		HoaDonDichVu hd = new HoaDonDichVu(0, tt, date, khachHang);
		hd.setMaHoaDonDichVu(hddv_dao.getLatestID());
		return hd;
	}

	public ChiTietDichVu getThongTinDV() {

		int indx = jcbDichVu.getSelectedIndex() - 1;

		int maDV = dsDV.get(indx).getMaDichVu();
		String tenDV = String.valueOf(jcbDichVu.getSelectedItem());
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(txtSoLuong.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Số lượng phải là số");
			return null;
		}

		double gia = dsDV.get(indx).getDonGia();
		DichVu dv = new DichVu(maDV, tenDV, gia);
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		HoaDonDichVu hd = new HoaDonDichVu(0, date, null);

		ChiTietDichVu ctDV = new ChiTietDichVu(dv, hd, soLuong, date);
		return ctDV;
	}

	private boolean validDataSo() {
		String soLuong = txtSoLuong.getText().trim();
		if (soLuong.length() > 0) {
			try {
				int x = Integer.parseInt(soLuong);
				if (x <= 0) {
					JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
					return false;
				}
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Số lượng phải là số!");
				return false;
			}
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			int row1 = table.getSelectedRow();
			int row2 = tableHD.getSelectedRow();
			cboMaKhachHang.setSelectedItem(tableModelHD.getValueAt(row2, 1).toString());
			jcbDichVu.setSelectedItem(tableModel.getValueAt(row1, 1).toString());
			txtSoLuong.setText(tableModel.getValueAt(row1, 2).toString());
			txtGia.setText(tableModel.getValueAt(row1, 3).toString());
		} else if (o.equals(tableHD)) {
			int row = tableHD.getSelectedRow();
			int maHD = Integer.parseInt(tableModelHD.getValueAt(row, 0).toString());
			dsCTDV = ctDV_dao.getChiTietDVByMaHDDV(maHD);
			cboMaKhachHang.setSelectedItem(tableModelHD.getValueAt(row, 1).toString());
			cboMaKhachHang.setEditable(false);
			docDuLieuVaoDV();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
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

	private void loadCboMaKH() {
		dsKH = kh_dao.getalltbKhachHang();
		for (KhachHang kh : dsKH) {
			String ma = kh.getMaKhachHang();
//			txtTenKhachHang.setText(kh.getTenKhachHang());
			cboMaKhachHang.addItem(String.valueOf(ma));
		}
	}

	private void loadCboTenDV() {
		dsDV = dv_dao.getalltbDichVu();
		for (DichVu dv : dsDV)
			jcbDichVu.addItem(dv.getTenDichVu());
	}

}
