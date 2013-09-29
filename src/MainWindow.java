import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import java.util.List;

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

    private JTextField titleField = null;
    private Font titleFont = new Font("Microsoft YaHei", Font.PLAIN, 30);

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
    private List<Material> materials = new ArrayList<Material>();

    public MainWindow(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Protokoll");

        mainPanel = new JPanel(new BorderLayout());
        titleField = new JTextField("Titel");
        titleField.setFont(titleFont);
        titleField.setBorder(BorderFactory.createCompoundBorder(titleField.getBorder(), new EmptyBorder(5,5,5,5)));
        titleField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (titleField.getText().equals("Titel")) {
                    titleField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(titleField.getText().equals("")){
                    titleField.setText("Titel");
                }
            }
        });
        mainPanel.add(titleField, BorderLayout.NORTH);

        inputPanel = new JPanel(new GridLayout(6, 1, 10, 20));
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

        //Materialien
        inputPane[0] = new JPanel(new BorderLayout(5, 0));
        paneLabel[0] = new JLabel(paneTitle[0]);
        paneLabel[0].setBorder(new EmptyBorder(10, 0, 5, 0));
        inputPane[0].add(paneLabel[0], BorderLayout.NORTH);

        final JPanel materialPanel = new JPanel();
        materialPanel.setLayout(new BoxLayout(materialPanel, BoxLayout.Y_AXIS));
        //TODO add method for adding materials
        JButton addMat = new JButton("Material hinzufügen");
        addMat.addActionListener(new ActionListener() {
            Random r = new Random();
            public void actionPerformed(ActionEvent e) {
                materials.add(new Material(r.nextInt(100) + 1, "Chemiekalie",
                        new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255))));
                materialPanel.validate();
                materialPanel.repaint();
            }
        });
        for (Material m: materials){
            materialPanel.add(new JLabel(m.getVolume() + " " + m.getName()));
        }
        materialPanel.add(addMat);
        inputPane[0].add(materialPanel);
        inputPanel.add(inputPane[0]);

        for (int i = 1; i < 6; i++) {
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
    }


}
