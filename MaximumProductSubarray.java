package home;
import java.util.ArrayList;
//https://leetcode.com/problems/maximum-product-subarray/
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
	       ArrayList<Integer> current = new ArrayList<Integer>();
	        int max = Integer.MIN_VALUE, teste;
	        int[] test;
	        if(nums.length == 1)
	            return nums[0];
	        //we can split every array into subarrays inbetween zeros since anything times zero is zero
	        //consider every subarray to the left of a zero or to the left of the end and find the
	        //maximum product of that subarray, find the maximum of those maximum products
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] == 0) {
	            	test = current.stream().mapToInt(j -> j).toArray();
	                if(test.length>0) {
		            	teste = maxArray(test);
		                if(teste>max)
		                    max = teste;
		                if(0 > max)
		                	max = 0;
		                current.clear();
	                }
	            }
	            else if(i == nums.length-1){
	            	current.add(nums[i]);
	            	test = current.stream().mapToInt(j -> j).toArray();
	                teste = maxArray(test);
	                if(teste>max)
	                    max = teste;
	            }
	            else
	                current.add(nums[i]);
	        }
	        return max;
	    }
	    public static int maxArray(int[] nums){
	    	//if the number of negatives is even, the final result of all the products will be even
	    	//if the number of negatives is odd, the greatest result can be found by either excluding
	    	//the first negative and everything to its left of the last negative and everything to its 
	    	//right, since every entry is an integer that's absolute value is greater than or equal to 1
	        if(nums.length == 1)
	            return nums[0];
	        int firstNeg = 0, lastNeg = 0, totalNeg = 0, right = 1, left =1, totalProd = 1;
	        for(int i = 0; i < nums.length; i++){
	            totalProd *= nums[i];
	            if(nums[i] < 0){
	                totalNeg++;
	                if(totalNeg == 1)
	                    firstNeg = i;
	            }
	        }
	        for(int i = nums.length-1; i>= 0; i--){
	            if(nums[i] < 0){
	                lastNeg = i;
	                break;
	            }
	        }
	        if(totalNeg % 2 == 0){
	            return totalProd;
	        }
	        else{
	            for(int i = firstNeg+1; i < nums.length; i++)
	                right *= nums[i];
	            for(int i = 0; i < lastNeg; i++)
	                left *= nums[i];
	            if(right > left)
	                return right;
	            else
	                return left;
	        }
	    }
}
