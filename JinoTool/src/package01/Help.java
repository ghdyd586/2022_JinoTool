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
//import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Help extends JFrame {
	Help() {
		setSize(500, 500);
		setTitle("Help");
		Container d = getContentPane();
		d.setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 0));
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new FlowLayout());
		JTextArea jta1 = new JTextArea("How to Use this program");
		JTextArea jta2 = new JTextArea("This program is made for users who use Shopify and Shopee.\n"
				+ "1. Open Shopify : Open Shopify.com\n" + "2. Open Shopee : Open Shopee.com\n"
				+ "3. Input Button : You can write details of your products.\n"
				+ "4. Copy Button : You can copy what you wrote.\n"
				+ "5. Help Button : (This Page) You can get guides.\n" + "6. Settings Button : Set some functions.\n"
				+ "7. Exit Button : Exit the program.\n"
				+ "8. Program Info : You can see the information like delveloper of this program.");
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		jta1.setBackground(Color.WHITE);
		jta1.setEditable(false);
		jta2.setEditable(false);

		JButton b1 = new JButton("Previous Page");
		JButton b2 = new JButton("I got it");
		JButton b3 = new JButton("Next Page");
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);

		b2.addMouseListener(new MouseListener() {
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
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/LINESeedSans_Bd.ttf"));
			font = font.deriveFont(Font.BOLD, 20);
			jta1.setFont(font);
			font = font.deriveFont(Font.PLAIN, 13);
			jta2.setFont(font);
			font = font.deriveFont(Font.PLAIN, 15);
			b1.setFont(font);
			b2.setFont(font);
			b3.setFont(font);

		} catch (Exception e) {

		}
		p1.add(jta1);
		p1.add(jta2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		add(p1);
		add(p2);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
