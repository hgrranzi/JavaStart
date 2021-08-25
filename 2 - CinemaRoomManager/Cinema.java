import java.util.*;

public class Cinema {

    public static void main(String[] args) {
        char[][] scheme = createScheme(7, 8);

        printScheme(scheme);
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
        System.out.println("Cinema:");
        for (char[] row : scheme) {
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }
}