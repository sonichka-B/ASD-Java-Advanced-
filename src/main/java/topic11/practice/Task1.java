package topic11.practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Task1 {
    List<Book> books = List.of(
            new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
            new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
            new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
            new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
    );

    List<String> filteredBooks = books.stream()
            .filter(book -> book.year()>2015)
            .map(book ->book.title().toUpperCase())
            .sorted()
            .limit(3)
            .toList();

    List<String> allTags = books.stream()
            .flatMap(book -> book.tags().stream())
            .distinct()
            .sorted()
            .toList();

    Map<String, Long> tagFrequency = books.stream()
            .flatMap(book -> book.tags().stream())
            .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));


    List<String>topTagsFreq = tagFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .map(Map.Entry::getKey)
            .toList();




}
