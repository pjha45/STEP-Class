import java.util.Scanner;

class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}

public class CourseCreditManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code1 = sc.next();
        sc.nextLine();
        String title1 = sc.nextLine();
        int credits1 = sc.nextInt();

        String code2 = sc.next();
        sc.nextLine();
        String title2 = sc.nextLine();
        int credits2 = sc.nextInt();
        int labCredits2 = sc.nextInt();

        Course theoryCourse = new Course(code1, title1, credits1);
        Course labCourse = new Course(code2, title2, credits2, labCredits2);

        System.out.println(code1 + " total credits: " + theoryCourse.totalCredits());
        System.out.println(code2 + " total credits: " + labCourse.totalCredits());
    }
}