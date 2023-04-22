package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.HoaDonDichVu;

public class GUI_QuanLyKhachSan extends JFrame implements ActionListener {

	private GUI_DatPhong pageDatPhong = new GUI_DatPhong();
	private GUI_QuanLyDichVu pageQuanLyDichVu = new GUI_QuanLyDichVu();
	private GUI_QuanLyKhachHang pageQuanLyKhachHang = new GUI_QuanLyKhachHang();
	private GUI_ThongKeDichVu pageThongKeDichVu = new GUI_ThongKeDichVu();
	private GUI_ThongKeKhachHang pageThongKeKhachHang = new GUI_ThongKeKhachHang();
	private GUI_QuanLyHoaDonDichVu pageHoaDonDichVu = new GUI_QuanLyHoaDonDichVu();
	private GUI_QuanLyPhong pageQuanLyPhong = new GUI_QuanLyPhong();
	private GUI_DangNhap pageDangNhap = new GUI_DangNhap();

	private JMenuItem itemTrangChu, itemDatPhong, itemQuanLyHoaDon, itemQuanLyPhong, itemQuanLyDichVu,
			itemQuanLyKhachHang, itemQuanLyNhanVien, itemThongKeDichVu, itemThongKeKhachHang, itemThongKeNhanVien;
	private JMenu menuTrangChu, menuDatPhong, menuQuanLyHoaDon, menuQuanLyDichVu, menuQuanLyKhachHang,
			menuQuanLyNhanVien, menuThongKe, subMenu;
	private int x = 0, w = 150, h = 50;
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

	ArrayList<HoaDonDichVu> dsHDDV = new ArrayList<HoaDonDichVu>();
	private JButton btnLogout;

	public GUI_QuanLyKhachSan() {
		JPanel pnlFull = new JPanel();
		pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(7, 0, 200, 650);
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

		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa Đơn");
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
		btnLogout.setBounds(20, 550, 120, 30);
		menuBar.add(btnLogout);
		pnlFull.add(menuBar);

		// Thêm sự kiện click
		itemDatPhong.addActionListener(this);
		itemQuanLyPhong.addActionListener(this);
		itemQuanLyHoaDon.addActionListener(this);
		itemQuanLyDichVu.addActionListener(this);
		itemQuanLyKhachHang.addActionListener(this);
		itemThongKeDichVu.addActionListener(this);
		itemThongKeKhachHang.addActionListener(this);

		pack();
		setTitle("Quản Lý Khách Hàng");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI_QuanLyKhachSan().setVisible(true);
			}
		});
	}

	// public void check
	public String currencyFormat(Double vnd) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(vnd);
	}
	
	private void handleEventBtnLogin() {
		
	}
}
