package concepts.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by srikanthmannepalle on 10/1/16.
 */
public class LeagueTable<T extends SportsTeam> {
    private String leagueName;
    private List<T> teamsList = new ArrayList<>();

    public LeagueTable(String leagueName) {
        this.leagueName = leagueName;
    }

    public static void main(String[] args) {

        LeagueTable<SportsTeam<Football>> footballLeague = new LeagueTable<>("Futbal mundial");
        SportsTeam<Football> team1 = new SportsTeam<>("Argentina");
        SportsTeam<Football> team2 = new SportsTeam<>("Brazil");
        SportsTeam<Football> team3 = new SportsTeam<>("Germany");
        SportsTeam<Football> team4 = new SportsTeam<>("France");
        SportsTeam<Football> team5 = new SportsTeam<>("Italy");
        SportsTeam<Football> team6 = new SportsTeam<>("Spain");
        SportsTeam<Football> team7 = new SportsTeam<>("Portugal");
        SportsTeam<Cricket>  team8 = new SportsTeam<>("India");

        footballLeague.add(team1);
        footballLeague.add(team2);
        footballLeague.add(team3);
        footballLeague.add(team4);
        footballLeague.add(team5);
        footballLeague.add(team6);
        footballLeague.add(team7);
        //footballLeague.teamsList.add(team8);

        team1.matchResult(team2, 3, 2);
        team1.matchResult(team7, 3, 2);
        team2.matchResult(team4, 3, 2);
        team3.matchResult(team4, 3, 2);
        team4.matchResult(team3, 3, 2);
        team5.matchResult(team6, 3, 2);
        team2.matchResult(team6, 3, 2);
        team7.matchResult(team6, 3, 2);

        Collections.sort(footballLeague.teamsList);
        System.out.println("\nTeams ranking");

        for (int i = 0; i < footballLeague.teamsList.size(); i++) {
            System.out.println(footballLeague.teamsList.get(i).getTeamName() + " " + (i + 1));
        }

        LeagueTable<SportsTeam> rawLeague = new LeagueTable<>("Raw League");
        rawLeague.add(team1);
    }

    public List<T> getTeamsList() {
        return teamsList;
    }

    public void add(T team) {
        if (!this.teamsList.contains(team)) {
            this.teamsList.add(team);
            System.out.println(team.getTeamName() + " is added");
        }
    }

}
