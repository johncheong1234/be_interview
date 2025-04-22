// 1.1 Advanced Stream Operations & var
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Product(String name, String category, double price) {}

public class StreamOperations {
    public static Map<String, Double> averagePriceByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.averagingDouble(Product::price)
                ));
    }

    public static void main(String[] args) {
        var products = List.of(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Keyboard", "Electronics", 75.00),
                new Product("Book", "Books", 25.00),
                new Product("Smartphone", "Electronics", 900.00),
                new Product("Novel", "Books", 15.00)
        );

        var averagePrices = averagePriceByCategory(products);
        System.out.println("Average prices by category: " + averagePrices);
    }
}