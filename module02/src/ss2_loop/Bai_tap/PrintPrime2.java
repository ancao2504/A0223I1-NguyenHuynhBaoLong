package ss2_loop.Bai_tap;

public class PrintPrime2 {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            boolean check = true;
            int j = 2;
            while (j <= Math.sqrt(i)) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
                j++;
            }
            if (check) {
                System.out.println(i);
            }
        }
    }
}
