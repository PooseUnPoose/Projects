package TermProject;
import javax.swing.JOptionPane;

public class ScoreCheck {
    private int PScore;
    private int CScore;
    private boolean popupShown;

    public ScoreCheck(int PScore, int CScore) {
        this.PScore = PScore;
        this.CScore = CScore;
        this.popupShown = false;
    }

    public boolean CheckPlayerFail() {
        return PScore > 33;
    }

    public boolean CheckComputerFail() {
        return CScore > 33;
    }

    public void CompareScores(boolean PopupShown) {
        this.popupShown = PopupShown;
        if (PScore == CScore) {
            if (!popupShown) {
                JOptionPane.showMessageDialog(null, "You Draw");
                popupShown = true;
            }
        } else if (PScore>33 && CScore>33) {
            if (!popupShown) {
                JOptionPane.showMessageDialog(null, "You Draw");
                popupShown = true;
            }
        } else if (PScore > CScore) {
            if (!popupShown) {
                JOptionPane.showMessageDialog(null, "You Win");
                popupShown = true;
            }
        } else if (CScore > PScore) {
            if (!popupShown) {
                JOptionPane.showMessageDialog(null, "You Lose");
                popupShown = true;
            } else {
                if (!popupShown) {
                    JOptionPane.showMessageDialog(null, "Neither player wins");
                    popupShown = true;
                }
            }
        }
    }
}
