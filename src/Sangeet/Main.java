package Sangeet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.FloatControl;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Main {
	long pauseLocation;
	long totalLenghtSong;
	public String fileLocation;
	FileInputStream fi;
	BufferedInputStream bi;
	public String filePath;
	float currentVol=0;
	//float previousVol=0;
	FloatControl control;
	 Player player;
	
	// creating methods for Stop, Play, and resume etc..
	
	public void pause() {
		// TODO Auto-generated method stub
		if(player!=null) { // jab song chal raha ho to pause krdo
			try {
			 pauseLocation=fi.available();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.close();
		}
		
	}
	
	
	// play method here
	
	public void play( String filePath) throws JavaLayerException, IOException {  // or filename
		      this.filePath=filePath;
		try {
			fi= new FileInputStream(filePath);
			bi= new BufferedInputStream(fi);
			player= new Player(bi);
			      totalLenghtSong=fi.available();
			      
			      fileLocation= filePath+ "";// file location after pause the song
			// lenght of the song
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// to play song in separate thread 
	  
		new Thread () {
			public void run() {
				
				try {
					player.play();// method
				} catch ( NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					   e.printStackTrace();
				}
			}
		
			
		      }.start();
	}
	
	
	// resume method 
	public void Resume() throws JavaLayerException, IOException {
		try {
			fi=new FileInputStream(fileLocation);
			bi= new BufferedInputStream(fi);
			player= new Player(bi);
			    
			fi.skip(totalLenghtSong-pauseLocation);  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread() {			
			public void run() {
				try {
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	    // volumeUP method
	public void volumeUp() {
	   currentVol+=1; // this is current volume 0+1.0=1.0 
	   System.out.println(currentVol);
	   if (currentVol>6) { // it raise from 1.0 se
	     currentVol=6;
	}
	   control.setValue(currentVol);// set the volume
	}
	// volume Down method
	public void volumeDown() {
		currentVol-=1f; // it will decrease from -1.0 se exp -2, -3 -4 etc.
		  System.out.println(currentVol);
		if (currentVol<-80) {
		  currentVol= -80;
		}
		control.setValue(currentVol);
	}

     }
