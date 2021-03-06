package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import model.Opdracht;
import model.Quiz;
import model.QuizCatalogus;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizListView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTree tree;
	private DefaultMutableTreeNode top;
	private JPanel content;
	private JButton btnCreatieQuiz, btnWijzigQuiz, btnDeleteQuiz;

	
	public QuizListView(){
		super("Lijst van quizzen");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		content = new JPanel();
		content.setLayout(new GridBagLayout());
		content.setPreferredSize(new Dimension(500, 650));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		top = new DefaultMutableTreeNode("Lijst van Quizen");
		tree = new JTree(top);
		tree.expandPath(tree.getPathForRow(0));
		JScrollPane pane = new JScrollPane(tree);
		pane.setPreferredSize(new Dimension(450, 550));
		
		content.add(pane, gbc);
		
		btnCreatieQuiz = new JButton("Creëer nieuwe quiz");
		btnWijzigQuiz = new JButton("Wijzigen van een quiz");
		btnDeleteQuiz = new JButton("Verwijder quiz");
		
		JPanel btns = new JPanel();
		gbc.gridy++;
		
		btns.add(btnCreatieQuiz);
		btns.add(btnWijzigQuiz);
		content.add(btns, gbc);
		
		gbc.gridy++;
		content.add(btnDeleteQuiz, gbc);
		
		this.add(content);
		this.setSize(900,900);
		this.setVisible(true);
		
	}
	
	public void buttonActionListener(ActionListener al) {

		btnCreatieQuiz.setActionCommand(btnCreatieQuiz.getName());
		btnCreatieQuiz.addActionListener(al);

		btnWijzigQuiz.setActionCommand(btnWijzigQuiz.getName());
		btnWijzigQuiz.addActionListener(al);
		
		btnDeleteQuiz.setActionCommand(btnDeleteQuiz.getName());
		btnDeleteQuiz.addActionListener(al);
	}
	
	public void createNodes(QuizCatalogus quizCatalogus){
		top.removeAllChildren();
		try {
			DefaultMutableTreeNode quiz = null;
			DefaultMutableTreeNode opdracht = null;
			List<Quiz> quizzen = quizCatalogus.getQuizzen();
			for(Quiz q : quizzen){
				String nameQuiz = q.toString();
		
				quiz = new DefaultMutableTreeNode(nameQuiz);
				top.add(quiz);
		
				for (Opdracht opdr : q.getOpdrachten()) {
					String nameOpdracht = opdr.toString();
					opdracht = new DefaultMutableTreeNode(nameOpdracht);
					quiz.add(opdracht);
				}
			}
			
			DefaultMutableTreeNode currentNode = top.getNextNode();
		    do {
		       if (currentNode.getLevel()==1) 
		            tree.expandPath(new TreePath(currentNode.getPath()));
		       currentNode = currentNode.getNextNode();
		       }
		    while (currentNode != null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultMutableTreeNode getTop() {
		return top;
	}

	public void setTop(DefaultMutableTreeNode top) {
		this.top = top;
	}

	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	public JButton getBtnCreatieQuiz() {
		return btnCreatieQuiz;
	}

	public void setBtnCreatieQuiz(JButton btnCreatieQuiz) {
		this.btnCreatieQuiz = btnCreatieQuiz;
	}

	public JButton getBtnWijzigQuiz() {
		return btnWijzigQuiz;
	}

	public void setBtnWijzigQuiz(JButton btnWijzigQuiz) {
		this.btnWijzigQuiz = btnWijzigQuiz;
	}

	public JButton getBtnDeleteQuiz() {
		return btnDeleteQuiz;
	}

	public void setBtnDeleteQuiz(JButton btnDeleteQuiz) {
		this.btnDeleteQuiz = btnDeleteQuiz;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
