package controller.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import client.ViewObject;

class LineToSpeechTest {

	private ViewObject view = new ViewObject();
	@Test
	void test() {
		view.setContents("This is a dog");
		LineToSpeech doc2sp = new LineToSpeech(view);
		doc2sp.execute();
		assertEquals("This is a dog", view.getContents());
		
		view.setContents("This is a dog");
		view.setFlow(1);
		LineToSpeech doc2spReversed = new LineToSpeech(view);
		doc2spReversed.execute();
		assertEquals("This is a dog", view.getContents());
		
	}

}
