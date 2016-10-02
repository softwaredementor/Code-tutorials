package concepts.generics;


/**
 * Created by srikanthmannepalle on 10/1/16.
 */
public class SportsTeam<T> implements Comparable<SportsTeam<T>> {

    private String teamName;
    private int wins;
    private int losses;
    private int ties;
    private int totalMatches;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void matchResult(SportsTeam<T> opponent, int scoreAgainst, int scoreFor) {
        if (scoreAgainst > scoreFor) {
            System.out.println(this.teamName + " defeated " + opponent.getTeamName());
            wins++;
        } else if (scoreAgainst == scoreFor) {
            ties++;
        } else {
            losses++;
        }
        if (null != opponent) {
            opponent.matchResult(null, scoreFor, scoreAgainst);
        }
        totalMatches++;
    }

    @Override
    public int compareTo(SportsTeam<T> team2) {
        if (this.wins > team2.wins) {
             return -1;
        } else if (this.wins == team2.wins) {
            return 0;
        } else {
            return 1;
        }
    }
}
