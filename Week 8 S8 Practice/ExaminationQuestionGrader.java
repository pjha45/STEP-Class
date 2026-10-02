import java.util.*;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();

    abstract String getType();
}

class MCQ extends Question {
    MCQ(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    TF(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int count = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String[] lastPart = parts[6].trim().split(" ");
            double points = Double.parseDouble(lastPart[lastPart.length - 1]);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                question = new TF(questionText, correctAnswer, studentAnswer, points);
            } else {
                question = new Essay(questionText, correctAnswer, studentAnswer, points);
            }

            double score = question.evaluate();

            System.out.printf("%s: %.2f%n", question.getType(), score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}