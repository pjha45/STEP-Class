import java.util.Scanner;

public class PhoneNumberFormatter {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(6);

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.insert(6, "-");
        masked.append(lastFour);

        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}