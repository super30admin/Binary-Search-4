//Time complexity: O(m log n)
//Space complexity: O(1)
import java.util.*;

class intersectBinary {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.length == 0)
            return nums1;
        
        if(nums2 == null || nums2.length == 0)
            return nums2;
        
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
                
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        int lo = 0, hi = n2 - 1;
        
        for(int i = 0; i < n1; i++){
            int bsindex = binarySearch(nums2, nums1[i], lo, hi);
            
            if(bsindex != -1){
                list.add(nums1[i]);
                lo = bsindex + 1;
            }
                
        }
            
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private int binarySearch(int[] nums, int target, int lo, int hi){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            //equal
            if(nums[mid] == target){
                //leftmost target
                if(mid == lo || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else
                    hi = mid-1;
            }
            
            //less than target
            else if(nums[mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return -1;
    }
}