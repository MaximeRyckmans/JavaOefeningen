package utils;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import controller.QuizCreatieController;
import view.QuizCreatieView;

public class Start {

	public static void main(String[] args) {
		QuizCreatieView view = new QuizCreatieView();
		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		
		QuizCreatieController c = new QuizCreatieController(view, cat, qcat);
	}

}
