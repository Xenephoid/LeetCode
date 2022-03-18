package home;
import java.util.ArrayList;
import java.lang.Math;
/* https://leetcode.com/problems/container-with-most-water/
 * We will only take into account heights that are higher than the previous max height because in order for the area 
 * of a container to increase, it must either increase in height or length, later values in the array will have
 * a lower length since the length will be i - index of left wall
 * make two arraylists, which contain the heights of importance and the indices for said heights, and calculate 
 * the area of the container made with the height of the current iteration and the heights of importance, and if
 * there is a bigger area that the current max area then it will update
 */
public class BiggestContainer {
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	public static int maxArea(int[] height) {
        ArrayList<Integer> peaks = new ArrayList<Integer>();
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int maxVol = Integer.MIN_VALUE, currentVol, maxHeight = maxVol;
        for(int i = 0; i < height.length; i++){
            if(height[i] > maxHeight){
                peaks.add(height[i]);
                indices.add(i);
                maxHeight = height[i];
            }
            for(int j = 0; j < peaks.size(); j++){
                currentVol = Math.min(peaks.get(j),height[i]) * (i-indices.get(j));
                if(currentVol > maxVol)
                    maxVol = currentVol;
            }
        }
        return maxVol;
    }
}
