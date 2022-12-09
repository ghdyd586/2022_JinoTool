package package01;

import java.awt.Desktop;
import java.net.URI;

import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JPanel;

public class OpenURL extends JFrame {
	OpenURL() {

	}

	public void Shopify() {
		Desktop shopify = java.awt.Desktop.getDesktop();
		try {
			URI shopifyURL = new URI("https://www.shopify.com/");
			shopify.browse(shopifyURL);
		} catch (Exception e) {

		}
	}

	public void Shopee() {
		Desktop shopee = java.awt.Desktop.getDesktop();
		try {
			URI shopeeURL = new URI("https://shopee.com/");
			shopee.browse(shopeeURL);
		} catch (Exception e) {

		}
	}

}
