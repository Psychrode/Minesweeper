import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Dimension;

public class Board extends JPanel{
	private int board_height;
	private int board_width;
	private int board_mines;
	private JLabel game_statusbar;
    private boolean isGameOver;
    private Minefield m = new Minefield();

 public Board(int height, int width, int mines, JLabel statusbar)
 {
  board_height = height;
  board_width = width;
  board_mines = mines;
  game_statusbar = statusbar;
  
  // set parameters for board size
  setPreferredSize(new Dimension(Configuration.BOARD_WIDTH, Configuration.BOARD_HEIGHT));
  addMouseListener(new MouseReader(this));
 }

 @Override
 public void paintComponent(Graphics g)
 {
  // drawing board here
	 m.draw(g);
 }
 
 public Minefield getMinefield(){
	 return m;
 }
 
 public boolean isGameOver(){
		 return isGameOver;
 }
 
 public void setStatusbar(String text){
	 game_statusbar.setText(text);
 }
 
 public String getStatusbar() {
	 return "Game over! - you won! - or you lost!";
 }
 
 public boolean removeMine(){
	 if (board_mines < 1) {
		 game_statusbar.setText("Invalid action");
	 }
	 else {
		 board_mines -= 1;
		 String mines = board_mines + " mines remaining";
		 game_statusbar.setText(mines);
		 return true;
	 }
 }
 
 public boolean addMine(){
	 board_mines += 1;
	 String mines = board_mines + " mines remaining";
	 game_statusbar.setText(mines);
	 return true;
 }


 public void mouseClickOnLocation(int x, int y, String button){
	 Object cell = m.getCellByScreenCoordinates(x, y);
	 if (button.equals("left")) {
		 if(cell instanceof MineCell) {
			 this.isGameOver = true;
			 isGameOver();
		 }
		 else if(cell instanceof InfoCell) {
			 int numberADJcells = ((InfoCell) cell).getNumOfAdjacentMines();
			 ((InfoCell) cell).setStatus(Configuration.STATUS_UNCOVERED);
			 if(numberADJcells == 0) {
				 
			 }
		 }
	 }

	 else if (button.equals("right")){
		 
	 }
	 else {
		 
	 }

  
  
   repaint();
 }
 
}
