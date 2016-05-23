import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class Border {
  private Track track;
  private Rectangle[] ary = {
    new Rectangle (125,200,800,500),
    new Rectangle (25,800,1025,1),
    new Rectangle (24,100,1,700),
    new Rectangle (25,100,1025,1),
    new Rectangle (1050,100,1,700)};

  public Border(Track track) {
    this.track = track;
  }

  public void paint(Graphics2D g2d) {
  g2d.setColor(Color.black);
  g2d.drawRect(125,200,800,500);
  g2d.fillRect(25,800,1025,1);
  g2d.fillRect(24,100,1,700);
  g2d.fillRect(25,100,1025,1);
  g2d.fillRect(1050,100,1,700);
  }

  public Rectangle[] getBounds() {
    return ary;
  }

}
