package topic11.practice;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println("TASK1");
        List<String> resultBook = task1.filteredBooks;
        System.out.println(resultBook);

        System.out.println("TASK2");
        List<String> resultTags= task1.allTags;
        System.out.println(resultTags);

        Map<String, Long> tagFrequency = task1.tagFrequency;
        System.out.println(tagFrequency);

        List<String> resultTopTagsFreq= task1.topTagsFreq;
        System.out.println(resultTopTagsFreq);

        System.out.println("TASK3");
        Task3 task3 = new Task3();
        Map<String,Integer> resultProduct = task3.products;
        System.out.println(resultProduct);

        Map<String, Long> resultEmails = task3.groupedByEmail;
        System.out.println(resultEmails);

        System.out.println("TASK4");
        List<Result> results = List.of(new Success("email"), new Failure("emailError"),
                new Success("email1"), new Success("email2"), new Failure("email3"),
                new Failure("email4"));
        long successCount = results.stream()
                .filter(result -> result instanceof Success)
                .count();

        long  failureCount = results.stream()
                .filter(result -> result instanceof Failure)
                .count();
        List<Result> allFailure = results.stream()
                        .filter(result -> result instanceof Failure)
                        .toList();
        System.out.println(successCount);
        System.out.println(failureCount);
        System.out.println(allFailure);

    }
}
