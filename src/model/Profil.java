package model;


public class Profil {
    
    
    ////////////////////////////// VARIABLES //////////////////////////////////
    

    private String _id;
    private String _nom;
    
    
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
    
    
    public Profil() {
        
    } 
    
    
    public Profil(String nom) {
        
        this._id = nom + this.hashCode();
        this._nom = nom;
        
    }


    //**** GETTER/SETTER *****//
    
      
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNom() {
        return _nom;
    }

    public void setNom(String nom) {
        this._nom = nom;
    }


} // class Profil
