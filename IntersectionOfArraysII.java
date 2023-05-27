import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Leetcode - 350
//Time Complexity - O(MlogN) M is low size array
//Space Complexity - O(1) - binary search
public class IntersectionOfArraysII {

    //ExtraSpace - O(max(m,n)), time - O(m+n)
    /*public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length; int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for (int j : nums1) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j)) {
                li.add(j);
                int count = map.get(j) - 1;
                map.put(j, count);
                map.remove(j, 0);
            }
        }

        int[] result = new int[li.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = li.get(i);
        }
        return result;
    }*/

    // using 2 pointers (and Sorting the array, assuming given sorted arrays)
   /* public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length; int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int p1=0; int p2=0;
        while(p1 <m && p2 <n) {
            if(nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        int[] result = new int[li.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = li.get(i);
        }
        return result;
    }*/

    //BinarySearch
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length; int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int low=0, high = n-1;
        for(int i=0; i<m; i++) {
            int bsIdx = binarySearch(nums2, low, high, nums1[i]);
            if(bsIdx != -1) {
                li.add(nums1[i]);
                low = bsIdx+1;
            }
        }
        int result[] = new int[li.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                if(mid > low && arr[mid] == arr[mid-1]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
