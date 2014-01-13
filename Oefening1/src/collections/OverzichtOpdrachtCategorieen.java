package collections;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import persistency.PersistencyFacade;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;

/**
 * 
 * @author Pulinx Davy
 *
 */

public class OverzichtOpdrachtCategorieen {

	private Map hashMap;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;
	
	public OverzichtOpdrachtCategorieen() {
		try {
			opdrachtCatalogus = new OpdrachtCatalogus();
			facade = new PersistencyFacade();
			
			facade.getPersistable().getAlleOpdrachten(opdrachtCatalogus);
				
			hashMap = new HashMap();
			
			hashMap.put(OpdrachtCategorie.Aardrijkskunde, 0);
			hashMap.put(OpdrachtCategorie.Nederlands, 0);
			hashMap.put(OpdrachtCategorie.Wetenschappen, 0);
			hashMap.put(OpdrachtCategorie.Wiskunde, 0);
			
			for (Object keyString : hashMap.keySet()) {
				getAantal(keyString);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void getAantal(Object categorie){
		for (Opdracht opdracht : opdrachtCatalogus.getOpdrachten()) {
			if (opdracht.getOpdrachtCategorie().toString() == categorie.toString()) {
				int i = ((Integer) hashMap.get(categorie)).intValue();
				i++;
				hashMap.put(categorie, i);
			}
		}
	}
	
	public static void main(String[] args){
		OverzichtOpdrachtCategorieen oC = new OverzichtOpdrachtCategorieen();
		
		System.out.println(oC.hashMap);
	}
}
