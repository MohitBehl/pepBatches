class Solution{
    public static class Person{
        String name = "abc";
        int age = 100;
        
        Person(){ // default constructor
            this.saysHi();
            System.out.println("instance created");
            name = "pep";
            age = 3;
        }
        
        // Person(String name , int age){
        //     this.name = name;
        //     this.age = age;
        // }

        void saysHi(){
            System.out.println(this.name+" --> "+this.age+" says hi.");
        }
    }
    public static void main(String args[]){
        // Person p3 = new Person("abcdef",15);
        // p3.saysHi();
        // System.out.println(Person);
        Person p1 = new Person();
        p1.saysHi();
        // p1.name = "abc";
        // p1.age = 1;

        // Person p2 = new Person();
        // p2.name = "def";
        // p2.age = 2;

        // p1.saysHi();
        // p2.saysHi();
        // game4(p1, p2);
        // p1.saysHi();
        // p2.saysHi();
        // p1.saysHi();
        // System.out.println(p1.name);
    }

    // public static void swap(Person p1 , Person p2){
    //     Person tmp = p1;
    //     p1 = p2;
    //     p2 = tmp;
    // }
    
    // public static void swap1(Person p1 , Person p2){
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public static void game1(Person p1 , Person p2){
    //     p1 = new Person();
    //     p2 = new Person();
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public static void game2(Person p2 , Person p1){
    //     String name = p1.name;
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public static void game3(Person p2 , Person p1){
    //     String name = p1.name;
    //     p1 = new Person();
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p1.age = p2.age;
    //     p2.age = age;
    // }

    // public static void game4(Person p2 , Person p1){
    //     String name = p1.name;
    //     p1 = new Person();
    //     p1.name = p2.name;
    //     p2.name = name;

    //     int age = p1.age;
    //     p2 = new Person();
    //     p1.age = p2.age;
    //     p2.age = age;
    // }
}