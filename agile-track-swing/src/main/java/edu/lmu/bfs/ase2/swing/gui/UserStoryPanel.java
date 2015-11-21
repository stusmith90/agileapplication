package edu.lmu.bfs.ase2.swing.gui;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.lmu.bfs.ase2.model.UserStory;
import edu.lmu.bfs.ase2.service.UserStoryService;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;

public class UserStoryPanel extends JPanel {

	
	UserStoryService userStoryService = new UserStoryService();
	UserStory userStory;
	private final JTextField title = new JTextField();
	private final JTextArea description = new JTextArea();
	private final JTextArea acceptanceCriteria = new JTextArea();
	/**
	 * Create the panel.
	 */
	public UserStoryPanel(int id) {
		userStory = (UserStory)userStoryService.getUserStoryById(id);
		title.setBackground(UIManager.getColor("nimbusBase"));
		title.setText(userStory.getTitle());
		title.setEditable(false);
		title.setColumns(10);
		setLayout(new BorderLayout(0, 0));
		
		add(title, BorderLayout.NORTH);
		description.setForeground(Color.BLACK);
		description.setLineWrap(true);
		description.setText(userStory.getDescription());
		
		add(description, BorderLayout.CENTER);
		acceptanceCriteria.setBackground(UIManager.getColor("nimbusBase"));
		acceptanceCriteria.setLineWrap(true);
		acceptanceCriteria.setText(userStory.getAcceptanceCriteria());
		
		add(acceptanceCriteria, BorderLayout.SOUTH);
		userStory = (UserStory) userStoryService.getUserStoryById(8);
		preparePanel();
	}

	private void preparePanel(){
		setPreferredSize(new Dimension(300,400));
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("UserStory Details");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new UserStoryPanel(8));
		frame.setVisible(true);
		frame.pack();
	}
}
