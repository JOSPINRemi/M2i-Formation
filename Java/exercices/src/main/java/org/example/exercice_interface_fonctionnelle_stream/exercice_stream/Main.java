package org.example.exercice_interface_fonctionnelle_stream.exercice_stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String text = "Ceci est le texte qui me servira pour mes tests";
        String cleanedText = text
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase();
        List<String> words = Arrays.asList(cleanedText.split("\\s+"));

//        Fréquence des mots
        Map<String, Long> wordFrequency = words.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

//        Filtrer les mots
        List<String> wordsFiltred = words.stream().filter(c -> c.length() > 5).collect(Collectors.toList());

//        Mots uniques
        Set<String> uniqueWords = new HashSet<>(words);
//        Avec stream
        uniqueWords = words.stream().distinct().collect(Collectors.toSet());

//        Les mots les plus fréquents
        List<String> mostFrequentWords = wordFrequency.entrySet().stream().sorted(
                Map.Entry.<String, Long>comparingByValue().reversed()
        ).limit(5).map(e -> e.getKey()).collect(Collectors.toList());

//        Statistique sur la longueur des mots
        IntSummaryStatistics summaryStatistics = words.stream().mapToInt(s -> s.length()).summaryStatistics();
    }
}
