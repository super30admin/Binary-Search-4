# Binary-Search-4



## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

//Time Complexity : O(nlog(m))
//Space Complexity : O(1)
//Binary search 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        
        if(n1 > n2) return intersect(nums2, nums1); 
        
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        List<Integer> result = new ArrayList<>(); 
        
        int low = 0; 
        int high = n2 - 1; 
        
        for(int i = 0 ; i < n1; i++){
            int curr = nums1[i]; 
            int bIndex = binarySearch(nums2, low, high, curr); 
            if(bIndex != -1){
                result.add(curr); 
                low = bIndex + 1; 
            }
        }
        
        int[] returnThis = new int[result.size()]; 
        
        for(int i = 0; i < result.size(); i++){
            returnThis[i] = result.get(i);
        }
        
        return returnThis; 
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2; 
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1; 
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
        }
        return -1; 
    }
}


//Time Complexity : O(m+n)
//Space Complexity : O(1)
//Two Pointers

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        
        if(n1 > n2) return intersect(nums2, nums1); 
        
        Arrays.sort(nums1); 
        Arrays.sort(nums2); 
        
        List<Integer> result = new ArrayList<>(); 
        
        int low = 0; 
        int high = n2 - 1; 
        
        for(int i = 0 ; i < n1; i++){
            int curr = nums1[i]; 
            int bIndex = binarySearch(nums2, low, high, curr); 
            if(bIndex != -1){
                result.add(curr); 
                low = bIndex + 1; 
            }
        }
        
        int[] returnThis = new int[result.size()]; 
        
        for(int i = 0; i < result.size(); i++){
            returnThis[i] = result.get(i);
        }
        
        return returnThis; 
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2; 
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1; 
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
        }
        return -1; 
    }
}

//Time Complexity : O(m+n)
//Space Complexity : O(n) 
//HashMap Approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        
        if(n1 > n2) return intersect(nums2, nums1); 
        
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>(); 
        
        for(int num : nums2){
            if(map.containsKey(num)){
                result.add(num); 
                map.put(num, map.get(num) - 1); 
                map.remove(num, 0); 
            }
        }
        
        int[] returnThis = new int[result.size()]; 
        
        for(int i = 0 ; i < result.size(); i++){
            returnThis[i] = result.get(i);
        }
        
        return returnThis;
    }
}


## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

//Time Complexity = O(log(m+n))
// Space Complexity = O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); 
        
        int low = 0;
        int high = n1; 
        
        while(low <= high){
            int partX = low + (high-low)/2; 
            int partY = (n1+n2)/2 - partX; 
            
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX]; 
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2) % 2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;  
                }
                else 
                   return Math.min(R1, R2); 
            }else if(L2 > R1){
                low = partX + 1;
            }else{
                high = partX - 1; 
            }
        }
        return 1.00; 
    }
}
