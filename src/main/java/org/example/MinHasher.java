package org.example;

import java.util.Set;

public class MinHasher {

    private final int[] hashSeeds;

    // Инициализация MinHasher с количеством хэш-функций
    public MinHasher(int numHashes) {
        this.hashSeeds = new int[numHashes];
        for (int i = 0; i < numHashes; i++) {
            hashSeeds[i] = i + 1; // Простая генерация seed для хэширования
        }
    }

    // Метод для вычисления MinHash для набора шинглов
    public int[] minHash(Set<String> shingles) {
        int[] minHashes = new int[hashSeeds.length];
        for (int i = 0; i < hashSeeds.length; i++) {
            int minHashValue = Integer.MAX_VALUE;
            for (String shingle : shingles) {
                int hashValue = shingle.hashCode() ^ hashSeeds[i];
                if (hashValue < minHashValue) {
                    minHashValue = hashValue;
                }
            }
            minHashes[i] = minHashValue;
        }
        return minHashes;
    }
}
