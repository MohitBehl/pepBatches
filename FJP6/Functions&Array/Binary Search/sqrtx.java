class Solution {
    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }   
        
        int left = 2 , right = x/2;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            long currSquare = (long)mid*mid;
            if(currSquare > x){
                right = mid - 1;
            }else if(currSquare < x){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        
        return right;
    }
}   