public class RecursionOnTheWayUp{
    public static void main(String[] args) {
        printSS("abc","",0);
        printSS1("abc","");
    }
    public static void printSS(String str, String asf,int idx) {
        if(idx == str.length()){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(idx);
        
        printSS(str,asf+ch,idx+1);
        printSS(str,asf,idx+1);
    }

    public static void printSS1(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = str.charAt(0);
        String roq = str.substring(1);
        
        printSS1(roq,asf+ch);
        printSS1(roq,asf);
    }
}