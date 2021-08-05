// Using HashMap

// Time Complexity: O(m+n)
// Space Complexity: O(max(m,n))
// Run on leetcode: yes
// Issues faced: None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int n: nums2){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int i: nums1){
            if(map.containsKey(i)){
                res.add(i);
                int n = map.get(i);
                n = n-1;
                if(n == 0)
                    map.remove(i);
                else
                    map.put(i, n);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}

// Using Two Pointers

// Time Complexity: O(mlogm + nlogn + min(m,n))
// Space Complexity: O(1)
// Run on Leetcode: yes
// Issues faced: None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pointer1 = 0;
        int pointer2 = 0;
        List<Integer> res = new ArrayList<>();
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if(nums1[pointer1] == nums2[pointer2]){
                res.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
            else if(nums1[pointer1] < nums2[pointer2]){
                pointer1++;
            }
            else{
                pointer2++;
            }
        }
        
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        
        return result;
    }
}

// Using Binary Search

// Time Complexity: O(mlogm + nlogn + mlogn)
// Space Complexity: O(1)
// Run on Leetcode: Yes
// Issues Faces: None

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = nums2.length-1;
        for(int i=0; i<nums1.length; i++){
            int ans = binarySearch(nums2, nums1[i], low, high);
            if(ans != -1){
                res.add(nums1[i]);
                low = ans + 1;
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    
    private int binarySearch(int[] nums2, int x, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums2[mid] == x){
                if(mid == low || nums2[mid-1] < nums2[mid])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(nums2[mid] > x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
