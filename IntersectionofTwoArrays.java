

// Time Complexity : O(m) where m is smaller of the two arrays
// Space Complexity : O(m) size of the HashMap

public class IntersectionofTwoArrays {
	public static int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
         ArrayList<Integer> result = new ArrayList<>();
        if(n1 > n2) return intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num1: nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        
        for(int num: nums2) {
            if(map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] arr = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
