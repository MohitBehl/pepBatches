import java.util.ArrayList;
import java.util.Scanner;

public class RecursionWithArrayList {
    public static ArrayList < String > gss(String str) {
        if (str.length() == 0) {
            // empty string
            ArrayList < String > bl = new ArrayList < > ();
            bl.add("");

            return bl;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList < String > rres = gss(ros);

        ArrayList < String > myList = new ArrayList < > ();

        for (String s: rres) {
            myList.add(s);
        }

        for (String s: rres) {
            myList.add(ch + s);
        }

        return myList;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        System.out.println(gss(str));
    }
}
