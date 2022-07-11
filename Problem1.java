// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//350. Intersection of Two Arrays II
//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    //BINARY SEARCH
    //time:O(mlogn)
    //space:O(1)
    
    int index = -1;
    int mid = -1;
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int m = nums1.length;
        int n = nums2.length;
        
        
        List<Integer> result = new ArrayList<>();
        int p1 = 0;
        
        if(m<=n){
            int low = 0; int high = n-1;
        for(int i=0; i<m; i++){
            index = binarySearch(nums1[i], nums2, low, high); //System.out.println("index  " + index);
            if(index != -1){
                result.add(nums1[i]);
                low = index+1;
            }
        }
        }else{
            int low = 0; int high = m-1;
            for(int i=0; i<n; i++){
               index = binarySearch(nums2[i], nums1, low, high);
               if(index != -1){
                    result.add(nums2[i]);
                   low = index+1;
               }
           } 
        }
        
        int[] res = new int[result.size()];
        for(int j = 0; j < result.size(); j++){
            res[j] = result.get(j);
        }
        
        return res;
    }
    
    private int binarySearch(int target, int[] nums, int low, int high){
        
        
        while(low<=high){
            mid = low + (high-low)/2; 
            if(target==nums[mid]){
                
                while(low < mid && mid > 0 && nums[mid-1] == nums[mid]){
                    mid = mid-1; 
                } 
                
                return mid;
                
            }else if(target>nums[mid]){
                low = mid +1;
            }else if(target<nums[mid]){
                high = mid-1;
            } 
        } 
        return -1;
    }
}



/*
class Solution {
    //TWO POINTER SOLUTION
    //time: O(m+n)
    //space:O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int m = nums1.length;
        int n = nums2.length;
        
        int p1 = 0;
        int p2 = 0;
        
        List<Integer> result = new ArrayList<>();
        
        while(p1<m && p2<n){
            if(nums1[p1]<nums2[p2]){
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                p2++;
            }else if(nums1[p1]==nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        //System.out.println(p1); System.out.println(p2);
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        
        return res;
        
    }
}
*/