
import java.util.HashSet;
import java.util.Scanner;

public class DistinctAgain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= input.nextInt();
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!hashSet.contains(arr[i])) {
                sum += arr[i];
                hashSet.add(arr[i]);
            }
        }
        System.out.println(sum);
    }
}

