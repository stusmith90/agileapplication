package edu.lmu.bfs.ase2.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;
import edu.lmu.bfs.ase2.model.UserStory;

@SuppressWarnings("serial")
public class UserStoyListPanelCustomCellRenderer extends JLabel implements ListCellRenderer<Object> {
	Component c;
	UserStory userStory;
	Boolean selected;
	Integer index;
	List<IMarkerEntity> userStories;
	java.util.Set<edu.lmu.bfs.ase2.model.Task> task;

	public UserStoyListPanelCustomCellRenderer() {
		super();
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		userStory = (UserStory) value;
		String title = userStory.getTitle();
		setText(title);
		this.index = index;
		this.task = userStory.getTaskSet();
		//setIcon((title.length() > 10) ? longIcon : shortIcon);
		selected = isSelected;
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(false);
		return this;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (selected) {
            Area area = new Area (new Rectangle(getWidth(), getHeight()) );
            g2d.setPaint ( Color.lightGray );
            g2d.fill ( area );
		} 

		Ellipse2D.Double ellipse = new Ellipse2D.Double(getWidth() - 20 - 5,
				getHeight() / 2 - 9, 20, 20);
		
		g2d.draw(ellipse);
		g2d.setPaint(new Color(37, 199, 32));
		g2d.fill(ellipse);
		final String text =  ""+this.task.size();
		final Font oldFont = g2d.getFont();
		g2d.setFont(oldFont.deriveFont(oldFont.getSize() - 1f));
		final FontMetrics fm = g2d.getFontMetrics();
		g2d.setPaint(Color.WHITE);
		g2d.drawString(
				text,
				getWidth() - 9 - 5 - fm.stringWidth(text) / 2,
				getHeight() / 2
						+ (fm.getAscent() - fm.getLeading() - fm.getDescent())
						/ 2);
		g2d.setFont(oldFont);
		super.paintComponent(g);
	}
}
