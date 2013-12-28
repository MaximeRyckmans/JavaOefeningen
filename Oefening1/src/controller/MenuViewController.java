package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistency.PersistencyFacade;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import view.MenuView;
import view.OpdrachtListView;
import view.QuizListView;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class MenuViewController implements ActionListener {
	private MenuView menuView;
	private QuizCatalogus qCat;
	private OpdrachtCatalogus opdrachtCatalogus;
	private PersistencyFacade facade;

	public MenuViewController(MenuView menuView, QuizCatalogus quizCatalogus,
			OpdrachtCatalogus opdrachtCatalogus, PersistencyFacade facade) {
		this.menuView = menuView;
	//	this.qCat = quizCatalogus;
		this.opdrachtCatalogus = opdrachtCatalogus;
		this.facade=facade;

		facade.getPersistable().getAlleOpdrachten(opdrachtCatalogus);
		this.qCat = quizCatalogus;

		facade.getPersistable().getAlleQuizzen(opdrachtCatalogus, quizCatalogus);
		menuView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Lijst van Quizzen")) {
			QuizListView view = new QuizListView();
			QuizListController controller = new QuizListController(view, qCat,
					opdrachtCatalogus);
			/*
			 * QuizCreatieView view = new QuizCreatieView(); new
			 * QuizCreatieController(cat, qcat, view);
			 */
		} else if (action.equals("Lijst van Opdrachten")) {
			OpdrachtListView view = new OpdrachtListView();
			OpdrachtListController controller = new OpdrachtListController(
					view, opdrachtCatalogus, facade);
		} else if (action.equals("Sluiten")) {
			int result = JOptionPane
					.showConfirmDialog(
							menuView,
							"Bent u zeker dat u wilt afsluiten? Niet opgeslagen gegevens kunnen verloren gaan.",
							"Confirmatie voor aflsuiten",
							JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
