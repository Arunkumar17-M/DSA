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
	
	public static boolean checkStringPalindrome(String str, int start, int size) {
		if(start >= size/2) return true;
		if(str.charAt(start) != str.charAt(size-start-1)) return false;
		return checkStringPalindrome(str, start+1, size);
	}
	
	public static int fibonacci(int n) {
		if(n <= 1) return n;
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int size = arr.length;

        reverseArray(arr, size);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        String str = "malayalam";
        System.out.println("\nIs it Palindrome: "+ checkStringPalindrome(str, 0, str.length()));
        
        System.out.println("Fibonacci: "+ fibonacci(7));
	}
}
