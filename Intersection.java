// the time complexity of this implementation is O(n)
import java.util.*;

class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // create a hashmap to store counts of elements in nums1
        List<Integer> list = new ArrayList<>(); // create a list to store the common elements between nums1 and nums2

        // fill the hashmap with counts of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // iterate through nums2 and check if the element is present in the hashmap
        // if present, decrement the count of the element in the hashmap and add it to the list
        for (int num : nums2) {
            if (map.containsKey(num)) {
                int count = map.get(num);
                if (count > 0) {
                    list.add(num);
                    map.put(num, count - 1);
                }
            }
        }

        int[] result = new int[list.size()]; // create an array to store the result
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Intersection solution = new Intersection();
        int[] result = solution.intersect(nums1, nums2);
        System.out.println("The intersection of the two arrays is: " + Arrays.toString(result)); // The intersection of the two arrays is: [2, 2]
    }

}
