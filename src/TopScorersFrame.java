import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();
        setTitle("Top 5 Scorers");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        ArrayList<Player> topPlayers = playerService.getTopFives();
        for (Player p : topPlayers) {
            Object[] row = {p.getUsername(), p.getWins(), p.getLosses(), p.getDraws(), p.getScore()};
            model.addRow(row);
        }

        table = new JTable(model);
        table.setEnabled(false);
        add(new JScrollPane(table));
    }
}