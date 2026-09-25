import java.lang.InterruptedException;
public class GameClock{
 private int tickInterval;
 private int countTicks;
 private int currTime;
 private GameClock gmClock; 
 public GameClock(GameConfig config){this.tickInterval = config.tickInterval;}
 public void start(){currTime = 0; countTicks = 0;}
 public void tick(){
  countTicks++;
  try{Thread.sleep(tickInterval);}
  catch (InterruptedException e){ Thread.currentThread().interrupt(); return;}
  currTime = (countTicks * tickInterval) / 1000;
 }
 public int getTime(){return currTime;}
}
