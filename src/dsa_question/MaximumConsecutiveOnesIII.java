package dsa_question;

public class MaximumConsecutiveOnesIII {
	
	public static int maximumConsecutiveOn2(int[] array, int k) {
		
		int maxlen = 0;
		for(int i = 0; i < array.length; i++) {
			int j = i, zeros = 0;
			for(; j < array.length; j++) {
				if(array[j]==0) zeros++;
				if(zeros > k) break;
			}
			maxlen = Math.max(maxlen, j-i);
		}
		
		return maxlen;
	}
	
	public static int usingTwoPointerOn2(int[] array, int k) {
		int left = 0, right = 0, maxlen = 0, zeros = 0;
		while(right < array.length) {
			if(array[right] == 0) zeros++;
			while(zeros > k) {
				if(array[left] == 0) zeros--;
				left++;
			}
			if(zeros <= k) {
				maxlen = Math.max(maxlen, right-left+1);
			}
			right++;
		}
		
		return maxlen;
	}
	
	public static int usingTwopointerOn(int[] array, int k) {
		
		int left = 0, right = 0, maxlen = 0, zeros = 0;
		while(right < array.length) {
			if(array[right] == 0) zeros++;
			if(zeros > k) {
				if(array[left] == 0) zeros--;
				left++;
			}
			if(zeros <= k) {
				maxlen = Math.max(maxlen,  right-left+1);
			}
			
			right++;
		}
		
		return maxlen;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println(usingTwopointerOn(array, 2));
	}
}
