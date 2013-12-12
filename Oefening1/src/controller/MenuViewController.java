package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import view.MenuView;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;
import view.QuizListView;

/**
 * @author Goossens Nicolas & Davy Pulinx
 * @version 1.0
 */

public class MenuViewController implements ActionListener {
	private MenuView menuView;
	private QuizCatalogus qCat;
	private OpdrachtCatalogus opdrachtCatalogus;

	public MenuViewController(MenuView menuView, QuizCatalogus quizCatalogus, OpdrachtCatalogus opdrachtCatalogus) {
		this.menuView = menuView;
		this.qCat = quizCatalogus;
		this.opdrachtCatalogus = opdrachtCatalogus;
		menuView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Lijst van Quizzen")) {
			QuizListView view = new QuizListView();
			QuizListController controller = new QuizListController(view, qCat, opdrachtCatalogus);
			/*QuizCreatieView view = new QuizCreatieView();
			new QuizCreatieController(cat, qcat, view);*/
		} else if (action.equals("Lijst vanOpdrachten")) {
			OpdrachtCreatieView opdrachtCreatieView = new OpdrachtCreatieView();
			new OpdrachtCreatieController(opdrachtCreatieView);
		} else if (action.equals("Sluiten")) {
			menuView.close();
		}

	}

}
