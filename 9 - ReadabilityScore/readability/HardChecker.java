package readability;

import java.io.*;

public class HardChecker {

    public static int countSentences(String text) {
        int sentences = 0;

        for (int i = 0; i < text.length(); i++) {
            if (i != text.length() - 1 && (text.charAt(i) == '!' || text.charAt(i) == '.' || text.charAt(i) == '?')) {
                sentences++;
            }
        }
        sentences++;
        return sentences;
    }

    public static int countWords(String text) {
        return text.split("\\s+").length;
    }

    public static int countCharacters(String text) {
        int chars = 0;

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                chars++;
            }
        }
        return chars;
    }

    public static boolean isHard(String text) {
        int sentences = countSentences(text);
        int words = countWords(text);

        return (double) words / sentences > 10;
    }

    public static double hardScore(BufferedReader in) throws IOException {
        int sentences = 0;
        int words = 0;
        int chars = 0;
        String text;

        while ((text = in.readLine()) != null) {
            text = text.replaceAll("^\\s+$\\s+", "");
            sentences += countSentences(text);
            words = +countWords(text);
            chars = +countCharacters(text);
        }
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + chars);
        double score = 4.71 * ((double) chars / words) + 0.5 * ((double) words / sentences) - 21.43;
        System.out.printf("The score is: %f\n", score);
        System.out.printf("This text should be understood by %s.\n", ari(score));
        return score;
    }

    static String ari(double n) {
        int score = (int) Math.ceil(n);
        if (score < 2) {
            return ("5-6-year-olds");
        } else if (score < 3) {
            return ("6-7-year-olds");
        } else if (score < 4) {
            return ("7-9-year-olds");
        } else if (score < 5) {
            return ("9-10-year-olds");
        } else if (score < 6) {
            return ("10-11-year-olds");
        } else if (score < 7) {
            return ("11-12-year-olds");
        } else if (score < 8) {
            return ("12-13-year-olds");
        } else if (score < 9) {
            return ("13-14-year-olds");
        } else if (score < 10) {
            return ("14-15-year-olds");
        }else if (score < 11) {
            return ("15-16-year-olds");
        } else if (score < 12) {
            return ("16-17-year-olds");
        } else if (score < 13) {
            return ("17-18-year-olds");
        } else if (score < 14) {
            return ("18-24-year-olds");
        } else {
            return ("24+-year-olds");
        }
    }
}