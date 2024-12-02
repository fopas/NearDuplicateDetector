package org.example;

public class TextNormalizer {

    // Приведение текста к стандартному виду, удаление пунктуации и лишних символов
    public static String normalize(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        return text.toLowerCase()
                .replaceAll("[^а-яa-z0-9\\s]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
