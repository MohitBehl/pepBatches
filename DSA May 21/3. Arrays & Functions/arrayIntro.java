import java.util.Arrays;

public class arrayIntro {
        public static void main(String[] args) {
            int arr[] = {10,20,3,6,4};

            for(int idx = 0 ; idx < arr.length ; idx++){
                System.out.println(idx +" --> "+arr[idx]);
            }

            int arr1[] = new int[4];
            arr1[0] = 10;
            arr1[2] = 40;
            arr1[3] = 55;

            System.out.println(Arrays.toString(arr1));

            for(int val : arr1){
                System.out.println(val);
            }

            System.out.println("len : " + arr.length);
        }
}
