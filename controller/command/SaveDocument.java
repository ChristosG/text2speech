package controller.command;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import client.ViewObject;

public class SaveDocument implements Command{
	
	public SaveDocument(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public void execute() {
		
		
		JFileChooser filechooser = new JFileChooser();
		 filechooser.setCurrentDirectory(new java.io.File("./")); 
		int choose = filechooser.showSaveDialog(null);
		if (choose == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			viewObj.setFilename(filename);
		}
		
		try {
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(viewObj.getFilename()));
			printWriter.write(viewObj.getContents());
			printWriter.write("\n@author");
			printWriter.write("\n"+viewObj.getAuthor());
			printWriter.write("\n@title");
			printWriter.write("\n"+viewObj.getTitle());
			printWriter.write("\n@date");
			printWriter.write("\n"+viewObj.getDate());
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
