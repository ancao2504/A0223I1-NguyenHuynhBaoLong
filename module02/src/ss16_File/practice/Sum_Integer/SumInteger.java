package ss16_File.practice.Sum_Integer;

import java.io.*;

public class SumInteger {
    public void readFile(String src) {
        File file = new File(src);
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            System.out.println("Sum= " +sum);
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai !!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc File ");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng File");
            }
        }

    }
}
