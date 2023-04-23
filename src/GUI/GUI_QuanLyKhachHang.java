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
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.DomainCombiner;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
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
import dao.KhachHang_DAO;
import entity.KhachHang;

public class GUI_QuanLyKhachHang extends JFrame implements ActionListener, MouseListener, KeyListener {
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
	private JTextField txtMaKhachHang, txtTenKhachHang, txtCCCD, txtTenKhachHangDSKH;
	private JComboBox<String> cbQuocTich;
	private DatePicker dpNgayHetHanCCCD;

	private DefaultTableModel tableModel;
	private JTable table;

	private KhachHang_DAO kh_DAO;

	private ArrayList<KhachHang> dsKH;
	private final int ADD = 1, UPDATE = 2;

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

		txtMaKhachHang = new JTextField("KH");
		txtMaKhachHang.setEditable(true);
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
		cbQuocTich.setEditable(true);
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

		txtTenKhachHangDSKH = new JTextField();
		txtTenKhachHangDSKH.setBounds(170, 25, 250, 25);
		txtTenKhachHangDSKH.setColumns(10);
		pnlDanhSachKhachHang.add(txtTenKhachHangDSKH);

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
		loadListKhachHang();
		docDuLieuVaoTable();

		// add sự kiện cho button
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTim.addActionListener(this);
		btnXemTatCa.addActionListener(this);
		btnLogout.addActionListener(this);

		// add sự kiện cho table
		table.addMouseListener(this);
		// add sự kiện phím enter

		txtTenKhachHangDSKH.addKeyListener(this);

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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI_QuanLyKhachHang().setVisible(true);
			}
		});
	}

	private void loadListKhachHang() {
		dsKH = kh_DAO.getalltbKhachHang();
	}

	public void docDuLieuVaoTable() {
		if (dsKH == null || dsKH.size() <= 0)
			return;
		for (KhachHang kh : dsKH) {
			String date = formatDate(kh.getNgayHetHanCCCD());
			tableModel.addRow(
					new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getQuocTich(), kh.getCCCD(), date });
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		Object key = e.getKeyCode();
		// Bắt sự kiện nhấn phím enter tự nhấn btnLogin
		if (o.equals(txtTenKhachHangDSKH)) {
			if (key.equals(KeyEvent.VK_ENTER)) {
				btnTim.doClick();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(table)) {
			int row = table.getSelectedRow();
			txtMaKhachHang.setText(tableModel.getValueAt(row, 0).toString());
			txtMaKhachHang.setEditable(false);
			txtTenKhachHang.setText(tableModel.getValueAt(row, 1).toString());
			cbQuocTich.setSelectedItem(tableModel.getValueAt(row, 2).toString());
			txtCCCD.setText(tableModel.getValueAt(row, 3).toString());
			try {
				dpNgayHetHanCCCD.setValue(tableModel.getValueAt(row, 4).toString());
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			txtMaKhachHang.setText("");
			txtTenKhachHang.setText("");
			cbQuocTich.setSelectedIndex(0);
			txtCCCD.setText("");
			dpNgayHetHanCCCD.setValueToDay();
			txtMaKhachHang.requestFocus();
			txtMaKhachHang.setText("KH");
			txtMaKhachHang.setEditable(true);
		} else if (o.equals(btnThem)) {
			if (validData(ADD)) {

				String maKH = txtMaKhachHang.getText().trim();
				String tenKH = txtTenKhachHang.getText().trim();
				String quocTich = cbQuocTich.getSelectedItem().toString();
				String cccd = txtCCCD.getText().trim();
				Date now = null;
				Date ngayHetHan = null;
				try {
					now = dpNgayHetHanCCCD.getValueToDay();
					ngayHetHan = dpNgayHetHanCCCD.getFullDate();
				} catch (ParseException e3) {
					e3.printStackTrace();
				}
				KhachHang kh = new KhachHang(maKH, tenKH, quocTich, cccd, ngayHetHan);

				try {
					if (kh_DAO.insert(kh)) {
						String date = formatDate(kh.getNgayHetHanCCCD());
						tableModel.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getQuocTich(),
								kh.getCCCD(), date });
						JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
						tableModel.fireTableDataChanged();
						loadListKhachHang();
					}
//					else {
//						JOptionPane.showMessageDialog(this, "Trùng");
//					}

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
				}
			}
		} else if (o.equals(btnSua)) {
			if (validData(UPDATE)) {
				String maKH = txtMaKhachHang.getText().trim();
				String tenKH = txtTenKhachHang.getText().trim();
				String quocTich = cbQuocTich.getSelectedItem().toString();
				String cccd = txtCCCD.getText().trim();
				Date now = null;
				Date ngayHetHan = null;
				try {
					now = dpNgayHetHanCCCD.getValueToDay();
					ngayHetHan = dpNgayHetHanCCCD.getFullDate();
				} catch (ParseException e3) {
					e3.printStackTrace();
				}
				KhachHang kh = new KhachHang(maKH, tenKH, quocTich, cccd, ngayHetHan);

				int row = table.getSelectedRow();
				try {
					boolean result = kh_DAO.update(kh);
					if (result == true) {
						String date = formatDate(kh.getNgayHetHanCCCD());
						tableModel.setValueAt(kh.getMaKhachHang(), row, 0);
						tableModel.setValueAt(kh.getTenKhachHang(), row, 1);
						tableModel.setValueAt(kh.getQuocTich(), row, 2);
						tableModel.setValueAt(kh.getCCCD(), row, 3);
						tableModel.setValueAt(date, row, 4);
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
						tableModel.fireTableDataChanged();
						loadListKhachHang();
					} else {
						JOptionPane.showMessageDialog(this, "Lỗi: Cập nhật thất bại");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			try {
				if (row == -1) {
					JOptionPane.showMessageDialog(this, "Lỗi: Cần chọn dòng muốn xóa");
				} else {
					int select = JOptionPane.NO_OPTION;
					KhachHang kh = getDataInForm();
					String tenKH = kh.getTenKhachHang();
					select = JOptionPane.showConfirmDialog(this, "<html>"
							+ "<p style='text-align: center; font-size: 18px; color:red'>Cảnh báo</p>"
							+ "<p style='text-align: center;'>Xóa khách hành " + "<span style='color: blue'> " + tenKH
							+ "</span>" + " sẽ dẫn đến xóa toàn bộ hóa đơn phòng, hóa đơn dịch vụ có liên quan.</p>"
							+ "<p style='text-align: left;'>Hãy suy nghĩ thật kỹ trước khi quyết định.</p>" + "</html>",
							"Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if (select == JOptionPane.YES_OPTION) {
						kh_DAO.delete(kh);
						tableModel.removeRow(row);
						loadListKhachHang();
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Xóa thất bại");
			}
		} else if (o.equals(btnTim)) {
			if (validDataTim()) {
				String tenkh = txtTenKhachHangDSKH.getText().trim();
				tableModel.getDataVector().removeAllElements();
				tableModel.fireTableDataChanged();
				dsKH = kh_DAO.getListKhachHangByName(tenkh);
				if (dsKH == null || dsKH.size() <= 0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
				} else
					docDuLieuVaoTable();
			}
		} else if (o.equals(btnXemTatCa)) {
			tableModel.getDataVector().removeAllElements();
			tableModel.fireTableDataChanged();
			dsKH = kh_DAO.getalltbKhachHang();
			if (dsKH == null || dsKH.size() <= 0)
				JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
			else
				docDuLieuVaoTable();
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
//		} else if (o.equals(itemQuanLyKhachHang)) {
//			this.dispose();
//			new GUI_QuanLyKhachHang().setVisible(true);
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

	public boolean validData(int type) {
		String maKH = txtMaKhachHang.getText().trim();
		String tenKH = txtTenKhachHang.getText().trim();
		String cmnd = txtCCCD.getText().trim();
		if (!(maKH.length() > 0 && maKH.matches("(KH)\\d{1,4}"))) {
			JOptionPane.showMessageDialog(this, "Lỗi: Mã khách hàng phải là KH1, KH2, KH3...");
			return false;
		} else {
			if (type == ADD)
				for (KhachHang khachHang : dsKH) {
					if (khachHang.getMaKhachHang().equalsIgnoreCase(maKH)) {
						JOptionPane.showMessageDialog(this, "Lỗi: Mã khách hàng đã tồn tại");
						return false;
					}
				}
		}
		if (!(tenKH.length() > 0 && tenKH.matches("^[^0-9]+$"))) {
			JOptionPane.showMessageDialog(this, "Lỗi: Tên không được để trống");
			return false;
		}
		if (!(cmnd.length() > 0 && cmnd.matches("^(\\d{9})$"))) {
			JOptionPane.showMessageDialog(this, "Lỗi: CMND phải có 9 số");
			return false;
		} else {
			if (type == ADD)
				for (KhachHang item : dsKH) {
					if (item.getCCCD().equalsIgnoreCase(cmnd)) {
						JOptionPane.showMessageDialog(this, "Lỗi: CMND hoặc CCCD đã tồn tại");
						return false;
					}
				}
		}
		Date now = null;
		Date ngayHetHan = null;
		try {
			now = dpNgayHetHanCCCD.getValueToDay();
			ngayHetHan = dpNgayHetHanCCCD.getFullDate();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (!ngayHetHan.toString().equals(now.toString()) && ngayHetHan.before(now)) {
			JOptionPane.showMessageDialog(this, "Lỗi: Giấy tờ đã hết hạn");
			return false;
		}
		return true;
	}

	private boolean validDataTim() {
		String TenKH = txtTenKhachHangDSKH.getText().trim();
		if (!(TenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Lỗi: Tên không được để trống");
			return false;
		}
		return true;
	}

	private KhachHang getDataInForm() throws ParseException {
		String maKH = txtMaKhachHang.getText().trim();
		String tenKH = txtTenKhachHang.getText().trim();
		String quocTich = cbQuocTich.getSelectedItem().toString();
		String cccd = txtCCCD.getText().trim();
		Date ngayHetHan = dpNgayHetHanCCCD.getFullDate();
		KhachHang kh = new KhachHang(maKH, tenKH, quocTich, cccd, ngayHetHan);
		return kh;
	}

}
