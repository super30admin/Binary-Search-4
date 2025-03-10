import java.util.*;

public class Intersection {

    // Time Complexity: O(m+n) where m is the length of nums1 and n is the length of nums2
    // Space Complexity: O(min(m,n)) where m is the length of nums1 and n is the length of nums2
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return intersectHashMap(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < m; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for(int i = 0; i < n; i++){
            if(map.containsKey(nums2[i])){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);

                if(map.get(nums2[i]) == 0){
                    map.remove(nums2[i]);
                }
            }
        }


        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }

    // Time Complexity: O(m + n) where m is the length of nums1 and n is the length of nums2. given two arrays are sorted.
    // Space Complexity: O(1) where m is the length of nums1 and n is the length of nums2
    public int[] intersectTwoPointer(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return intersectTwoPointer(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }

        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }

    // Time Complexity: O(m log(n))
    // Space Complexity: O(1)
    public int[] intersectBinarySearch(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return null;
        }

        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return intersectBinarySearch(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = nums2.length-1;
        for(int i = 0; i < m; i++){
            int target = nums1[i];
            int idx = binarySearchIdx(target, nums2, low, high);

            if(idx != -1){
                result.add(target);
                low = idx+1;
            }
        }


        int[] res = new int[result.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }

    private int binarySearchIdx(int target, int[] nums, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                // check if it is the leftmost
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }

            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
