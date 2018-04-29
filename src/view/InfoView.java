package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import model.Game;

public class InfoView extends JPanel implements Observer {
	
    ////////////////////////////// VARIABLES //////////////////////////////////

	private static final long serialVersionUID = 1L;
	
	private JLabel generalInfo;
	private JLabel age;
	private JLabel infosPlayer;
	private JLabel infosComputer;
	
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

	public InfoView() {
		generalInfo = new JLabel("Bienvenue !", SwingConstants.CENTER);
		age = new JLabel("Epoque : Aucune");
		infosPlayer = new JLabel("Joueur : Vies = 0" );
		infosComputer = new JLabel("Ordinateur : Vies = 0" );

		add(generalInfo);
		add(age);
		add(infosPlayer);
		add(infosComputer);

		this.setLayout(new GridLayout());
	}


	@Override
	public void update(Observable o, Object arg) {
		age.setText("Epoque : " + ((Game) o).getAge());
		generalInfo.setText(((Game) o).getInfo());
		infosPlayer.setText("Joueur : Vies = " + ((Game) o).getPlayerWorld().getNbLives());
		infosComputer.setText("Ordinateur : Vies = " + ((Game) o).getComputerWorld().getNbLives());
	}
	
}