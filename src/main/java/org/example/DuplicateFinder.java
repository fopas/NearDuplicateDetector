package org.example;

public class DuplicateFinder {

    // Метод для вычисления схожести на основе MinHash векторов
    public static double calculateSimilarity(int[] hash1, int[] hash2) {
        if (hash1.length != hash2.length) {
            throw new IllegalArgumentException("Hash arrays must be of the same length");
        }

        int identicalMinHashes = 0;
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] == hash2[i]) {
                identicalMinHashes++;
            }
        }
        return (double) identicalMinHashes / hash1.length;
    }
}
