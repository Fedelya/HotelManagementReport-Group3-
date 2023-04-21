package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;

import entity.Phong;

public class GUI_QuanLyPhong extends JFrame implements MouseListener, ActionListener {

	JButton btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnTim, btnXemTatCa, btnThemPhong;
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

	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtDonGia;
	private JLabel lblDonGia;
	private JLabel lblMaLoaiPhong;
	private JTextField txtTenLoaiPhong;
	private JLabel lblTenLoaiPhong;
	private JTextField txtMaLoaiPhong;
	private JLabel lblMaPhong;
	private JTextField txtMaPhong;
	private JLabel lblvitri;
	private JTextField txtvitri;
	private JComboBox<String> cbcloaiphong;
	private JComboBox<String> cbctinhtrang;
	private JButton btnLamMois;
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

	private LoaiPhong_DAO lp_Dao;
	private ArrayList<LoaiPhong_DAO> dsLP;
	private Phong_DAO phong_Dao;
	private ArrayList<Phong> dsPhong;
	private JTable table1;

	public GUI_QuanLyPhong() {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lp_Dao = new LoaiPhong_DAO();
		phong_Dao = new Phong_DAO();

		setLayout(null);

		JPanel pnlFull = new JPanel();
		pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(7, 0, 200, 650);
		menuBar.setLayout(null);

		JLabel lblUser = new JLabel("Tên Admin");
		lblUser.setBounds(x, 10, w, 70);
		menuBar.add(lblUser);
		lblUser.setIcon(iconUser);

		menuTrangChu = new JMenu("Trang Chủ");

		menuTrangChu.setBounds(x, 100, w, h);
		itemTrangChu = new JMenuItem("Trang chủ");
		menuTrangChu.add(itemTrangChu);
		menuBar.add(menuTrangChu);

		menuDatPhong = new JMenu("Đặt phòng");
		menuDatPhong.setBounds(x, 160, w, h);
		itemDatPhong = new JMenuItem("Đặt phòng");
		menuDatPhong.add(itemDatPhong);
		menuBar.add(menuDatPhong);

		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa Đơn");
		menuQuanLyHoaDon.setBounds(x, 220, w, h);
		itemQuanLyHoaDon = new JMenuItem("Quản lý hóa đơn dịch vụ");
		menuQuanLyHoaDon.add(itemQuanLyHoaDon);
		menuBar.add(menuQuanLyHoaDon);

		menuQuanLyDichVu = new JMenu("Quản Lý Dịch Vụ");
		menuQuanLyDichVu.setBounds(x, 280, w, h);
		itemQuanLyPhong = new JMenuItem("Quản lý phòng");
		itemQuanLyDichVu = new JMenuItem("Quản lý dịch vụ");
		menuQuanLyDichVu.add(itemQuanLyPhong);
		menuQuanLyDichVu.add(itemQuanLyDichVu);
		menuBar.add(menuQuanLyDichVu);

		menuQuanLyKhachHang = new JMenu("Quản Lý Khách Hàng");
		menuQuanLyKhachHang.setBounds(x, 340, w, h);
		itemQuanLyKhachHang = new JMenuItem("Quản lý khách hàng");
		menuQuanLyKhachHang.add(itemQuanLyKhachHang);
		menuBar.add(menuQuanLyKhachHang);

		menuQuanLyNhanVien = new JMenu("Quản Lý Nhân Viên");
		menuQuanLyNhanVien.setBounds(x, 400, w, h);
		itemQuanLyNhanVien = new JMenuItem("Quản lý nhân viên");
		menuQuanLyNhanVien.add(itemQuanLyNhanVien);
		menuBar.add(menuQuanLyNhanVien);

		JMenu menuThongKe = new JMenu("Thống kê");
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

		setTitle("Quản Lý Phòng");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));
		// right
		JLabel lblTitle = new JLabel("Quản Lý Phòng");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);
		JPanel pnlThongTinLoaiPhong = new JPanel();
		pnlThongTinLoaiPhong.setBorder(new TitledBorder(null, "Thông tin loại phòng"));
		pnlThongTinLoaiPhong.setBounds(210, 40, 347, 250);
		pnlFull.add(pnlThongTinLoaiPhong);

		pnlThongTinLoaiPhong.setLayout(null);

		lblMaLoaiPhong = new JLabel("Mã loại phòng:");
		lblMaLoaiPhong.setBounds(10, 20, 100, 30);
		pnlThongTinLoaiPhong.add(lblMaLoaiPhong);

		txtMaLoaiPhong = new JTextField();
		// txtMaLoaiPhong.setEditable(false);
		txtMaLoaiPhong.setBounds(110, 25, 200, 25);
		pnlThongTinLoaiPhong.add(txtMaLoaiPhong);
		txtMaLoaiPhong.setColumns(10);

		lblTenLoaiPhong = new JLabel("Tên loại phòng:");
		lblTenLoaiPhong.setBounds(10, 55, 100, 30);
		pnlThongTinLoaiPhong.add(lblTenLoaiPhong);

		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBounds(110, 60, 200, 25);
		pnlThongTinLoaiPhong.add(txtTenLoaiPhong);
		txtMaLoaiPhong.setColumns(10);

		lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setBounds(10, 90, 100, 30);
		pnlThongTinLoaiPhong.add(lblDonGia);

		txtDonGia = new JTextField();
		txtDonGia.setBounds(110, 95, 200, 25);
		pnlThongTinLoaiPhong.add(txtDonGia);
		// txtDonGia.setColumns(10);

		// Thêm button
		btnThem = new JButton("Add");
		btnThem.setBounds(50, 150, 100, 30);
		btnThem.setIcon(iconThem);
		pnlThongTinLoaiPhong.add(btnThem);

		btnXoa = new JButton("Delete");
		btnXoa.setBounds(200, 150, 100, 30);
		btnXoa.setIcon(iconXoa);
		pnlThongTinLoaiPhong.add(btnXoa);

		btnSua = new JButton("Update");
		btnSua.setBounds(50, 200, 100, 30);
		btnSua.setIcon(iconSua);
		pnlThongTinLoaiPhong.add(btnSua);

		btnLamMoi = new JButton("Refesh");
		btnLamMoi.setBounds(200, 200, 100, 30);
		btnLamMoi.setIcon(iconLamMoi);
		pnlThongTinLoaiPhong.add(btnLamMoi);
		// danh sach loai phong
		JPanel pnldanhsachloaiphong = new JPanel();
		pnldanhsachloaiphong.setBorder(new TitledBorder(null, "Danh Sách Loại Phòng"));
		pnldanhsachloaiphong.setBounds(560, 40, 425, 250);
		pnlFull.add(pnldanhsachloaiphong);

		pnldanhsachloaiphong.setLayout(null);

		lbltimmaloai = new JLabel("Mã loại phòng:");
		lbltimmaloai.setBounds(5, 22, 100, 30);
		pnldanhsachloaiphong.add(lbltimmaloai);

		txttimmaloai = new JTextField();
		txttimmaloai.setBounds(90, 27, 100, 25);
		txttimmaloai.setColumns(10);
		pnldanhsachloaiphong.add(txttimmaloai);

		btnTim = new JButton("Search");
		btnTim.setBounds(194, 25, 100, 30);
		btnTim.setIcon(iconTim);
		pnldanhsachloaiphong.add(btnTim);

		btnXemTatCa = new JButton("Watch All");
		btnXemTatCa.setBounds(300, 25, 120, 30);
		btnXemTatCa.setIcon(iconXemTatCa);
		pnldanhsachloaiphong.add(btnXemTatCa);

		JScrollPane scroll;
		String[] headers = { "Mã Loại phòng", "Tên Loại Phòng", "Đơn Giá" };

		tableModel = new DefaultTableModel(headers, 0);

		pnldanhsachloaiphong.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scroll.setBounds(5, 60, 417, 186);
		// quan ly phong
		JPanel pnlThongTinPhong = new JPanel();
		pnlThongTinPhong.setBorder(new TitledBorder(null, "Thông tin  phòng"));
		pnlThongTinPhong.setBounds(210, 295, 347, 310);
		pnlFull.add(pnlThongTinPhong);

		pnlThongTinPhong.setLayout(null);

		lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setBounds(10, 40, 100, 30);
		pnlThongTinPhong.add(lblMaPhong);

		txtMaPhong = new JTextField();
//		txtMaLoaiPhong.setEditable(false);
		txtMaPhong.setBounds(120, 45, 200, 25);
		pnlThongTinPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		lblvitri = new JLabel("Vị trí phòng:");
		lblvitri.setBounds(10, 75, 100, 30);
		pnlThongTinPhong.add(lblvitri);

		txtvitri = new JTextField();
		txtvitri.setBounds(120, 80, 200, 25);
		pnlThongTinPhong.add(txtvitri);
		txtvitri.setColumns(10);
		lblloaiphong = new JLabel("Loại Phòng:");
		lblloaiphong.setBounds(10, 110, 100, 30);
		pnlThongTinPhong.add(lblloaiphong);
		cbcloaiphong = new JComboBox<String>();
		cbcloaiphong.setBounds(120, 115, 160, 25);
//        cbBoPhan.addItem("");

//		cbcloaiphong.addItem("Giường đơn");
//		cbcloaiphong.addItem("Giường đôi");
//		
		loadDSLPhong();

		pnlThongTinPhong.add(cbcloaiphong);
		lbltinhtrang = new JLabel("Tình trạng phòng:");
		lbltinhtrang.setBounds(10, 140, 120, 30);
		pnlThongTinPhong.add(lbltinhtrang);
		cbctinhtrang = new JComboBox<String>();
		cbctinhtrang.setBounds(120, 145, 160, 25);
//        cbBoPhan.addItem("");
		cbctinhtrang.addItem("Trống");
		cbctinhtrang.addItem("Đã được đặt");
		cbctinhtrang.addItem("Đang cho thuê");
		pnlThongTinPhong.add(cbctinhtrang);
		// danh sach phong
		JPanel pnldanhsachphong = new JPanel();
		pnldanhsachphong.setBorder(new TitledBorder(null, "Danh Sách Phòng"));
		pnldanhsachphong.setBounds(560, 295, 425, 310);
		pnlFull.add(pnldanhsachphong);

		pnldanhsachphong.setLayout(null);

		lbltimmaphong = new JLabel("Mã Phòng:");
		lbltimmaphong.setBounds(5, 22, 100, 30);
		pnldanhsachphong.add(lbltimmaphong);

		txttimphong = new JTextField();
		txttimphong.setBounds(85, 27, 100, 25);
		txttimphong.setColumns(10);
		pnldanhsachphong.add(txttimphong);

		btnTims = new JButton("Search");
		btnTims.setBounds(190, 25, 100, 30);
		btnTims.setIcon(iconTim);
		pnldanhsachphong.add(btnTims);

		btnXemTatCas = new JButton("Watch All");
		btnXemTatCas.setBounds(300, 25, 120, 30);
		btnXemTatCas.setIcon(iconXemTatCa);
		pnldanhsachphong.add(btnXemTatCas);

		JScrollPane scrolls;
		String[] headerss = { "Mã  phòng", "Vị Trí", "Tình Trạng", "Loại Phòng" };

		tableModels = new DefaultTableModel(headerss, 0);

		pnldanhsachphong.add(scrolls = new JScrollPane(table1 = new JTable(tableModels),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scrolls.setBounds(5, 60, 417, 255);

//		txtDonGia.setColumns(10);

		// Thêm button
		btnThemPhong = new JButton("Add");
		btnThemPhong.setBounds(50, 200, 100, 30);
		btnThemPhong.setIcon(iconThem);
		pnlThongTinPhong.add(btnThemPhong);

		btnXoas = new JButton("Delete");
		btnXoas.setBounds(200, 200, 100, 30);
		btnXoas.setIcon(iconXoa);
		pnlThongTinPhong.add(btnXoas);

		btnSuas = new JButton("Update");
		btnSuas.setBounds(50, 250, 100, 30);
		btnSuas.setIcon(iconSua);
		pnlThongTinPhong.add(btnSuas);

		btnLamMois = new JButton("Refesh");
		btnLamMois.setBounds(200, 250, 100, 30);
		btnLamMois.setIcon(iconLamMoi);
		pnlThongTinPhong.add(btnLamMois);
//		btnXemLichs = new JButton("Xem Lich Đặt");
//		btnXemLichs.setBounds(75, 280, 200, 30);
//		btnXemLichs.setIcon(iconXemTatCa);
//		pnlThongTinPhong.add(btnXemLichs);

		docDuLieuLPVaoTable();
		docDuLieuPhongVaoTable();

		table.addMouseListener(this);
		table1.addMouseListener(this);
		btnTim.addActionListener(this);
		btnTims.addActionListener(this);
		btnXemTatCa.addActionListener(this);
		btnXemTatCas.addActionListener(this);
		btnThem.addActionListener(this);
		btnThemPhong.addActionListener(this);
		btnLamMois.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnLogout.addActionListener(this);
//		btnXemLichs.addActionListener(this);
		btnSua.addActionListener(this);
		btnSuas.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoas.addActionListener(this);
	}

	public static void main(String[] args) {
		new GUI_QuanLyPhong().setVisible(true);
	}

	public void loadDSLPhong() {
		ArrayList<LoaiPhong> listPB = lp_Dao.getallLoaiPhong();
		for (LoaiPhong p : listPB) {
			cbcloaiphong.addItem(p.getTenLoaiPhong());
		}
	}

	public void docDuLieuLPVaoTable() {
		List<LoaiPhong> dsLoaiPhong = lp_Dao.getallLoaiPhong();
		for (LoaiPhong lp : dsLoaiPhong) {
			tableModel.addRow(new Object[] { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getDonGia() });
		}
	}

	private LoaiPhong revertLP() {
		int ma = Integer.parseInt(txtMaLoaiPhong.getText());
		String ten = txtTenLoaiPhong.getText();
		double gia = Double.parseDouble(txtDonGia.getText());
		return new LoaiPhong(ma, ten, gia);
	}

	public void docDuLieuPhongVaoTable() {
		List<Phong> dsPhong = phong_Dao.getallPhong();
		List<LoaiPhong> lp_DAO = lp_Dao.getallLoaiPhong();
		for (Phong p : dsPhong) {

			int maLPhong = p.getLoaiPhong().getMaLoaiPhong();
			String tenLPhong = "";
			for (LoaiPhong i : lp_DAO) {
				if (i.getMaLoaiPhong() == maLPhong) {
					tenLPhong = i.getTenLoaiPhong();
					break;
				}
			}

			tableModels.addRow(new Object[] { p.getMaPhong(), p.getViTri(),
					p.getTinhTrang() == 0 ? "Trống" : p.getTinhTrang() == 1 ? "Đã được đặt" : "Đang cho thuê",
					tenLPhong });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o.equals(btnTim)) {
			int ma = Integer.parseInt(txttimmaloai.getText());
			ArrayList<LoaiPhong> dsLp = lp_Dao.getLoaiPhongTheoMa(ma);

			if (txttimmaloai.getText().trim().equals("")) {
				tableModel.getDataVector().removeAllElements();
				docDuLieuLPVaoTable();

			}

			else if (dsLp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Khong co ma can tim");
			}

			else {
				tableModel.getDataVector().removeAllElements();
				for (LoaiPhong lp : dsLp) {
					tableModel.addRow(new Object[] { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getDonGia() });
				}
			}
		}
		if (o.equals(btnTims)) {
			String ma = txttimphong.getText();
			ArrayList<Phong> listP = phong_Dao.getListPhongByID(ma);

			if (txttimphong.getText().trim().equals("")) {
				tableModels.getDataVector().removeAllElements();
				docDuLieuPhongVaoTable();

			}

			else if (listP == null) {
				JOptionPane.showMessageDialog(this, "Khong co ma can tim");
			}

			else {
				tableModels.getDataVector().removeAllElements();
				List<LoaiPhong> lp_DAO = lp_Dao.getallLoaiPhong();
				for (Phong p : listP) {

					int maLPhong = p.getLoaiPhong().getMaLoaiPhong();
					String tenLPhong = "";
					for (LoaiPhong i : lp_DAO) {
						if (i.getMaLoaiPhong() == maLPhong) {
							tenLPhong = i.getTenLoaiPhong();
							break;
						}
					}

					tableModels.addRow(new Object[] { p.getMaPhong(), p.getViTri(),
							p.getTinhTrang() == 0 ? "Trống" : p.getTinhTrang() == 1 ? "Đã được đặt" : "Đang cho thuê",
							tenLPhong });
				}

			}
		} else if (o.equals(btnXemTatCa)) {
			tableModel.getDataVector().removeAllElements();
			docDuLieuLPVaoTable();
		}

		else if (o.equals(btnXemTatCas)) {
			tableModels.getDataVector().removeAllElements();
			docDuLieuPhongVaoTable();
		}

		else if (o.equals(btnLamMoi)) {
			txtMaLoaiPhong.setText("");
			txtTenLoaiPhong.setText("");
			txtDonGia.setText("");
		}

		else if (o.equals(btnLamMois)) {
			txtMaPhong.setText("");
			txtvitri.setText("");
			cbcloaiphong.setSelectedIndex(0);
			cbctinhtrang.setSelectedIndex(0);
		}

		else if (o.equals(btnThem)) {
			int ma = Integer.parseInt(txtMaLoaiPhong.getText());
			String ten = txtTenLoaiPhong.getText();
			double donGia = Double.parseDouble(txtDonGia.getText());
			LoaiPhong lp = new LoaiPhong(ma, ten, donGia);

			try {
				lp_Dao.insert(lp);
				tableModel.addRow(new Object[] { lp.getMaLoaiPhong(), lp.getTenLoaiPhong(), lp.getDonGia() });
				JOptionPane.showMessageDialog(this, "them thanh cong");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}
		}

		else if (o.equals(btnThemPhong)) {
			String ma = txtMaPhong.getText();
			String viTri = txtvitri.getText();
			int loaiPhong = cbcloaiphong.getSelectedIndex();
			int tinhTrang = cbctinhtrang.getSelectedIndex();

			Phong p = new Phong(ma, viTri, tinhTrang, new LoaiPhong(loaiPhong + 1));
			try {
				phong_Dao.insert(p);
				tableModels.getDataVector().removeAllElements();
				docDuLieuPhongVaoTable();
				JOptionPane.showMessageDialog(this, "them thanh cong");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}

		}

		else if (o.equals(btnSua)) {
			int row = table.getSelectedRow();
			int ma = Integer.parseInt(txtMaLoaiPhong.getText());
			String ten = txtTenLoaiPhong.getText();
			double gia = Double.parseDouble(txtDonGia.getText());
			if (row >= 0) {
				LoaiPhong lp = new LoaiPhong(ma, ten, gia);
				System.out.println(lp.toString());
				if (lp_Dao.update(lp)) {
					table.setValueAt(txtTenLoaiPhong.getText(), row, 1);
					;
					table.setValueAt(txtDonGia.getText(), row, 2);
					JOptionPane.showMessageDialog(this, "Sua thanh cong");
				} else {
					JOptionPane.showMessageDialog(this, "Sua that bai");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chon dong can xoa");
			}
		}

		else if (o.equals(btnSuas)) {
			int row = table1.getSelectedRow();

			String ma = txtMaPhong.getText();
			String viTri = txtvitri.getText();
			int loaiPhong = cbcloaiphong.getSelectedIndex();
			int tinhTrang = cbctinhtrang.getSelectedIndex();

			if (row >= 0) {
				Phong p = new Phong(ma, viTri, tinhTrang, new LoaiPhong(loaiPhong + 1));
				if (phong_Dao.update(p)) {
					table1.setValueAt(txtvitri.getText(), row, 1);
					table1.setValueAt(cbctinhtrang.getSelectedItem().toString(), row, 2);
					table1.setValueAt(cbcloaiphong.getSelectedItem().toString(), row, 3);

					JOptionPane.showMessageDialog(this, "Sua thanh cong");
				} else {
					JOptionPane.showMessageDialog(this, "Sua that bai");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chon dong can sua");
			}
		}

		else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			try {
				if (row == -1) {
					JOptionPane.showMessageDialog(this, "Chon dong can xoa");
				} else {
					LoaiPhong lp = null;
					lp = getDataInFormLPhong();
					int ma = lp.getMaLoaiPhong();
					int count = lp_Dao.getCountPhongByMaLoaiPhong(ma);
					if (count > 0) {
						JOptionPane.showMessageDialog(this,
								"Vẫn còn phòng thuộc loại phòng này. Vui lòng chuyển các phòng thuộc loại phòng '"
										+ lp.getTenLoaiPhong() + "' sang loại phòng khác trước khi xóa",
								"Cảnh báo", JOptionPane.YES_NO_OPTION);
					} else {
						int ans = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
								JOptionPane.YES_NO_OPTION);
						if (ans == JOptionPane.YES_OPTION) {
							lp_Dao.delete(lp.getMaLoaiPhong());
							tableModel.removeRow(row);
							JOptionPane.showMessageDialog(this, "Xóa thành công");
							cbcloaiphong.removeAllItems();
							loadDSLPhong();
						}
					}
				}
			} catch (Exception e3) {
				JOptionPane.showMessageDialog(this, "Xoa khong thanh cong");
			}

		}

		else if (o.equals(btnXoas)) {
			int row = table1.getSelectedRow();
			try {
				if (row == -1) {
					JOptionPane.showMessageDialog(this, "Chon dong can xoa");

				} else {
					int select = JOptionPane.NO_OPTION;
					String ma = txtMaPhong.getText();
					String viTri = txtvitri.getText();
					int loaiPhong = cbcloaiphong.getSelectedIndex();
					int tinhTrang = cbctinhtrang.getSelectedIndex();

					Phong phong = new Phong(ma, viTri, tinhTrang, new LoaiPhong(loaiPhong + 1));
					int ans = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (ans == JOptionPane.YES_OPTION) {
						phong_Dao.delete(phong.getMaPhong());
						tableModels.removeRow(row);
						JOptionPane.showMessageDialog(this, "Xóa thành công");
						cbcloaiphong.removeAllItems();
						loadDSLPhong();
					}
				}
			} catch (Exception e3) {
				JOptionPane.showMessageDialog(this, "Xoa thanh cong");
			}

		}
	}

	public LoaiPhong getDataInFormLPhong() {
		int maLPhong = Integer.parseInt(txtMaLoaiPhong.getText().trim());
		String tenLPhong = txtTenLoaiPhong.getText().trim();
		Double donGia = Double.parseDouble(txtDonGia.getText());
		LoaiPhong p = new LoaiPhong(maLPhong, tenLPhong, donGia);
		return p;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

		if (o.equals(table)) {
			int row = table.getSelectedRow();
			txtMaLoaiPhong.setText(tableModel.getValueAt(row, 0).toString());
			txtTenLoaiPhong.setText(tableModel.getValueAt(row, 1).toString());
			txtDonGia.setText(tableModel.getValueAt(row, 2).toString());

		}

		else if (o.equals(table1)) {
			int row1 = table1.getSelectedRow();
			txtMaPhong.setText(tableModels.getValueAt(row1, 0).toString());
			txtvitri.setText(tableModels.getValueAt(row1, 1).toString());
			cbctinhtrang.setSelectedItem(tableModels.getValueAt(row1, 2).toString());
			cbcloaiphong.setSelectedItem(tableModels.getValueAt(row1, 3).toString());
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

}
