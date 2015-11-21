package edu.lmu.bfs.ase2.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import edu.lmu.bfs.ase2.model.Task;

@SuppressWarnings("serial")
public class TaskCustomCellRenderer extends JLabel implements ListCellRenderer<Object> {
	private ImageIcon icon = new ImageIcon(TaskCustomCellRenderer.class.getResource("/user.png"));
	private Component c;
	private Task task;
	private Boolean selected;
	private Integer index;

	public TaskCustomCellRenderer() {
		super();
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		task = (Task) value;
		String title = task.getName();
		setText(title);
		this.index = index;
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
		g2d.setPaint(new Color(37, 199, 32));
		if (task.isAssigned()) {
			g2d.drawImage(icon.getImage(),
					getWidth () - 9 - 5 - icon.getIconWidth () / 2,
					getHeight () / 2 - icon.getIconHeight () / 2, null);
			//setToolTipText("Assigned to "+task.getProductOwner().getName());
		}else{
			g2d.draw(ellipse);
			g2d.fill(ellipse);
		}
		super.paintComponent(g);
	}
}
