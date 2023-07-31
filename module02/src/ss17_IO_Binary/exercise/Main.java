package ss17_IO_Binary.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ProductManager> productManagers = new ArrayList<>();
        productManagers.add( new ProductManager(1,"bbb","local",123,"...."));
        productManagers.add( new ProductManager(2,"bbb","local",123,"...."));
        productManagers.add( new ProductManager(3,"bbb","local",123,"...."));
        productManagers.add( new ProductManager(4,"bbb","local",123,"...."));
        productManagers.add( new ProductManager(5,"bbb","local",123,"...."));

        File file = new File("src/ss17_IO_Binary/exercise/Product.csv");
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream =new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productManagers);
        } catch (FileNotFoundException e) {
            System.out.println("file ko tim thấy");
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("lỗi đóng file");
            }
        }
    }
}
