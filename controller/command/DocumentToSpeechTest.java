package controller.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import client.ViewObject;

class DocumentToSpeechTest {

	private ViewObject view = new ViewObject();
	
	
	@Test
	void test() {
		view.setContents("This is a cat");
		DocumentToSpeech doc2sp = new DocumentToSpeech(view);
		doc2sp.execute();
		assertEquals("This is a cat", view.getContents());
		
		view.setContents("This is a cat");
		view.setFlow(1);
		DocumentToSpeech doc2spReversed = new DocumentToSpeech(view);
		doc2spReversed.execute();
		assertEquals("This is a cat", view.getContents());
	}

}
