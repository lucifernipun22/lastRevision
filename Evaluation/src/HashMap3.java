import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap3 {

    public static void main(String[] args) {
        HashMap<String, Integer> map= new HashMap<>();
        map.put("Nipun",1234567890);
        map.put("Lloyd",1093803930);
        map.put("Yogesh",1898380398);
        map.put("Nrupul",1083979474);
        map.put("Prateek",1299349898);

//Print the value whose key length>5
       /* for(Iterator<Map.Entry<String ,Integer>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<String ,Integer> entry = it.next();
            if(entry.getKey().length()>5){
                System.out.println(entry.getKey());
            }

        }*/


        /*map.entrySet().removeIf(entry -> entry.getKey().length()>=6);
        System.out.println(map);*/                    //Remove all key-value where key length >=6 and print all the elements after removing
    }
}
