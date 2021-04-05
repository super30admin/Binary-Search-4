class Solution {// time is O(m log m + n log n ) space of O(total no of intersecting elements )
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // Create an arraylist
        int idx1 = 0 , idx2 = 0 , idx3 = 0;
        while(idx1< nums1.length && idx2 < nums2.length){
            if(nums1[idx1]< nums2[idx2]){
                idx1++;
            }else if(nums1[idx1] > nums2[idx2]){
                idx2++ ;
            }else{
                nums1[idx3++] = nums1[idx1++];
                idx2++;
            }
        }
        return Arrays.copyOfRange(nums1,0,idx3) ;
    }
}