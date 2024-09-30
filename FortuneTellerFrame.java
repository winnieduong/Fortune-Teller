import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{
    private JLabel titleLabel;
    private JTextArea fortuneDisplay;
    private JScrollPane scrollPane;
    private JButton readFortuneButton, quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3/4, screenSize.height * 3/4);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        titleLabel = new JLabel("Fortune Teller", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        ImageIcon icon = new ImageIcon("src/icon.jpg");
        titleLabel.setIcon(icon);
        add(titleLabel, BorderLayout.NORTH);

        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneDisplay.setEditable(false);
        scrollPane = new JScrollPane(fortuneDisplay);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        readFortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 24));

        buttonPanel.add(readFortuneButton);
        buttonPanel.add(quitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        readFortuneButton.addActionListener(e -> displayRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));

        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you around the corner.");
        fortunes.add("Good luck will be with you all week long.");
        fortunes.add("You will achieve great things.");
        fortunes.add("A promotion is on the horizon.");
        fortunes.add("Your patience will be rewarded soon.");
        fortunes.add("Expect the unexpected!");
        fortunes.add("You will find what you’ve been searching for.");
        fortunes.add("Happiness is within your reach.");
        fortunes.add("Something good will happen today.");
        fortunes.add("An exciting opportunity is coming your way.");
        fortunes.add("Your hard work will soon pay off.");

        setVisible(true);
    }
    private void displayRandomFortune() {
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        fortuneDisplay.append(fortunes.get(index) + "\n");
    }
}