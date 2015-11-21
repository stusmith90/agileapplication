package edu.lmu.bfs.ase2.swing;

import java.awt.Color;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.lmu.bfs.ase2.model.Task;
import edu.lmu.bfs.ase2.model.UserStory;
import edu.lmu.bfs.ase2.swing.gui.AddUserStoryPanel;

/**
 * @author Bamo
 * This is calls is responsible for creating list of {@link Task}s
 * for each {@link UserStory}
 */
@SuppressWarnings("serial")
public class TaskListPanel extends JPanel implements ListSelectionListener {

	/**
	 * set of {@link Task}s
	 */
	private Set<Task> taskSet;
	
	/**
	 * JList list of {@link Task}s
	 */
	private JList<Task> taskJList;
	
	/**
	 * JScrollPane to hold Jlist of {@link Task}s
	 */
	private JScrollPane tasklistScrollPane;
	
	/**
	 *  an instance of {@link ChooserListener}
	 *  the instance passes itself to this class to notify 
	 *  events
	 */
	private ChooserListener callback;

	/**
	 * Create the panel.
	 * @param callback the instance of {@link ChooserListener}
	 * @param userStory instacne of {@link UserStory}
	 */
	public TaskListPanel(ChooserListener callback, UserStory userStory) {
		
		this.callback = callback;
		getTask(userStory);
		
	}
	
	public void getTask(UserStory userStory){
		
		taskSet = userStory.getTaskSet();
		taskJList = new JList(taskSet.toArray());
		tasklistScrollPane = new JScrollPane();
		taskJList.addListSelectionListener(this);
		taskJList.setVisibleRowCount(5);
		taskJList.setFixedCellHeight(30);
		taskJList.setFixedCellWidth(250);
		taskJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taskJList.setBorder(new TitledBorder(new LineBorder(Color.black),
				"List of Tasks", TitledBorder.CENTER, TitledBorder.CENTER));
		taskJList.setCellRenderer(new TaskCustomCellRenderer());
		tasklistScrollPane.add(taskJList);
		tasklistScrollPane.setViewportView(taskJList);
		add(tasklistScrollPane);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			int selected = ((JList<?>) e.getSource()).getSelectedIndex();
			Task tas = taskJList.getModel().getElementAt(selected);
			System.out.println(tas.getName());
			//callback.tell(tas);
		}
	}

    public void sayAgain()
    {
        int selected = taskJList.getSelectedIndex();
        if (selected < 0)
        {
            callback.tell(null);
        }
        else
        {
			Task task = taskJList.getModel().getElementAt(selected);
			callback.tell(task);
        }
    }
    
    public JFrame display(){
    	JFrame f = new JFrame();
    	f.add(this);
    	f.setVisible(true);
    	f.pack();
    	f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		return f;
    }
}
