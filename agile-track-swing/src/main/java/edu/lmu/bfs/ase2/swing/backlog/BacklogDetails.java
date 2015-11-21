package edu.lmu.bfs.ase2.swing.backlog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import edu.lmu.bfs.ase2.model.Backlog;
import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.UserStory;
import edu.lmu.bfs.ase2.service.BacklogService;
import edu.lmu.bfs.ase2.swing.gui.UserStoryDetailsPanel;


public class BacklogDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BacklogDetails frame = new BacklogDetails(mockProductBacklog());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BacklogDetails(final Backlog backlog) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNorth = new JLabel("Backlog: " + backlog.getName());
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		// set up table
		UserStoryTableModel tm = new UserStoryTableModel();
		tm.setList(backlog.getUserStories());
		
		JTable table = new JTable(tm);
		// set row height
		table.setRowHeight(20);
		
		// set column width
		table.getColumnModel().getColumn(0).setPreferredWidth(360);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		
		//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		
		// Edit button
		Action editAction = new AbstractAction()
		{
			private static final long serialVersionUID = -6472416564234511361L;

			public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        // Open up the User Story Details passing in the selected UserStory
		        UserStory story = backlog.getUserStories().get(modelRow);
		        
		        // PLUG INTO USER STORY DETAILS WINDOW
		        JFrame frame = new JFrame("UserStory Details");
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.getContentPane().add(new UserStoryDetailsPanel(story.getId()));
				frame.setVisible(true);
				frame.pack();
		    }
		};

		new ButtonColumn(table, editAction, 3);
		
		// Move button
		Action moveAction = new AbstractAction()
		{
			private static final long serialVersionUID = -8359888370077953911L;

			public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        // Open up the Select Backlog Dialog passing in the selected UserStory
		        UserStory story = backlog.getUserStories().get(modelRow);
		        
		        // TODO PLUG INTO SELECT BACKLOG WINDOW
		    }
		};

		new ButtonColumn(table, moveAction, 4);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		// Buttons at the bottom
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddUserStory = new JButton("Add User Story");
		southPanel.add(btnAddUserStory);
		
		JButton btnClose = new JButton("Close");
		southPanel.add(btnClose);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
	}

	private static Backlog mockProductBacklog()
	{
		Backlog backlog = new ProductBacklog();
		
		BacklogService backlogService = new BacklogService();
		backlog = backlogService.getProductBacklogById(52);
		
		return backlog;
	}
	
	
	class UserStoryTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 348151783960451333L;
		List<UserStory> list;

		/**
		 * @param list the list to set
		 */
		public void setList(List<UserStory> list) {
			this.list = list;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getRowCount()
		 */
		@Override
		public int getRowCount() {
			return list.size();
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getColumnCount()
		 */
		@Override
		public int getColumnCount() {
			return 5;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object toReturn = "";
			switch (columnIndex) {
	        case 0:
	               toReturn = list.get(rowIndex).getTitle();
	               break;
	        case 1:
	        	toReturn = list.get(rowIndex).getPriority();
	        	break;
	        case 2:
	        	toReturn = list.get(rowIndex).getStoryPointEstimate();
	        	break;
	        case 3:
	        	toReturn = "View/Edit";
	        	break;
	        case 4:
	        	toReturn = "Move";
	        	break;
	        }
			return toReturn;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
		 */
		@Override
		public String getColumnName(int column) {
			String toReturn = "";
			switch (column) {
	        case 0:
	            toReturn = "User Story";
	            break;
	        case 1:
	        	toReturn = "Priority";
	        	break;
	        case 2:
	        	toReturn = "Estimate";
	        	break;

	        }
			return toReturn;
		}
		
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			boolean toReturn = false;
			switch (columnIndex) {
	        case 3:
	        case 4:
	        	toReturn = true;
	        	break;
	        }
			return toReturn;
		}
	}


}
