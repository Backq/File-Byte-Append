package me.back.gg.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import me.back.gg.utils.Wrapper;

public class MainGui {

	public JFrame frame;
	private JTextField textField;
	private String currentDirectory = System.getProperty("user.home");

	public MainGui() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(Wrapper.randuuid());
		frame.setResizable(false);
		frame.setBounds(100, 100, 250, 161);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(31, 19, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Path");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 9));
		lblNewLabel.setBounds(5, 21, 29, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pump");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					Wrapper.msgBox("Fill the TextField first!", "Warning", JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					
					Thread thr = new Thread(new Runnable() {
                        @Override
                        public void run() {
                        	Wrapper.msgBox("Pumping...", "Loading", JOptionPane.INFORMATION_MESSAGE);                      	
                        }
                    });
					
					thr.run();
					Wrapper.appendBytes(textField.getText());
					thr.interrupt();
					
				Wrapper.msgBox("File Pumped Succesfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException ee) {
					Wrapper.msgBox("Failed or Interrupted I/O Operation", "Error", JOptionPane.ERROR_MESSAGE);
					ee.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 9));
		btnNewButton.setBounds(153, 98, 79, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File(currentDirectory)); 
				fileChooser.setDialogTitle("Select a file from your directory");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            if (fileChooser.showOpenDialog(btnNewButton) == JFileChooser.APPROVE_OPTION){ 
	            	textField.setHorizontalAlignment(JTextField.LEFT); 
	            	textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
	             }
			}
		});
		btnNewButton_1.setBounds(194, 18, 29, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("File Pumper");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(3, 103, 86, 19);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
