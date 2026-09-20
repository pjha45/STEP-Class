import java.util.Scanner;

public class BankTransactionValidator {
    static String normalizeReference(String raw) {
        raw = raw.trim();

        String bankCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        reference = normalizeReference(reference);

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        String formattedDate = date.substring(0, 2) + "/" +
                               date.substring(2, 4) + "/" +
                               date.substring(4, 6);

        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(formattedDate);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        System.out.println(validateAndFormat(raw));
    }
}