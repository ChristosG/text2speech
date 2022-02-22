package controller.command;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import client.ViewObject;

public class NewDocument implements Command {
	
	public NewDocument(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public void execute() {
		
		LocalDateTime date = LocalDateTime.now();
		viewObj.setDate(String.valueOf(date));
		viewObj.setTitle(JOptionPane.showInputDialog("Title of Document"));
		viewObj.setAuthor(JOptionPane.showInputDialog("Author of Document"));
		
	}

}
