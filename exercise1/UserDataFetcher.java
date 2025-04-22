// UserDataFetcher.java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UserDataFetcher {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long userId1 = 101;
        long userId2 = 202;
        
        var combinedFuture = fetchAndCombineUserData(userId1, userId2);
        
        // Block and get the result (just for demo)
        System.out.println(combinedFuture.get());
    }

    public static CompletableFuture<String> fetchAndCombineUserData(long userId1, long userId2) {
        CompletableFuture<String> future1 = fetchUserData(userId1);
        CompletableFuture<String> future2 = fetchUserData(userId2);

        return future1.thenCombine(future2, (result1, result2) -> 
                    "Data1: " + result1 + ", Data2: " + result2)
                .exceptionally(ex -> {
                    System.err.println("Error fetching data: " + ex.getMessage());
                    return "Partial data available due to errors";
                });
    }

    // Simulate remote service call
    private static CompletableFuture<String> fetchUserData(long userId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate network delay
                Thread.sleep((long) (Math.random() * 1000));
                
                if (Math.random() > 0.8) {
                    throw new RuntimeException("Service unavailable for user " + userId);
                }
                
                return "User" + userId + "Data";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}