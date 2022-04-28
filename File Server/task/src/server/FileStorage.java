package server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStorage {
    Path root = Path.of(
            System.getProperty("user.dir"),
            "src", "server", "data"
    );
    //    private static final String STORAGE_FOLDER = System.getProperty("user.dir") + "/File Server/task/src/server/data/";
    private static final String STORAGE_FOLDER = System.getProperty("user.dir") +File.separator + "src" + File.separator + "server" + File.separator + "data" + File.separator;

   // private static final String STORAGE_FOLDER =  System.getProperty("user.dir")
      //      + File.separator + "File Server" + File.separator + "task" + File.separator
        //    + "src" + File.separator + "server" + File.separator + "data" + File.separator;


    public void addFile(String fileName, String fileContent) throws IOException {
        //Files.writeString(Path.of(STORAGE_FOLDER + fileName), fileContent);
        try {
            File file = new File(STORAGE_FOLDER + fileName);
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(fileContent);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getFileContent(String fileName) throws IOException {
        return new String(Files.readAllBytes(Path.of(STORAGE_FOLDER + fileName)));
    }

    public boolean deleteFile(String fileName) throws IOException {
        return Files.deleteIfExists(Path.of(STORAGE_FOLDER + fileName));
    }

    public boolean contains(String fileName) {
        return Files.exists(Path.of(STORAGE_FOLDER + fileName));
    }
}
