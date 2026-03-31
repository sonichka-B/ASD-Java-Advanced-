package topic11.practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {

    List<Sale> sales = List.of(
            new Sale("a@ex.com", "Tea", 120),
            new Sale("b@ex.com", "Cake", 200),
            new Sale("a@ex.com", "Tea", 120),
            new Sale("c@ex.com", "Coffee", 150),
            new Sale("b@ex.com", "Cake", 200)
    );

    Map<String, Integer> products = sales.stream()
            .collect(Collectors.toMap(Sale::product, Sale::cents, Integer::sum));

    Map<String,Long> groupedByEmail =  sales.stream()
            .collect(Collectors.groupingBy(Sale::customerEmail, Collectors.counting()));
}
