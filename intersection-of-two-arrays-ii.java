// Time Complexity :
O(nlogn + mlogm) n and m are lengths of the arrays. we sort the arrays and then we traverse through both the arrays
// Space Complexity :

// Did this code successfully run on Leetcode :
yes
// Three line explanation of solution in plain english
Maintain 2 pointers to iterate through nums1 and nums2
Increment i if nums1[i] is smaller. [Doing this to reach to a point until both the elements at i,j are same]
Increment j if nums2[j] is smaller.
When both elements are same we add to the result and increment all the pointers
// Your code here along with comments explaining your approach


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int i=0;
        int j=0;
        int k=0;
        //Sort the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                nums1[k++]=nums1[i++];
                j++;
            }
        }
        
        return Arrays.copyOfRange(nums1,0,k);
        
    }
}