import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/26/13
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow extends JFrame{

    private JScrollPane scrollPane = null;
    private JPanel mainPanel = null;

    private JPanel titlePanel = null;
    //private JLabel title = null;
    private JTextField titleField = null;

    private JPanel inputPanel = null;
    private JPanel[] inputPane = new JPanel[6];
    private JLabel[] paneLabel = new JLabel[6];
    private JTextArea[] textPane = new JTextArea[6];
    private String[] paneTitle =
            {
            "Materialien",
            "Vorbereitung",
            "Aufbau",
            "Durchführung",
            "Beobachtung",
            "Erklärung"
            };

    public MainWindow(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        mainPanel = new JPanel(new BorderLayout());
        titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleField = new JTextField("Titel", 30);
        titlePanel.add(titleField);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        inputPanel = new JPanel(new GridLayout(6, 1, 10, 20));
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        for (int i = 0; i < 6; i++) {
            inputPane[i] = new JPanel(new BorderLayout(5, 0));
            paneLabel[i] = new JLabel(paneTitle[i]);
            paneLabel[i].setBorder(new EmptyBorder(0, 0, 5, 0));
            inputPane[i].add(paneLabel[i], BorderLayout.NORTH);
            textPane[i] = new JTextArea(10, 40);
            textPane[i].setPreferredSize(new Dimension(490, 160));
            textPane[i].setBorder(blackBorder);
            inputPane[i].add(textPane[i], BorderLayout.CENTER);
            inputPanel.add(inputPane[i]);
        }
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(new EmptyBorder(0, 6, 0, 20));

        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setPreferredSize(new Dimension(500, 700));
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 0));

        this.setPreferredSize(new Dimension(550, 700));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        pack();
        //System.out.println(this.size());
        //System.out.println(textPane[0].getHeight());
    }
}
