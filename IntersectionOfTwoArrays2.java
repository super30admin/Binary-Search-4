// Time Complexity : O(mlogn) , m is length of smaller array, n is length of larger array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each element in the smaller array, find that element in the larger array using Binary Search. To avoid problems caused due to duplicate elements in one array, find the first occurence of the element from the larger array, and perform the next search from this index.

public class IntersectionOfTwoArrays2 {
    
    // Solution 1 : Binary Search Approach   
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        if(nums1 == null || nums2 == null) return new int[0];
        
        if(nums1.length > nums2.length ) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low = 0;
        for(int i = 0 ; i < nums1.length; i++){
            int index = binarySearch(nums2, nums1[i] , low, nums2.length - 1);

            if( index != -1){
                res.add(nums1[i]);
                low = index + 1;
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0 ; i < res.size(); i++){
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    private int binarySearch( int[] nums2, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums2[mid] == target){
                if(mid - 1 >= 0 && mid - 1 >= low && nums2[mid] == nums2[mid - 1]){
                    high = mid - 1;
                } else{
                    return mid;
                }
            } else if(nums2[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }

    // Solution 2 : Two pointer Approach   
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     List<Integer> res = new ArrayList<>();

    //     if(nums1 == null || nums2 == null) return new int[0];
        
    //     if(nums1.length > nums2.length ) return intersect(nums2, nums1);
        
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
        
    //     int p1 = 0;
    //     int p2 = 0;
        
    //     while(p1 < nums1.length && p2 < nums2.length){
    //         if(nums1[p1] == nums2[p2]){
    //             res.add(nums1[p1]);
    //             p1 = p1 + 1;
    //             p2 = p2 + 1;
    //         } else if(nums1[p1] < nums2[p2]){
    //             p1 = p1 + 1;
    //         } else {
    //             p2 = p2 + 1;
    //         }
    //     }
        
    //     int[] result = new int[res.size()];
        
    //     for(int i = 0; i < res.size(); i++){
    //         result[i] = res.get(i);
    //     }
        
    //     return result;
    // }
}
