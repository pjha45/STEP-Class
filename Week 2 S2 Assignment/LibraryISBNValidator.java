import java.util.Scanner;

public class LibraryISBNValidator {
    static String normalizeCode(String raw) {
        raw = raw.trim();

        String publisherCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return publisherCode + rest;
    }

    static String validateAndFormat(String code) {
        code = normalizeCode(code);

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();
        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();

        System.out.println(validateAndFormat(code));
    }
}