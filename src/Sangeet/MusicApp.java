package Sangeet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javazoom.jl.decoder.JavaLayerException;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MusicApp extends JFrame {
	  Main main= new Main(); // to calling our methods here 
	
	private JPanel contentPane;
	private JTextField songtxt;
	private JButton btnplay;
	private JButton btnPuase;
	protected String songFile;

	/**
	 * Launch the application.
	 */
	// main class here
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicApp frame = new MusicApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MusicApp() {
		setTitle("Sangeet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		songtxt = new JTextField();
		songtxt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		songtxt.setBackground(Color.ORANGE);
		songtxt.setForeground(Color.WHITE);
		songtxt.setEditable(false);
		songtxt.setBounds(142, 129, 312, 33);
		contentPane.add(songtxt);
		songtxt.setColumns(10);
		//songtxt.setText(null);
		
		JButton loadmusic = new JButton("Browse music"); // 
		loadmusic.setBackground(Color.ORANGE);
		loadmusic.setForeground(Color.BLACK);
		loadmusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser choose= new JFileChooser();
				choose.showOpenDialog(null);
				
			    // songFile is to be pass as song
				String name= choose.getSelectedFile().getPath();
				System.out.println(name);
				songtxt.getText();
			    songtxt.setText(name);
			    songFile =name;
			   /* try {
					main.play(songFile);
				} catch (JavaLayerException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		loadmusic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loadmusic.setBounds(476, 129, 117, 33);
		contentPane.add(loadmusic);
		
		btnplay = new JButton("Play");
		btnplay.setForeground(Color.BLACK);
		btnplay.setBackground(Color.ORANGE);
		btnplay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						main.play(songFile);     //F:\\Kesariya.mp3
					} catch (JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnplay.setBounds(255, 265, 89, 33);
		contentPane.add(btnplay);
		
		btnPuase = new JButton("Puase");
		btnPuase.setBackground(Color.ORANGE);
		btnPuase.setForeground(Color.BLACK);
		btnPuase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPuase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.pause();   // calling the method stope//
			}
		});
		btnPuase.setBounds(156, 265, 89, 33);
		contentPane.add(btnPuase);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setBackground(Color.ORANGE);
		btnResume.setForeground(Color.BLACK);
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// calling the Resume method 
				try {
					main.Resume();
				} catch (JavaLayerException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnResume.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResume.setBounds(354, 265, 89, 33);
		contentPane.add(btnResume);
		
		JButton btnUp = new JButton("+");
		btnUp.setForeground(Color.BLACK);
		btnUp.setBackground(Color.ORANGE);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					main.volumeUp(); // calling the volumeUp method
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUp.setBounds(452, 272, 46, 23);
		contentPane.add(btnUp);
		
		JButton btnDown = new JButton("-");
		btnDown.setForeground(Color.BLACK);
		btnDown.setBackground(Color.ORANGE);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					main.volumeDown(); // calling the volumeDown method
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnDown.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDown.setBounds(508, 272, 46, 23);
		contentPane.add(btnDown);
		
		JLabel lblNewLabel = new JLabel("SANGEET.Player");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(255, 39, 161, 38);
		contentPane.add(lblNewLabel);
	}
}
