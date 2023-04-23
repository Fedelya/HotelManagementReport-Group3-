package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI_DangNhap extends JFrame implements ActionListener {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private ImageIcon iconXoa = new ImageIcon(
			new ImageIcon("picture/delete-icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private ImageIcon iconDangNhap = new ImageIcon(
			new ImageIcon("picture/login-icon.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

	public GUI_DangNhap() {
		setSize(420, 300);
		setTitle("Dang Nhap");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBounds(0, 0, 450, 250);

		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(131, 11, 155, 51);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(50, 83, 102, 28);
		contentPanel.add(lblNewLabel_1);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(160, 85, 185, 29);
		contentPanel.add(txtUsername);

		JLabel lblNewLabel_2 = new JLabel("Mật khẩu:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(66, 122, 102, 34);
		contentPanel.add(lblNewLabel_2);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(160, 127, 185, 28);
		contentPanel.add(txtPassword);

		btnLogin = new JButton("Đăng nhập", iconDangNhap);
		btnLogin.setActionCommand("OK");
		btnLogin.setBounds(224, 200, 120, 39);
		contentPanel.add(btnLogin);

		btnCancel = new JButton("Huỷ", iconXoa);
		btnCancel.setActionCommand("Cancel");
		btnCancel.setBounds(70, 200, 100, 39);
		contentPanel.add(btnCancel);

		this.add(contentPanel);

		contentPanel.setBackground(new Color(255, 204, 163));

		this.setBackground(new Color(255, 230, 179));

		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);

	}

	public static void main(String[] args) {
		new GUI_DangNhap().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			String tenTK = txtUsername.getText();
			String maTK = txtPassword.getText();
			if (tenTK.equals("admin") && maTK.equals("admin")) {
				JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
				new GUI_TrangChu().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this, "Sai mk hoac tai khoan");
				txtPassword.requestFocus();
				txtUsername.requestFocus();
				txtPassword.selectAll();
				txtUsername.selectAll();
			}
		}

		else if (o.equals(btnCancel)) {
			int ans = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoat?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION) {
				System.exit(0);
				;
			}

		}

	}
}
