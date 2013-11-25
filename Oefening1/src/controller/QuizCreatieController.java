package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizCreatieView;

public class QuizCreatieController implements ActionListener {

	private QuizCreatieView quizCreatieView;
	private Quiz quiz;
	private OpdrachtCatalogus opdrachtCatalogusModel;
	private QuizCatalogus quizCatalogusModel;

	public QuizCreatieController(QuizCreatieView quizCreatieView,
			OpdrachtCatalogus opdrachtCatalogusModel,
			QuizCatalogus quizCatalogusModel) {
			
		this.quizCreatieView = quizCreatieView;
		this.opdrachtCatalogusModel = opdrachtCatalogusModel;
		this.quizCatalogusModel = quizCatalogusModel;
		
		this.opdrachtCatalogusModel.leesOpdrachtenVanBestand();
		this.quizCatalogusModel.leesQuizzenVanBestand();
		
		quizCreatieView.buttonActionListener(this);
		String[] list = new String[5];
		for(Opdracht opdr : opdrachtCatalogusModel.getOpdrachten()){
			list[0] = opdr.getVraag();
		}
		this.quizCreatieView.getOpdrachten().setListData(list);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println("this is: "+ action);
		if(action.equals(">>>>")){
			System.out.println("button is pressed");
		}
		
	}

}
