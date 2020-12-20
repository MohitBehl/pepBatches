public class removePrime {
    public static void solution(ArrayList < Integer > al) {
        for(int i = al.size()-1 ; i >= 0 ; i--){
            if(isPrime(al.get(i))){
                al.remove(i);
            }   
        }

    }

    public static boolean isPrime(int num) {
        for (int div = 2; div * div <= num; div++) {
            if (num % div == 0) {
                // extra factor exists --> not a prime
                return false;
            }
        }
        // implication : 2 -> sqrt(num) there is no possible extra-factor (is a prime)
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
