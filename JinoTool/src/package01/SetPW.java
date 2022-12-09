package package01;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class SetPW extends JFrame {
	private String password;
	int b1cnt;
	int b2cnt;

	SetPW() {
		b1cnt = 0;
		b2cnt = 0;

		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Password Setting");
		setLayout(new FlowLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		JTextArea jta = new JTextArea("Set/Reset Password");

		JButton b1 = new JButton("New Password");
		JButton b2 = new JButton("Reset Password");
		JButton b3 = new JButton("Back");

		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);

		} catch (Exception e) {

		}
		b1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				if (b1cnt == 0) {
					NewPW();
				}

			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		b2.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				if (b2cnt == 0) {
					ResetPW();
				}
			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		b3.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				new Settings(Main.readpw());
				setVisible(false);
			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		add(p1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String GetPW() {
		return this.password;
	}

	public void NewPW() {
		JFrame notice = new JFrame();
		setTitle("Password Setting");
		notice.setTitle("Set Password Successfully!");
		notice.setSize(300, 200);
		notice.setLocationRelativeTo(null);
		notice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notice.setResizable(false);
		notice.getContentPane().setLayout(null);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel p2 = new JPanel();
		JLabel pw = new JLabel("New Password");
		JPasswordField jf1 = new JPasswordField(10);
		JButton input = new JButton("Input");
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(notice, "Set Password Successfully!", "Notice",
						JOptionPane.INFORMATION_MESSAGE);
				password = new String(jf1.getPassword());
				savepw("1" + password);
				new Login(Main.readpw());
				setVisible(false);
			}
		});

		p2.add(pw);
		p2.add(jf1);
		p2.add(input);
		add(p2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1cnt++;

	}

	public void ResetPW() {
		JFrame notice = new JFrame();
		notice.setTitle("Change Password Successfully!");
		notice.setSize(300, 200);
		notice.setLocationRelativeTo(null);
		notice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notice.setResizable(false);
		notice.getContentPane().setLayout(null);
		JLabel pw = new JLabel("Password");
		JPanel p2 = new JPanel();
		JPasswordField jf1 = new JPasswordField(10);
		JButton input = new JButton("Input");
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(jf1.getPassword()).equals(Main.readpw())) {
					JOptionPane.showMessageDialog(notice, "Reset Password Successfully!\n New password is 1234.",
							"Reset Password", JOptionPane.INFORMATION_MESSAGE);
					password = "1234";
					savepw("1" + password);
					new Settings(Main.readpw());
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(notice, "Login Fail!", "Notice", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		p2.add(pw);
		p2.add(jf1);
		p2.add(input);
		add(p2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b2cnt++;

	}

	public void savepw(String password) {
		try {
			FileWriter fw = new FileWriter("etc/pw.txt");
			fw.write(password);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void visiblesetting(boolean n) {
		setVisible(n);
	}

}
