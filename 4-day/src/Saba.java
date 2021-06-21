import java.util.*;

class Saba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int row = sc.nextInt();
        int column = sc.nextInt();
        String string[] = new String[row];
        for (int i = 0; i < row; i++) {
            string[i] = sc.next();

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((j + 3) < column && string[i].charAt(j) == 's' && string[i].charAt(j + 1) == 'a'
                        && string[i].charAt(j + 2) == 'b' && string[i].charAt(j + 3) == 'a')
                    count++;
                if ((i + 3) < row && string[i].charAt(j) == 's' && string[i + 1].charAt(j) == 'a'
                        && string[i + 2].charAt(j) == 'b' && string[i + 3].charAt(j) == 'a')
                    count++;
                if ((i + 3) < row && (j + 3) < column && string[i].charAt(j) == 's' &&
                        string[i + 1].charAt(j + 1) == 'a' && string[i + 2].charAt(j + 2) == 'b'
                        && string[i + 3].charAt(j + 3) == 'a')
                    count++;
                if ((i - 3) >= 0 && (j + 3) < column && string[i].charAt(j) == 's' &&
                        string[i - 1].charAt(j + 1) == 'a' && string[i - 2].charAt(j + 2) == 'b' &&
                        string[i - 3].charAt(j + 3) == 'a')
                    count++;
            }
        }
        System.out.println(count);
    }
}