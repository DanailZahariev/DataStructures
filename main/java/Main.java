import implementations.ArrayList;
import interfaces.List;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("one");
        names.add("2");
        names.add("3");
        names.add("4");
        names.add("five");

        names.add(2,"Hello");
        names.add(5,"Hello again");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));
        System.out.println(names.get(3));
        System.out.println(names.get(4));
        System.out.println(names.get(5));


    }
}