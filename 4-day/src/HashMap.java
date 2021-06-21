import java.util.Iterator;
import java.util.Map;

public class HashMap {

    public static void main(String[] args) {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        map.put("Nipun", 1);
        map.put("Lloyd", 2);
        map.put("Nrupul", 3);
        map.put("Prateek", 4);
        map.put("Yogesh", 5);

        /*map.entrySet().removeIf(entry -> entry.getKey().length() >= 6);
        System.out.println(map);*/                                                 //Remove all key-value where key length >=6 and print all the eelnt after remove

        /*for (Map.Entry<String, Integer> ans: map.entrySet())                                      //Print all the key-value
            System.out.println("Name is :"+ans.getKey() +"\n" + "Roll no is :"+ans.getValue());*/
/*
        for (Map.Entry<String, Integer> ans2 : map.entrySet())
            if (ans2.getKey().length() > 5)                           //Print the value whose key length>5
                System.out.println(ans2.getValue());*/

       /* Iterator<Map.Entry<String, Integer>> ans3 = map.entrySet().iterator();
        while(ans3.hasNext()) {

                    Map.Entry<String ,Integer> ans4 = ans3.next();
                    if(ans4.getKey().length()>=6){
                        ans3.remove();

                    }
            }
        System.out.println(map);*/                                     //Remove all key-value where key length >=6 and print all the elements after removing
        }


    }



