import java.util.Scanner;

public class IsEvenSumPossible {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        int sum =0;
        for (int k=0;k<testCases;k++){
            int length = input.nextInt();
            int arr[] = new int[length];
            for (int i=0;i<length;i++){
                arr[i]= input.nextInt();
            }

            for(int i=0;i<length;i++){
                sum += arr[i];
                if(sum%2!=0){
                    System.out.println("No");
                    break;
                }else {
                    System.out.println("Yes");
                    break;
                }
            }
        }

    }

}
