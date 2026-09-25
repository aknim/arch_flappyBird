public class Main{
 public static void main(String [] args){
  GameConfig config = new GameConfig(30, 30, 2, 3, 1, 5, "Flappy Bird", 200, 4);
  GameComposite gc = new GameComposite(config);
  /*
    We didn't have the GameComposite create the gameConfig. That would have created tight coupling. We created gameConfig 1st. Then simply passed that to the gameComposite. 
  */
  gc.start(); 
 }
}
