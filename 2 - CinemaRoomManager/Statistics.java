
public class Statistics {
    private int purchasedTickets;
    private double percentage;
    private int currentIncome;
    private final int totalIncome;
    private final double percentPerTicket;

    Statistics(int rows, int seats) {
        this.purchasedTickets = 0;
        this.percentage = 0.0;
        this.currentIncome = 0;
        this.totalIncome = calculateTotalIncome(rows, seats);
        this.percentPerTicket = (double) 1 / (rows * seats) * 100;
    }

    public static int calculateTotalIncome(int rows, int seats) {
        int frontSeats;
        int backSeats;

        if (rows * seats <= 60) {
            return rows * seats * 10;
        }
        frontSeats = rows / 2 * seats;
        backSeats = rows * seats - frontSeats;
        return (frontSeats * 10 + backSeats * 8);
    }

    public void printStatistics() {
        System.out.println();
        System.out.printf("Number of purchased tickets: %d\n", this.purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", this.percentage);
        System.out.printf("Current income: $%d\n", this.currentIncome);
        System.out.printf("Total income: $%d\n", this.totalIncome);
    }

    public void updateStatistics(int ticketPrice) {
        this.purchasedTickets++;
        this.percentage += percentPerTicket;
        this.currentIncome += ticketPrice;
    }

}