
import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    double total() {
        return calculateCharge() + calculateInsurance();
    }
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return 0.02 * value;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return 0.02 * value;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (types[i]) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new Fragile(weight, value);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double charge = parcels[i].calculateCharge();
            double insurance = parcels[i].calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i], charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}