/*
    Time Complexity - O(m + n) where m and n are the length of array nums1 and nums2.
    Space Complexity - O(1)
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) 
            return intersect(nums2, nums1);
        
        int[] arr = new int[1001];
        for(int a: nums1)
            arr[a]++;
        
        int index = 0;
        for(int a: nums2)
            if(arr[a]-- > 0) 
                nums1[index++] = a;
        
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
