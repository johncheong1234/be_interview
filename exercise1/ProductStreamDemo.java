// ProductStreamDemo.java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Product(String name, String category, double price) {}

public class ProductStreamDemo {
    public static void main(String[] args) {
        var products = List.of(
            new Product("Laptop", "Electronics", 999.99),
            new Product("Phone", "Electronics", 699.99),
            new Product("Shirt", "Clothing", 29.99),
            new Product("Pants", "Clothing", 49.99),
            new Product("Book", "Books", 14.99)
        );

        var avgPricesByCategory = calculateAveragePriceByCategory(products);
        avgPricesByCategory.forEach((category, avgPrice) ->
            System.out.printf("%s: %.2f%n", category, avgPrice));
    }

    public static Map<String, Double> calculateAveragePriceByCategory(List<Product> products) {
        return products.stream()
            .collect(Collectors.groupingBy(
                Product::category,
                Collectors.averagingDouble(Product::price)
            ));
    }
}