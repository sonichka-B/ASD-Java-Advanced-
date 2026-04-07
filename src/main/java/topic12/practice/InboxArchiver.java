package topic12.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class InboxArchiver {
    public void archiveTmpFiles(Path inbox, Path archive) throws IOException {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(inbox, "*.tmp")) {
            for (Path p : stream) {
                Files.move(p, archive.resolve(p.getFileName()), StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE);
                System.out.println("transferred:" + p.getFileName().toString());
            }
            System.out.println("Archived files: " + archive.toString());
        } catch (IOException e) {
            throw new IOException("Error while archiving tmp files", e);
        }
    }
}
