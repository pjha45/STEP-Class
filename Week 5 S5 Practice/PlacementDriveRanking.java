import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveRanking {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && cgpa < 7.5 && codingScore >= 60;
        }

        private double getCompositeScore() {
            return cgpa * 10 + codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }

        @Override
        public String toString() {
            return name + " (" + getCompositeScore() + ")";
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

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
        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double cgpa = sc.nextDouble();
            int codingScore = sc.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));
    }
}