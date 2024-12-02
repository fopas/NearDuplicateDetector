package org.example;

import java.util.HashSet;
import java.util.Set;

public class Shingling {

    // Метод для построения шинглов указанного размера
    public static Set<String> getShingles(String text, int shingleSize) {
        Set<String> shingles = new HashSet<>();
        String[] words = text.split(" ");
        if (words.length < shingleSize) {
            return shingles;
        }

        for (int i = 0; i <= words.length - shingleSize; i++) {
            StringBuilder shingle = new StringBuilder();
            for (int j = 0; j < shingleSize; j++) {
                if (j > 0) {
                    shingle.append(" ");
                }
                shingle.append(words[i + j]);
            }
            shingles.add(shingle.toString());
        }
        return shingles;
    }
}
