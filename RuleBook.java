public class RuleBook{
 private int birdX;
 public RuleBook(GameConfig config){
  this.birdX = config.canvasWidth/2;
 }
 public Boolean detectCollision(int birdY, Coord [] pipesXY){
  return false; 
 }
}
