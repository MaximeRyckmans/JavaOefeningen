package model;

import java.util.List;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class OpdrachtCatalogus implements Cloneable,Comparable<OpdrachtCatalogus>{

	private List<Opdracht> opdrachten;

	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}

	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
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
		// TODO Auto-generated method stub
		return 0;
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
	
}
