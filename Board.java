import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Dimension;

public class Board extends JPanel{

 public Board(int height, int width, int mines, JLabel statusbar)
 {
  board_height = height;
  board_wdith = width;
  board_mines = mines;
  
  Minefield m = new Minefield();
  //setStatusbar(statusbar); ...?
  
  // do not edit the two lines below this! 
  setPreferredSize(new Dimension(Configuration.BOARD_WIDTH, Configuration.BOARD_HEIGHT));
  addMouseListener(new MouseReader(this));
 }

 @Override
 public void paintComponent(Graphics g)
 {
  // Here, you must invoke method draw(g) of the Minefield object
 }
 
 public Minefield getMinefield(){
 
 }
 
 public boolean isGameOver(){
 
 }
 
 public void setStatusbar(String text){
 
 }
 
 public boolean removeMine(){
 
 }
 
 public boolean addMine(){
 
 }
 
 

 public void mouseClickOnLocation(int x, int y, String button)
 {
  /*
   Your code goes here.

   Do not remove the invocation of repaint() below
  */
  repaint();
 }
 
}
