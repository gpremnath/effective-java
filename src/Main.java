import java.util.*;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

        int arr[]={1,2,3,2,3,1,4,5,4};

        List names = new ArrayList();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        names.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        eval(list, n -> n - 2 == 0);
    }


    public static void eval(List<Integer> list, Predicate<Integer> predicate) {




        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
