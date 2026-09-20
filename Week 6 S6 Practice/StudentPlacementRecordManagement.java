import java.util.Scanner;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class StudentPlacementRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < 3; i++) {
            String studentName = sc.next();
            sc.nextLine();

            String company = sc.next();
            double packageLpa = sc.nextDouble();

            records[i] = new PlacementRecord(studentName, company, packageLpa);
        }

        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}