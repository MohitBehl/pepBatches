public class ArraysIntro1d{
    public static void main(String args[]){
        int n = 5;
        int arr[] = new int[n];
        
        arr[0] = 10;
        arr[2] = 99;
        arr[3] = 15;
        arr[4] = 21;
        // arr[idx] = scn.nextInt();
        for(int idx = 0 ; idx < arr.length ; idx++){
            System.out.println(idx +" --> "+ arr[idx]);
        }
        
        for(int val : arr){
            System.out.println(val);
        }
        
        System.out.println(arr.length);
    }
}