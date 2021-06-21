import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class HashSet {

    public static void main(String[] args) {
        java.util.HashSet<String> set = new java.util.HashSet<>();



        set.add("India");
        set.add("Pak");
        set.add("China");
        set.add("India");
        set.add("Aus");
        set.add("Pak");
        set.add("Japan");

        System.out.println(set);  //Print all the elements after adding all the elements

        if(set.toString().length()>5){
            System.out.println(set);
        }

        /* set.remove("India");
        System.out.println(set); */       //Remove the object "India"


    }

}
