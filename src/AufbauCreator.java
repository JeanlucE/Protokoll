import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/26/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class AufbauCreator extends JFrame {
    DrawingPanel dp = new DrawingPanel();
    public AufbauCreator(){
        this.setSize(800, 550);
        this.setLayout(new GridLayout(1,1));
        this.add(dp);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class DrawingPanel extends JPanel{

        public DrawingPanel(){
            this.setSize(800, 550);
        }

        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            g2d.drawString("Hello", 10, 10);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(0, 0, 200, 200);
            g2d.setColor(Color.pink);
            g2d.drawOval(200, 200, 20, 30);
            try {
                BufferedImage in = ImageIO.read(new File("E:\\Pictures\\temp\\manulein.jpg"));
                g2d.drawImage(in, 10, 10, null);
            } catch (IOException e) {
                System.out.println("bla");
            }


        }
    }
}
