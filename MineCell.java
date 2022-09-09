import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class MineCell{
	int row;
	int column;
	String status;
  
  public MineCell(int row, int column){
	  this.row = row;
	  this.column = column;
	  this.status = Configuration.STATUS_COVERED;
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
		  a = new ImageIcon("uncovered_cell.png");
		  return a.getImage();
	  }
	  else {
		  a = new ImageIcon("marked_cell.png");
		  return a.getImage();
		  }
	  }
      
}