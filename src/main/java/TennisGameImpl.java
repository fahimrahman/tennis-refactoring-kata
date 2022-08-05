
public class TennisGameImpl implements ITennisGameInterface {


    private Player player1 = new Player();
    private Player player2 = new Player();

    public TennisGameImpl(String player1Name, String player2Name) {
        player1.setName(player1Name);
        player2.setName(player2Name);
    }

    public void wonPoint(String playerName) {
        if ( player1.getName().equals(playerName) ){
            int score = player1.getScore();
            player1.setScore(score + 1);
        } else {
            int score = player2.getScore();
            player2.setScore(score + 1);
        }

    }

    public String getScore() {

        String score = "";

        final String scoreStrings[] = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        int score1 = player1.getScore();
        int score2 = player2.getScore();

        if (score1 == score2 ){
            score = ( score1 < 3) ? scoreStrings[score1] + "-All" : "Deuce";
        }
        else if (score1 > 3 || score2 > 3){
            int scoreDiff = score1-score2;

            if (Math.abs(scoreDiff) == 1)
                score = (scoreDiff > 0) ? "Advantage player1" : "Advantage player2";
            else if (Math.abs(scoreDiff) > 1)
                score = (scoreDiff > 0) ? "Win for player1" : "Win for player2";

        } else { //normal
            score = scoreStrings[score1] + "-" + scoreStrings[score2];
        }

        return score;

    }

}
