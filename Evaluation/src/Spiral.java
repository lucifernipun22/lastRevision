import java.io.*;
import java.util.Scanner;

class Spiral{
    static void spiralTraversal(int n,int m,int arr[][]){
        int i, k = 0, l = 0;
        int count = 0;
        int total = n * m;
        while (k < n && l < m){
            if (count == total)
                break;
            for (i = k; i < n; ++i){
                System.out.print(arr[i][l] + " ");
                count++;
            }
            l++;
            if (count == total)
                break;
            for (i = l; i < m; ++i){
                System.out.print(arr[n - 1][i] + " ");
                count++;
            }
            n--;
            if (count == total)
                break;
            if (k < n){
                for (i = n - 1; i >= k; --i)
                {
                    System.out.print(arr[i][m - 1] + " ");
                    count++;
                }
                m--;
            }
            if (count == total)
                break;
            if (l < m){
                for (i = m - 1; i >= l; --i){
                    System.out.print(arr[k][i] + " ");
                    count++;
                }
                k++;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for(int i =0;i<testCases;i++){
            int n= input.nextInt();
            int m= input.nextInt();
            int arr[][] = new int[n][m];
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    arr[j][k]= input.nextInt();
                }
            }
            spiralTraversal(n,m, arr);
        }

    }
}