package view;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

//import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GridController;
import model.Bateau;
import model.Case;
import model.Game;
import model.Game.Etat;

public class GridView extends JPanel implements Observer {

	////////////////////////////// VARIABLES //////////////////////////////////

	private static final long serialVersionUID = 1L;
	
	private JButton[][] grid;
	private int nbLignes = 10;
	private int nbColonnes = 10;
	private GridController gridController;
	private boolean player = false;

	/**
	 * Music
	 */
	//private Clip music;
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	
	public GridView(GridController gridController, boolean player) {
		
		this.player = player;
		this.gridController = gridController;
		
		grid = new JButton[nbLignes + 1][nbColonnes + 1];

		GridLayout langLayout = new GridLayout(nbLignes + 1, nbColonnes + 1, 1, 1);
		this.setLayout(langLayout);
		
		ImageFactory imageFactory = ImageFactory.getInstance();
		for (int j = 0; j < nbColonnes + 1 ; j++) {
			if (j == 0)
				grid[0][j] = new JButton();
			else
				grid[0][j] = new JButton("" + j);

			grid[0][j].setPreferredSize(new Dimension(50, 30));
			grid[0][j].setEnabled(false);
			add(grid[0][j]);
		}

		for (int i = 1; i <= nbLignes; i++) {
			char upper = (char) ('A' + i-1);
			grid[i][0] = new JButton(""+upper);
			grid[i][0].setPreferredSize(new Dimension(50, 30));
			grid[i][0].setEnabled(false);
			add(grid[i][0]);

			for (int j = 1; j < nbColonnes + 1; j++) {
				grid[i][j] = new JButton("");
				grid[i][j].setPreferredSize(new Dimension(50, 40));
				grid[i][j].setIcon(imageFactory.getBackground());
				grid[i][j].setFocusPainted(false);
				grid[i][j].addMouseListener(new GridListener(grid[i][j], i, j));
				grid[i][j].addActionListener(new GridClicListener(i, j));
				add(grid[i][j]);
			}
		}
//		music = SoundFactory.getInstance().getBackgroundSound();
//		music.loop(Clip.LOOP_CONTINUOUSLY);
//		music.start();
	}
	
	public class GridListener implements MouseListener {
		private JButton bouton;
		int i;
		int j;

		public GridListener(JButton bouton, int i, int j) {
			this.bouton = bouton;
			this.i = i;
			this.j = j;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
				bouton.setBackground(gridController.mouseOver(i, j));
				if(bouton.getBackground().getAlpha() == 0)
					bouton.setBackground(null);	
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
				bouton.setBackground(null);	
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				gridController.clicDroit();
			}
		}

	}
	
	public class GridClicListener implements ActionListener {
		int i;
		int j;

		public GridClicListener(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			gridController.clic(i, j);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		ImageFactory imageFactory = ImageFactory.getInstance();
		
		for (int i = 1; i < nbLignes+1; i++) {
			for (int j = 1; j < nbColonnes+1; j++) {
				grid[i][j].setIcon(imageFactory.getBackground());
				grid[i][j].setDisabledIcon(imageFactory.getBackground());
				
				if(player == true && ((Game) o).getEtat() != Etat.PLACINGBOATS)
					grid[i][j].setEnabled(false);
				else if(player == true)
					grid[i][j].setEnabled(true);
				
				if(player == false && ((Game) o).getEtat() != Etat.PLAYERTURN)
					grid[i][j].setEnabled(false);
				else if(player == false)
					grid[i][j].setEnabled(true);
			}
		}
		
		/*
		 * Joueur
		 */
		if(player == true) {
			/*
			 * Bateaux
			 */
			for(Bateau s : ((Game) o).getPlayerWorld().getShips()) {
				
				for(int i = 1; i <= s.getSize(); i++) {
					if(!s.isVertical()) {
						grid[s.getX()][s.getY()+(i-1)].setIcon(s.getTexture(imageFactory, i, s.isVertical(), ((Game) o).getEpoque().getName()));
						grid[s.getX()][s.getY()+(i-1)].setDisabledIcon(s.getTexture(imageFactory,i, s.isVertical(), ((Game) o).getEpoque().getName()));
						grid[s.getX()][s.getY()+(i-1)].setEnabled(false);
					}
					else {
						grid[s.getX()+(i-1)][s.getY()].setIcon(s.getTexture(imageFactory, i, s.isVertical(), ((Game) o).getEpoque().getName()));
						grid[s.getX()+(i-1)][s.getY()].setDisabledIcon(s.getTexture(imageFactory,i, s.isVertical(), ((Game) o).getEpoque().getName()));
						grid[s.getX()+(i-1)][s.getY()].setEnabled(false);
					}
				}	
			}
			/*
			 * Tirs
			 */
			for(Case s : ((Game) o).getPlayerWorld().getShoots()) {
				grid[s.getX()][s.getY()].setIcon(s.getTexture(imageFactory));
				grid[s.getX()][s.getY()].setDisabledIcon(s.getTexture(imageFactory));
				grid[s.getX()][s.getY()].setEnabled(false);
			}
		}
		/*
		 * Ordinateur
		 */
		else {
			/*
			 * Bateaux
			 */
			for(Bateau s : ((Game) o).getComputerWorld().getShips()) {
				for(int i = 1; i <= s.getSize(); i++) {
					
					if(!s.isVertical()) {
						grid[s.getX()][s.getY()+(i-1)].setIcon(imageFactory.getBackground());
					}
					else {
						grid[s.getX()+(i-1)][s.getY()].setIcon(imageFactory.getBackground());
					}
					
				}	
			}			
			/*
			 * Tirs
			 */
			for(Case s : ((Game) o).getComputerWorld().getShoots()) {
				grid[s.getX()][s.getY()].setIcon(s.getTexture(imageFactory));
				grid[s.getX()][s.getY()].setDisabledIcon(s.getTexture(imageFactory));
				grid[s.getX()][s.getY()].setEnabled(false);
			}
		}
	}
}
