package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import connectDB.ConnectDB;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;

public class GUI_TrangChu extends JFrame implements ActionListener {
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
	private ImageIcon iconGreenCheck = new ImageIcon(
			new ImageIcon("picture/check.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	private ImageIcon iconQuestion = new ImageIcon(
			new ImageIcon("picture/question_16.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	private ImageIcon iconRedClose = new ImageIcon(
			new ImageIcon("picture/close.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));

	private JButton btnLogout;
	private DefaultComboBoxModel<String> modelLoaiPhong;
	private JComboBox<String> cbLoaiPhong;

	private Phong_DAO phong_DAO;
	private LoaiPhong_DAO loaiPhong_DAO;
	private ArrayList<Phong> dsPhong;
	private ArrayList<LoaiPhong> dsLP;
	private JButton[] btnPhong;

	private JLabel lblAvail, lblBooking, lblUsing;

	private int countAvail = 0, countBooking = 0, countUsing = 0;
	private JPanel pnlDanhSachPhong;
	private JPanel pnlPhongTrong;
	private JPanel pnlTrangChu;
	private JLabel lblLoai;
	private JLabel lblMaPhong;

	GUI_TrangChu() {
		// Kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		phong_DAO = new Phong_DAO();
		loaiPhong_DAO = new LoaiPhong_DAO();
		dsPhong = phong_DAO.getallPhong();
		dsLP = loaiPhong_DAO.getallLoaiPhong();

		// Phần Left
		JPanel pnlFull = new JPanel();
		pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(7, 0, 200, 650);
//		menuBar.setLayout(new GridLayout(0, 1));
		menuBar.setLayout(null);

		JLabel lblUser = new JLabel("admin");
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

		// Phần right

		pnlTrangChu = new JPanel();
		pnlTrangChu.setLayout(null);
		pnlTrangChu.setBounds(220, 0, 765, 650);
		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setBounds(280, 20, 80, 30);
		pnlTrangChu.add(lblLoaiPhong);
		modelLoaiPhong = new DefaultComboBoxModel<String>();
		cbLoaiPhong = new JComboBox<String>(modelLoaiPhong);
		cbLoaiPhong.setBounds(360, 25, 90, 25);

		pnlTrangChu.add(cbLoaiPhong);

		// Số phòng trống
		lblAvail = new JLabel("Phòng trống(20)", JLabel.CENTER);
		lblAvail.setIcon(iconGreenCheck);
//		lblAvail.setBorder(BorderFactory.createEtchedBorder());
		lblAvail.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblAvail.setBounds(120, 60, 150, 30);
		pnlTrangChu.add(lblAvail);

		// Số phòng đã được đặt
		lblBooking = new JLabel("Đã đặt(20)", JLabel.CENTER);
		lblBooking.setIcon(iconQuestion);
//		lblAvail.setBorder(BorderFactory.createEtchedBorder());
		lblBooking.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblBooking.setBounds(300, 60, 150, 30);
		pnlTrangChu.add(lblBooking);

		// Số phòng đang dùng
		lblUsing = new JLabel("Đang ở(20)", JLabel.CENTER);
		lblUsing.setIcon(iconRedClose);
//		lblAvail.setBorder(BorderFactory.createEtchedBorder());
		lblUsing.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblUsing.setBounds(480, 60, 150, 30);
		pnlTrangChu.add(lblUsing);

		// Hiển thị các phòng

		pnlDanhSachPhong = new JPanel();
		pnlDanhSachPhong.setLayout(new BoxLayout(pnlDanhSachPhong, BoxLayout.Y_AXIS));
		pnlFull.add(pnlDanhSachPhong);

		JLabel lblDanhSachPhong = new JLabel("Tình trạng phòng");
		lblDanhSachPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDanhSachPhong.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		lblDanhSachPhong.setBounds(330, 90, 200, 30);
		pnlTrangChu.add(lblDanhSachPhong);
		pnlTrangChu.add(space(10, 10));
		pnlTrangChu.add(pnlDanhSachPhong);

		// Danh sách phòng trống
		pnlPhongTrong = new JPanel();
		pnlPhongTrong.setBounds(60, 150, 650, 450);
		pnlDanhSachPhong.add(pnlPhongTrong);
		GridLayout grid_Phong = new GridLayout(0, 3);
		grid_Phong.setHgap(10);
		grid_Phong.setVgap(10);
		pnlPhongTrong.setLayout(grid_Phong);

		pnlTrangChu.revalidate();
		pnlTrangChu.repaint();

		btnPhong = new JButton[dsPhong.size()];
		for (int i = 0; i < dsPhong.size(); i++) {
			Phong phong = dsPhong.get(i);
			int j = i;
			btnPhong[i] = new JButton();
			pnlPhongTrong.add(btnPhong[i]);
			btnPhong[i].setLayout(new BoxLayout(btnPhong[i], BoxLayout.Y_AXIS));
			btnPhong[i].setAlignmentX(CENTER_ALIGNMENT);
			btnPhong[i].setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

			lblMaPhong = new JLabel(String.valueOf(phong.getMaPhong()));
			lblMaPhong.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblMaPhong.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
			lblMaPhong.setForeground(Color.WHITE);

			int maLP = phong.getLoaiPhong().getMaLoaiPhong();
			String tenLP = "";
			for (LoaiPhong lp : dsLP) {
				if (lp.getMaLoaiPhong() == maLP) {
					tenLP = lp.getTenLoaiPhong();
					break;
				}
			}
			lblLoai = new JLabel(tenLP);
//			System.out.println(tenLP);
			lblLoai.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
			lblLoai.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblLoai.setForeground(Color.WHITE);

			JLabel lblIcon;
			if (phong.getTinhTrang() == 2) {
				btnPhong[i].setBackground(Color.red);
				lblIcon = new JLabel(iconRedClose);
			} else if (phong.getTinhTrang() == 1) {
				btnPhong[i].setBackground(Color.orange);
				lblIcon = new JLabel(iconQuestion);
			} else {
				btnPhong[i].setBackground(Color.green);
				lblIcon = new JLabel(iconGreenCheck);
			}
			lblIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblIcon.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
			lblIcon.setForeground(Color.WHITE);

			btnPhong[i].add(lblMaPhong);
			btnPhong[i].add(lblLoai);
			btnPhong[i].add(space(0, 5));
			btnPhong[i].add(lblIcon);
		}
		pnlTrangChu.add(pnlPhongTrong);
		pnlFull.add(pnlTrangChu);

		getCount();
		lblAvail.setText("Phòng trống (" + (countAvail + countBooking) + ")");
		lblBooking.setText("Đã đặt (" + countBooking + ")");
		lblUsing.setText("Đang ở (" + countUsing + ")");

		pack();
		setTitle("Trang chủ");
		setSize(1000, 650);
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255, 230, 179));
		rdLoaiPhong();

		// Add sự kiện
		cbLoaiPhong.addActionListener(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI_TrangChu().setVisible(true);
			}
		});
	}

	public JLabel space(int w, int h) {
		JLabel space = new JLabel("");
		space.setBorder(BorderFactory.createEmptyBorder(h / 2, w / 2, h / 2, w / 2));
		return space;
	}

	public void rdLoaiPhong() {
		// Add dsLoaiPhong
		modelLoaiPhong.removeAllElements();
		modelLoaiPhong.addElement("Tất cả");
//					System.out.println(dsLP.size());
		for (int i = 0; i < dsLP.size(); i++) {
			modelLoaiPhong.addElement(dsLP.get(i).getTenLoaiPhong());
		}
	}

	public void getCount() {
		countAvail = 0;
		countBooking = 0;
		countUsing = 0;
		for (int i = 0; i < dsPhong.size(); i++) {
			if (dsPhong.get(i).getTinhTrang() == 0) {
				countAvail++;
			} else if (dsPhong.get(i).getTinhTrang() == 1) {
				countBooking++;
			} else {
				countUsing++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(cbLoaiPhong)) {
			int choose = cbLoaiPhong.getSelectedIndex() - 1;
			if (choose == -1) {
				dsPhong = phong_DAO.getallPhong();
			} else {
				dsPhong = phong_DAO.getPhongByMaLoaiPhong(dsLP.get(choose).getMaLoaiPhong());

			}
		}
	}
}
