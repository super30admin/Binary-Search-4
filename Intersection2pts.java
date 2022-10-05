class Solution {
    //tc - m+n
    //sc-o(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length < nums2.length) return intersect(nums2,nums1);

        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        int i=0; int j=0;
         while(i<m && j<n)
         {
             if(nums1[i] == nums2[j])
             {
                 li.add(nums1[i]);
                 i++;
                 j++;
             }
             else
             {
                 if(nums1[i] < nums2[j])
                 {
                     i++;
                 }
                 else{j++;}
             }

         }
         int[] result = new int[li.size()];
         for(int k=0;k<result.length;k++)
         {
             result[k] = li.get(k);
         }
          return result;
    }
}