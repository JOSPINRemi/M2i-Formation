package org.example.entity;

import lombok.Getter;

public class HangMan {
    private WordGenerator wordGenerator;
    private String word;
    @Getter
    private String mask;

    public HangMan(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    public void generateMask() {
        word = wordGenerator.getRandomWord();
        mask = "_";
        for (int i = 0; i < word.length() - 1; i++) {
            mask += "_";
        }
    }

    public boolean tryChar(char c) {
        return true;
    }
}
