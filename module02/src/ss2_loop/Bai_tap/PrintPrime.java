package ss2_loop.Bai_tap;

public class PrintPrime {
    public static void main(String[] args) {
        for (int i = 2; i < 22; i++) {
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
