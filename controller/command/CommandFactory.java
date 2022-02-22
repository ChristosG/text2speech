package controller.command;

import client.ViewObject;

public class CommandFactory {

	public CommandFactory(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public Command createCommand(String com) {
		
		if(com.equals("newDoc")){
			return new NewDocument(viewObj);
		}
		
		if(com.equals("open")){
			return new OpenDocument(viewObj);
		}
	
		if(com.equals("save")){
			return new SaveDocument(viewObj);
		}
		
		if(com.equals("doc")){
			return new DocumentToSpeech(viewObj);
		}
		
		if(com.equals("tune")) {
			return new TuneAudio(viewObj);
		}
		
		if(com.equals("line2sp")) {
			return new LineToSpeech(viewObj);
		}
		
		
		return null;
	}
}
