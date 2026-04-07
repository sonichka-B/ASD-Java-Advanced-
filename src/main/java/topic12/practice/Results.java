package topic12.practice;

import java.util.List;

public record Results(List<Payment> payments, int invalidLines) {
}
