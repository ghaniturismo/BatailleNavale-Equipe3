package view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ShipController;
import model.Bateau;
import model.Game;
import model.Game.Etat;

public class ShipSelectionView extends JPanel implements Observer {
	
    ////////////////////////////// VARIABLES //////////////////////////////////

	private static final long serialVersionUID = 1L;

	private JButton[] ships;
	private JLabel info;
	private ShipController shipController;

	///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	
	public ShipSelectionView(ShipController shipController) {
		this.shipController = shipController;
		info = new JLabel("");
		info.setBounds(new Rectangle(100,500));
		add(info);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (((Game) o).getEtat() == Etat.PLACINGBOATS) {
			if(ships == null) {
				ships = new JButton[((Game) o).getEpoque().getNbShip()];

				for (int i = 0; i < ((Game) o).getEpoque().getNbShip(); i++) {
					ships[i] = new JButton("");
					ships[i].setText(((Game) o).getEpoque().getShips().get(i).getType());
					ships[i].addActionListener(new ShipListener(ships[i], ((Game) o).getEpoque().getShips().get(i), ((Game) o).getEpoque().getShips().get(i).getSize()));
					add(ships[i]);
				}
			} else {
					for (int i = 0; i < ((Game) o).getEpoque().getNbShip(); i++) {
						if(ships[i].getBackground().getGreen() == 255) {
							remove(ships[i]);
							repaint();
						}else {
							ships[i].setBackground(null);
							ships[i].setEnabled(true);
						}
					}
			}
		} else { 
			
			if(ships != null) {
				for (int i = 0; i < ((Game) o).getEpoque().getNbShip(); i++) {
					remove(ships[i]);
				}

				ships = null;
			}
		}
	}
	
	public class ShipListener implements ActionListener {
		private JButton bouton;
		private Bateau bateau;
		private int size;

		public ShipListener(JButton button, Bateau bateau, int size) {
			this.bouton = button;
			this.bateau = bateau;
			this.size = size;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			shipController.clic(bateau, size);
			bouton.setBackground(Color.GREEN);
			shipController.getGame().setVertical(false);
			
			for (int i = 0; i < ships.length; i++) {
				ships[i].setEnabled(false);
			}			
		}

	}
}