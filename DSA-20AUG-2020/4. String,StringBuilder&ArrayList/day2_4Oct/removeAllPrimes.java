import java.io.*;
import java.util.*;

public class Main {

    public static void solution(ArrayList < Integer > al) {

        for (int i = al.size() - 1; i >= 0; i--) {
            int val = al.get(i);

            if (isprime(val)) {
                //  val needs to be deleted
                al.remove(i);
            }
        }

    }

    public static boolean isprime(int val) {
        for (int fac = 2; fac * fac <= val; fac++) {
            if (val % fac == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < Integer > al = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
        System.out.println(al);
    }

}