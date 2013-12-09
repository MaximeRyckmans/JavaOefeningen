package utils;

import java.util.List;

import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import controller.QuizCreatieController;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;
import view.QuizWijzigenView;

public class Start {

	public static void main(String[] args) {
		QuizCreatieView view = new QuizCreatieView();
		OpdrachtCreatieView viewOp = new OpdrachtCreatieView();
		OpdrachtCatalogus cat = new OpdrachtCatalogus();
		QuizCatalogus qcat = new QuizCatalogus();
		
		QuizCreatieController c = new QuizCreatieController(cat, qcat, view);
		//QuizListView qlv = new QuizListView(qcat);
	
		//QuizWijzigenView qW = new QuizWijzigenView();
	}

}
