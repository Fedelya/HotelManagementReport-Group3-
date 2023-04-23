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
import entity.HoaDonDichVu;
import entity.HoaDonPhong;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;

public class GUI_DatPhong extends JFrame implements ActionListener{
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
//	private ArrayList<HoaDonPhong> listHDP;
	private ArrayList<LoaiPhong> listLP;
	private ArrayList<KhachHang> listKH;
	private ArrayList<Phong> listPhong;

//	private DefaultComboBoxModel<String> modelMaPhong;
//	private DefaultComboBoxModel<String> modelMaKH;
//	private DefaultComboBoxModel<String> modelLoaiKH;

	public GUI_DatPhong() {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		hdp_dao = new HoaDonPhong_DAO();
		kh_dao = new KhachHang_DAO();
		phong_dao = new Phong_DAO();
		loaiPhong_dao = new LoaiPhong_DAO();

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
		JLabel lblTitle = new JLabel("Quản Lý Đặt Hàng");
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
		cboMaKhachHang.setBounds(125, 25, 195, 25);
		pnlThongTin.add(cboMaKhachHang);

		lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setBounds(7, 55, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(125, 55, 195, 25);
		pnlThongTin.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		lblTenKhachHang = new JLabel("Cmnd:");
		lblTenKhachHang.setBounds(10, 85, 100, 30);
		pnlThongTin.add(lblTenKhachHang);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(125, 83, 195, 25);
		pnlThongTin.add(txtCCCD);
		txtCCCD.setColumns(10);

		txtCCCD = new JTextField();
		txtCCCD.setBounds(490, 25, 250, 25);
		pnlThongTin.add(txtCCCD);
		txtCCCD.setColumns(10);

		lblNgayHetHanCCCD = new JLabel("Ngày hết hạn CCCD: ");
		lblNgayHetHanCCCD.setBounds(7, 110, 250, 30);
		pnlThongTin.add(lblNgayHetHanCCCD);

		dpNgayHetHanCCCD = new DatePicker(205);
		dpNgayHetHanCCCD.setBounds(125, 115, 200, 25);
		pnlThongTin.add(dpNgayHetHanCCCD);

		lblTenKhachHang = new JLabel("Loại khách hàng:");
		lblTenKhachHang.setBounds(7, 140, 100, 20);
		pnlThongTin.add(lblTenKhachHang);

		jcbLoaiKH = new JComboBox<String>();
		jcbLoaiKH.setBounds(125, 140, 195, 25);
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

		dpNgayHetHanCCCD = new DatePicker(205);
		dpNgayHetHanCCCD.setBounds(125, 200, 200, 25);
		pnlThongTin.add(dpNgayHetHanCCCD);

		lblNgayHetHanCCCD = new JLabel("Ngày đến: ");
		lblNgayHetHanCCCD.setBounds(7, 220, 250, 30);
		pnlThongTin.add(lblNgayHetHanCCCD);

		dpNgayHetHanCCCD = new DatePicker(205);
		dpNgayHetHanCCCD.setBounds(125, 225, 200, 25);
		pnlThongTin.add(dpNgayHetHanCCCD);

		jckKH1st = new JCheckBox("Khách hàng mới");
		jckKH1st.setBounds(100, 255, 250, 30);
		pnlThongTin.add(jckKH1st);

		// Thêm Button
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
		String[] headersHD = { "Mã hóa đơn", "Mã khách hàng", "tên khách hàng", "Mã phòng", "Loại phòng", "Ngày đến",
				"Ngày đi", "Tình trạng" };

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
		jcbLoc.addItem("Tên Khách Hàng");
		jcbLoc.setBounds(600, 22, 150, 30);
		pnlDanhSachHoaDon.add(jcbLoc);

//		setJMenuBar(menuBar);
		pack();
		setTitle("Quản Lý Đặt Phòng");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));

		docDuLieuVaoTable();
		docDSPhong();
		
		jckKH1st.addActionListener(this);
	}

	public static void main(String[] args) {
		new GUI_DatPhong().setVisible(true);

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
			tableModelHD.addRow(new Object[] { hdp.getMaHoaDon(), hdp.getKhachHang().getMaKhachHang(), tenKH,
					hdp.getPhong().getMaPhong(),tenLPhong , date1, date2, hdp.getTinhTrang() });

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
			tableModel.addRow(new Object[] {p.getMaPhong(), tenLPhong,p.getViTri(),dongia});

		}
	}
//	public void docHoaDon() {
//		tableModelHD.setRowCount(0);
//		for(int i=0;i<listHDP.size();i++) {
//			int MaHD = listHDP.get(i).getMaHoaDon();
//			String MaKH = listHDP.get(i).getKhachHang().getMaKhachHang();
//			String tenKH = listHDP.get(i).getKhachHang().getTenKhachHang();
//			Phong phong = listHDP.get(i).getPhong();
//			Date NgayGioNhan = listHDP.get(i).getNgayGioNhan();
//			Date NgayGioTra = listHDP.get(i).getNgayGioTra();
//			
//			String tinhTrang = "Đã đặt phòng";
//			
//			if(listHDP.get(i).getTinhTrang() == 1) {
//				tinhTrang = "Đã nhận phòng";
//			}else if(listHDP.get(i).getTinhTrang() == 0) {
//				tinhTrang = "Đã thanh toán";
//			}
//			tableModelHD.addRow(new Object[] { MaHD, MaKH,tenKH, phong.getMaPhong(),phong.getLoaiPhong(),
//					NgayGioNhan,NgayGioTra,tinhTrang});
//			if(this.maHD == MaHD) {
//				tableHD.addRowSelectionInterval(i, i);
//			}
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		long ml = System.currentTimeMillis();
		ml = ml/86400000*86400000;
		Date now = new Date(ml);
		if(o.equals(btnThem)) {
			if(jckKH1st.isSelected()) {
				if(txtTenKhachHang.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống");
					return;
				}
				if(!txtTenKhachHang.getText().matches("^[0-9]{2,25}$")) {
					JOptionPane.showMessageDialog(this, "Tên khách hàng không được chứa số và có ít nhất 2 kí tự");
					txtTenKhachHang.selectAll();
					txtTenKhachHang.requestFocus();
					return;
				}
				if(txtCCCD.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "CCCD không được để trống");
					return;
				}
				if(!txtCCCD.getText().matches("^(\\d{9}|\\d{12}$)")) {
					JOptionPane.showMessageDialog(this, "CCCD chỉ được chứa chữ số, bao gồm hoặc 12 kí tự");
					txtCCCD.selectAll();
					txtCCCD.requestFocus();
					return;
				}
			}else {
				if(cboMaKhachHang.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống");
				}
			}
			Date ngayHetHan = new Date(ml);
			try {
				ngayHetHan = dpNgayHetHanCCCD.getFullDate();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			if(!ngayHetHan.toString().equals(now.toString())&&ngayHetHan.before(now)) {
				JOptionPane.showMessageDialog(this, "Giất tờ đã hết hạn, Không thể đặt phòng");
				return;
			}
			
			Date tuNgay = new Date(ml);
			Date denNgay = new Date(ml);
//			try {
//                tuNgay = tuNgay.getFullDate();
//                denNgay = dpTuNgay.getFullDate(); 
//            } catch (ParseException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
		}
	}
}
