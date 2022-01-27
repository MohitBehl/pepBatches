import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;


public class Sample {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String wordsInLine[] = line.split(" ");
        System.out.println(Arrays.toString(wordsInLine));
    }
}
