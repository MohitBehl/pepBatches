public class batch{
    public static void swap1(Person p1 , Person p2){
        Person tmp = p1;
        p1 = p2;
        p2 = tmp;
    }
    public static void swap2(Person p1 , Person p2){
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;

        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }
    public static void game1(Person p1,Person p2){
        String name = p1.name;
        p1 = new Person();
        p1.name = p2.name;
        p2.name = name;

        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }
    public static void game2(Person p1,Person p2){
        String name = p1.name;
        p1.name = p2.name;
        p1 = new Person();
        p2.name = name;

        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }
    public static void game3(Person p1,Person p2){
        p1 = new Person();
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;

        p2 = new Person();
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }
    public static void game4(Person p1,Person p2){
        p1 = new Person();
        p2 = new Person();
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }    
    public static void main(String args[]){
        // Person p1 = new Person();
        // p1.name = "abc";
        // p1.age = 3;        
        // Person p2 = new Person();
        // p2.name = "def";
        // p2.age = 4;
        
        // p1.saysHi();
        // p2.saysHi();      
        // game4(p1,p2);
        // p1.saysHi();
        // p2.saysHi(); 

        // Area o1 = new Area();
        // // System.out.println(o1.calc());
        // o1.setLen(10);// o1.l = 25;       
        // System.out.println(o1.calc());

        Person o1 = new Person();
        o1.name = "abc";
        o1.age = 2;
        o1.count = 15;
        o1.saysHi();

        Person o2 = new Person();
        o2.count = 10;

        o1.saysHi();

        
        // System.out.println(Person.count);

        // Person p = new Person("pep",3);
        // p.saysHi();
        // Person obj = new Person();
        // obj.saysHi();
    }
    public static class Person{
        int age = 1000;
        String name;
        static int count;

        // Person(){
        //     System.out.println("welcome");
        // }

        // Person(String name , int age){
        //     this.name = name;
        //     this.age = age;
        // }

        void saysHi(){
            System.out.println("name : "+name+" age : "+age +" says hi --> "+count);
        }
    }
}
class Area{
    private int l = 5;
    private int b = 2;


    int calc(){
        return l*b;
    }
    void setLen(int n){
        l = n;       
    }
}