package lab1.javaeelab1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServletHelper {

    public void configWriteInfo(String key, int value, LocalDateTime timestamp, boolean sync){
        File file = new File("repository.txt");
        if (sync) {
            synchronized (this) {
                writeToFile(file, value, key, timestamp);
            }
        } else {
            writeToFile(file, value, key, timestamp);
        }
    }

    public List<String> configReadInfo(boolean sync){
        File file = new File("repository.txt");
        if (sync) {
            synchronized (this) {
                return readAndFormatContent(file);
            }
        } else {
            return readAndFormatContent(file);
        }
    }

    private void writeToFile(File file, int value, String key, LocalDateTime timestamp){
        try{
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

    public List<String> readAndFormatContent(File file) {
        List<String> result = new ArrayList<>();
        try{
            boolean rs = file.createNewFile();
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
