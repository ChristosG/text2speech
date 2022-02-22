package client;

import controller.Controller;

public class ViewObject {
	
	private String filename,author,title,date,contents;
	private Controller controller;
	private float volume = 1;
	private float pitch;
	private int flow;
	
	public ViewObject() {
		this.controller = new Controller(this);
	}
	
	public Controller getController() {
		return this.controller;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	public void setTitle(String d) {
		this.title = d;
	}
	public void setAuthor(String d) {
		this.author = d;
	}
	
	public String getDate() {
		return this.date;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	
	public void setFilename(String d) {
		this.filename = d;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public void setContents(String d) {
		this.contents = d;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public void setVolume(float v) {
		this.volume = v;
	}
	
	public float getVolume() {
		return this.volume;
	}
	
	public void setPitch(float p) {
		this.pitch = p;
	}
	
	public float getPitch() {
		return this.pitch;
	}
	
	public void setFlow(int f) {
		this.flow = f;
	}
	
	public float getFlow() {
		return this.flow;
	}
}
