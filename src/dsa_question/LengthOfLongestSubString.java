package dsa_question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	
	public static int lengthOfLongestSubstring(String str) {
		int left = 0, right = 0;
		int maxLen = 0;
		Set<Character> set = new HashSet<>();
		while(right < str.length()) {
			if(set.add(str.charAt(right))) {
				maxLen = Math.max(maxLen, right - left +1);
				right++;
			}
			else {
				set.remove(str.charAt(left));
				left++;
			}
		}
		return maxLen;
	}
	
	public static void lengthOfSubstringUsingMap(String str) {
		int maxlen = 0, left = 0, right = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(right < str.length()) {
			char ch = str.charAt(right);
			if(map.get(ch) == null || left > map.get(ch)) {
				map.put(ch, right);
				maxlen = Math.max(maxlen, right-left+1);
			} else {
				left = map.get(ch)+1;
				map.put(ch, right);
			}
			right++;
		}
		
		System.out.println(maxlen);
	}

	public static void main(String[] args) {
		
		String str = "cadbzabcd";
//		System.out.println(lengthOfLongestSubStringMyApproach(str));
//		System.out.println(lengthOfLongestSubstring(str));
		lengthOfSubstringUsingMap(str);
	}
}
