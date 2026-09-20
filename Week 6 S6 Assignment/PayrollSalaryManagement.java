import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative basic salary rejected. Salary set to 0.");
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percentage must be between 0 and 100");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollSalaryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double basicSalary = sc.nextDouble();
        double bonus = sc.nextDouble();
        double taxPercent = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(basicSalary);

        account.creditBonus(bonus);
        account.deductTax(taxPercent);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}