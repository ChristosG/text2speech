package controller.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

import client.ViewObject;

public class OpenDocument implements Command {
	
	public OpenDocument(ViewObject v) {
		this.viewObj = v;
	}
	private ViewObject viewObj;
	
	public void execute() {
		
		JFileChooser filechooser = new JFileChooser();
		 filechooser.setCurrentDirectory(new java.io.File("./")); 
		int choose = filechooser.showOpenDialog(null);
		if (choose == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			
		
		 String contents = "";
		 try {
		      File myObj = new File(filename);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        
		        if(data.equals("@author")) {
		        	viewObj.setAuthor(myReader.nextLine());
		        }
		        else if(data.equals("@title")) {
		        	viewObj.setTitle(myReader.nextLine());
		        }
		        else if(data.equals("@date")) {
		        	viewObj.setDate(myReader.nextLine());
		        }
		        else {
		        	
		        		contents += data + "\n";
		        	
		        }
		      }
		      myReader.close();
		      viewObj.setContents(contents);
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 	
		}
	}

}
