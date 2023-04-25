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
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import dao.HoaDonDichVu_DAO;
import dao.HoaDonPhong_DAO;
import entity.HoaDonPhong;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;

public class GUI_ThongKeKhachHang extends JFrame implements ActionListener {
	private JButton btnLogout;
	private JMenuItem itemTrangChu, itemDatPhong, itemQuanLyHoaDon, itemQuanLyPhong, itemQuanLyDichVu,
			itemQuanLyKhachHang, itemQuanLyNhanVien, itemThongKeDichVu, itemThongKeKhachHang, itemThongKeNhanVien;
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
	private ImageIcon iconThongKe = new ImageIcon(
			new ImageIcon("picture/chart-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

	private JLabel lblMaKhachHang, lblTenKhachHang;
	private JTextField txtMaKhachHang, txtTenKhachHang;

	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel lblTuNgay;
	private DatePicker dpTuNgay;
	private JLabel lblDenNgay;
	private DatePicker dpDenNgay;
	private JButton btnThongKe;
	private JLabel lblTongDoanhThu;
	private JTextField txtTongDoanhThu;
	private JLabel lblVND;

	private HoaDonPhong_DAO hd_DAO = new HoaDonPhong_DAO();

	public GUI_ThongKeKhachHang() {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		hd_DAO = new HoaDonPhong_DAO();

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
		JLabel lblTitle = new JLabel("BÁO CÁO TỔNG HỢP KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);

		JPanel pnlThongKeKhachHang = new JPanel();
//		pnlThongKeKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng"));
		pnlThongKeKhachHang.setBounds(230, 40, 750, 550);
		pnlFull.add(pnlThongKeKhachHang);

		pnlThongKeKhachHang.setLayout(null);

		lblTuNgay = new JLabel("Từ ngày: ");
		lblTuNgay.setBounds(40, 35, 100, 30);
		pnlThongKeKhachHang.add(lblTuNgay);

		dpTuNgay = new DatePicker(205);
		dpTuNgay.setBounds(130, 40, 250, 25);
		pnlThongKeKhachHang.add(dpTuNgay);

		lblDenNgay = new JLabel("Đến ngày: ");
		lblDenNgay.setBounds(410, 35, 250, 30);
		pnlThongKeKhachHang.add(lblDenNgay);

		dpDenNgay = new DatePicker(205);
		dpDenNgay.setBounds(510, 40, 250, 25);
		pnlThongKeKhachHang.add(dpDenNgay);

		JScrollPane scroll;
		String[] headers = { "Mã HD", "Mã Phòng", "Loại Phòng", "Giá Phòng", "Ngày CheckIn", "Ngày CheckOut", "Số ngày",
				"Thành tiền", "Mã KH", "Tên KH" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlThongKeKhachHang.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
		scroll.setBounds(5, 100, 740, 400);
//        
		reSizeColumnTable();

		btnThongKe = new JButton("Thống kê");
		btnThongKe.setBounds(580, 510, 150, 30);
		btnThongKe.setIcon(iconThongKe);
		pnlThongKeKhachHang.add(btnThongKe);

		lblTongDoanhThu = new JLabel("Tổng doanh thu:");
		lblTongDoanhThu.setBounds(10, 510, 100, 30);
		pnlThongKeKhachHang.add(lblTongDoanhThu);

		txtTongDoanhThu = new JTextField("0.0");

		txtTongDoanhThu.setBounds(110, 517, 180, 20);
		txtTongDoanhThu.setBackground(Color.CYAN);
		txtTongDoanhThu.setEditable(false);
		pnlThongKeKhachHang.add(txtTongDoanhThu);
		txtTongDoanhThu.setColumns(10);

		lblVND = new JLabel("VNĐ");
		lblVND.setBounds(300, 510, 100, 30);
		pnlThongKeKhachHang.add(lblVND);

//		setJMenuBar(menuBar);
//		pack();
		setTitle("Thống Kê Khách Hàng");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));

		btnThongKe.addActionListener(this);

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
	}

//	public static void main(String[] args) {
//		new GUI_ThongKeKhachHang().setVisible(true);
//	}

	private void reSizeColumnTable() {
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(70);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThongKe)) {
			tableModel.getDataVector().removeAllElements();
			try {
				Date tuNgay = dpTuNgay.getFullDate();
				Date denNgay = dpDenNgay.getFullDate();
				ArrayList<HoaDonPhong> listHD = hd_DAO.getListHDKHByDate(tuNgay, denNgay);

				if (tuNgay.before(denNgay)) {
//					listHD = getListSearchByDate();
					if (listHD == null || listHD.isEmpty() || listHD.size() <= 0) {
						tableModel.getDataVector().removeAllElements();
						docVaoModal(listHD);
						JOptionPane.showMessageDialog(this, "Khong tim thay thong tin hop le");
					} else {
						docVaoModal(listHD);
					}
				} else {
					if (denNgay.before(tuNgay)) {
						dpDenNgay.setValueToDay();
						JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu",
								"Cảnh báo", JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		// Menu
		else if (o.equals(itemDatPhong)) {
			this.dispose();
			new GUI_DatPhong().setVisible(true);
		} else if (o.equals(itemQuanLyDichVu)) {
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
//		} else if (o.equals(itemThongKeKhachHang)) {
//			this.dispose();
//			new GUI_ThongKeKhachHang().setVisible(true);
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

	private void docVaoModal(ArrayList<HoaDonPhong> listHD) {
		DecimalFormat df = new DecimalFormat("#,###.##");
		Double s = 0.0;
		for (HoaDonPhong item : listHD) {
			Phong phong = item.getPhong();
			LoaiPhong lPhong = item.getPhong().getLoaiPhong();
			KhachHang kh = item.getKhachHang();
			int soNgay = (int) tinhSoNgay(item.getNgayGioNhan(), item.getNgayGioTra());
			Double thanhTien = lPhong.getDonGia() * soNgay;
			String tien = df.format(thanhTien);
			s += thanhTien;

			String donGia = df.format(lPhong.getDonGia());
			tableModel.addRow(new Object[] { item.getMaHoaDon(), phong.getMaPhong(), lPhong.getTenLoaiPhong(), donGia,
					item.getNgayGioNhan(), item.getNgayGioTra(), soNgay, tien, kh.getMaKhachHang(),
					kh.getTenKhachHang() });
		}
		String thanhTien = df.format(s);
		txtTongDoanhThu.setText(thanhTien);
	}

	private long tinhSoNgay(Date tuNgay, Date denNgay) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		long millis = System.currentTimeMillis();
		if (tuNgay == null) {
			tuNgay = new Date(millis);
		}
		if (denNgay == null) {
			denNgay = new Date(millis);
		}
		cal1.setTime(tuNgay);
		cal2.setTime(denNgay);
		long result = (cal2.getTime().getTime() - cal1.getTime().getTime()) / (24 * 3600 * 1000);

		return result <= 0 ? 1 : result;
	}

}
