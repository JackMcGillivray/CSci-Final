import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class Throttle {
  private Car car;
  private Track track;
  private final Font smallFont = new Font ("Times New Roman", 1, 12);
  private final Font bigFont = new Font ("Times New Roman", 1, 18);

  public Throttle(Car car, Track track) {
    this.track = track;
    this.car = car;
  }

  public void paint(Graphics g, Graphics2D g2d) {
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
    g.setFont(smallFont);
    g.drawString("Throttle", 740, 15);
    g.setFont(bigFont);
    g.drawString((car.getThrottle()*20) + " %",740, 35);
  }
}
