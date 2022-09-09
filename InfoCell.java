import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class InfoCell{
	int row;
	int column;
	int numOfAdjacentMines;
	String status;
	
  public InfoCell(int row, int column, int numOfAdjacentMines){
	  this.row = row;
	  this.column = column;
	  this.numOfAdjacentMines = numOfAdjacentMines;
  }
  
  public void draw(Graphics g){
	  g.drawImage(this.getImage(), this.getHorizontalPosition(), this.getVerticalPosition(), null);
  }
  
  public int getHorizontalPosition(){
	  return Configuration.CELL_SIZE * column;
  }
  
  public int getVerticalPosition(){
	  return Configuration.CELL_SIZE * row;
  }
  
  public String getStatus(){
	  return status;
  }
  
  public void setStatus(String status){
	  this.status = status;
  }
  
  public Image getImage(){
	  ImageIcon a;
	  if(this.getStatus().equals(Configuration.STATUS_COVERED)) {
		  a = new ImageIcon("covered_cell.png");
		  return a.getImage();
	  }
	  else if(this.getStatus().equals(Configuration.STATUS_UNCOVERED)) {
		  
		  if(numOfAdjacentMines == 0) {//fix later
			  a = new ImageIcon("info_0.png");
		  }
		  else if(numOfAdjacentMines == 1) {
			  a = new ImageIcon("info_1.png");

		  }
		  else if(numOfAdjacentMines == 2) {
			  a = new ImageIcon("info_2.png");
		  }
		  else if(numOfAdjacentMines == 3) {
			  a = new ImageIcon("info_3.png");
		  }
		  else if(numOfAdjacentMines == 4) {
			  a = new ImageIcon("info_4.png");
		  }
		  else if(numOfAdjacentMines == 5) {
			  a = new ImageIcon("info_5.png");
		  }
		  else if(numOfAdjacentMines == 6) {
			  a = new ImageIcon("info_6.png");
		  }
		  else if(numOfAdjacentMines == 7) {
			  a = new ImageIcon("info_7.png");
		  }
		  else{
			  a = new ImageIcon("info_8.png");
		  }
		  return a.getImage();
	  }
	  else if(this.getStatus().equals(Configuration.STATUS_MARKED)) {
		  a = new ImageIcon("marked_cell.png");
		  return a.getImage();
		  }
	  else {
    	  a = new ImageIcon("wrong_mark.png");
    	  return a.getImage();
	  }
  }
  
  public int getNumOfAdjacentMines(){
	  return numOfAdjacentMines;
  }

}