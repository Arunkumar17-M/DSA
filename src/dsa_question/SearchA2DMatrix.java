package dsa_question;

public class SearchA2DMatrix {
	
	static boolean bruteforceSolutionByMeSerachMatrix(int[][] matrix, int target) {
		
		int colSize = matrix[0].length;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]<= target && matrix[i][colSize-1]>=target) {
				for(int j = 0; j < colSize; j++) {
					if(matrix[i][j] == target) 
						return true;
				}
				break;
			}
		}
		
		return false;
	}
	
	static boolean optimalSolution(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int low = 0, high = (n*m)-1;
		while(low <= high) {
			int middle = (low+high)/2;
			int row = middle/m;
			int col = middle%m;
			if(matrix[row][col] == target) return true;
			else if(matrix[row][col] < target) low = middle+1;
			else high = middle-1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
		System.out.println(optimalSolution(matrix, 60));
	}
}
