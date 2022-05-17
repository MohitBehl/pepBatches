// https://leetcode.com/problems/sort-an-array/
import java.util.*;
class Solution {
    public int[] sortArray(int[] nums) {
       bubbleSort(nums);
       return nums;
    }
    public static void swap(int nums[],int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void selectionSort(int nums[]){
        int n = nums.length;
        for(int itr = 1 ; itr <= n-1 ; itr++){
            int mIdx = itr-1;
            for(int i = itr ; i < n ; i++){
                if(nums[mIdx] > nums[i]) mIdx = i;
            }
            swap(nums, mIdx, itr-1);
        }
    }

    public static void bubbleSort(int nums[]){
        int n = nums.length;
        for(int itr = 1 ; itr <= n-1 ; itr++){
            for(int i = 0 ; i <= n - 1 - itr ; i++){
                if(nums[i+1] < nums[i]){
                    swap(nums, i, i+1);
                }
            }
        }
    }

    public static void insertionSort(int nums[]){
        int n = nums.length;
        for(int itr = 1 ; itr <= n-1 ; itr++){
            for(int idx = itr ; idx > 0 ; idx--){
                if(nums[idx] < nums[idx-1]){
                    swap(nums, idx, idx-1);
                }else{
                    break;
                }   
            }
        }
    }
    
}
