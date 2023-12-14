package TermProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Window extends JPanel {
    public JButton PlayerCard1;
    public JButton PlayerCard2;
    public JButton PlayerCard3;
    public JButton PlayerCard4;
    public JButton PlayerCard5;
    private JLabel PlayerScore;
    private JButton SkipButton;
    private JLabel NpcCard1;
    private JLabel NpcCard2;
    private JLabel NpcCard3;
    private JLabel NpcCard4;
    private JLabel NpcCard5;
    private JLabel NpcScore;
    private static int CardSelection = 1;
    public static int PScore = 0;
    public static int CScore = 0;
    public boolean PopupShown = false;
    private ScoreCheck ScoreCheck; 

private void Disable() {
    PlayerCard1.setEnabled(false);
    PlayerCard2.setEnabled(false);
    PlayerCard3.setEnabled(false);
    PlayerCard4.setEnabled(false);
    PlayerCard5.setEnabled(false);
    SkipButton.setEnabled(false);
}
private void handleCardAction(JButton playerCard, JLabel npcCard) {
    Card PCard = new Card();
    Card CCard = new Card();
    ImageIcon PCardIcon = new ImageIcon(PCard.GetCardImage());
    ImageIcon CCardIcon = new ImageIcon(CCard.GetCardImage());
    playerCard.setIcon(PCardIcon);
    npcCard.setIcon(CCardIcon);
    playerCard.setEnabled(false);
    PScore += PCard.GetCardValue();
    CScore += CCard.GetCardValue();
    NpcScore.setText("Computer Score: " + CScore);
    PlayerScore.setText("Player Score: " + PScore);
    System.out.println("Player score: " + PScore);
    System.out.println("Computer score:" + CScore);
    ScoreCheck = new ScoreCheck(PScore, CScore);
    CheckGameStatus();
}
private void handleSkipAction() {
    Card card = new Card();
    ImageIcon CCardIcon;
    while (CardSelection <= 5 && !isCardEnabled(CardSelection)) {
        CardSelection++;
    }
    if (CardSelection <= 5) {
        switch (CardSelection) {
            case 1:
                PlayerCard1.setEnabled(false);
                CCardIcon = new ImageIcon(card.GetCardImage());
                NpcCard1.setIcon(CCardIcon);
                CScore += card.GetCardValue();
                NpcScore.setText("Computer Score: " + CScore + "");
                CheckGameStatus();
                break;
            case 2:
                PlayerCard2.setEnabled(false);
                CCardIcon = new ImageIcon(card.GetCardImage());
                NpcCard2.setIcon(CCardIcon);
                CScore += card.GetCardValue();
                NpcScore.setText("Computer Score: " + CScore + "");
                CheckGameStatus();
                break;
            case 3:
                PlayerCard3.setEnabled(false);
                CCardIcon = new ImageIcon(card.GetCardImage());
                NpcCard3.setIcon(CCardIcon);
                CScore += card.GetCardValue();
                NpcScore.setText("Computer Score: " + CScore + "");
                CheckGameStatus();
                break;
            case 4:
                PlayerCard4.setEnabled(false);
                CCardIcon = new ImageIcon(card.GetCardImage());
                NpcCard4.setIcon(CCardIcon);
                CScore += card.GetCardValue();
                NpcScore.setText("Computer Score: " + CScore + "");
                CheckGameStatus();
                break;
            case 5:
                PlayerCard5.setEnabled(false);
                CCardIcon = new ImageIcon(card.GetCardImage());
                NpcCard5.setIcon(CCardIcon);
                CScore += card.GetCardValue();
                NpcScore.setText("Computer Score: " + CScore + "");
                CheckGameStatus();
                break;
            default:
                break;
        }
        CardSelection++;
    }
}
private boolean areAllCardsDisabled() {
    return !PlayerCard1.isEnabled() && !PlayerCard2.isEnabled() && !PlayerCard3.isEnabled() && !PlayerCard4.isEnabled() && !PlayerCard5.isEnabled();
}
private void CheckGameStatus() {
        ScoreCheck = new ScoreCheck(PScore, CScore);
        if (PScore > 33 || CScore > 33) {
            if (!PopupShown){ 
                if (PScore>33 && CScore>33){
                    JOptionPane.showMessageDialog(null, "You Draw"); //Which means the house wins
                    PopupShown = true;
                }
                else if (ScoreCheck.CheckPlayerFail()){
                JOptionPane.showMessageDialog(null, "You lose"); //Which means the house wins
                PopupShown = true;
                }
            }
            if (!PopupShown) {
                if (ScoreCheck.CheckComputerFail()){
                    JOptionPane.showMessageDialog(null, "You Win");
                    PopupShown = true;
                }
            }
            Disable();}
        else if (areAllCardsDisabled()) {
            ScoreCheck.CompareScores(PopupShown);
            Disable();
        }
    }      
private boolean isCardEnabled(int cardNumber) {
    switch (cardNumber) {
        case 1:
            return PlayerCard1.isEnabled();
        case 2:
            return PlayerCard2.isEnabled();
        case 3:
            return PlayerCard3.isEnabled();
        case 4:
            return PlayerCard4.isEnabled();
        case 5:
            return PlayerCard5.isEnabled();
        default:
            return false;
    }
}
public Window() { 
    
    //construct components
    PlayerCard1 = new JButton(new ImageIcon("TermProject/Cards/CardBack.jpg"));
    PlayerCard2 = new JButton(new ImageIcon("TermProject/Cards/CardBack.jpg"));
    PlayerCard3 = new JButton(new ImageIcon("TermProject/Cards/CardBack.jpg"));
    PlayerCard4 = new JButton(new ImageIcon("TermProject/Cards/CardBack.jpg"));
    PlayerCard5 = new JButton(new ImageIcon("TermProject/Cards/CardBack.jpg"));
    PlayerScore = new JLabel ("Player Score: ");
    SkipButton = new JButton ("Skip Card");
    NpcCard1 = new JLabel (new ImageIcon("TermProject/Cards/CardBack.jpg"));
    NpcCard2 = new JLabel (new ImageIcon("TermProject/Cards/CardBack.jpg"));
    NpcCard3 = new JLabel (new ImageIcon("TermProject/Cards/CardBack.jpg"));
    NpcCard4 = new JLabel (new ImageIcon("TermProject/Cards/CardBack.jpg"));
    NpcCard5 = new JLabel (new ImageIcon("TermProject/Cards/CardBack.jpg"));
    NpcScore = new JLabel ("Computer Score:");
    setPreferredSize (new Dimension (1053, 685));
    setLayout (null);

    SkipButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleSkipAction();
        }
    });
    PlayerCard1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCardAction(PlayerCard1, NpcCard1);
        }
    });
    PlayerCard2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCardAction(PlayerCard2, NpcCard2);
        }
    });
    PlayerCard3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCardAction(PlayerCard3, NpcCard3);
        }
    });
    PlayerCard4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCardAction(PlayerCard4, NpcCard4);
        }
    });
    PlayerCard5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleCardAction(PlayerCard5, NpcCard5);
        }
    });
//add components
    add (PlayerCard1);
    add (PlayerCard2);
    add (PlayerCard3);
    add (PlayerCard4);
    add (PlayerCard5);
    add (PlayerScore);
    add (SkipButton);
    add (NpcCard1);
    add (NpcCard2);
    add (NpcCard3);
    add (NpcCard4);
    add (NpcCard5);
    add (NpcScore);
//set component bounds (only needed by Absolute Positioning)
    PlayerCard1.setBounds (50, 385, 125, 175);
    PlayerCard2.setBounds (250, 385, 125, 175);
    PlayerCard3.setBounds (450, 385, 125, 175);
    PlayerCard4.setBounds (650, 385, 125, 175);
    PlayerCard5.setBounds (850, 385, 125, 175);
    PlayerScore.setBounds (870, 590, 120, 30);
    SkipButton.setBounds (465, 595, 110, 35);
    NpcCard1.setBounds (50, 80, 125, 175);
    NpcCard2.setBounds (250, 80, 125, 175);
    NpcCard3.setBounds (450, 80, 125, 175);
    NpcCard4.setBounds (650, 80, 125, 175);
    NpcCard5.setBounds (850, 80, 125, 175);
    NpcScore.setBounds (850, 615, 120, 25);
    
}

}
