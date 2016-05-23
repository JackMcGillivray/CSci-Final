import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Track extends JPanel{

  FinishLine finishLine = new FinishLine(this);
  Border border = new Border(this);
  Car car = new Car(this, border);
  Throttle throttle = new Throttle(car, this);
  LapTime time = new LapTime(this, car, finishLine);

  public Track() {
    addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				car.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				car.keyPressed(e);
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
    throttle.paint(g, g2d);
    g.drawString("Return = Faster, Shift = Slower, Steer with arrow keys",
                    300, 900);
  }

  private void move() {
    car.move();
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
