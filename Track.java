import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Track extends JPanel{

  FinishLine finishLine = new FinishLine(this);
  Border border = new Border(this);
  Car car = new Car(this, border);
  Car2 car2 = new Car2(this, border);
  Throttle throttle = new Throttle(car, this, car2);
  LapTime time = new LapTime(this, car, car2, finishLine);

  public Track() {
    addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				car.keyReleased(e);
        car2.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				car.keyPressed(e);
        car2.keyPressed(e);
			}
		});
		setFocusable(true);
  }

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paint(g);
    time.paint(g,g2d);
    border.paint(g2d);
    finishLine.paint(g2d);
    car.paint(g2d);
    car2.paint(g2d);
    throttle.paint(g, g2d);
    g.drawString("Player 1: Return = Faster, Shift = Slower, Steer with arrow keys",
                    300, 900);
    g.drawString("Player 2: R = Faster, F = Slower, Steer with WASD",
                    300, 940);
  }

  private void move() {
    car.move();
    car2.move();
  }

  public void seeYa()  {
    System.exit(0);
  }

  public static void main(String[] args) throws InterruptedException{
    JFrame frame = new JFrame("Race");
    Track track = new Track();
    frame.add(track);
    frame.setSize(1200,1000);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    while (true) {
      track.move();
      track.repaint();
      Thread.sleep(20);
    }
  }
}
