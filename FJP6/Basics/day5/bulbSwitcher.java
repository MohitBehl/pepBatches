class Solution {
    public int bulbSwitch(int n) {
        // main logic
        int count = 0;
        for(int i = 1 ; i*i <= n ; i++){
            System.out.println(i*i);
            count++;
        }
        
        return count;
    }
}