package dsa_question;

public class MaximumSubarray {

	public static void maximumSubarray(int[] arrays) {
		int maxSoFar = arrays[0];
		int currentSum = arrays[0];
		int start = 0, end = 0, s = 0;
		
		for(int i = 1; i < arrays.length; i++) {
			if(arrays[i] > arrays[i]+currentSum) {
				currentSum = arrays[i];
				s = i;
			}
			else {
				currentSum = arrays[i]+currentSum;
			}
			
			if(maxSoFar < currentSum) {
				maxSoFar = currentSum;
				start = s;
				end = i;
			}
		}
		
		System.out.println(maxSoFar+" "+start+" "+end);
	}
	
	public static void main(String[] args) {
	
		int[] array = new int[] {-1, -2, 5, -1, 2};
		maximumSubarray(array);
	}
}
