public class Bird{
 private int currY, upBattery, computedY;
 public Bird(int currY){this.currY = currY; computedY = -1; upBattery = 0;}
 public int getCurrY(){return currY;}
 public void recharge(){
  upBattery = 2;
 }
 public int computeNextPos(){
  int move = (upBattery>0)?1:-1;
  computedY = currY + move;
  if (upBattery>0) upBattery--;
  return computedY; 
 }

 public void moveNextPos(){currY = computedY; computedY = -1;}
 
}
