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
	
	
	private List<Opdracht> data = null;
	private String [] columnNames;
	
	
	public OpdrachtTableModel(String[] columnNames, List<Opdracht> data){
		this.data= new ArrayList<>(data) ;
		this.columnNames = columnNames;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Opdracht opdracht = (Opdracht) data.get(rowIndex);
		Object waarde=null;
		switch(columnIndex){
		
		case 0:
			waarde= opdracht.getVraag();
			break;
		case 1:
			waarde = opdracht.getMaxAantalPunten();
			
		}
		return waarde;
	}

	public String [] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String [] columnNames) {
		this.columnNames = columnNames;
	}

	public List<Opdracht> getData() {
		return data;
	}

	public void setData(List<Opdracht> data) {
		this.data = data;
	}

}
