package ss2_loop.Bai_tap;

public class Print {
    public static void main(String[] args) {
        System.out.println("hình chữ nhật");
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
        
        System.out.println("tam giác vuông");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= j) {
                    System.out.print(" * ");
                }
            }
            System.out.println("");
        }

        System.out.println("tam giác vuông ngược");
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < 5; j++) {
                if (j < i) {
                    System.out.print(" * ");
                }
            }
            System.out.println("");
        }

    }
}
