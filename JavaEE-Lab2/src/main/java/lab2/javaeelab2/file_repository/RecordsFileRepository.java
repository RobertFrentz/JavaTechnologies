package lab2.javaeelab2.file_repository;

import lab2.javaeelab2.model.Category;
import lab2.javaeelab2.model.Record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordsFileRepository {

    private static final String path = "C:/Users/Robert/records-repository.txt";

    public static void writeRecordToFile(Category category, String key, String value){
        try{
            File file = new File(path);
            boolean result = file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.append(category.getName()).append(",")
                      .append(key).append(",")
                      .append(value);
            fileWriter.append("\n");
            fileWriter.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<Record> readRecordsFromFile() {
        File file = new File(path);
        List<Record> result = new ArrayList<>();
        List<String> recordsValues;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while( (line = bufferedReader.readLine()) != null){
                System.out.println(line);
                recordsValues = Arrays.asList(line.split(",")); // 0 => category, 1 => key, 2 => value
                System.out.println(recordsValues);
                result.add(new Record(new Category(recordsValues.get(0)), recordsValues.get(1), recordsValues.get(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
