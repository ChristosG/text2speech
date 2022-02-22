package model;

import java.util.ArrayList;

public class Document {
	


	private String contents;
	private float volume,pitch;
	
	public Document(String contents, float volume, float pitch) {
		this.contents = contents;
		this.volume = volume;
		this.pitch = pitch;
	}
	
	public void playContents() {
		Line line = new Line(contents,volume,pitch);
		line.playLine();
	}
	
	public void playReverseContents() {
		Line line = new Line(contents,volume,pitch);
		line.playReverseLine();
	}
	
	public void playLine() {
		
	}
	

}
