package battleship;

import java.io.*;

public class Game {

    private Player player1;
    private Player player2;

    public Game() {
        this.player1 = new Player(1);
        this.player2 = new Player(2);
    }

    public void play() {
        player1.beforeStart();
        promptEnter();
        player2.beforeStart();
        promptEnter();
        while (player1.getShipsCount() > 0 && player2.getShipsCount() > 0) {
            printInstruction(this.player1, this.player2);
            player2.shoot();
            promptEnter();
            if (player2.getShipsCount() == 0) {
                break;
            }
            printInstruction(this.player2, this.player1);
            player1.shoot();
            promptEnter();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    void printInstruction(Player shoot, Player shooted) {
        shooted.getField().printField(true);
        System.out.printf("---------------------\n");
        shoot.getField().printField(false);
        System.out.printf("Player %d, it's your turn:\n", shoot.id);
    }

    public static void promptEnter() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {

        }
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}