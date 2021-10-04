// Time Complexity : O(n + m)
// Space Complexity : O(min(n,m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class intersectionTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        //take smaller of the two arrays
        if(nums2.length > nums1.length) 
            return intersect (nums2, nums1);
        
        //Store number and its frequency in a Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //iterate over nums1 and add to the map and increase freq. by 1 for each occurence
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }
        
        int k = 0; //range in which overlap exists
        
        //iterate over nums2 and add to the map and decrease freq. by 1 for each occurence
        for(int i = 0; i < nums2.length; i++){
            int count = map.getOrDefault(nums2[i],0);
            if(count > 0){
                nums1[k++] = nums2[i];
                map.put(nums2[i], count-1);
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
