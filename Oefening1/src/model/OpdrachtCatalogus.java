package model;

import java.util.List;
/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 *
 */
public class OpdrachtCatalogus {

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
}
