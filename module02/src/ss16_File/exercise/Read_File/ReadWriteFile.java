package ss16_File.exercise.Read_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    public static void writeFile(String src, String value, boolean append) {
        File file = new File(src);
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(value);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi File");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
    }

    public void readFile(String src) {
        List<String> strings = new ArrayList<>();
        File file = new File(src);
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi dóng file");
            }
        }
    }
}
