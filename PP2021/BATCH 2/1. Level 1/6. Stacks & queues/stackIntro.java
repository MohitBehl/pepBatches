import java.util.Stack;
public class stackIntro {
    public static class Person{
        String name;
        int age;

        // Person(String n , int a){
        //     name = n;
        //     age = a;
        // }

        void saysHi(){
            System.out.println("name : "+name + " age : "+age);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "pepcoding";
        p1.age = 3;
        p1.saysHi();

        Person p2 = new Person();
        p2.name = "abc";
        p2.age = 10;
        p2.saysHi();
        // Stack<Integer> st = new Stack<>();

        // System.out.println(st);

        // st.push(10);
        // st.push(20);
        // st.push(30);

        // System.out.println(st);
        
        // System.out.println(st.peek());

        // System.out.println("pop : "+st.pop());
        // System.out.println(st);

        // System.out.println(st.size());
        // direct access not allowed



    }
}
