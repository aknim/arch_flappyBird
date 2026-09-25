public final class Coord{
 private int x, y;
 public Coord(int x, int y){this.x = x; this.y = y;}
 public Coord(Coord other){this.x = other.getX(); this.y = other.getY();}
 public int getX(){return x;}
 public int getY(){return y;}
 public boolean equals(Coord other){return other.getX()==x && other.getY()==y;}
}
