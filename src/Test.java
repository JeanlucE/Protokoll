import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/26/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test extends JPanel {

    private JScrollPane vertical;
    private JTextArea console;

    public static void main(String[] args) {
        new JFrame() {{
            getContentPane().add(new Test());
            pack();
            setVisible(true);
        }};
    }


    public Test() {
        setPreferredSize(new Dimension(200, 250));
        console = new JTextArea(15, 15);

        vertical = new JScrollPane(console);
        vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(vertical);
    }
}
