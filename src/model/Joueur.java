package model;

import java.util.ArrayList;


public class Joueur {

    ////////////////////////////// VARIABLES //////////////////////////////////
	
    protected String nom;
    protected ArrayList<Case> cases;  
    
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////

    public Joueur() {
        
    } 
    
    public Joueur(String nom){
    	this.nom = nom;
    }
    
    
}
