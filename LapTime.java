import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class LapTime {

  private Track track;
  private Car car;
  private FinishLine finishLine;
  private long startTime;
  private double currentTime;
  private final Font smallFont = new Font ("Times New Roman", 1, 12);
  private final Font bigFont = new Font ("Times New Roman", 1, 18);

  public LapTime(Track track, Car car, FinishLine finishLine) {
    this.track = track;
    this.car = car;
    this.finishLine = finishLine;
  }

  public void paint(Graphics g, Graphics2D g2d) {
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
    g.setFont(smallFont);
    g.drawString("Time:", 500, 15);
    g.setFont(bigFont);
    if (collision() && getCurrentTime() > 4) {
      JOptionPane.showMessageDialog(null,
                  "Your time was: "+Double.toString(currentTime));
      track.seeYa();
    }
    if (this.collision())
      setStartTime();
    if (car.collision())
      startTime = 0;
    if (this.isLaping())
      g.drawString(Double.toString(getCurrentTime()),500,35);

  }

  private double getCurrentTime() {
    if (startTime == 0)
      return 0.0;
    currentTime=(double) (Math.abs(startTime - System.currentTimeMillis()))/1000;
    return currentTime;
  }

  private boolean isLaping() {
    return (startTime > 0);
  }

  private void setStartTime() {
    startTime = System.currentTimeMillis();
  }

  private boolean collision() {
    return car.getBounds().intersects(finishLine.getBounds());
  }


}
