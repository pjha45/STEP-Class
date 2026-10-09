
import java.util.*;

interface SaverMode {
    double SAVING = 0.25;
}

abstract class Appliance {
    double hours;
    double power;

    Appliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    double calculateUnits() {
        return power * hours / 1000;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours, 150);
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours, 1500);
    }

    double calculateUnits(boolean saver) {
        double units = calculateUnits();
        return saver ? units * (1 - SAVING) : units;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours, 100);
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours, 500);
    }

    double calculateUnits(boolean saver) {
        double units = calculateUnits();
        return saver ? units * (1 - SAVING) : units;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver)
                sc.next();

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver)
                units *= 0.75;

            double cost = units * 8;

            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}