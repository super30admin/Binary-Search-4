//given that the arrays are already sorted. Use 2 pointers to go through both arrays and compare elements. If equal, then add to result.
//Time complexity: O(m+n)
//Space complexity: O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j]) j++;
            else i++;
        }
        int []result = new int[ans.size()] ;
        for(int k = 0 ; k< ans.size(); k++){
             result[k] = ans.get(k);
         }

         return result;
    }
}
    