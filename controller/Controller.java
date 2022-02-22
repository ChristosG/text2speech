package controller;

import java.util.HashMap;

import client.ViewObject;
import controller.command.Command;
import controller.command.CommandFactory;

public class Controller {

	private HashMap<String, Command> commands;

	
	public Controller(ViewObject vobj) {
		commands = new HashMap<String, Command>();
		
		CommandFactory commandsFactory = new CommandFactory(vobj);
		
		Command newCommand = commandsFactory.createCommand("newDoc");
		commands.put("newDoc", newCommand);
		
		Command openCommand = commandsFactory.createCommand("open");
		commands.put("open", openCommand);
		
		Command saveCommand = commandsFactory.createCommand("save");
		commands.put("save", saveCommand);
		
		Command documentToSpeech = commandsFactory.createCommand("doc");
		commands.put("doc", documentToSpeech);
		
		Command tuneAudio = commandsFactory.createCommand("tune");
		commands.put("tune", tuneAudio);
		
		Command line2speech = commandsFactory.createCommand("line2sp");
		commands.put("line2sp", line2speech);
	
	}

	public void enact(String commandType) {
		Command command = commands.get(commandType);
		command.execute();
	}
	
}
