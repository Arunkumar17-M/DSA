package sorting;

public class Sort {
	
	public static void selectionSort(int[] nums) {
		int size = nums.length;
		for(int i = 0; i < size-1; i++) {
			int position = i;
			for(int j = i+1; j < size; j++) {
				if(nums[position] > nums[j]) position = j;
			}
			if(i != position) {
				int temp = nums[i];
				nums[i] = nums[position];
				nums[position] = temp;
			}
		}
	}
	
	// put the biggest element at the last by swapping
	public static void bubbleSort(int[] nums) {
		int size = nums.length;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size-i-1; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
	
	// insertion sort which means we need to take element that we need to shift from right to left
	public static void insertionSort(int[] nums) {
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1]= temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] num = new int[] {13, 46, 24, 52, 20, 9};
		insertionSort(num);
		for(int i : num) {
			System.out.print(i+" ");
		}
	}
}
