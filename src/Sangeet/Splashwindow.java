package Sangeet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Splashwindow extends JFrame {
	 static MusicApp app= new MusicApp();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  JPanel contentPane;
     JProgressBar progressBar ;
      JLabel counter; 
      
	/**
	 * Launch the application.
	 */ 
     
	public static void main(String[] args) {
		          int i=0;
					Splashwindow frame = new Splashwindow();
					frame.setVisible(true);
					try {
						for(i=0; i<=100;i++) {
			    	  frame.progressBar.setValue(i);
			    	  Thread.sleep(50);
			    	  frame.counter.setText(Integer.toString(i));
			    	  if (i==100) {
						frame.dispose();
						app.setVisible(true); // in main method
					}
					} 
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      
	}

	/**
	 * Create the frame.
	 */
	public Splashwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 598, 443);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		ImageIcon icon= new ImageIcon(this.getClass().getResource("/sangeet-logo.jpg"));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(68, 11, 409, 311);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(199,21,133));
//		progressBar.setBackground(new Color(199, 21, 133));
		progressBar.setBounds(148, 379, 256, 14);
		contentPane.add(progressBar);
		
		counter = new JLabel("");
		counter.setForeground(Color.WHITE);
		counter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		counter.setBounds(249, 354, 62, 14);
		contentPane.add(counter);
	}
}
