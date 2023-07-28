package ss16_File.practice.Max;

import ss10_DSA_list.practice.list_basic.List;

import java.io.*;
import java.util.ArrayList;
import java.util.RandomAccess;


public class ReadAndWriteFile {
    public ArrayList readFile(String src) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        File file = new File(src);
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line="";
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.valueOf(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
        return numbers;
    }

    public void writeFile(String src, int max) {
        BufferedWriter bufferedWriter=null;
        try {
            FileWriter writer =new FileWriter(src,true);
             bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("max value: " + max);
        } catch (IOException e) {
            System.out.println("Lỗi ghi File");
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Lỗi đóng file");
            }
        }
    }

    public static int findMax(ArrayList<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max=numbers.get(i);
            }
        }
        return max;
    }
}
