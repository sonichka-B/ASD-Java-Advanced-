package topic12.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PaymentLoader {
    public Results load(Path cvs) throws IOException {
        List<Payment> payments = new ArrayList<>();
        int invalidLines = 0;

        try (BufferedReader r = Files.newBufferedReader(cvs, StandardCharsets.UTF_8)) {
            String missTitle = r.readLine();
            String line;

            while ((line = r.readLine()) != null) {
                if(line.isBlank()){
                    invalidLines++;
                    continue;
                }
                try {
                    String[] lines = line.split(",");
                    if(lines.length<4){
                        invalidLines++;
                        continue;
                    }
                    String id = lines[0].trim();
                    String email = lines[1].trim();
                    PaymentStatus status = PaymentStatus.valueOf(lines[2].trim());
                    int amountCents = Integer.parseInt(lines[3].trim());
                    payments.add(new Payment(id, email, status, amountCents));
                } catch (IllegalArgumentException e) {
                    invalidLines++;
                }
            }
        }
        return new Results(payments, invalidLines);
    }

}
