package ss16_File.exercise.Copy_file;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        ArrayList<Character> arrayList = new ArrayList();
        arrayList= readAndWriteFile.readFile("src/ss16_File/exercise/Copy_file/sourceFile.csv");
        readAndWriteFile.writeFile("src/ss16_File/exercise/Copy_file/TargetFile.csv", arrayList);
    }
}
