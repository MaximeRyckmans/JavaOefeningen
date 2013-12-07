/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author Maxime Ryckmans
 *
 */
public class OpdrachtTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Vector dataVector;
	private String [] columnNames;
	
	
	public OpdrachtTableModel(String[] columnNames){
		this.dataVector= new Vector();
		this.columnNames = columnNames;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataVector.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Opdracht getValueAt(int rowIndex, int columnIndex) {
	/*	Opdracht opdracht = (Opdracht) dataVector.get(rowIndex);
		
		switch(columnIndex){
		
		case 0:
			return opdracht.getVraag();
		case 1:
			
		}*/
		return null;
	}


	public Vector getDataVector() {
		return dataVector;
	}

	public void setDataVector(Vector dataVector) {
		this.dataVector = dataVector;
	}

	public String [] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String [] columnNames) {
		this.columnNames = columnNames;
	}

}
