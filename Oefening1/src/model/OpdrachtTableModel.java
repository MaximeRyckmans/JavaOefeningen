/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

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
	
	private List <Opdracht> opdrachtLijst;
	private String [] columnNames = {"Vraag", "Maximum score"};
	
	
	public OpdrachtTableModel(){
		this.opdrachtLijst= new ArrayList<Opdracht>();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return opdrachtLijst.size();
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
		return null;
	}

	/**
	 * @return the opdrachtLijst
	 */
	public List<Opdracht> getOpdrachtLijst() {
		return opdrachtLijst;
	}

	/**
	 * @param opdrachtLijst the opdrachtLijst to set
	 */
	public void setOpdrachtLijst(List<Opdracht> opdrachtLijst) {
		this.opdrachtLijst = opdrachtLijst;
	}

}
