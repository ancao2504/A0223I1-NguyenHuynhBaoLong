package ss3_Array_Method.Bai_tap;

public class GopMang {
    public static void main(String[] args) {
        int[] arr1 = {10, 9, 8, 13, 2};
        int[] arr2 = {1, 2, 3, 4, 0};
        int length = arr1.length + arr2.length;
        int[] arr = new int[length];

        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr[i + arr1.length] = arr2[i];
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
