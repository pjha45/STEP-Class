import java.util.*;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    String name;
    LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class Basic extends SubscriptionPlan {
    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends SubscriptionPlan {
    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends SubscriptionPlan {
    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            if (type.equals("BASIC"))
                plan = new Basic(name, startDate);
            else if (type.equals("STANDARD"))
                plan = new Standard(name, startDate);
            else
                plan = new Premium(name, startDate);

            System.out.println(plan.name + ": " + plan.getRenewalDate());
        }
    }
}