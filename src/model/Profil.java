package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Profil {
    
    
    ////////////////////////////// VARIABLES //////////////////////////////////
    

    private String _id;
    private String _nom;
    private String _date;
    
    ///////////////////////////// CONSTRUCTEUR ////////////////////////////////
    
    
    public Profil() {
        
    } 
    
    
    public Profil(String nom) {
        
        // Recuperation de la date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Calendar cal = Calendar.getInstance();
    	
        this._id = nom + this.hashCode();
        this._nom = nom;
        this._date = dateFormat.format(cal.getTime());
        
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

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }
    

} // class Profil
