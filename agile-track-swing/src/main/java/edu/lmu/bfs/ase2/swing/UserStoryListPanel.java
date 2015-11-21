package edu.lmu.bfs.ase2.swing;

import java.awt.Color;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import edu.lmu.bfs.ase2.model.UserStory;
import edu.lmu.bfs.ase2.service.UserStoryService;

@SuppressWarnings("serial")
public class UserStoryListPanel extends JPanel implements ListSelectionListener {

	SessionFactory sessionFactory;
	Session session;
	JScrollPane UserStorylistScrollPane;
	UserStory userStory;
	UserStoryService service;
	JList<UserStory> userStoryJList;
	ChooserListener callback;
	List userStoryList;
	ChooserListener ballback;

	UserStoryListPanel() {
		getUserStories();
	}

	UserStoryListPanel(ChooserListener callback) {
		this.callback = callback;
		getUserStories();
	}

	public void getUserStories() {
		setUp();
		userStory = new UserStory();
		service = new UserStoryService();
		userStoryList = service.findAll();
		userStoryJList = new JList(userStoryList.toArray());
		userStoryJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		UserStoyListPanelCustomCellRenderer cellRenderer = new UserStoyListPanelCustomCellRenderer();
		userStoryJList.setCellRenderer(cellRenderer);
		userStoryJList.addListSelectionListener(this);
		userStoryJList.setVisibleRowCount(5);
		userStoryJList.setFixedCellHeight(30);
		userStoryJList.setFixedCellWidth(200);
		userStoryJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userStoryJList
				.setBorder(new TitledBorder(new LineBorder(Color.black),
						"List of UserStories", TitledBorder.CENTER,
						TitledBorder.CENTER));
		UserStorylistScrollPane = new JScrollPane(userStoryJList);
		UserStorylistScrollPane.setViewportView(userStoryJList);
		add(UserStorylistScrollPane);
	}

	/**
	 * Launch the application.
	 */

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getValueIsAdjusting() == false) {
			int selected = ((JList) e.getSource()).getSelectedIndex();
			UserStory userStoryObj = userStoryJList.getModel()
					.getElementAt(selected);
			callback.tell(userStoryObj);
		}
	}

	public List<UserStory> getUserStoryList() {
		return userStoryList;
	}

	public void setUp() {

		// Start Hibernate DB Transaction

		// Create the SessionFactory from hibernate.cfg.xml
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// Open the session and begin the transaction
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
}
