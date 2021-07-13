import java.util.*;
import java.lang.*;
class test {
    static void generatePermutation(int arr[], int n2, int n){
        if (n2 == 1){
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
        for (int i = 0; i < n2; i++) {
            generatePermutation(arr, n2 - 1, n);
            if (n2 % 2 == 1) {
                int temp = arr[0];
                arr[0] = arr[n2 - 1];
                arr[n2 - 1] = temp;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[n2 - 1];
                arr[n2 - 1] = temp;
            }
        }
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        generatePermutation(arr,n, n);
    }
}

