package dsa_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
	
	public boolean carPooling(List<List<Integer>> trips, int capacity) {
		
		Map<Integer, Integer> changes = new TreeMap<>();
		for(List<Integer> trip: trips) {
			int passagers = trip.get(0);
			int start = trip.get(1);
			int end = trip.get(2);
			
			changes.put(start, changes.getOrDefault(start, 0)+passagers);
			changes.put(end, changes.getOrDefault(end, 0)-passagers);
		}
		
		int current = 0;
		for(int location : changes.keySet()) {
			current +=changes.get(location);
			if(current > capacity) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		CarPooling cp = new CarPooling();
		
		List<List<Integer>> trips = new ArrayList<>();
		trips.add(Arrays.asList(2, 1, 5));
		trips.add(Arrays.asList(3, 5, 7));
		trips.add(Arrays.asList(4, 7, 6));
		System.out.println(cp.carPooling(trips, 5));
	}
}
