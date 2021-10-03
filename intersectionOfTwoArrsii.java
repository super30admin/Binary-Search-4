// Time Complexity : O(m + n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// time = O(m+n)
// space = O(m)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        // null
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0) +1);
        }
        for(int num: nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num, 0);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0; i< result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
        
    }
}

// *************************************

// Time Complexity : O(m + n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// two pointer soln
// NO EXTRA SPACE!

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        // null
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Arrays.sort(nums1); Arrays.sort(nums2);
        int p1 = 0; int p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++; p2++;
            } else if(nums1[p1] < nums2[p2]){
                p1++;
            } else{
                p2++;
            }
        }
        
        int[] arr = new int[result.size()];
        for(int i=0; i< result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
        
    }
}

// *************************************

// Time Complexity : O(m log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Modified Binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        // null
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Arrays.sort(nums1); Arrays.sort(nums2);
        
        int low=0; int high = nums2.length - 1;
        for(int i=0; i< nums1.length; i++){
            int bIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bIndex != -1){
                result.add(nums1[i]);
                low = bIndex + 1;
            }
        }
        
        int[] arr = new int[result.size()];
        for(int i=0; i< result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
        
    }
    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid==low || arr[mid] > arr[mid-1]){
                    return mid;
                } else{
                    high = mid - 1;
                }
            } else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
