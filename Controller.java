public class Controller{
 private GameClock gameClock;
 private Display display;
 private InputListener input;
 private Bird bird;
 private PipeManager pipeManager;
 private RuleBook ruleBook; 
 public Controller(GameConfig config, InputListener input, Display display, Bird bird, PipeManager pipeManager, GameClock gameClock, RuleBook ruleBook){
  this.gameClock = gameClock; this.display = display; this.input = input;  this.bird = bird; this.pipeManager = pipeManager; this.ruleBook = ruleBook;
 }
 public void start(){
  while(true){
   int birdCoord = bird.getCurrY();
   Coord [] pipesCoords = pipeManager.getPipesCoords();
   display.displayCanvas(birdCoord, pipesCoords);
   gameClock.tick();
   String in = input.giveUserIn();
   if(in!=null && in.equals("space")){
    bird.recharge();
   } 
   int birdNewY = bird.computeNextPos();
   if(ruleBook.detectCollision(birdNewY, pipesCoords)){System.out.println("collision"); return;}
   bird.moveNextPos();
   display.displayCanvas(birdNewY, pipesCoords);
   pipeManager.movePipes();
   pipesCoords = pipeManager.getPipesCoords();
   display.displayCanvas(birdNewY, pipesCoords);
   if(ruleBook.detectCollision(birdNewY, pipesCoords)){System.out.println("collision"); return;}
   pipeManager.checkProbabilityAndAddNewPipe();
  }
 }
}
