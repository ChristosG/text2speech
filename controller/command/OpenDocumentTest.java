package controller.command;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import client.ViewObject;

class OpenDocumentTest {

	
	private ViewObject view = new ViewObject();
	private OpenDocument openDoc = new OpenDocument(view);
	
	@Test
	void test() {
		
		view.setContents("This is a dog");
		view.setAuthor("Apostolos");
		view.setTitle("Titlos");
		
		SaveDocument saveDoc = new SaveDocument(view);
		saveDoc.execute();
		openDoc.execute();
		assertEquals("This is a dog"+"\n", view.getContents());
		assertEquals("Apostolos", view.getAuthor());
		assertEquals("Titlos", view.getTitle());	 	
	}

}
