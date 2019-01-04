import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class PanelMaze extends JPanel{
	
	private Tile[][] tile = new Tile[20][20];
	private Integer x, y, random_X, random_Y;
	private Random rand = new Random();
	
	public PanelMaze() {
		setBounds(0, 0, 800, 800);
		reset();
	}
		
	public void reset(){
		x = 1;
		y = 1;
		
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				if(i == 1 && j == 1){
					tile[i][j] = new Tile(40, 40, "Player");
				}
				else if(i == 18 && j == 18){
					tile[i][j] = new Tile(720, 720, "Exit");
				}
				else if(i == 0 || i == 19 || j == 0 || j == 19){
					tile[i][j] = new Tile(i * 40, j * 40, "Wall");
				}
				else{
					tile[i][j] = new Tile(i * 40, j * 40, "Floor");
				}
			}
		}
		
		Integer i = 0;
		do{
			random_X = rand.nextInt(20);
			random_Y = rand.nextInt(20);
			if(tile[random_X][random_Y].getStatus().equals("Floor")){
				tile[random_X][random_Y].setStatus("Coin");
				i++;
			}
		}
		while(i < 5);
		
		i = 0;
		do{
			random_X = rand.nextInt(20);
			random_Y = rand.nextInt(20);
			if(tile[random_X][random_Y].getStatus().equals("Floor")){
				tile[random_X][random_Y].setStatus("Trap");
				i++;
			}
		}
		while(i < 3);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				if(tile[i][j].getStatus().equals("Floor")){
					g2d.setColor(Color.WHITE);
				}
				else if(tile[i][j].getStatus().equals("Wall")){
					g2d.setColor(Color.BLACK);
				}
				else if(tile[i][j].getStatus().equals("Coin")){
					g2d.setColor(new Color(251, 192, 45));
				}
				else if(tile[i][j].getStatus().equals("Trap")){
					g2d.setColor(new Color(237, 2, 10));
				}
				else if(tile[i][j].getStatus().equals("Exit")){
					g2d.setColor(new Color(0, 195, 229));
				}
				else if(tile[i][j].getStatus().equals("Player")){
					g2d.setColor(new Color(7, 247, 35));
				}
				g2d.fillRect(tile[i][j].getX(), tile[i][j].getY(), 40, 40);
			}
		}
	}
	
	public String moveUp(){
		String s = "";
		if(!tile[x][y - 1].getStatus().equals("Wall")){
			if(tile[x][y - 1].getStatus().equals("Coin")){
				s = "Coin";
			}
			if(tile[x][y - 1].getStatus().equals("Trap")){
				s = "Trap";
			}
			if(tile[x][y - 1].getStatus().equals("Exit")){
				s = "Exit";
			}
			tile[x][y].setStatus("Floor");
			y -= 1;
			tile[x][y].setStatus("Player");
		}
		return s;
	}
	
	public String moveDown(){
		String s = "";
		if(!tile[x][y + 1].getStatus().equals("Wall")){
			if(tile[x][y + 1].getStatus().equals("Coin")){
				s = "Coin";
			}
			if(tile[x][y + 1].getStatus().equals("Trap")){
				s = "Trap";
			}
			if(tile[x][y + 1].getStatus().equals("Exit")){
				s = "Exit";
			}
			tile[x][y].setStatus("Floor");
			y += 1;
			tile[x][y].setStatus("Player");
		}
		return s;
	}
	
	public String moveLeft(){
		String s = "";
		if(!tile[x - 1][y].getStatus().equals("Wall")){
			if(tile[x - 1][y].getStatus().equals("Coin")){
				s = "Coin";
			}
			if(tile[x - 1][y].getStatus().equals("Trap")){
				s = "Trap";
			}
			if(tile[x - 1][y].getStatus().equals("Exit")){
				s = "Exit";
			}
			tile[x][y].setStatus("Floor");
			x -= 1;
			tile[x][y].setStatus("Player");
		}
		return s;
	}
	
	public String moveRight(){
		String s = "";
		if(!tile[x + 1][y].getStatus().equals("Wall")){
			if(tile[x + 1][y].getStatus().equals("Coin")){
				s = "Coin";
			}
			if(tile[x + 1][y].getStatus().equals("Trap")){
				s = "Trap";
			}
			if(tile[x + 1][y].getStatus().equals("Exit")){
				s = "Exit";
			}
			tile[x][y].setStatus("Floor");
			x += 1;
			tile[x][y].setStatus("Player");
		}
		return s;
	}
}