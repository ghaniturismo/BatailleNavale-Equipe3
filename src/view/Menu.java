package view;


import javax.swing.*;

import controller.MenuController;
import model.Epoque;
import model.Game;
import model.Game.Etat;
import model.IA_Strategy;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class Menu extends JMenuBar implements Observer{

	////////////////////////////// VARIABLES //////////////////////////////////

	private static final long serialVersionUID = 1L;
	
	private final static int CUSTOMIZEDGAME=0;
	private final static int QUICKGAME=1;
	private final static int LOAD=2;
	private final static int SAVE=3;
	private final static int EXIT=10;
	
	private MenuController controller;
	private Game game;
	
	private JMenu menu1;
	private JMenuItem load;
	private JMenuItem save;
	private JMenuItem quit;
	private JMenu menu2;
	private JMenuItem customizeGame;
	private JMenuItem fastGame;

	///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public Menu(Game game, MenuController menuController) {

		this.game = game;
		controller = menuController;

		/*
		 * Le premier menu --> menu1
		 */
		menu1 = new JMenu("Application");
		
		load = new JMenuItem("Charger Partie");
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		load.addActionListener(new MenuListener(LOAD));
		
		menu1.add(load);
		
		save = new JMenuItem("Sauvegarder Partie");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		save.addActionListener(new MenuListener(SAVE));
		save.setEnabled(false);
		menu1.add(save);
		
		menu1.addSeparator();
		
		quit = new JMenuItem("Quitter");
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		quit.addActionListener(new MenuListener(EXIT));
		
		menu1.add(quit);
		
		add(menu1);
		
		/*
		 * Le deuxieme menu --> menu2
		 */
		
		menu2 = new JMenu("Jeu");

		customizeGame = new JMenuItem("Partie personnalisee");
		fastGame = new JMenuItem("Partie rapide");
		
		customizeGame.setAccelerator(KeyStroke.getKeyStroke("F1"));
		fastGame.setAccelerator(KeyStroke.getKeyStroke("F2"));
		
		customizeGame.addActionListener(new MenuListener(CUSTOMIZEDGAME));
		fastGame.addActionListener(new MenuListener(QUICKGAME));
		
		menu2.add(customizeGame);
		menu2.add(fastGame);
		add(menu2);
	}
	
	
	
	public class MenuListener implements ActionListener {
		private int i;

		public MenuListener(int i) {
			this.i = i;
		}

		public void actionPerformed(ActionEvent e) {
			switch (i) {
				case CUSTOMIZEDGAME:
					/*
					 *  Choix du mode de jeu
					 */
					JComboBox<String> choosemode = new JComboBox<String>();
					for(IA_Strategy ia_Strategy : game.getStrategies()) {
						choosemode.addItem(ia_Strategy.getName());
					}
					int returnBtn1 = JOptionPane.showConfirmDialog(null, choosemode, "Choisissez une strategie :", JOptionPane.YES_NO_OPTION);
					if (returnBtn1 == JOptionPane.NO_OPTION || returnBtn1==JOptionPane.CLOSED_OPTION){
						break;	
					}else{	
						/*
						 * Choix de l'epoque
						 */
						JComboBox<String> chooseEpoque = new JComboBox<String> ();
						for(Epoque epoque : game.getEpoques()) {
							chooseEpoque.addItem(epoque.getName());
						}
						
						int returnBtn2 = JOptionPane.showConfirmDialog(null, chooseEpoque, "Choisissez une epoque :", JOptionPane.YES_NO_OPTION);
						if (returnBtn2 == JOptionPane.NO_OPTION || returnBtn2==JOptionPane.CLOSED_OPTION){
							break;
						}else{
							/*
							 * Choix du placement
							 */
							JComboBox<String> chooseplace = new JComboBox<String>();
							chooseplace.addItem("Placement libre");
							chooseplace.addItem("Placement aleatoire");
							
							int returnBtn3 = JOptionPane.showConfirmDialog(null, chooseplace, "Choisissez un mode de positionnement des bateaux :", JOptionPane.YES_NO_OPTION);
							if (returnBtn3 == JOptionPane.NO_OPTION || returnBtn3==JOptionPane.CLOSED_OPTION){
								break;
							}else{
								controller.newCustomizeGame(game.getEpoques().get(chooseEpoque.getSelectedIndex()), game.getStrategies().get(choosemode.getSelectedIndex()), chooseplace.getSelectedIndex());
								break;
							}
						}
					}
					
				case QUICKGAME: controller.newFastGame();
					break;
					
				case SAVE:		controller.saveGame();
					break;
				
				case LOAD:		controller.loadGame();
					break;
					
					
				case EXIT:
					 
					int returnexitBtn1 = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter le jeu !", "Exit", JOptionPane.YES_NO_OPTION);
					if (returnexitBtn1 == JOptionPane.NO_OPTION || returnexitBtn1==JOptionPane.CLOSED_OPTION){
						break;	
					}else{
						System.exit(0);
						break;
						
					}
				default: break;
				
			}
		}
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		Game g = (Game) arg0;
		if(g.getEtat() == Etat.PLAYERTURN || g.getEtat() == Etat.COMPUTERTURN){
			save.setEnabled(true);
		}
		else {
			save.setEnabled(false);
		}
	}
}