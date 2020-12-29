class PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        printEncodings(str, "");
    }

    static char encoder[] = {
        ' ',
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z'
    };

    public static void printEncodings(String str, String asf) {
        if (str.length() == 0) {
            // decoding successfull
            System.out.println(asf);
            return;
        }

        char fc = str.charAt(0);
        if (fc == '0') {
            // invalid case
            return;
        }

        // single digit encoding
        printEncodings(str.substring(1), asf + encoder[fc - '0']);

        if (str.length() > 1) {
            char sc = str.charAt(1);
            int idx = Integer.parseInt("" + fc + sc);

            if (idx >= 1 && idx <= 26) {
                printEncodings(str.substring(2), asf + encoder[idx]);
            }
        }
    }
}


public class PrintPermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        printPermutations(str, "");
    }

    public static void printPermutations(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String lp = str.substring(0, i);
            String rp = str.substring(i + 1);
            String roq = lp + rp;

            printPermutations(roq, asf + ch);
        }
    }

}


public class PrintMazePaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        printMazePaths(0, 0, nr - 1, nc - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        if (sr > dr || sc > dc) {
            return;
        }

        // horizontal movement 
        printMazePaths(sr, sc + 1, dr, dc, psf + "h");

        // v. movement
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");
    }

}



public class PrintStairPaths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }

        if (n < 0) {
            // invalid call
            return;
        }

        // 1 len
        printStairPaths(n - 1, path + "1");

        // 2 len
        printStairPaths(n - 2, path + "2");

        // 3 len
        printStairPaths(n - 3, path + "3");
    }

}



public class PrintKPC {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String ques = scn.nextLine();
        printKPC(ques, "");
    }

    static String keypad[] = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };

    public static void printKPC(String ques, String asf) {
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        int idx = ch - '0'; //  char --> int

        String word = keypad[idx];
        String roq = ques.substring(1);
        for (int i = 0; i < word.length(); i++) {
            printKPC(roq, asf + word.charAt(i));
        }
    }

}



public class PrintSubsequences {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String ques = scn.nextLine();

        printSS(ques, "");
    }

    public static void printSS(String ques, String asf) {
        if (ques.length() == 0) {
            // all characters have been processed
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        // include
        printSS(roq, asf + ch);

        // not-include
        printSS(roq, asf);
    }

}