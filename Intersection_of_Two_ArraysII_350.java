
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Intersection_of_Two_ArraysII_350 {
	// Binary Search appraoch
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||nums2 == null || nums2.length == 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int retIndex = -1;
        List<Integer> l = new ArrayList<>();
        if(nums1.length > nums2.length)
            intersect(nums2, nums1);
        for(int num : nums1){
            retIndex = binarySearch(nums2, num, index, nums2.length-1);
            if(retIndex != -1) {
                l.add(num);
                index = retIndex+1;
            }
        }
        int[] result = new int[l.size()];
        for(int i = 0; i < l.size(); i++)
            result[i] = l.get(i);
        return result;
    }
    private int binarySearch(int[] nums, int num, int l, int r){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == num){
                if(mid == l || nums[mid] > nums[mid-1])
                    return mid;
                else
                    r = mid - 1;
            } else if(nums[mid] < num){
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return -1;
    }

// HashMap appraoch
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if(nums1 == null || nums1.length == 0 ||nums2 == null || nums2.length == 0)
//            return new int[0];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        if(nums1.length > nums2.length)
//            intersect(nums2, nums1);
//        List<Integer> l = new ArrayList<>();
//        for(int num : nums1)
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        for(int num : nums2){
//            if(map.containsKey(num)){
//                l.add(num);
//                map.put(num, map.get(num) - 1);
//                map.remove(num, 0);
//            }
//        }
//        int[] result = new int[l.size()];
//        for(int i = 0; i < l.size(); i++)
//            result[i] = l.get(i);
//        return result;
//    }
    public static void main(String[] args)
    {
    	Intersection_of_Two_ArraysII_350 obj = new Intersection_of_Two_ArraysII_350();
    	int[] nums1 = {3,4,5};
    	int[] nums2 = {1,9,6,3,4,5,3,4};
    	int[] nums = obj.intersect(nums1, nums2);
    	for(int num : nums)
    		System.out.println(num);
    }
}
