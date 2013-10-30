package model;

import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class OpdrachtCatalogus implements Cloneable,Comparable<OpdrachtCatalogus>, Iterable<Opdracht>{

	private List<Opdracht> opdrachten;
	private int id;

	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addOpdrachtToList(Opdracht opdracht){
		if(!opdracht.equals(null) || !opdrachten.contains(opdracht)){
			this.opdrachten.add(opdracht);
		}
	}
	public void removeOpdrachtFromList(Opdracht opdracht){
		if(opdrachten.contains(opdracht)){
			this.opdrachten.remove(opdracht);
		}
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		final int BEFORE = -1;
		final int  EQUAL = 0;
		final int AFTER = 1;
		
		if(this == o) return EQUAL;
		
		if (this.id < o.id) return BEFORE;
		return AFTER;		
	}

	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpdrachtCatalogus other = (OpdrachtCatalogus) obj;
		if (opdrachten == null) {
			if (other.opdrachten != null)
				return false;
		} else if (!opdrachten.equals(other.opdrachten))
			return false;
		return true;
	}

	@Override
	public Iterator<Opdracht> iterator() {
		return opdrachten.iterator();
	}
	
}
