/**
 * Using HashMap

class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> myMap = new HashMap<>();
        List<Integer> myList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;

        if(m>n){
            return intersect(nums2, nums1);
        }

        for(int i=0; i<nums1.length; i++){
            if(myMap.containsKey(nums1[i])){
                myMap.put(nums1[i], myMap.get(nums1[i])+1);
            }
            else
            {
                myMap.put(nums1[i], 1);
            }
        }

        for(int i=0; i<nums2.length; i++){
            if(myMap.containsKey(nums2[i])){
                myList.add(nums2[i]);
                myMap.put(nums2[i], myMap.get(nums2[i])-1);
                myMap.remove(nums2[i], 0);
            }
        }

        int[] res = new int[myList.size()];
        for(int i=0; i<myList.size(); i++){
            res[i] = myList.get(i);
        }
        return res;
    }
}

/**
 * Two Pointer
 * 
 * class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> myList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m>n){
            return intersect(nums2, nums1);
        }

        int p1=0; 
        int p2=0;

        while(p1<m && p2<n){
            if(nums1[p1] == nums2[p2]){
                myList.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        int[] res = new int[myList.size()];
        for(int i=0; i<myList.size(); i++){
            res[i] = myList.get(i);
        }
        return res;
    }
}
 * 
 */

//BinarySearch
/*
 * Reduce the Search Space.
 * First Occurance
 */


class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> myList = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        if (m < n) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = n - 1;

        for (int num : nums1) {
            int bsIdx = binarySearch(nums2, num, low, high);
            if (bsIdx != -1) {
                myList.add(num);
                low = bsIdx + 1;
            }
        }

        int[] res = new int[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            res[i] = myList.get(i);
        }
        return res;
    }

    private int binarySearch(int[] nums, int num, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == num) {
                if (mid == low || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else
                    high = mid - 1;
            } else if (nums[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}