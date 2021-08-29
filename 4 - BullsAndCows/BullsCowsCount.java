class BullsCowsCount {
    private int bulls;
    private int cows;

    int getBulls() {
        return this.bulls;
    }

    int getCows() {
        return this.cows;
    }

    void countBullsCows(char[] num, char[] guess) {
        char[] number = new char[num.length];

        for (int i = 0; i < num.length; i++) {
            number[i] = num[i];
        }
        for (int i = 0; i < number.length; i++) {
            if (guess[i] == number[i]) {
                this.bulls++;
                number[i] = guess[i] = 'n';
            }
        }
        for (int i = 0; i < number.length; i++){
            for (int j = 0; j < number.length; j++) {
                if (Character.isDigit(guess[i]) && guess[i] == number[j]) {
                    this.cows++;
                    number[j] = guess[i] = 'n';
                    break;
                }
            }
        }
    }

    void zero() {
        this.bulls = 0;
        this.cows = 0;
    }
}