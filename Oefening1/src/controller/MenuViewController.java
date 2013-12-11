package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import view.MenuView;
import view.OpdrachtCreatieView;
import view.QuizCreatieView;

/**
 * @author Goossens Nicolas
 * @version 1.0
 */

public class MenuViewController implements ActionListener {
	private MenuView menuView;

	public MenuViewController(MenuView menuView) {
		this.menuView = menuView;
		menuView.buttonActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Quizes")) {
			OpdrachtCatalogus cat = new OpdrachtCatalogus();
			QuizCatalogus qcat = new QuizCatalogus();
			QuizCreatieView view = new QuizCreatieView();
			new QuizCreatieController(cat, qcat, view);
		} else if (action.equals("Opdrachten")) {
			OpdrachtCreatieView opdrachtCreatieView = new OpdrachtCreatieView();
			new OpdrachtCreatieController(opdrachtCreatieView);
		} else if (action.equals("Sluiten")) {
			menuView.close();
		}

	}

}
