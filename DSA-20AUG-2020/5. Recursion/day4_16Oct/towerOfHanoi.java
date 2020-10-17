import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // no. of disk
        
        int t1id = scn.nextInt();
        int t2id = scn.nextInt();
        int t3id = scn.nextInt();
        
        toh(n , t1id , t2id , t3id);
    }

    public static void toh(int n, int src, int dest, int helper){
        if(n == 0){
            return;
        }    
    
        // fath1 : move n-1 disks from src tower to helper tower.
        toh(n-1,src,helper,dest);
        
        // my work : move nth disk from src to dest
        System.out.println(n+"["+src+" -> "+dest+"]");
        
        // faith2 :  move n-1 disks from helper tower to dest tower
        toh(n-1,helper,dest,src);
        
    }

}