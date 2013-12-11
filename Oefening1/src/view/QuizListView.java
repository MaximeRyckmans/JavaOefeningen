package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
		super("Lijst van quizzen");
		this.quizCatalogus = qcat;
		Container content = getContentPane();
		
		DefaultMutableTreeNode top =
				new DefaultMutableTreeNode("Lijst van Quizen");
		createNodes(top);
		
		tree = new JTree(top);
		
		content.add(new JScrollPane(tree), BorderLayout.CENTER);
		this.setSize(900,900);
		this.setVisible(true);
		
	}
	
	private void createNodes(DefaultMutableTreeNode top){
		try {
			DefaultMutableTreeNode quiz = null;
			DefaultMutableTreeNode opdracht = null;
			List<Quiz> quizzen = quizCatalogus.getQuizzen();
			for(Quiz q : quizzen){
				int nameQuiz = q.getId();
		
				quiz = new DefaultMutableTreeNode(nameQuiz);
				top.add(quiz);
		
				for (Opdracht opdr : q) {
					String nameOpdracht = opdr.getVraag();
			
					opdracht = new DefaultMutableTreeNode(nameOpdracht);
					quiz.add(opdracht);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
