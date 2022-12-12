package package01;

import java.awt.Color;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ResetAll extends JFrame {
	ResetAll() {
		JFrame resetframe = new JFrame();
		resetframe.setSize(200, 200);
		resetframe.setLocationRelativeTo(null);
		resetframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resetframe.setResizable(false);
		resetframe.getContentPane().setLayout(null);
		JLabel resetmessage = new JLabel("Do you want to reset this program?");
		resetmessage.setOpaque(true);
		resetmessage.setForeground(Color.BLACK);
		resetmessage.setHorizontalAlignment(JLabel.CENTER);
		int quit = JOptionPane.showConfirmDialog(resetframe, resetmessage, "EXIT", JOptionPane.YES_NO_OPTION);
		if (quit == 0) {
			reset();
			JOptionPane.showMessageDialog(resetframe, "Reset Finished! Exit the program.", "Notice",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (quit == 1) {
			// nothing happens.
		}
	}

	public void reset() {
		try {
			String pw = "";
			String info = "1false";
			String bcnt = "10";
			FileWriter fw = new FileWriter("etc/pw.txt");
			fw.write(pw);
			fw.close();
			FileWriter fw1 = new FileWriter("etc/pwinfo.txt");
			fw1.write(info);
			fw1.close();
			FileWriter fw2 = new FileWriter("etc/bcnt.txt");
			fw2.write(bcnt);
			fw2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ResetAll();

	}

}
