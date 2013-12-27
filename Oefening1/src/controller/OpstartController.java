package controller;

import persistency.Persistable;
import persistency.PersistencyFacade;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import utils.BeheerInitBestand;
import view.MenuView;

public class OpstartController {

	public OpstartController() {
		
		BeheerInitBestand beheerinitBestand = new BeheerInitBestand();
		beheerinitBestand.keuzePersistentieMethode();
		MenuView menuView = new MenuView();

		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		PersistencyFacade facade = new PersistencyFacade();

		MenuViewController mv = new MenuViewController(menuView, qcat, cat, facade);
	}

}
