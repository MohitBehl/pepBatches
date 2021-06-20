import java.util.ArrayList;

public class L003 {
    public static class Person{
        String name;
        int age;
        
        public void saysHi(){
            // int n;
            // System.out.println(n);
            System.out.println(this.name + " ["+this.age+"] says hi");
        }
        
        // Person(){
        //     System.out.println("default constructor");
        //     name = "sample";
        //     age = 1;
        // }
        
        // Person(String n , int a){
        //     System.out.println("paramterized constructor");
        //     name = n;
        //     age = a;
  
        //     saysHi();
        // }

        // Person(String name,int age){
        //     System.out.println("paramterised constructor");
        //     this.name = name;
        //     this.age = age;
        // }
    }
            
            
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.saysHi();
        // Person p2 = new Person();
        // Person p = new Person("pepcoding",3);
    
        // p.saysHi();
        // Person p1 = new Person();
        // p1.name = "abc";
        // p1.age = 10;
        // Person p2 = new Person();
        // p2.name = "def";
        // p2.age = 20;
        
        // p1.saysHi();
        // p2.saysHi();
        // game4(p1, p2);
        // p1.saysHi();
        // p2.saysHi();
    
        // Person p1 = new Person();
        
        // // System.out.println(p1.name+" --> "+p1.age);
        
        // // System.out.println(p1);
        // p1.name = "abc";
        // p1.age = 10;
        // // p1.saysHi();
        
        // // saysHi();   
    }
    // public static void swap(Person p1 , Person p2){
    //     Person tmp = p1;
    //     p1 = p2;
    //     p2 = tmp;
    // }

    // public static void swap1(Person p1 , Person p2){
    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;

    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;
    // }

    // public static void game1(Person p1,Person p2){
    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    //     p1 = new Person();

    //     String name = p1.name;

    //     p1.name = p2.name;
    //     p2.name = name;
    //     p2 = new Person();
    // }

    // public static void game2(Person p1,Person p2){
    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;

    //     p1 = new Person();
    //     p2 = new Person();

    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;
    // }
    // public static void game3(Person p1,Person p2){
    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;

        
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;
        
    //     p1 = new Person();
    //     p2 = new Person();
    // }

    // public static void game4(Person p1,Person p2){
    //     p1 = new Person();
    //     p2 = new Person();

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;

        
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;
        
    // }
}
