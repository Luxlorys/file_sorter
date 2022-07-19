import org.apache.commons.io.FilenameUtils;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

//        System.out.println(FilenameUtils.getExtension("Computer/home/gromozeqa/twitter.jpg").equals("jpg"));
//        System.out.println(getFileExtension("Computer/home/gromozeqa/twitter.jpg").equals("jpg"));

        List<String> fileList = Arrays.asList(
                "Computer/home/gromozeqa/twitter.jpg",
                "Computer/home/gromozeqa/Intern_Java_Dev.pdf"
        );

        for (String el : fileList) {
            if (getFileExtension(el).equals("jpg")) {
                System.out.println(true);
            }
        }
    }

    private static String getFileExtension(String path) {
        return FilenameUtils.getExtension(path);
    }
}
