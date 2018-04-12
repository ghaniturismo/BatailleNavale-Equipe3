import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.GridController;
import controller.MenuController;
import controller.ShipController;
import model.Game;
import view.GridView;
import view.InfoView;
import view.Menu;
import view.ShipSelectionView;

public class MenuF extends JFrame {
	
	
	private Game game;
	private Menu menu;
	private GridController controller;
	private MenuController menuController;

	public MenuF() {

		/*
		 * Set look and feel -Theme-
		 */
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(this.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		
		JFrame frame = new JFrame("Bataille navale");
			
		game = new Game();
		controller = new GridController(game);
		menuController = new MenuController(game);
		menu = new Menu(game, menuController);
		frame.setJMenuBar(menu);
		
		GridView gridView = new GridView(controller, true);
		
		InfoView infoView = new InfoView();
		
		frame.add(gridView, BorderLayout.CENTER);
		
		frame.add(infoView, BorderLayout.NORTH);
			
		ShipSelectionView shipSelectionView = new ShipSelectionView(new ShipController(game));
		game.addObserver(shipSelectionView);
		frame.add(shipSelectionView, BorderLayout.SOUTH);

		game.addObserver(gridView);
		game.addObserver(infoView);
		game.addObserver(menu);
		
		// Ordinateur
		GridView gridComputer = new GridView(controller, false);
		frame.add(gridComputer, BorderLayout.EAST);
		game.addObserver(gridComputer);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
			
		SwingUtilities.updateComponentTreeUI(this);
	}
	}