import java.util.*;

public class India {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfCountry = input.nextInt();
        String str = input.next();
        HashMap<String , Integer> map = new HashMap<>();
        for(int i=0;i<numberOfCountry;i++){
            map.put(str,i);
            if(map.containsKey("India")){
                System.out.println(map.get("India"));
            }
        }



    }
}




