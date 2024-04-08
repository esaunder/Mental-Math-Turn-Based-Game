import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	void playMusic(String musicLocation) {
		if (musics == true) {
			try {	
				File musicpath = new File(musicLocation);
				if (musicpath.exists()) {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
					clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					music1 = true;
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					
				}
				else {
					
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	void playSound(String musicLocation) {
		if (musics == true) {
			try {	
				File musicpath = new File(musicLocation);
				if (musicpath.exists()) {
					AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicpath);
					clip = AudioSystem.getClip();
					clip.open(audioInput);
					clip.start();
					music1 = true;
				}
				else {
					
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	void stopMusic() {
		music1 = false;
		clip.close();
	}
	void pauseMusic() {
		i = clip.getMicrosecondPosition();
		clip.stop();
	}
	void resumeMusic() {
		try {
				int lo = (int) (i/clip.getMicrosecondLength());
				clip.setMicrosecondPosition(i - clip.getMicrosecondLength() * lo);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Clip clip;
	long i = 0;
	public static boolean musics = true; 
	public static boolean music1 = false;
}