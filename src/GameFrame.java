import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.buttons = new JButton[9];

        setTitle("Tic-Tac-Toe - " + player.getUsername());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusPainted(false);
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            add(buttons[i]);
        }
    }

    private void handlePlayerMove(int index) {
        if (!gameLogic.makeMove(index, 'X')) return;
        buttons[index].setText("X");

        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }
        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        int compIndex = gameLogic.computerMove();
        if (compIndex != -1) {
            buttons[compIndex].setText("O");
            if (gameLogic.checkWinner('O')) {
                finishGame("LOSE");
                return;
            }
            if (gameLogic.isDraw()) {
                finishGame("DRAW");
            }
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        
        currentPlayer = playerService.login(currentPlayer.getUsername(), "12345");

        JOptionPane.showMessageDialog(this, "Game result: " + result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}