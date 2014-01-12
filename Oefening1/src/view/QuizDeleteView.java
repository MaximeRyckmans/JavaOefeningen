package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Quiz;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class QuizDeleteView extends QuizWijzigenView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnDeleteQuiz, btnCancelChanges, btnSaveChanges;
	private DefaultListModel<Quiz> qModel;

	public QuizDeleteView(){
		this.setTitle("Verwijder quiz");
		this.setSize(500,900);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		this.setPnlBackground(new JPanel());
		this.btnDeleteQuiz = new JButton("Verwijder quiz");
		Dimension dimension = new Dimension(435, 800);
		
		this.CreateLeftPanel(btnDeleteQuiz, dimension);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.getPnlBackground().add(this.getPnlLeft());
		
		JPanel btnPanel = new JPanel();
		this.btnCancelChanges = new JButton("Annuleer wijzigingen");
		this.btnSaveChanges = new JButton("Wijzigingen opslaan");
		btnPanel.add(btnCancelChanges);
		btnPanel.add(btnSaveChanges);
		
		this.add(getPnlBackground());
		this.add(btnPanel);
		this.setVisible(true);
	}
	
	@Override
	public void buttonActionListener(ActionListener al){
		btnDeleteQuiz.setActionCommand(btnDeleteQuiz.getName());
		btnDeleteQuiz.addActionListener(al);
		
		btnCancelChanges.setActionCommand(btnCancelChanges.getName());
		btnCancelChanges.addActionListener(al);
		
		btnSaveChanges.setActionCommand(btnSaveChanges.getName());
		btnSaveChanges.addActionListener(al);
	}
	
	public void setList(java.util.List<Quiz> list){
		qModel = new DefaultListModel<Quiz>();
		for (Quiz quiz : list) {
			qModel.addElement(quiz);
		}
		this.getListQuizzen().setModel(qModel);
	}
	
	public JButton getBtnDeleteQuiz() {
		return btnDeleteQuiz;
	}

	public void setBtnDeleteQuiz(JButton btnDeleteQuiz) {
		this.btnDeleteQuiz = btnDeleteQuiz;
	}

	public DefaultListModel<Quiz> getqModel() {
		return qModel;
	}

	public void setqModel(DefaultListModel<Quiz> qModel) {
		this.qModel = qModel;
	}
}
