public class BullsCows {
    public static void main(String[] args) {
        Config config;
        Game game;

        config = new Config();
        if (config.good()) {
            game = new Game (config.getLen(), config.getPossibleSymbols());
            game.play();
        }
        else {
            System.out.println("NOT Ok");
        }
    }
}