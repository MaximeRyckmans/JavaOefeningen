package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import model.Klas;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.OpdrachtTableModel;
import model.Quiz;
import model.QuizCatalogus;
import view.QuizCreatieView;

public class QuizCreatieController implements ActionListener, ItemListener {

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

	public QuizCreatieController() {

	}

	public QuizCreatieController(OpdrachtCatalogus opdrachtCatalogusModel,
			QuizCatalogus quizCatalogusModel, QuizCreatieView quizCreatieView) {

		this.opdrachtCatalogusModel = opdrachtCatalogusModel;
		this.quizCatalogusModel = quizCatalogusModel;
		this.opdrachtCatalogusModel.leesOpdrachtenVanBestand();
		this.quizCatalogusModel.leesQuizzenVanBestand();
		opdrachten = opdrachtCatalogusModel.getOpdrachten();

		listModel = new DefaultListModel<Opdracht>();
		populeerListModel(listModel);

		tableModel = new DefaultTableModel(col, 0);

		this.quizCreatieView = quizCreatieView;

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

	private void verplaatsOpdrachtNaarRechts()
			throws IllegalArgumentException {
		boolean opdrachtAlToegevoegd = false;
		if (quizCreatieView.getOpdrachten().getSelectedValue() != null) {
			for (String s : getLijstVanToegevoegdeOpdrachten()) {
				if (s.equals(quizCreatieView.getOpdrachten().getSelectedValue()
						.toString())) {
					opdrachtAlToegevoegd = true;
					throw new IllegalArgumentException(
							"Opdracht is al toegevoegd. Selecteer een andere opdracht.");
				}
			}
			if (opdrachtAlToegevoegd == false) {
				quizCreatieView.getTableModel().addRow(
						new Opdracht[] {
								quizCreatieView.getOpdrachten()
										.getSelectedValue(), null });
				aantalToegevoegdeOpdrachten++;
				quizCreatieView.getAantalToegevoegdeOpdr().setText(Integer.toString(aantalToegevoegdeOpdrachten));
			}
		} else {
			throw new IllegalArgumentException(
					"Geen opdracht geselecteerd. Selecteer een opdracht");
		}
	}

	private void verwijderOpdrachtVanToegevoegdeOpdrachten() {
		int selectedRow = quizCreatieView.getGeselecteerdeOpdrachten().getSelectedRow();
		if(selectedRow != -1) {
		    quizCreatieView.getTableModel().removeRow(selectedRow);
		    aantalToegevoegdeOpdrachten--;
			quizCreatieView.getAantalToegevoegdeOpdr().setText(Integer.toString(aantalToegevoegdeOpdrachten));
		}

	}

	private void verplaatsOpdrachtNaarBoven() {

	}

	private void registreerNieuweQuiz() {

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
				System.out.println(e.getItem());
			} else if (e.getItemSelectable() == quizCreatieView.getCategorie()) {

			}

		}
	}

	private List<Opdracht> toonOpdrachtenVanCategorie(ItemEvent e) {
		List<Opdracht> tempList = new ArrayList<Opdracht>();
		for (Opdracht opdr : opdrachtCatalogusModel.getOpdrachten()) {
			if (e.getItem().equals(OpdrachtCategorie.Aardrijkskunde)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Aardrijkskunde)) {
				tempList.add(opdr);
			} else if (e.getItem().equals(OpdrachtCategorie.Nederlands)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Nederlands)) {

				tempList.add(opdr);
			} else if (e.getItem().equals(OpdrachtCategorie.Wetenschappen)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Wetenschappen)) {
				tempList.add(opdr);
			} else if (e.getItem().equals(OpdrachtCategorie.Wiskunde)
					&& opdr.getOpdrachtCategorie().equals(
							OpdrachtCategorie.Wiskunde)) {
				tempList.add(opdr);
			}
		}
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
