public class Main {
    public static void printIncreasing(int n){
        if(n == 0) return;

        printIncreasing(n-1); // faith
        System.out.println(n);
    }
    public static void printDecreasing(int n){

    }
    public static void main(String[] args) {
        printIncreasing(5); // 1 2 3 4 5
        printDecreasing(5); // 5 4 3 2 1
    }
}
