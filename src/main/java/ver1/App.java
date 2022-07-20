package ver1;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    private static final String PATH_FORMAT = "/home/gromozeqa/Downloads/%s/";
    private static final String BASE_DIR = "/home/gromozeqa/Downloads";

    public static void main(String[] args) {
        System.out.println(transfer());
    }

    private static boolean transfer() {
        for (File file : getFilesToMove(BASE_DIR)) {
            if (getFileExtension(file.getName()).equals("jpg")) {
                movePicture(file);
                return true;
            }

            if (getFileExtension(file.getName()).equals("docx")) {
                moveDocs(file);
                return true;
            }
        }
        return false;
    }

    private static List<File> getFilesToMove(String dir) {
        List<File> filesToMove = new ArrayList<>();
        Optional<File[]> filesInFolder = Optional.ofNullable(new File(dir).listFiles(File::isFile));

        filesInFolder.ifPresent(arrayOfFiles -> {
            filesToMove.addAll(Arrays.asList(arrayOfFiles));
        });
        return filesToMove;
    }

    private static String getFileExtension(String filePath) {
        return FilenameUtils.getExtension(filePath);
    }

    private static boolean movePicture(File file) {
        try {
            Path temp = Files.move(file.toPath(), Paths.get(String.format(PATH_FORMAT, "pictures") + file.getName()));
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean moveDocs(File file) {
        try {
            Path temp = Files.move(file.toPath(), Paths.get(String.format(PATH_FORMAT, "documents") + file.getName()));
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
