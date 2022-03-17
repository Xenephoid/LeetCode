package home;
import java.lang.Math;
import java.util.Arrays;
/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * main class is just to test my code
 * the idea behind this code is that you can split an array based on whether it is even or odd
 * if it is even, you can split it into left and right
 * if it is odd, you can split it into left, middle (will just be the one element in the middle), and right
 * then find the minimum of left or right and compare to see whether left(, middle) or right have the smallest number
 * and the recursion will go down until each array becomes size 1
 * the idea is kind of like merge sorting except you don't have to recombine the arrays
 */
public class MinimumSortedArray {
	public static void main(String[] args) {
		System.out.println(findMin(new int[] {3,4,5,1,2}));
	}
	public static int findMin(int[] nums) {
		if(nums.length == 1)
            return nums[0];
        else{
            int len = nums.length;
            int left, right;
            if(len % 2 == 0){ // len/2 will be to the right of middle
            	left = findMin(Arrays.copyOfRange(nums, 0, len/2));
            	right = findMin(Arrays.copyOfRange(nums, len/2, len));
            	return Math.min(left,right);
            }
            else{ // (len-1)/2 will be the middle 
                left = findMin(Arrays.copyOfRange(nums, 0, (len-1)/2));
            	right = findMin(Arrays.copyOfRange(nums, (len-1)/2+1, len));
            	return Math.min(left, Math.min(nums[(len-1)/2], right));
            }
        }
    }
}