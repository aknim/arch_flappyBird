import javax.swing.JFrame; 
import java.awt.Dimension; 
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;  
public class Display extends JPanel{
 private final int TILE_SIZE = 25;
 private final int canvasWidth, canvasHeight;
 public String [][] grid;
 private int birdY, pipeGap, birdX;
 private Coord [] pipesCoords;
 public String gameName;
 public Display(GameConfig config, InputListener inputListener){
  this.canvasWidth = config.canvasWidth; this.canvasHeight = config.canvasHeight; this.pipeGap = config.pipeGap; this.grid = new String[this.canvasHeight][this.canvasWidth]; this.gameName = config.gameName; this.birdX = this.canvasWidth/2;
    //canvas dimensions & background
  this.setPreferredSize(new Dimension(this.canvasWidth * TILE_SIZE, this.canvasHeight * TILE_SIZE));
  this.setBackground(Color.BLACK);
  this.setFocusable(true);

  this.addKeyListener(inputListener);

  //launch the OS frame window wrapper
  JFrame window = new JFrame(gameName);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.add(this);
  window.pack();
  window.setLocationRelativeTo(null); //centers window on screen
  window.setVisible(true);
  this.requestFocusInWindow();
 } 
 public void displayCanvas(int birdY, Coord [] pipesCoords){
  this.birdY = birdY;
  this.pipesCoords = pipesCoords;
  this.repaint();
 }
 @Override
 protected void paintComponent(Graphics g){
  super.paintComponent(g);
  paintBackground(g); 
  paintBird(g);
  paintPipes(g); 
  System.out.println("oo");
 }
 private void paintBackground(Graphics g){
  g.setColor(Color.GRAY);
  if (grid == null) return;
  for (int y=0; y<canvasHeight; y++){
   for (int x=0; x<canvasWidth; x++){
    paintCell(g, x, y);
   }
  }
 }
 private void paintCell(Graphics g, int x, int y){
  g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE-1, TILE_SIZE-1);
 }
 private void paintPipes(Graphics g){
  g.setColor(Color.GREEN);
  if(pipesCoords == null) return; 
  for(int i=0;i<pipesCoords.length;i++){
   int pipeGapY1 = pipesCoords[i].getY();
   int pipeX = pipesCoords[i].getX();
   for(int j=0;j<pipeGapY1;j++){
    paintCell(g, pipeX, j);
   }
   for(int j=pipeGapY1+1;j<canvasHeight;j++){
    paintCell(g, pipeX, j);
   }
  }
 }
 private void paintBird(Graphics g){
  g.setColor(Color.YELLOW);
  paintCell(g, birdX, birdY);
 }
 
}
