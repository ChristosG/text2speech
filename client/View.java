package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class View {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		viewObject =  new ViewObject();
		initialize();
		
	}

	
	private JScrollPane scrollPanel = new JScrollPane();
	private JEditorPane editorPanel = new JEditorPane();
	private ViewObject viewObject;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(scrollPanel, BorderLayout.CENTER);
		scrollPanel.setViewportView(editorPanel);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBounds(0, 0, 450, 30);
		frame.getContentPane().add(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		
		JMenuItem newFile = new JMenuItem("New Document");
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPanel.setBounds(5, 45 , 425 , 210);

				viewObject.getController().enact("newDoc");
			}
		});
		file.add(newFile);
		
		JMenuItem openFile = new JMenuItem("Open Document");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPanel.setBounds(5, 45 , 425 , 210);
				viewObject.getController().enact("open");
				editorPanel.setText(viewObject.getContents());
				System.out.println("Author: "+viewObject.getAuthor());
				System.out.println("Title: "+viewObject.getTitle());
				System.out.println("Date: "+viewObject.getDate());
			}
		});
		file.add(openFile);
		
		JMenuItem saveFile = new JMenuItem("Save Document");
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewObject.setContents(editorPanel.getText());			
				viewObject.getController().enact("save");
			}
		});
		file.add(saveFile);
		
		
		
		JMenu play = new JMenu("Play");
		menubar.add(play);
		
		JMenuItem playContents = new JMenuItem("Play Contents");
		playContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewObject.setContents(editorPanel.getText());
				viewObject.setFlow(0);
				viewObject.getController().enact("doc");
				
			}
		});
		play.add(playContents);
		
		JMenuItem playReverse = new JMenuItem("Play Reverse Contents");
		playReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewObject.setContents(editorPanel.getText());
				viewObject.setFlow(1);
				viewObject.getController().enact("doc");
				
			}
		});
		play.add(playReverse);
		
		
		
		JMenu playlines = new JMenu("PlaySelectedLine");
		menubar.add(playlines);
		
		JMenuItem playLine = new JMenuItem("Play Line");
		playLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				viewObject.setContents(editorPanel.getSelectedText());
				viewObject.setFlow(0);
				viewObject.getController().enact("line2sp");
				
			}
		});
		playlines.add(playLine);
		
		JMenuItem playReverseLine = new JMenuItem("Play Reversed Line");
		playReverseLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				viewObject.setContents(editorPanel.getSelectedText());
				viewObject.setFlow(1);
				viewObject.getController().enact("line2sp");
				
			}
		});
		playlines.add(playReverseLine);
		
		JMenu tuner = new JMenu("Tune");
		menubar.add(tuner);
		
		JMenuItem pitchName = new JMenuItem("Pitch");
		tuner.add(pitchName);
		
		JSlider pitch = new JSlider();
		pitch.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		        
		    	float value = pitch.getValue();		       
		        viewObject.setPitch(value);
		        viewObject.getController().enact("tune");

		      }
		    });
		
		tuner.add(pitch);
		
		JMenuItem volumeName = new JMenuItem("Volume");
		tuner.add(volumeName);
		JSlider volume = new JSlider();
		volume.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		        
		    	float value = volume.getValue();
		        viewObject.setVolume(value/100);
		        viewObject.getController().enact("tune");

		      }
		    });
		
		tuner.add(volume);
		
	}

}
