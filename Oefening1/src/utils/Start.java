package utils;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import controller.MenuViewController;
import controller.QuizCreatieController;
import view.MenuView;
import controller.QuizWijzigenController;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;
import view.QuizWijzigenView;

public class Start {

	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		MenuViewController mv = new MenuViewController(menuView);

		//QuizCreatieView view = new QuizCreatieView();
		//OpdrachtCreatieView viewOp = new OpdrachtCreatieView();
		QuizWijzigenView qW = new QuizWijzigenView();
		
		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		
		cat.leesOpdrachtenVanBestand();
		qcat.leesQuizzenVanBestand();
		
		//QuizListView qlv = new QuizListView(qcat);
		QuizWijzigenController qC = new QuizWijzigenController(qW, qcat, cat);
		//QuizCreatieController c = new QuizCreatieController(cat, qcat, view);

	}

}
