package me.back.gg;

import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.back.gg.gui.MainGui;

public class Main {
	/***
	 * @author Back
	 * 
	 * https://github.com/Backq
	 * Telegram: @Backq
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException e) {} catch (InstantiationException ee) {} catch (IllegalAccessException eee) {} catch (UnsupportedLookAndFeelException eeee) {}
		try {
			MainGui window = new MainGui();
			window.frame.setVisible(true);
		} catch (Exception ex) {ex.printStackTrace();}
	}
}

