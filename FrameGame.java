import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FrameGame extends JFrame implements KeyListener{
	
	private Thread thread_Panel;
	private Thread thread_TimeLeft;
	private PanelMaze panel_Maze = new PanelMaze();
	private PanelInfo panel_Info = new PanelInfo();
	private Boolean pause = false;

	public FrameGame() {
		thread_Panel = new Thread(new Runnable() {
			public void run() {
				while(true){
					if(!pause){
						panel_Maze.repaint();
						panel_Info.repaint();
					}
				}
			}
		});
		thread_TimeLeft = new Thread(new Runnable() {
			public void run() {
				while(true){
					if(!pause){
						panel_Info.decreaseTime();
						if(panel_Info.getTime_Left() == 0){
							lose();
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		thread_Panel.start();
		thread_TimeLeft.start();
		
		setSize(1200, 840);
		setTitle("Find the X-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		addKeyListener(this);
		
		add(panel_Maze);
		add(panel_Info);
		setVisible(true);
	}
	
	public void lose(){
		pause = true;
		JOptionPane.showMessageDialog(this, "You lose the game! Press OK to restart game!");
		panel_Maze.reset();
		panel_Info.reset();
		pause = false;
	}
	
	public void win(){
		pause = true;
		JOptionPane.showMessageDialog(this, "You won the game! Press OK to restart game!");
		panel_Info.reset();
		pause = false;
	}
	
	public void keyPressed(KeyEvent e) {
		String s = "";
		if(e.getKeyCode() == 87 && !pause){
			s = panel_Maze.moveUp();
		}
		else if(e.getKeyCode() == 83 && !pause){
			s = panel_Maze.moveDown();
		}
		else if(e.getKeyCode() == 65 && !pause){
			s = panel_Maze.moveLeft();
		}
		else if(e.getKeyCode() == 68 && !pause){
			s = panel_Maze.moveRight();
		}
		else if(e.getKeyCode() == 32 && pause){
			pause = false;
			setTitle("Find the X-it");
		}
		else if(e.getKeyCode() == 32 && !pause){
			pause = true;
			setTitle("Find the X-it - Paused");
		}
		
		if(s.equals("Coin")){
			for(int i = 0; i < 5; i++){
				panel_Info.increaseTime();
			}
		}
		else if(s.equals("Trap")){
			panel_Info.decreaseLife();
			if(panel_Info.getLife() == 0){
				lose();
			}
			else{
				pause = true;
				JOptionPane.showMessageDialog(this, "You lose a life!");
				pause = false;
			}
		}
		else if(s.equals("Exit")){
			panel_Info.increaseLevel();
			panel_Info.setLife(3);
			for(int i = 0; i < 3; i++){
				panel_Info.decreaseTime();
			}
			panel_Maze.reset();
			if(panel_Info.getLevel() == 7){
				win();
			}
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
