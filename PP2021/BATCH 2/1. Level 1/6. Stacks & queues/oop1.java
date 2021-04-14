public class oop1{
    
    public static class Person{
        String name;
        int age;
        static int count;

        Person(){
            System.out.println("welcome ");
        }

        Person(String n , int a){
            name  = n;
            age = a;
        }

        void saysHi(){
            System.out.println(name+" @ "+age + " says hi");
        }
    }

    public static void main(String args[]){
        // Person p1 = new Person("abc",3);
        p1.name = "abc";
        p1.age = 3;
        // p1.saysHi();
        // p1.count = 15;

        Person p2 = new Person();
        // p2.name = "def";
        // p2.age = 22;
        // p2.count = 125;
        // System.out.println(p1.count);
        // System.out.println(p2.count);

        // System.out.println(Person.count);
        // // p1.saysHi();
        // // p2.saysHi();
        // // game2(p1,p2);
        // // p1.saysHi();
        // // p2.saysHi();
    }
    // public static void swap1(Person p1 , Person p2){
    //     Person p3 = p1;
    //     p1 = p2;
    //     p2 = p3;
    // }

    // public static void swap2(Person p1 , Person p2){
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public static void game1(Person p1 , Person p2){
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p1 = new Person();
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public  static void game2(Person p1 , Person p2){
    //     p1 = new Person();
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;

    //     p2 = new Person();
    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

}