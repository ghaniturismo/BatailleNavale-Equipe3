package sauvegarde;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import model.Bateau;
import model.Case;
import model.Game;
import model.Profil;

/**
 * DAO_Sauvegarde
 */
public class DAO_Sauvegarde {

    
    public DAO_Sauvegarde() {
        
        File f = new File("users");
        if (!f.exists()) {
            f.mkdir();
        }
        
    } 
    
        
    /**
     * Permet d'enregistrer une partie de jeu Game
     */
    public void saveGame(Game game) {

        try {
        	
        	Profil profil = game.getProfil();
            // Profil
            Element eProfil = new Element("profil");
            Document doc = new Document();
            doc.setRootElement(eProfil);

            // Id
            Element idProfil = new Element("id");
            idProfil.setAttribute(new Attribute("id", profil.getId()));
            doc.getRootElement().addContent(idProfil);

            // Nom
            Element nomProfil = new Element("nom");
            nomProfil.setAttribute(new Attribute("nom", profil.getNom()));
            doc.getRootElement().addContent(nomProfil);

            // Date
	        Element date = new Element("date");
	        date.addContent(new Element("date").setText(game.getDate()));
	        doc.getRootElement().addContent(date);

	        
            // Strategie
            Element strategies = new Element("Strategie"); 
            strategies.addContent(new Element("Level").setText(game.getStrategy().getName()+""));
            doc.getRootElement().addContent(strategies);
            
            // Epoque
            Element epoque = new Element("Epoque"); 
            epoque.addContent(game.getEpoque().getName()+"");
            doc.getRootElement().addContent(epoque);
            
            //Etat
            Element etat = new Element("Etat"); 
            etat.addContent(game.getEtat().name() +"");
            doc.getRootElement().addContent(etat);
            
            
//*********************        COMPUTER            ************************************
            Element joueur1 = new Element("joueur1");
            joueur1.addContent(new Element("nom").setText("Computer"));
            joueur1.addContent(new Element("nbVie").setText(game.getComputerWorld().getNbLives()+""));
                
            Element caseSj1 = new Element("cases");
            for(Case c : game.getComputerWorld().getCases()) {
            	Element caseJ = new Element("case");
            	
                caseJ.addContent(new Element("abs").setText(c.getX()+""));
                caseJ.addContent(new Element("ord").setText(c.getY()+""));
                caseJ.addContent(new Element("HitCase").setText(c.isHit()+""));

                caseSj1.addContent(caseJ);
            }
            
            joueur1.addContent(caseSj1);
            //Stockage des Bateaux
            Element bateauxXml1 = new Element("Bateaux");
            
            for(Bateau bateau : game.getComputerWorld().getShips()) {
            	Element bateauXml = new Element("Bateau");
            	
            	bateauXml.addContent(new Element("NomBateau").setText(bateau.getType()+""));
            	
                for(Case c : bateau.getCases()) {
                	Element caseJJ = new Element("case");
                	
                	caseJJ.addContent(new Element("abs").setText(c.getX()+""));
                	caseJJ.addContent(new Element("ord").setText(c.getY()+""));
                	caseJJ.addContent(new Element("HitCase").setText(c.isHit()+""));

                    bateauXml.addContent(caseJJ);
                }
                bateauxXml1.addContent(bateauXml);
                
            }
            joueur1.addContent(bateauxXml1);
            doc.getRootElement().addContent(joueur1);
          
                        
            
            //*********************          PLAYER           ************************************  
            Element joueur2 = new Element("joueur2");
            joueur2.addContent(new Element("nom").setText("Player"));
            joueur2.addContent(new Element("nbVie").setText(game.getPlayerWorld().getNbLives()+""));
                
            Element caseSj2 = new Element("cases");
            for(Case c : game.getComputerWorld().getCases()) {
            	Element caseJ = new Element("case");
                caseJ.addContent(new Element("abs").setText(c.getX()+""));
                caseJ.addContent(new Element("ord").setText(c.getY()+""));
                caseJ.addContent(new Element("HitCase").setText(c.isHit()+""));

                caseSj2.addContent(caseJ);
            }
            joueur2.addContent(caseSj2);
            
            //Stockage des Bateaux
            Element bateauxXmlJ2 = new Element("Bateaux");
            
            for(Bateau bateau : game.getPlayerWorld().getShips()) {
            	Element bateauXml = new Element("Bateau");
            	
            	bateauXml.addContent(new Element("NomBateau").setText(bateau.getType()+""));
            	
                for(Case c : bateau.getCases()) {
                	Element caseJJ = new Element("case");
                	
                	caseJJ.addContent(new Element("abs").setText(c.getX()+""));
                	caseJJ.addContent(new Element("ord").setText(c.getY()+""));
                	caseJJ.addContent(new Element("HitCase").setText(c.isHit()+""));

                    bateauXml.addContent(caseJJ);
                }
                bateauxXmlJ2.addContent(bateauXml);
            }
            joueur2.addContent(bateauxXmlJ2);
            
            
            doc.getRootElement().addContent(joueur2);

            
            XMLOutputter xmlOutput = new XMLOutputter();

            // Enregistrer le fichier
            String file = "users" + File.separator + profil.getNom() + ".xml";
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(file));
 
        } catch (IOException io) {
              System.out.println(io.getMessage());
        }
      
    }

 /**************************** PARTIE ***********************************/
    
    /**
     * Permet de recuperer une partie d'un profil
     * @param id identifiant de la partie
     * @param profil profil dans lequel on souhaite recuperer la partie
     * @return la partie de game souhaitee.
     */
    public Game loadGame(Profil profil) {
        
        Game game = new Game();
        File folder = new File("users");
        File[] listOfFiles = folder.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) {
        	   if (listOfFiles[i].isFile() && listOfFiles[i].getName().replaceAll("\\..*", "").equals(profil.getNom())) {
                   try {
                       SAXBuilder builder = new SAXBuilder();
                       Document document = (Document) builder.build(listOfFiles[i]);
                       Element rootNode = document.getRootElement();
                       List<?> list = rootNode.getChildren("partie");
                       for (int j = 0; j < list.size(); j++) {
                    	   /*
                    	    * A completer
                    	    */
                       }
                       
                   } catch (FileNotFoundException ex) {
                	   Logger.getLogger(DAO_Sauvegarde.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (JDOMException | IOException ex) {
                       Logger.getLogger(DAO_Sauvegarde.class.getName()).log(Level.SEVERE, null, ex);
                   }         		   
        	   }
        }
        
        return game;
        
    }
    
    
} // class DAO_Sauvegarde
