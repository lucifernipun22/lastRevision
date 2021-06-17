import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveElement {


    public static void main(String[] args) {

        int n = 5;
        int arr[] = {1,2,3,4,5};
        int index1 = 0;
        int index2 = n-1;
        int index3 = 3;
        removIndex1(arr,index1);
        removIndex2(arr,index2);
        removIndex3(arr,index3);
    }

    private static void removIndex3(int arr[],int index3) {
        List<Integer> arrayList = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toList());

            arrayList.remove(index3);
        System.out.println(arrayList);



    }

    private static void removIndex2(int arr[],int index2) {
        List<Integer> arrayList = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toList());

        arrayList.remove(index2);
        System.out.println(arrayList);
    }

    private static void removIndex1(int arr[],int index1) {
        List<Integer> arrayList = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toList());

        arrayList.remove(index1);
        System.out.println(arrayList);
    }

}
