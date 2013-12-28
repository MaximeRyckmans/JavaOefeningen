package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import persistency.PersistencyFacade;
import model.Klas;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtTableModel;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizStatus;
import utils.OpdrachtCategorieComparator;
import utils.OpdrachtVraagComparator;
import view.QuizCreatieView;

public class QuizCreatieController extends QuizController implements
		ItemListener {

	private QuizCreatieView quizCreatieView;
	private Quiz quiz;
	private OpdrachtCatalogus opdrachtCatalogusModel;
	private QuizCatalogus quizCatalogusModel;
	private List<Opdracht> opdrachten;
	private Klas klas;
	private String[] sorterenOp = { "geen", "categorie", "vraag" };
	private String[] col = { "Opdracht", "MaximumScore" };
	private DefaultListModel<Opdracht> listModel;
	private DefaultTableModel tableModel;
	private int aantalToegevoegdeOpdrachten = 0;
	private List<Opdracht> geselecteerdeOpdrachten = null;
	List<Opdracht> tempList = new ArrayList<Opdracht>();
	private PersistencyFacade facade;

	public QuizCreatieController() {

	}

	public QuizCreatieController(OpdrachtCatalogus opdrachtCatalogusModel,
			QuizCatalogus quizCatalogusModel, QuizCreatieView quizCreatieView, PersistencyFacade facade) {

		this.opdrachtCatalogusModel = opdrachtCatalogusModel;
		this.quizCatalogusModel = quizCatalogusModel;
		
		opdrachten = opdrachtCatalogusModel.getOpdrachten();

		listModel = new DefaultListModel<Opdracht>();
		populeerListModel(listModel);

		tableModel = new DefaultTableModel(col, 0);

		this.quizCreatieView = quizCreatieView;
		this.facade=facade;
		quizCreatieView.setInitiëleWaardenQuizCreatieView(tableModel,
				sorterenOp, klas, listModel);
		quizCreatieView.buttonActionListener(this);
		quizCreatieView.comboboxActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		System.out.println("this is: " + action);

		if (action.equals(">>>>")) {

			verplaatsOpdrachtNaarRechts();

		} else if (action.equals("<<<<")) {

			verwijderOpdrachtVanToegevoegdeOpdrachten();

		} else if (action.equals("^^^^")) {

			verplaatsOpdrachtNaarBoven();

		} else if (action.equals("Registreer nieuwe quiz")) {

			registreerNieuweQuiz();

		}
	}

	private void verplaatsOpdrachtNaarRechts() throws IllegalArgumentException {
		
	
		if (quizCreatieView.getOpdrachten().getSelectedValue() != null) {
			Opdracht opdracht = quizCreatieView.getOpdrachten()
					.getSelectedValue();
			
			if (isToegevoegdeOpdracht(tempList, opdracht) == false) {
				quizCreatieView.getTableModel().addRow(
						new Opdracht[] {
								quizCreatieView.getOpdrachten()
										.getSelectedValue(), null });
				tempList.add(opdracht);
				aantalToegevoegdeOpdrachten++;
				quizCreatieView.getAantalToegevoegdeOpdr().setText(
						Integer.toString(aantalToegevoegdeOpdrachten));
			}
		} else {
			throw new IllegalArgumentException(
					"Geen opdracht geselecteerd. Selecteer een opdracht");
		}
	}

	private void verwijderOpdrachtVanToegevoegdeOpdrachten() {
		int selectedRow = quizCreatieView.getGeselecteerdeOpdrachten()
				.getSelectedRow();
		if (selectedRow != -1) {
			quizCreatieView.getTableModel().removeRow(selectedRow);
			aantalToegevoegdeOpdrachten--;
			quizCreatieView.getAantalToegevoegdeOpdr().setText(
					Integer.toString(aantalToegevoegdeOpdrachten));
		}

	}

	private void verplaatsOpdrachtNaarBoven() {
		int selectedRow = quizCreatieView.getGeselecteerdeOpdrachten()
				.getSelectedRow();
		if (selectedRow == 0) {
			quizCreatieView.getTableModel().moveRow(selectedRow, selectedRow,
					quizCreatieView.getTableModel().getRowCount() - 1);
		} else if (selectedRow != -1) {
			quizCreatieView.getTableModel().moveRow(selectedRow, selectedRow,
					selectedRow - 1);
		}

	}

	private void registreerNieuweQuiz() throws IllegalArgumentException {
		boolean isQuizOk = true;
		geselecteerdeOpdrachten = new ArrayList<Opdracht>();
		for (Quiz q : quizCatalogusModel.getQuizzen()) {
			if (q.getOnderwerp().equals(quizCreatieView.getOnderwerpText())) {
				isQuizOk = false;
				throw new IllegalArgumentException(
						"Quiz bestaat al, kies een andere naam");
			}
		}
		if (quizCreatieView.getTableModel().getRowCount() == -1) {
			isQuizOk = false;
			throw new IllegalArgumentException("Voeg eerst opdrachten toe.");
		}
		/*
		 * if(!quizCreatieView.getQuizStatus().getSelectedItem().toString().equals
		 * (QuizStatus.AFGEWERKT)){ isQuizOk=false; }
		 */
		if (isQuizOk == true) {
			int id = quizCatalogusModel.getQuizzen().size() + 1;

			String leerjaarString = quizCreatieView.getKlas().getSelectedItem()
					.toString();
			Klas leerjaar = Klas.valueOf(leerjaarString);

			String leraarString = quizCreatieView.getAuteur().getSelectedItem()
					.toString();
			Leraar leraar = Leraar.valueOf(leraarString);

			String onderwerp = quizCreatieView.getOnderwerpText().getText();

			String quizStatusString = quizCreatieView.getQuizStatus()
					.getSelectedItem().toString();
			QuizStatus quizStatus = QuizStatus.valueOf(quizStatusString);

			for (int i = 0; i < quizCreatieView.getTableModel().getRowCount(); i++) {
				Opdracht opdr = (Opdracht) quizCreatieView.getTableModel()
						.getValueAt(i, 0);
				System.out.println(quizCreatieView.getTableModel().getValueAt(
						i, 1));
				opdr.setMaxAantalPunten(Integer
						.parseInt((String) quizCreatieView.getTableModel()
								.getValueAt(i, 1)));
				geselecteerdeOpdrachten.add(opdr);
			}

			Quiz quiz = new Quiz(id, 0, leerjaar, leraar, onderwerp,
					quizStatus, geselecteerdeOpdrachten);

			quizCatalogusModel.addQuizToList(quiz);
			facade.getPersistable().slaQuizOp(quizCatalogusModel, quiz);
		}
	}

	public void populeerListModel(DefaultListModel<Opdracht> model) {

		for (Opdracht opdr : this.opdrachten) {
			model.addElement(opdr);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (e.getItemSelectable() == quizCreatieView.getSorteerOpdr()) {

				if (e.getItem().equals("categorie")) {
					sorteerOpComparator(new OpdrachtCategorieComparator());
				} else if (e.getItem().equals("geen")) {
					setOpdrachtModelVanCategorie();
				} else if (e.getItem().equals("vraag")) {
					sorteerOpComparator(new OpdrachtVraagComparator());
				}

			} else if (e.getItemSelectable() == quizCreatieView.getCategorie()) {
				setOpdrachtModelVanCategorie();
			}

		}
	}

	private void sorteerOpComparator(Comparator<Opdracht> comp) {
		List<Opdracht> tempList = new ArrayList<Opdracht>();
		tempList.clear();
		for (int i = 0; i < quizCreatieView.getOpdrachten().getModel()
				.getSize(); i++) {
			tempList.add(quizCreatieView.getOpdrachten().getModel()
					.getElementAt(i));
		}
		Collections.sort(tempList, comp);
		listModel.clear();
		for (Opdracht opdr : tempList) {
			listModel.addElement(opdr);
		}
		quizCreatieView.getOpdrachten().setModel(listModel);
	}

	private void setOpdrachtModelVanCategorie() {
		listModel.clear();
		for (Opdracht opdr : toonOpdrachtenVanCategorie()) {
			listModel.addElement(opdr);
		}
		quizCreatieView.getOpdrachten().setModel(listModel);
	}

	private List<Opdracht> toonOpdrachtenVanCategorie() {
		List<Opdracht> tempList = new ArrayList<Opdracht>();
		for (Opdracht opdr : opdrachtCatalogusModel.getOpdrachten()) {
			if (quizCreatieView.getCategorie().getSelectedItem()
					.equals(OpdrachtCategorie.Aardrijkskunde)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Aardrijkskunde)) {
				tempList.add(opdr);
			} else if (quizCreatieView.getCategorie().getSelectedItem()
					.equals(OpdrachtCategorie.Nederlands)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Nederlands)) {

				tempList.add(opdr);
			} else if (quizCreatieView.getCategorie().getSelectedItem()
					.equals(OpdrachtCategorie.Wetenschappen)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Wetenschappen)) {
				tempList.add(opdr);
			} else if (quizCreatieView.getCategorie().getSelectedItem()
					.equals(OpdrachtCategorie.Wiskunde)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Wiskunde)) {
				tempList.add(opdr);
			}
		}
		/*
		 * if(quizCreatieView.getCategorie().getSelectedItem()
		 * .equals(OpdrachtCategorie.Alles)){ tempList = opdrachten; }
		 */
		return tempList;
	}

	public List<String> getLijstVanToegevoegdeOpdrachten() {
		List<String> toegevoegdeOpdrachten = new ArrayList<String>();

		for (int i = 0; i < quizCreatieView.getTableModel().getRowCount(); i++) {
			toegevoegdeOpdrachten.add(String.valueOf(quizCreatieView
					.getTableModel().getValueAt(i, 0)));
		}

		return toegevoegdeOpdrachten;
	}

}
