// Basic Two Pointer solution. Not optimal.


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        int [] result = new int[9999];
        if(nums1.length==0)
            return nums1;
        if(nums2.length==0)
            return nums2;
        //Sort both the arrays. 
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){	//  Run the while loop to compare elements and move the pointers forward.
            if(nums1[i]<nums2[j] )
                i++;
            else if(nums2[j]<nums1[i])
                j++;
            else if(nums1[i]==nums2[j]){
                result[k++]=nums1[i];
                i++;            
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, k); // Return Result from range 0 to K as only K elments are part of the intersection.
    }
}