package org.example.entity;

import lombok.Getter;

public class HangMan {
    private WordGenerator wordGenerator;
    private String winnerWord;
    @Getter
    private String mask;
    @Getter
    private int tryNumber;

    public HangMan(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        tryNumber = 10;
    }

    public void generateMask() {
        winnerWord = wordGenerator.getRandomWord();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < winnerWord.length(); i++) {
            builder.append("_");
        }
        this.mask = builder.toString();
    }

    public boolean tryChar(char inputChar) {
        boolean found = false;
        StringBuilder nextMaskBuilder = new StringBuilder();
        for (int i = 0; i < winnerWord.length(); i++) {
            if (winnerWord.charAt(i) == inputChar){
                nextMaskBuilder.append(inputChar);
                found = true;
            }
            else {
                nextMaskBuilder.append(mask.charAt(i));
            }
        }
        if (found) {
            mask = nextMaskBuilder.toString();
        } else {
            tryNumber--;
        }
        return found;
    }

    public boolean checkVictory() {
        return winnerWord.equals(mask);
    }
}
