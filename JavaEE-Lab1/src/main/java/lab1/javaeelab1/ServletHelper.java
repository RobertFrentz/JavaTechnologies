package lab1.javaeelab1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServletHelper {

    public static void configWriteInfo(String key, int value, LocalDateTime timestamp, boolean sync){
        File file = new File("repository.txt");
        if (sync) {
            synchronized (file) {
                writeToFile(file, value, key, timestamp);
            }
        } else {
            writeToFile(file, value, key, timestamp);
        }
    }

    private static void writeToFile(File repo, int value, String key, LocalDateTime timestamp){
        try{
            boolean result = repo.createNewFile();
            FileWriter fileWriter = new FileWriter(repo, true);
            for (int i = 0; i < value; i++) {
                fileWriter.append(key).append(" ");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            fileWriter.append(timestamp.format(formatter));
            fileWriter.append("\n");
            fileWriter.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> readAndFormatContent() {
        File file = new File("repository.txt");
        List<String> result = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while( (line = bufferedReader.readLine()) != null){
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(result);
        return result;
    }
}
