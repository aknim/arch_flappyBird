public class GameComposite{
 private Controller c;
 public GameComposite(GameConfig config){
  Bird bird = new Bird(config.canvasHeight/2);
  PipeManager pipeManager = new PipeManager(config);
  InputListener input = new InputListener();
  Display display = new Display(config, input);
  GameClock gameClock = new GameClock(config);
  RuleBook ruleBook = new RuleBook(config);
  c = new Controller(config, input, display, bird, pipeManager, gameClock, ruleBook);
 }
 public void start(){
  c.start(); 
 }
}
