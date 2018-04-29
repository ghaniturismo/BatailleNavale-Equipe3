package model;


import javax.swing.*;

import model.strategy.AleatoireStrategy;
import model.strategy.IA_Strategy;
import model.strategy.IntelligentStrategy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;

public class Game extends Observable {
	
    ////////////////////////////// VARIABLES //////////////////////////////////
	
	private ArrayList<IA_Strategy> strats; //liste des strategies
	private ArrayList<Epoque> epoques; //liste des epoques
    private Epoque epoque; 
	private IA_Strategy strategy;

	private BateauFactory bf; //factory de bateau (pour recuperer les images des bateaux)
	private Etat etat; //etat du jeu
	private boolean placeVertical = false; 
	private int currentSize = 0;
	private Bateau currentShip;

	//Carte
	private World worldPlayer; //carte du joueur
	private World worldComputer; //carte de l IA

	private Profil profil;
	private String info;
    private String _date;
	
	public enum Etat {
		WAIT, PLAYERTURN, COMPUTERTURN, PLACINGBOATS, PLAYERWIN, COMPUTERWIN
	}
	
	///////////////////////////// CONSTRUCTEUR ////////////////////////////////
	/**
	 * Constructeur sans parametre
	 * 
	 */
	public Game() {
		strats = new ArrayList<IA_Strategy>();
		epoques = new ArrayList<Epoque>();

		profil = new Profil("profil1");
		 // Recuperation de la date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Calendar cal = Calendar.getInstance();
        this._date = dateFormat.format(cal.getTime());

		
        //recuperation des deux strategies dans strats
		strats.add(new IntelligentStrategy());
		strats.add(new AleatoireStrategy());
		
		bf = new BateauFactory();
		
		//recuperation des images des bateaux du XXe siecle
		Epoque siecle_20 = new Siecle_XX();
		//Bateaux 20 eme siecle
		siecle_20.addShip(bf.getBateau("ContreTorpilleur"));
		siecle_20.addShip(bf.getBateau("Croiseur"));
		siecle_20.addShip(bf.getBateau("PorteAvion"));
		siecle_20.addShip(bf.getBateau("SousMarin"));
		siecle_20.addShip(bf.getBateau("Torpieur"));
		
		
		//recuperation des images des bateaux du XVIe siecle
		Epoque siecle_16 = new Siecle_XVI();
		//Bateaux 16 eme siecle
		siecle_16.addShip(bf.getBateau("Brick"));
		siecle_16.addShip(bf.getBateau("Galeasse"));
		siecle_16.addShip(bf.getBateau("Fregate"));
		siecle_16.addShip(bf.getBateau("Galion"));
		siecle_16.addShip(bf.getBateau("NavireDeLigne"));
		
		//recuperation des deux epoques dans la liste epoques
		epoques.add(siecle_16);
		epoques.add(siecle_20);

		worldPlayer = new World();
		worldComputer = new World();

		epoque = new Siecle_XVI();
		strategy = new AleatoireStrategy();

		etat = Etat.WAIT;
		info = "Bienvenue";
	}


	/**
	 * lancement d une nouvelle partie
	 * @param a l epoque
	 * @param m la strategie
	 * @param al 1 si placement aleatoire, 0 sinon
	 */
	public void newGame(Epoque a, IA_Strategy m, int al) {
		
		etat = Etat.WAIT;
		update();
		
		currentSize = 0;
		placeVertical = false;
		worldPlayer.clearWorld();
		worldComputer.clearWorld();

		epoque = a;
		strategy = m;

		worldPlayer.setNbLives(0);
		
		etat = Etat.PLACINGBOATS;
		update();
		
		
		if(al == 1)
			placeAleatoryBoats();
	}
	
	/**
	 * Choix de placement aleatoire des bateaux
	 */
	public void placeAleatoryBoats() {
		
		for(int i = 0; i < epoque.getShips().size(); i++) {
			placeShipAleatory(worldPlayer, epoque.getShips().get(i), epoque.getShips().get(i).getSize());
			placeShipAleatory(worldComputer, epoque.getShips().get(i), epoque.getShips().get(i).getSize());
		}
		
		etat = Etat.PLAYERTURN;
		update();
	}

	/**
	 * Pour la partie rapide
	 * Par défaut : Epoque 16 eme - strategie aleatoire - placement aleatoire
	 */
	public void newFastGame() {
		newGame(epoques.get(0), strats.get(1), 1);
	}
	
	/**
	* Place aleatoirement un bateau dans un monde 'world'
	*/
	public void placeShipAleatory(World world, Bateau bateau, int size) {
		
		boolean vertical;
		int x, y;
		
		if(Math.random() > 0.5) vertical = true;
		else vertical = false;
		
		boolean ship = false;
		
		while (!ship) {
			
			if(vertical){
				x = (int) (Math.random() * (world.getNbRows() - size)) + 1;
				y = (int) (Math.random() * world.getNbCols()) + 1;
			} 
			else {
				x = (int) (Math.random() * world.getNbRows()) + 1;
				y = (int) (Math.random() * (world.getNbCols() - size)) + 1;
			}
			
			boolean boat = false;
			if(!vertical) {
				for(int k = 1; k <= size; k++) {
					if(world.shipHit(x, y+(k-1), false))
						boat = true;
				}
			}
			else {
				for(int k = 1; k <= size; k++) {
					if(world.shipHit(x+(k-1), y, false))
						boat = true;
				}
			}
			
			if (!boat) {
				currentShip = bateau.copy();
				currentShip.setX(x);
				currentShip.setY(y);
				currentShip.setVertical(vertical);
				currentShip.setCases();
				
				world.addShip(currentShip);
				
				currentSize = 0;
				currentShip = null;
				placeVertical = false;
				
				ship = true;
			}	
		}
	}
	
	/**
	* Place un bateau dans une case (x,y) dans le monde du joueur
	*/
	public void placeShip(int x, int y) {
		
		if(currentSize != 0) {
			
			int vertX = 0;
			int vertY = 0;
		
			if(!placeVertical) vertY = currentSize-1;
			else vertX = currentSize-1;
		
			if(x >= 1 && x <= worldPlayer.getNbCols() - vertX && y >= 1 && y <= worldPlayer.getNbRows() - vertY) {
				boolean ok = true;
				for(int i = 1; i <= currentSize; i++) {
					
					if(worldPlayer.shipHit(x+vertX, y+vertY, false)) {
						ok = false;
					}	
				
					if(!placeVertical) vertY = vertY-1;
					else vertX = vertX-1;
				}
				
				if(ok) {
					
					currentShip.setX(x);
					currentShip.setY(y);
					currentShip.setVertical(placeVertical);
					
					currentShip.setCases();
					worldPlayer.addShip(currentShip);
					
					currentSize = 0;
					currentShip = null;
					placeVertical = false;
					
					//Si tous les bateaux du joueur ont ete places
					if (worldPlayer.getNbBoats() == epoque.getNbShip()) {
						etat = Etat.PLAYERTURN;
						
						for(int i = 0; i < epoque.getShips().size(); i++) {
							placeShipAleatory(worldComputer, epoque.getShips().get(i) , epoque.getShips().get(i).getSize());
						}
					}
					update();
				}
			}
		}
	}
	/**
	 *Mise a jour des affichage de la barre d'info 
	 */
	public void update() {
		setInfo();
		setChanged();
		notifyObservers();
	}

	/**
	 * Strategie de shoot aleatoire
	 */
	public void aleatoryShoot() {
		strategy.shoot(worldPlayer);
		gameFinished();
		update();
	}
	
	/**
	 * Pour clicker sur une case du jeux
	 */
	public void shoot(int x, int y) {
		if (etat == Etat.PLAYERTURN && !worldComputer.caseTaken(x, y)) {
			Case shoot = new Case(x, y);
			if(worldComputer.shipHit(x, y, true)) {
				shoot.hit();
			}
			worldComputer.addShoot(shoot);
			
			boolean fin = gameFinished();
			update();
	
			if(!fin) 
				aleatoryShoot();
		}
	}
	
	/**
	 * Retourne true si la partie est finie.
	 */
	public boolean gameFinished() {

		if (worldComputer.getNbLives() == 0) {
			etat = Etat.PLAYERWIN;
			return true;
		}
		
		if (worldPlayer.getNbLives() == 0) {
			etat = Etat.COMPUTERWIN;
			return true;
		}
		
		return false;
	}
	
	/*
	 * lors du choix des placements des bateaux
	 */
	public boolean mouseOver(int x, int y) {
		if(etat == Etat.PLACINGBOATS){
			int vertX = 0;
			int vertY = 0;
			
			if(!placeVertical) vertY = currentSize-1;
			else vertX = currentSize-1;
			
			if(x < 1 || x > worldPlayer.getNbCols()-vertX || y < 1 || y > worldPlayer.getNbRows()-vertY) {
				return false;
			}

			boolean ok = true;
			for(int i = 1; i <= currentSize; i++) {
				if(worldPlayer.shipHit(x+vertX, y+vertY, false)) {
					ok = false;
				}	
				
				if(!placeVertical) vertY = vertY-1;
				else vertX = vertX-1;
			}
			
			return ok;
		}
		return false;
	}
	
	
	//GETTERS AND SETTERS
	
	public void setVertical() {
		placeVertical = !placeVertical;
	}
	
	public void setVertical(boolean b) {
		placeVertical = b;
	}

	public String getAge() {
		return epoque.getName();
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo() {
		switch (etat) {
		
		case WAIT:		 	info = "En attente du lancement d'une partie"; 
							break;
		case PLACINGBOATS:	info = "Veuillez placer vos bateaux"; 
							break;
		case PLAYERTURN:	info = "A vous de jouer"; 
							break;
		case COMPUTERTURN:	info = "En attente de l'ordinateur"; 
							break;
		case PLAYERWIN:		info = "Vous avez gagné !\n Voulez vous rejouer";
							
							int returnGagne = JOptionPane.showConfirmDialog(null, info, "Fini", JOptionPane.YES_NO_OPTION);
							if (returnGagne == JOptionPane.NO_OPTION || returnGagne==JOptionPane.CLOSED_OPTION){
								System.exit(0);
								break;
							}else{
								break;
							}
							
		case COMPUTERWIN:	info = "Vous avez perdu !\n Voulez vous rejouer";
							int returnPerdu = JOptionPane.showConfirmDialog(null, info, "Fini", JOptionPane.YES_NO_OPTION);
							if (returnPerdu == JOptionPane.NO_OPTION || returnPerdu==JOptionPane.CLOSED_OPTION){
								System.exit(0);
								break;
							}else{
								break;
							}
		}
	}

	public World getPlayerWorld() {
		return worldPlayer;
	}
	
	public World getComputerWorld() {
		return worldComputer;
	}
	
	public void setCurrentShip(Bateau bateau, int size) {
		currentShip =  bateau.copy();
		currentSize = size;
	}

	/*
	 * return le profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/*
	 * return la liste des strategies
	 */
	public ArrayList<IA_Strategy> getStrategies() {
		return strats;
	}

	/*
	 * return la strategie choisi
	 */
	public IA_Strategy getStrategy() {
		return strategy;
	}
	
	
	/*
	 * return la liste des epoques
	 */
	public ArrayList<Epoque> getEpoques() {
		return epoques;
	}
	
	/*
	 * return Epoque de bateau
	 */
	public Epoque getEpoque() {
		return epoque;
	}

	public Etat getEtat() {
		return etat;
	}
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }
    
	public ArrayList<IA_Strategy> getStrats() {
		return strats;
	}

	public void setStrats(ArrayList<IA_Strategy> strats) {
		this.strats = strats;
	}


	public void setProfil(Profil profil) {
		this.profil = profil;
	}
    
}