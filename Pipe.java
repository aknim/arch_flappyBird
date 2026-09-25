public class Pipe{
 private int x, topLength;
 public Pipe(int x, int topLength){
  this.x = x; this.topLength = topLength; 
 }
 public Coord getCoord(){return new Coord(x, topLength);}
 public void move(){
  x = x - 1;
 } 
}
