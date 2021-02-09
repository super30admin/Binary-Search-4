// binary search soln. 
// Time Complexity : O(n1logn2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low = 0;
        for(int i = 0; i < n1; i++){
            int bsIndex = binarySearch(nums2, nums1[i], low , n2-1);
            if(bsIndex != -1){
                li.add(nums1[i]);
                low = bsIndex + 1;
            }
            
        }
            
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = li.get(i);
        
        return result;
    }
    private int binarySearch(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}

// HashMap soln. O(n1+n2) time and O(min(n1, n2)) space
/*
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
                li.add(num);
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = li.get(i);
        
        return result;
    }
}
*/
// two pointer soln. O(n2logn2) time and O(n1) space used for sorting
/*
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int p1 = 0; int p2 = 0;
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]);
                p1++; p2++;
            }
            else if(nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = li.get(i);
        
        return result;
    }
}
*/