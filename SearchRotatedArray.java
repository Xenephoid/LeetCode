package home;

/* https://leetcode.com/problems/search-in-rotated-sorted-array/
 * if we take the first and middle value of an array, there are two possible subarrays for the target to be in
 * if first < middle and target is in between, then it must be in the first half, else it will be in the second half
 * if first > middle then there must be a reset so if target is greater than first or less than middle it will be
 * in the first half
 * keep the same array since it is cheaper and manipulate the subarray that we are evaluating, which will be from 
 * begin to end-1, as end will be one greater than the index of the last element in the sub array since it is initially
 * the length of the array 
 * treat reset as when the value of nums[i+1] < nums[i] since the array is sorted initially
 */
public class SearchRotatedArray {
	public static void main(String[] args) {
		System.out.println(search(new int[] {1,3}, 3));
	}
	public static int search(int[] nums, int target) {
		return(recursion(nums, 0, nums.length, target));
	}
	public static int recursion(int[] nums, int begin, int end, int target) {
		int first= nums[begin], middle = nums[(begin + end)/2];
		if(target == first)
			return begin;
		else if(target == middle)
			return (begin + end)/2;
		else
			if(end-begin < 3)
				return -1;
        if(first < middle) { //no reset in between first and middle
        	if(target > first && target < middle) { //number is in between first and middle
        		return recursion(nums, begin, (begin + end)/2, target);
        	}
        	else
        		return recursion(nums, (begin + end)/2, end, target);
        }
        else {
        	if(target > first || target < middle) {
        		return recursion(nums, begin, (begin + end)/2, target);
        	}
        	else
        		return recursion(nums, (begin + end)/2, end, target);
        }
	}
}
