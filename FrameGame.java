import javax.swing.JFrame;

public class FrameGame extends JFrame{
	
	private Thread thread_Maze;
	private Thread thread_Info;
	private PanelMaze panel_Maze = new PanelMaze();
	private PanelInfo panel_Info = new PanelInfo();

	public FrameGame() {
		thread_Maze = new Thread(new Runnable() {
			public void run() {
				while(true){
					panel_Maze.repaint();
					panel_Info.repaint();
				}
			}
		});
		thread_Info = new Thread(new Runnable() {
			public void run() {
				while(true){
					panel_Info.decreaseTime();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread_Maze.start();
		thread_Info.start();
		
		setSize(1200, 800);
		setTitle("Find the X-it");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
	
		add(panel_Maze);
		add(panel_Info);
		setVisible(true);
	}
}
