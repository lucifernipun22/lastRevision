import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        int maxLength = 1;
        int start = 0;
        int length = string.length();
        int lowest, highest;
        for (int i = 1; i < length; i++) {
            lowest = i - 1;
            highest = i;
            while (lowest >= 0 && highest < length && string.charAt(lowest) == string.charAt(highest)) {
                if (highest - lowest + 1 > maxLength) {
                    start = lowest;
                    maxLength = highest - lowest + 1;
                }
                --lowest;
                ++highest;
            }
            lowest = i - 1;
            highest = i + 1;
            while (lowest >= 0 && highest < length && string.charAt(lowest) == string.charAt(highest)) {
                if (highest - lowest + 1 > maxLength) {
                    start = lowest;
                    maxLength = highest - lowest + 1;
                }
                --lowest;
                ++highest;
            }
        }
        System.out.println(maxLength);


    }


}