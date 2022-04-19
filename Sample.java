import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;

public class Sample {
    public static class Pair implements Comparable<Pair>{
        int v1;
        int v2;
        Pair(int v1,int v2){
            this.v1 = v1;
            this.v2 = v2;
        }

        public int compareTo(Pair o){
            return this.v2-o.v2;
        }

        public String toString(){
            return v1+"-"+v2;
        }
    }
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // String wordsInLine[] = line.split(" ");
        // System.out.println(Arrays.toString(wordsInLine));

        // int [][]arr = {{1,15},{2,10},{2,6},{1,11}};
        // Arrays.sort(arr,(a,b) -> {return a[1] - b[1];});

        // for(int a[] : arr){
        //     System.out.println(Arrays.toString(a));
        // }
        // Scanner
        Pair arr[] = new Pair[4];
        arr[0] = new Pair(1,15);
        arr[1] = new Pair(2,10);
        arr[2] = new Pair(2,6);
        arr[3] = new Pair(1,11);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}