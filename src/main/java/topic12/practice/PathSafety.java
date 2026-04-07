package topic12.practice;

import java.nio.file.Path;

public class PathSafety {
    public void safeResolve(Path base, String userInput) throws IllegalArgumentException {
        Path resolvedPath = base.resolve(userInput).normalize();
        if (!resolvedPath.startsWith(base)) {
            throw new IllegalArgumentException("Invalid path: " + userInput);
        }
        System.out.println("Resolved path: " + resolvedPath);
    }
}
