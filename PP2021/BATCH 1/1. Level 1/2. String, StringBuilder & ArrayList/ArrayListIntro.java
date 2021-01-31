import java.util.*;

public class Main {

    public static void main(String[] args) {

        // declaration + memory allocation

        ArrayList < Integer > list = new ArrayList < Integer > ();

        System.out.println(list);
        // [idx] : not possible in ArrayList
        list.add(10);
        System.out.println(list);
        list.add(20);
        System.out.println(list);
        list.add(30);
        System.out.println(list);
        list.add(40);
        System.out.println(list);


        for (int val: list) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (int idx = 0; idx < list.size(); idx++) {
            System.out.println(idx + " --> " + list.get(idx));
        }
        System.out.println("COMPLETE LIST : " + list);

        System.out.println("Element removed : " + list.remove(2));

        System.out.println("COMPLETE LIST : " + list);

        list.set(0, 100); // update

        System.out.println(list);

        list.add(0, 50);
        System.out.println(list);
    }
}