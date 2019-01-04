import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel{
	
	private Integer time_left = 25;
	private Integer life = 3;
	private Integer level = 1;
	private JLabel label_This;
	private JButton button_Exit;
	
	public PanelInfo() {
		setBounds(800, 0, 400, 800);
		setLayout(null);
		label_This = new JLabel("THIS");
		label_This.setFont(new Font("Arial", Font.BOLD, 16));
		label_This.setForeground(new Color(237, 2, 10));
		label_This.setBounds(127, 485, label_This.getPreferredSize().width, label_This.getPreferredSize().height);
		label_This.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {
//				remove(button_Exit);
			}
			public void mouseEntered(MouseEvent e) {
				add(button_Exit);
			}
			public void mouseClicked(MouseEvent e) {}
		});
		add(label_This);
		button_Exit = new JButton("Exit");
		button_Exit.setBounds(150, 525, 100, 40);
		button_Exit.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setFont(new Font("Arial Bold", Font.ITALIC, 36));
		g2d.drawString("Find the X-it", 705, 100);
		g2d.setFont(new Font("Arial", Font.BOLD, 16));
		g2d.drawString("Time Left: ", 75, 150);
		g2d.drawString(time_left.toString(), 175, 150);
		g2d.drawString("Life: ", 75, 175);
		g2d.drawString(life.toString(), 175, 175);
		g2d.drawString("Level: ", 75, 200);
		g2d.drawString(level.toString(), 175, 200);
		g2d.setColor(new Color(0, 195, 229));
		g2d.fillRect(75, 230, 25, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Your Goal", 125, 250);
		g2d.setColor(new Color(7, 247, 35));
		g2d.fillRect(75, 280, 25, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Player", 125, 300);
		g2d.setColor(new Color(251, 192, 45));
		g2d.fillRect(75, 330, 25, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("Coin (Extra Time)", 125, 350);
		g2d.setColor(new Color(237, 2, 10));
		g2d.fillRect(75, 380, 25, 25);
		g2d.setColor(Color.BLACK);
		g2d.drawString("It's a trap!", 125, 400);
		g2d.drawString("Press 'Space' to pause the game", 75, 450);
		g2d.drawString("Hover", 75, 500);
		g2d.drawString("to show exit button", 169, 500);
	}
	
	public void resetTime(){
		time_left = 25;
	}
	public void decreaseTime(){
		time_left--;
	}
	public void resetLife(){
		life = 3;
	}
	public void decreaseLife(){
		life--;
	}
	public void resetLevel(){
		level = 1;
	}
	public void increaseLevel(){
		level++;
	}
}
