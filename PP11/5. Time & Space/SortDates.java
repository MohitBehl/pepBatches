import java.util.Scanner;
public class SortDates{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        String dates[] = new String[n];
        for(int i = 0 ; i < n ; i++){
            dates[i] = scn.next();
        }

        countSort(dates,1);
        countSort(dates,2);
        countSort(dates,3);

        for(int i = 0 ; i < dates.length ; i++){
            System.out.println(dates[i]);
        }
    }

    public static void countSort(String []dates,int iden){
        int psa[]; // prefix sum array
        int div,mod;
        if(iden == 1){ // day
            psa = new int[32]; // a month has 31 days
            div = 1000000;
            mod = 100;
        }else if(iden == 2){ // month
            psa = new int[13]; // a year has 12 months
            div = 10000;
            mod = 100;
        }else { // year
            psa = new int[2501]; // there can be maximum of 2500 years
            div = 1;
            mod = 10000;
        }

        for(String date : dates){
            int num = Integer.parseInt(date);        
            int idx = (num/div)%mod;
            psa[idx]++;
        }

        for(int i = 1 ; i < psa.length ; i++){
            psa[i] += psa[i-1];
        }

        String res[] = new String[dates.length];
        for(int i = dates.length-1 ; i >= 0 ; i--){
            int num = Integer.parseInt(dates[i]);
            int idx = (num/div)%mod;
            int pos = psa[idx]--;
            res[pos-1] = dates[i];
        }

        for(int i = 0 ; i < dates.length ; i++){
            dates[i] = res[i];
        }
    }
}