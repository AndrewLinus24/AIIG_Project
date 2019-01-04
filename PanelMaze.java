import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelMaze extends JPanel{

	public PanelMaze() {
		setBounds(0, 0, 800, 800);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, 800, 800);
	}

}
