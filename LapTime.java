import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
public class LapTime {

  private Track track;
  private Car car;
  private Car2 car2;
  private FinishLine finishLine;
  private long startTime;
  private double currentTime;
  private final Font smallFont = new Font ("Times New Roman", 1, 12);
  private final Font bigFont = new Font ("Times New Roman", 1, 18);

  public LapTime(Track track, Car car, Car2 car2, FinishLine finishLine) {
    this.track = track;
    this.car = car;
    this.finishLine = finishLine;
    this.car2 = car2;
  }

  public void paint(Graphics g, Graphics2D g2d) {
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON);
    g.setFont(smallFont);
    g.drawString("Time:", 500, 15);
    g.setFont(bigFont);
    if (collision() == 1 && getCurrentTime() > 4) {
      JOptionPane.showMessageDialog(null,
                  "Player 1 Wins!!!");
      track.seeYa();
    }
    if (collision() == 2 && getCurrentTime() > 4) {
      JOptionPane.showMessageDialog(null,
                  "Player 2 Wins!!! ");
      track.seeYa();
    }
    if (this.collision()!= 0)
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

  private int collision() {
    if (car.getBounds().intersects(finishLine.getBounds()))
      return 1;
    if (car2.getBounds().intersects(finishLine.getBounds()))
      return 2;
    return 0;
  }


}
