package view;

import javax.swing.ImageIcon;

public class ImageFactory {

	private static ImageFactory instance;
	
	/*
	 * Les fonds des bouton / explosion ,tire , arriere plan
	 */
	private ImageIcon none = new ImageIcon(getClass().getResource("/source/img/0.png"));
	private ImageIcon background = new ImageIcon(getClass().getResource("/source/img/background.png"));
	private ImageIcon ship = new ImageIcon(getClass().getResource("/source/img/BoatDefault.png"));
	private ImageIcon shoot = new ImageIcon(getClass().getResource("/source/img/Miss.png"));
	private ImageIcon explosion = new ImageIcon(getClass().getResource("/source/img/Hit.png"));
	
	
		//********************
		// XX - eme siecle
		//********************
	
	
	/*
	 * Chargment du bateau Torpilleur
	 */
	private ImageIcon[] ship1H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_1_H_01.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_1_H_02.png" ))
	};

	/*
	 * Chargment du bateau SousMarin
	 */
	private ImageIcon[] ship2H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_2_H_01.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_2_H_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_2_H_03.png" ))
	};

	/*
	 * Chargment du bateau ContreTorpilleur
	 */
	private ImageIcon[] ship3H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_3_H_01.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_3_H_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_3_H_03.png" ))
	};
	
	/*
	 * Chargment du bateau Croiseur
	 */
	private ImageIcon[] ship4H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_4_H_01.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_H_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_H_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_H_04.png" ))
	};
	
	/*
	 * Chargment du bateau Porte Avion
	 */
	private ImageIcon[] ship5H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_5_H_01.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_H_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_H_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_H_04.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_H_05.png" ))
	};
	
	

	/*
	 * Chargment du bateau Torpilleur verticalement
	 */
	private ImageIcon[] ship1V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_1_V_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_1_V_01.png" ))
	};

	/*
	 * Chargment du bateau SousMarin verticalement
	 */
	private ImageIcon[] ship2V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_2_V_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_2_V_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_2_V_01.png" ))
	};

	/*
	 * Chargment du bateau ContreTorpilleur verticalement
	 */
	private ImageIcon[] ship3V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_3_V_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_3_V_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_3_V_01.png" ))
	};
	
	/*
	 * Chargment du bateau Croiseur verticalement
	 */
	private ImageIcon[] ship4V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_4_V_04.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_V_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_V_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_4_V_01.png" ))
	};
	
	/*
	 * Chargment du bateau Porte Avion verticalement
	 */
	private ImageIcon[] ship5V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Ship_5_V_05.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_V_04.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_V_03.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_V_02.png" )),
			new ImageIcon(getClass().getResource("/source/img/Ship_5_V_01.png" ))
	};
	
	//********************
	// XVI - eme siecle
	//********************
	
	/*
	 * Chargment du bateau Brick
	 */
	private ImageIcon[] boat1H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat1-1.png" ))
	};

	/*
	 * Chargment du bateau Galeasse
	 */
	private ImageIcon[] boat2H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat2-1.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat2-2.png" ))
	};

	/*
	 * Chargment du bateau Fregate
	 */
	private ImageIcon[] boat3H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat3-1.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat3-2.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat3-3.png" ))
	};
	
	/*
	 * Chargment du bateau Navire De Ligne
	 */
	private ImageIcon[] boat4H = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat4-1.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat4-2.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat4-3.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat4-4.png" ))
	};
	
	/*
	 * Chargment du bateau Brick verticalement
	 */
	private ImageIcon[] boat1V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat1-1V.png" ))
	};
	
	/*
	 * Chargment du bateau Galeasse verticalement
	 */
	private ImageIcon[] boat2V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat2-1V.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat2-2V.png" ))
	};

	/*
	 * Chargment du bateau Fregate et Galion verticalement //pour le moment il ont la meme image  
	 */
	private ImageIcon[] boat3V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat3-1V.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat3-2V.png" )),
			new ImageIcon(getClass().getResource("/source/img/Boat3-3V.png" ))
	};
	
	/*
	 * Chargment du bateau Navire De Ligne verticalement
	 */
	private ImageIcon[] boat4V = new ImageIcon[] {
			new ImageIcon(getClass().getResource("/source/img/Boat4-1V.png")),
			new ImageIcon(getClass().getResource("/source/img/Boat4-2V.png")),
			new ImageIcon(getClass().getResource("/source/img/Boat4-3V.png")),
			new ImageIcon(getClass().getResource("/source/img/Boat4-4V.png"))
	};
	
	
	private ImageFactory() {
		
	}
	
	public static ImageFactory getInstance() {
		if (instance == null) {
			instance = new ImageFactory();
		}
		return instance;
	}

	public ImageIcon getNone() {
		return none;
	}
	
	public ImageIcon getShip() {
		return ship;
	}
	
	public ImageIcon getShoot() {
		return shoot;
	}
	
	public ImageIcon getExplosion() {
		return explosion;
	}
	
	public ImageIcon getBackground() {
		return background;
	}
	
	public ImageIcon getShipXVI(int indice, String nom, boolean vertical) {
		if(!vertical){
			switch(nom) {
				case "Brick":			return boat1H[indice-1];
				case "Galeasse":		return boat2H[indice-1];
				case "Galion":			return boat3H[indice-1];
				case "Fregate":			return boat3H[indice-1];
				case "Navire De Ligne":	return boat4H[indice-1];
			}
		}
		else{
			switch(nom) {
				case "Brick": 			return boat1V[indice-1];
				case "Galeasse": 		return boat2V[indice-1];
				case "Galion": 			return boat3V[indice-1];
				case "Fregate": 		return boat3V[indice-1];
				case "Navire De Ligne":	return boat4V[indice-1];
			}
		}
		return ship;
	}

	public ImageIcon getShipXX(int indice, String nom, boolean vertical) {
		if(!vertical){
			switch(nom) {
				case "Torpilleur":			return ship1H[indice-1];
				case "Sous-Marin":			return ship2H[indice-1];
				case "Contre Torpilleur":	return ship3H[indice-1];
				case "Croiseur":			return ship4H[indice-1];
				case "Porte Avion":			return ship5H[indice-1];
			}
		}
		else{
			switch(nom) {
				case "Torpilleur": 			return ship1V[indice-1];
				case "Sous-Marin": 			return ship2V[indice-1];
				case "Contre Torpilleur": 	return ship3V[indice-1];
				case "Croiseur":			return ship4V[indice-1];
				case "Porte Avion":			return ship5V[indice-1];
			}
		}
		return ship;
	}
}
