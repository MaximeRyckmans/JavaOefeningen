package utils;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import controller.MenuViewController;
import controller.QuizCreatieController;
import view.MenuView;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;

public class Start {

	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		MenuViewController mv = new MenuViewController(menuView);
		//OpdrachtCreatieView viewOp = new OpdrachtCreatieView();
		
	}

}
