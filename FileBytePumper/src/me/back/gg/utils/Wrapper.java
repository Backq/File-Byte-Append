package me.back.gg.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Wrapper {
	
	public static String randuuid() {	
		return UUID.randomUUID().toString();
	}
	
	public static void appendBytes(String filePath) throws IOException {
		FileOutputStream out = new FileOutputStream(filePath, true);
		out.write(randomString("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", randInt(40000, 90000)).getBytes());
		out.close();
	}
	
	public static String randomString(String alphabet, int len) {
	    StringBuilder sb = new StringBuilder();
	    Random rnd = new Random();
	    for (int i = 0; i < len; i++) {
	        sb.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
	    }
	    return sb.toString();
	}
	
	public static int randInt(int min, int max) {
	    Random rnd = new Random();
	    return rnd.nextInt((max - min) + 1) + min;
	}
	
	public static void msgBox(String msg, String title, int mode) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
			JOptionPane.showMessageDialog(null, msg, title, mode);
		 } catch (ClassNotFoundException e) {} catch (InstantiationException ee) {} catch (IllegalAccessException eee) {} catch (UnsupportedLookAndFeelException eeee) {}
	}

}
