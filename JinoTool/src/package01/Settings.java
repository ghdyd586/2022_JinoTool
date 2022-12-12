package package01;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Settings extends JFrame {
	Settings(String password) {
		setTitle("Settings");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout());
		JPanel p0 = new JPanel(new GridLayout(2, 0));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel(new GridLayout(5, 0));
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		p0.setBackground(Color.WHITE);
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		JTextArea jta = new JTextArea("Settings");
		jta.setEditable(false);
		JButton b1 = new JButton("Set User Password");
		JButton b2 = new JButton("Reset User Settings");
		JButton b3 = new JButton("Option 2");
		JButton b4 = new JButton("Option 3");
		JButton b5 = new JButton("Back");
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);

		b1.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				new SetPW();
				setVisible(false);
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
				new ResetAll();
				setVisible(false);
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
				Main.main(null);
				setVisible(false);
			}

			public void mouseReleased(MouseEvent e) {
			}

		});
		p1.add(jta);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p0.add(p1);
		p0.add(p2);
		add(p0);

		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);
			b1.setFont(font);
			b2.setFont(font);
			b3.setFont(font);
			b4.setFont(font);
			b5.setFont(font);

		} catch (Exception e) {

		}
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
