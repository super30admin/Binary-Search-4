import java.util.*;
/********************************************Brute Force*************************************/
//Time Complexity :O(n * m), n and m are size of given two arrays
//Space Complexity :O(n), intersected elements are stored in a list
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[0];

		if(nums1.length > nums2.length) 
			return intersect(nums2,nums1);
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums2.length; i++){
			for(int j = 0; j < nums1.length; j++){
				if(nums2[i] == nums1[j]){
					list.add(nums2[i]);
					nums1[j]--;
					break;
				}
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0 ; i < list.size() ; i++){
			res[i] = list.get(i);
		}
		return res;
	}
}
/********************************************Using HashMap*************************************/
//Time Complexity :O(n + m), n and m are size of given two arrays
//Space Complexity :O(n), first array is stored in hashmap with its frequency
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Hashmap, store all the elements with the key and the frequency of numbers
 * Once the number of occurrences hits zero while traversing through the second array, remove it from the hash map
 * all intersected elements will be in a stored in a list then*/

class Intersection_of_Two_Arrays_II_map {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[0];

		List<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num : nums1)
			map.put(num, map.getOrDefault(num, 0) + 1);

		for(int num : nums2){
			if(map.containsKey(num)){
				list.add(num);
				map.put(num, map.get(num) - 1);
				map.remove(num, 0);
			}
		}
		int result[] = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			result[i] = list.get(i);

		return result;
	}
}

/********************************************Using Two Pointer Approach*************************************/
//Time Complexity :O(n + m), n and m are size of given two arrays
//Space Complexity :O(n), intersected elements are stored in a list
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Two Pointer Approach, pointing at start of each array
 * if elements are same at both the pointers, add to the list and increment both the pointers
 * else increment the pointer of array element smaller than the other */

class Intersection_of_Two_Arrays_II_2Pointer {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[0];

		int p1 = 0, p2 = 0; // pointer on nums1 and nums2
		List<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		while(p1 < nums1.length && p2 < nums2.length){  // till one of the array finishes
			if(nums1[p1] == nums2[p2]){ // if we found a intersection, add to result and increment both pointers
				result.add(nums1[p1]);
				p1++;
				p2++;
			}
			else if(nums1[p1] < nums2[p2])  // if value in nums1 is less then value at nums2, increase pointer1, else pointer2
				p1++;
			else
				p2++;
		}
		int array[] = new int[result.size()];
		for(int i=0; i<result.size(); i++)
			array[i] = result.get(i);

		return array;
	}
}

/********************************************Using Binary Search*************************************/
//Time Complexity :O(n + log m), m is size of smaller array and n is size of larger array
//Space Complexity :O(n), intersected elements are stored in a list
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Binary Search,
 * First Sort the two lists given, for each element in the smaller array, binary search on the bigger array to get the occurrence of the first occurrence of the element
 * once we find an element in the second array we start our binary search from the element next to the one found within the second array */

class Intersection_of_Two_Arrays_II_2Pointer_BS {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[0];

		if (nums1.length > nums2.length)
			return intersect(nums2, nums1); // nums1 should be smaller one
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		int index = 0;  //starting low index of second array
		for(int i=0; i<nums1.length; i++){  //O(n)
			int bsIndex = binarySearch(nums2, index, nums2.length-1, nums1[i]);     //O(logm)
			if(bsIndex != -1){
				list.add(nums1[i]);
				index = bsIndex+1;
			}
		}
		int result[] = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			result[i] = list.get(i);

		return result;
	}
	private int binarySearch(int[] arr, int low, int high, int target){
		while(low <= high){
			int mid = low + (high-low)/2;
			if(arr[mid] == target){
				if(mid == low || arr[mid] > arr[mid-1])
					return mid;
				else
					high = mid-1;
			}
			else if(arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}
}