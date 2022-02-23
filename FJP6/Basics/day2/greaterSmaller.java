import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt(); // num1 ki input
        int n2 = scn.nextInt(); // num2 ki input

        if(n1 == n2){
            System.out.println("Both are equal");
        }else if(n1 > n2){
            System.out.println("n1 is greater than n2");
        }else{
            System.out.println("n1 is smaller than n2");
        }
    }
}
