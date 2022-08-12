//Time Complexity: O(m*log(m)) + O(n*log(n)) + O(m*log(n)); where m is the length of nums1 & n is the length of nums2.
//Space Complexity: O(i); where i is the no. of elements in the intersection.
//Code run successfully on LeetCode.

public class Problem1_3 {

public int[] intersect(int[] nums1, int[] nums2){
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> result = new ArrayList<>();
        int low = 0;
        
        for(int i =0; i < n1; i++){
            
            int bIndex = binarySearch(nums2, low, n2 , nums1[i]);
            if(bIndex != -1){
             result.add(nums1[i]);
             low = bIndex + 1;    
            }
        }
        
        int n = result.size();
        int[] res = new int[n];
        
        for(int i =0; i<n; i++)
            res[i] = result.get(i);
        
        return res;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target){
        int mid = 0;
        while(low < high){
            
            mid = low + (high-low)/2;
            
            if(nums[mid] == target)
            {
                
                if(mid == low || nums[mid - 1] < nums[mid])
                    return mid;
         
                else
                    high = mid;
            }
            
            else if(nums[mid] < target)
                low = mid +1;
            
            else
                high = mid;
        }
        
        return -1;
    }
}
