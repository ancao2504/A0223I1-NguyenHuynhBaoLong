package ss3_Array_Method.Thuc_hanh;

public class MinVal {
    public static void main(String[] args) {
        int[] array = {10,6,9,8,19};
        int result = minVal(array);
        System.out.println("Min value in array is "+ result);
    }

    public static int minVal (int[] arr) {
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
