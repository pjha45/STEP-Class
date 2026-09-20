import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRanking {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed) ||
                Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count] = player;
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i]);

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int matchesPlayed = sc.nextInt();
            double battingAverage = sc.nextDouble();
            boolean injured = sc.nextBoolean();

            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }

        System.out.println(draftAndRank(players));
    }
}