package topic12.practice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PaymentReportWriter {
    public void writeReport(Path out, List<Payment> payments, int invalidLines) throws IOException {
        Path txtFile = out.resolveSibling(out.getFileName()+"txt");
        try(BufferedWriter w = Files.newBufferedWriter(txtFile, StandardCharsets.UTF_8)) {
            int paidTotalCents = 0;
            int newSt = 0;
            int paidSt = 0;
            int failedSt = 0;
            for (Payment payment : payments) {
                if (payment.status() == PaymentStatus.NEW) newSt++;
                if (payment.status() == PaymentStatus.PAID) {
                    paidSt++;
                    paidTotalCents += payment.amountCents();
                }
                if (payment.status() == PaymentStatus.FAILED) failedSt++;
            }
            w.write("Payment Report");
            w.newLine();
            w.write("invalidLines=" +invalidLines);
            w.newLine();
            w.write("paidTotalCents="+paidTotalCents);
            w.newLine();
            w.write("NEW="+newSt);
            w.newLine();
            w.write("PAID="+paidSt);
            w.newLine();
            w.write("FAILED="+failedSt);
            w.newLine();
        }
        Files.move(txtFile, out, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
    }
}
