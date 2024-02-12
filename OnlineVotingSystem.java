import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class OnlineVotingSystem extends JFrame 
{
    private Map<String, Integer> partyVotes;

    public OnlineVotingSystem()
     {
        partyVotes = new HashMap<>();
        addParties();
        initComponents();
    }

    private void addParties()
     {
        partyVotes.put("BRS", 0);
        partyVotes.put("Congress", 0);
        partyVotes.put("BJP", 0);
        partyVotes.put("NOTA", 0);
    }

    private void initComponents()
     {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Online Voting System");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);

        JButton voteButton = new JButton("Vote");
        voteButton.addActionListener(new ActionListener() 
        {
            
            public void actionPerformed(ActionEvent e)
             {
                String partyName = (String) JOptionPane.showInputDialog(
                        OnlineVotingSystem.this,
                        "Choose a party to vote for:",
                        "Vote",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        partyVotes.keySet().toArray(),
                        null);

                if (partyName != null)
                 {
                    voteForParty(partyName);
                    JOptionPane.showMessageDialog(OnlineVotingSystem.this,
                            "Your vote has been recorded for party " + partyName,
                            "Vote Recorded",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        panel.add(voteButton, constraints);

        JButton viewResultsButton = new JButton("View Results");
        viewResultsButton.addActionListener(new ActionListener()
         {
        
            public void actionPerformed(ActionEvent e) {
                displayResults();
            }
        });
        constraints.gridy++;
        panel.add(viewResultsButton, constraints);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() 
        {
            
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        constraints.gridy++;
        panel.add(exitButton, constraints);

        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void voteForParty(String partyName)
     {
        if (partyVotes.containsKey(partyName)) 
        {
            partyVotes.put(partyName, partyVotes.get(partyName) + 1);
        } else 
        {
            JOptionPane.showMessageDialog(this,
                    "Invalid party name",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayResults()
     {
        StringBuilder results = new StringBuilder("Voting Results:\n");
        for (Map.Entry<String, Integer> entry : partyVotes.entrySet()) 
        {
            results.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votes\n");
        }
        JOptionPane.showMessageDialog(this,
                results.toString(),
                "Results",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args)
     {
        SwingUtilities.invokeLater(new Runnable() 
        {

            public void run() 
            {
                new OnlineVotingSystem().setVisible(true);
            }
        });
    }
}
