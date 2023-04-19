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
import java.security.DomainCombiner;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import dao.KhachHang_DAO;
import entity.KhachHang;

public class GUI_QuanLyKhachHang extends JFrame {
	private JButton btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnTim, btnXemTatCa;
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

	private JLabel lblMaKhachHang, lblTenKhachHang, lblCCCD, lblNgayHetHanCCCD, lblQuocTich;
	private JTextField txtMaKhachHang, txtTenKhachHang, txtCCCD;
	private JComboBox<String> cbQuocTich;
	private DatePicker dpNgayHetHanCCCD;

	private DefaultTableModel tableModel;
	private JTable table;

	private KhachHang_DAO kh_DAO;

	private ArrayList<KhachHang> list;
	public GUI_QuanLyKhachHang() {
		// Phần Left

//		setLayout(null);
////		JMenuBar menuBar = new JMenuBar();
////		menuBar.setBounds(0, 0, 300, 600);
//
//		JPanel pnlFull = new JPanel();
//		pnlFull.setLayout(null);
//		pnlFull.setBounds(0, 0, 1000, 650);
//		
//		JLabel lblUser = new JLabel("Tên Nhân Viên");
//		lblUser.setBounds(x, 10, 200, 70);
//		pnlFull.add(lblUser);
//		lblUser.setIcon(iconUser);
//		
//		
//		menuTrangChu = new JMenu("Trang Chủ");
//
////		menuTrangChu.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuTrangChu.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuTrangChu.setBounds(x, 100, w, h);
////		menuBar.add(menuTrangChu);
//		itemTrangChu = new JMenuItem("Trang Chủ");
//		menuTrangChu.add(itemTrangChu);
//		pnlFull.add(menuTrangChu);
//
////            JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
////            bar.add(sep1, "growy");
//		menuDatPhong = new JMenu("Đặt phòng");
////		menuDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
////		menuBar.add(menuDatPhong);
//		menuDatPhong.setBounds(x, 160, w, h);
//		pnlFull.add(menuDatPhong);
//
//		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa Đơn");
////		menuQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuQuanLyHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
////		menuBar.add(menuQuanLyHoaDon);
//		menuQuanLyHoaDon.setBounds(x, 220, w, h);
//		pnlFull.add(menuQuanLyHoaDon);
//
//		menuQuanLyDichVu = new JMenu("Quản Lý Dịch Vụ");
////		menuQuanLyDichVu.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuQuanLyDichVu.setVerticalTextPosition(SwingConstants.BOTTOM);
////		menuBar.add(menuQuanLyDichVu);
//		menuQuanLyDichVu.setBounds(x, 280, w, h);
//		pnlFull.add(menuQuanLyDichVu);
//
////            JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
////            bar.add(sep2, "growy");
//
//		menuQuanLyKhachHang = new JMenu("Quản Lý Khách Hàng");
////		menuQuanLyKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuQuanLyKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
////		menuBar.add(menuQuanLyKhachHang);
//		menuQuanLyKhachHang.setBounds(x, 340, w, h);
//		pnlFull.add(menuQuanLyKhachHang);
//
////		menuQuanLyNhanVien = new JMenu("Quản Lý Nhân Viên");
//////		menuQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
//////		menuQuanLyNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
//////		menuBar.add(menuQuanLyNhanVien);
////		menuQuanLyNhanVien.setBounds(x, 400, w, h);
////		pnlFull.add(menuQuanLyNhanVien);
//
//		JMenu menuThongKe = new JMenu("Thống kê");
////		menuThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
////		menuThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
////		menuBar.add(menuThongKe);
//		menuThongKe.setBounds(x, 400, w, h);
//		pnlFull.add(menuThongKe);

//		btnLogout = new JButton("Log out");
//		btnLogout.setIcon(iconLogout);
//		btnLogout.setBounds(20, 530, 120, 30);
//		pnlFull.add(btnLogout);
//		setLayout(null);

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		kh_DAO = new KhachHang_DAO();

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
		// Phần Right
		JLabel lblTitle = new JLabel("Quản Lý Khách Hàng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);

		JPanel pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBorder(new TitledBorder(null, "Thông tin khách hàng"));
		pnlThongTinKhachHang.setBounds(230, 40, 750, 200);
		pnlFull.add(pnlThongTinKhachHang);

		pnlThongTinKhachHang.setLayout(null);

		lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(10, 20, 100, 30);
		pnlThongTinKhachHang.add(lblMaKhachHang);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setBounds(110, 25, 250, 25);
		pnlThongTinKhachHang.add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(10, 55, 100, 30);
		pnlThongTinKhachHang.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(110, 60, 250, 25);
		pnlThongTinKhachHang.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblQuocTich = new JLabel("Quốc tịch:");
		lblQuocTich.setBounds(10, 90, 100, 30);
		pnlThongTinKhachHang.add(lblQuocTich);

		cbQuocTich = new JComboBox<String>();
		cbQuocTich.setBounds(110, 95, 160, 25);
//        cbQuocTich.addItem("");
        cbQuocTich.addItem("Việt Nam");
        cbQuocTich.addItem("Nước ngoài");
		pnlThongTinKhachHang.add(cbQuocTich);

		lblCCCD = new JLabel("CCCD/Hộ chiếu:");
		lblCCCD.setBounds(390, 20, 100, 30);
		pnlThongTinKhachHang.add(lblCCCD);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(490, 25, 250, 25);
		pnlThongTinKhachHang.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblNgayHetHanCCCD = new JLabel("Ngày hết hạn CCCD: ");
		lblNgayHetHanCCCD.setBounds(390, 55, 250, 30);
		pnlThongTinKhachHang.add(lblNgayHetHanCCCD);

		dpNgayHetHanCCCD = new DatePicker(205);
		dpNgayHetHanCCCD.setBounds(520, 60, 250, 25);
		pnlThongTinKhachHang.add(dpNgayHetHanCCCD);

		// Thêm Button
		btnThem = new JButton("Add");
		btnThem.setBounds(130, 150, 100, 30);
		btnThem.setIcon(iconThem);
		pnlThongTinKhachHang.add(btnThem);

		btnXoa = new JButton("Delete");
		btnXoa.setBounds(260, 150, 100, 30);
		btnXoa.setIcon(iconXoa);
		pnlThongTinKhachHang.add(btnXoa);

		btnSua = new JButton("Update");
		btnSua.setBounds(390, 150, 100, 30);
		btnSua.setIcon(iconSua);
		pnlThongTinKhachHang.add(btnSua);

		btnLamMoi = new JButton("Refesh");
		btnLamMoi.setBounds(520, 150, 100, 30);
		btnLamMoi.setIcon(iconLamMoi);
		pnlThongTinKhachHang.add(btnLamMoi);

		JPanel pnlDanhSachKhachHang = new JPanel();
		pnlDanhSachKhachHang.setBorder(new TitledBorder(null, "Danh Sách Khách Hàng"));
		pnlDanhSachKhachHang.setBounds(230, 250, 750, 360);
		pnlFull.add(pnlDanhSachKhachHang);

		pnlDanhSachKhachHang.setLayout(null);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(60, 20, 100, 30);
		pnlDanhSachKhachHang.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(170, 25, 250, 25);
		txtTenKhachHang.setColumns(10);
		pnlDanhSachKhachHang.add(txtTenKhachHang);

		btnTim = new JButton("Search");
		btnTim.setBounds(430, 22, 100, 30);
		btnTim.setIcon(iconTim);
		pnlDanhSachKhachHang.add(btnTim);

		btnXemTatCa = new JButton("Watch All");
		btnXemTatCa.setBounds(540, 22, 150, 30);
		btnXemTatCa.setIcon(iconXemTatCa);
		pnlDanhSachKhachHang.add(btnXemTatCa);

		JScrollPane scroll;
		String[] headers = { "Mã khách hàng", "Tên khách hàng", "Quốc tịch", "CCCD/Hộ Chiếu", "Ngày hết hạn CCCD" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlDanhSachKhachHang.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scroll.setBounds(5, 60, 740, 300);

//		setJMenuBar(menuBar);
		pack();
		setTitle("Quản Lý Khách Hàng");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));

		// Đọc dữ liệu từ database SQL vào JTable
		docDuLieuVaoTable();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI_QuanLyKhachHang().setVisible(true);
			}
		});
	}

	public void docDuLieuVaoTable() {
		List<KhachHang> list = kh_DAO.getalltbKhachHang();
		for (KhachHang kh : list) {
			String date = formatDate(kh.getNgayHetHanCCCD());
			tableModel.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getQuocTich(), kh.getCCCD(),
					date });
		}
	}
	
	private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
        return sdf.format(date);
    }
//	class Horizontal extends JMenu{
//		public void HorizontalMenu(String label){
//			JPopupMenu pm = getPopupMenu();
//			pm.setLayout(new BoxLayout(pm, BoxLayout.LINE_AXIS));
//		}
//	}
//	
//	public Dimension getMinimumSize() {
//		return getPreferredSize();
//	}
//	
//	public Dimension getMaximumSize() {
//		return getPreferredSize();
//	}
//	
//	public void setPopupMenuVisible(boolean b) {
//		
//	}
}
