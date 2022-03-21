/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1 , right = n;
        
        while(left <= right){
            int randomNum = left+(right-left)/2;
            
            if(guess(randomNum) == 0){
                return randomNum;
            }else if(guess(randomNum) == 1){
                left = randomNum+1;
            }else{
                // -1
                right = randomNum-1;
            }
        }
        
        return -1;
    }
}   