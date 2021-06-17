import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arraylist {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Nipun");
        list.add("Lloyd");
        list.add("Nrupul");
        list.add("Prateek");
        list.add("Yogesh");

        


        System.out.println(list); // all list print


        list.remove(2);                 // remove 2 index
        System.out.println(list);

        list.set(3,"Masai");
        System.out.println(list);         // replace 3 element


    }


}
