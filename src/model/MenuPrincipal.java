package model;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MenuPrincipal{

	public JFrame frame;
	
	ImageIcon icon = new ImageIcon(getClass().getResource("/source/img/background1.jpg"));
	
	public MenuPrincipal(){
		
		frame = new JFrame();
		
		frame.setSize(900,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JPanel container = new JPanel(new BorderLayout());
		
		//On définit le layout à utiliser sur le content pane
	    frame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel()
		{	
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g)
			{
				//  Dispaly image at full size
				g.drawImage(icon.getImage(), 150, 40, null); 	
				super.paintComponent(g);
			}
		};
				
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(100,600));
		
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		container.add(panel,BorderLayout.NORTH);
 		
		JPanel southPanel = new JPanel();
		//bouton jouer
		JButton player = new JButton("Jouer");
 		southPanel.add(player);
 		
 		container.add(southPanel, BorderLayout.SOUTH);	
 		
 		
 		frame.setContentPane(container);
 		frame.setVisible(true);

		
		ActionListener play =new ActionListener(){
	
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new MenuPartie();
	                frame.dispose();
	            }
	    };
			
		player.addActionListener(play);
		frame.setVisible(true);
		}
   
}
