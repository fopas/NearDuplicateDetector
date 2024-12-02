package org.example;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        // Отрывки из "Войны и мира" Льва Толстого для анализа схожести
        String text1 = "Князь Андрей ехал в одном ряду с генералом Багратионом, поглядывая на бесконечные войска, проходившие мимо него. Ему хотелось взглянуть на глаза людей, узнать, как они чувствуют свою будущую смерть, которую они так уверенно и спокойно идут навстречу.";
        String text2 = "Войска генерала Багратиона двигались бесконечной колонной. Князь Андрей ехал вместе с ними, смотрел на солдат и думал о том, что же их ждет впереди, и как они так спокойно идут навстречу возможной смерти.";

        // Канонизация текста
        String normalizedText1 = TextNormalizer.normalize(text1);
        String normalizedText2 = TextNormalizer.normalize(text2);

        // Построение шинглов с размером 2
        Set<String> shingles1 = Shingling.getShingles(normalizedText1, 1);
        Set<String> shingles2 = Shingling.getShingles(normalizedText2, 1);

        // Вывод шинглов для анализа
        System.out.println("Shingles for text1: " + shingles1);
        System.out.println("Shingles for text2: " + shingles2);

        // Расчет Jaccard Similarity
        double jaccardSimilarity = calculateJaccardSimilarity(shingles1, shingles2);
        System.out.printf("Jaccard Similarity based on Shingles: %.2f%%%n", jaccardSimilarity * 100);

        // Вычисление MinHash
        MinHasher minHasher = new MinHasher(50);
        int[] hash1 = minHasher.minHash(shingles1);
        int[] hash2 = minHasher.minHash(shingles2);

        // Сравнение MinHash
        double minHashSimilarity = DuplicateFinder.calculateSimilarity(hash1, hash2);
        System.out.printf("Similarity based on MinHash: %.2f%%%n", minHashSimilarity * 100);
    }

    // Метод для вычисления Jaccard Similarity между двумя множествами шинглов
    private static double calculateJaccardSimilarity(Set<String> set1, Set<String> set2) {
        if (set1.isEmpty() || set2.isEmpty()) {
            return 0.0;
        }

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }
}
