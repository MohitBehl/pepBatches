
import java.util.*;

public class TOH {

    public static void main(String[] args) throws Exception {
       
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int src = scn.nextInt();
       int dest = scn.nextInt();
       int helper = scn.nextInt();
       
       toh(n,src,dest,helper);
    }

    public static void toh(int n, int src, int dest, int helper){
        if(n == 0){
            return;
        }
        toh(n-1,src,helper,dest);
        System.out.println(n+"["+src+" -> "+dest+"]");
        toh(n-1,helper,dest,src);
    }

}