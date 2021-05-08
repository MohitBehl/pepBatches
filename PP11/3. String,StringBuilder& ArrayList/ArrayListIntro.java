import java.util.ArrayList;
public class ArrayListIntro {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println(list);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);

        System.out.println("val at 3 : " + list.get(3));
        // list[idx] it is wrong 
        list.remove(2);
        System.out.println(list);

        list.set(0,99);
        System.out.println(list);

        list.add(1,54);

        System.out.println(list);

        System.out.println(list.size());

        for(int val : list){
            System.out.print(val+" -> ");
        }
    }
}
