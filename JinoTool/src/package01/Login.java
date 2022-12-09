package package01;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Login extends JFrame {
	Login(String password) {
		Main m = new Main();
		SetPW p = new SetPW();
		m.visiblesetting(false);
		p.visiblesetting(false);
		JFrame notice = new JFrame();
		JPanel p0 = new JPanel(new GridLayout(3, 0));
		JTextArea jta = new JTextArea("Login");
		setTitle("Login");
		notice.setTitle("Login Successfully!");
		notice.setSize(300, 200);
		notice.setLocationRelativeTo(null);
		notice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notice.setResizable(false);
		notice.getContentPane().setLayout(null);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JLabel pw = new JLabel("Login");
		JPasswordField jf1 = new JPasswordField(10);
		JButton input = new JButton("Login");

		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(jf1.getPassword()).equals(password)) {
					JOptionPane.showMessageDialog(notice, "Login Success!", "Notice", JOptionPane.INFORMATION_MESSAGE);

					m.visiblesetting(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(notice, "Login Fail!", "Notice", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);
			pw.setFont(font);
			jf1.setFont(font);
			input.setFont(font);

		} catch (Exception e) {

		}

		p1.add(jta);
		p2.add(pw);
		p2.add(jf1);
		p2.add(input);

		p0.add(p1);
		p0.add(p2);
		add(p0);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
