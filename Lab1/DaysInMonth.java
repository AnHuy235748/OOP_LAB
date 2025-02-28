package a;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<String, Integer> monthMap = new HashMap<>() {{
            put("january", 1);
            put("jan.", 1);
            put("jan", 1);
            put("1", 1);
            put("february", 2);
            put("feb.", 2);
            put("feb", 2);
            put("2", 2);
            put("march", 3);
            put("mar.", 3);
            put("mar", 3);
            put("3", 3);
            put("april", 4);
            put("apr.", 4);
            put("apr", 4);
            put("4", 4);
            put("may", 5);
            put("5", 5);
            put("june", 6);
            put("jun", 6);
            put("6", 6);
            put("july", 7);
            put("jul", 7);
            put("7", 7);
            put("august", 8);
            put("aug.", 8);
            put("aug", 8);
            put("8", 8);
            put("september", 9);
            put("sept.", 9);
            put("sep", 9);
            put("9", 9);
            put("october", 10);
            put("oct.", 10);
            put("oct", 10);
            put("10", 10);
            put("november", 11);
            put("nov.", 11);
            put("nov", 11);
            put("11", 11);
            put("december", 12);
            put("dec.", 12);
            put("dec", 12);
            put("12", 12);
        }};

        int monthNumber = 0;
        int year = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter the month:");
            String monthInput = in.nextLine().toLowerCase();

            if(monthMap.containsKey(monthInput)) {
                monthNumber = monthMap.get(monthInput);
                validInput = true;
            } else {
                System.out.println("Invalid month. Please try again.");
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.println("Enter the year:");
            String yearInput = in.nextLine();

            if(yearInput.matches("\\d{4}")) {
                year = Integer.parseInt(yearInput);
                if (year >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Year cannot be negative. Please try again.");
                }
            } else {
                System.out.println("Invalid year. Please enter a 4-digit year.");
            }
        }

        YearMonth yearMonthObject = YearMonth.of(year, monthNumber);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        System.out.println("Number of days: " + daysInMonth);
    }

}