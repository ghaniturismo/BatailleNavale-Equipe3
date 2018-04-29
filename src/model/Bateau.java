package model;


import java.util.ArrayList;

import javax.swing.ImageIcon;

import view.ImageFactory;

/**
 * Classe Bateau 
 * gère les caracteristiques d un bateau 
 */
public class Bateau {
    ////////////////////////////// VARIABLES //////////////////////////////////

	private String type;
	private int taille;
    private int posX, posY;
    private boolean vertical = false;
    private ArrayList<Case> cases;   

    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
    
    /**
     * Constructeur de la classe
     * @param type le type du bateau (brick, fregate etc...)
     * @param taille la taille du bateau dans le tableau
     */
    public Bateau(String type, int taille){
    	this.type = type;
    	this.taille = taille;
    	cases = new ArrayList<Case>();
    }
    
    /**
     * Methode getTexture retournant la texture (image) du bateau en fonction de l'indice
     */
    public ImageIcon getTexture(ImageFactory imgF, int indice, boolean vertical, String epoque) {
    	switch(epoque){
    		case "16 EME Siecle" :	return imgF.getShipXVI(indice, this.getType(), vertical);
    		case "20 EME Siecle" :	return imgF.getShipXX(indice, this.getType(), vertical);
    		default : return null;
    	}
	}

    /**
     * Methode isDead
     * @return true si toutes les cases du bateau sont touchees
     * 		   false sinon
     */
    public boolean isDead(){
    	for(int i=0; i<cases.size(); i++){
    		if(!cases.get(i).isHit())
    			return false;
    	}
    	return true;
    }
        
    public void addCase(Case c){
    	if(!cases.contains(c))
    		cases.add(c);
    }
  
    
    /*
     *  Getters and Setters
     */
    
    public int getX(){
    	return posX;
    }
    
    public void setX(int x){
    	posX = x;
    }
    
    public int getY(){
    	return posY;
    }
    
    public void setY(int y){
    	posY = y;
    }
    
    public int getSize(){
    	return taille;
    }
    
    public boolean isVertical(){
    	return vertical;
    }
    
    public void setVertical(boolean v){
    	vertical = v;
    }
    
    public String getType(){
    	return type;
    }
    
    public void setType(String type) {
		this.type = type;
	}
    
    
	public ArrayList<Case> getCases() {
    	return cases;
    }
	
	public void setCases() {
		if(vertical){
			for(int i = this.posX; i < posX + taille; i++){
				addCase(new Case(i, posY));
			}
		}
		else {
			for(int i = this.posY; i < posY + taille; i++){
				addCase(new Case(posX, i));
			}
		}
	}


	public boolean hasCase(Case c) {
		for(int i=0; i<cases.size(); i++){
			if(cases.get(i).getX() == c.getX() && cases.get(i).getY() == c.getY())
				return true;
		}
		return false;
	}

	public void setCaseHit(Case c){
    	for(int i=0; i<cases.size(); i++){
			if(cases.get(i).getX() == c.getX() && cases.get(i).getY() == c.getY()){
				cases.get(i).hit();
				break;
			}
		}
    }
    
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
	/**
	 * Methode copy
	 * @return une copie du bateau
	 */
	protected Bateau copy() {
		
		Bateau clone = new Bateau(this.type,this.taille);
	    clone.setX(this.getX());
	    clone.setY(this.getY());
	    clone.setVertical(this.isVertical());
	    if(!this.getCases().isEmpty())
	    	clone.setCases();
	    
	    return clone;
	}
	
}
