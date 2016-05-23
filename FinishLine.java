import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

public class FinishLine {
  private BufferedImage finishPicture;
  private Track track;
  private int x;
  private int y;

  public FinishLine(Track track) {
    try {
      finishPicture = ImageIO.read(new File("images/Finish.png"));
    } catch (IOException e) {}
    this.track = track;
    x = 400;
    y = 700;
  }

  public void paint(Graphics2D g) {
    g.drawImage(finishPicture,x,y,null);
  }

  public Rectangle getBounds() {
    return new Rectangle(x, y, 100, 100);
  }
}
