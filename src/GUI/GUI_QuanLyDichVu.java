package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import dao.DichVu_DAO;
import dao.KhachHang_DAO;
import entity.DichVu;
import entity.KhachHang;
import entity.LoaiPhong;

public class GUI_QuanLyDichVu extends JFrame implements MouseListener ,ActionListener{
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
	private DichVu_DAO dv_DAO;
	private DichVu_DAO dv_Dao;
 
	public GUI_QuanLyDichVu() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dv_DAO = new DichVu_DAO();
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
        lblTendichvu.setBounds(390, 20, 100, 30);
        pnlThongTindichvu.add(lblTendichvu);
        
        txtTendichvu = new JTextField();
        txtTendichvu.setBounds(490, 25, 250, 25);
        pnlThongTindichvu.add(txtTendichvu);
        txtTendichvu.setColumns(10);
//        lblsoluong = new JLabel("Số lượng:");
//        lblsoluong.setBounds(390, 20, 100, 30);
//        pnlThongTindichvu.add(lblsoluong);
//        
//        txtsoluong = new JTextField();
//        txtsoluong.setBounds(490, 25, 250, 25);
//        pnlThongTindichvu.add(txtsoluong);
//        txtsoluong.setColumns(10);
        lbldongia = new JLabel("Đơn Giá");
        lbldongia.setBounds(150, 80, 100, 30);
        pnlThongTindichvu.add(lbldongia);
        
        txtdongia = new JTextField();
        txtdongia.setBounds(250, 85, 250, 25);
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

		lblTendichvus = new JLabel("Mã dịch vụ:");
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
		String[] headers = { "Mã dịch vụ", "Tên dịch vụ", "Đơn giá" };

		tableModel = new DefaultTableModel(headers, 0);

		pnlDanhSachdichvu.add(scroll = new JScrollPane(table = new JTable(tableModel),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		scroll.setBounds(5, 60, 740, 300);
		btnLamMoi.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemTatCa.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		table.addMouseListener(this);
		
		
		
		

        
        
        
		docDuLieuVaoTable();
		
	}
	public static void main(String[] args) {
		new GUI_QuanLyDichVu().setVisible(true);
	}
	public void docDuLieuVaoTable() {
		List<DichVu> list = dv_DAO.getalltbDichVu();
		for (DichVu dv : list) {
			
			tableModel.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(), dv.getDonGia()
					});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object o = e.getSource();

		if (o.equals(btnTim)) {
			int ma = Integer.parseInt(txtTendichvus.getText());
			ArrayList<DichVu> dsdv = dv_DAO.getDichVuTheoMa(ma);

			if (txtTendichvus.getText().trim().equals("")) {
				tableModel.getDataVector().removeAllElements();
				docDuLieuVaoTable();

			}

			else if (dsdv.size() == 0) {
				JOptionPane.showMessageDialog(this, "Khong co ma can tim");
			}

			else {
				tableModel.getDataVector().removeAllElements();
				for (DichVu dv : dsdv) {
					tableModel.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(), dv.getDonGia() });
				}
			}
		}else if (o.equals(btnXemTatCa)) {
		tableModel.getDataVector().removeAllElements();
		docDuLieuVaoTable();
	}
		else if (o.equals(btnLamMoi)) {
			txtMadichvu.setText("");
			txtTendichvu.setText("");
			txtdongia.setText("");
			txtTendichvus.setText("");
		}
		else if (o.equals(btnThem)) {
			int ma = Integer.parseInt(txtMadichvu.getText());
			String ten = txtTendichvu.getText();
			double donGia = Double.parseDouble(txtdongia.getText());
			DichVu dv = new DichVu(ma, ten, donGia);

			try {
				dv_DAO.insert(dv);
				tableModel.addRow(new Object[] { dv.getMaDichVu(),dv.getTenDichVu(), dv.getDonGia() });
				JOptionPane.showMessageDialog(this, "them thanh cong");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}
		}
		else if (o.equals(btnSua)) {
			int row = table.getSelectedRow();
			int ma = Integer.parseInt(txtMadichvu.getText());
			String ten = txtTendichvu.getText();
			double gia = Double.parseDouble(txtdongia.getText());
			if (row >= 0) {
				DichVu dv = new DichVu(ma, ten, gia);
				System.out.println(dv.toString());
				if (dv_DAO.update(dv)) {
					table.setValueAt(txtTendichvu.getText(), row, 1);
					;
					table.setValueAt(txtdongia.getText(), row, 2);
					JOptionPane.showMessageDialog(this, "Sua thanh cong");
				} else {
					JOptionPane.showMessageDialog(this, "Sua that bai");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chon dong can xoa");
			}
		}
		else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			try {
				if (row == -1) {
					JOptionPane.showMessageDialog(this, "Chon dong can xoa");
				} else {
					DichVu dv = null;
					dv = getDataInFormDichVu();
					int ma = dv.getMaDichVu();
			int ans = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
								JOptionPane.YES_NO_OPTION);
					if (ans == JOptionPane.YES_OPTION) {
							dv_DAO.delete(ma);
							tableModel.removeRow(row);
							JOptionPane.showMessageDialog(this, "Xóa thành công");
							
							
						}
					}
				}catch (Exception e3) {
				JOptionPane.showMessageDialog(this, "Xoa khong thanh cong");
			}
			}
		

		
	}
	
	
	public DichVu getDataInFormDichVu() {
		int maDV = Integer.parseInt(txtMadichvu.getText().trim());
		String tenDV = txtTendichvu.getText().trim();
		Double donGia = Double.parseDouble(txtdongia.getText());
		DichVu dv = new DichVu(maDV, tenDV, donGia);
		return dv;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

		if (o.equals(table)) {
			int row = table.getSelectedRow();
			txtMadichvu.setText(tableModel.getValueAt(row, 0).toString());
			txtTendichvu.setText(tableModel.getValueAt(row, 1).toString());
			txtdongia.setText(tableModel.getValueAt(row, 2).toString());

		}
		

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

