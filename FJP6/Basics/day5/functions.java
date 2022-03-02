import java.util.Scanner;
public class Main{
    public static void saysHello(){
        System.out.println("hello");
        for(int i = 1 ; i <= 5 ; i++){
            System.out.print(i+"->");
        }
        System.out.println();
        // return;
    }

    public static int add(int n1,int n2){
        return (n1+n2);
        // System.out.println(n1+n2);
    }
    public static int area(int l,int b){
        return (l*b);
    }

    public static int area(int side){
        return side*side;
    }
    public static void main(String args[]){
        // Scanner scn = new Scanner(System.in);

        // int n = scn.nextInt();
        // saysHello();
        // saysHello();
        // saysHello();
        // saysHello();
        // saysHello();
        // saysHello();


        // System.out.println(add(150,20));

        // int var = 10;

        // System.out.println(var)
    }
}