package package01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class SetPW extends JFrame {
	private String password;
	int bcnt;
	boolean isnew;

	SetPW() {
		Main m = new Main();
		m.setVisible(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle("Password Setting");
		setBackground(Color.WHITE);
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		JPanel p0 = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		JTextArea jta = new JTextArea("Set/Reset Password");
		p0.setBackground(Color.WHITE);
		p1.setBackground(Color.WHITE);
		JButton b1 = new JButton("New Password");
		JButton b2 = new JButton("Reset Password");
		JButton b3 = new JButton("Back");
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);

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
				if (readbcnt().equals("0")) {
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
				if (readbcnt().equals("1")) {
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
		p0.add(p1);
		add(p0, BorderLayout.NORTH);
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
		p2.setBackground(Color.WHITE);
		JLabel pw = new JLabel("New Password");
		JPasswordField jf1 = new JPasswordField(10);
		JButton input = new JButton("Input");
		input.setBackground(Color.WHITE);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(notice, "Set Password Successfully!", "Notice",
						JOptionPane.INFORMATION_MESSAGE);
				password = new String(jf1.getPassword());
				savepw("1" + password);
				isnew = true;
				savepwinfo(isnew);
				savebcnt(1);
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

	}

	public void ResetPW() {
		JFrame notice = new JFrame();
		setTitle("Password Setting");
		notice.setTitle("Change Password Successfully!");
		notice.setSize(300, 200);
		notice.setLocationRelativeTo(null);
		notice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notice.setResizable(false);
		notice.setBackground(Color.WHITE);
		notice.getContentPane().setLayout(null);
		JLabel pw = new JLabel("Password");
		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		JPasswordField jf1 = new JPasswordField(10);
		JButton input = new JButton("Input");
		input.setBackground(Color.WHITE);
		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new String(jf1.getPassword()).equals(Main.readpw())) {
					JOptionPane.showMessageDialog(notice, "Reset Password Successfully!\n New password is 1234.",
							"Reset Password", JOptionPane.INFORMATION_MESSAGE);
					password = "1234";
					savepw("1" + password);
					isnew = false;
					savepwinfo(isnew);
					savebcnt(0);
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

	}

	public static String readbcnt() {
		String bcnt = "";
		try {
			File file = new File("etc/bcnt.txt");
			FileReader file_reader = new FileReader(file);
			file_reader.read();

			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				String cc = String.valueOf((char) cur);
				bcnt = bcnt + cc;
			}
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return bcnt;
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

	public void savepwinfo(Boolean isnew) {
		try {
			String info = "";
			if (isnew == true) {
				info = "1true";
			} else {
				info = "1false";
			}
			FileWriter fw = new FileWriter("etc/pwinfo.txt");
			fw.write(info);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savebcnt(int bcnt) {
		try {
			String sbcnt = "";
			sbcnt = "1" + Integer.toString(bcnt);
			FileWriter fw = new FileWriter("etc/bcnt.txt");
			fw.write(sbcnt);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void visiblesetting(boolean n) {
		setVisible(n);
	}

}
