import java.util.*;

public enum Input {
    FROM,
    TO,
    EXIT;

    public static Input takeInput() throws IllegalArgumentException {
        Scanner term = new Scanner(System.in);
        String input;

        System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
        input = term.nextLine();
        if ("/from".equals(input)) {
            return Input.FROM;
        }
        if ("/to".equals(input)) {
            return Input.TO;
        }
        if ("/exit".equals(input)) {
            return Input.EXIT;
        }
        return valueOf("");
    }
}