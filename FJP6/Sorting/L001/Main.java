// https://leetcode.com/problems/sort-an-array/
class Solution {
    public int[] sortArray(int[] nums) {
       selectionSort(nums);
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
                if(arr[mIdx] > arr[i]) mIdx = i;
            }
            swap(nums, mIdx, itr-1);
        }
    }

    public static void bubbleSort(int nums[]){
        
    }
}
