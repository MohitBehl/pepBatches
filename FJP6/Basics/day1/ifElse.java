import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num = scn.nextInt(); // input

        // process
        int rem = num%2;
        if(rem == 1){ // number is odd
            System.out.println("Number is odd "+num);
        }else{
            System.out.println("Number is even "+num);
        }
    }
}