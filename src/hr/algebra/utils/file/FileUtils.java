package hr.algebra.utils.file;

import hr.algebra.res.ConstValues;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private static final String MY_DOCUMENT_DIRECTORY = getMyDocumentDirectory();
    private static final String PROJECT_DIRECTORY = MY_DOCUMENT_DIRECTORY + File.separator + ConstValues.getAppName();

    public static String getLogDir() {
        return PROJECT_DIRECTORY + File.separator + "Logs";
    }

    public static void createDirHierarchy(String destination) throws IOException {
        String dir = destination.substring(0, destination.lastIndexOf(File.separator));
        if (!Files.exists(Paths.get(dir))) {
            Files.createDirectories(Paths.get(dir));
        }
    }

    private static String getMyDocumentDirectory() {
        JFileChooser fr = new JFileChooser();
        FileSystemView fs = fr.getFileSystemView();
        return fs.getDefaultDirectory().toString();
    }
}
