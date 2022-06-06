public class Main{
    public static class Person{
        int age;
        String name;
        Person(){
            System.out.println("instance");
            name = "-";
            age = 1;
        }
        Person(String name,int age){
            System.out.println("parmeterized");
            this.name = name;
            this.age = age;
        }
        public void saysHi(){
            System.out.println(name+"["+age+"]"+" hello");
        }
    }
    public static void main(String args[]){
        Person p1 = new Person("pep",3);
        p1.saysHi();
        // p1.name = "pep";
        // p1.age = 3;
        // Person p2 = new Person();
        // p2.saysHi();
        // p2.name = "abc";
        // p2.age = 4;
        // game5(p1,p2);
        // p1.saysHi();
        // p2.saysHi();


        // p1.saysHi();
        // p1.saysHi();
    }
    public static void game1(Person p1,Person p2){
        Person tmp = p1;
        p1 = p2;
        p2 = tmp;
    }
     public static void game2(Person p1,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
    public static void game3(Person p1,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;
        
        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
        p1 = new Person();
        p2 = new Person();
    }   
    public static void game4(Person p1,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;
        
        p1 = new Person();
        p2 = new Person();

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
    public static void game5(Person p1,Person p2){
        p2 = new Person();
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;
        
        p1 = new Person();
        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
}