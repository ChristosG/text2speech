package controller.command;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import client.ViewObject;

class SaveDocumentTest {

	private ViewObject viewobj = new ViewObject();
	
	@Test
	void test() {
		viewobj.setContents("This is a catdog");
		viewobj.setFilename("./catdog");
		viewobj.setAuthor("Apostolos");
		viewobj.setTitle("Titlos");
		SaveDocument saveDoc = new SaveDocument(viewobj);
		saveDoc.execute();
		
		
		ViewObject view = new ViewObject();
		OpenDocument openDoc = new OpenDocument(view);
		openDoc.execute();
		assertEquals("This is a catdog"+"\n", view.getContents());
		assertEquals("Apostolos", view.getAuthor());
		assertEquals("Titlos", view.getTitle());	 	
		 
		 
		 
	}

}
