package recursions;

public class RecurionProblem {

	public static void reverseArray(int[] array, int n) {
		if(n <= 1) return;
		
		int temp = array[0];
		array[0] = array[n-1];
		array[n-1] = temp;
		
		int[] subarray = new int[n-2];
		for(int i = 0; i< n-2; i++) {
			subarray[i]= array[i+1];
		}
		
		reverseArray(subarray, n-2);
		
		for(int i = 0; i < subarray.length; i++) {
			array[i+1] = subarray[i];
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
        int size = arr.length;

        reverseArray(arr, size);

        for (int num : arr) {
            System.out.print(num + " ");
        }
	}
}
