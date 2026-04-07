package topic12.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            Path csvPath = Path.of("csvTest.csv");
            String csvContent = """
                id,email,status,amountCents
                1,john.doe@email.com,NEW,15000
                2,jane.smith@email.com,PAID,25000

                bad_row_missing_data
                3,error@email.com,UNKNOWN_STATUS,500
                4,bob@email.com,FAILED,1200
                5,alice@email.com,PAID,34000
                """;
            Files.writeString(csvPath, csvContent);

            System.out.println("Task1");
            PaymentLoader paymentLoader = new PaymentLoader();
            paymentLoader.load(csvPath);
            System.out.println(paymentLoader.load(csvPath).payments());
            System.out.println("invalid:"+paymentLoader.load(csvPath).invalidLines());

            Path out = Path.of("report.txt");
            System.out.println("Task2");
            PaymentReportWriter paymentReportWriter = new PaymentReportWriter();
            System.out.println();
            paymentReportWriter.writeReport(out,paymentLoader.load(csvPath).payments(),paymentLoader.load(csvPath).invalidLines() );

        }catch (IOException e){
            System.err.println("Error creating directories: " + e.getMessage());
        }


        try{
            Path inbox = Path.of("practical-data/inbox");
            Path archive = Path.of("practical-data/archive");
            Files.createDirectories(inbox);
            Files.createDirectories(archive);
            Files.writeString(inbox.resolve("file1.txt"), "This is file 1");
            Files.writeString(inbox.resolve("file2.txt"), "This is file 2");
            Files.writeString(inbox.resolve("file3.tmp"), "This is file 3");
            Files.writeString(inbox.resolve("file4.tmp"), "This is file 4");

            System.out.println("Task3");
            InboxArchiver inboxArchiver = new InboxArchiver();
            inboxArchiver.archiveTmpFiles(inbox, archive);

        }catch (IOException e){
            System.err.println("Error writing report: " + e.getMessage());
        }

        try{
            Path base = Path.of("base");
            System.out.println("Task4");
            PathSafety safety = new PathSafety();
            safety.safeResolve(base, "reports/2025.txt");
            safety.safeResolve(base, "../secret.txt");
        }catch (IllegalArgumentException e){
            System.err.println("Path resolution error: " + e.getMessage());
        }

        System.out.println("Task5");
        Path bin = Path.of("status.bin");
        Files.write(bin, new byte[10]);
        StatusFile statusFile = new StatusFile();
        statusFile.updateStatus(bin, 2, (byte)1);

    }
}
