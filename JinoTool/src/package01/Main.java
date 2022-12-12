package package01;

import java.awt.Color;
import java.awt.Container;
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main extends JFrame {

	Main() {
		setSize(400, 400);
		setTitle("Shopping Mall Template Copy Tool");
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		JPanel p0 = new JPanel();
		p0.setBackground(Color.WHITE);
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		JPanel p2 = new JPanel(new GridLayout(8, 0));
		p2.setBackground(Color.WHITE);
		JTextArea jta1 = new JTextArea("Shopping Mall Template Copy Tool");
		JTextArea jta2 = new JTextArea("If you need any help, press \"Help\" button.");

		jta1.setEditable(false);
		JButton b1 = new JButton("Open Shopify");
		JButton b2 = new JButton("Open Shopee");
		JButton b3 = new JButton("Input");
		JButton b4 = new JButton("Copy");
		JButton b5 = new JButton("Help");
		JButton b6 = new JButton("Settings");
		JButton b7 = new JButton("Exit");
		JButton b8 = new JButton("Program Info");
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		b6.setBackground(Color.WHITE);
		b7.setBackground(Color.WHITE);
		b8.setBackground(Color.WHITE);

		JFrame exitframe = new JFrame();
		exitframe.setSize(200, 200);
		exitframe.setLocationRelativeTo(null);
		exitframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exitframe.setResizable(false);
		exitframe.getContentPane().setLayout(null);
		JLabel exitmessage = new JLabel("Do you want to exit this program?");
		exitmessage.setOpaque(true);

		exitmessage.setForeground(Color.BLACK);
		exitmessage.setHorizontalAlignment(JLabel.CENTER);
		b1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				OpenURL shopify = new OpenURL();
				shopify.Shopify();
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
				OpenURL shopee = new OpenURL();
				shopee.Shopee();

			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		b5.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				new Help();
				setVisible(false);
			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		b6.addMouseListener(new MouseListener() {
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
		b7.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				int quit = JOptionPane.showConfirmDialog(exitframe, exitmessage, "EXIT", JOptionPane.YES_NO_OPTION);
				if (quit == 0) {
					SetPW p = new SetPW();
					p.savepwinfo(true);
					System.exit(0);
				} else if (quit == 1) {
					// nothing happens.
				}

			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		b8.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				new ProgramInfo();
				setVisible(false);

			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		p0.add(jta1);
		p1.add(jta2);

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);

		add(p0);
		add(p1);
		add(p2);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta1.setFont(font);
			font = font.deriveFont(Font.BOLD, 15);
			jta2.setFont(font);
			font = font.deriveFont(Font.PLAIN, 12);
			exitmessage.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);
			b1.setFont(font);
			b2.setFont(font);
			b3.setFont(font);
			b4.setFont(font);
			b5.setFont(font);
			b6.setFont(font);
			b7.setFont(font);
			b8.setFont(font);

		} catch (Exception e) {

		}
	}

	public void visiblesetting(boolean n) {
		setVisible(n);
	}

	public static String readpw() {
		String pw = "";
		try {
			File file = new File("etc/pw.txt");
			FileReader file_reader = new FileReader(file);
			file_reader.read();

			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				String cc = String.valueOf((char) cur);
				pw = pw + cc;
			}
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return pw;
	}

	public static String readpwinfo() {
		String info = "";
		try {
			File file = new File("etc/pwinfo.txt");
			FileReader file_reader = new FileReader(file);
			file_reader.read();

			int cur = 0;
			while ((cur = file_reader.read()) != -1) {
				String cc = String.valueOf((char) cur);
				info = info + cc;
			}
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return info;
	}

	public static void main(String[] args) {

		if (readpw().equals("")) {
			new Main();
		} else {
			if (readpwinfo().equals("true")) {
				new Login(readpw());
			} else {
				new Main();
			}
		}

	}

}
