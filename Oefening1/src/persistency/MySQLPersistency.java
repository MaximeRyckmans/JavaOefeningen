package persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Klas;
import model.Leraar;
import model.Meerkeuze;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Opsomming;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizStatus;
import model.Reproductie;

/**
 * 
 * @author Maxime Ryckmans
 * @version 1.0
 * 
 */
public class MySQLPersistency implements Persistable {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	ResultSet rs2= null;
	PreparedStatement pst = null;

	@Override
	public void getAlleOpdrachten(OpdrachtCatalogus opdrachtCatalogus) {
		try {
			con = createConnection();
			String query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam,meerkeuzeopdrachten.alleKeuzes from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, meerkeuzeopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and meerkeuzeopdrachten.idmeerkeuzeOpdrachten= opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Meerkeuze'";
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				String alleKeuzes = rs.getString(8);

				Opdracht opdr = new Meerkeuze(id, vraag, antwoord,
						maxAantalPogingen, alleKeuzes, antwoordHint,
						maxAntwoordTijd, opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}

			query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, opsommingsopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and opsommingsopdrachten.idopsommingsOpdrachten= opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Opsomming'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				Opdracht opdr = new Opsomming(vraag, antwoord,
						maxAantalPogingen, antwoordHint, maxAntwoordTijd,
						opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}

			query = "select opdrachten.idopdrachten, opdrachten.vraag,opdrachten.antwoord,opdrachten.maxAantalpogingen,opdrachten.antwoordHint,opdrachten.maxAntwoordTijd, opdrachtcategorieën.opdrachtCategorieNaam,reproductieopdrachten.trefwoorden,reproductieopdrachten.minAantalTrefwoorden from opdrachten left join (`opdrachtcategorieën`, opdrachtsoorten, reproductieopdrachten) ON (`opdrachtcategorieën`.`idopdrachtCategorieën` = opdrachten.opdrachtenCategorie and opdrachtsoorten.idOpdrachtSoorten = opdrachten.soortOpdracht and reproductieopdrachten.idreproductieOpdrachten = opdrachten.idopdrachten) where opdrachtsoorten.OpdrachtSoortenNaam='Reproductie'";
			rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String vraag = rs.getString(2);
				String antwoord = rs.getString(3);
				int maxAantalPogingen = rs.getInt(4);
				String antwoordHint = rs.getString(5);
				int maxAntwoordTijd = rs.getInt(6);
				OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie
						.valueOf(rs.getString(7));
				String trefwoorden = rs.getString(8);
				int minAantalJuisteTrefwoorden = rs.getInt(9);
				Opdracht opdr = new Reproductie(vraag, antwoord,
						maxAantalPogingen, antwoordHint, maxAntwoordTijd,
						trefwoorden, minAantalJuisteTrefwoorden,
						opdrachtCategorie);
				opdrachtCatalogus.getOpdrachten().add(opdr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {

					rs.close();
				}
				if (st != null) {
					st.close();
				}
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void getAlleQuizzen(OpdrachtCatalogus opdrachtCatalogus,
			QuizCatalogus quizCatalogus) {
		con = createConnection();

		
		try {
			
			pst = con
					.prepareStatement("SELECT quizzen.idquizzen, quizzen.onderwerp, quizzen.aantalDeelnames, klassen.klassenNaam, leraren.voornaam, leraren.naam, quizstatussen.quizStatus FROM quizzen left join (klassen, leraren, quizstatussen) on (klassen.idklassen= quizzen.klassenID and leraren.idleraren = quizzen.lerarenId and quizstatussen.idquizStatussen= quizzen.quizStatusID);");
			rs = pst.executeQuery();

			while (rs.next()) {
				List<Opdracht> opdrachten = new ArrayList<Opdracht>();
				int quizID = rs.getInt(1);
				String onderwerp = rs.getString(2);
				int aantalDeelnames = rs.getInt(3);
				String klassenNaam = rs.getString(4);
				Klas leerjaar = Klas.valueOf(klassenNaam);
				String lerarenNaam = rs.getString(5) + rs.getString(6);
				Leraar leraar = Leraar.valueOf(lerarenNaam);
				String quizStatusString = rs.getString(7);
				QuizStatus quizStatus = QuizStatus.valueOf(quizStatusString);
				
				PreparedStatement pst2 = con
						.prepareStatement("select idOpdracht, maxAantalPunten from quizzen_opdrachten where idQuiz=?");
				pst2.setInt(1, quizID);
				rs2 = pst2.executeQuery();
				while (rs2.next()) {

					Opdracht opdracht = this.getBepaaldeOpdracht(rs2.getInt(1),
							opdrachtCatalogus);
					opdracht.setMaxAantalPunten(rs2.getInt(2));
					opdrachten.add(opdracht);
				}

				Quiz quiz = new Quiz(quizID, aantalDeelnames, leerjaar, leraar,
						onderwerp, quizStatus, opdrachten);
				quizCatalogus.addQuizToList(quiz);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void slaOpdrachtOp(OpdrachtCatalogus opdrachtCatalogus,
			Opdracht opdracht) {
		try {
			String vraag = opdracht.getVraag();
			String antwoord = opdracht.getAntwoord();
			int maxAantalPogingen = opdracht.getMaxAantalPogingen();
			String antwoordHint = opdracht.getAntwoordHint();
			int maxAntwoordTijd = opdracht.getmaxAntwoordTijd();
			OpdrachtCategorie opdrachtCategorie = opdracht
					.getOpdrachtCategorie();
			int opdrachtCategorieID = 0;
			con = createConnection();

			pst = con
					.prepareStatement("select idopdrachtCategorieën from opdrachtcategorieën where opdrachtCategorieNaam=?");
			pst.setString(1, opdrachtCategorie.toString());
			rs = pst.executeQuery();
			while (rs.next()) {
				opdrachtCategorieID = rs.getInt(1);
			}

			pst = con
					.prepareStatement(
							"insert into opdrachten(vraag, antwoord, maxAantalpogingen, antwoordHint, maxAntwoordTijd,opdrachtenCategorie) values (?,?,?,?,?,?",
							Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, vraag);
			pst.setString(2, antwoord);
			pst.setInt(3, maxAantalPogingen);
			pst.setString(4, antwoordHint);
			pst.setInt(5, maxAntwoordTijd);
			pst.setInt(6, opdrachtCategorieID);
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			int opdrachtID = 0;
			while (rs.next()) {
				opdrachtID = rs.getInt(1);
			}
			String opdrachtClass = opdracht.getClass().getSimpleName();
			if (opdrachtClass.equals("Meerkeuze")) {
				int opdrachtSoortId = zoekOpdrachtsoortID("Meerkeuze");
				vulSoortOpdrachtIn(opdrachtSoortId, opdrachtID);

				String alleKeuzes = ((Meerkeuze) opdracht).getAlleKeuzes();
				pst = con
						.prepareStatement("insert into meerkeuzeopdrachten (idmeerkeuzeOpdrachten,alleKeuzes) values(?,?)");
				pst.setInt(1, opdrachtID);
				pst.setString(2, alleKeuzes);
				pst.executeUpdate();

			} else if (opdrachtClass.equals("Opsomming")) {

				int opdrachtSoortId = zoekOpdrachtsoortID("Opsomming");
				vulSoortOpdrachtIn(opdrachtSoortId, opdrachtID);

			} else if (opdrachtClass.equals("Reproductie")) {

				int opdrachtSoortId = zoekOpdrachtsoortID("Reproductie");
				vulSoortOpdrachtIn(opdrachtSoortId, opdrachtID);

				String trefwoorden = ((Reproductie) opdracht).getTrefwoorden();
				int minAantalTrefwoorden = ((Reproductie) opdracht)
						.getMinAantalJuisteTrefwoorden();

				pst = con
						.prepareStatement("insert into reproductieopdrachten (idreproductieOpdrachten,trefwoorden,minAantalTrefwoorden) values(?,?,?)");
				pst.setInt(1, opdrachtID);
				pst.setString(2, trefwoorden);
				pst.setInt(3, minAantalTrefwoorden);
				pst.executeUpdate();

			}

		} catch (SQLException sqlex) {
			System.out.println(sqlex.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void slaQuizOp(QuizCatalogus quizCatalogus, Quiz quiz) {

		con = createConnection();
		ResultSet rs = null;

		try {

			int aantalDeelnames = quiz.getAantalDeelnames();
			String leerjaarNaam = quiz.getLeerjaar().toString();

			pst = con
					.prepareStatement("select idklassen from klassen where klassen.klassenNaam=?");
			pst.setString(1, leerjaarNaam);
			rs = pst.executeQuery();
			int klassenID = 0;
			while (rs.next()) {
				klassenID = rs.getInt(1);
			}
			String onderwerp = quiz.getOnderwerp();
			String quizStatusNaam = quiz.getQuizStatus().toString();

			pst = con
					.prepareStatement("select idquizStatussen from quizstatussen where quizstatussen.quizStatus=?");
			pst.setString(1, quizStatusNaam);
			rs = pst.executeQuery();
			int quizStatusID = 0;

			while (rs.next()) {
				quizStatusID = rs.getInt(1);
			}

			String voornaam = quiz.getLeraar().getVoorNaam();
			String naam = quiz.getLeraar().getFamilieNaam();
			pst = con
					.prepareStatement("select idleraren from leraren where leraren.voornaam=? and leraren.naam=?");
			pst.setString(1, voornaam);
			pst.setString(2, naam);
			int lerarenID = 0;
			rs = pst.executeQuery();
			while (rs.next()) {
				lerarenID = rs.getInt(1);
			}

			List<Integer> ids = new ArrayList<Integer>();

			for (Opdracht opdr : quiz.getOpdrachten()) {
				ids.add(opdr.getId());
			}
			if (klassenID != 0 && lerarenID != 0 && quizStatusID != 0) {

				pst = con
						.prepareStatement(
								"insert into quizzen(onderwerp,aantalDeelnames, klassenID, lerarenId, quizStatusID) values (?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, onderwerp);
				pst.setInt(2, aantalDeelnames);
				pst.setInt(3, klassenID);
				pst.setInt(4, lerarenID);
				pst.setInt(5, quizStatusID);
				pst.executeUpdate();
				rs = pst.getGeneratedKeys();
				int keyId = 0;
				while (rs.next()) {
					keyId = rs.getInt(1);
				}

				pst = con
						.prepareStatement("insert into quizzen_opdrachten(idQuiz,idOpdracht,maxAantalPunten) values(?,?,?)");
				for (int opdrIDs : ids) {
					pst.setInt(1, keyId);
					pst.setInt(2, opdrIDs);
					pst.setInt(3, getMaxaantalPuntenVoorBepaaldeOpdracht(quiz, opdrIDs));
					pst.executeUpdate();
				}
				pst= con.prepareStatement("insert into quizzen_opdrachten(maxAantalPunten) values(?) where idQuiz=? and idOpdracht=?");
				
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public void verwijderQuiz(Quiz quiz, QuizCatalogus quizCatalogus) {

		con = createConnection();
		try {
			pst = con.prepareStatement("delete from quizzen where idquizzen=?");
			pst.setInt(1, quiz.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	@Override
	public void verwijderOpdracht(Opdracht opdracht,
			OpdrachtCatalogus opdrachtCatalogus) {
		con = createConnection();
		try {
			pst = con
					.prepareStatement("delete from opdrachten where idopdrachten=?");
			pst.setInt(1, opdracht.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	@Override
	public Opdracht getBepaaldeOpdracht(Integer i,
			OpdrachtCatalogus opdrachtCatalogus) {
		Opdracht opdracht = null;
		for (Opdracht opdr : opdrachtCatalogus.getOpdrachten()) {
			if (i.equals(opdr.getId())) {
				opdracht = opdr;

			}
		}
		return opdracht;
	}

	private int zoekOpdrachtsoortID(String soortOpdracht) {
		int opdrachtSoortId = 0;
		try {
			pst = con
					.prepareStatement("select idOpdrachtSoorten from opdrachtsoorten where OpdrachtSoortenNaam=?");
			pst.setString(1, soortOpdracht);
			rs = pst.executeQuery();

			while (rs.next()) {
				opdrachtSoortId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opdrachtSoortId;
	}

	private void vulSoortOpdrachtIn(int opdrachtSoortId, int opdrachtID) {
		try {
			pst = con
					.prepareStatement("insert into opdrachten(soortOpdracht) values(?) where idopdrachten=?");

			pst.setInt(1, opdrachtSoortId);
			pst.setInt(2, opdrachtID);
			pst.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	private int getMaxaantalPuntenVoorBepaaldeOpdracht(Quiz quiz, int opdrachtId){
		int maxAantalPunten=0;
		for(Opdracht opdr: quiz.getOpdrachten()){
			if(opdr.getId() == opdrachtId){
				maxAantalPunten=opdr.getMaxAantalPunten();
			}
		}
		return maxAantalPunten;
	}

	private Connection createConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/quizdb2";
			String user = "root";
			String password = "root";

			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	private void closeConnection() {
		try {
			if (this.con != null) {
				this.con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
