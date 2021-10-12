package lab1.javaeelab1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServletHelper {

    public static void configWriteInfo(String key, int value, LocalDateTime timestamp, boolean sync){
        if (sync) {
                writeToFileSync(value, key, timestamp);
        } else {
            writeToFile(value, key, timestamp);
        }
    }

    public static List<String> configReadInfo(boolean sync){
        if (sync) {
            return readAndFormatContentSync();
        } else {
            return readAndFormatContent();
        }
    }

    private synchronized static void writeToFileSync(int value, String key, LocalDateTime timestamp){
        try{
            File file = new File("repository.txt");
            boolean result = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
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

    private static void writeToFile(int value, String key, LocalDateTime timestamp){
        try{
            File file = new File("repository.txt");
            boolean result = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
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

    public synchronized static List<String> readAndFormatContentSync() {
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
