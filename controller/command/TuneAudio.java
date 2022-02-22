package controller.command;

import client.ViewObject;

public class TuneAudio implements Command{

	public TuneAudio(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public void execute() {
		
		System.out.println(viewObj.getPitch());
		System.out.println(viewObj.getVolume());
	
	}
}
