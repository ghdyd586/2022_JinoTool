package package01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Settings extends JFrame {
	Settings(String password) {
		setTitle("Settings");
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel p0 = new JPanel(new GridLayout(3, 0));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel(new GridLayout(4, 0));
		JPanel p7 = new JPanel();
		Container f = getContentPane();
		f.setBackground(Color.WHITE);
		JTextArea jta = new JTextArea("Settings");
		jta.setEditable(false);
		JCheckBox cb1 = new JCheckBox();
		JCheckBox cb2 = new JCheckBox();
		JCheckBox cb3 = new JCheckBox();
		JCheckBox cb4 = new JCheckBox();
		JLabel jl1 = new JLabel("Set User Password");
		JLabel jl2 = new JLabel("Option 1");
		JLabel jl3 = new JLabel("Option 2");
		JLabel jl4 = new JLabel("Option 3");
		JLabel jl5 = new JLabel("Option 4");
		JButton b1 = new JButton("Back");

		cb1.addMouseListener(new MouseListener() {
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
		b1.addMouseListener(new MouseListener() {
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
		p2.add(jl1);
		p2.add(cb1);

		p3.add(jl2);
		p3.add(cb2);

		p4.add(jl3);
		p4.add(cb3);

		p5.add(jl4);
		p5.add(cb4);
		p7.add(b1);

		p0.add(p1);
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		p0.add(p6);
		p0.add(p7);
		add(p0);
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);
			jl1.setFont(font);
			jl2.setFont(font);
			jl3.setFont(font);
			jl4.setFont(font);
			jl5.setFont(font);

		} catch (Exception e) {

		}
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
