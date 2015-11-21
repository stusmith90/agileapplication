package edu.lmu.bfs.ase2.swing;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import edu.lmu.bfs.ase2.dao.IMarkerEntity;

/**
 * purpose: to act as model for the table which is populated from database. this
 * class populate table based on the number of columns and rows in the database.
 * 
 * 
 */
public class CustomTableModel extends AbstractTableModel {

	int li_cols = 0;
	Vector allRows;
	Vector row;
	Vector newRow;
	Vector colNames;
	String dbColNames[];
	Vector newRows;
	boolean ibRowNew = false;


	CustomTableModel(List<IMarkerEntity> objectList) {

		newRows = new Vector();
		allRows = new Vector();
		IMarkerEntity iMarkerEntity;
		Iterator iterator = objectList.iterator();
		while (iterator.hasNext()) {
			iMarkerEntity = (IMarkerEntity) iterator.next();
			System.out.println(iMarkerEntity.getClass().toString());
			Field[] properties = iMarkerEntity.getClass().getDeclaredFields();
			li_cols = properties.length;
			dbColNames = new String[li_cols];
			newRow = new Vector();
			for (int i = 0; i < li_cols; i++) {
				dbColNames[i] = properties[i].getName();
				Method method;
				char FirstUpper = Character
						.toUpperCase(dbColNames[i].charAt(0));
				dbColNames[i] = FirstUpper + dbColNames[i].substring(1);
				try {
					method = iMarkerEntity.getClass().getMethod(
							"get" + dbColNames[i]);
					try {
						newRow.addElement(method.invoke(iMarkerEntity, null));
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			} // Endforloop

			allRows.addElement(newRow);

		}
	}

	@Override
	public Class getColumnClass(int col) {
		Object value = this.getValueAt(0, col);
		return (value == null ? Object.class : value.getClass());
		// return getValueAt(0,col).getClass();
	}

	@Override
	public boolean isCellEditable(int row, int col) {

		if (ibRowNew) {
			return true;
		}
		if (col == 0) {

			return false;
		} else {

			return true;
		}
	}

	@Override
	public String getColumnName(int col) {
		return dbColNames[col];
	}

	@Override
	public int getRowCount() {

		return allRows.size();
	}

	@Override
	public int getColumnCount() {

		return li_cols;
	}

	@Override
	public Object getValueAt(int arow, int col) {

		row = (Vector) allRows.elementAt(arow);
		return row.elementAt(col);
	}
    @Override
    public void setValueAt(Object value, int row, int col){
       
        Vector rows =  (Vector) allRows.get(row);
        Object obj = rows.elementAt(col);
        obj = value;
        fireTableCellUpdated(row, col);
     } 
}