package edu.lmu.bfs.ase2.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.lmu.bfs.ase2.dao.impl.UserStoryDAOImpl;
import edu.lmu.bfs.ase2.model.UserStory;

public class Runner extends JPanel {

	private JTable table;
	SessionFactory sessionFactory;
	GridBagConstraints gc = new GridBagConstraints();
	private JButton productBacklogButton	= new JButton("Product backlog");
	private JButton userStoryButton			= new JButton("User story");
	private JButton sprintBacklogButton		= new JButton("Sprint backlog");
	private JButton taskButton				= new JButton("Task");
	private JButton deleteButton            = new JButton("Delete record");
	private JButton addButton              	= new JButton("Add new record");
	private JPanel buttonMenuPanel          = new JPanel();
	private JPanel jTablePanelHolder        = new JPanel();	
    
    public Runner() {
        this.setFont(new Font("Verdana", Font.PLAIN,  20));
        this.setPreferredSize(new Dimension(1100,600)); 
        setUp();
        initComponents();
	}
	public void setUp(){

		// Start Hibernate DB Transaction

		// Create the SessionFactory from hibernate.cfg.xml
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// Open the session and begin the transaction
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public void initComponents() {
		jTablePanelHolder.setLayout(new GridLayout(0,1));
		buttonMenuPanel.setLayout(new GridBagLayout());

        // specify button positions and alignment
        gc = new GridBagConstraints();
        gc.ipadx =35;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.NORTHWEST;    
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(productBacklogButton, gc);
        
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weighty = 0.0;
        gc.ipadx = 6;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(sprintBacklogButton, gc);

        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 2;
        gc.weighty = 0.0;
        gc.ipadx = 17;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(userStoryButton, gc);


        gc = new GridBagConstraints();
        gc.ipadx = 13;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(taskButton, gc);

        gc = new GridBagConstraints();
        gc.ipadx = 7;
        gc.gridx = 0;
        gc.gridy = 4;
        gc.weighty = 0.0;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(addButton, gc);

        gc = new GridBagConstraints();
        gc.ipadx =0;
        gc.gridx = 0;
        gc.gridy = 5;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.insets = new Insets(6, 6, 6, 6);
        buttonMenuPanel.add(deleteButton, gc);
		
		setBounds(100, 100, 450, 300);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
        // group buttonpanel and tableholderpanel horizontally and vertically
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
		UserStory userStory = new UserStory();
		UserStoryDAOImpl dao = new UserStoryDAOImpl(sessionFactory);
		table = new JTable(new CustomTableModel(dao.listEntity(userStory)));
		JScrollPane jScrollPane1 = new JScrollPane(table);
           table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION); // only sinlge selection allowed
           table.setRowSorter(new TableRowSorter(new CustomTableModel(dao.listEntity(userStory)))); // sorting rows to java TableRowSorter
           jScrollPane1.setViewportView(table);
           jScrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Object Table", WIDTH, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
           jTablePanelHolder.add(jScrollPane1);
           this.add(jTablePanelHolder);
           renderTableCell(table); // customise/render table cells colums
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonMenuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTablePanelHolder, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonMenuPanel, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTablePanelHolder, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

	}

    /**
     * sets the default renderer for the table
     */
    public static void renderTableCell(JTable table){
        
        table.setDefaultRenderer(Object.class, new CustomRenderer());
        table.setDefaultRenderer(Integer.class, new CustomRenderer());
        table.setDefaultRenderer(String.class, new CustomRenderer());
        //dbTable.setDefaultRenderer(Double.class, new CustomRenderer());
        //table.setDefaultRenderer(Float.class, new CustomRenderer());
    } 
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		try {
			f.setVisible(true);
			f.add(new Runner());
			f.pack();
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
