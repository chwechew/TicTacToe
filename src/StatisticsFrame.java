import java.awt.*;
import javax.swing.*;

public class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        setTitle("My Statistics");
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        add(new JLabel("Username: " + player.getUsername(), SwingConstants.CENTER));
        add(new JLabel("Wins: " + player.getWins(), SwingConstants.CENTER));
        add(new JLabel("Losses: " + player.getLosses(), SwingConstants.CENTER));
        add(new JLabel("Draws: " + player.getDraws(), SwingConstants.CENTER));
        add(new JLabel("Total Score: " + player.getScore(), SwingConstants.CENTER));
    }
}