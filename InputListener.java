import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class InputListener implements KeyListener{
 private String readUserIn;
 public InputListener(){ readUserIn = null;}
 public String giveUserIn(){String ret = readUserIn; readUserIn = null; return ret;}
 @Override
 public void keyPressed(KeyEvent e){
  switch(e.getKeyCode()){
   case KeyEvent.VK_SPACE-> readUserIn = "space";
  }
 }

 @Override public void keyTyped(KeyEvent e){}
 @Override public void keyReleased(KeyEvent e){}
}
