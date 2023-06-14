package Thuc_hanh;
import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month you want to count days");
        int month = scanner.nextInt();
        String dayInmonth;

        switch (month) {
            case 2:
                dayInmonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayInmonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayInmonth = "30";
                break;
            default:
                dayInmonth = "";
        }

        if (!dayInmonth.equals("")) {
            System.out.printf("The month %d has %s days", month, dayInmonth);
        } else {
            System.out.println("Invalid input!");
        }
    }
}

