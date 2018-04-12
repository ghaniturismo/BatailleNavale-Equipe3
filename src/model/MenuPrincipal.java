import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuPrincipal{

//JPanel jp = new JPanel();

public MenuPrincipal(){
	TestM testm = new TestM(new BorderLayout());
	
	JPanel panel = new JPanel();
	panel.setOpaque(false);
	
	
	
	//Création de bouton de jeu
	JButton player = new JButton("Jouer");

	testm.add(player,BorderLayout.NORTH);
	
	//label.setFont(new Font("serif",Font.BOLD, 16));
	JLabel label = new JLabel("Bataille Navale");
	panel.add(label);
	
	testm.add(panel);
	JFrame f = new JFrame();
	f.add(testm);
	
	f.setSize(800,500);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	f.setResizable(false);
	
	//Centre le JFrame a l'écran
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	f.setLocation(dim.width/2 - f.getWidth()/2, dim.height/2 - f.getHeight()/2);
	

	ActionListener play =new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
           		f.dispose();
				f.setVisible(false);
                MenuF march =new MenuF();
                march.setVisible(true);   
            }
      
        };
		
		player.addActionListener(play);

	}
	
	
	  
        
}