/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author karim
 */
public abstract class Bateau {
    
	private String type;
    private int taille;
    private int force;
    private int robustesse;
    private int nb_projectile;
    private boolean dead;
    
    private ArrayList<Case> cases;
    
    public Bateau(String type, int taille){
    	this.type = type;
    	this.taille = taille;
    }
    
}
