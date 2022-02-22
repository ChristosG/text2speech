package model;

import java.util.ArrayList;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.*;

public class Line {
	
	private ArrayList<String> words;
	private float volume,pitch;
	private VoiceManager voiceManager;
	private Voice voice;
	
	public Line(String c, float vol, float pit) {
		this.words = new ArrayList<String>();
		String[] contents = c.split("\\s*(=>|\n|\\s)\\s*");
		for(String word : contents) {
			this.words.add(word);
		}
		this.volume = vol;
		this.pitch = pit;
		this.voiceManager = VoiceManager.getInstance();
		this.voice = voiceManager.getVoice("kevin");
		this.voice.allocate();
		
	}
	
	public void playLine() {

		
		this.voice.setVolume(this.volume);
		this.voice.setPitch(this.pitch);	
		for(String word : words) {
			this.voice.speak(word);
		}
	}
	
	public void playReverseLine() {
		this.voice.setVolume(this.volume);
		this.voice.setPitch(this.pitch);
		
		ArrayList<String> revArrayList = new ArrayList<String>();
		for (int i = words.size() - 1; i >= 0; i--) { 
            revArrayList.add(words.get(i)); 
            
        } 
		
		for(String word : revArrayList) {
			this.voice.speak(word);
		}
	}
	
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
		
	public void setVolume(float vol) {
		this.volume = vol;
	}
	

}
