import java.util.List;


public class ArrayItem2 {

    public static void main(String[] args) {
        //List<List<String>> items  = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]];
        String ruleKey = "type";
        String ruleValue = "phone";
        //countMatch(items, ruleKey, ruleValue);
    }

    public static int countMatch(List<List<String>> items, String ruleKey, String rulesValue) {
        int count = 0;
        for (List<String> list : items) {
            if (ruleKey.equals("type") && rulesValue.equals(list.get(0)))
                count++;
            else if (ruleKey.equals("color") && rulesValue.equals(list.get(1)))
                count++;
            else if (ruleKey.equals("name") && rulesValue.equals(list.get(2)))
                count++;
        }
        return count;
    }
}
