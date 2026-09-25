import java.util.Random;
import java.util.ArrayList;
public class PipeManager{
 private ArrayList<Pipe> pipes;
 private Random random;
 private int pipeGap, canvasHeight, canvasWidth, pipeProbability;
 public PipeManager(GameConfig config){
  pipes = new ArrayList<Pipe>();
  pipeProbability = config.pipeProbability; 
  pipeGap = config.pipeGap; 
  canvasHeight = config.canvasHeight; 
  canvasWidth = config.canvasWidth; 
  random = new Random();
 }
 public Coord [] getPipesCoords(){
  Coord [] ans = new Coord [pipes.size()];
  for(int i=0;i<pipes.size();i++){
   ans[i] = pipes.get(i).getCoord();
  }
  return ans; 
 } 
 public void movePipes(){
  for(int i=0;i<pipes.size();i++){
   pipes.get(i).move();
  }
 }
 public void checkProbabilityAndAddNewPipe(){
  int probabilityToAdd = random.nextInt(pipeProbability);
  if(probabilityToAdd!=0) return;
  int topLength = random.nextInt(canvasHeight-pipeGap);
  Pipe newPipe = new Pipe(canvasWidth-1, topLength);
  pipes.add(newPipe);
 }
 public void destroyPipe(){
  pipes.remove(0);
 }
}
