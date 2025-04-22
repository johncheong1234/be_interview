// PaymentProcessor.java
sealed interface Currency permits USD, EUR, GBP {}
record USD() implements Currency {}
record EUR() implements Currency {}
record GBP() implements Currency {}

record Payment(double amount, String currency) {}

public class PaymentProcessor {
    public static void main(String[] args) {
        var payment = new Payment(100.0, "USD");
        
        System.out.println(processPayment(payment, new USD()));
        System.out.println(processPayment(payment, new EUR()));
        System.out.println(processPayment(payment, new GBP()));
    }

    public static String processPayment(Payment payment, Currency targetCurrency) {
        return switch (targetCurrency) {
            case USD usd -> "Converting %.2f %s to USD".formatted(payment.amount(), payment.currency());
            case EUR eur -> "Converting %.2f %s to EUR".formatted(payment.amount(), payment.currency());
            case GBP gbp -> "Converting %.2f %s to GBP".formatted(payment.amount(), payment.currency());
        };
    }
}