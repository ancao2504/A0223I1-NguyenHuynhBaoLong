package ss16_File.practice.Max;

import java.util.ArrayList;

import static ss16_File.practice.Max.ReadAndWriteFile.findMax;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        ArrayList<Integer> numbers = readAndWriteFile.readFile("src/ss16_File/practice/Max/Integer_Num");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/ss16_File/practice/Max/Integer_Num", maxValue);
    }
}
