//Time Complexity-O(nlogn)
//O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=nums1.length-1;
        int m=nums2.length-1;
        if(n<m)
        {
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        int k=0;
        
        while(i<=n &&j<=m)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
            }
            else if(nums2[j]<nums1[i])
            {
                j++;
            }
            else if(nums1[i]==nums2[j]){
                nums1[k]=nums1[i];
                i++;
                j++;
                k++;
            }              
        }
        return Arrays.copyOfRange(nums1,0,k);
                
    }
}