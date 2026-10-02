import java.util.*;

interface PaymentMethod {
    double calculateAmount(double amount);
    String getType();
}

class Card implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }

    public String getType() {
        return "CARD";
    }
}

class Wallet implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

class Transaction {
    PaymentMethod paymentMethod;
    double amount;

    Transaction(PaymentMethod paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    double getAdjustedAmount() {
        return paymentMethod.calculateAmount(amount);
    }

    void display() {
        System.out.printf("%s: %.2f%n",
                paymentMethod.getType(), getAdjustedAmount());
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment;

            if (type.equals("CARD"))
                payment = new Card();
            else if (type.equals("WALLET"))
                payment = new Wallet();
            else
                payment = new BankTransfer();

            Transaction t = new Transaction(payment, amount);
            t.display();
            total += t.getAdjustedAmount();
        }

        System.out.printf("Total: %.2f%n", total);
    }
}