package controller.command;

import client.ViewObject;
import model.Document;

public class DocumentToSpeech implements Command {

	public DocumentToSpeech(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public void execute() {
		
		if(viewObj.getFlow()==0) {
			Document document = new Document(viewObj.getContents(), viewObj.getVolume(), viewObj.getPitch());
			document.playContents();
		}
		
		if(viewObj.getFlow()==1) {
			Document document = new Document(viewObj.getContents(), viewObj.getVolume(), viewObj.getPitch());
			document.playReverseContents();
		}
		
	}
}
