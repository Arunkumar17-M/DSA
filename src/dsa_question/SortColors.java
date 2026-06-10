package dsa_question;

public class SortColors {

	public static void betterApproch(int[] nums) {
		int count0 = 0, count1 = 0, count2 = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) count0++;
			else if(nums[i] == 1) count1++;
			else count2++;
		}
		
		for(int i = 0; i < count0; i++) nums[i] = 0;
		for(int i = count0; i < count0+count1; i++) nums[i] = 1;
		for(int i = count0+count1 ; i < nums.length; i++) nums[i] = 2;
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
	
	public static void sortColors(int[] nums) {
		int size = nums.length;
		int low = 0, mid = 0, high = size - 1;
		while(mid <= high) {
			int temp = nums[mid];
			if(temp == 0) {
				nums[mid++] = nums[low];
				nums[low++] = temp;
			}
			else if(temp == 1) {
				mid++;
			}
			else if(temp == 2) {
				nums[mid] = nums[high];
				nums[high--] = temp;
			}
		}
		
		for(int i = 0; i < size; i++) {
			System.out.print(nums[i]);
		}
	}
	
	public static void main(String[] args) {
//		betterApproch(new int[] {2,0,1});
		sortColors(new int[] {2,0,1});//new int[] {2,0,2,1,1,0});
	}
}
