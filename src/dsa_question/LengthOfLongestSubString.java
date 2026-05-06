package dsa_question;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
	
	static int lengthOfLongestSubStringMyApproach(String str) {
		
		if(str.length() == 0) return 0;
		if(str.length() == 1) return 1;
		int maxlength = 0;
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			int count = 0;
			set.clear();
			for(int j = i; j < str.length(); j++) {
				if(set.add(str.charAt(j))){
					count++;
				}
				else break;
			}
			if(maxlength < count) maxlength = count;
		}
		return maxlength;
	}

	public static void main(String[] args) {
		
		String str = "geeksforgeeks";
		System.out.println(lengthOfLongestSubStringMyApproach(str));
		
	}
}
