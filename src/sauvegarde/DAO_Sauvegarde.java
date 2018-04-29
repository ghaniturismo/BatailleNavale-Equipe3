package sauvegarde;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
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
	        Element p = new Element("partie");
	        
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
	        p.addContent(new Element("date").setText(game.getDate()));
            
	        // Strategie
            p.addContent(new Element("Strategie").setText(game.getStrategy().getName()+""));
            
            // Epoque
            Element epoque = new Element("Epoque"); 
            epoque.addContent(game.getEpoque().getName()+"");
            p.addContent(epoque);

            //Etat
            Element etat = new Element("Etat"); 
            etat.addContent(game.getEtat().name() +"");
            p.addContent(etat);
            
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
            p.addContent(joueur1);
                        
            
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
            

            p.addContent(joueur2);
            doc.getRootElement().addContent(p);
            
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
//        File folder = new File("users");
//        File[] listOfFiles = folder.listFiles();
//        for (int i = 0; i < listOfFiles.length; i++) {
//        	   if (listOfFiles[i].isFile() && listOfFiles[i].getName().replaceAll("\\..*", "").equals(profil.getNom())) {
//                   try {
//                       SAXBuilder builder = new SAXBuilder();
//                       Document document = (Document) builder.build(listOfFiles[i]);
//                       Element rootNode = document.getRootElement();
//                       
//                       List list = rootNode.getChildren("partie");
//                       Element partie = (Element) list.get(0);
//                       
//                       game.getProfil().setDate(partie.getChildText("date"));
//                       game.setStrategy(partie.getChildText("Strategie"));
//                       game.setEpoque(partie.getChildText("Epoque"));
//                     
//                       System.out.println("date "+ partie.getChildText("date"));
//                       System.out.println("stra "+ partie.getChildText("Strategie"));
//                       
//                       
//                   } catch (FileNotFoundException ex) {
//                	   Logger.getLogger(DAO_Sauvegarde.class.getName()).log(Level.SEVERE, null, ex);
//                   } catch (JDOMException | IOException ex) {
//                       Logger.getLogger(DAO_Sauvegarde.class.getName()).log(Level.SEVERE, null, ex);
//                   }         		   
//        	   }
//        }
//        
        return game;
        
    }
    
    
} // class DAO_Sauvegarde
