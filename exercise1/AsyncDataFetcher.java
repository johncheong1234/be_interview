// 1.3 Concurrency & CompletableFuture
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncDataFetcher {

    public static CompletableFuture<String> fetchUserData(long userId) {
        // Simulate fetching data from a remote service with a delay
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep((long) (Math.random() * 1000)); // Simulate network latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return "Error fetching data for user " + userId;
            }
            return "Data for user " + userId;
        });
    }

    public static CompletableFuture<String> fetchCombinedUserData(long userId1, long userId2) {
        CompletableFuture<String> data1Future = fetchUserData(userId1);
        CompletableFuture<String> data2Future = fetchUserData(userId2);

        return data1Future.thenCombine(data2Future, (data1, data2) -> "Data1: " + data1 + ", Data2: " + data2)
                .exceptionally(throwable -> "Error combining data: " + throwable.getMessage());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long user1 = 123;
        long user2 = 456;

        CompletableFuture<String> combinedDataFuture = fetchCombinedUserData(user1, user2);

        System.out.println("Fetching data...");
        String combinedData = combinedDataFuture.get(); // Block and wait for the result
        System.out.println("Combined data: " + combinedData);
    }
}