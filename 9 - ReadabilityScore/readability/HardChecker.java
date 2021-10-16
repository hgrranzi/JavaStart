package readability;

public class HardChecker {

    static int countSentences(String text) {
        int sentences = 0;

        for (int i = 0; i < text.length(); i++) {
            if (i != text.length() - 1 && (text.charAt(i) == '!' || text.charAt(i) == '.' || text.charAt(i) == '?')) {
                sentences++;
            }
        }
        sentences++;
        return sentences;
    }

    public static boolean isHard(String text) {
        int sentences;
        double averageWords;

        sentences = countSentences(text);
        averageWords = text.split("\\s+").length;
        return averageWords / sentences > 10;
    }
}