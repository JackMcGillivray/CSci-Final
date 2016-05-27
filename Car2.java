import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
public class Car2 {

private BufferedImage carPicture;
private Border border;
private Track track;
private int x;
private int y;
private int xm;
private int ym;
private int throttle;
private final int picSides = 50;
private Rectangle[] ary = {
  new Rectangle (125,200,800,500),
  new Rectangle (25,800,1025,1),
  new Rectangle (24,100,1,700),
  new Rectangle (25,100,1025,1),
  new Rectangle (1050,100,1,700)};


  public Car2(Track track, Border boarder) {
    try {
      carPicture = ImageIO.read(new File("images/car.png"));
    } catch (IOException e) {}
    throttle = 1;
    this.track = track;
    this.border = border;
    x = 150;
    y = 725;
  }

  public void move() {
    if (collision()) {
      x = 150;
      y = 725;
    }
    x = x + (xm * throttle);
    y = y + (ym * throttle);
  }

  public void paint(Graphics2D g) {
    g.drawImage(carPicture,x,y,null);
  }

  public boolean collision() {
    for (Rectangle rectangle :ary ){
      if (this.getBounds().intersects(rectangle)) {
        return true;
      }
    }
    return false;
  }

  public Rectangle getBounds() {
    return new Rectangle(x, y, picSides, picSides);
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_A)
			xm = 0;
		if (e.getKeyCode() == KeyEvent.VK_D)
			xm = 0;
    if (e.getKeyCode() == KeyEvent.VK_W)
  		ym = 0;
  	if (e.getKeyCode() == KeyEvent.VK_S)
  		ym = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			xm = -1;
		if (e.getKeyCode() == KeyEvent.VK_D)
			xm = 1;
    if (e.getKeyCode() == KeyEvent.VK_W)
  		ym = -1;
  	if (e.getKeyCode() == KeyEvent.VK_S)
  		ym = 1;
    if (e.getKeyCode() == KeyEvent.VK_R) {
      if (throttle < 5) {
        throttle++;
      }
    }
  	if (e.getKeyCode() == KeyEvent.VK_F) {
      if (throttle > 1) {
        throttle--;
      }
    }
  }

  public int getThrottle() {
    return throttle;
  }
}
