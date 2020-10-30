/*
TC : O(n log n + m log m), to sort both arrays, then do 1 pass to add common elements to nums1[]
SC : O(n+m), for sorting the arrays

Approach:
Sort both arrays, maintain two pointers and check if elements at the indexes are same, else move pointers
write back to nums1[] to return int[] for this we maintain variable k
*/ 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return this.intersect(nums2, nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0,j=0,k=0;
        
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, k);
    }
}