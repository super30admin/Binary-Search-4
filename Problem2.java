/**
LeetCode Submitted : YES 
Space Complexity : O(Minimum length of nums1 and nums2)
Time Complexity : O(Num1log(Num1)) + O(Nums2log(Nums2)) + O(Minimum length of nums1 and nums2))

The idea is to sort the arrays and then use 2 pointers to see which values are intersecting. If val1 > val2 then increase second pointer else increase pointer 1. If both are equal increment both the pointers. 

**/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        
        
        
        if(nums1 == null || nums1.length < 1)
            return nums1;
        
        if(nums2 == null || nums2.length < 1)
            return nums2;
        
        //Sorting the Arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                results.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++; 
            }
        }
        
        
        int[] out =  new int[results.size()];
        for(int c = 0; c < out.length;c++)
            out[c] = results.get(c);
        
        return out;
    }
}
