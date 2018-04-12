

import java.awt.*;
import javax.swing.*;



public class BackImage extends JPanel{
	
public BackImage(LayoutManager l){
	super.setLayout(l);
}

protected void paintComponent(Graphics g){
super.paintComponent(g);

Image image = new ImageIcon(BackImage.class.getResource("source/img/background1.jpg")).getImage();

int baslangicx = 0;
int baslangicy = 0;

int bitisx = getSize().width;
int bitisy = getSize().height;
g.drawImage(image,baslangicx,baslangicy,bitisx,bitisy,null);
}
}