package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Opdracht;
import model.Quiz;
import model.QuizCatalogus;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizListView extends JFrame {

	private JTree tree;
	private QuizCatalogus quizCatalogus;
	
	public QuizListView(QuizCatalogus qcat){
		this.quizCatalogus = qcat;
		Container content = getContentPane();
		setLayout(new FlowLayout());
		
		DefaultMutableTreeNode top =
				new DefaultMutableTreeNode("Lijst van Quizen");
		createNodes(top);
		
		tree = new JTree(top);
		
		content.add(new JScrollPane(tree), BorderLayout.CENTER);
		setSize(275,300);
		setVisible(true);
		
	}
	
	private void createNodes(DefaultMutableTreeNode top){
		try {
			DefaultMutableTreeNode quiz = null;
			DefaultMutableTreeNode opdracht = null;
			List<Quiz> quizzen = quizCatalogus.getQuizzen();
			for(Quiz q : quizzen){
			//	Quiz tempQuiz = q;
				int nameQuiz = q.getId();
		
				quiz = new DefaultMutableTreeNode(nameQuiz);
				top.add(quiz);
		
				for (Opdracht opdr : q) {
			//		Opdracht tempOpdracht = opdr;
					String nameOpdracht = opdr.getVraag();
			
					opdracht = new DefaultMutableTreeNode(nameOpdracht);
					quiz.add(opdracht);
			}
		/*	for (Iterator<Quiz> i = quizCatalogus.getQuizzen().iterator(); i.hasNext();) {
				if (i.next() != null) {
				
					Quiz tempQuiz = i.next();
					int nameQuiz = tempQuiz.getId();
			
					quiz = new DefaultMutableTreeNode(nameQuiz);
					top.add(quiz);
			
					for (Iterator<Opdracht> iter = tempQuiz.getOpdrachten().iterator(); iter.hasNext();) {
						Opdracht tempOpdracht = iter.next();
						String nameOpdracht = tempOpdracht.getVraag();
				
						opdracht = new DefaultMutableTreeNode(nameOpdracht);
						quiz.add(opdracht);
					}
				}
				else {
					top.add(new DefaultMutableTreeNode("Nog geen quizen in het systeem"));
				}*/
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
