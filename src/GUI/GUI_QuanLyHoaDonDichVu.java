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
import entity.DichVu;
import entity.HoaDonDichVu;
import entity.KhachHang;

public class GUI_QuanLyHoaDonDichVu extends JFrame implements ActionListener, MouseListener {
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
	private HoaDonDichVu_DAO HDDV_dao;
	private ChiTietDichVu_DAO ctDV_dao;
	private KhachHang_DAO kh_dao;
	private DichVu_DAO dv_dao;
	private JTextField txtMaHDDV;

	public GUI_QuanLyHoaDonDichVu() {
		// Phần Left
		dsKH = new ArrayList<KhachHang>();
		dsCTDV = new ArrayList<ChiTietDichVu>();
		dsDV = new ArrayList<DichVu>();
		ctDV_dao = new ChiTietDichVu_DAO();
		kh_dao = new KhachHang_DAO();
		dv_dao = new DichVu_DAO();

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HDDV_dao = new HoaDonDichVu_DAO();

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
		cboMaKhachHang.setBounds(145, 25, 195, 25);
		cboMaKhachHang.addItem("");
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
		txtGia.setBounds(565, 70, 160, 25);
		pnlThongTin.add(txtGia);

		// Thêm Button
		btnThem = new JButton("Add");
		btnThem.setBounds(100, 120, 200, 30);
		btnThem.setIcon(iconThem);
		pnlThongTin.add(btnThem);

		btnLamMoi = new JButton("Refesh");
		btnLamMoi.setBounds(400, 120, 200, 30);
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

		btnTim = new JButton("Search");
		btnTim.setBounds(350, 22, 110, 30);
		btnTim.setIcon(iconTim);
		pnlDanhSachHoaDon.add(btnTim);

		btnXemTatCa = new JButton("See All");
		btnXemTatCa.setBounds(480, 22, 110, 30);
		btnXemTatCa.setIcon(iconXemTatCa);
		pnlDanhSachHoaDon.add(btnXemTatCa);

		btnBoChon = new JButton("Bỏ chọn");
		btnBoChon.setBounds(610, 22, 110, 30);
		btnBoChon.setIcon(iconXoa);
		pnlDanhSachHoaDon.add(btnBoChon);

//		setJMenuBar(menuBar);
		pack();
		setTitle("Quản Lý Khách Hàng");
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
			break;
		}
	}

	public void docDuLieuVaoTableHDDV() {
		List<HoaDonDichVu> list = HDDV_dao.getalltbHoaDonDichVu();
		for (HoaDonDichVu hddv : list) {
			String date = formatDate(hddv.getNgayGioDat());
			tableModelHD.addRow(new Object[] { hddv.getMaHoaDonDichVu(), hddv.getKhachHang().getMaKhachHang(), date,
					hddv.getMaHoaDonDichVu(), hddv.getTinhTrang() });
		}
	}

	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		return sdf.format(date);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
//		if (o.equals(btnThem)) {
//			
//		}
		if (o.equals(cboMaKhachHang)) {
			int indx = cboMaKhachHang.getSelectedIndex();
			if (indx == -1) {
				txtTenKhachHang.setText("");
			} else {
				String ten = String.valueOf(dsKH.get(indx).getTenKhachHang());
				txtTenKhachHang.setText(ten);
			}
		}
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
