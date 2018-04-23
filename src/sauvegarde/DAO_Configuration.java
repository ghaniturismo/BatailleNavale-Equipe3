package sauvegarde;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 * DAO_Configuration
 */
public class DAO_Configuration {


    private final String path = "/source/stockage_partie/fich_config.xml";
    private Document document;
    private final Element racine;

 
    public DAO_Configuration() {
        
        SAXBuilder sxb = new SAXBuilder();
        try {
            
            //On crée un nouveau document JDOM avec en argument le fichier XML
            File f = new File(path);
            File dossier = new File("stockage");
            if (!dossier.exists()) {
                dossier.mkdir();
            }
            if (!f.exists()) {
                this.ecrireFichConfig();
            }
            document = sxb.build(f);
            
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        racine = document.getRootElement();
        
    } 
    
    
    /**
     * Permet d'ecrire le fichier de configuration s'il est introuvable
     */
    private void ecrireFichConfig() {
        
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        		  +"<BatailleNavale>\n"
        		  +"	<Strategies>\n"
        		  +"		<Level>Intelligent</Level>\n"
        		  +"		<Level>Aléatoire</Level>\n"
        		  +"	</Strategies>\n"
        		  +"	<Epoques>\n"
        		  +"		<Epoque>\n"
        		  +"			<Name>16 EME Siecle</Name>\n"
        		  +"			<Bateaux>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Brick</ShipName>\n"
        		  +"					<Size>1</Size>\n"
        		  +"				</Bateau>\n"
        	      +"				<Bateau>\n"
        		  +"					<ShipName>Fregate</ShipName>\n"
        	      +"					<Size>3</Size>\n"
        		  +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Galeasse</ShipName>\n"
        		  +"					<Size>2</Size>\n"
        		  +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        	      +"					<ShipName>Galion</ShipName>\n"
        		  +"					<Size>3</Size>\n"
        	      +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        	      +"					<ShipName>NavireDeLigne</ShipName>\n"
        		  +"					<Size>4</Size>\n"
        		  +"				</Bateau>\n"
        		  +"			</Bateaux>\n"
        		  +"		</Epoque>\n"
        		  +"		<Epoque>\n"
        		  +"			<Name>20 EME Siecle</Name>\n"
        		  +"			<Bateaux>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Torpilleur</ShipName>\n"
        		  +"					<Size>2</Size>\n"
        		  +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Sous-Marin</ShipName>\n"
        		  +"					<Size>3</Size>\n"
        		  +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Contre Torpilleur</ShipName>\n"
        		  +"					<Size>3</Size>\n"
        		  +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Croiseur</ShipName>\n"
        		  +"					<Size>4</Size>\n"
        	      +"				</Bateau>\n"
        		  +"				<Bateau>\n"
        		  +"					<ShipName>Porte Avion</ShipName>\n"
        		  +"					<Size>5</Size>\n"
        		  +"				</Bateau>\n"
        		  +"			</Bateaux>\n"
        		  +"		</Epoque>\n"
        		  +"	</Epoques>\n"
        		  +"\n"
        		  +"</BatailleNavale>";
        
        try {
            
            File f = new File("/source/stockage_partie/fich_config.xml");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(s);
            bw.newLine();
            bw.flush();
            bw.close();
            
        } catch (IOException ex) {
        	
        }
        
    } 

}