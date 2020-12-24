/**
 * longestConsecutiveSequence
 */
public class longestConsecutiveSequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // logic 

        HashMap < Integer, Boolean > hm = new HashMap < > ();

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], true);
        }

        for (int key: hm.keySet()) {
            if (hm.containsKey(key - 1)) {
                hm.put(key, false);
            }
        }

        int rStartingPoint = -1, rCount = -1;
        for (int idx = 0; idx < arr.length; idx++) {
            int val = arr[idx];
            if (hm.get(val)) {
                // starting point found
                int lStartingPoint = val, lCount = 1;

                while (hm.containsKey(lStartingPoint + lCount)) {
                    lCount++;
                }

                if (lCount > rCount) {
                    rStartingPoint = lStartingPoint;
                    rCount = lCount;
                }
            }
        }

        for (int i = 0; i < rCount; i++) {
            System.out.println(rStartingPoint + i);
        }
    }
    
}