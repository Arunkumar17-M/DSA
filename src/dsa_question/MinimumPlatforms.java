package dsa_question;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MinimumPlatforms {

	static int findMinimumPlatform(int[] arr, int dep[]) {
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 0, currMax = 0, max = 0, j = 0;
		while(i<arr.length) {
			if(arr[i] <= dep[j]) {
				currMax++;
				i++;
			}
			else {
				currMax--;
				j++;
			}
			max = Math.max(max, currMax);
		}
		return max;
	}
	
	static int findMaximumPlatformUsingMap(int[][] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < nums.length; i++) {
			int arrival = nums[i][0];
			int dep = nums[i][1];
			map.put(arrival, map.getOrDefault(arrival, 0)+1);
			map.put(dep, map.getOrDefault(dep, 0)-1);
		}
		
		int platformNeeded = 0, maxPlatform = 0;
		for(int timing : map.keySet()) {
			platformNeeded += map.get(timing);
			maxPlatform = Math.max(maxPlatform, platformNeeded);
		}
		return maxPlatform;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {900, 940, 950, 1100, 1500, 1800};
		int[] dep = new int[] {910, 1200, 1120, 1130, 1900, 2000};
		
		int[][] nums = new int[][] {{600,700},{630,820},{1200,1500}};
		
//		System.out.println(findMinimumPlatform(arr, dep));
		System.out.println(findMaximumPlatformUsingMap(nums));
	}
}
