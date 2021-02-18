
public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            this.player1Score ++;
        else
            this.player2Score ++;
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (this.player1Score == this.player2Score) {
            switch (this.player1Score) {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
            }
        }
        else if (this.player1Score >= 4 || this.player2Score >= 4){
            int minusResult = this.player1Score - this.player2Score;
            if (minusResult == 1)
                score = "Advantage player1";
            else
                if (minusResult == -1)
                    score = "Advantage player2";
            else
                if (minusResult >=2 )
                    score = "Win for player1";
            else
                score = "Win for player2";
        }
        else {
            for (int i = 1; i < 3; i ++) {
                if (i == 1) tempScore = this.player1Score;
                else {
                    score = score.concat("-");
                    tempScore = this.player2Score;
                }
                switch(tempScore) {
                    case 0:
                        score = score.concat("Love");
                        break;
                    case 1:
                        score = score.concat("Fifteen");
                        break;
                    case 2:
                        score = score.concat("Thirty");
                        break;
                    default:
                        score = score.concat("Forty");
                        break;
                }
            }
        }
        return score;
    }
}
