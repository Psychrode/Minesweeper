import java.awt.Graphics;
import java.util.Random;

public class Minefield{
	private Object[][] field;
	int numRows;
	int numColumns;
	int numMines;
	
  public Minefield(){
	  Minefield defaultStats = new Minefield(10, 10, 10);
  }
  
  public Minefield(int numRows, int numColumns, int numMines){
	  this.numRows = numRows;
	  this.numColumns = numColumns;
	  this.numMines = numMines;
	  Minefield customStats = new Minefield(numRows, numColumns, numMines);
	  mineLaying(numMines);
	  addInfoCells();
  }
  
  public void mineLaying(int numOfMines){
	  Random r = new Random();
	  
	  while(numOfMines > 0) {
		  int randX = r.nextInt(r.nextInt(Configuration.ROWS));
		  int randY = r.nextInt(r.nextInt(Configuration.COLS));
		  field[randX][randY] = new MineCell(randX, randY);
		  numOfMines -= 1;
	  }
  }
  
  public void addInfoCells(){
	  for(int i=0; i<field.length;i++) {
		  for(int j=0; j<field[0].length;j++) {
			  if(field[i][j] == null) {
				  field[i][j] = new InfoCell(i, j, ((InfoCell) field[i][j]).getNumOfAdjacentMines());
			  }
		  }
	  }
  }
  
  public void draw(Graphics g){
	  for (int i = 0; i < field.length; i++) {
		  for (int j = 0; j < field[0].length; j++) {
			  field[i][j].draw(g);
		  }
	  }
  }
  
  public Object getCellByScreenCoordinates(int x, int y){
	  int cellX = x / Configuration.CELL_SIZE;
	  int cellY = y / Configuration.CELL_SIZE;
	  return field[cellX][cellY];
  }
  
  public Object getCellByRowCol(int row, int col){
	  return field[row][col];
  }
  
  public void setMineCell(int row, int col, MineCell cell){
	  field[row][col] = cell;
  }
  
  public void setInfoCell(int row, int col, InfoCell cell){
	  field[row][col] = cell;
  }
  
  public int countCellsWithStatus(String status){
	  int statusCounter = 0;
	  for(int i=0; i<field.length; i++) {
		  for(int j=0; j<field[0].length; j++) {
			  if(field[i][j].getStatus().equals("STATUS_COVERED")) {
				  statusCounter++;
			  }
		  }
	  }
	  return statusCounter;
  }
  
  public void openCells(Object cell){
	  for(int i=0; i<field.length; i++) {
		  for(int j=0; j<field[0].length; j++) {
			  if(field[i][j].equals(cell)) {
				  
			  }
				  
			  }
		  }
  }
  
  public void revealIncorrectMarkedCells(){
  
  }
  
}