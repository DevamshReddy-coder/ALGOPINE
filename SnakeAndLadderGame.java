import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SnakeAndLadderGame extends JFrame 
{
    private static final int BOARD_SIZE = 10;
    private static final int WINNING_POSITION = BOARD_SIZE * BOARD_SIZE;
    private static final int[] LADDERS_START = {2, 7, 22, 28, 40, 70, 79};
    private static final int[] LADDERS_END = {18, 14, 30, 84, 59, 92, 81};
    private static final int[] SNAKES_START = {12, 24, 35, 47, 56, 73, 87};
    private static final int[] SNAKES_END = {2, 8, 20, 26, 33, 50, 70};
    private Map<Integer, Integer> ladderMap;
    private Map<Integer, Integer> snakeMap;
    private int currentPlayerPosition;
    private int currentPlayerIndex;
    private int[] players;
    private JLabel[] playerLabels;
    private JButton rollButton;
    public SnakeAndLadderGame(int numPlayers)
     {
        ladderMap = new HashMap<>();
        snakeMap = new HashMap<>();
        for (int i = 0; i < LADDERS_START.length; i++)
         {
            ladderMap.put(LADDERS_START[i], LADDERS_END[i]);
        }
        for (int i = 0; i < SNAKES_START.length; i++) 
        {
            snakeMap.put(SNAKES_START[i], SNAKES_END[i]);
        }
        currentPlayerIndex = 0;
        currentPlayerPosition = 0;
        players = new int[numPlayers];
        setTitle("Snake and Ladder Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        playerLabels = new JLabel[numPlayers];
        for (int i = 0; i < numPlayers; i++) 
        {
            playerLabels[i] = new JLabel("Player " + (i + 1) + " at position 0");
            add(playerLabels[i]);
        }
        rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                int steps = rollDice();
                movePlayer(steps);
                updatePlayerLabels();
                if (currentPlayerPosition == WINNING_POSITION)
                 {
                    JOptionPane.showMessageDialog(null, "Player " + (currentPlayerIndex + 1) + " wins!");
                    rollButton.setEnabled(false);
                }
                nextTurn();
            }
        });
        add(rollButton);
        setVisible(true);
    }
    private int rollDice() 
    {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    private void nextTurn()
     {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
    private void movePlayer(int steps)
     {
        int newPosition = currentPlayerPosition + steps;
        if (newPosition > WINNING_POSITION)
         {
            return;
        }
        currentPlayerPosition = newPosition;
        if (ladderMap.containsKey(currentPlayerPosition)) 
        {
            currentPlayerPosition = ladderMap.get(currentPlayerPosition);
        } 
        else if (snakeMap.containsKey(currentPlayerPosition))
         {
            currentPlayerPosition = snakeMap.get(currentPlayerPosition);
        }
    }
    private void updatePlayerLabels() 
    {
        for (int i = 0; i < players.length; i++)
         {
            playerLabels[i].setText("Player " + (i + 1) + " at position " + currentPlayerPosition);
        }
    }
    public static void main(String[] args) 
    {
        int numPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of players:"));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {
                new SnakeAndLadderGame(numPlayers);
            }
        });
    }
}
