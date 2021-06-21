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

        Iterator<Map.Entry<String ,Integer>> it= map.entrySet().iterator();

        while (it.hasNext()){
            Map.Entry<String,Integer> set = (Map.Entry<String,Integer>) it.next();
            System.out.println(set.getKey().length()>5);
        }
    }
}
