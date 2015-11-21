package edu.lmu.bfs.ase2.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
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

import edu.lmu.bfs.ase2.model.ProductBacklog;
import edu.lmu.bfs.ase2.model.Project;
import edu.lmu.bfs.ase2.model.SprintBacklog;
import edu.lmu.bfs.ase2.service.BacklogService;
import edu.lmu.bfs.ase2.service.ProjectService;
import edu.lmu.bfs.ase2.swing.backlog.BacklogDetails;
import edu.lmu.bfs.ase2.swing.backlog.ButtonColumn;


public class BacklogList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Project project;
	private List<ProductBacklog> productBacklogList;
	private List<SprintBacklog> sprintBacklogList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project project = new Project();
					project.setId(1);
					project.setName("<Test Project Name>");
					BacklogList frame = new BacklogList(project);
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
	public BacklogList(final Project project) {
		this.initialise(project);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNorth = new JLabel("Project: " + this.project.getName());
		contentPane.add(lblNorth, BorderLayout.NORTH);
		
		// set up table
		ProductBacklogTableModel tm = new ProductBacklogTableModel();
		tm.setList(productBacklogList);
		
		JTable table = new JTable(tm);
		//table.setSize(100, 100);
		// set row height
		table.setRowHeight(20);
		
		// set column width
		table.getColumnModel().getColumn(0).setPreferredWidth(360);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		
		// Edit button
		Action editAction = new AbstractAction()
		{
			private static final long serialVersionUID = -6472416564234511361L;
			
			public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		     // Open up the Backlog Details passing in the selected
				// UserStory
				ProductBacklog backlog = productBacklogList.get(modelRow);

				// PLUG INTO BACKLOG DETAILS WINDOW
				try {
					BacklogDetails frame = new BacklogDetails(backlog);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		    }
		};

		new ButtonColumn(table, editAction, 2);
				
		JScrollPane scrollPane = new JScrollPane(table);
		
		
		// set up table
		SprintBacklogTableModel sbtm = new SprintBacklogTableModel();
		sbtm.setList(sprintBacklogList);
		
		JTable sbtable = new JTable(sbtm);
		// set row height
		sbtable.setRowHeight(20);
		
		// set column width
		sbtable.getColumnModel().getColumn(0).setPreferredWidth(250);
		sbtable.getColumnModel().getColumn(1).setPreferredWidth(60);
		sbtable.getColumnModel().getColumn(2).setPreferredWidth(100);
		sbtable.getColumnModel().getColumn(3).setPreferredWidth(100);
		sbtable.getColumnModel().getColumn(4).setPreferredWidth(90);
		
		//table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		
		// Edit button
		Action sbeditAction = new AbstractAction()
		{
			private static final long serialVersionUID = -6472416564234511361L;
			
			public void actionPerformed(ActionEvent e)
		    {
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		     // Open up the Backlog Details passing in the selected
				// UserStory
				SprintBacklog backlog = sprintBacklogList.get(modelRow);

				// PLUG INTO BACKLOG DETAILS WINDOW
				try {
					BacklogDetails frame = new BacklogDetails(backlog);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		    }
		};

		new ButtonColumn(sbtable, sbeditAction, 4);
		
		JScrollPane scrollPane2 = new JScrollPane(sbtable);
		
		// add to window
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// set size of the tables
		Dimension d = new Dimension();
		d.setSize(600, 50);
		scrollPane.setPreferredSize(d);
		
		Dimension d2 = new Dimension();
		d2.setSize(600, 300);
		scrollPane2.setPreferredSize(d2);
		
		centerPanel.add("Product Backlog List",scrollPane);
		centerPanel.add("Sprint Backlog List",scrollPane2);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
	
				
		
		// Buttons at the bottom
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddPB = new JButton("Add Product Backlog");
		southPanel.add(btnAddPB);

		JButton btnAddSB = new JButton("Add Sprint Backlog");
		southPanel.add(btnAddSB);

		JButton btnClose = new JButton("Close");
		southPanel.add(btnClose);
		
		contentPane.add(southPanel, BorderLayout.SOUTH);
	}
	
	
	class ProductBacklogTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 348151783960451333L;
		List<ProductBacklog> list;

		/**
		 * @param list the list to set
		 */
		public void setList(List<ProductBacklog> list) {
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
			return 3;
		}

		/* (non-Javadoc)
		 * @see javax.swing.table.TableModel#getValueAt(int, int)
		 */
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object toReturn = "";
			switch (columnIndex) {
	        case 0:
	               toReturn = list.get(rowIndex).getName();
	               break;
	        case 1:
	        	toReturn = list.get(rowIndex).getUserStories().size();
	        	break;
	        case 2:
	        	toReturn = "View/Edit";
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
	            toReturn = "Product Backlog Name";
	            break;
	        case 1:
	        	toReturn = "Stories";
	        	break;

	        }
			return toReturn;
		}
		
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			boolean toReturn = false;
			switch (columnIndex) {
	        case 2:
	        	toReturn = true;
	        	break;
	        }
			return toReturn;
		}
	}

	class SprintBacklogTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 4539340842601837023L;
		List<SprintBacklog> list;
	
		/**
		 * @param list the list to set
		 */
		public void setList(List<SprintBacklog> list) {
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
	               toReturn = list.get(rowIndex).getName();
	               break;
	        case 1:
	        	toReturn = list.get(rowIndex).getUserStories().size();
	        	break;
	        case 2:
	        	toReturn = new SimpleDateFormat("yyyy-MM-dd").format(list.get(rowIndex).getStartDate().getTime());
	        	break;
	        case 3:
	        	toReturn = new SimpleDateFormat("yyyy-MM-dd").format(list.get(rowIndex).getEndDate().getTime());
	        	break;
	        case 4:
	        	toReturn = "View/Edit";
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
	            toReturn = "Sprint Backlog Name";
	            break;
	        case 1:
	        	toReturn = "Stories";
	        	break;
	        case 2:
	        	toReturn = "Start Date";
	        	break;
	        case 3:
	        	toReturn = "End Date";
	        	break;
	
	        }
			return toReturn;
		}
		
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			boolean toReturn = false;
			switch (columnIndex) {
			case 4:
	        	toReturn = true;
	        	break;
	        }
			return toReturn;
		}
	}

	private void initialise(Project project2) {
		// select Project by ID - use Project 1. This will be selectable later.
		ProjectService ps = new ProjectService();
		this.project = ps.getProjectById(1);
		System.out.println("project name: " + this.project.getName());

		BacklogService BacklogServiceObject = new BacklogService();

		// select Product Backlogs for Project
		productBacklogList = BacklogServiceObject
				.getProductBacklogByProjectId(this.project.getId());

		// select Sprint Backlogs for project
		sprintBacklogList = BacklogServiceObject
				.getSprintBacklogByProjectId(this.project.getId());

	}

}
