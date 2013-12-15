package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Opdracht;
import model.OpdrachtCatalogus;

/**
 * 
 * @author Davy Pulinx
 * @version 1.0
 *
 */

public class OpdrachtListView extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	private DefaultMutableTreeNode top;
	private JPanel content;
	private JButton btnCreatieOpdracht, btnWijzigOpdracht;
	
	public OpdrachtListView() {
		super("Lijst van opdrachten");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		content = new JPanel();
		content.setLayout(new GridBagLayout());
		content.setPreferredSize(new Dimension(500,650));
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		top = new DefaultMutableTreeNode("Lijst van opdrachten");
		
		tree = new JTree(top);
		tree.expandPath(tree.getPathForRow(0));
		JScrollPane pane = new JScrollPane(tree);
		pane.setPreferredSize(new Dimension(450, 600));
		
		content.add(pane, gbc);
		
		btnCreatieOpdracht = new JButton("Creëer nieuwe opdracht");
		btnWijzigOpdracht = new JButton("Wijzigen van een opdracht");
		
		JPanel btns = new JPanel();
		gbc.gridy++;
		
		btns.add(btnCreatieOpdracht);
		btns.add(btnWijzigOpdracht);
		content.add(btns, gbc);
		
		this.add(content);
		this.setSize(900,900);
		this.setVisible(true);
	}
	
	public void buttonActionListener( ActionListener al) {
		btnCreatieOpdracht.setActionCommand(btnCreatieOpdracht.getName());
		btnCreatieOpdracht.addActionListener(al);

		btnWijzigOpdracht.setActionCommand(btnWijzigOpdracht.getName());
		btnWijzigOpdracht.addActionListener(al);
	}
	
	public void createNodes(OpdrachtCatalogus opdrachtCatalogus){
		try {
			DefaultMutableTreeNode opdracht = null;
			List<Opdracht> opdrachten = opdrachtCatalogus.getOpdrachten();
			for(Opdracht o : opdrachten){
				String nameOpdracht = o.toString();
		
				opdracht = new DefaultMutableTreeNode(nameOpdracht);
				top.add(opdracht);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
