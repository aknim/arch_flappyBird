public class GameConfig{
 final int canvasHeight, canvasWidth, birdDownSpeed, birdUpSpeed, pipeSpeed, pipeGap, tickInterval, pipeProbability;
 final String gameName;
 public GameConfig(int cH, int cW, int bDS, int bUS, int pS, int pG, String gameName, int tickInterval, int pipeProbability){ this.canvasHeight = cH; this.canvasWidth = cW; this.birdDownSpeed = bDS; this.birdUpSpeed = bUS; this.pipeSpeed = pS; this.pipeGap = pG; this.gameName = gameName; this.tickInterval = tickInterval; this.pipeProbability = pipeProbability;}
}
