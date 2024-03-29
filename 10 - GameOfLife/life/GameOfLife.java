package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    static JLabel generation;
    static JLabel alive;
    static JPanel[][] fieldPanel;

    public static void main(String[] args) {
        try {
            Field field = Field.create();
            GameOfLife life = new GameOfLife(field);
            life.setVisible(true);
            life.runLife(field);
//            field.printField();
        } catch (Exception e) {
            System.out.println("Error. Wrong input.");
        }
    }

    public GameOfLife(Field field) {
        super("Game of Life");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel text = new JPanel();
        text.setBounds(0, 0, 300, 40);
        text.setVisible(true);
        text.setLayout(new GridLayout(2, 1));
        add(text);
        generation = new JLabel("Generation: #1");
        //generation.setBounds(5, 5, 100, 10);
        text.add(generation);
        alive = new JLabel("Alive: 0");
        //alive.setBounds(5, 20, 100, 10);
        text.add(alive);

        JPanel img = new JPanel();
        img.setBounds(5, 40, 290, 225);
        img.setVisible(true);
        add(img);
        fieldPanel = new JPanel[field.getField().length][field.getField().length];
        for (int y = 0; y < fieldPanel.length; y++) {
            for (int x = 0; x < fieldPanel.length; x++) {
                fieldPanel[y][x] = new JPanel();
                fieldPanel[y][x].setVisible(true);
                fieldPanel[y][x].setBackground(Color.BLACK);
                img.add(fieldPanel[y][x]);
            }
        }
        img.setLayout(new GridLayout(fieldPanel.length, fieldPanel.length, 1, 1));
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    public void drawPanel(Field field) {
        for (int y = 0; y < fieldPanel.length; y++) {
            for (int x = 0; x < fieldPanel.length; x++) {
                if (field.getField()[y][x] == 'O') {
                    fieldPanel[y][x].setBackground(Color.GRAY);
                } else {
                    fieldPanel[y][x].setBackground(Color.WHITE);
                }
            }
        }
        repaint();
    }

    public void runLife(Field field) throws InterruptedException {
        for (int i = 0; i < field.getSteps(); i++) {
//            System.out.println("Generation #" + (i + 1));
//            System.out.println("Alive: " + Generation.countAlive(field));
//            field.printField();
            drawPanel(field);
            Thread.sleep(150);
            field.setField(Generation.nextGeneration(field.getField()));
        }
    }
}