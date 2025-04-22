import java.text.MessageFormat;

public class PaymentProcessor {
    
    // Using classic class hierarchy instead of records/sealed classes
    public static abstract class Currency {
        public abstract String getCode();
    }
    
    public static class USD extends Currency {
        @Override public String getCode() { return "USD"; }
    }
    
    public static class EUR extends Currency {
        @Override public String getCode() { return "EUR"; }
    }
    
    public static class GBP extends Currency {
        @Override public String getCode() { return "GBP"; }
    }
    
    public static class Payment {
        private final double amount;
        private final String currency;
        
        public Payment(double amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }
        
        public double getAmount() { return amount; }
        public String getCurrency() { return currency; }
    }
    
    public String processPayment(Payment payment, Currency targetCurrency) {
        return MessageFormat.format(
            "Converting {0,number,#.##} {1} to {2}",
            payment.getAmount(),
            payment.getCurrency(),
            targetCurrency.getCode()
        );
    }
    
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        Payment payment = new Payment(123.45, "JPY");
        System.out.println(processor.processPayment(payment, new USD()));
    }
}