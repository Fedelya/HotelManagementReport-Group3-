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

public class GUI_ThongKeDichVu extends JFrame {
	private JButton btnLogout;
	private JMenuItem itemTrangChu;
	private JMenu menuTrangChu, menuDatPhong, menuQuanLyHoaDon, menuQuanLyDichVu, menuQuanLyKhachHang,
			menuQuanLyNhanVien, menuThongKe, subMenu;

	private int x = 10, w = 150, h = 50;
	private ImageIcon iconLogout = new ImageIcon(new ImageIcon("picture/logout-icon.png").getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
	private	ImageIcon iconUser = new ImageIcon(new ImageIcon("picture/user-icon.png").getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
	private ImageIcon iconThem = new ImageIcon(new ImageIcon("picture/add-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXoa = new ImageIcon(new ImageIcon("picture/delete-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconSua = new ImageIcon(new ImageIcon("picture/update-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconLamMoi = new ImageIcon(new ImageIcon("picture/refesh-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconTim = new ImageIcon(new ImageIcon("picture/search-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconXemTatCa = new ImageIcon(new ImageIcon("picture/see_all-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconThongKe = new ImageIcon(new ImageIcon("picture/chart-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

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
	public GUI_ThongKeDichVu() {
		// Phần Left
		
		setLayout(null);
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setBounds(0, 0, 300, 600);

		JPanel pnlFull = new JPanel();
		pnlFull.setLayout(null);
		pnlFull.setBounds(0, 0, 1000, 650);
		
		JLabel lblUser = new JLabel("Tên User");
		lblUser.setBounds(x, 10, w, 70);
		pnlFull.add(lblUser);
		lblUser.setIcon(iconUser);
		
		
		menuTrangChu = new JMenu("Trang Chủ");

//		menuTrangChu.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuTrangChu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menuTrangChu.setBounds(x, 100, w, h);
//		menuBar.add(menuTrangChu);
		itemTrangChu = new JMenuItem("Trang Chủ");
		menuTrangChu.add(itemTrangChu);
		pnlFull.add(menuTrangChu);

//            JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
//            bar.add(sep1, "growy");
		menuDatPhong = new JMenu("Đặt phòng");
//		menuDatPhong.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuDatPhong.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuDatPhong);
		menuDatPhong.setBounds(x, 160, w, h);
		pnlFull.add(menuDatPhong);

		menuQuanLyHoaDon = new JMenu("Quản Lý Hóa Đơn");
//		menuQuanLyHoaDon.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyHoaDon.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyHoaDon);
		menuQuanLyHoaDon.setBounds(x, 220, w, h);
		pnlFull.add(menuQuanLyHoaDon);

		menuQuanLyDichVu = new JMenu("Quản Lý Dịch Vụ");
//		menuQuanLyDichVu.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyDichVu.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyDichVu);
		menuQuanLyDichVu.setBounds(x, 280, w, h);
		pnlFull.add(menuQuanLyDichVu);

//            JSeparator sep2 = new JSeparator(JSeparator.VERTICAL);
//            bar.add(sep2, "growy");

		menuQuanLyKhachHang = new JMenu("Quản Lý Khách Hàng");
//		menuQuanLyKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyKhachHang);
		menuQuanLyKhachHang.setBounds(x, 340, w, h);
		pnlFull.add(menuQuanLyKhachHang);

		menuQuanLyNhanVien = new JMenu("Quản Lý Nhan Vien");
//		menuQuanLyNhanVien.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuQuanLyNhanVien.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuQuanLyNhanVien);
		menuQuanLyNhanVien.setBounds(x, 400, w, h);
		pnlFull.add(menuQuanLyNhanVien);

		JMenu menuThongKe = new JMenu("Thống kê");
//		menuThongKe.setHorizontalTextPosition(SwingConstants.CENTER);
//		menuThongKe.setVerticalTextPosition(SwingConstants.BOTTOM);
//		menuBar.add(menuThongKe);
		menuThongKe.setBounds(x, 460, w, h);
		pnlFull.add(menuThongKe);

		
		btnLogout = new JButton("Log out");
		btnLogout.setIcon(iconLogout);
		btnLogout.setBounds(20, 550, 120, 30);
		pnlFull.add(btnLogout);
		// Phần Right
		JLabel lblTitle = new JLabel("THỐNG KÊ DỊCH VỤ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(350, 0, 500, 30);
		lblTitle.setFont(new Font("Ariel", Font.BOLD, 25));
		pnlFull.add(lblTitle);
		
		JPanel pnlThongKeDichVu = new JPanel();
//		pnlThongKeDichVu.setBorder(new TitledBorder(null, "Thông tin khách hàng"));
		pnlThongKeDichVu.setBounds(230, 40, 750, 550);
		pnlFull.add(pnlThongKeDichVu);
		
		pnlThongKeDichVu.setLayout(null);
		
		
		lblMaKhachHang = new JLabel("Mã khách hàng:");
		lblMaKhachHang.setBounds(10, 20, 100, 30);
		pnlThongKeDichVu.add(lblMaKhachHang);
		
		txtMaKhachHang = new JTextField();
//		txtMaKhachHang.setEditable(false);
        txtMaKhachHang.setBounds(110, 25, 250, 25);
        pnlThongKeDichVu.add(txtMaKhachHang);
        txtMaKhachHang.setColumns(10);
		
        
        lblTenKhachHang = new JLabel("Tên khách hàng:");
        lblTenKhachHang.setBounds(390, 20, 100, 30);
        pnlThongKeDichVu.add(lblTenKhachHang);
        
        txtTenKhachHang = new JTextField();
        txtTenKhachHang.setBounds(490, 25, 250, 25);
        pnlThongKeDichVu.add(txtTenKhachHang);
        txtTenKhachHang.setColumns(10);
        
        lblTuNgay = new JLabel("Từ ngày: ");
        lblTuNgay.setBounds(10, 55, 100, 30);
        pnlThongKeDichVu.add(lblTuNgay);
        
        dpTuNgay = new DatePicker(205);
        dpTuNgay.setBounds(110, 60, 250, 25);
        pnlThongKeDichVu.add(dpTuNgay);
                
        lblDenNgay = new JLabel("Đến ngày: ");
        lblDenNgay.setBounds(390, 55, 250, 30);
        pnlThongKeDichVu.add(lblDenNgay);
        
        dpDenNgay = new DatePicker(205);
        dpDenNgay.setBounds(490, 60, 250, 25);
        pnlThongKeDichVu.add(dpDenNgay);
        
        JScrollPane scroll;
        String[] headers = {"Mã HD", "Mã DV", "Tên DV", "Số lượng", "Đơn giá","Thành tiền","Ngày đặt","Tình trạng HD","Mã KH","Tên KH"};
        
        tableModel = new DefaultTableModel(headers, 0);
        
        pnlThongKeDichVu.add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));
        scroll.setBounds(5, 100, 740, 400);
//        
        reSizeColumnTable();
        
      btnThongKe = new JButton("Thống kê");
      btnThongKe.setBounds(580, 510, 150, 30);
      btnThongKe.setIcon(iconThongKe);
      pnlThongKeDichVu.add(btnThongKe);
      
      lblTongDoanhThu = new JLabel("Tổng doanh thu:");
      lblTongDoanhThu.setBounds(10, 510, 100, 30);
      pnlThongKeDichVu.add(lblTongDoanhThu);
      
      txtTongDoanhThu = new JTextField("0.0");
      
      txtTongDoanhThu.setBounds(110, 517, 180, 20);
      txtTongDoanhThu.setBackground(Color.CYAN);
      txtTongDoanhThu.setEditable(false);
      pnlThongKeDichVu.add(txtTongDoanhThu);
      txtTongDoanhThu.setColumns(10);
      
      lblVND = new JLabel("VNĐ");
      lblVND.setBounds(300, 510, 100, 30);
      pnlThongKeDichVu.add(lblVND);
        
//		setJMenuBar(menuBar);
//		pack();
		setTitle("Thống kê dịch vụ");
		setSize(1000, 650);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(pnlFull);
		pnlFull.setBackground(new Color(255,230,179));
		
		
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI_ThongKeDichVu().setVisible(true);
			}
		});
	}
	private void reSizeColumnTable() {
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(65);
        table.getColumnModel().getColumn(2).setPreferredWidth(110);
        table.getColumnModel().getColumn(3).setPreferredWidth(85);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(5).setPreferredWidth(95);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(120);
        table.getColumnModel().getColumn(8).setPreferredWidth(70);
        table.getColumnModel().getColumn(9).setPreferredWidth(204);
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
