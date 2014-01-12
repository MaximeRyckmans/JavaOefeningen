package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import persistency.PersistencyFacade;
import model.Klas;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizStatus;
import view.QuizWijzigenView;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 * 
 */

public class QuizWijzigenController extends QuizController {

	private QuizWijzigenView quizWijzigenView;
	private QuizCatalogus quizCatalogus;
	private OpdrachtCatalogus opdrachtCatalogus;
	private Quiz quiz, copyQuizOld;
	private PersistencyFacade facade;

	public QuizWijzigenController() {
	}

	public QuizWijzigenController(QuizWijzigenView quizWijzigenView,
			QuizCatalogus quizCatalogus, OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.quizWijzigenView = quizWijzigenView;
		this.quizCatalogus = quizCatalogus;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.facade = facade;
		quizWijzigenView.setInitiëleWaarden(quizCatalogus.getQuizzen(),
				opdrachtCatalogus.getOpdrachten());
		quizWijzigenView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voeg opdracht toe aan quiz")) {
			voegOpdrachtToeAanQuiz();
		} else if (e.getActionCommand().equals(" Verwijder opdracht in quiz ")) {
			verwijderOpdrachtInQuiz();
		} else if (e.getActionCommand().equals("Alle wijzigingen opslaan")) {
			if (!quizWijzigenView.getCmbbxLeraar().getSelectedItem()
					.equals(quizWijzigenView.getNotSelectableOption())
					|| !quizWijzigenView.getCmbbxQuizStatus().getSelectedItem()
							.equals(quizWijzigenView.getNotSelectableOption())) {
				wijzigingQuizOpslaan();
			} else {
				quizWijzigenView.popUpWindow();
			}
		} else if (e.getActionCommand().equals("Wijzig quiz")) {
			wijzigQuiz();
		} else if (e.getActionCommand().equals("Annuleer")) {
			annuleer();
		} 
	}

	private void annuleer() {
		quizWijzigenView.confirmationWindow(
				"Ben je zeker dat je de wijzigingen wilt annuleren?",
				"Annuleer wijzigingen");

		if (quizWijzigenView.isTrueIndicator()) {
			for (Quiz q : quizCatalogus.getQuizzen()) {
				if (q.getId() == copyQuizOld.getId()) {
					q = copyQuizOld;
				}
			}
			quizWijzigenView.closeWindow();
		}
	}

	private void wijzigQuiz() {
		quiz = quizWijzigenView.getListQuizzen().getSelectedValue();
		copyQuizOld = quiz.clone();
		quizWijzigenView.setOpdrachtenInQuiz(quiz);
	}

	private void wijzigingQuizOpslaan() {
		quizWijzigenView.confirmationWindow(
				"Ben je zeker dat je deze wijzigingen wilt opslaan?",
				"Opslaan wijzigingen");
		if (quizWijzigenView.isTrueIndicator()) {
			String parse = quizWijzigenView.getTxtAantalDeelnames().getText();
			quiz.setAantalDeelnames(Integer.parseInt(parse));

			for (Klas klas : Klas.values()) {
				if (klas.toString().equals(
						quizWijzigenView.getCmbbxLeerjaar().getSelectedItem())) {
					quiz.setLeerjaar(klas);
				}
			}

			for (Leraar leraar : Leraar.values()) {
				if (leraar.toString().equals(
						quizWijzigenView.getCmbbxLeraar().getSelectedItem())) {
					quiz.setLeraar(leraar);
				}
			}

			quiz.setOnderwerp(quizWijzigenView.getTxtOnderwerp().getText());

			for (QuizStatus quizStatus : QuizStatus.values()) {
				if (quizStatus.toString()
						.equals(quizWijzigenView.getCmbbxQuizStatus()
								.getSelectedItem())) {
					quiz.setQuizStatus(quizStatus);
				}
			}
			facade.getPersistable().wijzigQuiz(quiz, quizCatalogus);
			quizWijzigenView.closeWindow();
		}
	}

	private void verwijderOpdrachtInQuiz() {
		int row = quizWijzigenView.getTableOpdrachtenInQuiz().getSelectedRow();
		String vraag = quizWijzigenView.getTableOpdrachtenInQuiz()
				.getValueAt(row, 0).toString();
		try {
			quizWijzigenView.removeOpdrachtInQuiz(quiz, vraag);
		} catch (Exception e) {
			System.out.println(e);
		}
		quizWijzigenView.setOpdrachtenInQuiz(quiz);

	}

	private void voegOpdrachtToeAanQuiz() {
		try {
			if (!isToegevoegdeOpdracht(quiz.getOpdrachten(), quizWijzigenView
					.getListOpdrachten().getSelectedValue())) {
				for (Opdracht opdracht : opdrachtCatalogus.getOpdrachten()) {
					if (opdracht.equals(quizWijzigenView.getListOpdrachten()
							.getSelectedValue())) {

						quiz.getOpdrachten().add(opdracht);
						quizWijzigenView.setOpdrachtenInQuiz(quiz);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
