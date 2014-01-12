package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import persistency.PersistencyFacade;
import model.Observer;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.Subject;
import view.QuizCreatieView;
import view.QuizDeleteView;
import view.QuizListView;
import view.QuizWijzigenView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizListController implements ActionListener, Observer{
	
	private QuizListView quizListView;
	private QuizCatalogus quizCatalogus;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;

	public QuizListController() {}
	
	public QuizListController(QuizListView quizListView, QuizCatalogus quizCatalogus, OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.quizListView = quizListView;
		this.quizCatalogus = quizCatalogus;
		this.quizCatalogus.registreerObserver(this);
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.facade = facade;
		
		quizListView.createNodes(quizCatalogus);
		quizListView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Creëer nieuwe quiz")) {
			QuizCreatieView quizCreatieView = new QuizCreatieView();
			QuizCreatieController quizCreatieController = new QuizCreatieController(opdrachtCatalogus, quizCatalogus, quizCreatieView, facade);
		}else if (e.getActionCommand().equals("Wijzigen van een quiz")) {
			QuizWijzigenView quizWijzigenView = new QuizWijzigenView("Wijzig quiz");
			QuizWijzigenController quizWijzigenController = new QuizWijzigenController(quizWijzigenView, quizCatalogus, opdrachtCatalogus, facade);
		}else if (e.getActionCommand().equals("Verwijder quiz")) {
			QuizDeleteView quizDeleteView = new QuizDeleteView();
			QuizDeleteController quizDeleteController = new QuizDeleteController(quizDeleteView, quizCatalogus);
		}
	}
	//updates the tree with the new information
	@Override
	public void update(Subject subject) {
		
		this.quizCatalogus=(QuizCatalogus)subject;
		quizListView.createNodes(this.quizCatalogus);
		quizListView.getTree().updateUI();
	}
}