package ss16_File.exercise.Copy_file;

import ss10_DSA_list.practice.list_basic.List;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFile {
    public ArrayList<Character> readFile (String src){
        ArrayList<Character> stringList = new ArrayList<Character>();
        File file = new File(src);
        BufferedReader bufferedReader=null;
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int line ;
            while ((line= bufferedReader.read()) !=-1) {
                stringList.add((char) line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return stringList;
    }

    public static void writeFile (String src, ArrayList<Character> str) {
        BufferedWriter bufferedWriter =null;
        int countChar = 0;
        try {
            FileWriter writer =new FileWriter(src,true);
            bufferedWriter = new BufferedWriter(writer);
             countChar=0;
            for (Character character: str) {
                bufferedWriter.write(character);
                countChar++;
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi File");
        }finally {
            try {
                bufferedWriter.write("\n Có tất cả: "+countChar +"Ký tự");
               bufferedWriter.newLine();
               bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("lỗi đóng file");
            }
        }

    }

}
