package utils;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import controller.QuizCreatieController;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;

public class Start {

	public static void main(String[] args) {
		QuizCreatieView view = new QuizCreatieView();
		OpdrachtCreatieView viewOp = new OpdrachtCreatieView();
		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		
		QuizCreatieController c = new QuizCreatieController(view, cat, qcat);
	}

}
