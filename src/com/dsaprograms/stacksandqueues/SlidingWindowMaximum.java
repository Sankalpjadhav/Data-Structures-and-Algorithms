package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;

/*
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:
Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int [] result = maxSlidingWindow(nums,k);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // First find out next greater element index for all the elements of nums.
        int [] nextGreater = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(nextGreater.length-1);
        nextGreater[nextGreater.length-1] = nextGreater.length;
        for(int i=nextGreater.length-2;i>=0;i--){
            while(stack.size()>0 && nums[i]>nums[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreater[i] = nextGreater.length;
            }
            else{
                nextGreater[i] = stack.peek();
            }
            stack.push(i);
        }
        int j=0;
        int [] result = new int[nums.length-k+1];  // Resultant array size will be (nums.length - k + 1).
        for(int i=0;i<=nums.length-k;i++){
            if(j<i){
                j=i;
            }

            while(nextGreater[j]<i+k){
                j = nextGreater[j];
            }

            result[i]=nums[j];
        }
        return result;
    }

}
