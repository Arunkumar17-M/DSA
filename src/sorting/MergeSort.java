package sorting;

public class MergeSort {

	public static void mergeSort(int[] arr, int low, int high) {
		if(low >= high) return;
		int mid = (low+high)/2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		alternateMergeMethod(arr, low, mid, high);
	}
	
	static void merge(int[] arr, int low, int mid, int high) {
		int temp[] = new int[arr.length];
		int left = low;
		int right = mid+1;
		int index = 0;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right])
				temp[index++] = arr[left++];
			else
				temp[index++] = arr[right++];
		}
		
		while(left <= mid) temp[index++] = arr[left++];
		
		while(right <= high) temp[index++] = arr[right++];
		
		for(int i = low; i <= high; i++) {
			arr[i] = temp[i-low];
		}
	}
	
	public static void alternateMergeMethod(int[] arr, int low, int mid, int high) {
		int n1 = mid-low+1;
		int n2 = high-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i = 0; i < n1; i++) L[i] = arr[low+i];
		for(int i = 0; i < n2; i++) R[i] = arr[mid+1+i];
		
		int left = 0; int right = 0; int k = low;
		while(left < n1 && right < n2) {
			if(L[left] <= R[right]) arr[k++] = L[left++];
			else arr[k++] = R[right++];
		}
		
		while(left < n1) arr[k++] = L[left++];
		while(right < n2) arr[k++] = R[right++];
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3, 1, 2, 4, 1, 5, 6, 2, 4};
		mergeSort(array, 0, array.length-1);
		for(int value : array) {
			System.out.print(value+" ");
		}
	}
}
