/**
 * 
 */
package edu.lmu.bfs.ase2.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import edu.lmu.bfs.ase2.model.UserStory;

/**
 * @author bamo
 * 
 */
public class ChooserListernerImp extends JPanel implements ChooserListener{

	private UserStoryListPanel userStoryChooser;
	private TaskListPanel taskCard;
	private JPanel cards;
	private HashMap<Integer, TaskListPanel> taskMapper;
	public ChooserListernerImp(ChooserListener callback) {
		userStoryChooser = new UserStoryListPanel(this);
		add(userStoryChooser, BorderLayout.NORTH);
		cards = new JPanel(new CardLayout());
		List<UserStory> userStoryList = userStoryChooser.getUserStoryList();
		JPanel emptyPanel = new JPanel();
		taskMapper = new HashMap<Integer, TaskListPanel>();
		cards.add(emptyPanel,"Empty Panel");
		for (Object element : userStoryList) {
			UserStory userStoryObj = (UserStory) element;
			taskCard = new TaskListPanel(callback, userStoryObj);
			cards.add(taskCard, "" + userStoryObj.getId());
			taskMapper.put(userStoryObj.getId(), taskCard);
		}
	
		add(cards, BorderLayout.SOUTH);
	}

	@Override
	public void tell(Object o) {
		UserStory userStoryObj = (UserStory) o;
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "" + userStoryObj.getId());
		TaskListPanel taskPanel  = taskMapper.get(userStoryObj.getId());
		taskPanel.sayAgain();
	}
}
