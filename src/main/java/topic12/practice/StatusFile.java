package topic12.practice;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;

public class StatusFile {
    public void updateStatus(Path file, int index, byte status) throws IOException {
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file.toFile(), "rw")){
            randomAccessFile.seek(index);
            randomAccessFile.writeByte(status);

            randomAccessFile.seek(index);
            byte back = randomAccessFile.readByte();
            System.out.println("Updated status at index " + index + " to " + status + ". Read back: " + back);
        }
    }
}
