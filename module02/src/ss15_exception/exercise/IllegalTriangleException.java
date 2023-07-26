package ss15_exception.exercise;

import java.util.Scanner;

public class IllegalTriangleException extends Throwable {
   private String mess;

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String mess) {
        System.out.println(mess);
    }
}
