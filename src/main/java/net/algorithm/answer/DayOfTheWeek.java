package net.algorithm.answer;

public class DayOfTheWeek {
    public static void main(String[] args) {

    }

    private int start = 1971;
    private int end = 2100;

    public String dayOfTheWeek(int day, int month, int year) {
        int sum = 0;
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weeks = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        for (int i = start; i < year; i++) {
            if (i % 4 == 0 && i != 1900 && i != 2100) {
                sum += 366;
            } else {
                sum += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            sum += months[i - 1];
            if (i == 2 && year % 4 == 0 && year != 1900 && year != 2100) {
                sum++;
            }
        }
        sum += day;
        return weeks[sum % 7];
    }
}
