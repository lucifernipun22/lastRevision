import java.util.Scanner;

public class GenerateAllSubstring {


        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int testCase = input.nextInt();
            for(int i=0;i<testCase;i++) {
                int n = input.nextInt();
                String string1 = input.next();
                subsequence2(string1);
            }
        }
        static void subsequence2(String string1) {
            int index = -1;
            String string2 = "";
            subsequence1(string1, string1.length(), index, string2);
        }
        static void subsequence1(String string1, int n, int index, String string2) {
            if (index == n) {
                return;
            }
            if (string2 != null && ! string2.isEmpty()) {
                System.out.print(string2);
                System.out.println();
            }
            for (int i = index + 1; i < n; i++) {
                string2 += string1.charAt(i);
                subsequence1(string1, n, i, string2);
                string2 = string2.substring(0, string2.length() - 1);
            }

        }
    }
