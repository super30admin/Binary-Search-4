# Binary Search - 4


Problem1
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
// Time Complexity : O(m+n)
// Space Complexity : O(n) // for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// method: Hashmap: traverse thorugh array of shorted size and add all elements to Hmap with count.  Now, traverse through second array and check if that value 
// exists in first array.  If exist decrement count by 1.  
class Solution {
public int[] intersect(int[] nums1, int[] nums2) {
    int n1=nums1.length;
    int n2=nums2.length;
    if(n1>n2) return intersect(nums1, nums2);
    HashMap<Integers> hmap = new HashMap<>();
    for(int i=0;i<nums1.length;i++){
        if(hmap.isContains)
        }
    }
}


Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)
// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
// method: 2 pointers: merge both the arays and return median
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0;
        int nums3[] = new int[nums1.length+nums2.length];
        while(i < nums1.length && j < nums2.length){
            if(nums1[i]<nums2[j]){
                nums3[k++]=nums1[i]; i++;
            }
            else{
                nums3[k++]=nums2[j];j++;
            }
        }
        while(i<nums1.length){
            nums3[k++]=nums1[i];i++;
        }
        while(j<nums2.length){
            nums3[k++]=nums2[j];j++;
        }
        if((nums3.length) % 2==0){
            int middle=(nums3.length-1) / 2;
            int sum=nums3[middle]+nums3[middle+1];
            return (float) sum/2;
        }
        else{
            int middle=(nums3.length-1) / 2;
            return (float) nums3[middle];
        }
    }
}