package dsa_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {

	public static void bruteForceSolution(int[] num) {
		int size = num.length;
		Set<List<Integer>> solutions = new HashSet<>();
		for(int i = 0; i < size-2; i++) {
			for(int j = i+1; j < size - 1; j++) {
				for(int k = j+1; k < size; k++) {
					if(num[i]+num[j]+num[k] == 0) {
						List<Integer> list = Arrays.asList(num[i], num[j], num[k]);
						Collections.sort(list);
						solutions.add(list);
					}
				}
			}
		}
		
		display(solutions);
	}
	
	static void betterSolution(int[] num) {
		int size = num.length;
		Set<List<Integer>> data = new HashSet<>();
		for(int i = 0; i < size; i++) {
			Set<Integer> set = new HashSet<>();
			for(int j = i+1; j < size; j++) {
				int difference = -(num[i]+num[j]);
				if(set.contains(difference)) {
					List<Integer> list = Arrays.asList(num[i], num[j], difference);
					Collections.sort(list);
					data.add(list);
				}
				else {
					set.add(num[j]);
				}
			}
		}
		
		display(data);
	}
	
	static void optimalSolution(int[] num) {
		int size = num.length;
		Arrays.sort(num);
		List<List<Integer>> data = new ArrayList<>();
		int i = 0;
		while(i < size-2) {
			if(i != 0 && num[i] == num[i-1]) i++;
			else {
				int j = i+1, k = size-1;
				while(j < k) {
					int difference = num[i]+num[j]+num[k];
					if(difference == 0) {
						data.add(Arrays.asList(num[i], num[j], num[k]));
						j++; k--;
						while(num[j] == num[j-1] && j < k) j++;
						while(num[k] == num[k+1] && j < k) k--;
					}
					else if(difference < 0) j++;
					else k--;
				}
			}
		}
		
		display(new HashSet<>(data));
	}
	
	private static void display(Set<List<Integer>> solutions) {
		for(List<Integer> l : solutions) {
			System.out.println(l);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		int[] num = new int[] {-1, 0, 1, 2, -1, -4};
//		int[] num = new int[] {10, -7, 2, -3, 5, -10, 8, -2, 0, 1, -1};
		betterSolution(num);
	}
}
