import java.util.*;

public class Cinema {

    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);
        char[][] scheme;
        int rows;
        int seatsInRow;
        int request;
        Statistics stat;

        System.out.println("Enter the number of rows:");
        rows = term.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsInRow = term.nextInt();
        stat = new Statistics(rows, seatsInRow);
        scheme = createScheme(rows, seatsInRow);

        do {
            System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit");
            request = term.nextInt();
            switch (request) {
                case 1:
                    printScheme(scheme);
                    break;
                case 2:
                    bookTicket(scheme, rows, seatsInRow, term);
                    break;
                case 3:
                    stat.printStatistics();
                    break;
            }
        } while (request != 0);
    }

    public static void bookTicket(char[][] scheme, int rows, int seatsInRow, Scanner term) {
        int choosenRow;
        int choosenSeat;

        System.out.println();
        System.out.println("Enter a row number:");
        choosenRow = term.nextInt();
        System.out.println("Enter a seat number in that row:");
        choosenSeat = term.nextInt();
        showTicketPrice(rows, seatsInRow, choosenRow, choosenSeat);
        scheme[choosenRow][choosenSeat] = 'B';
    }

    public static void showTicketPrice(int rows, int seats, int choosenRow, int choosenSeat) {
        System.out.println();
        if (rows * seats <= 60 ) {
            System.out.println("Ticket price: $10");
        }
        else {
            if (choosenRow <= rows / 2) {
                System.out.println("Ticket price: $10");
            } else {
                System.out.println("Ticket price: $8");
            }
        }
    }

    public static void printTotalIncome(int total) {
        System.out.println("Total income:");
        System.out.printf("$%d", total);
    }

    public static char[][] createScheme(int rows, int seats) {
        char[][] arr = new char[rows + 1][];
        for (int i = 0; i <= rows; i++) {
            arr[i] = new char[seats + 1];
            if (i == 0) {
                arr[i][0] = ' ';
                for (int j = 1; j <= seats; j++) {
                    arr[i][j] = (char) (j + 48);
                }
            }
            else {
                arr[i][0] = (char) (i + 48);
                for (int j = 1; j <= seats; j++) {
                    arr[i][j] = 'S';
                }
            }
        }
        return arr;
    }

    public static void printScheme(char[][] scheme) {
        System.out.println();
        System.out.println("Cinema:");
        for (char[] row : scheme) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}