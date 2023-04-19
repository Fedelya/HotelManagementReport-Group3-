package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_QuanLyDichVu extends JFrame{
	private JButton btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnTim, btnXemTatCa;
	private JMenuItem itemTrangChu, itemDatPhong, itemQuanLyHoaDon, itemQuanLyPhong, itemQuanLyDichVu,
	itemQuanLyKhachHang, itemQuanLyNhanVien,  itemThongKeDichVu, itemThongKeKhachHang, itemThongKeNhanVien;
	private JMenu menuTrangChu, menuDatPhong, menuQuanLyHoaDon, menuQuanLyDichVu, menuQuanLyKhachHang,
			menuQuanLyNhanVien, menuThongKe, subMenu;

	private int x = 0, w = 150, h = 50;
	private ImageIcon iconLogout = new ImageIcon(new ImageIcon("picture/logout-icon.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	private	ImageIcon iconUser = new ImageIcon(new ImageIcon("picture/user-icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	private ImageIcon iconThem = new ImageIcon(new ImageIcon("picture/add-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXoa = new ImageIcon(new ImageIcon("picture/delete-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconSua = new ImageIcon(new ImageIcon("picture/update-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconLamMoi = new ImageIcon(new ImageIcon("picture/refesh-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconTim = new ImageIcon(new ImageIcon("picture/search-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXemTatCa = new ImageIcon(new ImageIcon("picture/see_all-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private JLabel lblMadichvu;
	private JTextField txtMadichvu;
	private JLabel lblTendichvu;
	private JTextField txtTendichvu;
	private JLabel lblsoluong;
	private JLabel lbldongia;
	private JTextField txtdongia;
	private JTextField txtsoluong;
	private JLabel lblTendichvus;
	private JTextField txtTendichvus;
	private DefaultTableModel tableModel;
	private JTable table;
	public GUI_QuanLyDichVu() {
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
		menuDatPhong = new JMenu(" Đặt phòng");
//		menuDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuDatPhong);
		menuDatPhong.setBounds(x, 160, w, h);
		itemDatPhong = new JMenuItem(" Đặt phòng");
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
		//size
		setTitle("Quản Lý Khách Hàng");
		setSize(1000, 650);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255,230,179));
		//right
		JLabel lblTitle = new JLabel("Quản Lý Dịch Vụ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);
		
		JPanel pnlThongTindichvu = new JPanel();
		pnlThongTindichvu.setBorder(new TitledBorder(null, "Dịch Vụ"));
		pnlThongTindichvu.setBounds(230, 40, 750, 200);
		pnlFull.add(pnlThongTindichvu);
		
		pnlThongTindichvu.setLayout(null);
		
		
		lblMadichvu = new JLabel("Mã dịch vụ:");
		lblMadichvu.setBounds(10, 20, 100, 30);
		pnlThongTindichvu.add(lblMadichvu);
		
		txtMadichvu = new JTextField();
		//txtMadichvu.setEditable(false);
		txtMadichvu.setBounds(110, 25, 250, 25);
        pnlThongTindichvu.add(txtMadichvu);
        txtMadichvu.setColumns(10);
		
        
        lblTendichvu = new JLabel("Tên dịch vụ:");
        lblTendichvu.setBounds(10, 55, 100, 30);
        pnlThongTindichvu.add(lblTendichvu);
        
        txtTendichvu = new JTextField();
        txtTendichvu.setBounds(110, 60, 250, 25);
        pnlThongTindichvu.add(txtTendichvu);
        txtTendichvu.setColumns(10);
        lblsoluong = new JLabel("Số lượng:");
        lblsoluong.setBounds(390, 20, 100, 30);
        pnlThongTindichvu.add(lblsoluong);
        
        txtsoluong = new JTextField();
        txtsoluong.setBounds(490, 25, 250, 25);
        pnlThongTindichvu.add(txtsoluong);
        txtsoluong.setColumns(10);
        lbldongia = new JLabel("Đơn Giá");
        lbldongia.setBounds(390, 50, 100, 30);
        pnlThongTindichvu.add(lbldongia);
        
        txtdongia = new JTextField();
        txtdongia.setBounds(490, 55, 250, 25);
        pnlThongTindichvu.add(txtdongia);
        txtdongia.setColumns(10);
        //them button
        btnThem = new JButton("Add");
        btnThem.setBounds(130, 150, 100, 30);
        btnThem.setIcon(iconThem);
        pnlThongTindichvu.add(btnThem);
        
        btnXoa = new JButton("Delete");
        btnXoa.setBounds(260, 150, 100, 30);
        btnXoa.setIcon(iconXoa);
        pnlThongTindichvu.add(btnXoa);
        
        btnSua = new JButton("Update");
        btnSua.setBounds(390, 150, 100, 30);
        btnSua.setIcon(iconSua);
        pnlThongTindichvu.add(btnSua);
        
        btnLamMoi = new JButton("Refesh");
        btnLamMoi.setBounds(520, 150, 100, 30);
        btnLamMoi.setIcon(iconLamMoi);
        pnlThongTindichvu.add(btnLamMoi);
        //danh sach dich vu
        JPanel pnlDanhSachdichvu = new JPanel();
		pnlDanhSachdichvu.setBorder(new TitledBorder(null, "Danh Sách Dịch Vụ"));
		pnlDanhSachdichvu.setBounds(230, 250, 750, 360);
		pnlFull.add(pnlDanhSachdichvu);

		pnlDanhSachdichvu.setLayout(null);

		lblTendichvus = new JLabel("Tên dịch vụ:");
		lblTendichvus.setBounds(60, 20, 100, 30);
		pnlDanhSachdichvu.add(lblTendichvus);

		txtTendichvus = new JTextField();
		txtTendichvus.setBounds(170, 25, 250, 25);
		txtTendichvus.setColumns(10);
		pnlDanhSachdichvu.add(txtTendichvus);

		btnTim = new JButton("Search");
		btnTim.setBounds(430, 22, 100, 30);
		btnTim.setIcon(iconTim);
		pnlDanhSachdichvu.add(btnTim);

		btnXemTatCa = new JButton("Watch All");
		btnXemTatCa.setBounds(540, 22, 150, 30);
		btnXemTatCa.setIcon(iconXemTatCa);
		pnlDanhSachdichvu.add(btnXemTatCa);

		JScrollPane scroll;
		String[] headers = { "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Đơn giá" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlDanhSachdichvu.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scroll.setBounds(5, 60, 740, 300);

        
        
        
		
		
	}
	public static void main(String[] args) {
		new GUI_QuanLyDichVu().setVisible(true);
	}
	

}

