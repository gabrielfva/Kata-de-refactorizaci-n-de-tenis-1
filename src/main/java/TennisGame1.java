
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

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.getPlayer1Name())) {
            this.player1Score++;
        } else if (playerName.equals(this.getPlayer2Name())) {
            this.player2Score++;
        }
    }

    public String getScore() {
        String score = "";

        if (this.getPlayer1Score() == this.getPlayer2Score()) {
            score = this.setTie(this.getPlayer1Score());
        } else if ((this.getPlayer1Score() >= 4) || (this.getPlayer2Score() >= 4)) {
            score = setDifferenceScores();
        } else {
            score = this.setTemporalScore(score);
        }
        return score;
    }

    private String setTie(int player1Score) {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }

    }

    private String setDifferenceScores () {
        int differenceScores = player1Score - player2Score;

        if (differenceScores == 1) {
            return "Advantage player1";
        } else if (differenceScores == -1) {
            return "Advantage player2";
        } else if (differenceScores >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String setTemporalScore(String score) {
        int tempScore;

        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = this.getPlayer1Score();
            } else {
                score = score.concat("-");
                tempScore = this.getPlayer2Score();
            }

            switch (tempScore) {
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
        return score;
    }
}
