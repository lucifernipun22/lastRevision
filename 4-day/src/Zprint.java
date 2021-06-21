import java.util.*;


public class Zprint {

    static int SingleElement(int arr[], int n) {
        int low = 0, high = n - 2;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int k=0;k<testCases;k++){
            int size = input.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = input.nextInt();
            }
            Arrays.sort(arr);

            System.out.println(SingleElement(arr, size));
        }

    }
}



