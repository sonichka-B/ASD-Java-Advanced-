package topic12.practice;

public record Payment(String id, String email, PaymentStatus status, int amountCents) {
}
