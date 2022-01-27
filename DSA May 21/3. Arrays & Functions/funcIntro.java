public class funcIntro{
    public static void main(String[] args) {
        int n = 5 , r = 3;

        int factN = fact(n);
        int factR = fact(r);
        int factNmr = fact(n-r);

        System.out.println(factN/(factR*factNmr));
    }

    public static int fact(int num){
        int res = 1;
        for(int i = 1 ; i <= num ;i++){
            res = res * num;
        }
        return res;
    }
}