package sauvegarde;


/**
 * DAOFactory
 */
public class DAOFactory {
    
    private static final DAOFactory INSTANCE = new DAOFactory();
    
    private DAOFactory() {
    
    }
    
    
    /** Point d'accès pour l'instance unique du singleton
      * @return une instance du singleton 
      */
    public static DAOFactory getInstance() {	
        
        return INSTANCE;
        
    } 

    
    /**
     * Permet d'avoir acces au fichier de configuration
     * @return la classe permettant l'acces au fichier de configuration
     */
    public DAO_Configuration getDAO_Configuration() {
        
        return new DAO_Configuration();
        
    } 

    
    /**
     * Permet d'avoir acces au fichier de sauvegarde
     * @return la classe permettant l'acces au fichier de sauvegarde
     */
    public DAO_Sauvegarde getDAO_Sauvegarde() {
        
        return new DAO_Sauvegarde();
        
    }
    
}