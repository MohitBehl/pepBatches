import java.io.*;
import java.util.*;

public class Main {

    public static int[] input(int n, Scanner scn) {
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int arr1[] = input(scn.nextInt(), scn);

        int arr2[] = input(scn.nextInt(), scn);

        // ArrayList < Integer > commonElements = getCommonElements1(arr1, arr2);
        ArrayList < Integer > commonElements = getCommonElements2(arr1, arr2);

        print(commonElements);
    }

    public static ArrayList < Integer > getCommonElements1(int arr1[], int arr2[]) {
        HashMap < Integer, Integer > freqMap = new HashMap < > ();

        // build freqMap using arr1
        for (int val: arr1) {
            if (freqMap.containsKey(val)) {
                // update
                freqMap.put(val, freqMap.get(val) + 1);
            } else {
                // insert
                freqMap.put(val, 1);
            }
        }

        ArrayList < Integer > commonElements = new ArrayList < > ();

        // consume freqMap using arr2
        for (int val: arr2) {
            if (freqMap.containsKey(val)) {
                // System.out.println(val);
                commonElements.add(val);
                freqMap.remove(val);
            }

            if (freqMap.size() == 0) {
                break;
            }
        }

        return commonElements;
    }

    public static ArrayList < Integer > getCommonElements2(int arr1[], int arr2[]) {
        HashMap < Integer, Integer > freqMap = new HashMap < > ();

        // build freqMap using arr1
        for (int val: arr1) {
            if (freqMap.containsKey(val)) {
                // update   
                freqMap.put(val, freqMap.get(val) + 1);
            } else {
                // insert
                freqMap.put(val, 1);
            }
        }

        ArrayList < Integer > commonElements = new ArrayList < > ();

        // consume freqMap using arr2
        for (int val: arr2) {
            if (freqMap.containsKey(val) && freqMap.get(val) > 0) {
                commonElements.add(val);
                freqMap.put(val,freqMap.get(val)-1);
            }

            if (freqMap.size() == 0) {
                break;
            }
        }

        return commonElements;
    }
    public static void print(ArrayList < Integer > commonElements) {
        for (int val: commonElements) {
            System.out.println(val);
        }
    }

}